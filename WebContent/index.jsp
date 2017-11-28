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
<link href="css/loadingButton.css" rel="stylesheet">

</head>
<body data-spy="scroll" data-target="#myScrollspy" id="MyBody">
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
						
					</ul>
					<ul class="content-text" id="mainContent">
						<!-- content -->
					</ul>
					
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
				</div>

				<div class="col-lg-3" id="content-right">
					<c:if test="${!empty sessionScope.NowLoginUser.uemail}">
					<div class="panel panel-info" id="userinfo">
						<div class="panel-heading  text-center">
							<img class="img-circle" src="<c:if test="${not empty sessionScope.NowLoginUser.uhead}"><%=basePath%>files/${sessionScope.NowLoginUser.uhead}</c:if><c:if test="${empty sessionScope.NowLoginUser.uhead}"><%=basePath%>files/ITForum.jpg</c:if>" width="60" height="60" />
						</div>
						<div class="panel-body">
							<h3 class="panel-title">
								关注
							</h3>
							<div style="line-height: 25px;">
								<c:forEach items="${userFollowSession}" var="follow">
									<a href="javaScript:;" class="label label-success" onclick="tosessionjump(${follow.sid})">
										${follow.sname}
									</a>									
								</c:forEach>
							</div>
						</div>
					</div>
					</c:if>
					
					<c:if test="${empty sessionScope.NowLoginUser.uemail}">
					<%@include file="MyLogin.html" %>						
					</c:if>
					<div class="panel " id="HotQuestion">
					<div class="panel-heading">
						<h3 class="panel-title">热议</h3>
					</div>
					<div class="panel-body">
						<ul class=""> 
							<c:forEach items="${HotsTopics }" var="topic">
							<li>
								<span class="label label-success col-xs-2 zebra_tips4" title="回复人数:${topic.treplycount }">${topic.treplycount }</span>
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
<%@include file="footer.html" %>
		
</body>
<!-- 加载更多 -->
<script type="text/javascript" src="js/indexSpiltPage.js"></script>
<script type="text/javascript">
	$(function(){
		loadedMore();
		$("#showMore").click(loadedMore);
	});
	  
function loadedMore(){
	hide_show($("#showMore"),$("#loadEffect"));
	
	var nowPageNo = $("#nowPageNo").val();
	var param = {
			'op':'findTopicByPage',
			'pageno':nowPageNo
	}
	$.post('welcome',param,function(data){
		if(data=="false"){
			setTimeout('hide_MoreBtn_LoadBtn()',1000);
		}else{
			
			hide_show($("#loadEffect"),$("#showMore"));
			
			var topics = JSON.parse(data);
			$.each(topics,function(i,topic){
				var content=topicContent(topic);
				$('#mainContent').append(content);
			});
			nowPageNo++;
			$("#nowPageNo").val(nowPageNo);
			
			$("[data-toggle='tooltip']").tooltip();
			//按钮点击
			$('.sessionName').unbind('click',sessionName);
			$('.TopicTName').unbind('click',TopicTName);
			$('.sessionName').click(sessionName);
			$('.TopicTName').click(TopicTName);
			//图片放大器
			PostbirdImgGlass.init({
		        domSelector:"#mainContent img",
		        animation:true
		    });
		}
	});
}
function hide_show(obj_x,obj_y){
	obj_x.hide();
	obj_y.show();
}
function hide_MoreBtn_LoadBtn(){
	$("#showMore").hide();
	$("#loadEffect").hide();
}
function topicContent(topic){
	var myimgs = getImageSrc(topic.tcontents);
	var mainContents = getMainContents(myimgs,topic.tcontents);
	var contents = neatenContent(myimgs,mainContents)
	var lastReply;
	if(topic.treplycount!=0){
		lastReply = '<div class="lastRelpy"><a href="javaScript:;" title="最后回帖人:'
			+topic.lastreplyuser
			+'<br>回复时间:'
			+topic.tlastreplaytime
			+'" target="_blank" class="" data-toggle="tooltip" onclick="touserjump('
			+topic.tlastreplyuseid
			+')"><span class="glyphicon glyphicon-comment"></span> '
			+topic.lastreplyuser
			+'</span></div>';
	}else{
		lastReply=" ";
	}
	
	var text ='<li><div class="panel" ><div class="panel-heading">'
		+'<a href="javaScript:void(0)" class="sessionName " onclick="tosessionjump('+topic.tsid+')" style="color:black;margin-right:15px;">'
			+topic.sname
			+'</a><input type="hidden" class="sessionSid" value="'
			+topic.tsid 
			+'"><a href="javaScript:;" class="topicTName" data-toggle="tooltip" title="题目" onclick="topicjumg(this,'
			+topic.tsid
			+')" >'
			+topic.ttopic 
			+'</a><input type="hidden" class="topicTid" value="'
			+topic.tid 
			+'"></div><div class="panel-body">'
			+contents	
			+'</div><div class="author">'
			+'<a href="javaScript:;" title="发帖人:'
			+topic.uname
			+'" target="_blank" class="" data-toggle="tooltip" onclick="touserjump('
			+topic.tuid
			+')"><span class="glyphicon glyphicon-user "></span> '
			+topic.uname
			+'</a></span></div>'
			+lastReply
			+'</div></li>';
		return text;
	}
</script>
<!-- 左边导航栏 -->
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