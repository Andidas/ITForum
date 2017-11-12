<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		
		<link href="css/init.css" rel="stylesheet" />
		<link href="css/topic.css" rel="stylesheet" />
		<link href="dist/summernote.css" rel="stylesheet" />
</head>
<body>
<jsp:include page="nav.jsp" flush="true"></jsp:include>
	<div class="container">
		<div class="row clearfix">
			<div class="col-lg-12 page-header">
				<h2 class="col-lg-12" title="题目"  >
				<span class="TopicTName" id="nowTopicName">${nowActiveTopicView.ttopic}</span>
				<input type="hidden" value="${nowActiveTopicView.tid}" id="nowTopicTid" class="topicTid"/> 
				</h2>
				<a href="javaScript:void(0)" class="col-lg-12 pull-right" title="版块">-
					<span class="sessionName">${nowActiveTopicView.sname}</span>
					<input type="hidden" value="${nowActiveTopicView.tsid}" class="sessionSid" id="sessionSid"/>
				</a>
			</div>
			<div class="col-md-8  column">
				<div class="answer" style="border-bottom: transparent;">
					<table>
						<tbody>
							<tr>
								<td class="votecell">
									<div class="vote">
										 <span class="date-dz-z pull-left" title="赞">
    										<i class="date-dz-z-click-red"></i><i class="z-num">666</i></span>
									</div>
								</td>
								<td class="answercell">
									<div class="post-text" >
										${nowActiveTopicView.tcontents}
									</div>
									<div class="fw">
										<div class="post-signature" style="background-color:#eee;">
											<div class="user-info ">
												<div class="user-action-time">
													asked <span title="发帖时间"
														class="relativetime">${nowActiveTopicView.ttime}</span>
												</div>
												<div class="user-gravatar32">
													<a href="user.html">
														<img src="img/17883626.jpg" alt="" width="32" height="32">
													</a>
												</div>
												<div class="user-details">
													<a href="javaScript:void(0)" title="作者">${nowActiveTopicView.uname}</a>
													<div class="-flair">
														<span class="reputation-score" title="reputation score "
															dir="ltr">1,993</span><span title="1 gold badge"><span
															class="badge1"></span><span class="badgecount">1</span></span><span
															title="13 silver badges"><span class="badge2"></span>
															<span class="badgecount">13</span> </span><span
															title="14 bronze badges"><span class="badge3"></span><span
															class="badgecount">14</span></span>
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
				<ul id="Tabson" class="nav nav-tabs ">
						<li>
							<h4>10tiao</h4>
						</li>
						<li class="pull-right"><a href="#answers" data-toggle="tab"
							aria-expanded="false">oldest</a></li>
						<li class="pull-right active"><a href="#questions"
							data-toggle="tab" aria-expanded="true">new</a></li>
						<li class="pull-right"><a href="#All" data-toggle="tab"
							aria-expanded="false">vote</a></li>
				</ul>
				<div class="answers">
				<c:forEach items="${ReplyPage.data}" var="replyList">
					<div class="answer">
						<table>
							<tbody>
								<tr>
									<td class="votecell">
										<div class="vote">
											 <span class="date-dz-z pull-left" title="赞">
    										<i class="date-dz-z-click-red"></i><i class="z-num">${replyList.rfavour}</i></span>
										</div>
									</td>
									<td class="answercell">
										<div>${replyList.rcontent}</div>
										<div class="fw">
											<div class="post-signature">
												<div class="user-info ">
													<div class="user-action-time">
														answered <span title="时间">${replyList.rtime}</span>
													</div>
													<div class="user-gravatar32">
														<a href="javaScript:;">
																<img src="img/17883626.jpg" width="32" height="32">
														</a>
													</div>
													<div class="user-details">
														<a href="javaScript:;">${replyList.uname}</a>
														<div>
															<span title="状态">${replyList.ustate}</span>
															<span title="积分">${replyList.upoint}</span>
															<span title="版主">${replyList.uissectioner}</span>
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
					
					</c:forEach>
				</div>
					
				<div id="pageForm">
					<input type="hidden" name="pageno" id="pageno">
					<a onclick="findPage(1)">&laquo;</a>  
					<c:if test="${ReplyPage.pageParam.pageno>1 }">
						<a onclick="findPage(${ReplyPage.pageParam.pageno-1})">&larr;</a>
					</c:if>
					<c:forEach begin="1" end="${ReplyPage.totalPageCount }" var="i" step="1">
						<a onclick="findPage(${i})">${i }</a>
					</c:forEach>
					<c:if test="${ReplyPage.pageParam.pageno<ReplyPage.totalPageCount }">
						<a onclick="findPage(${ReplyPage.pageParam.pageno+1})">&rarr;</a>
					</c:if>
					<a onclick="findPage(${ReplyPage.totalPageCount })" >&raquo;</a>
					<input type="hidden" name="totalCount" id="totalCount" value="${ReplyPage.totalPageCount }">
					<input id="topage" size="3"><a onclick="jump()">跳转</a>
				</div>
				
				
				<div id="summernoteReply" ></div>
				<a class="btn btn-success" id="ReplyTopic">回复</a>
				
			</div>
			<div class="col-md-4 column">
				<div class="module question-stats">
					<table id="qinfo">
						<tbody>
							<tr>
								<td>
									<p class="label-key">asked</p>
								</td>
								<td style="padding-left: 10px">
									<p class="label-key" title="生成时间">
										<b>${nowActiveTopicView.ttime}</b>
									</p>
								</td>
							</tr>
							<tr>
								<td>
									<p class="label-key">viewed</p>
								</td>

								<td style="padding-left: 10px">
									<p class="label-key">
										<b>${nowActiveTopicView.tclickcount}</b>
									</p>
								</td>
							</tr>
							<tr>
								<td>
									<p class="label-key">active</p>
								</td>
								<td style="padding-left: 10px">
									<p class="label-key">
										<b><a class="lastactivity-link"
											title="最后回复时间">${nowActiveTopicView.tlastreplaytime}</a></b>
									</p>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="panel " id="HotQuestion">
					<div class="panel-heading">
						<h3 class="panel-title">相关</h3>
					</div>
					<div class="panel-body">
						<ul class=""> 
							<c:forEach items="${nowActiveTopicView.sameTopic}" var="sametopic">
								<li>
									<span class="label label-success col-xs-1" title="有多少人回复">${sametopic.treplycount }</span>
									<a href="javaScript:void(0)" class="col-xs-11" onclick="topicjumg(this,${nowActiveTopicView.tsid})">${sametopic.ttopic}</a>
									<input type="hidden" class="topicTid" value="${sametopic.tid}">
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>

	
</body>
<script type="text/javascript" src="js/GotoTopicOrSession.js"></script>
<script src="dist/summernote.js"></script>
<script src="dist/lang/summernote-zh-CN.js"></script>
<!-- 回复的分页查询 -->
<script type="text/javascript">
	
	function findPage(pageno){
		var param ={
			'op':'findReplyByPage',
			'pageno':pageno,
			'nowTopicTid':$('#nowTopicTid').val()
		}
		$.post("Topic",param,function(data){
			if(data=="false"){
				alert('分页查询失败');
			}else{
				
				$('.answers').empty();
				var replys = eval(data);
				$.each(replys,function(i,reply){
					var text = replyContent(reply);
					$('.answers').append(text);
				});
				clickInit();
			}
		});
	}
	function jump(){
		var pageno = document.getElementById("topage").value;
		findPage(pageno);
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
					console.log(data);
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
	//初始化赞和回复的点击事件
	function clickInit(){
		//移除事件
		//添加事件
		$('.date-dz-z').click(clickZan);
		$('.replyComment').click(springReply);
	}
	//回复内容
	function replyContent(reply){
		var text = "<div class='answer'><table><tbody><input type='hidden' class='rid' value='"
					+ reply.rid
					+"'><tr><td class='votecell'><div class='vote'><span class='date-dz-z pull-left' title='赞'>"
					+"	<i class='date-dz-z-click-red'></i><i class='z-num'>"
					+ reply.rfavour
					+"</i></span></div></td><td class='answercell'><div>"
					+ reply.rcontent
					+"</div><div class='fw'><div class='post-signature'>"
					+"<div class='user-info'><div class='user-action-time'>answered <span title='时间'>"
					+ reply.rtime
					+"</span></div><div class='user-gravatar32'><a href='javaScript:;'>"
					+"<img src='img/17883626.jpg' width='32' height='32'>"
					+"</a></div><div class='user-details'><a href='javaScript:;' title='回复人'>"
					+ reply.uname
					+"</a><div><span title='状态'>"
					+ reply.ustate
					+"</span><span title='积分'>"
					+ reply.upoint
					+"</span><span title='版主'>"
					+ reply.uissectioner
					+"</span></div></div></div></div></div></td></tr><tr><td class='votecell'></td>"
					+"<td><div class='comments '>"
					+"<table><tbody></tbody></table></div><div>"
					+"<a class='comments-link replyComment'>回复</a>"
					+"</div></td></tr></tbody></table></div></div>";
					
		return text;
	}
	
</script>

<!-- 楼中楼回复 -->
<script type="text/javascript">
$(document).ready(function(e) {
	/*点击回复的时候跳出回复框*/
	$('.replyComment').click(springReply);
});
//添加楼中楼回复
function addReply(obj,val){
	var text = "<tr class='comment '>"
					+"<td class='comment-actions'>"
					+"<table><tbody><tr>"
					+"<td class=' comment-score'><span title='条数'class='cool'>1</span></td>"
					+"<td>&nbsp;</td></tr></tbody></table></td>"
					+"<td class='comment-text'>"
					+"<div style='display: block;' class='comment-body'>"
					+"<span class='comment-copy'>"+val
					+"</span> –&nbsp; <a "
					+"href='javaScript:void(0)' title='用户'class='comment-user'>"
					+$('#nowUserName').html()
					+"</a> <span class='comment-date' dir='ltr'><w class='comment-link'><span "
					+"title='回复日期'>Sep 10 '15 at 9:09</span></w>"
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
	if($('#nowUserName').html()==undefined){
		alert('请登录');
	}else{
		//去除原来已经存在的楼中楼回复框
		showReply();
		var content = "<div id='Demo' style='text-align:center;display:none' >"
	   				 +"<div class='Input_Box'>"
			      	+"<textarea class='Input_text'></textarea>"
			      	+"<div class='faceDiv'> </div>"
			     	+ "<div class='Input_Foot'> <a class='imgBtn' href='javascript:void(0);'></a><a class='postBtn'>确定</a> </div>"
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
				addReply(obj,val);
				showReply();					
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
</html>