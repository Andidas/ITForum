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
<meta http-equiv="description" content="loginAndRegister">
<meta charset="UTF-8">
<title>导航条</title>
<link href="css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-3.0.0.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<style type="text/css">
.login {
	padding-right: 40px;
}

.login span {
	padding: 0 8px 0 0;
}

.login .dropdown-menu li:hover a {
	background-color: #0366D6;
	color: white;
}
</style>
<link rel="stylesheet" type="text/css" href="css/search-form.css">
</head>
<body>
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
					<a class="navbar-brand" href="index.jsp">ITFOURM</a>
				</div>

				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					

					<form onsubmit="submitFn(this, event);">
			            <div class="search-wrapper">
			                <div class="input-holder">
			                    <input type="text" class="search-input" placeholder="Type to search" />
			                    <button class="search-icon" onclick="searchToggle(this, event);"><span></span></button>
			                </div>
			                <span class="close" onclick="searchToggle(this, event);"></span>
			                <div class="result-container">
			                </div>
			            </div>
			       </form>

					<div class="login">
						<ul class="nav navbar-nav navbar-right">
							<c:if test="${empty sessionScope.NowLoginUser.uemail}">
								<li><a href="UserServlet?op=toLogin"><span
										class="glyphicon glyphicon-user"></span>注册</a></li>
								<li><a href="UserServlet?op=toLogin"><span
										class="glyphicon glyphicon-log-in"></span>登录</a></li>
							</c:if>
							<c:if test="${!empty sessionScope.NowLoginUser.uemail}">
								<li class="dropdown"><a href="#" class="dropdown-toggle"
									data-toggle="dropdown"> <img alt="user"
										src="<c:if test="${not empty sessionScope.NowLoginUser.uhead}"><%=basePath%>files/${sessionScope.NowLoginUser.uhead}</c:if><c:if test="${empty sessionScope.NowLoginUser.uhead}"><%=basePath%>files/ITForum.jpg</c:if>"
										width="22" height="22" class="img-rounded" /> <strong
										class="caret"></strong>
								</a>
									<ul class="dropdown-menu ">
										<li class="dropdown-header header-nav-current-user css-truncate">
											<input type="hidden" value="${sessionScope.NowLoginUser.uid}" id="nowUserID"/>
											欢迎您！ <strong class="css-truncate-target" id="nowUserName">${sessionScope.NowLoginUser.uname}</strong>
										</li>
										<li class="divider"></li>
										<li><a href="user.jsp" class="dropdown-item">个人信息</a></li>

										<li class="divider"></li>
										<li><a href="#" class="dropdown-item"> 帮助</a></li>
										<li><a href="#" class="dropdown-item"> 设置</a></li>
										<li><a href="javaScript:void(0)" class="dropdown-item"
											id="exitEmail"> 退出</a></li>
									</ul></li>
							</c:if>
						</ul>
					</div>
				</div>
			</div>
		</nav>
	</div>
</body>
<script type="text/javascript">
$(document).ready(function(){
		$("#exitEmail").click(function(){
			location.href='<%=basePath%>UserServlet?op=exitUser';
		});
	});
</script>
<!-- 搜索框 -->
<script type="text/javascript">
        function searchToggle(obj, evt){
            var container = $(obj).closest('.search-wrapper');

            if(!container.hasClass('active')){
                  container.addClass('active');
                  evt.preventDefault();
            }
            else if(container.hasClass('active') && $(obj).closest('.input-holder').length == 0){
                  container.removeClass('active');
                  // clear input
                  container.find('.search-input').val('');
                  // clear and hide result container when we press close
                  container.find('.result-container').fadeOut(100, function(){$(this).empty();});
            }
        }

        function submitFn(obj, evt){
            value = $(obj).find('.search-input').val().trim();

            _html = "Yup yup! Your search text sounds like this: ";
            if(!value.length){
                _html = "Yup yup! Add some text friend :D";
            }
            else{
                _html += "<b>" + value + "</b>";
            }

            $(obj).find('.result-container').html('<span>' + _html + '</span>');
            $(obj).find('.result-container').fadeIn(100);

            evt.preventDefault();
        }
    </script>
</html>