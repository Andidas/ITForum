<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="description" content="loginAndRegister">
<meta charset="UTF-8">
<title></title>
<link href="css/login.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-3.0.0.min.js"></script>
</head>

<body>
	<div class="form">
		<div id="landing">登录</div>
		<div id="registered">注册</div>
		<div class="fix"></div>
		<div id="landing-content" class="show">
			<form class="form-horizontal " role="form"
				action="UserServlet?op=login" method="post" id="FormLogin">
				<div id="photo">
					<img src="img/photo.jpg" />
				</div>
				<div class="inp">
					<input type="email" placeholder="邮箱" id="inputEmail" name="email" />
				</div>
				<div class="inp">
					<input type="password" placeholder="密码" name="password"
						id="inputPassword" /> <small><input type="checkbox"
						name="rememberMe" value="yes" id="rememberMe" />记住我</small>
				</div>

				<div class="login" id="login">登录</div>
				<div id="bottom">
					<span id="registeredtxt">立即注册</span><span id="forgotpassword">忘记密码</span>
				</div>
			</form>
		</div>
		<div id="registered-content" class="hidden">
			<form class="form-horizontal " role="form"
				action="UserServlet?op=register" method="post" id="Formregister">

				<div class="inp">
					<input type="text" placeholder="请输入用户名" name="rname" id="rname" />
					<small class="hidden">中文、字母、数字或下划线的组合</small>
				</div>
				<div class="inp">
					<input type="password" placeholder="请输入密码" name="rpassword" id="rpassword" />
					<small class="hidden">字母开头，6~18个字母和数字</small>
				</div>
				<div class="inp">
					<input type="password" placeholder="请再次输入密码" name="ensurePassword" id="ensurePassword" />
					<small class="hidden">两次输入的密码不同</small>
				</div>
				<div class="inp">
					<input type="text" placeholder="电子邮箱" name="remail" id="remail" />
					<small class="hidden">邮箱格式错误</small>
				</div>
				<div class="ensureEmail">
					<input type="text" placeholder="验证码" name="captcha" id="captcha" />
					<a href="javaScript:void(0)" id="sendEmail"><span id="reSend">邮箱验证</span></a>
					<small class="hidden" id="reSmall">请到邮箱查看验证码</small>
				</div>
				<div class="login" id="register">立即注册</div>
			</form>
		</div>
	</div>


</body>
<script type="text/javascript">
	/*发送邮箱验证，ajax*/
	$(document).ready(function(){
		$("#sendEmail").click(function(){
			var param = {
				"op" : "emailCaptcha",
				"email" : $("#remail").val()
			}
			$.post("AuthenticateServlet",param,function(data){
				console.log(data);
				if(data == "false"){
					$("#reSmall").html("发送失败，请检查邮箱");
					$("#reSmall").show();
				}else{
					$("#reSmall").html("发送成功，请在邮箱查看验证码");
					$("#reSmall").show();
				}
				$("#reSend").html("重新发送");
			});
		});
	});
	/*点击登录和注册的动作*/
	$(document).ready(function() {

		$(".form").slideDown(500);

		$("#landing").addClass("border-btn");

		$("#registered").click(function() {
			$("#landing").removeClass("border-btn");
			$("#landing-content").hide(500);
			$(this).addClass("border-btn");
			$("#registered-content").show(500);

		})

		$("#landing").click(function() {
			$("#registered").removeClass("border-btn");
			$(this).addClass("border-btn");

			$("#landing-content").show(500);
			$("#registered-content").hide(500);
		})
	});

	/*表单校验*/
	$(document).ready(function(){	
		/*验证名字*/
		$("#rname").blur(function(){
			var regName = /^[\u4e00-\u9fa5\w+$]/;
			if(!regName.test($(this).val())||$(this).val()==""){
				$(this).siblings("small").attr("class","show");
			}else{
				$(this).siblings("small").attr("class","hidden");
			}
		});
		/*验证密码*/
		$("#rpassword").blur(function(){
			var regPass = /^[a-zA-Z]\w{5,17}$/;
			if(!regPass.test($(this).val())||$(this).val()==""){
				$(this).siblings("small").attr("class","show");
			}else{
				$(this).siblings("small").attr("class","hidden");
			}
		});
		/*确认密码*/
		$("#ensurePassword").blur(function(){
			if($(this).val()!=$("#rpassword").val()){
				$(this).siblings("small").attr("class","show");
			}else{
				$(this).siblings("small").attr("class","hidden");
			}
		});
		/*验证邮箱*/
		$("#remail").blur(function(){
			var regEmail = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
			if(!regEmail.test($(this).val())||$(this).val()==""){
				$(this).siblings("small").attr("class","show");
			}else{
				$(this).siblings("small").attr("class","hidden");
			}
		});
		/*表单提交*/
		$("#login").click(function() {
			$("#FormLogin").submit();
		});
		$("#register").click(function() {
			var regName = /^[\u4e00-\u9fa5\w+$]/;
			var regPass = /^[a-zA-Z]\w{5,17}$/;
			var regEmail = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
			if(!regName.test($("#rname").val())||$("#rname").val()==""){
				$("#rname").focus();
				$("#rname").siblings("small").attr("class","show");
			}else if(!regPass.test($("#rpassword").val())||$("#rpassword").val()==""){
				$("#rpassword").focus();
				$("#rpassword").siblings("small").attr("class","show");
			}else if($("#ensurePassword").val()!=$("#rpassword").val()){
				$("#ensurePassword").focus();
				$("#ensurePassword").siblings("small").attr("class","show");
			}else if(!regEmail.test($("#remail").val())||$("#remail").val()==""){
				$("#remail").focus();
				$("#remail").siblings("small").attr("class","show");
			}else{
				$("#Formregister").submit();				
			}
		});
	});
	/*ajax 自动回填密码*/
	$(function() {
		$("#inputEmail").blur(function() {
			var param = {
				"op" : "getPassword",
				"email" : this.value
			};
			$.post("UserServlet", param, function(data) {
				$("#inputPassword").val(data);
				$("#rememberMe").attr("checked", "checked");
			});
		});
	});
</script>
</html>