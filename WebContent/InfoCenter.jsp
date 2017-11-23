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
	<meta content="dGBSiGhfHAv6IlAuZKAym2FPsqWeA3RYvxkKMY1d4Xw=" name="csrf-token" />

	<body id="notify-center" style="padding-top:30px;background-color: #e9e9e9; font-family: 'microsoft yahei'">
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
				<div style="position: absolute; z-index: 999; right: 0px; top: 0px; border: 1px solid rgb(193, 193, 193); background-color: rgb(255, 255, 255); width: 8px; display: none;">
					<div style="width: 10px; background-color: rgb(193, 193, 193); position: absolute; cursor: pointer;"></div>
				</div>
			</div>
			<div class="w1170-w">
				<ul class="notice-info-tab">
					<li class="notify curr-tab"> <a href="/">通知</a></li>
					<li class="letter "><a href="/letters">私信</a></li>
					<li class="at "><a href="/ats">@我</a></li>
				</ul>
				<div class="notice-count">
					<span>未读通知：<b class="unread_count">0</b></span>
					<a class="mark_read" href="/notifies/set_readed">全部标记为已读</a>
					<span>
				        &nbsp;
				      </span>
					<a class="mark_read" href="/notifies/message_destroy">清空所有通知</a>
				</div>
				<ul class="notice-list">
				</ul>
				<ul class="pager">
					<li class=" no-msg" style="margin-bottom: 0; height: auto; width: 100%; text-align: center; color: #666; font-size: 16px; display: inline-block; height: 660px;">
						<div class="icon-th-list" style="margin-top: 200px; display: block;">

							<span style="width: 100%; float: none; display: inline;">
							<i class="glyphicon glyphicon-list">&nbsp; </i>您暂时还未收到通知
   							</span>
						</div>
					</li>
				</ul>
			</div>
			<div class="w1170-w row ntf-bg">
				<ul class="notice-info-tab">
					<li class="notify "> <a href="/">通知</a></li>
					<li class="letter curr-tab"><a href="/letters">私信</a></li>
					<li class="at "><a href="/ats">@我</a></li>
				</ul>
				<div class="col-xs-4 col-summary nLeft">
					<div class="nl_setting">
						<a href="/letters?type=1" class="nGzAndWgz ">已关注（未读0）</a>
						<span class="nSeparator">|</span>
						<a href="/letters?type=2" class="nGzAndWgz ">未关注（未读0）</a>
						<a href="javascript:void(0);" class="nSettings dropdown-toggle" data-toggle="dropdown">
							<i class="glyphicon glyphicon-cog"></i>
						</a>
						<ul class="dropdown-menu nsetting-menu">
							<li>
								<span class="nty-top-arr"></span>
								<label href="javascript:void(0);" class="del">
                <a class="icon-ok" href="javascript:void(0);">
                	<i class="glyphicon glyphicon-ok">&nbsp; </i>
                  <span style="font-family: microsoft yahei;">允许所有人私信我</span>
                </a>
           		</label>
							</li>
							<li>
								<label href="javascript:void(0);" class="mark">
                <a href="/letters/set_receive_letter_notify_rule?type=fans_to_other">
                  <span style="font-family: microsoft yahei;">仅允许我关注的人私信我</span>
                </a>
          		</label>
							</li>
						</ul>
					</div>

					<form class="form-inline nty-seabar" action="/letters">
						<label for="keywords"><span class="glyphicon glyphicon-search"></span></label>
						<div class="form-group">
							<input id="keywords" type="text" placeholder="搜索联系人" class="form-control" name="username" value="">
							<input type="submit" style="display:none">
						</div>
					</form>
					<!--使用post方式提交表单，此处会出现 Can't verify CSRF token authenticity 错误,无法读取到cookie中的信息，需要controller中增加 skip_before_filter :verify_authenticity_token, :only => [:del, :mark]-->
					<form class="form-horizontal" method="get" action="#">
						<input type="hidden" name="start_id" value="0">
						<div class="form-group check-all-toolbar">
							<div class="col-xs-6">
								<div class="checkbox select-all">
									<label>
						                <input type="checkbox">全选
						            </label>
								</div>
							</div>
							<div class="col-xs-6 text-right">
								<div class="dropdown nty-pop-small">
									<button id="center-list-menu" type="button" data-toggle="dropdown" class="btn btn-sm btn-default dropdown-toggle">操作 <span class="caret"></span></button>
									<ul aria-labelledby="center-list-menu" class="dropdown-menu">
										<li>
											<span class="nty-top-arr"></span>
											<a class="del" href="javascript:void(0);"><span class="glyphicon glyphicon-trash"></span> 删除私信</a>
											<a class="mark" href="javascript:void(0);"><span class="glyphicon glyphicon-volume-down"></span>标记已读</a>
										</li>
									</ul>
								</div>
							</div>
						</div>
						<div class="media-list" style="min-height: 475px;">
						</div>
					</form>
					<div class="csdn-pagination hide-text hide-set hide-go">
						<span class="page-nav">
				        <a class="btn" href="/letters?start_id=0">&lt;</a>
				        <a class="btn" href="/letters?start_id=10">&gt;</a>
				        </span>
					</div>

					<a class="btnNewMail new-private">
						<i class="glyphicon glyphicon-plus addicon"></i>
						<span>新建私信</span>
					</a>

				</div>
				<div class="col-xs-8 col-content nRight">

					<div class="private-new" style="display:block;">
						<div class="row nty-mas-rtop">
							<h3 class="noy-pl15"><i class="glyphicon glyphicon-envelope">&nbsp; </i> 新私信</h3>
						</div>
						<form class="form-horizontal nty-sent-newmas" name="send_new" action="/letters/send_message" method="get">
							<div class="form-group">
								<label class="pull-left control-label" style="text-align:right;">发给：</label>
								<div class="pull-right">
									<input type="text" placeholder="请输入有效的收信人" name="receiver" class="form-control typeahead">
									<span class="error error-empty help-block">请输入有效的收信人</span>
								</div>
							</div>
							<div class="form-group">
								<label class="pull-left control-label" style="text-align:right;">内容：</label>
								<div class="pull-right">
									<textarea rows="6" class="form-control" name="body" placeholder="可发送200字以内的内容"></textarea>
									<span class="error error-empty help-block">私信内容不能为空</span>
								</div>
							</div>
							<div class="form-group">
								<button class="btn btn-primary send-private" style="margin-left:86px;">私信</button>
							</div>
						</form>
					</div>

					<div class="private-list" style="display:none; margin-left:-15px;margin-right:-15px;">
						<div class="nl_title">
							<i class="icon-envelope-alt"></i>
							<a href="http://my.csdn.net/" class="nl_username" target="_blank">

							</a>
							<span>&nbsp;和我的私信往来</span>
						</div>

						<div class="nl_content">
							<div class="nl_dialog clearfix">
								<!--<div class="nl_show_his"><span class="nl_a_l"></span><a class="nl_a_show_his" href="www.163.com">查看历史消息</a><span class="nl_a_r"></span></div>-->

							</div>
							<div class="nl_input_box nl_input_box2">
							</div>
							<div class="nl_input_box">
								<form class="form-horizontal" name="reply" action="/letters/send_message" method="get">
									<input type="hidden" name="receiver" value="">
									<input type="hidden" name="linker" value="">
									<input name="body" id="content1" class="nl_input" type="text" placeholder="200字以内" maxlength="200">
									<input class="nl_btn_reply" type="submit" value="回复">
								</form>
							</div>

						</div>

					</div>

				</div>
			</div>
		</div>
	</body>
	<script type="text/javascript" src="js/jquery-3.0.0.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
</html>