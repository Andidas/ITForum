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
<title>login</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="login">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width,initial-scale=1.0" />
<title>登录</title>
<link href="css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-3.0.0.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<style type="text/css">
#login form>div {
	padding: 0 30px;
}

#login {
	padding-top: 50px;
}

#login label {
	padding: 10px 0 5px 0;
	display: block;
	text-align: left;
}

#login .other {
	list-style: none;
}

#login .other>li a {
	float: left;
	font-size: 12px;
	padding: 4px;
	color: #000000;
}

#login .other>li a:hover {
	color: dodgerblue;
}
</style>
</head>
<body>
	<div class="container" id="login">
		<div class="row clearfix">
			<div class="col-md-4 column col-md-offset-4">
				<div class="col-sm-offset-0.5 col-sm-11">
					<div class="text-center">
						<img src="img/骑行.jpg" width="48" height="48" class="img-circle" />
						<h3>
							登录 <small>GitHub</small>
						</h3>
					</div>
					<div class="panel panel-default">
						<form class="form-horizontal " role="form" action="userLogin"
							method="post">
							<div class="form-group ">
								<label for="inputEmail3" class=" control-label">Email</label> <input
									type="email" class="form-control" id="inputEmail3" name="email" />

							</div>
							<div class="form-group">
								<label for="inputPassword3" class=" control-label">Password
									<a href="#" class="label-link small" style="float: right;">Forgot
										password?</a>
								</label> <input type="password" name="password" class="form-control"
									id="inputPassword3" />

							</div>
							<div class="form-group">
								<div class="col-sm-offset-1 col-sm-11">
									<div class="checkbox">
										<label><input type="checkbox" />Remember me</label>
									</div>
								</div>
							</div>
							<div class="form-group">

								<button type="submit"
									class="btn btn-block btn-default btn-success">按钮</button>

							</div>
						</form>
					</div>
					<div class="panel panel-default">
						<div class="panel-body text-center">
							New to GitHub? <a href="#" class="text-right">Create an
								account</a>.
						</div>
					</div>
					<div class="text-center">
						<ul class="other">
							<li><a href="#">Terms</a></li>
							<li><a href="#">Privacy</a></li>
							<li><a href="#">Security</a></li>
							<li><a href="#">Contact GitHub</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>