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
<title>搜索</title>
</head>
<body style="margin-top: 50px">
	<jsp:include page="nav.jsp" flush="true"></jsp:include>
	
	<div class="container">
		<div style="color:red;margin-top:20px;">
		<p>简易搜索教程</p>
		<p>搜索版块：java。请在搜索框输入：[java]</p>
		<p>搜索帖子：帖子1。请在搜索框输入：帖子1</p>
		</div>
		<c:if test="${empty sessions and empty topics}">
		<h1>无搜索结果，您可以选择<a href="javaScript:;" id="newSession">新建</a></h1>
			<img src="img/notfound.jpg" width="100%" height="100%">
		</c:if>
		
		<c:if test="${not empty topics }">
			<table class="table table-striped">
				<caption>查找内容</caption>
				<thead>
					<tr>
						<th>题目</th>
						<th>内容</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${topics}" var="topic">

						<tr>
							<td>
							
							<a  href="javaScript:;" class="topicTName" onclick="topicjumg(this,${topic.tsid})">${topic.ttopic }</a>
							<input type="hidden" class="topicTid" value="${topic.tid }">
						
							</td>
							<td>${topic.tcontents }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
​		</c:if>
		<c:if test="${not empty sessions }">
			<table class="table table-striped">
				<caption>查找内容</caption>
				<thead>
					<tr>
						<th>主题</th>
						<th>版块</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${sessions}" var="session">
						<tr>
							<td>${session.sprofile }</td>
							<td>
							<a href="javaScript:;" class="sessionName">${session.sname }</a>
							<input type="hidden" class="sessionSid" value="${session.sid }">
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
​		</c:if>
	</div>
<%@include file="footer.html" %>
</body>
<script type="text/javascript" src="js/GotoTopicOrSession.js"></script>
<script type="text/javascript">
	$(function(){
		$('#newSession').click(function(){
			location.href="Session?op=toNewSession"
		});
	});
</script>
</html>