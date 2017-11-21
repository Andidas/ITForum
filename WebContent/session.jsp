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
<!-- 提示框 -->
<link rel="stylesheet" href="css/zebra_tooltips.css" type="text/css"> 
</head>
<body >
	<jsp:include page="nav.jsp" flush="true" />
	<div class="clearfix container" id="content">
		<div class="row-fluid clearfix" id="sessionHead">

			<div class="col-md-3" style="width: 230px">
				<c:if test="${empty nowActiveSessionView.spicture}">
					<img src="img/ITForum.jpg" />
				</c:if>
				<c:if test="${not empty nowActiveSessionView.spicture}">
					<img src="files/${nowActiveSessionView.spicture}" />
				</c:if>
			</div>
			<div class="page-header col-md-9">
				<h1>
					<span id="sessionName" class="sessionName">${nowActiveSessionView.sname}</span>
					<input type="hidden" id ="sessionSid" class="sessionSid" value="${nowActiveSessionView.sid}">
					
					<a href="javaScript:void(0)" class="follow" id="follow" ><span>关注</span></a>
					<a class="unfollow" id="unfollow" href="javaScript:void(0)" style="display: none;">取消关注 </a>
					 <small>
					 	关注:<span title="目前关注人数:${nowActiveSessionView.follow}" id="followCount" class="zebra_tips1">${nowActiveSessionView.follow}</span>
					 	提问:<span title="目前发帖数:${nowActiveSessionView.stopiccount}" class="zebra_tips1">${nowActiveSessionView.stopiccount}</span>
						 主题：<a href="javaScript:void(0)" title="分类依据:${nowActiveSessionView.sprofile}" class="zebra_tips1">${nowActiveSessionView.sprofile}</a>
					 </small>
				</h1>
				<p >${nowActiveSessionView.sstatement}<a href="javaScript:;" title="创建人:${nowActiveSessionView.uname}" class="zebra_tips1" style="color:#888;" onclick="touserjump(${nowActiveSessionView.smasterid})">——<span>${nowActiveSessionView.uname}</span></a></p>
			</div>
		</div>
			
		<div class="col-md-8" id="mainContent">
				<c:if test="${empty nowActiveSessionView.topicViewPM.data}">
					<div class="row clearfix">
						<div class="col-md-12 column">
							<div class="jumbotron">
								<h2>
									您好， 暂时无人发帖~
								</h2>
								<small>
									您将成为第一个发帖人！<a href="javaScript:;" onclick="jumpEveryWhere('#releaseTopic')">发帖</a>
								</small>
							</div>
						</div>
					</div>
				</c:if>
			<ul class="content-text clearfix" >
				
				<c:forEach items="${nowActiveSessionView.topicViewPM.data}" var="topicList" >
					<li class="clearfix ">
						<div class="col-xs-1">
							<div class="thumbsUp">
								<p title="回复条数:${topicList.treplycount}" class="zebra_tips1">
									<span class="activeSpan">${topicList.treplycount}</span><span class="glyphicon glyphicon-comment"></span>
								</p>
								<!--  <p title="被赞数目" class="zebra_tips1">
									<span class="activeSpan">2232</span><span class="glyphicon glyphicon glyphicon-thumbs-up"></span>
								</p>-->
								<p title="观看人数:${topicList.tclickcount}" class="zebra_tips1">
									<span class="activeSpan">${topicList.tclickcount}</span><span
										class="glyphicon glyphicon glyphicon glyphicon-eye-open"></span>
								</p>
							</div>
						</div>
						<div class="panel col-xs-11">
							<div class="panel-heading">
								<a href="javaScript:void(0)" class="TopicTName" >${topicList.ttopic}</a>
								<input type="hidden" class="topicTid" value="${topicList.tid}">
							</div>
							<div class="panel-body" >
								${topicList.tcontents}
							</div>
							<div class="panel-footer clearfix">
								<div style="float: right">
									<span class="glyphicon glyphicon-user"></span> 
									<a href="javaScript:;" title="谁发了这个贴:${topicList.uname}" target="_blank" class="zebra_tips1" onclick="touserjump(${topicList.tuid})">${topicList.uname}</a>
								</div>
								<c:if test="${topicList.treplycount!=0}">
									<div style="float: left">
										<span class="glyphicon glyphicon glyphicon-comment"></span> 
										<a href="javaScript:;" title="最后回复这个帖子的人:${topicList.lastreplyuser}" target="_blank" class="zebra_tips1" onclick="touserjump(${topicList.tlastreplyuseid})">${topicList.lastreplyuser}</a> 
										<span class="glyphicon glyphicon-time"></span> 
										<span class="time zebra_tips1" title="最后一次回复这个帖子的时间:${topicList.tlastreplaytime}" >${topicList.tlastreplaytime}</span>
									</div>
								</c:if>
							</div>
						</div>
					</li>
				</c:forEach>
			</ul>
			
			<ul class="pagination" id="pagination"></ul>
			<input type="hidden" id="SessiontotalPageCount" value="${nowActiveSessionView.topicViewPM.totalPageCount}">
   			<input type="hidden" id="Sessionpagesize" value="${nowActiveSessionView.topicViewPM.pageParam.pagesize }">
	
			<div class="col-xs-12" id="releaseTopic">
				<div id="topicTitle" class="topicTitle">
					<input type="text" id="topicTitleText" placeholder="请输入题目"/>
				</div>
				<div id="topicText"></div>
				<div>
					<a class="btn btn-success" id="topicTextSubmit">发表</a>
				</div>
			</div>
		</div>
				
		<div class="col-md-4" style="padding-left:0;">
			<div class="panel " id="HotQuestion">
				<div class="panel-heading">
					<h3 class="panel-title">相关session</h3>
				</div>
				<div class="panel-body">
					<ul>
					<c:if test="${empty nowActiveSessionView.sameSprofile}">
						<li>
							无相关的版块
							<a href="Session?op=toNewSession">赶快来成为版主吧？</a>
						</li>
					</c:if>
					<c:forEach items="${nowActiveSessionView.sameSprofile}" var="session">
						<li><a href="javaScript:void(0)" class="sessionName">${session.sname }</a>
							<input type="hidden" value="${session.sid}" class="sessionSid">
							<br>
							<span>${session.sstatement}</span>
						</li>
					</c:forEach>
					</ul>
				</div>
			</div>

		</div>
	
	</div>
	
			
</body>
<!-- 提示框 -->
<script type="text/javascript" src="js/zebra_tooltips.js"></script> 
<!-- 页面跳转 -->
<script type="text/javascript" src="js/GotoTopicOrSession.js"></script>
<!-- 富文本框 -->
<script src="dist/summernote.js"></script>
<script src="dist/lang/summernote-zh-CN.js"></script>
<!-- 分页 -->
<script type="text/javascript" src="js/jqPaginator.js"></script>
<!-- 回复的分页查询 -->
<script type="text/javascript">
var spc = parseInt($('#SessiontotalPageCount').val());
var spp = parseInt($('#Sessionpagesize').val());

$.jqPaginator('#pagination', {
    totalPages: spc,
    visiblePages:spp,
    currentPage: 1,
    onPageChange: function (num, type) {
        findPage(num);
    }
});
function findPage(pageno){
	var param ={
		'op':'findTopicByPage',
		'pageno':pageno,
		'sessionSid':$('#sessionSid').val()
	}
	$.post("Session",param,function(data){
		if(data=="false"){
			alert('分页查询失败');
		}else{
			
			$('.content-text').empty();
			var topics = eval(data);
			$.each(topics,function(i,topic){
				var Mytext = topicContent(topic);
				$('.content-text').append(Mytext);
			});
			//TopicTName function is exist in GotoTopicOrSession.js
			$('.TopicTName').click(TopicTName);
			//图片放大器
			PostbirdImgGlass.init({
	            domSelector:"#mainContent img",
	            animation:true
	        });
			//提示框初始化
			new $.Zebra_Tooltips($('.zebra_tips6'),{
				'position': 'right'
			});
			new $.Zebra_Tooltips($('.zebra_tips7'),{
				'position': 'left'
			});
			jumpEveryWhere('#');
		}
	});
}
//得到图像数组'<img ...>,<img ...>,<img ...>'
function getImageSrc(content){
	var contentCopy = content;
	var totalImg;
	if(contentCopy.match(eval("/<img/ig"))){
		totalImg= contentCopy.match(eval("/<img/ig")).length;//一共有几张图
	}else{
		totalImg=0;
	}
	var myimg=new Array();//数组对象
	for(var i=0;i<totalImg;i++){
		var begin = contentCopy.indexOf('<img');
		var end = contentCopy.substring(begin).indexOf('>') + begin +1;
		myimg[i] = contentCopy.substring(begin,end);
		contentCopy = contentCopy.substring(end);
		//console.log(' '+i+":"+myimg[i]);
	}
	return myimg;
}
//得到内容，不包含图片
function getMainContents(imgs,content){
	var contentCopy = content;
	for(var i =0;i<imgs.length;i++){
		contentCopy = contentCopy.replace(imgs[i],'');
	}
	//console.log('main contents:'+contentCopy);
	return contentCopy;
}
//把图片和文字整合在一起
function neatenContent(imgs,content){
	var lastContent = '<div style="max-height:60px;" title="简略内容,请点击题目进入主贴!" class="zebra_tips7">'+content+'</div><div>';
	for(var i =0;i<imgs.length;i++){
		lastContent = lastContent+imgs[i].replace('style','styleOld').replace('<img','<img width="137" height="137"');
	}
	lastContent =lastContent+'</div>';
	//console.log(lastContent);
	return lastContent;
}
function topicContent(topic){
var myimgs = getImageSrc(topic.tcontents);
var mainContents = getMainContents(myimgs,topic.tcontents);
var contents = neatenContent(myimgs,mainContents)
var text = "<li class='clearfix'><div class='col-xs-2'><div class='thumbsUp'><p title='回复条数' class='zebra_tips6'>"
			+ "<span class='activeSpan'>"
			+ topic.treplycount
			+ "	</span><span class='glyphicon glyphicon-comment'></span>"
			+ "</p><p title='观看人数:"+topic.tclickcount+"' class='zebra_tips6'><span class='activeSpan'>"
			+ topic.tclickcount
			+ "</span><span class='glyphicon glyphicon glyphicon glyphicon-eye-open'></span></p></div>"
			+ "</div><div class='panel col-xs-10'><div class='panel-heading'>"
			+ "<a href='javaScript:void(0)' class='TopicTName'>"
			+ topic.ttopic
			+ "</a><input type='hidden' class='topicTid' value='"
					+topic.tid
					+"'></div><div class='panel-body'>"
			+ contents
			+ "</div><div class='panel-footer clearfix'><div style='float: right'>"
			+ "<span class='glyphicon glyphicon-user'></span> "
			+ "	<a href='javaScript:;' title='谁发了这个贴:"+topic.uname+"' target='_blank' class='zebra_tips6' onclick='touserjump("+topic.tuid+")'>"
			+ topic.uname + "</a></div><c:if test='" + topic.treplycount != 0
			+ "'><div style='float: left'><span class='glyphicon glyphicon glyphicon-comment'></span>"
			+ "<a href='javaScript:;' title='最后回复这个帖子的人:"+topic.lastreplyuser+"' target='_blank' class='zebra_tips6'>"
			+ topic.lastreplyuser
			+ "</a> <span class='glyphicon glyphicon-time'></span>"
			+ "<span class='time zebra_tips6' title='最后一次回复这个帖子的时间:"+topic.tlastreplaytime+"'>"
			+ topic.tlastreplaytime
			+ "</span></div></c:if></div></div></li>";
	return text;
}
</script>
<!-- 富文本框，发布帖子 -->
<script type="text/javascript">
	/*富文本框初始化*/
	$(function() {
		$('#topicText').summernote(
				{
					height : 200,
					tabsize : 2,
					lang : 'zh-CN',
					toolbar : [ 
							[ 'font', [ 'bold', 'underline', 'clear' ] ],
							[ 'color', [ 'color' ] ],
							[ 'insert', [ 'link', 'picture' ] ],
							[ 'view', [ 'fullscreen' ] ] ],
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
	});//end 富文本框初始化
	$(function(){
		/*帖子提交*/
		$('#topicTextSubmit').click(function(){
			var sessionText = $('#topicText').summernote('code');
			var titleText = $('#topicTitleText').val();
			var nowUserName = $('#nowUserName').html();
			var sessionSid = $('#sessionSid').val();//当前session的id
			var nowUserUid = $('#nowUserID').val();
			if(nowUserName==undefined){
				alert('请登录');
			}else if(titleText==""){
				$('#topicTitleText').focus();
				alert('请填写标题');
			}else if(sessionText==""||sessionText=="<p><br></p>"){
				$('#topicText').focus();
				alert('请填写内容');
			}else{
				$.ajax({
					type : "post",
					url : "Topic",
					data:{"op":"releaseTopic","ttopic":titleText,"tcontents":sessionText,"tsid":sessionSid,"tuid":nowUserUid},
					success:function(data){
						if(data=="false"){
							alert('发帖失败');
						}else{
							alert('发帖成功');
						location.reload();//重新加载本页面
						}
					}
				});//end ajax
			}

		});//end #topicTextSubmit
	});
	
</script>
<!-- 关注和取消关注 -->
<script type="text/javascript">
	$(document).ready(function() {
		/*关注*/
		$("#follow").click(function() {
			if($('#nowUserName').html()==undefined){
				alert('请登录');
			}else{
				var param = {
						"op":"follow",
						"sessionSid":$('#sessionSid').val(),
						"nowUserID" : $('#nowUserID').val()
					}
				$.post("FollowAndUnfollow",param,function(data){
					if(data=="true"){
						$("#follow").hide();
						$("#unfollow").show();
						var num = $('#followCount').html();
						num++;//关注人数自增
						$('#followCount').html(num);
						alert("关注成功");
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
						"sessionSid":$('#sessionSid').val(),
						"nowUserID" : $('#nowUserID').val()
					}
				$.post("FollowAndUnfollow",param,function(data){
					if(data=="true"){
						$("#unfollow").hide();
						$("#follow").show();
						var num = $('#followCount').html();
						num--;//关注人数自减
						$('#followCount').html(num);
						alert("取消关注成功");
					}else{
						alert("取消关注失败，服务器错误！");
					}									
				});//end post
			}
		});
	});//end ready 
</script>
<!-- 图片放大器 -->
<script src="./js/postbird-img-glass.js"></script>

</html>