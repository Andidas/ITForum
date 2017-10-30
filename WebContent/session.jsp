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
<script type="text/javascript">
		</script>
<style type="text/css">
body {
	margin: 50px;
}

.content-text li {
	float: left;
}
</style>

</head>
<body>
	<jsp:include page="nav.jsp" flush="true"/>
	<div class="clearfix container">
		<div class="row-fluid">
			<div class="col-xs-8">
				<div class="row-fluid">
					<img src="img/骑行.jpg" class="img-thumbnail pull-left" width="200"
						height="187" class="col-xs-4" />
					<div class="page-header col-xs-8">
						<h1>
							java <small>Subtext for header</small>
						</h1>
						<a class="btn btn-info" href="#writeTopic">发表帖子</a>
					</div>
				</div>
			</div>
			<div class="col-xs-4">
				<div class="container">
					<table>
						<tbody>
							<tr>
								<td>
									<p class="label-key">asked</p>
								</td>
								<td style="padding-left: 10px">
									<p class="label-key" title="2009-07-30 15:36:42Z">
										<b>8 years, 2 months ago</b>
									</p>
								</td>
							</tr>
							<tr>
								<td>
									<p class="label-key">viewed</p>
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
			</div>
		</div>
		<div class="col-md-8">

			<div class="column">
				<ul class="content-text">
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
		</div>
		<div class="col-md-4">

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
</html>