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
<title>消息中心</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="css/infoCenter/index.css">
<link rel="stylesheet" href="css/infoCenter/themes-defalut.css">
<link href="css/infoCenter/pagination.css" rel="stylesheet" />
<link rel="stylesheet" href="css/infoCenter/common.css">
<link rel="stylesheet" href="css/infoCenter/form.css">
<link rel="stylesheet" href="css/infoCenter/alerts.css">
<link rel="stylesheet" href="css/infoCenter/style.css">


<link href="css/infoCenter/frontshow.css" rel="stylesheet" />
<link href="css/infoCenter/notices.css" rel="stylesheet" />

</head>
<meta content="authenticity_token" name="csrf-param" />
<meta content="dGBSiGhfHAv6IlAuZKAym2FPsqWeA3RYvxkKMY1d4Xw="
	name="csrf-token" />

<body id="notify-center"
	style="padding-top: 30px; background-color: #e9e9e9; font-family: 'microsoft yahei'">
	<div class="clearfix">
		<nav class="navbar navbar-default navbar-fixed-top" role="navigation"
			style="border-top: solid #F48024 3px;">
			<div class="container">

				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="welcome">ITFOURM</a>
				</div>
			</div>
		</nav>
	</div>
	<a href="javaScript:;" class="btn btn-link" id="return_top"></a>
	<div class="container clearfix">
		<input id="current_user" type="hidden" value="qq_34353848">
		<div id="scrollbox" style="display: none; height: 0px;">
			<div></div>
			<div
				style="position: absolute; z-index: 999; right: 0px; top: 0px; border: 1px solid rgb(193, 193, 193); background-color: rgb(255, 255, 255); width: 8px; display: none;">
				<div
					style="width: 10px; background-color: rgb(193, 193, 193); position: absolute; cursor: pointer;"></div>
			</div>
		</div>

		<div class="w1170-w row ntf-bg">
			<ul class="notice-info-tab">
				<li class="notify "><a href="NoticeUser.jsp">通知</a></li>
				<li class="letter curr-tab"><a href="javaScript:;">私信</a></li>
			</ul>
			<div class="col-xs-4 col-summary nLeft">
				<div class="nl_setting">
					<a href="/letters?type=1" class="nGzAndWgz ">已关注（未读0）</a> <span
						class="nSeparator">|</span> <a href="/letters?type=2"
						class="nGzAndWgz ">未关注（未读0）</a> <a href="javascript:void(0);"
						class="nSettings dropdown-toggle" data-toggle="dropdown"> <i
						class="glyphicon glyphicon-cog"></i>
					</a>
					<ul class="dropdown-menu nsetting-menu">
						<li><span class="nty-top-arr"></span> <label
							href="javascript:void(0);" class="del"> <a
								class="icon-ok" href="javascript:void(0);"> <i
									class="glyphicon glyphicon-ok">&nbsp; </i> <span
									style="font-family: microsoft yahei;">允许所有人私信我</span>
							</a>
						</label></li>
						<li><label href="javascript:void(0);" class="mark"> <a
								href="/letters/set_receive_letter_notify_rule?type=fans_to_other">
									<span style="font-family: microsoft yahei;">仅允许我关注的人私信我</span>
							</a>
						</label></li>
					</ul>
				</div>

				<form class="form-inline nty-seabar" action="/letters">
					<label for="keywords"><span
						class="glyphicon glyphicon-search"></span></label>
					<div class="form-group">
						<input id="keywords" type="text" placeholder="搜索联系人"
							class="form-control" name="username" value=""> <input
							type="submit" style="display: none">
					</div>
				</form>
				<!--使用post方式提交表单，此处会出现 Can't verify CSRF token authenticity 错误,无法读取到cookie中的信息，需要controller中增加 skip_before_filter :verify_authenticity_token, :only => [:del, :mark]-->
				<form class="form-horizontal" method="get" action="#">
					<input type="hidden" name="start_id" value="0">
					<div class="form-group check-all-toolbar">
						<div class="col-xs-6">
							<div class="checkbox select-all">
								<label> <input type="checkbox">全选
								</label>
							</div>
						</div>
						<div class="col-xs-6 text-right">
							<div class="dropdown nty-pop-small">
								<button id="center-list-menu" type="button"
									data-toggle="dropdown"
									class="btn btn-sm btn-default dropdown-toggle">
									操作 <span class="caret"></span>
								</button>
								<ul aria-labelledby="center-list-menu" class="dropdown-menu">
									<li>
										<span class="nty-top-arr"></span> 
										<a class="del" href="javascript:void(0);">
											<span class="glyphicon glyphicon-trash"></span> 删除私信</a>
										<a class="mark" href="javascript:void(0);">
										<span class="glyphicon glyphicon-volume-down"></span>标记已读</a>
									</li>
								</ul>
							</div>
						</div>
					</div>
					<div class="media-list" style="min-height: 300px;">
						<input type="hidden" value="${letterList.data[0].user_id}" id="user_id">
						<c:forEach items="${letterList.data}" var="letter">
						<div class="media nty-mas-li">
							<div class="pull-left">
								<div class="checkbox">
									<label> 
									<input type="checkbox" name="ids[]" value="${letter.receiver_name}" class="select">
									<img src="<%=basePath%>files/${letter.receiver_image}" class="media-object">
									</label>
								</div>
							</div>
							<div class="media-body">
								<a href="javaScript:;" class="userList">
									<h4 class="media-heading">
										<div class="pull-right">${letter.ptime}</div>
										<span class="txt">${letter.receiver_name}</span>
										<input type="hidden" class="friend_id" value="${letter.friend_id}"/>
									</h4>
									<p class="con">
										<span class="letter_id" >${letter.pcontent}</span>
									</p>
								</a>
							</div>
						</div>
						</c:forEach>
					</div>
				</form>
				<div class="csdn-pagination hide-text hide-set hide-go">
					<span class="page-nav">
					 	<a  href="javaScript:;" pageno="1" id="show_more">加载更多</a>
					</span>
				</div>

				<a class="btnNewMail new-private"> 
					<i class="glyphicon glyphicon-plus addicon"></i> 
					<span>新建私信</span>
				</a>

			</div>
			<div class="col-xs-8 col-content nRight">
				
				<div class="private-new" style="display: block;">
					<div class="row nty-mas-rtop">
						<h3 class="noy-pl15">
							<i class="glyphicon glyphicon-envelope">&nbsp; </i> 新私信
						</h3>
					</div>
					<form class="form-horizontal nty-sent-newmas" name="send_new"
						action="letter?op=new_letter" method="post">
						<div class="form-group">
							<label class="pull-left control-label" style="text-align: right;">发给：</label>
							<div class="pull-right">
								<input type="text" placeholder="请输入有效的收信人" 
									class="form-control typeahead" value="${queryUserInfo.uname }" name="receiver">
								<input type="hidden" name="receiver_id" value="${queryUserInfo.uid}" >
								<span class="error error-empty help-block">请输入有效的收信人</span>
							</div>
						</div>
						<div class="form-group">
							<label class="pull-left control-label" style="text-align: right;">内容：</label>
							<div class="pull-right">
								<textarea rows="6" class="form-control" name="body"
									placeholder="可发送200字以内的内容" maxlength="200"></textarea>
								<span class="error error-empty help-block">私信内容不能为空</span>
							</div>
						</div>
						<div class="form-group">
							<button class="btn btn-primary send-private" type="submit"
								style="margin-left: 86px;">私信</button>
						</div>
					</form>
				</div>

				<div class="private-list"
					style="margin-left: -15px; margin-right: -15px; display: none;">
					<div class="nl_title">
						<i class="glyphicon glyphicon-envelope"></i>
						 <a href="javaScript:;" class="nl_username" target="_blank" onclick="touserjump(30)">
						  flyingpig2016
						  </a>
						  <span>&nbsp;和我的私信往来</span>
					</div>
					<div class="nl_content">
						<div class="nl_dialog clearfix">
							<!-- 详细信息内容 -->
						</div>
						
						<div class="nl_input_box nl_input_box2"></div>
						<div class="nl_input_box">
							<form class="form-horizontal" name="reply" action="letter?op=send_letter" method="post">
								<input type="hidden" name="receiver" value="flyingpig2016" id="receiver_id">
								<input name="body" id="content1" class="nl_input" type="text" placeholder="200字以内" maxlength="200">
								<input class="nl_btn_reply" type="submit" value="回复">
							</form>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
	<%@include file="footer.html"%>
</body>
<script type="text/javascript" src="js/jquery-3.0.0.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript">
	$(function() {
		//查看信息
		$('.userList').click(function() {
			var friend_id = $(this).find('.friend_id').val();
			show_hide($('.private-list'),$('.private-new'));
			$('.nl_username').html($(this).find('.txt').html());
			$('#receiver_id').val(friend_id);
			var param = {
				'op':'letter_detail',
				'friend_id':friend_id
			}
			$.post('letter',param,function(data){
				if(data=='false'){
					alert('获取数据错误');
				}else{
					$('.nl_dialog').empty();
					var letters = JSON.parse(data);
					$.each(letters,function(i,letter){
						var text = letterContent(letter);
						$('.nl_dialog').prepend(text);
					});
				}
			});
		});
		//新建私信
		$('.new-private').click(function(){
			show_hide($('.private-new'),$('.private-list'));
		});
		
	});
	//内容布局
	function letterContent(letter){
		if(letter.puid == $('#user_id').val()){
			var left_or_right = '<div class="dialog_wr">'
				+'<div class="dialog_g_r">'+letter.pcontent+'</div>'
				+'<div class="ang3"></div>'
				+'<div class="ang4"></div>'
				+'<div class="dialog_wr_l">'
					+'<div>'
						+'<a href="javaScript:;" touserjump('+letter.puid+')>'
						+'<img class="dialog_p" src="files/'+letter.sender_image+'">'
						+'</a>'
					+'</div>'
				+'</div>'
			+'</div>';
		}else{
			var left_or_right = '<div class="dialog_girl">'
				+'<div class="dialog_g_l">'
					+'<a href="javaScript:;" touserjump('+letter.puid+')>'
					+'<img class="dialog_p" src="files/'+letter.sender_image+'">'
					+'</a></div>'
				+'<div class="ang"></div>'
				+'<div class="ang2"></div>'
				+'<div class="dialog_g_r">'
					+'<div>'
					+letter.pcontent
					+'</div>'
				+'</div>'
			+'</div>';
		}
		
		var text = '<div class="nl_show_his">'+getDateDiff(letter.ptime)+'</div>'+left_or_right
		return text;
	}
	function show_hide(obj_x,obj_y){
		obj_x.show();
		obj_y.hide();
	}
</script>
<script type="text/javascript" src="js/transform_time.js"></script>
</html>