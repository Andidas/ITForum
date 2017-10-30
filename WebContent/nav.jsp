<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
</head>
<body>
		<div class="clearfix">
		<nav class="navbar navbar-default navbar-fixed-top" role="navigation"
			style="border-top: solid #F48024 3px;">
			<div class="container">

				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">Brand</a>
				</div>

				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="active"><a href="#">Link</a></li>

						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">Dropdown<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li><a href="#">Action</a></li>
								<li><a href="#">Another action</a></li>
								<li><a href="#">Something else here</a></li>
								<li class="divider"></li>
								<li><a href="#">Separated link</a></li>
								<li class="divider"></li>
								<li><a href="#">One more separated link</a></li>
							</ul></li>
					</ul>

					<form action="http://www.baidu.com/s"
						class="navbar-form navbar-left" role="search">
						<div class="input-group">
							<input type="text" class="form-control" placeholder="search.."
								autocomplete="off" maxlength="240" /> <span
								class="input-group-btn">
								<button class="btn btn-default btn-primary" type="button">
									<span class="glyphicon glyphicon-search"></span>
								</button>
							</span>
						</div>

					</form>
					
					<div class="login">
						<ul class="nav navbar-nav navbar-right">
							<c:if test="${empty sessionScope.NowLoginUser.uemail}">
							<li><a href="UserServlet?op=toLogin"><span
									class="glyphicon glyphicon-user"></span>注册</a></li>
							<li><a href="UserServlet?op=toLogin"><span
									class="glyphicon glyphicon-log-in"></span>登录</a></li>
							</c:if>
							<c:if test="${!empty sessionScope.NowLoginUser.uemail}">
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown"> <img alt="user" src="<%=basePath%>files/${sessionScope.NowLoginUser.uhead}"
									width="22" height="22" class="img-rounded" /> <strong
									class="caret"></strong>
							</a>
								<ul class="dropdown-menu ">
									<li
										class="dropdown-header header-nav-current-user css-truncate">
										欢迎您！ <strong class="css-truncate-target">${sessionScope.NowLoginUser.uname}</strong>
									</li>
									<li class="divider"></li>
									<li><a href="user.jsp" class="dropdown-item">个人信息</a></li>

									<li class="divider"></li>
									<li><a href="#" class="dropdown-item"> 帮助</a></li>
									<li><a href="#" class="dropdown-item"> 设置</a></li>
									<li><a href="javaScript:void(0)" class="dropdown-item" id="exitEmail"> 退出</a></li>
								</ul></li>
							</c:if>
						</ul>
					</div>
				</div>
			</div>
		</nav>
	</div>
</body>
<script type="text/javascript">
$(document).ready(function(){
		$("#exitEmail").click(function(){
			location.href='<%=basePath%>UserServlet?op=exitUser';
			
		});
	});
</script>
</html>