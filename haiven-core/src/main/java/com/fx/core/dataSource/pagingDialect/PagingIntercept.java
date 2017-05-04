package com.fx.core.dataSource.pagingDialect;

import com.fx.core.util.StringUtils;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.util.ClassUtils;

import java.util.Properties;

/**
 * Created by hlwang on 2017/5/4.
 */
@Intercepts({@Signature(type = Executor.class, method = "query", args = {
        MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class }) })
public class PagingIntercept implements Interceptor {

    private PagingDialect pagingDialect;

    public Object intercept(Invocation invocation) throws Throwable {
        //query(MappedStatement ms, Object parameter, RowBounds rowBounds, ResultHandler resultHandler) throws SQLException;
        Object[] args = invocation.getArgs();
        MappedStatement ms = (MappedStatement) args[0];
        Object parameter = args[1];
        RowBounds rowBounds = (RowBounds) args[2];
        int offset = rowBounds.getOffset();
        int limit = rowBounds.getLimit();
        if (pagingDialect.supportsPaging() && (offset != RowBounds.NO_ROW_OFFSET || limit != RowBounds.NO_ROW_LIMIT)) {
            BoundSql boundSql = ms.getBoundSql(parameter);
            String sql = boundSql.getSql().trim();
            sql = pagingDialect.getPagingSql(sql, offset, limit);
            offset = RowBounds.NO_ROW_OFFSET;
            limit = RowBounds.NO_ROW_LIMIT;
            args[2] = new RowBounds(offset, limit);
            BoundSql newBoundSql = new BoundSql(ms.getConfiguration(), sql, boundSql.getParameterMappings(), boundSql.getParameterObject());
            copyMetaParameters(boundSql, newBoundSql);
            MappedStatement newMs = copyFromMappedStatement(ms, new BoundSqlSqlSource(newBoundSql));
            args[0] = newMs;
        }
        return invocation.proceed();
    }

    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    public void setProperties(Properties properties) {
        String className = (String) properties.get("dialect");
        if(StringUtils.isEmpty(className)) {
            throw new MyBatisException("分页方言 不能为空.");
        }
        Class<?> dialectClass = null;
        try {
            dialectClass = ClassUtils.forName(className);
        } catch (Exception e) {
            throw new MyBatisException(e);
        }
        pagingDialect = (PagingDialect) BeanUtils.instantiate(dialectClass);
    }

    /**
     * 复制BoundSql的MetaParameter
     * <br>------------------------------<br>
     * @param lhs
     * @param rhs
     */
    private void copyMetaParameters(BoundSql lhs, BoundSql rhs) {
        for (ParameterMapping map : lhs.getParameterMappings()) {
            String key = map.getProperty();
            Object value = lhs.getAdditionalParameter(key);
            if (null != value) {
                rhs.setAdditionalParameter(key, value);
            }
        }
    }

    // see: MapperBuilderAssistant
    private MappedStatement copyFromMappedStatement(MappedStatement ms, SqlSource newSqlSource) {
        MappedStatement.Builder builder =
                new MappedStatement.Builder(ms.getConfiguration(), ms.getId(), newSqlSource, ms.getSqlCommandType());

        builder.resource(ms.getResource());
        builder.fetchSize(ms.getFetchSize());
        builder.statementType(ms.getStatementType());
        builder.keyGenerator(ms.getKeyGenerator());
        builder.keyProperty(ms.getKeyProperty());
        // setStatementTimeout()
        builder.timeout(ms.getTimeout());
        // setStatementResultMap()
        builder.parameterMap(ms.getParameterMap());
        // setStatementResultMap()
        builder.resultMaps(ms.getResultMaps());
        builder.resultSetType(ms.getResultSetType());
        // setStatementCache()
        builder.cache(ms.getCache());
        builder.flushCacheRequired(ms.isFlushCacheRequired());
        builder.useCache(ms.isUseCache());
        return builder.build();
    }

    public static class BoundSqlSqlSource implements SqlSource {

        private BoundSql boundSql;

        public BoundSqlSqlSource(BoundSql boundSql) {
            this.boundSql = boundSql;
        }

        public BoundSql getBoundSql(Object parameterObject) {
            return boundSql;
        }
    }
}
