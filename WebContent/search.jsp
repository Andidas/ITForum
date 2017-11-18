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
		<c:if test="${empty topics }">
		<h1><a href="javaScript:;" id="newSession">新建</a></h1>
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
							<td>${topic.ttopic }</td>
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
							<td>${session.sname }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
​		</c:if>
	</div>

</body>
<script type="text/javascript">
	$(function(){
		$('#newSession').click(function(){
			if($('#nowUserName').html()==undefined){
				alert('请登录');
			}else{
				location.href="newSession.jsp"
			}
		});
	});
</script>
</html>