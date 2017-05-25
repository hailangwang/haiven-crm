$(function(){
	mini.parse();
	 $("#userName").focus();
	$("#loginButton").click(function(){
		checkUser();
	});
	var skin = mini.Cookie.get("miniuiSkin");
	if (skin) {
	}else{
		 mini.Cookie.set('miniuiSkin', "blue",100);
	}
});

function checkUser(){
	var userName = $("#userName").val();
	var password = $("#password").val();
	var redirectURL = $("#redirectURL").val();
	var paras1 = {
			
				userName : userName,
				password : password
			
		};


	if(checkNotNull(userName,password)){
		 var messageid =  mini.loading("正在登录...", "正在登录");
		 $(".wrap").hide();
		  var project =  $("#projectName").val();
		$.ajax({
            type: "post",
            contentType: "application/json",
            cache : false,
            url:"/login/checkUser",
            data: mini.encode(paras1),
            success: function (data) {
            	   var req = mini.decode(data);
            	 setTimeout(function () {
                     mini.hideMessageBox(messageid);
                 }, 500);
            	 if(req.model.status="fail"){
            		 $(".wrap").show();
            		 $("#errorMsg").text(req.model.message).css("color","red");
            	 }else{
            		 if(redirectURL==""){
            			 window.location = 'main';
            		 }else{
            			 window.location = 'main?redirectURL='+redirectURL;
            		 }
            		
            	 }
               
            },
            error: function (jqXHR, textStatus, errorThrown) {
            	 setTimeout(function () {
                     mini.hideMessageBox(messageid);
                 }, 500);
            	 $(".wrap").show();
            	  mini.alert(jqXHR.responseText);
            }
        });
	}
	
}
function checkNotNull(userName,password){
	$("#errorMsg").text("");
	if($.trim(userName)==""){
		$("#errorMsg").text("用户名不能能为空").css("color","red");
		 $("#userName").focus();
		return false;
	}else if($.trim(password)==""){
		$("#errorMsg").text("");
		 $("#password").focus();
		$("#errorMsg").text("密码不能能为空").css("color","red");
		return false;
	}else{
		return true;
	}
	
}

function onKeyEnter(e) {
	if(e.keyCode == 13){
		checkUser();
	}
	
}