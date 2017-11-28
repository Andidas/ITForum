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
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="login">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width,initial-scale=1.0" />
<title>作者</title>

<link href="css/init.css" rel="stylesheet" />
<link href="css/user.css" rel="stylesheet" />
<link rel="stylesheet" href="css/zebra_tooltips.css" type="text/css"> 
<link href="css/loadingButton.css" rel="stylesheet">
</head>
<body class="user-page" id="MyBody">
	<jsp:include page="nav.jsp" flush="true"></jsp:include>
	<div class="container" id="content">
		<div class="clearfix">
			<div class="col-md-12 column">
				<ul id="myTab" class="nav nav-tabs">
					<li class="active"><a href="#profile" data-toggle="tab">
							<span class="glyphicon glyphicon-home"></span>主页</a></li>
					<li><a href="#activity" data-toggle="tab"><span class="glyphicon glyphicon-leaf"></span>成就</a></li>
					<c:if test="${queryUserInfo.uid==NowLoginUser.uid}">
					<li><a href="#edit" data-toggle="tab"><span class="glyphicon glyphicon-cog"></span>编辑</a></li>
					</c:if>
				</ul>
			</div>
		</div>
		<div id="myTabContent" class="tab-content clearfix">
			<div class="tab-pane fade in active" id="profile">
				<div id="user-card">
					<div class="clearfix">
						<div class="col-sidebar col-lg-3">
							<div id="avatar-card" class="avatar-card">
								<div class="avatar">
								<a href="javascript:;" onclick="touserjump(${queryUserInfo.uid})" >
									<input type="hidden" id="queryUserId" value="${queryUserInfo.uid}">
										<img  src="<c:if test="${not empty queryUserInfo.uhead}"><%=basePath%>files/${queryUserInfo.uhead}</c:if><c:if test="${empty queryUserInfo.uhead}"><%=basePath%>files/ITForum.jpg</c:if>"									
											alt="" width="164" height="164" class="avatar-user">
									</a>
								</div>
								<div class="reputation zebra_tips1" title="reputation">
									131,472 <span class="label-uppercase">reputation</span>
								</div>

								<div class="g-row _gutters ai-start fl-none -row-first">
									<div class="g-col g-row g-center badge1-alternate zebra_tips1" title="拥有${queryUserInfo.uissectioner}个版块<br><a href=''>申请版主?</a>">
										<span class="g-col g-center -total">${queryUserInfo.uissectioner}</span>
									</div>
									<div class="g-col g-row g-center badge2-alternate zebra_tips1" title="用户积分:${queryUserInfo.upoint}">
										<span class="g-col g-center -total">${queryUserInfo.upoint}</span>
									</div>
									<div class="g-col g-row g-center badge3-alternate zebra_tips1"
										title="发送消息给他">
										<a href="javaScript:;" onclick="toInfoCenterjump(${queryUserInfo.uid})" class="g-col g-center -total">私信</a>
									</div>

								</div>
							</div>
						</div>
						<div class="col-lg-9">
							<div class="col-left col-md-7 about">
								<h2 class="user-card-name">个人简介</h2>
								<c:if test="${empty queryUserInfo.usatement}">
								<div class="current-position"><br><br><br>该用户很懒人,什么都没留下~</div>
								</c:if>
								<div class="bio">
								<br>
								<c:if test="${not empty queryUserInfo.usatement}">
									${queryUserInfo.usatement}
								</c:if>
								</div>
								
							</div>
							
							<div class="col-right col-md-5">
								<div class="user-links">
									<div class="user-stats">
										<div class="row" style="margin: 0;">
											<div class="stat">
												<span class="number">5,852</span> answers
											</div>

											<div class="stat">
												<span class="number">0</span> questions
											</div>
											<div class="stat">
												<span class="number">~4.0m</span> people reached
											</div>
										</div>
									</div>

									<div class="user-link">
										<ul class="list-unstyled">
											<li><svg aria-hidden="true" class="svg-icon iconLocation" width="18" height="18" viewBox="0 0 18 18">
												<path d="M8.1 17.7S2 9.9 2 6.38A6.44 6.44 0 0 1 8.5 0C12.09 0 15 2.86 15 6.38 15 9.91 8.9 17.7 8.9 17.7c-.22.29-.58.29-.8 0zm.4-8.45a2.75 2.75 0 1 0 0-5.5 2.75 2.75 0 0 0 0 5.5z"></path></svg>
												Atlanta, GA
											</li>
											<li><svg aria-hidden="true" class="svg-icon iconLink" width="18" height="18" viewBox="0 0 18 18">
												<path d="M2.9 9c0-1.16.94-2.1 2.1-2.1h3V5H 5a4 4 0 1 0 0 8h3v-1.9H5A2.1 2.1 0 0 1 2.9 9zM13 5h-3v1.9h3a2.1 2.1 0 1 1 0 4.2h-3V13h3a4 4 0 1 0 0-8zm-7 5h6V8H6v2z"></path></svg>
												<a href="http://www.frischcode.com" rel="me noreferrer" class="url">
												frischcode.com
												</a>
											</li>
											<li><svg aria-hidden="true" class="svg-icon iconHistory" width="19" height="18" viewBox="0 0 19 18">
												<path d="M3 9a8 8 0 1 1 3.73 6.77L8.2 14.3A6 6 0 1 0 5 9l3.01-.01-4 4-4-4h3zm7-4h1.01L11 9.36l3.22 2.1-.6.93L10 10V5z"></path></svg>
												Member for 
												<span title="2013-11-09 01:20:44Z">
												3 years, 11 months
												</span>
											</li>
											<li><svg aria-hidden="true" class="svg-icon iconEye" width="18" height="18" viewBox="0 0 18 18">
												<path 	d="M9.06 3C4 3 1 9 1 9s3 6 8.06 6C14 15 17 9 17 9s-3-6-7.94-6zM9 13a4 4 0 1 1 0-8 4 4 0 0 1 0 8zm2-4a2 2 0 0 1-2 2 2 2 0 0 1-2-2 2 2 0 0 1 2-2 2 2 0 0 1 2 2z"></path></svg>
												11,727 profile views
												</li>
											<li><svg aria-hidden="true" class="svg-icon iconClock"width="18" height="18" viewBox="0 0 18 18">
												<path d="M9 17A8 8 0 1 1 9 1a8 8 0 0 1 0 16zm0-2A6 6 0 1 0 9 3a6 6 0 0 0 0 12zM8 5h1.01L9 9.36l3.22 2.1-.6.93L8 10V5z"></path></svg>
												Last seen 
												<span title="2017-10-23 02:04:28Z" class="relativetime">
												3 mins ago
												</span>
											</li>
										</ul>
									</div>

								</div>
							</div>
						</div>
					</div>
					<div class="clearfix" id="sidebar">
						<div class="col-md-3">
							<div class="module" id="interesting-tags">
								<h4 id="h-interesting-tags">他的关注</h4>
								<a id="edit-interesting">edit</a>
								<div>
									<c:if test="${empty userFollowSession}">
										<br><br>
										<p style="color: #9e9e9e;">
											用户暂时没有关注的版块
										</p>		
									</c:if>
									<c:forEach items="${userFollowSession}" var="follow">
									<a href="javaScript:;" class="label label-success"  rel="tag" onclick="tosessionjump(${follow.sid})">
										${follow.sname}
									</a>									
									</c:forEach>
								</div>
								
							</div>
						</div>
						<div class="col-md-9">
							<ul id="Tabson" class="nav nav-tabs ">
								<li>
									<h4>帖子</h4>
								</li>
							</ul>
							<div id="TabContentSon" class="tab-content">
								<div class="tab-pane fade in active" >
									<table class="table table-hover table-condensed table-striped">
										<thead>
											<tr>
												<th>题目</th>
												<th>时间</th>
											</tr>
										</thead>
										<tbody id="tbody">
											<c:forEach items="${userTopic.data}" var="topic" varStatus="num">
											<tr <c:if test="${num.index%2==1}">class="success"</c:if>>
											<td><a href="javaScript:;" onclick="toTopicJump(${topic.tid},${topic.tsid})">${topic.ttopic}</a></td>
												<td>${topic.ttime}</td>
											</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
							<c:if test="${empty userTopic.data}">
								<p style="color:#9e9e9e;text-align: center;">一个帖子都没发过</p>
							</c:if>
							<c:if test="${not empty userTopic.data}">
								
								<div class="col-xs-2 col-xs-offset-5" style="padding-bottom:20px;">								
									<a class="btn btn-default" id="showMore">加载更多</a>
									<input type="hidden" value="1" id="nowPageNo">
									<div class="loadEffect" id="loadEffect" style="display:none;">
								        <span></span>
								        <span></span>
								        <span></span>
								        <span></span>
								        <span></span>
								        <span></span>
								        <span></span>
								        <span></span>
									</div>
								</div>
								
							</c:if>
							
						</div>
					</div>
				</div>
			</div>
			<div class="tab-pane fade" id="activity">
				<div class="clearfix col-xs-12" style="margin-bottom:170px;">
				<img src="img/achieve.PNG" alt="暂未获得成就" class="col-xs-6 col-xs-offset-3">
				</div>
			</div>
			<div class="tab-pane fade" id="edit">
				<div class="clearfix">
					<div class="col-md-12 column">
						<form role="form" method="post" enctype="multipart/form-data" action="UserServlet?op=update">
							<div class="col-md-3">
								<div class="thumbnail">
									<img src="<c:if test="${not empty sessionScope.NowLoginUser.uhead}"><%=basePath%>files/${sessionScope.NowLoginUser.uhead}</c:if><c:if test="${empty sessionScope.NowLoginUser.uhead}"><%=basePath%>files/ITForum.jpg</c:if>" alt="图片不符合规范" 
										id="PictureBySet" style="width:235;height:235;">
									<div class="caption">
										<label for="setPicture" class="btn btn-success btn-block">set
											picture</label><input type="file" id="setPicture" class="hidden" name = "PictureBySet" value="${sessionScope.NowLoginUser.uhead}"/>
									</div>
								</div>
							</div>
							<div class="col-md-8">
								<div class="form-group">
									<label for="userName">姓名</label><input type="text"
										class="form-control" id="userName" name = "userName" value="${sessionScope.NowLoginUser.uname}"/>
								</div>
								<div class="form-group">
									<label for="userEmail">邮箱</label><input
										type="email" class="form-control" id="userEmail" name="userEmail" value="${sessionScope.NowLoginUser.uemail}"/>
								</div>
								
								<div class="form-group">
									<label>性别</label> <input type="radio" name="userSex" value="1" <c:if test="${sessionScope.NowLoginUser.usex ==1}">checked="checked"</c:if>>男
									<input type="radio" name="userSex" value="0" <c:if test="${sessionScope.NowLoginUser.usex ==0}">checked="checked"</c:if>>女

								</div>
								<div class="form-group">
									<label for="userBirthday">生日</label><input
										type="date" class="form-control"
										id="userBirthday" name="userBirthday" value="${sessionScope.NowLoginUser.ubirthady}"/>
								</div>
								<div class="form-group">
									<label for="userBio">自我介绍</label>
						            <textarea class='form-control' id="userBio" name="userBio" onkeyup='textAreaChange(this)' onkeydown='textAreaChange(this)' rows='5'>${sessionScope.NowLoginUser.usatement}</textarea>
						            <div class='text-right'>
						                <em style='color:red'>500</em>/<span>500</span>
						            </div>
								</div>
								<button type="submit" class="btn btn-default" id="setUserInfo">Submit</button>
							</div>
							
						</form>

					</div>
				</div>

			</div>
		</div>
	</div>
	<%@include file="footer.html" %>	
</body>
<!-- 加载更多 -->
<script type="text/javascript">
	$(function(){
		$("#showMore").click(function(){
			hide_show($("#showMore"),$("#loadEffect"));
			var uid = $("#queryUserId").val();
			var nowPageNo = $("#nowPageNo").val();
			var param = {
					'op':'findUserTopic',
					'uid':uid,
					'pageno':nowPageNo
			}
			$.post('UserInFo',param,function(data){
				if(data=="false"){
					setTimeout('hide_MoreBtn_LoadBtn()',1000);
				}else{
					hide_show($("#loadEffect"),$("#showMore"));
					
					var topics = JSON.parse(data);
					$.each(topics,function(i,topic){
						var content=setUser_Ttopic(i,topic);
						$('#tbody').append(content);
					});
					nowPageNo++;
					$("#nowPageNo").val(nowPageNo);
				}
			});
		});
	});
	function setUser_Ttopic(i,topic){
		if(i%2==1){
			var cla = 'class="success"';
		}
		var text = '<tr '+cla+'>'
				+'<td>'
				+'<a href="javaScript:;" onclick="toTopicJump('+topic.tid+','+topic.tsid+')">'+topic.ttopic+'</a>'
				+'</td><td>'
				+topic.ttime
				+'</td></tr>';
		return text;
	}
	function hide_show(obj_x,obj_y){
		obj_x.hide();
		obj_y.show();
	}
	function hide_MoreBtn_LoadBtn(){
		$("#showMore").hide();
		$("#loadEffect").hide();
	}
</script>
<!-- 页面跳转 -->
<script type="text/javascript" src="js/GotoTopicOrSession.js"></script>
<!-- 提示框 -->
<script type="text/javascript" src="js/zebra_tooltips.js"></script>
<!-- 字符限制 -->
<script type="text/javascript" src="js/limitStr.js"></script>

<script type="text/javascript">
	$(function(){
		textAreaChange($("#userBio"));
	});
</script>
</html>