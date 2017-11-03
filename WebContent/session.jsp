<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
				<img src="img/photo.jpg" />
			</div>
			<div class="page-header col-md-9">
				<h1>
					<span id="sessionName">java</span><a href="javaScript:void(0)" class="follow" id="follow"
						style="display: none;"><span>关注</span></a> <a class="unfollow"
						id="unfollow" href="javaScript:void(0)" style="">取消关注 </a> <small>关注:<span
						title="目前关注人数">4561</span>提问:<span title="目前问题数">1235</span>主题：<a
						href="javaScript:void(0)" title="分类依据">HTML/CSS</a></small>
				</h1>
				<p title="扼要描述">金钱与未来，你的选择是什么？</p>
			</div>
		</div>
		<div class="col-md-8" id="mainContent">
			<ul class="content-text">
				<li class="clearfix">
					<div class="col-xs-2">
						<div class="thumbsUp">
							<p title="回复条数">
								<span class="activeSpan">22</span><span class="glyphicon glyphicon-comment"></span>
							</p>
							<p title="被赞数目">
								<span class="activeSpan">2232</span><span class="glyphicon glyphicon glyphicon-thumbs-up"></span>
							</p>
							<p title="观看人数">
								<span class="activeSpan">2542</span><span
									class="glyphicon glyphicon glyphicon glyphicon-eye-open"></span>
							</p>
						</div>
					</div>
					<div class="panel col-xs-10">
						<div class="panel-heading">
							<a href="topic.html">题目sdf</a>
						</div>
						<div class="panel-body">
							<p>用起来感觉一般般，也可能是我带投石车的都不是高武武将吧。总是砸到自己人，</p>

						</div>
						<div class="panel-footer clearfix">
							<div style="float: right">
								<span class="glyphicon glyphicon-user"></span> <a
									href="user.jsp" title="提问者" target="_blank"> 1900lwy</a> <span
									class="glyphicon glyphicon-time"></span> <span class="time"
									title="提问时间">10月 10日 00:22</span>
							</div>
							<div style="float: left">
								<span class="glyphicon glyphicon glyphicon-comment"></span> <a
									href="user.jsp" title="最后回复人" target="_blank"> 1900lwy</a> <span
									class="glyphicon glyphicon-time"></span> <span class="time"
									title="最后回复时间">10月 10日 00:22</span>
							</div>
						</div>
					</div>
				</li>
				<li class="clearfix">
					<div class="col-xs-2">
						<div class="thumbsUp">
							<p title="回复条数">
								<span class="activeSpan">22</span><span class="glyphicon glyphicon-comment"></span>
							</p>
							<p title="被赞数目">
								<span class="activeSpan">2232</span><span class="glyphicon glyphicon glyphicon-thumbs-up"></span>
							</p>
							<p title="观看人数">
								<span class="activeSpan">2542</span><span
									class="glyphicon glyphicon glyphicon glyphicon-eye-open"></span>
							</p>
						</div>
					</div>
					<div class="panel col-xs-10">
						<div class="panel-heading">
							<a href="topic.html">题目sdf</a>
						</div>
						<div class="panel-body">
							<p>用起来感觉一般般，也可能是我带投石车的都不是高武武将吧。总是砸到自己人，用起来感觉一般般，也可能是我带投石车的都不是高武武将吧。总是砸到自己人，用起来感觉一般般，也可能是我带投石车的都不是高武武将吧。总是砸到自己人，</p>
							<img src="img/photo.jpg" style="width:25%">
							<img src="img/photo.jpg" style="width:25%">
							<img src="img/photo.jpg" style="width:25%">
						</div>
						<div class="panel-footer clearfix">
							<div style="float: right">
								<span class="glyphicon glyphicon-user"></span> <a
									href="user.jsp" title="提问者" target="_blank"> 1900lwy</a> <span
									class="glyphicon glyphicon-time"></span> <span class="time"
									title="提问时间">10月 10日 00:22</span>
							</div>
							<div style="float: left">
								<span class="glyphicon glyphicon glyphicon-comment"></span> <a
									href="user.jsp" title="最后回复人" target="_blank"> 1900lwy</a> <span
									class="glyphicon glyphicon-time"></span> <span class="time"
									title="最后回复时间">10月 10日 00:22</span>
							</div>
						</div>
					</div>
				</li>
			</ul>
			<div class="col-xs-10 col-xs-offset-2">
				<div id="topicTitle">
					题目<input type="text" id="topicTitleText" />
				</div>
				<div class="">
					<div id="topicText"></div>
				</div>
				<div>
					<a class="btn btn-danger" id="topicTextReset">重置</a><a
						class="btn btn-success" id="topicTextSubmit">提交</a>
				</div>
			</div>
		</div>
		<div class="col-md-4">
			<div class="column">
				<table>
					<tbody>
						<tr>
							<td>
								<p class="label-key">拥有者</p>
							</td>
							<td style="padding-left: 10px">
								<p class="label-key" title="2009-07-30 15:36:42Z">
									<b>刘伟艺</b>
								</p>
							</td>
						</tr>
						<tr>
							<td>
								<p class="label-key">起始点</p>
							</td>
							<td style="padding-left: 10px">
								<p class="label-key" title="2009-07-30 15:36:42Z">
									<b>8 years, 2 months ago</b>
								</p>
							</td>
						</tr>
						<tr>
							<td>
								<p class="label-key">总贴数</p>
							</td>

							<td style="padding-left: 10px">
								<p class="label-key">
									<b>259,352 times</b>
								</p>
							</td>
						</tr>
						<tr>
							<td>
								<p class="label-key">active</p>
							</td>
							<td style="padding-left: 10px">
								<p class="label-key">
									<b><a href="?lastactivity" class="lastactivity-link"
										title="2017-07-28 00:37:31Z">2 months ago</a></b>
								</p>
							</td>
						</tr>
					</tbody>
				</table>
			</div>

			<div class="panel " id="HotQuestion">
				<div class="panel-heading">
					<h3 class="panel-title">相关session</h3>
				</div>
				<div class="panel-body">
					<ul class="">
						<li><img src="img/骑行.jpg" alt="通用的占位符缩略图" width="40"
							height="40" class="col-xs-3"> <a href="#" class="col-xs-9">
								This is fake right? "FACEBOOK USER LOCATION FINDER"This is fake
								right? "FACEBOOK USER LOCATION FINDER"</a></li>
						<li><img src="img/骑行.jpg" alt="通用的占位符缩略图" width="40"
							height="40" class="col-xs-3"> <a href="#" class="col-xs-9">
								This is fake right? "FACEBOOK USER LOCATION FINDER"This is fake
								right? "FACEBOOK USER LOCATION FINDER"</a></li>
						<li><img src="img/骑行.jpg" alt="通用的占位符缩略图" width="40"
							height="40" class="col-xs-3"> <a href="#" class="col-xs-9">
								This is fake right? "FACEBOOK USER LOCATION FINDER"This is fake
								right? "FACEBOOK USER LOCATION FINDER"</a></li>
						<li><img src="img/骑行.jpg" alt="通用的占位符缩略图" width="40"
							height="40" class="col-xs-3"> <a href="#" class="col-xs-9">
								This is fake right? "FACEBOOK USER LOCATION FINDER"This is fake
								right? "FACEBOOK USER LOCATION FINDER"</a></li>
						<li><img src="img/骑行.jpg" alt="通用的占位符缩略图" width="40"
							height="40" class="col-xs-3"> <a href="#" class="col-xs-9">
								This is fake right? "FACEBOOK USER LOCATION FINDER"This is fake
								right? "FACEBOOK USER LOCATION FINDER"</a></li>
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
					toolbar : [ [ 'style', [ 'style' ] ],
							[ 'font', [ 'bold', 'underline', 'clear' ] ],
							[ 'fontname', [ 'fontname' ] ],
							[ 'color', [ 'color' ] ],
							[ 'para', [ 'paragraph' ] ],
							[ 'insert', [ 'link', 'picture' ] ],
							[ 'view', [ 'fullscreen', 'codeview', 'help' ] ] ],
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
		    console.log(data.get("file"));  
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
		    });  
		}  
	});
	$(function(){
		/*帖子内容重置*/
		$('#topicTextReset').click(function(){
			$('#topicText').summernote('code', "");
		});
		/*帖子提交*/
		$('#topicTextSubmit').click(function(){
			var sessionText = $('#topicText').summernote('code');
			var titleText = $('#topicTitleText').val();
			var sessionName = $('#sessionName').html();
			var nowUserName = $('#nowUserName').html();
			
			if(nowUserName==undefined){
				alert('请登录');
			}else{
				console.log('sessionname:'+sessionName+' username:'+nowUserName);
				/*$.ajax({
				type : "post",
				url : "Topic",
				data:{"op":"releaseTopic","titleText":titleText,"sessionText":sessionText,"sessionName":sessionName,"nowUserName":nowUserName},
				success:function(data){
					$('#mainContent>ul').prepend('<li><div class="col-xs-2"><div class="thumbsUp"><p title="回复条数">22&emsp;<span class="glyphicon glyphicon-comment"></span></p><p title="被赞数目">10&emsp;<span class="glyphicon glyphicon glyphicon-thumbs-up"></span></p><p title="观看人数">5333&emsp;<span class="glyphicon glyphicon glyphicon glyphicon-eye-open"></span></p></div></div><div class="panel col-xs-10"><div class="panel-heading"><a href="topic.html">题目'
							+ titleText
							+ '</a></div><div class="panel-body">'
							+ sessionText
							+ '</div><div class="panel-footer clearfix"><div style="float: right"><span class="glyphicon glyphicon-user"></span><a href="user.jsp" title="提问者" target="_blank"> 1900lwy</a><span class="glyphicon glyphicon-time"></span> <span class="time" title="提问时间">10月 10日 00:22</span></div><div style="float: left"><span class="glyphicon glyphicon glyphicon-comment"></span><a href="user.jsp" title="最后回复人" target="_blank"> 1900lwy</a><span class="glyphicon glyphicon-time"></span><span class="time" title="最后回复时间">10月 10日 00:22</span></div></div></div></li>');

					$('#topicText').summernote('code', "");
				}
				});//end ajax*/
			}
			
			
		});//end #topicTextSubmit
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		/*观看人数，赞数，评论数的淡入淡出*/
		$('#mainContent>ul>li').mousemove(function(){
			$(this).find('.activeSpan').stop();
			$(this).find('.activeSpan').animate({
			    right:'30px',
			    opacity:'1',
			    width:'60px'
			});
		});
		$('#mainContent>ul>li').mouseout(function(){
			$(this).find('.activeSpan').stop();
			$(this).find('.activeSpan').animate({
			    right:'0',
			    opacity:'0',
			    width:'0'
			});
		});
		
		/*关注*/
		$("#follow").click(function() {
			$(this).hide();
			$("#unfollow").show();
		});
		/*取消关注*/
		$("#unfollow").click(function() {
			$(this).hide();
			$("#follow").show();
		});
	});
</script>
</html>