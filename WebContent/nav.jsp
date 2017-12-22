<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>导航条</title>
<link href="css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-3.0.0.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<style type="text/css">
.login {
	padding-right: 40px;
}

.login span {
	padding: 0 8px 0 0;
}

.login .dropdown-menu li:hover a {
	background-color: #0366D6;
	color: white;
}
#return_top {
	position: fixed;
	bottom: 100px;
	right: 55px;
	width: 45px;
	height: 45px;
	background: url(img/aside_float_bar_z_9bec013.png);
	display: none;
}

#return_top:hover {
	background-position: 109px 99px;
}

</style>
<link rel="stylesheet" type="text/css" href="css/search-form.css">
</head>
<body >
	<div class="clearfix">
		<nav class="navbar navbar-default navbar-fixed-top" role="navigation"
			style="border-top: solid #F48024 3px;border-top: solid #F48024 3px;background: white;">
			<div class="container">

				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="welcome">ITFOURM</a>
				</div>

				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<form onsubmit="submitFn(this, event);">
			            <div class="search-wrapper">
			                <div class="input-holder">
			                    <input type="text" class="search-input"  />
			                    <button class="search-icon" onclick="searchToggle(this, event);"><span></span></button>
			                </div>
			                <span class="close" onclick="searchToggle(this, event);"></span>
			                
			            </div>
			       </form>

					<div class="login">
						<ul class="nav navbar-nav navbar-right">
							<c:if test="${empty sessionScope.NowLoginUser.uemail}">
								<li><a href="UserServlet?op=toLogin">
									<span class="glyphicon glyphicon-user"></span>登录/注册</a>
								</li>
							</c:if>
							<c:if test="${!empty sessionScope.NowLoginUser.uemail}">
								<li class="dropdown"><a href="#" class="dropdown-toggle"
									data-toggle="dropdown"><small><i class="glyphicon glyphicon-bell" id="glyphicon-bell" style="color:red;position: relative;top: -8px;left: 4px;display: none;"></i></small>
								<img alt="user"
										src="<c:if test="${not empty sessionScope.NowLoginUser.uhead}"><%=basePath%>files/${sessionScope.NowLoginUser.uhead}</c:if><c:if test="${empty sessionScope.NowLoginUser.uhead}"><%=basePath%>files/ITForum.jpg</c:if>"
										width="22" height="22" class="img-rounded" /> <strong
										class="caret"></strong>
								</a>
									<ul class="dropdown-menu ">
										<li class="dropdown-header header-nav-current-user css-truncate">
											欢迎您！ <strong class="css-truncate-target" id="nowUserName" class="nowUserName">${sessionScope.NowLoginUser.uname}</strong>
											<input type="hidden" value="${sessionScope.NowLoginUser.uid}" id="nowUserID" class="nowUserID"/>
										</li>
										<li class="divider"></li>
										<li><a href="javaScript:;" class="dropdown-item" onclick="touserjump(${sessionScope.NowLoginUser.uid})">个人信息</a></li>
										<li><a href="javaScript:;" class="dropdown-item" onclick="toInfoCenterjump(${sessionScope.NowLoginUser.uid})">消息中心 <span class="label label-info" id="label-info">+<i id="countInfo">3</i></span></a></li>
										<li class="divider"></li>
										<li><a href="javaScript:void(0)" class="dropdown-item"
											id="exitEmail"> 退出</a></li>
									</ul></li>
							</c:if>
						</ul>
					</div>
				</div>
			</div>
		</nav>
	</div>
	<a href="javaScript:;" class="btn btn-link" id="return_top"></a>
	
</body>
<script type="text/javascript">
 $(window).scroll(function(){
   var sc=$(window).scrollTop();
   var rwidth=$(window).width()
   if(sc>0){
    $("#return_top").css("display","block");
    $("#return_top").css("left",(rwidth-100)+"px")
   }else{
   $("#return_top").css("display","none");
   }
 })
 $("#return_top").click(function(){
   var sc=$(window).scrollTop();
   $('body,html').animate({scrollTop:0},500);
 })
</script>
<script type="text/javascript">
$(document).ready(function(){
		$("#exitEmail").click(function(){
			location.href='<%=basePath%>UserServlet?op=exitUser';
		});
		getLetterCount();
		function getLetterCount(){
			var param = {
				"op":"getLetterCount"
			}
			$.post("letter",param,function(data){
				$("#countInfo").html(data);
				if(data>0){
					$('#label-info').show();
					$('#glyphicon-bell').show();
				}else{
					$('#label-info').hide();
					$('#glyphicon-bell').hide();
				}
			});
		}
	});
</script>
<!-- 搜索框 -->
<script type="text/javascript">
        function searchToggle(obj, evt){
            var container = $(obj).closest('.search-wrapper');

            if(!container.hasClass('active')){
                  container.addClass('active');
                  evt.preventDefault();
            }
            else if(container.hasClass('active') && $(obj).closest('.input-holder').length == 0){
                  container.removeClass('active');
                  // clear input
                  container.find('.search-input').val('');
                  // clear and hide result container when we press close
                  container.find('.result-container').fadeOut(100, function(){$(this).empty();});
            }
        }

        function submitFn(obj, evt){
            value = $(obj).find('.search-input').val().trim();
            if(!value.length){
                alert('请输入内容');
                $(obj).focus();
            }else{
            	location.href="Search?value="+value;
            }
            evt.preventDefault();
        }
    </script>
</html>