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
<title>newSession</title>
</head>
<body style="margin-top:80px;">
<jsp:include page="nav.jsp" flush="true"></jsp:include>
	<div class="container">
		<div class="col-md-12 column">
			<form role="form" method="post" enctype="multipart/form-data"
				action="Session?op=doNewSession" id="newSessionForm">
				<%-- 2、在提交页面中存储令牌--%>
				<input type="hidden" name="token" value="${token}">
				<div class="col-md-3">
					<div class="thumbnail">
						<img src="img/ITForum.jpg" alt="图片不符合规范" id="PictureBySet" style="width: 235; height: 235;">
						<div class="caption">
							<label for="setPicture" class="btn btn-success btn-block">set
								picture</label><input type="file" id="setPicture" class="hidden"
								name="PictureBySet" value="img/ITForum.jpg" />
						</div>
					</div>
				</div>
				<div class="col-md-8">
					<div class="form-group">
						<label for="sessionName">版名</label><input type="text"
							class="form-control" id="sessionName" name="sessionName"
							value="" />
					</div>
					<div class="form-group">
						<label for="sessionSprofile">类型</label><input type="text"
							class="form-control" id="sessionSprofile" name="sessionSprofile"
							value="" />
					</div>

					<div class="form-group">
						<label for="sessionBio">简介</label>
						<textarea class='form-control' id="sessionBio" name="sessionBio"
							onkeyup='textAreaChange(this)' onkeydown='textAreaChange(this)'
							rows='5'></textarea>
						<div class='text-right'>
							<em style='color: red'>100</em>/<span>100</span>
						</div>
					</div>
					<button type="submit" class="btn btn-default" id="newSessionSubmit">Submit</button>
				</div>

			</form>
		</div>
	</div>
</body>
<script type="text/javascript" src="js/limitStr.js"></script>
<script type="text/javascript">
	$(function(){
		textAreaChange($("#sessionBio"));
		
	});
</script>
</html>