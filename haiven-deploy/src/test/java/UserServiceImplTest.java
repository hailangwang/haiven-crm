

import com.fx.login.controller.LoginController;
import com.fx.login.entity.UserEntity;
import com.fx.login.service.UserService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by hlwang on 2017/6/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:development/conf/spring_applicationContext.xml" })
public class UserServiceImplTest extends TestCase {

    @Autowired
    private UserService userService;
    @Test
    public void testCheckUser() throws Exception {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName("wang");
        userEntity.setPassword("123");
        String s = userService.checkUser(userEntity);
//        String s =  userService.checkUser(userEntity);
        System.out.println(s);
    }
}