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
<link rel="stylesheet" href="css/toastr.css" type="text/css"></link>
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
					<c:if test="${queryUserInfo.uid==NowLoginUser.uid and not empty NowLoginUser}">
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
								<div class="reputation zebra_tips1" title="该用户所获得的成就">
									${queryUserInfo.upoint} <span class="label-uppercase">reputation</span>
								</div>

								<div class="g-row _gutters ai-start fl-none -row-first">
									<c:if test="${queryUserInfo.uissectioner ==0}">
										<div class="g-col g-row g-center badge1-alternate zebra_tips1" title="普通用户">
											<a class="g-col g-center -total"><i class="	glyphicon glyphicon-magnet"></i></a>
										</div>						
									</c:if>
									<c:if test="${queryUserInfo.uissectioner ==1}">
										<div class="g-col g-row g-center badge1-alternate zebra_tips1" title="版主">
											<a class="g-col g-center -total"><i class="glyphicon glyphicon-tower"></i></a>
										</div>
									</c:if>
									<div class="g-col g-row g-center badge2-alternate zebra_tips1" title="举报该用户">
										<a href="javaScript:;" data-toggle="modal" class="g-col g-center -total" id="toMyModal"><i class="glyphicon glyphicon-warning-sign"></i></a>
									</div>
									<div class="g-col g-row g-center badge3-alternate zebra_tips1"
										title="发送私信给他">
										<a href="javaScript:;" onclick="toInfoCenterjump(${queryUserInfo.uid})" class="g-col g-center -total"><i class="glyphicon glyphicon-send"></i></a>
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
												<span class="number"><i class="glyphicon glyphicon-user"></i> <i id="queryUserName">${queryUserInfo.uname}</i></span>
											</div>
										
										</div>
									</div>

									<div class="user-link">
										<ul class="list-unstyled">
											<li>
												<span class="	glyphicon glyphicon-fire"></span>
												性别：<c:if test="${queryUserInfo.usex==1 }">男</c:if>
												<c:if test="${queryUserInfo.usex==0 }">女</c:if>
											</li>
											
											<li><span class="glyphicon glyphicon-file"></span>
												发帖个数：${userTopic.totalRecordCount}
											</li>
											<li><span class="glyphicon glyphicon-comment"></span>
												回帖个数：${userReplys.totalRecordCount}
												</li>
											<li><span class="glyphicon glyphicon-info-sign"></span>
											用户状态：
											<c:if test="${queryUserInfo.ustate > 0}">良好</c:if>
											<c:if test="${queryUserInfo.ustate < -10}">警告</c:if>
											</li>
											<li><span class="glyphicon glyphicon-gift"></span>
												出生日期：${queryUserInfo.ubirthady}
											</li>
											<li><span class="glyphicon glyphicon-time"></span>
												注册时间：<i id="regist_time">${queryUserInfo.uregdate}</i>
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
								<h4>他的关注</h4>
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
							<div class="module" id="myNew-tags">
								<h4 >他建的版块</h4>
								<div>
									<c:if test="${empty sessionsCreatedByUser}">
										<br><br>
										<p style="color: #9e9e9e;">
											用户暂时不是版主
										</p>		
									</c:if>
									<c:forEach items="${sessionsCreatedByUser}" var="session">
									<a href="javaScript:;" class="label label-success"  rel="tag" onclick="tosessionjump(${session.sid})">
										${session.sname}
									</a>									
									</c:forEach>
								</div>
							</div>
						</div>
						<div class="col-md-9">
							<ul class="nav nav-tabs ">
								<li>
									<h4>帖子</h4>
								</li>
							</ul>
							<div  class="tab-content">
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
								<p style="color:#9e9e9e;text-align: center;">一个帖子都没发表过</p>
							</c:if>
							<c:if test="${not empty userTopic.data}">
								
								<div class="col-xs-2 col-xs-offset-5" style="padding-bottom:20px;">								
									<a class="btn btn-default" id="showMore">加载更多</a>
									<input type="hidden" value="2" id="nowPageNo">
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
							<!-- 回帖 -->
							<ul class="nav nav-tabs" style="margin-top: 100px;">
								<li>
									<h4>回复</h4>
								</li>
							</ul>
							<div  class="tab-content">
								<div class="tab-pane fade in active" >
									<table class="table table-hover table-condensed table-striped">
										<thead>
											<tr>
												<th>内容</th>
												<th>时间</th>
											</tr>
										</thead>
										<tbody id="reply_tbody">
											<c:forEach items="${userReplys.data}" var="reply" varStatus="num">
											<tr <c:if test="${num.index%2==1}">class="success"</c:if>>
											<td><a href="javaScript:;" onclick="toTopicJump(${reply.rtid},${reply.rsid})">${reply.rcontent}</a></td>
												<td>${reply.rtime}</td>
											</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
							<c:if test="${empty userReplys.data}">
								<p style="color:#9e9e9e;text-align: center;">从未回复过帖子</p>
							</c:if>
							<c:if test="${not empty userReplys.data}">
								<div class="col-xs-2 col-xs-offset-5" style="padding-bottom:20px;">								
									<a class="btn btn-default" id="replyShowMore">加载更多</a>
									<input type="hidden" value="2" id="replyNowPageNo">
									<div class="loadEffect" id="replyLoadEffect" style="display:none;">
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
										id="PictureBySet" style="min-width:216px;min-height:189px;width:216px;height:189px;">
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
								<button type="submit" class="btn btn-default" id="setUserInfo" style="margin-bottom: 20px;">Submit</button>
								
							</div>
							
						</form>

					</div>
				</div>

			</div>
		</div>
	</div>
	<%@include file="footer.html" %>
	
	<!--模态窗口 -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			 <div class="modal-dialog">
			  <div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h3 id="myModalLabel">举报用户</h3>
			</div>
			<div class="modal-body">
				<form action="#" method="post" id="reportForm">
				<div class="poplayer-bd">
					<p class="text-gray">温馨提示：填写完整的描述，举报将得到优先处理。<br>请再次确认您的举报信息，确认信息已全部上传，以便投诉可以全部处理。</p>
					<div class="form-row js-row">
						<label class="form-label" for="">
							<span class="form-need">*</span>
							举报问题类别：
						</label>
						<div class="f-control">
							<select class="form-select js-type">
								<option value="广告类" selected="selected">广告类</option>
								<option value="诈骗类">诈骗类</option>
								<option value="个人资料">个人资料</option>
								<option value="政治有害类">政治有害类</option>
								<option value="淫秽色情类">淫秽色情类</option>
								<option value="头像、签名档赌博类">头像、签名档赌博类</option>
								<option value="其他有害类">其他有害类</option>
							</select>
						</div>
					</div>
					<div class="form-row js-row">
						<label class="form-label" for="">
							<span class="form-need-hidden">*</span>
							被举报的用户：
						</label>
						<div class="f-control">
							<input class="form-input js-phone" type="text" placeholder="填写正确的用户">
						</div>
						<div class="form-tips">
							<span class="text-icon-tips hidden js-phoneTips"></span>
						</div>
					</div>
					<div class="form-row js-row">
						<label class="form-label-block">
							<span class="form-need">*</span>
								问题描述
							<span class="text-gray">
								(为了更快速解决您的问题，请尽量提供详实描述)
							</span>
						</label>
						<div class="f-control">
							<textarea maxlength="250" placeholder="如：在xx版块，发布了xxx信息。" id="myTextare"></textarea>
						</div>
						<div class="poplayer-feedback-tips js-wordCounter">
							<b class="char-constantia">250</b>字
						</div>
					</div>
				</div>
			
				</form>
			</div>
			<div class="modal-footer">
				<button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
				<button class="btn btn-danger" id="doReport">举报</button>
			</div>
		</div>
		</div></div>
		<!-- end modal -->
		
</body>
<!-- 模态窗口 -->
<script type="text/javascript">
$(function(){
	$('#toMyModal').click(function(){
		if($('#nowUserName').html()==undefined){
			toastr.info('请登录');
		}else{
			$('.js-phone').val($('#queryUserName').html());
			$('#myModal').modal('show');
		}		
	});
	
	$('#doReport').click(function(){
		var selectText = $(".form-select").find("option:selected").text();
		var userText = $('.js-phone').val();
		var mytextare = $('#myTextare').val();
		
		if(userText==null||userText==""){
			$('.js-phone').focus();
			toastr.info("请填写用户名！");
		}else if(mytextare==null||mytextare==""){
			$('#myTextare').focus();
			toastr.info("请填写描述！");
		}else{
			var param = {
					"op":"sendWhistleBlowing",
					"content":"我举报用户<a>"+userText+"</a>,原因："+mytextare
			}
			$.post("letter",param,function(data){
				if(data=="false"){
					toastr.error("举报失败！");		
				}else{
					toastr.success("举报成功！");
					$('.js-phone').val("");
					$('#myTextare').val("");
					$('#myModal').modal('hide');
				}
			});
		}
		
	});
});

</script>
<!-- topic加载更多 -->
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
			$.post('Topic',param,function(data){
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
<!-- reply加载更多 -->
<script type="text/javascript">
function hide_MoreBtn_LoadBtn_reply(){
	$("#replyShowMore").hide();
	$("#replyLoadEffect").hide();
}
	$(function(){
		$("#replyShowMore").click(function(){
			hide_show($("#replyShowMore"),$("#replyLoadEffect"));
			var uid = $("#queryUserId").val();
			var nowPageNo = $("#replyNowPageNo").val();
			var param = {
					'op':'findUserReply',
					'uid':uid,
					'pageno':nowPageNo
			}
			$.post('Reply',param,function(data){
				if(data=="false"){
					setTimeout('hide_MoreBtn_LoadBtn_reply()',1000);
				}else{
					hide_show($("#replyLoadEffect"),$("#replyShowMore"));
					
					var replys = JSON.parse(data);
					$.each(replys,function(i,reply){
						var content=setUser_Treply(i,reply);
						$('#reply_tbody').append(content);
					});
					nowPageNo++;
					$("#replyNowPageNo").val(nowPageNo);
				}
			});
		});
	});
	function setUser_Treply(i,reply){
		if(i%2==1){
			var cla = 'class="success"';
		}
		var text = '<tr '+cla+'>'
				+'<td>'
				+'<a href="javaScript:;" onclick="toTopicJump('+reply.rtid+','+reply.rsid+')">'+reply.rcontent+'</a>'
				+'</td><td>'
				+reply.rtime
				+'</td></tr>';
		return text;
	}
</script>
<!-- 页面跳转 -->
<script type="text/javascript" src="js/GotoTopicOrSession.js"></script>
<!-- 提示框 -->
<script type="text/javascript" src="js/zebra_tooltips.js"></script>
<!-- 字符限制 -->
<script type="text/javascript" src="js/limitStr.js"></script>
<script type="text/javascript" src="js/transform_time.js"></script>
<script type="text/javascript">
	$(function(){
		
		textAreaChange($("#userBio"));
	});
</script>
<script type="text/javascript" src="js/toastr.js"></script>
</html>