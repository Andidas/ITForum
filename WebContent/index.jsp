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
<title>首页</title>
<!-- 提示框 -->
<link rel="stylesheet" href="css/zebra_tooltips.css" type="text/css"> 

<link href="css/index.css" rel="stylesheet" />
<link href="css/init.css" rel="stylesheet" />
<style type="text/css">
#mainContent .panel-body div{
    overflow: hidden;
    text-overflow: ellipsis;
    width: 100%;
    white-space: nowrap;
}
#mainContent .panel,#mainContent .panel-heading,#mainContent .panel-body,#mainContent .panel-footer{
	margin-bottom:0;
	padding-bottom:2px;
	padding-top:2px;
}
#mainContent .panel-heading{
	
}
</style>

</head>
<body data-spy="scroll" data-target="#myScrollspy" style="margin-top:30px;">
	<jsp:include page="nav.jsp" flush="true"></jsp:include>
	
	<div class="container" id="content">
		<div class="row clearfix">
			<div class="col-lg-2" id="myScrollspy">
				<div class="panel-group" id="accordion" data-spy="affix" data-offset-top="125">
							<div class="panel panel-group-header">
								<div class="panel-heading">
								<span class="glyphicon glyphicon-th-list"></span>
								</div>
							</div>
							<c:forEach items="${welcomeProfiles}" var="profiles" varStatus="xh">
								<div class="panel">
									<div class="panel-heading">
										<a data-toggle="collapse" data-parent="#accordion" href="#${xh.count}" class="profilesNav" >${profiles}</a>
									</div>
									<div id="${xh.count}" class="panel-collapse collapse ">
										<div class="panel-body" style="display: none;">
										</div>
									</div>
								</div>
							</c:forEach>
							<div class="panel-group-footer">
							</div>
						</div>
				</div>
				<div class="col-lg-7" id="content-center">
					<div class="carousel slide" id="carousel-930279">
						<ol class="carousel-indicators">
							<li class="active" data-slide-to="0"
								data-target="#carousel-930279"></li>
							<li data-slide-to="1" data-target="#carousel-930279"></li>
							<li data-slide-to="2" data-target="#carousel-930279"></li>
						</ol>
						<div class="carousel-inner">
							<div class="item active">
								<img alt="" src="img/default.jpg" />
								<div class="carousel-caption">
									<h4>First Thumbnail label</h4>
									<p>Cras justo odio, dapibus ac facilisis in, egestas eget
										quam. Donec id elit non mi porta gravida at eget metus. Nullam
										id dolor id nibh ultricies vehicula ut id elit.</p>
								</div>
							</div>
							<div class="item">
								<img alt="" src="img/default1.jpg" />
								<div class="carousel-caption">
									<h4>Second Thumbnail label</h4>
									<p>Cras justo odio, dapibus ac facilisis in, egestas eget
										quam. Donec id elit non mi porta gravida at eget metus. Nullam
										id dolor id nibh ultricies vehicula ut id elit.</p>
								</div>
							</div>
							<div class="item">
								<img alt="" src="img/default2.jpg" />
								<div class="carousel-caption">
									<h4>Third Thumbnail label</h4>
									<p>Cras justo odio, dapibus ac facilisis in, egestas eget
										quam. Donec id elit non mi porta gravida at eget metus. Nullam
										id dolor id nibh ultricies vehicula ut id elit.</p>
								</div>
							</div>
						</div>
						<a class="left carousel-control" href="#carousel-930279"
							data-slide="prev"><span
							class="glyphicon glyphicon-chevron-left"></span></a> <a
							class="right carousel-control" href="#carousel-930279"
							data-slide="next"><span
							class="glyphicon glyphicon-chevron-right"></span></a>
					</div>

					<ul id="myTab" class="nav nav-tabs">
						<li class="active"><a href="#profile" data-toggle="tab">
								最新</a></li>
						<li><a href="#activity" data-toggle="tab">感兴趣</a></li>
						<li><a href="#edit" data-toggle="tab">Edit Profile &amp;
								Settings</a></li>
					</ul>
					<ul class="content-text" id="mainContent">
						<c:forEach items="${topicViewPageMode.data}" var="topic">
						<li>
							<div class="panel" >
								<div class="panel-heading">
									<h3 class="panel-title">
										<a href="javaScript:void(0)" class="sessionName">${topic.sname }</a>
										<input type="hidden" class="sessionSid" value="${topic.tsid }">
									</h3>
								
									<a href="javaScript:;" class="topicTName " onclick="topicjumg(this,${topic.tsid})" >${topic.ttopic }</a>
									<input type="hidden" class="topicTid" value="${topic.tid }">
									<span class="glyphicon glyphicon-comment zebra_tips1" title="回帖数"></span> ${topic.treplycount}
								</div>
								<div class="panel-body">
									${topic.tcontents}									
								</div>
								<div class="panel-footer">
									<span class="glyphicon glyphicon-user "></span>
									<a href="javaScript:;" title="主题作者" target="_blank" class="zebra_tips1" onclick="touserjump(${topic.tuid})">${topic.uname}</a> 
									<span class="glyphicon glyphicon-time"></span>
									<span class="time zebra_tips1" title="发帖时间">${topic.ttime}</span>
								</div>
							</div>
						</li>
						</c:forEach>
					</ul>
					
				</div>

				<div class="col-lg-3" id="content-right">
					<div class="panel panel-info">
						<div class="panel-heading  text-center">
							<img class="img-circle" src="img/骑行.jpg" width="60" height="60" />
						</div>
						<div class="panel-body">
							<h3 class="panel-title">
								Favorite Tags<a href="#" class="small">edit</a>
							</h3>
							<div style="line-height: 25px;">
								<span class="label label-info">java</span> <span
									class="label label-info">javascript</span> <span
									class="label label-info">bootstrap</span> <span
									class="label label-info">json</span> <span
									class="label label-info">mysql</span> <span
									class="label label-info">java</span> <span
									class="label label-info">javascript</span> <span
									class="label label-info">bootstrap</span> <span
									class="label label-info">json</span> <span
									class="label label-info">mysql</span>
							</div>
						</div>
					</div>
					<div class="panel " id="HotQuestion">
					<div class="panel-heading">
						<h3 class="panel-title">热议</h3>
					</div>
					<div class="panel-body">
						<ul class=""> 
							<c:forEach items="${HotsTopics }" var="topic">
							
							<li>
								<span class="label label-success col-xs-2 zebra_tips1" title="回复人数:${topic.treplycount }">${topic.treplycount }</span>
								<a href="javaScript:;" class="col-xs-10" onclick="topicjumg(this,${topic.tsid})">${topic.ttopic}</a>
								<input type="hidden" class="topicTid" value="${topic.tid}">
							</li>
							</c:forEach>
						</ul>
					</div>
				</div>
				</div>
			</div>
		</div>

		
</body>
<!--  -->
<script type="text/javascript">
	$(function(){
		$('.profilesNav').click(function(){
			var obj = $(this).attr('href');
			var panelbody = $(obj).find('.panel-body');
			var profile = $(this).html();
			console.log(profile);
			var param ={
					'profile':profile,
					'op':'getSnameAndSid'
					}
			$.post('welcome',param,function(data){
				if(data == 'false'){
					alert('获取失败');
				}else{
					var sessions = JSON.parse(data);
					panelbody.empty();
					$.each(sessions,function(i,session){
						panelbody.append("<a href='javaScript:;' onclick='tosessionjump("+session.sid+")'>"+session.sname+"</a>");
					});
					panelbody.show(300);
				}
			});
		});
		
	});
</script>
<!-- 提示框 -->
<script type="text/javascript" src="js/zebra_tooltips.js"></script> 
<!-- 页面跳转 -->
<script type="text/javascript" src="js/GotoTopicOrSession.js"></script>
<!-- 图片放大器 -->
<script src="./js/postbird-img-glass.js"></script>
 <script>
        PostbirdImgGlass.init({
            domSelector:"#mainContent img",
            animation:true
        });
  </script>
</html>