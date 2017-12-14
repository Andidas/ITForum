<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" deferredSyntaxAllowedAsLiteral="false"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
<title>主贴</title>
<!-- 提示框 -->
<link rel="stylesheet" href="css/zebra_tooltips.css" type="text/css"> 
<!-- 初始化 -->
<link href="css/init.css" rel="stylesheet" />
<!--  -->
<link href="css/topic.css" rel="stylesheet" />
<!-- 富文本框 -->
<link href="dist/summernote.css" rel="stylesheet" />
</head>
<body id="MyBody">
<jsp:include page="nav.jsp" flush="true"></jsp:include>
	<div class="container" id="content">
		<div class="row clearfix">
			<div class="col-lg-12 page-header" style="margin-top:0;">
				<h2 class="col-lg-12">
				<span class="TopicTName" id="nowTopicName" >${nowActiveTopicView.ttopic}</span>
				<input type="hidden" value="${nowActiveTopicView.tid}" id="nowTopicTid" class="topicTid"/>
				<c:if test="${nowActiveTopicView.tuid == NowLoginUser.uid}">
				<small><a href="javaScript:;" onclick="deleteTopic(${nowActiveTopicView.tid})">删除</a></small> 
				</c:if>
				</h2>
				<a href="javaScript:void(0)" class="col-lg-12 pull-right" >-
					<span class="sessionName">${nowActiveTopicView.sname}</span>
					<input type="hidden" value="${nowActiveTopicView.tsid}" class="sessionSid" id="sessionSid"/>
				</a>
			</div>
			
			<div class="col-md-8  column">
				<div class="answer" id="questionMain">
					<table>
						<tbody>
							<tr>
								
								<td class="answercell" >
									<div class="post-text" >
										${nowActiveTopicView.tcontents}
									</div>
									<div class="fw">
										<div class="post-signature" style="background-color:#eee;">
											<div class="user-info ">
												<div class="user-action-time">
													发表时间： <span title="发表时间:${nowActiveTopicView.ttime}"
														class="relativetime zebra_tips1">${nowActiveTopicView.ttime}</span>
												</div>
												<div class="user-gravatar32">
													<a href="user.html">
														<img src="img/17883626.jpg" alt="" width="32" height="32">
													</a>
												</div>
												<div class="user-details">
													<a href="javaScript:;" title="发帖人:${nowActiveTopicView.uname}" class="zebra_tips1" onclick="touserjump(${nowActiveTopicView.tuid})">${nowActiveTopicView.uname}</a>
													<div class="hide">
													
														<span title="用户当前积分: "
															class="reply_tips">1</span><span title="用户是否是版主："
															class="reply_tips">1</span>
													</div>
												</div>
											</div>
										</div>

									</div>
								</td>
							</tr>
							
						</tbody>
					</table>
				</div>
				<ul id="Tabson" class="nav nav-tabs" style="background: #00BCD4;">
						<li >
							<h4 style="color:#fff;">&nbsp;${ReplyPage.totalRecordCount} &nbsp;条回复</h4>
						</li>
						
				</ul>
				<div class="answers">
				<!--<c:forEach items="${ReplyPage.data}" var="reply">
					<div class="answer">
						<table>
							<tbody>
								<tr>
									<td class="votecell">
										<div class="vote hide">
											 <span class="date-dz-z pull-left">
    										<i class="date-dz-z-click-red zebra_tips1"  title="点赞，可以加该贴的排名"></i><i class="z-num">${reply.rfavour}</i></span>
										</div>
									</td>
									<td class="answercell">
										<div>${reply.rcontent}</div>
										<div class="fw">
											<div class="post-signature">
												<div class="user-info ">
													<div class="user-action-time">
														回复时间： <span title="回复时间:${reply.rtime}" class="zebra_tips1">${reply.rtime}</span>
													</div>
													<div class="user-gravatar32">
														<a href="javaScript:;">
																<img src="img/17883626.jpg" width="32" height="32">
														</a>
													</div>
													<div class="user-details">
														<a href="javaScript:;" title="回帖人:${reply.uname}" class="zebra_tips1" onclick="touserjump(${reply.ruid})">${reply.uname}</a>
														<div>
															<span title="用户当前状态:${reply.ustate}" class="zebra_tips1">${reply.ustate}</span>
															<span title="用户当前积分:${reply.upoint}" class="zebra_tips1">${reply.upoint}</span>
															<span title="用户是否是版主:${reply.uissectioner}" class="zebra_tips1">${reply.uissectioner}</span>
														</div>
													</div>
												</div>
											</div>

										</div>
									</td>
								</tr>

								<tr>
									<td class="votecell"></td>
									<td>
										<div class="comments ">
											<table>
												<tbody>
												</tbody>
											</table>
										</div>
										<div>
											<a class="comments-link replyComment">回复</a>
											
										</div>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
					
					</c:forEach>-->
				</div>
				
   				<ul class="pagination" id="pagination"></ul>
   				<input type="hidden" id="ReplytotalPageCount" value="${ReplyPage.totalPageCount}">
   				<input type="hidden" id="Replypagesize" value="${ReplyPage.pageParam.pagesize}">
   				
				<div id="summernoteReply" ></div>
				<a class="btn btn-success" id="ReplyTopic">回复</a>
				
			</div>
			<div class="col-md-4 column">
				<div class="module question-stats">
					<table id="qinfo">
						<tbody>
							<tr>
								<td>
									<p class="label-key">观看人数：</p>
								</td>

								<td style="padding-left: 10px">
									<p class="label-key">
										<b class="zebra_tips1" title="观看人数:${nowActiveTopicView.tclickcount}"><a href="javaScript:;">${nowActiveTopicView.tclickcount} 人</a></b>
									</p>
								</td>
							</tr>
							<tr>
								<td>
									<p class="label-key">最后回帖：</p>
								</td>
								<td style="padding-left: 10px">
									<p class="label-key">
										<b><a class="lastactivity-link zebra_tips1"
											title="最后回复时间:${nowActiveTopicView.tlastreplaytime}">${nowActiveTopicView.tlastreplaytime}</a></b>
									</p>
								</td>
							</tr>
							<tr>
								<td>
									<p class="label-key">回帖用户：</p>
								</td>
								<td style="padding-left: 10px">
									<p class="label-key">
										<b><a class="lastactivity-link zebra_tips1" onclick="touserjump(${nowActiveTopicView.tlastreplyuseid})"
											title="最后回复用户:${nowActiveTopicView.lastreplyuser}">${nowActiveTopicView.lastreplyuser}</a></b>
									</p>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="panel" id="HotQuestion">
					<div class="panel-heading" style="margin-top:0;background: #00BCD4;">
						<h3 class="panel-title" style="color:#fff;">相关</h3>
					</div>
					<div class="panel-body">
						<ul class=""> 
							<c:forEach items="${nowActiveTopicView.sameTopic}" var="sametopic">
								<li>
									<span class="label label-success col-xs-1 zebra_tips1" title="回复人数:${sametopic.treplycount }">${sametopic.treplycount }</span>
									<a href="javaScript:;" class="col-xs-11" onclick="topicjumg(this,${nowActiveTopicView.tsid})">${sametopic.ttopic}</a>
									<input type="hidden" class="topicTid" value="${sametopic.tid}">
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
<!-- 日起转换s -->
<script type="text/javascript" src="js/transform_time.js"></script>
<!-- 页面跳转 -->
<script type="text/javascript" src="js/GotoTopicOrSession.js"></script>
<!-- 富文本框 -->
<script src="dist/summernote.js"></script>
<script src="dist/lang/summernote-zh-CN.js"></script>
<!-- 分页 -->
<script type="text/javascript" src="js/jqPaginator.js"></script>
<!-- 回复的分页查询 -->
<script type="text/javascript">
	var rpc = parseInt($('#ReplytotalPageCount').val());
	var rps =parseInt($('#Replypagesize').val());
	
	$.jqPaginator('#pagination', {
	    totalPages:rpc ,
	    visiblePages: rps,
	    currentPage: 1,
	    onPageChange: function (num, type) {
	        findPage(num);
	    }
	});
	function findPage(pageno){
		var param ={
			'op':'findReplyByPage',
			'pageno':pageno,
			'nowTopicTid':$('#nowTopicTid').val()
		}
		$.post("Reply",param,function(data){
			if(data=="false"){
				alert('分页查询失败');
			}else{
				$('.answers').empty();
				var replys = JSON.parse(data);
				$.each(replys,function(i,reply){
					var text = replyContent(reply);
					$('.answers').append(text);
				});
				findLzlReply();	
				clickInit();
				jumpEveryWhere("#");
			}
		});
	}
	//楼中楼的回复
	function findLzlReply(){
		var answers = $('.answer');
		var comments;
		for(var i = 1;i<answers.length;i++){
			var rid = $(answers[i]).find('.rid').val();
			comments = $(answers[i]).find('.comments').find('tbody');
			comments.html('123');
			$.post("Reply",{'op':'findLzlReplyByPage','rid':rid},function(data){
				var lzlreplys = JSON.parse(data);
				
				$.each(lzlreplys,function(j,lzl){
					addReply(comments,lzl);
				});
				
			});
		}
	}
	
	//初始化赞和回复的点击事件
	function clickInit(){
		//移除事件
		//添加事件
		$('.date-dz-z').unbind('click',clickZan);
		$('.date-dz-z').click(clickZan);
		$('.replyComment').unbind('click',springReply);
		$('.replyComment').click(springReply);
		//提示框
		new $.Zebra_Tooltips($('.reply_tips'));
	}
	//回复内容
	function replyContent(reply){
		var deleteText;
		if($('#nowUserID').val()==reply.ruid){
			deleteText="<a href='javaScript:;' onclick='deleteReply("+reply.rid+")'>删除</a>";
		}else{
			deleteText="";
		}
		var text = "<div class='answer'><table><tbody><input type='hidden' class='rid' value='"
					+ reply.rid
					+"'><tr><td class='votecell'><div class='vote hide'><span class='date-dz-z pull-left reply_tips' title='点赞，可以加该贴的排名'>"
					+"	<i class='date-dz-z-click-red'></i><i class='z-num'>"
					+ reply.rfavour
					+"</i></span></div></td><td class='answercell'><div>"
					+ reply.rcontent
					+"</div><div class='fw'><div class='post-signature'>"
					+"<div class='user-info'><div class='user-action-time'>回复时间：  <span title='回复时间:"+reply.rtime
					+"' class='reply_tips'>"
					+ reply.rtime
					+"</span></div><div class='user-gravatar32'><a href='javaScript:;'>"
					+"<img src='img/17883626.jpg' width='32' height='32'>"
					+"</a></div><div class='user-details'><a href='javaScript:;' onclick='touserjump("+reply.ruid+")' title='回帖人:"+reply.uname+"' class='reply_tips'>"
					+ reply.uname
					+"</a><div class='hide'><span title='用户当前状态:"+reply.ustate+"' class='reply_tips'>"
					+ reply.ustate
					+"</span><span title='用户当前积分:"+reply.upoint+"' class='reply_tips'>"
					+ reply.upoint
					+"</span><span title='用户是否是版主:"+reply.uissectioner+"' class='reply_tips'>"
					+ reply.uissectioner
					+"</span></div></div></div></div></div></td></tr><tr><td class='votecell'></td>"
					+"<td><div class='comments '>"
					+"<table><tbody></tbody></table></div><div>"
					+"<a class='comments-link replyComment'>回复</a>"
					+deleteText
					+"</div></td></tr></tbody></table></div></div>";
					
		return text;
	}
	//删除回复reply
	function deleteReply(rid){
		var param = {
				'op':'deleteReply',
				'rid':rid
		}
		$.post('Reply',param,function(data){
			if(data == 'false'){
				alert('无法删除');
			}else{
				alert('删除成功');
				location.reload();
			}
		});
	}
	//删除帖子topic
	function deleteTopic(tid){
		var msg = '确定要删除该帖子，并删除相关的东西吗?';
		if(confirm(msg)==true){
			var param = {
					'op':'deleteTopic',
					'tid':tid
			}
			$.post('Topic',param,function(data){
				if(data=='false'){
					alert('无法删除');
				}else{
					alert('删除成功');
					location.href = "Session?op=toSession&SessionSid=" + $('#sessionSid').val();
				}
			});
		}else{
			alert('删除取消');
		}
	}
</script>
<!-- 回复帖子  -->
<script type="text/javascript">
	$(function(){
		$('#ReplyTopic').click(function(){
			var replyText = $('#summernoteReply').summernote('code');
			var nowTopicTid = $('#nowTopicTid').val();
			var nowSessionID = $('#sessionSid').val();
			var nowUserID = $('#nowUserID').val();
			
			if($('#nowUserName').html()==undefined){
				alert('请登录');
			}else if(replyText==""||replyText=="<p><br></p>"){
				$('#summernoteReply').focus();
				alert('请填写内容');
			}else{
				var param  = {
					"op" : "ReplyTopic",
					"nowTopicTid" :nowTopicTid,
					"nowSessionID" :nowSessionID,
					"nowUserID" :nowUserID,
					"replyText" :replyText
					}
				$.post("Reply",param,function(data){
					if(data=="false"){
						alert("回复失败");
					}else{
						alert('回帖成功');
						location.reload();//重新加载本页面
					}
				});
			}	
		});//end #ReplyTopic
		//富文本框初始化
		$('#summernoteReply').summernote(
				{
					height : 200,
					tabsize : 2,
					lang : 'zh-CN',
					toolbar : [ 
							[ 'font', [ 'bold', 'underline', 'clear' ] ],
							[ 'color', [ 'color' ] ],
							[ 'insert', [ 'link' ] ],
							[ 'view', [ 'fullscreen'] ] ]
		});
	});//end ready
</script>

<!-- 楼中楼回复 -->
<script type="text/javascript">
$(document).ready(function(e) {
	/*点击回复的时候跳出回复框*/
	$('.replyComment').unbind('click',springReply);
	$('.replyComment').click(springReply);
});
//添加楼中楼回复
function addReply(obj,val){
	var name;
	if(val.uname!=""&&val.uname!=null){
		name=val.uname;
	}else {
		name=$('#nowUserName').html();
	}
	var text = "<tr class='comment '>"
					+"<td class='comment-actions'>"
					+"<table><tbody><tr><input type='hidden' class='lid' value='"+val.lid+"'>"
					+"<td class=' comment-score'><span class='glyphicon glyphicon-comment'></span></td>"
					+"<td>&nbsp;</td></tr></tbody></table></td>"
					+"<td class='comment-text'>"
					+"<div style='display: block;' class='comment-body'>"
					+"<span class='comment-copy'>"+val.lcontent
					+"</span> –&nbsp; <a "
					+"href='javaScript:void(0)' onclick='touserjump("
					+val.luid
					+")' title='用户'class='comment-user reply_tips'>"
					+name
					+"</a> <span class='comment-date' dir='ltr'><w class='comment-link'><span "
					+"title='回复日期' class='reply_tips'>"
					+val.ltime
					+"</span></w>"
					+"</span></div></td></tr>";
	obj.append(text);
}
//显示楼中楼回复按钮
function showReply(){
	$('#Demo').siblings('a').show();
	$('#Demo').remove();
}
/*点击楼中楼回复的时候跳出回复框*/
function springReply(){
	var rid = $(this).parents("tr").siblings(".rid").val();
	if($('#nowUserName').html()==undefined){
		alert('请登录');
	}else{
		//去除原来已经存在的楼中楼回复框
		showReply();
		var content = "<div id='Demo' style='text-align:center;display:none' >"
	   				 +"<div class='Input_Box'>"
			      	+"<textarea class='Input_text'></textarea>"
			      	+"<div class='faceDiv'> </div>"
			     	+ "<div class='Input_Foot'> <a class='imgBtn hide' href='javascript:void(0);'></a><a class='postBtn'>确定</a> </div>"
			   		+"</div></div>";
		$(this).parent("div").prepend(content);//添加回复框
		$(this).hide();//隐藏回复按钮
		ImgIputHandler.Init();//初始化回复框
		$('#Demo').show(500);//回复框显示
		//确定按钮点击事件
		$(".postBtn").click(function(){
			var val = $(".Input_text").val();
			var obj = $('#Demo').parent("div").siblings(".comments");//回复所要添加的地方
			if(val==""){
				showReply();
			}else{
				var param = {
						'op':'addLzlReply',
						'uid':$('#nowUserID').val(),
						'rid':rid,
						'content':val
				}
				$.post('Reply',param,function(data){
					if(data=='false'){
						alert('回复失败');
					}else{
						addReply(obj,JSON.parse(data));
						showReply();											
					}
				});
			}
		});
	}//end else
}
//楼中楼回复框函数
var ImgIputHandler={
	facePath:[
	    {faceName:"微笑",facePath:"0_微笑.gif"},
		{faceName:"撇嘴",facePath:"1_撇嘴.gif"},
		{faceName:"色",facePath:"2_色.gif"},
		{faceName:"发呆",facePath:"3_发呆.gif"},
		{faceName:"得意",facePath:"4_得意.gif"},
		{faceName:"流泪",facePath:"5_流泪.gif"},
		{faceName:"害羞",facePath:"6_害羞.gif"},
		{faceName:"闭嘴",facePath:"7_闭嘴.gif"},
		{faceName:"大哭",facePath:"9_大哭.gif"},
		{faceName:"尴尬",facePath:"10_尴尬.gif"},
		{faceName:"发怒",facePath:"11_发怒.gif"},
		{faceName:"调皮",facePath:"12_调皮.gif"},
		{faceName:"龇牙",facePath:"13_龇牙.gif"},
		{faceName:"惊讶",facePath:"14_惊讶.gif"},
		{faceName:"难过",facePath:"15_难过.gif"},
		{faceName:"酷",facePath:"16_酷.gif"},
		{faceName:"冷汗",facePath:"17_冷汗.gif"},
		{faceName:"抓狂",facePath:"18_抓狂.gif"},
		{faceName:"吐",facePath:"19_吐.gif"},
		{faceName:"偷笑",facePath:"20_偷笑.gif"},
	    {faceName:"可爱",facePath:"21_可爱.gif"},
		{faceName:"白眼",facePath:"22_白眼.gif"},
		{faceName:"傲慢",facePath:"23_傲慢.gif"},
		{faceName:"饥饿",facePath:"24_饥饿.gif"},
		{faceName:"困",facePath:"25_困.gif"},
		{faceName:"惊恐",facePath:"26_惊恐.gif"},
		{faceName:"流汗",facePath:"27_流汗.gif"},
		{faceName:"憨笑",facePath:"28_憨笑.gif"},
		{faceName:"大兵",facePath:"29_大兵.gif"},
		{faceName:"奋斗",facePath:"30_奋斗.gif"},
		{faceName:"咒骂",facePath:"31_咒骂.gif"},
		{faceName:"疑问",facePath:"32_疑问.gif"},
		{faceName:"嘘",facePath:"33_嘘.gif"},
		{faceName:"晕",facePath:"34_晕.gif"},
		{faceName:"折磨",facePath:"35_折磨.gif"},
		{faceName:"衰",facePath:"36_衰.gif"},
		{faceName:"骷髅",facePath:"37_骷髅.gif"},
		{faceName:"敲打",facePath:"38_敲打.gif"},
		{faceName:"再见",facePath:"39_再见.gif"},
		{faceName:"擦汗",facePath:"40_擦汗.gif"},
	]
	,
	Init:function(){
		var isShowImg=false;
		$(".Input_text").focusout(function(){
			$(this).parent().css("border-color", "#cccccc");
            $(this).parent().css("box-shadow", "none");
            $(this).parent().css("-moz-box-shadow", "none");
            $(this).parent().css("-webkit-box-shadow", "none");
		});
		$(".Input_text").focus(function(){
		$(this).parent().css("border-color", "rgba(19,105,172,.75)");
        $(this).parent().css("box-shadow", "0 0 3px rgba(19,105,192,.5)");
        $(this).parent().css("-moz-box-shadow", "0 0 3px rgba(241,39,232,.5)");
        $(this).parent().css("-webkit-box-shadow", "0 0 3px rgba(19,105,252,3)");
		});
		$(".imgBtn").click(function(){
			if(isShowImg==false){
				isShowImg=true;
			    $(this).parent().prev().animate({marginTop:"-117px"},300);
				if($(".faceDiv").children().length==0){
					for(var i=0;i<ImgIputHandler.facePath.length;i++){
						$(".faceDiv").append("<img title=\""+ImgIputHandler.facePath[i].faceName+"\" src=\"img/face/"+ImgIputHandler.facePath[i].facePath+"\" />");
					}
					$(".faceDiv>img").click(function(){
				 		isShowImg=false;
			            $(this).parent().animate({marginTop:"0px"},300);
						ImgIputHandler.insertAtCursor($(".Input_text")[0],"["+$(this).attr("title")+"]");
						
					});
				}
			}else{
				isShowImg=false;
			    $(this).parent().prev().animate({marginTop:"0px"},300);
			}
		});
		
	},
	insertAtCursor:function(myField, myValue) {
    if (document.selection) {
        myField.focus();
        sel = document.selection.createRange();
        sel.text = myValue;
        sel.select();
    } else if (myField.selectionStart || myField.selectionStart == "0") {
        var startPos = myField.selectionStart;
        var endPos = myField.selectionEnd;
        var restoreTop = myField.scrollTop;
        myField.value = myField.value.substring(0, startPos) + myValue + myField.value.substring(endPos, myField.value.length);
        if (restoreTop > 0) {
            myField.scrollTop = restoreTop;
        }
        myField.focus();
        myField.selectionStart = startPos + myValue.length;
        myField.selectionEnd = startPos + myValue.length;
    } else {
        myField.value += myValue;
        myField.focus();
    }
}
}
</script>
<!--点赞-->
<script type="text/javascript">
	function clickZan(){
		if($('#nowUserName').html()==undefined){
			alert('请登录');
		}else{
			var zNum = $(this).find('.z-num').html();
	        if($(this).is('.date-dz-z-click')){
	            zNum--;
	            $(this).removeClass('date-dz-z-click red');
	            $(this).find('.z-num').html(zNum);
	            $(this).find('.date-dz-z-click-red').removeClass('red');
	        }else {
	            zNum++;
	            $(this).addClass('date-dz-z-click');
	            $(this).find('.z-num').html(zNum);
	            $(this).find('.date-dz-z-click-red').addClass('red');
	        }
		}
	}
	$(function(){
		$('.date-dz-z').click(clickZan);		
	});
	
</script>
<!-- 提示框 -->
<script type="text/javascript" src="js/zebra_tooltips.js"></script> 
</html>