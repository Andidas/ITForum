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
<title>版块</title>


<link href="css/init.css" rel="stylesheet" />
<link href="css/session.css" rel="stylesheet" />
<link href="dist/summernote.css" rel="stylesheet" />
<style type="text/css">
</style>
</head>
<body>
	<jsp:include page="nav.jsp" flush="true" />
	<div class="clearfix container" id="content">
		<div class="row-fluid clearfix" id="sessionHead">

			<div class="col-md-3" style="width: 230px">
				<c:if test="${empty nowActiveSessionView.session.spicture}">
					<img src="img/photo.jpg" />
				</c:if>
				<c:if test="${not empty nowActiveSessionView.session.spicture}">
					<img src="${nowActiveSession.spicture}" />
				</c:if>
			</div>
			<div class="page-header col-md-9">
				<h1>
					<span id="sessionName">${nowActiveSessionView.session.sname}</span><a href="javaScript:void(0)" class="follow" id="follow"
						style=""><span>关注</span></a> <a class="unfollow"
						id="unfollow" href="javaScript:void(0)" style="display: none;">取消关注 </a> <small>关注:<span
						title="目前关注人数">${nowActiveSessionView.follow}</span>提问:<span title="目前问题数">${nowActiveSessionView.session.stopiccount}</span>主题：<a
						href="javaScript:void(0)" title="分类依据">${nowActiveSessionView.session.sprofile}</a></small>
				</h1>
				<p title="扼要描述">${nowActiveSessionView.session.sstatement}<a href="#" title="创建人" style="color:#888;">——<span>${nowActiveSessionView.sessionMaster}</span></a></p>
			</div>
		</div>
		<div class="col-md-8" id="mainContent">
			<ul class="content-text">
	
				<c:forEach items="${nowActiveSessionView.topicViewList}" var="topicList">
					<li class="clearfix">
						<div class="col-xs-2">
							<div class="thumbsUp">
								<p title="回复条数">
									<span class="activeSpan">${topicList.topic.treplycount}</span><span class="glyphicon glyphicon-comment"></span>
								</p>
								<!--  <p title="被赞数目">
									<span class="activeSpan">2232</span><span class="glyphicon glyphicon glyphicon-thumbs-up"></span>
								</p>-->
								<p title="观看人数">
									<span class="activeSpan">${topicList.topic.tclickcount}</span><span
										class="glyphicon glyphicon glyphicon glyphicon-eye-open"></span>
								</p>
							</div>
						</div>
						<div class="panel col-xs-10">
							<div class="panel-heading">
								<a href="javaScript:void(0)" class="TopicTName" title="题目">${topicList.topic.ttopic}</a>
							</div>
							<div class="panel-body" title="内容">
								${topicList.topic.tcontents}
							</div>
							<div class="panel-footer clearfix">
								<div style="float: right">
									<span class="glyphicon glyphicon-user"></span> <a
										href="user.jsp" title="提问者" target="_blank">${topicList.userName}</a>
								</div>
								<c:if test="${topicList.topic.tlastreplyuseid !=0}">
									<div style="float: left">
										<span class="glyphicon glyphicon glyphicon-comment"></span> <a
											href="user.jsp" title="最后回复人" target="_blank">${topicList.lastReplyUserName}</a> <span
											class="glyphicon glyphicon-time"></span> <span class="time"
											title="最后回复时间">${topicList.topic.tlastreplaytime}</span>
									</div>
								</c:if>
							</div>
						</div>
					</li>
				</c:forEach>
			</ul>
			<div class="col-xs-10 col-xs-offset-2" id="releaseTopic">
				<div id="topicTitle" class="topicTitle">
					<input type="text" id="topicTitleText" placeholder="请输入题目"/>
				</div>
				<div id="topicText"></div>
				<div>
					<a class="btn btn-success" id="topicTextSubmit">发表</a>
				</div>
			</div>
		</div>
		<div class="col-md-4">
			<div class="panel " id="HotQuestion">
				<div class="panel-heading">
					<h3 class="panel-title">相关session</h3>
				</div>
				<div class="panel-body">
					<ul>
					<c:forEach items="${nowActiveSessionView.sameSprofile}" var="session">
						<li><a href="javaScript:void(0)" class="sessionName">${session.sname }</a></li>
					</c:forEach>
					</ul>
				</div>
			</div>

		</div>
	
	</div>
	
</body>
<script src="dist/summernote.js"></script>
<script src="dist/lang/summernote-zh-CN.js"></script>
<!-- 中文-->
<script>
	/*发布帖子，输入框初始化*/
	$(function() {
		$('#topicText').summernote(
				{
					height : 200,
					tabsize : 2,
					lang : 'zh-CN',
					toolbar : [ //[ 'style', [ 'style' ] ],
							[ 'font', [ 'bold', 'underline', 'clear' ] ],
							//[ 'fontname', [ 'fontname' ] ],
							[ 'color', [ 'color' ] ],
							//[ 'para', [ 'paragraph' ] ],
							[ 'insert', [ 'link', 'picture' ] ],
							[ 'view', [ 'fullscreen'//, 'codeview', 'help' 
							            ] ] ],
					
					callbacks: {  
			            onImageUpload: function(files) { //the onImageUpload API  
			                img = sendFile(files[0]);  
			       		 } 
					}
				});
		/*把图片存在服务器*/
		function sendFile(file) {  
		    data = new FormData();  
		    data.append("file", file);  
		    //console.log(data.get("file"));  
		    $.ajax({  
		        type: "POST",  
		        url: "UploadFileTopic",  
		        data: data, 
		        cache: false,  
		        contentType: false,  
		        processData: false,  
		        success: function(url) {
		              $("#topicText").summernote('insertImage', url, 'image name');   
		        }  
		    });//end ajax
		}  
	});//end 输入框初始化
	$(function(){
		/*帖子提交*/
		$('#topicTextSubmit').click(function(){
			var sessionText = $('#topicText').summernote('code');
			var titleText = $('#topicTitleText').val();
			var sessionName = $('#sessionName').html();
			var nowUserName = $('#nowUserName').html();
			
			if(nowUserName==undefined){
				alert('请登录');
			}else if(titleText==""){
				$('#topicTitleText').focus();
				alert('请填写标题');
			}else if(sessionText==""||sessionText=="<p><br></p>"){
				$('#topicText').focus();
				alert('请填写内容');
			}else{
				console.log('titleText:'+titleText+' sessionText'+sessionText+' sessionname:'+sessionName+' username:'+nowUserName);
				$.ajax({
					type : "post",
					url : "Topic",
					data:{"op":"releaseTopic","ttopic":titleText,"tcontents":sessionText,"sname":sessionName,"uname":nowUserName},
					success:function(data){
						//console.log(data);
						$('#topicTitleText').val("");
						$('#topicText').summernote('code', "");
						$('#mainContent>ul').prepend(data);
						/*topic的跳转*/
						$('.TopicTName').click(function(){
							location.href="Topic?op=toTopic&TopicTName="+$(this).html();
						});
								
					}
				});//end ajax
			}

		});//end #topicTextSubmit
	});
</script>
<script type="text/javascript" src="js/GotoTopicOrSession.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		/*关注*/
		$("#follow").click(function() {
			if($('#nowUserName').html()==undefined){
				alert('请登录');
			}else{
				var param = {
						"op":"follow",
						"sessionName":$('#sessionName').html(),
						"userName" : $('#nowUserName').html()
					}
				$.post("FollowAndUnfollow",param,function(data){
					if(data=="true"){
						$("#follow").hide();
						$("#unfollow").show();
					}else{
						alert("关注失败，服务器错误！");
					}					
				});//end post
			}
		});//end click function
		/*取消关注*/
		$("#unfollow").click(function() {
			if($('#nowUserName').html()==undefined){
				alert('请登录');
			}else{
				var param = {
						"op" :"unfollow",
						"sessionName":$('#sessionName').html(),
						"userName" : $('#nowUserName').html()
					}
				$.post("FollowAndUnfollow",param,function(data){
					if(data=="true"){
						$("#unfollow").hide();
						$("#follow").show();
					}else{
						alert("取消关注失败，服务器错误！");
					}									
				});//end post
			}
		});
	});//end ready function
</script>
</html>