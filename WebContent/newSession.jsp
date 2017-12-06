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
<!-- 提示框 -->
<link rel="stylesheet" href="css/zebra_tooltips.css" type="text/css"> 
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
					<div class="thumbnail" >
						<img src="img/ITForum.jpg" alt="图片不符合规范" id="PictureBySet" style="width: 235; height: 235;">
						<div class="caption">
							<label for="setPicture" class="btn btn-success btn-block">set
								picture</label><input type="file" id="setPicture" class="hidden"
								name="PictureBySet" value="img/ITForum.jpg" />
						</div>
					</div>
				</div>
				<div class="col-md-8">
					
					<div class="form-group clearfix">
							<div class="col-md-4" >
								<label for="sessionSprofile">类别</label>
								<select  class="form-control" name="sessionSprofile" id="sessionSprofile">
									<c:forEach items="${AllSessionProfiles}" var="profile">
										<option value="${profile}">${profile}</option>
									</c:forEach>
									<option value="other">其他</option>
								</select>
							</div>
							<div class="col-md-5 " id="otherDiv" style="display: none;">
								<label for="otherSprofile">其他</label>
								<input type="text" class="form-control" id="otherSprofile" name="otherSprofile"/>	
							</div>						
					</div>
					<div class="col-md-9" >
						<label for="sessionName">版名</label>
						<input type="text" class="form-control" id="sessionName" name="sessionName" onkeyup='textAreaChange(this)' onkeydown='textAreaChange(this)'/>
						<div class='text-right'>
							<em style='color: red'>50</em>/<span>50</span>
						</div>
					</div>
					<div class="form-group col-md-12">
						<label for="sessionBio">简介</label>
						<textarea class='form-control' id="sessionBio" name="sessionBio"
							onkeyup='textAreaChange(this)' onkeydown='textAreaChange(this)'
							rows='5'></textarea>
						<div class='text-right'>
							<em style='color: red'>100</em>/<span>100</span>
						</div>
					</div>
					<div class="form-group col-md-12">
					<a class="btn btn-default" id="newSessionSubmit">Submit</a>
						</div>
				</div>
			</form>
		</div>
	</div>
<%@include file="footer.html" %>
</body>
<!-- 提示框 -->
<script type="text/javascript" src="js/zebra_tooltips.js"></script> 
<!-- 限制字符串个数 -->
<script type="text/javascript" src="js/limitStr.js"></script>
<script type="text/javascript">
	$(function(){
		textAreaChange($("#sessionBio"));
		$('#sessionSprofile').change(function(){
			if($(this).val()=='other'){
				$('#otherDiv').show();
				console.log($('#otherDiv'));
			}else{
				$('#otherDiv').hide();
			}
		});
	});
</script>
<!-- 校验提交 -->
<script type="text/javascript">
	$(function(){
		$('#newSessionSubmit').click(function(){
		
			var reg=/^\s+$/;
			if($('#nowUserName').html()==undefined){
				alert('请登录');
			}else if($('#sessionSprofile').val()=='other'&&(reg.test($("#otherSprofile").val())||$('#otherSprofile').val()=="")){
				$("#otherSprofile").focus();
					alert('请输入类型!');
			}else if(reg.test($("#sessionName").val())||$('#sessionName').val()==""){
				$('#sessionName').focus();
				alert('请输入版名!');
			}else if(reg.test($("#sessionBio").val())||$('#sessionBio').val()==""){
				$('#sessionBio').focus();
				alert('请输入简短的描述！');
			}else{
				$('#newSessionForm').submit();
			}
		});
	});
</script>
</html>