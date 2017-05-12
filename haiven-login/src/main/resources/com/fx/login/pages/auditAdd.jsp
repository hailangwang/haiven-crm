<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>审核</title>
<script src="${staticServerAddress}/boot.js${cacheVersion}" type="text/javascript"></script>
<script src="${staticServerAddress}/util.js${cacheVersion}" type="text/javascript"></script>
<link href="${css}/core/util.css" rel="stylesheet" type="text/css" />

</head>
<body>
<input type="hidden" id="projectName" value="${projectName}" />
<input class="mini-hidden" id="id" name="id" value=""/>
	<form id="auditAddForm" method="post">
	 <input class="mini-hidden" id="checkoutOrderNumId" name="checkoutOrderNumId" value=""/>
		<div>
			<div>
			     <div class="mini-toolbar" style="border-bottom:0;padding:0px;">
		            <table style="width:100%;">
		                <tr>
		                 	<td style="width:100%;">详细列表</td>
		                </tr>
		            </table>           
		        </div>
	       </div>
	       <div>
			     <div class="mini-toolbar" style="border-bottom:0;padding:0px;">
		            <table style="width:100%;">
		                <tr>
		                 	<td style="width:100%;">
		                 		<a id="audit_add_export" class="mini-button" iconCls="icon-edit" onclick="auditAddExport()">导出审核</a>
		                 	</td>
		                </tr>
		            </table>           
		        </div>
	       </div>
	   <div class="mini-fit" style="height:300px;">
		  <div id="auditGrid" class="mini-datagrid" style="width:100%;height:100%;"
		        url=""  idField="id" showPager="false" >
		        <div property="columns">
		            <div type="indexcolumn"></div>
		            <div field="id" visible="false">主键</div>
		            <div field="repairOrderNum" width="180px">工单号</div>
		            <div field="laborCharge" width="80px">劳务费</div>
		            <div field="orderType" width="80px">开单类型</div>
		            <div field="orderProType" width="80px">开单产品类型</div>
		            <div field="userType" width="100px">用户类型</div>
		            <div field="model" width="80px">产品型号</div>
		            <div field="partNum" width="80px">料号</div>
		            <div field="customerName" width="80px">顾客姓名</div>
		            <div field="siteNum" width="80px">网点授权号</div>
		            <div field="visitStatus" width="80px">回访状态</div>
		            <div field="createTime" width="140px" dateFormat="yyyy-MM-dd HH:mm:ss">接收日期</div>
		            <div field="takeTime" width="140px" dateFormat="yyyy-MM-dd HH:mm:ss">取机日期</div>
		        </div>
		    </div>
	    </div>
			<div style="padding: 8px;" id="baseinfo">
				<fieldset style="border: solid 1px #aaa; padding: 8px;">
					<legend>结算额外信息</legend>
						<div class="two_col_label">额外补助:</div><div class="two_col_input"><input class="mini-spinner" id="extraAllowance" name="extraAllowance" minValue="0" maxValue="1000000" format="n2" required="true" onvaluechanged="actualCostSet"/></div>
						<div class="two_col_label">其它扣款:</div><div class="two_col_input"><input class="mini-spinner" id="otherDeduction" name="otherDeduction" minValue="0" maxValue="1000000" format="n2" required="true" onvaluechanged="actualCostSet"/></div>
						<br/>
						<div class="two_col_label">劳务费:</div><div class="two_col_input"><input class="mini-spinner" id="laborCharge" name="laborCharge" minValue="0" maxValue="1000000" format="n2" required="true" /></div>
						<div class="two_col_label">实际结算:</div><div class="two_col_input"><input class="mini-spinner" id="actualCost" name="actualCost" minValue="0" maxValue="1000000" format="n2" required="true" /></div>
						<br/>
						<div class="one_col_label">备注:</div><div class="one_col_input"><textarea id="remark" name="remark"   style="width: 500px;" vtype="rangeChar:0,50" class="mini-textarea" ></textarea></div>
				</fieldset>
			</div>
			<div style="text-align: center; padding: 10px;" id="buttonarea">
				<a class="mini-button" id="button_ok" onclick="onOkAuditAdd"
					style="width: 60px; margin-right: 10px;">提交</a><a
					class="mini-button" id="button_onCancel" onclick="onCancelAuditAdd"
					style="width: 60px; margin-right: 10px;">取消</a>
					
			</div>
		</div>
	</form>
<script src="${scripts}/checkoutmanage/auditAdd.js${cacheVersion}" type="text/javascript"></script>
</body>
</html>