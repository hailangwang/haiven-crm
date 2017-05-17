<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML> 
<html> 
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<title>登录</title> 
<link type="text/css" rel="stylesheet" href="${css}/login/login.css"></link>
<script type="text/javascript" src="${scripts}/easyui/boot.js"></script>
<script type="text/javascript" src="${scripts}/login/login.js"></script>
<style type="text/css">
fieldset input[type=text] { 
    background:url(${img}/login/user.png) 2px 2px no-repeat; 
} 
fieldset input[type=password] { 
    background:url(${img}/login/password.png) 2px 2px no-repeat; 
} 

</style>
<!--为了让IE支持HTML5元素，做如下操作：--> 
<!--[if IE]> 
<script type="text/javascript"> 
document.createElement("section"); 
document.createElement("header"); 
document.createElement("footer"); 
</script> 
<![endif]--> 
</head> 
 
<body>
<input type="hidden" id="projectName" value="${projectName}"> 
<div class="wrap"> 
  <form > 
    <section class="loginForm"> 
      <header> 
        <h1>欢迎登录CRM</h1>
      </header> 
      <div class="loginForm_content"> 
        <fieldset> 
        	<span id="errorMsg"></span>
          <div class="inputWrap"> 
           <input type="hidden" id="redirectURL" name="redirectURL" value="${redirectURL}" />
            <input type="text" id="userName" name="userName"   placeholder="帐号"  autofocus="autofocus" onKeypress="onKeyEnter(event)"> 
          </div> 
          <div class="inputWrap"> 
            <input type="password" id="password" name="password" placeholder="请输入密码" onKeypress="onKeyEnter(event)"> 
          </div> 
        </fieldset> 
        <fieldset> 
          <input type="checkbox" checked="checked"> 
          <span>记住登陆信息</span> 
        </fieldset> 
        <fieldset> 
          <input type="button" id="loginButton" value="登录"> 
           <a href="#">忘记密码？</a>
        </fieldset> 
      </div> 
    </section> 
  </form> 
</div> 
</body> 
</html> 