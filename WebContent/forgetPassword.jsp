<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="login">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width,initial-scale=1.0" />
	<title></title>
<script type="text/javascript" src="js/jquery-3.0.0.min.js"></script>
<link type="text/css" href="css/forgetPassword.css" rel="stylesheet" />
</head>

<body>

	<div class="content">
		<div class="web-width">
			<div class="for-liucheng">
				<div class="liulist for-cur" id="weBox0"></div>
				<div class="liulist" id="eeBox0"></div>
				<div class="liulist" id="npBox0"></div>
				<div class="liulist" id="done0"></div>
				<div class="liutextbox">
					<div class="liutext for-cur" id="weBox">
						<em>1</em><br />
						<strong>填写邮箱</strong>
					</div>
					<div class="liutext" id="eeBox">
						<em>2</em><br />
						<strong>验证身份</strong>
					</div>
					<div class="liutext" id="npBox">
						<em>3</em><br />
						<strong>设置新密码</strong>
					</div>
					<div class="liutext" id="done">
						<em>4</em><br />
						<strong>完成</strong>
					</div>
				</div>
			</div>
			<!--for-liucheng/-->
			<form action="" method="post" class="forget-pwd" id="writeEmailForm">
				<dl>
					<dt></dt>
					<dd>
						<input type="email" name="FPemail0" id="FPemail0" placeholder="请先输入邮箱"/>
					</dd>
					<div class="clears"></div>
				</dl>
				<dl>
					<dt></dt>
					<dd>
						<div id="captcha2">
							<p id="wait2" class="show">正在加载验证码......</p>
						</div>
						<p id="notice2" class="hide">请先完成验证</p>
					</dd>
					<div class="clears"></div>
				</dl>
				<div class="subtijiao">
					<input type="button" value="提交" id="submit2" />
				</div>
			</form>
			<form action="" method="post" class="forget-pwd" id="ensureEmailForm">
				<dl>
					<dt></dt>
					<dd>
						<input type="email" class="disabled" readonly id="remail" name="remail" placeholder="已验证邮箱"/>
					</dd>
					<div class="clears"></div>
				</dl>
				<dl>
					<dt></dt>
					<dd class="ensureEmail">
						<input type="text" style="height: 33px; width: 96px;" placeholder="验证码" id="captcha" name="captcha"/> 
						<a href="javaScript:void(0)" id="sendEmail"><span id="reSend">邮箱验证</span></a>
						<span id="reSmall" class="bubble">输入验证码</span>						
					</dd>
					<div class="clears"></div>
				</dl>
				<div class="subtijiao">
					<input type="button" value="提交" id="eeSubmit" />
				</div>
			</form>
			<form action="" method="post" class="forget-pwd" id="newPasswordForm">
				<dl>
					<dt></dt>
					<dd>
						<input type="password" id="newpassword" name="newpassword" placeholder="请输入新密码"/><span class="bubble">字母开头，6~18个字母和数字</span>
					</dd>
					<div class="clears"></div>
				</dl>
				<dl>
					<dt></dt>
					<dd>
						<input type="password" id="ensurepassword" name="ensurepassword" placeholder="确认新密码"/><span class="bubble">两次输入的密码不同</span>
					</dd>
					<div class="clears"></div>
				</dl>
				<div class="subtijiao">
					<input type="button" value="提交" id="npSubmit" />
				</div>
			</form>
			<div class="successs" id="success">
				<h3>恭喜您，修改成功！</h3>
				<br>
				<a href="loginAndRegister.jsp">返回登录...</a>
			</div>
		</div>
		<!--web-width/-->
	</div>
	<!--content/-->


</body>

<script type="text/javascript">
$(function(){
	/*发送邮件获取验证码*/
	$("#sendEmail").click(function(){
		var param = {
				"op" : "emailCaptcha",
				"remail" : $("#remail").val()
		}
		$.post("AuthenticateServlet",param,function(data){
			console.log(data);
			if(data == "false"){
				$("#reSmall").html("发送失败，请检查邮箱");
				$("#reSmall").show(300);
			}else{
				$("#reSmall").html("发送成功，请在邮箱查看验证码");
				$("#reSmall").show(300);
			}
			$("#sendEmail").css('opacity','0.5');
			$("#reSend").html("重新发送");
		});
	});
	/*鼠标移开时,校验密码*/
	$("#newpassword").blur(function(){
		var regPass = /^[a-zA-Z]\w{5,17}$/;
		if(!regPass.test($(this).val())||$(this).val()==""){
			$(this).siblings("span").fadeIn(300);
		}else{
			$(this).siblings("span").fadeOut(300);
		}
	});
	/*鼠标移开时,校验确认密码*/
	$("#ensurepassword").blur(function(){
		if($(this).val()!=$("#newpassword").val()){
			$(this).siblings("span").fadeIn(300);
		}else{
			$(this).siblings("span").fadeOut(300);
		}
	});
	/*鼠标移开验证码框的时候校验验证码*/
	$("#captcha").blur(function(){
		$("#captcha").blur(function(){
			var param = {
				"op" :"toCheckEmailCaptcha",
				"captcha" :$("#captcha").val()
			}
			$.post("AuthenticateServlet",param,function(data){
				console.log(data);
				if(data == "true"){
					$("#reSmall").hide();
					$("#reSmall").html("true");
				}else{
					$("#reSmall").html("验证码错误!");
					$("#reSmall").show(300);
				}
			});
		});
	});
});
$(function(){
	/*初始化要隐藏的值*/
	$("#ensureEmailForm").hide();
	$("#newPasswordForm").hide();
	$("#success").hide();
	/*邮箱收到的验证码校验*/
	$("#eeSubmit").click(function(){
		if($("#reSmall").html()!="true"){
			$("#captcha").focus();
			$("#reSmall").show(300);
		}else{
			$("#ensureEmailForm").hide();
			$("#newPasswordForm").show();
			$("#npBox").addClass("for-cur");
			$("#npBox0").addClass("for-cur");					
		}
	});
	/*新密码提交校验*/
	$("#npSubmit").click(function(){
		var regPass = /^[a-zA-Z]\w{5,17}$/;
		if(!regPass.test($("#newpassword").val())||$("#newpassword").val()==""){
			$("#newpassword").focus();
			$("#newpassword").siblings("span").fadeIn(300);
		}else if($("#ensurepassword").val()!=$("#newpassword").val()){
			$("#ensurepassword").focus();
			$("#ensurepassword").siblings("span").fadeIn(300);
		}else{
			var param = {
				"op" :"modifyPassword",
				"newpassword" :$("#newpassword").val(),
				"remail" : $("#remail").val()
			}
			$.post("UserServlet",param,function(data){
				console.log(data);
				if(data == "true"){
					$("#newPasswordForm").hide();
					$("#success").show();
					$("#done").addClass("for-cur");
					$("#done0").addClass("for-cur");
				}else{
					alert("修改失败，请刷新页面");
				}
			});
		}
	});
});

</script>
<!-- 引入 gt.js，既可以使用其中提供的 initGeetest 初始化函数 -->
<script src="js/gt.js"></script>
<script>
	/*拖动验证防范机器人*/
    var handler2 = function (captchaObj) {
        $("#submit2").click(function (e) {
            var result = captchaObj.getValidate();
            if (!result) {
                $("#notice2").show();
                setTimeout(function () {
                    $("#notice2").hide();
                }, 2000);
            } else {
                $.ajax({
                    url: 'gt/ajax-validate2',
                    type: 'POST',
                    dataType: 'json',
                    data: {
                        username: $('#username2').val(),
                        password: $('#password2').val(),
                        geetest_challenge: result.geetest_challenge,
                        geetest_validate: result.geetest_validate,
                        geetest_seccode: result.geetest_seccode
                    },
                    success: function (data) {
                        if (data.status == 'success') {
                        	if($("#FPemail0").val()==""){
                        		$("#FPemail0").focus();
                        		alert('输入邮箱');
                        	}else{
                        		$("#remail").val($("#FPemail0").val());
                        		$("#writeEmailForm").hide();
                    			$("#ensureEmailForm").show();
                    			$("#eeBox").addClass("for-cur");
                    			$("#eeBox0").addClass("for-cur");
                        	}
                        } else if (data.status === 'fail') {
                            alert('重新验证失败');
                        }
                    }
                })
            }
            e.preventDefault();
        });
        // 将验证码加到id为captcha的元素里，同时会有三个input的值用于表单提交
        captchaObj.appendTo("#captcha2");
        captchaObj.onReady(function () {
            $("#wait2").hide();
        });
        // 更多接口参考：http://www.geetest.com/install/sections/idx-client-sdk.html
    };
    $.ajax({
        url: "gt/register2?t=" + (new Date()).getTime(), // 加随机数防止缓存
        type: "get",
        dataType: "json",
        success: function (data) {
            // 调用 initGeetest 初始化参数
            // 参数1：配置参数
            // 参数2：回调，回调的第一个参数验证码对象，之后可以使用它调用相应的接口
            initGeetest({
                gt: data.gt,
                challenge: data.challenge,
                new_captcha: data.new_captcha, // 用于宕机时表示是新验证码的宕机
                offline: !data.success, // 表示用户后台检测极验服务器是否宕机，一般不需要关注
                product: "popup", // 产品形式，包括：float，popup
                width: "100%"
                // 更多配置参数请参见：http://www.geetest.com/install/sections/idx-client-sdk.html#config
            }, handler2);
        }
    });
</script>
</html>
