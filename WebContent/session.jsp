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



<link href="css/session.css" rel="stylesheet" />
<link href="dist/summernote.css" rel="stylesheet" />

<link href="css/init.css" rel="stylesheet" />

<link rel="stylesheet" href="css/toastr.css" type="text/css"></link>
</head>
<body id="MyBody">
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
					
					
					<a href="javaScript:void(0)" class="follow" id="follow" style="display: none;"><span>关注</span></a>
					<a class="unfollow" id="unfollow" href="javaScript:void(0)" style="display: none;">取消关注 </a>
					
					 <small>
					 	关注:<span title="目前关注人数:${nowActiveSessionView.follow}" id="followCount" class="zebra_tips1">${nowActiveSessionView.follow}</span>
					 	提问:<span title="目前发帖数:${nowActiveSessionView.stopiccount}" class="zebra_tips1">${nowActiveSessionView.stopiccount}</span>
						 主题：<a href="javaScript:void(0)" title="分类依据:${nowActiveSessionView.sprofile}" class="zebra_tips1">${nowActiveSessionView.sprofile}</a>
					 </small>
				</h1>
				<p >${nowActiveSessionView.sstatement}<a href="javaScript:;" title="创建人:${nowActiveSessionView.uname}" class="zebra_tips1" style="color:#888;" onclick="touserjump(${nowActiveSessionView.smasterid})">——<span>${nowActiveSessionView.uname}</span></a>
				<c:if test="${nowActiveSessionView.smasterid == NowLoginUser.uid}">
					<a href="Session?op=toUpdateSession&sid=${nowActiveSessionView.sid}" >编辑</a>&nbsp;<a href="javaScript:;" id="deleteSession">删除</a>
				</c:if>			
				
				</p>
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
				<!-- 内容 -->
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
				
		<div class="col-md-4" style="padding:0;">
			<div class="panel " id="HotQuestion">
				<div class="panel-heading">
					<h3 class="panel-title">相关版块</h3>
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
						<li style="border-bottom:1px #e7e7e7 solid;">
							版名：<a href="javaScript:void(0)" class="sessionName">${session.sname }</a>
							<input type="hidden" value="${session.sid}" class="sessionSid">
							<br>
							<small style="color:#ababab;">描述：${session.sstatement}</small>
						</li>
					</c:forEach>
					</ul>
				</div>
			</div>

		</div>
	
	</div>
	

	
	<%@include file="footer.html" %>
</body>

<!-- 编辑，删除session -->
<script type="text/javascript">
 $(function(){
	 
	 $('#deleteSession').click(function(){
		 var msg = "您真的确定要删除该板块，并与之相关的东西吗？\n\n请确认！";
		 if (confirm(msg)==true){
			 var param = {
					'op':'deleteSession',
					'sid':$('#sessionSid').val()
			 }
			 $.post('Session',param,function(data){
				 if(data == 'false'){
					toastr.error('程序出错，无法删除');					 
				 }else{
					toastr.success('删除成功');	

					setTimeout(function(){location.href="welcome";},800);
					
				 }
			 });
		 }else{
			 toastr.error('删除被取消');
		 }
	 });
 });

</script>
<!-- 提示框 -->
<script type="text/javascript" src="js/zebra_tooltips.js"></script> 
<!-- 页面跳转 -->
<script type="text/javascript" src="js/GotoTopicOrSession.js"></script>
<!-- 富文本框 -->
<script src="dist/summernote.js"></script>
<script src="dist/lang/summernote-zh-CN.js"></script>
<!-- 分页 -->
<script type="text/javascript" src="js/jqPaginator.js"></script>
<script type="text/javascript" src="js/indexSpiltPage.js"></script>
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
			toastr.error('分页查询失败');
		}else{
			
			$('.content-text').empty();
			var topics = eval(data);
			$.each(topics,function(i,topic){
				var Mytext = topicContent(topic);
				$('.content-text').append(Mytext);
			});
			clickInit();
		}
	});
}

function topicContent(topic){
var myimgs = getImageSrc(topic.tcontents);
var mainContents = getMainContents(myimgs,topic.tcontents);
var contents = neatenContent(myimgs,mainContents)
var lastReply;
if(topic.treplycount!=0){
	lastReply = "<div style='float: left'><span class='glyphicon glyphicon glyphicon-comment'></span>"
		+ "<a href='javaScript:;' title='最后回复这个帖子的人:"+topic.lastreplyuser+"' target='_blank' class='zebra_tips6'> "
		+ topic.lastreplyuser
		+ "</a> <span class='glyphicon glyphicon-time'></span>"
		+ "<span class='time zebra_tips6' title='最后一次回复这个帖子的时间:"+topic.tlastreplaytime+"'>"
		+ topic.tlastreplaytime
		+ "</span></div>"
		+"</div></div></li>";
}else {
	lastReply="";
}

var text = "<li class='clearfix'><div class='col-xs-1'><div class='thumbsUp'><p title='回复条数' class='zebra_tips6'>"
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
			+ topic.uname 
			+ "</a></div>"
			+ lastReply;
	return text;
}
</script>
<!-- 富文本框，发布帖子 -->
<script type="text/javascript">
	/*富文本框初始化*/
	$(function() {
		/*初始化提示框*/
		toastr.options.positionClass = "toast-center";
		$('#topicText').summernote(
				{
					height : 200,
					tabsize : 2,
					lang : 'zh-CN',
					toolbar : [ 
							[ 'font', [ 'bold', 'underline', 'clear' ] ],
							[ 'color', [ 'color' ] ],
							[ 'insert', [ 'link', 'picture' ] ],
							['view', ['fullscreen', 'codeview', 'help']]
							 ],
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
				toastr.error('请登录');
			}else if(titleText==""){
				$('#topicTitleText').focus();
				toastr.success('请填写标题');
			}else if(sessionText==""||sessionText=="<p><br></p>"){
				$('#topicText').focus();
				toastr.info('请填写内容');
			}else{
				$.ajax({
					type : "post",
					url : "Topic",
					data:{"op":"releaseTopic","ttopic":titleText,"tcontents":sessionText,"tsid":sessionSid,"tuid":nowUserUid},
					success:function(data){
						if(data=="false"){
							toastr.error('发帖失败');
						}else{
							toastr.success('发帖成功');

							setTimeout(function(){location.reload();},800);
						}
					}
				});//end ajax
			}

		});//end #topicTextSubmit
	});
	
</script>
<!-- 关注和取消关注 -->
<script type="text/javascript">
//是否被关注 
function isBeFollow(uid){
	if(uid==undefined){
		showfollow();
	}else{
		var param={
				'op':'isBeFollow',
				'uid':uid,
				'sid':$('#sessionSid').val()
		}
		$.post('FollowAndUnfollow',param,function(data){
			if(data=="false"){
				showfollow();
			}else{
				showunfollow();
			}
		});
	}
}
//显示关注
function showfollow(){
	$("#follow").show();
	$("#unfollow").hide();
}
//显示取消关注
function showunfollow(){
	$("#follow").hide();
	$("#unfollow").show();
}
	$(document).ready(function() {
		
		isBeFollow($('#nowUserID').val());
		
		/*关注*/
		$("#follow").click(function() {
			if($('#nowUserName').html()==undefined){
				toastr.info('请登录');
			}else{
				var param = {
						"op":"follow",
						"sessionSid":$('#sessionSid').val(),
						"nowUserID" : $('#nowUserID').val()
					}
				$.post("FollowAndUnfollow",param,function(data){
					if(data=="true"){
						showunfollow();
						var num = $('#followCount').html();
						num++;//关注人数自增
						$('#followCount').html(num);
						toastr.success("关注成功");
					}else{
						toastr.error("关注失败，服务器错误！");
					}					
				});//end post
			}
		});//end click function
		/*取消关注*/
		$("#unfollow").click(function() {
			if($('#nowUserName').html()==undefined){
				toastr.info('请登录');
			}else{
				var param = {
						"op" :"unfollow",
						"sessionSid":$('#sessionSid').val(),
						"nowUserID" : $('#nowUserID').val()
					}
				$.post("FollowAndUnfollow",param,function(data){
					if(data=="true"){
						showfollow();
						var num = $('#followCount').html();
						num--;//关注人数自减
						$('#followCount').html(num);
						toastr.success("取消关注成功");
					}else{
						toastr.error("取消关注失败，服务器错误！");
					}									
				});//end post
			}
		});
	});//end ready 
</script>
<!-- 图片放大器 -->
<script src="./js/postbird-img-glass.js"></script>
<script type="text/javascript" src="js/toastr.js"></script>
</html>