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
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="login">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width,initial-scale=1.0" />
<title>消息中心</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="css/infoCenter/index.css">
<link rel="stylesheet" href="css/infoCenter/themes-defalut.css">
<link href="css/infoCenter/pagination.css" rel="stylesheet" />
<link rel="stylesheet" href="css/infoCenter/common.css">
<link rel="stylesheet" href="css/infoCenter/form.css">
<link rel="stylesheet" href="css/infoCenter/alerts.css">
<link rel="stylesheet" href="css/infoCenter/style.css">


<link href="css/infoCenter/frontshow.css" rel="stylesheet" />
<link href="css/infoCenter/notices.css" rel="stylesheet" />

</head>
<meta content="authenticity_token" name="csrf-param" />
<meta content="dGBSiGhfHAv6IlAuZKAym2FPsqWeA3RYvxkKMY1d4Xw="
	name="csrf-token" />

<body id="notify-center"
	style="padding-top: 30px; background-color: #e9e9e9; font-family: 'microsoft yahei'">
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
					<a class="navbar-brand" href="welcome">ITFOURM</a>
				</div>
			</div>
		</nav>
	</div>
	<a href="javaScript:;" class="btn btn-link" id="return_top"></a>
	<div class="container clearfix">
		<input id="current_user" type="hidden" value="qq_34353848">
		<div id="scrollbox" style="display: none; height: 0px;">
			<div></div>
			<div
				style="position: absolute; z-index: 999; right: 0px; top: 0px; border: 1px solid rgb(193, 193, 193); background-color: rgb(255, 255, 255); width: 8px; display: none;">
				<div
					style="width: 10px; background-color: rgb(193, 193, 193); position: absolute; cursor: pointer;"></div>
			</div>
		</div>
		<div class="w1170-w">
			<ul class="notice-info-tab">
				<li class="notify curr-tab"><a href="javaScript:;">通知</a></li>
				<li class="letter "><a href="PrivateLetter.jsp">私信</a></li>
			</ul>
			<div class="notice-count">
				<span>未读通知：<b class="unread_count">0</b></span> <a class="mark_read"
					href="/notifies/set_readed">全部标记为已读</a> <span> &nbsp; </span> <a
					class="mark_read" href="/notifies/message_destroy">清空所有通知</a>
			</div>
			<ul class="notice-list">
			</ul>
			<ul class="pager">
				<li class=" no-msg"
					style="margin-bottom: 0; height: auto; width: 100%; text-align: center; color: #666; font-size: 16px; display: inline-block; height: 500px;">
					<div class="icon-th-list"
						style="margin-top: 200px; display: block;">

						<span style="width: 100%; float: none; display: inline;"> <i
							class="glyphicon glyphicon-list">&nbsp; </i>您暂时还未收到通知
						</span>
					</div>
				</li>
			</ul>
		</div>

	</div>
	<%@include file="footer.html"%>
</body>
<script type="text/javascript" src="js/jquery-3.0.0.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
</html>