<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<title>版块</title>


<link href="css/init.css" rel="stylesheet" />
<link href="css/session.css" rel="stylesheet" />
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
					java<a href="javaScript:void(0)" class="follow" id="follow"
						style="display: none;"><span>关注</span></a> <a class="unfollow"
						id="unfollow" href="javaScript:void(0)" style="">取消关注 </a> <small>关注:<span>4561</span>提问:<span>1235</span></small>
				</h1>
				金钱与未来，你的选择是什么？
			</div>
		</div>
		<div class="col-md-8" id="mainContent">
			<ul class="content-text clearfix">
				<li>
					<div class="panel">
						<div class="panel-heading">
							<a href="topic.html">题目sdf</a> <span
								class="glyphicon glyphicon-log-out"></span> 22
						</div>
						<div class="panel-body">
							<p>用起来感觉一般般，也可能是我带投石车的都不是高武武将吧。总是砸到自己人，砸敌人的sdfasdfsdfds</p>

						</div>
						<div class="panel-footer">
							<span class="glyphicon glyphicon-user"></span> <a
								href="user.html" title="主题作者" target="_blank"> 1900lwy</a> <span
								class="glyphicon glyphicon-time"></span> <span class="time">10月
								10日 00:22</span>
						</div>
					</div>
				</li>
				<li>
					<div class="panel">
						<div class="panel-heading">
							<a href="topic.html">题目sdf</a> <span
								class="glyphicon glyphicon-log-out"></span> 22
						</div>
						<div class="panel-body">
							<p>用起来感觉一般般，也可能是我带投石车的都不是高武武将吧。总是砸到自己人，砸敌人的sdfasdfsdfds</p>

						</div>
						<div class="panel-footer">
							<span class="glyphicon glyphicon-user"></span> <a
								href="user.html" title="主题作者" target="_blank"> 1900lwy</a> <span
								class="glyphicon glyphicon-time"></span> <span class="time">10月
								10日 00:22</span>
						</div>
					</div>
				</li>
			</ul>
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
<script type="text/javascript">
	$(document).ready(function(){
		$("#follow").click(function(){
			$(this).hide();
			$("#unfollow").show();
		});
		$("#unfollow").click(function(){
			$(this).hide();
			$("#follow").show();
		});
	});
</script>
</html>