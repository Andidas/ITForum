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

</head>
<body>
<body class="user-page" style="margin-top: 80px">
	<jsp:include page="nav.jsp" flush="true"></jsp:include>
	<div class="container" id="content">
		<div class="clearfix">
			<div class="col-md-12 column">
				<ul id="myTab" class="nav nav-tabs">
					<li class="active"><a href="#profile" data-toggle="tab">
							Profile</a></li>
					<li><a href="#activity" data-toggle="tab">Activity</a></li>
					<c:if test="${not empty NowLoginUser }">
					<li><a href="#edit" data-toggle="tab">编辑</a></li>
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
									<a href="https://stackoverflow.com/users/2970947/elliott-frisch">
										<div class="gravatar-wrapper-164">
											<img src="https://i.stack.imgur.com/HAq55.png?s=328&amp;g=1"
												alt="" width="164" height="164" class="avatar-user">
										</div>
									</a>
								</div>
								<div class="reputation" title="reputation">
									131,472 <span class="label-uppercase">reputation</span>
								</div>

								<div class="g-row _gutters ai-start fl-none -row-first">
									<div class="g-col g-row g-center badge1-alternate"
										title="12 gold badges">
										<span class="g-col fl-none -badge badge1"></span> <span
											class="g-col g-center -total">12</span>
									</div>

									<div class="g-col g-row g-center badge2-alternate"
										title="69 silver badges">
										<span class="g-col fl-none -badge badge2"></span> <span
											class="g-col g-center -total">69</span>
									</div>

									<div class="g-col g-row g-center badge3-alternate"
										title="138 bronze badges">
										<span class="g-col fl-none -badge badge3"></span> <span
											class="g-col g-center -total">138</span>
									</div>

								</div>

							</div>
						</div>
						<div class="col-lg-9">
							<div class="col-left col-md-7 about">
								<h2 class="user-card-name">Elliott Frisch</h2>
								<div class="current-position">Big Data Engineer</div>
								<div class="bio">
									<h1>SOreadytohelp</h1>
									<p>Just a Software Engineer working with Big Data in the
										greater Atlanta, GA area.</p>
									<p>All opinions and views expressed are entirely my own.</p>
									<p>Just a Software Engineer working with Big Data in the
										greater Atlanta, GA area.</p>
									<p>All opinions and views expressed are entirely my own.</p>

									<hr>
								</div>

							</div>
							<div class="col-right col-md-5">
								<div class="user-links">
									<div class="user-stats">
										<div class="row" style="margin: 0;">
											<div class="stat">
												<span class="number">5,852</span> answers
											</div>

											<div class="stat">
												<span class="number">0</span> questions
											</div>
											<div class="stat">
												<span class="number">~4.0m</span> people reached
											</div>
										</div>
									</div>

									<div class="user-link">
										<ul class="list-unstyled">
											<li><svg aria-hidden="true"
													class="svg-icon iconLocation" width="18" height="18"
													viewBox="0 0 18 18">
													<path
														d="M8.1 17.7S2 9.9 2 6.38A6.44 6.44 0 0 1 8.5 0C12.09 0 15 2.86 15 6.38 15 9.91 8.9 17.7 8.9 17.7c-.22.29-.58.29-.8 0zm.4-8.45a2.75 2.75 0 1 0 0-5.5 2.75 2.75 0 0 0 0 5.5z"></path></svg>
												Atlanta, GA</li>
											<li><svg aria-hidden="true" class="svg-icon iconLink"
													width="18" height="18" viewBox="0 0 18 18">
													<path
														d="M2.9 9c0-1.16.94-2.1 2.1-2.1h3V5H5a4 4 0 1 0 0 8h3v-1.9H5A2.1 2.1 0 0 1 2.9 9zM13 5h-3v1.9h3a2.1 2.1 0 1 1 0 4.2h-3V13h3a4 4 0 1 0 0-8zm-7 5h6V8H6v2z"></path></svg>
												<a href="http://www.frischcode.com" rel="me noreferrer"
												class="url">frischcode.com</a></li>
											<li><svg aria-hidden="true" class="svg-icon iconHistory"
													width="19" height="18" viewBox="0 0 19 18">
													<path
														d="M3 9a8 8 0 1 1 3.73 6.77L8.2 14.3A6 6 0 1 0 5 9l3.01-.01-4 4-4-4h3zm7-4h1.01L11 9.36l3.22 2.1-.6.93L10 10V5z"></path></svg>
												Member for <span title="2013-11-09 01:20:44Z">3
													years, 11 months</span></li>
											<li><svg aria-hidden="true" class="svg-icon iconEye"
													width="18" height="18" viewBox="0 0 18 18">
													<path
														d="M9.06 3C4 3 1 9 1 9s3 6 8.06 6C14 15 17 9 17 9s-3-6-7.94-6zM9 13a4 4 0 1 1 0-8 4 4 0 0 1 0 8zm2-4a2 2 0 0 1-2 2 2 2 0 0 1-2-2 2 2 0 0 1 2-2 2 2 0 0 1 2 2z"></path></svg>
												11,727 profile views</li>
											<li><svg aria-hidden="true" class="svg-icon iconClock"
													width="18" height="18" viewBox="0 0 18 18">
													<path
														d="M9 17A8 8 0 1 1 9 1a8 8 0 0 1 0 16zm0-2A6 6 0 1 0 9 3a6 6 0 0 0 0 12zM8 5h1.01L9 9.36l3.22 2.1-.6.93L8 10V5z"></path></svg>
												Last seen <span title="2017-10-23 02:04:28Z"
												class="relativetime">3 mins ago</span></li>
										</ul>
									</div>

								</div>
							</div>
						</div>
					</div>
					<div class="clearfix" id="sidebar">
						<div class="col-md-3">
							<div class="module" id="interesting-tags">
								<h4 id="h-interesting-tags">Favorite Tags</h4>
								<a id="edit-interesting">edit</a>
								<div>
									<a href="#" class="label label-danger labeltag" title="java"
										rel="tag">java<span class="glyphicon glyphicon-remove"
										title="remove this tag"></span></a> <a href="#"
										class="label label-danger labeltag" title="go" rel="tag">go<span
										class="glyphicon glyphicon-remove" title="remove this tag"></span></a>
									<a href="#" class="label label-danger labeltag" title="html"
										rel="tag">html<span class="glyphicon glyphicon-remove"
										title="remove this tag"></span></a> <a href="#"
										class="label label-danger labeltag" title="css" rel="tag">css<span
										class="glyphicon glyphicon-remove" title="remove this tag"></span></a>

								</div>
								<div id="addTag">
									<input type="text" name="interestingTag" autocomplete="off"
										class="form-control">
									<button class="btn btn-success">add</button>
								</div>
							</div>
						</div>
						<div class="col-md-9">
							<ul id="Tabson" class="nav nav-tabs ">
								<li>
									<h4>10tiao</h4>
								</li>
								<li class="active pull-right"><a href="#answers"
									data-toggle="tab"> answers</a></li>
								<li class="pull-right"><a href="#questions"
									data-toggle="tab">questions</a></li>
								<li class="pull-right"><a href="#All" data-toggle="tab">All</a></li>
							</ul>
							<div id="TabContentSon" class="tab-content">
								<div class="tab-pane fade in active" id="All">
									<table class="table table-hover table-condensed table-striped">
										<thead>
											<tr>
												<th>赞</th>
												<th>题目</th>
												<th>时间</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>1</td>
												<td>Java program advice</td>
												<td>01/04/2012</td>

											</tr>
											<tr class="success">
												<td>1</td>
												<td>StudentGPA.java:5: error: '.class' expected error</td>
												<td>01/04/2012</td>

											</tr>
											<tr class="error">
												<td>2</td>
												<td>TB - Monthly</td>
												<td>02/04/2012</td>

											</tr>
											<tr class="warning">
												<td>3</td>
												<td>TB - Monthly</td>
												<td>03/04/2012</td>

											</tr>
											<tr class="info">
												<td>4</td>
												<td>TB - Monthly</td>
												<td>04/04/2012</td>

											</tr>
										</tbody>
									</table>
									<ul class="pagination">
										<li><a href="#">Prev</a></li>
										<li><a href="#">1</a></li>
										<li><a href="#">2</a></li>
										<li><a href="#">3</a></li>
										<li><a href="#">4</a></li>
										<li><a href="#">5</a></li>
										<li><a href="#">Next</a></li>
									</ul>
								</div>
								<div class="tab-pane fade" id="questions">
									<p>iOS 是一个由苹果公司开发和发布的手机操作系统。最初是于 2007 年首次发布 iPhone、iPod
										Touch 和 Apple TV。iOS 派生自 OS X，它们共享 Darwin 基础。OS X
										操作系统是用在苹果电脑上，iOS 是苹果的移动版本。</p>
								</div>
								<div class="tab-pane fade" id="answers">
									<p>jMeter 是一款开源的测试软件。它是 100% 纯 Java 应用程序，用于负载和性能测试。</p>
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>
			<div class="tab-pane fade" id="activity">
				<div class="clearfix">222222</div>
			</div>
			<div class="tab-pane fade" id="edit">
				<div class="clearfix">
					<div class="col-md-12 column">
						<form role="form" method="post" enctype="multipart/form-data" action="UserServlet?op=update">
							<div class="col-md-3">
								<div class="thumbnail">
									<img src="<c:if test="${not empty sessionScope.NowLoginUser.uhead}"><%=basePath%>files/${sessionScope.NowLoginUser.uhead}</c:if><c:if test="${empty sessionScope.NowLoginUser.uhead}"><%=basePath%>files/ITForum.jpg</c:if>" alt="图片不符合规范" 
										id="userPicture" style="width:235;height:235;">
									<div class="caption">
										<label for="setUserPicture" class="btn btn-success btn-block">set
											picture</label><input type="file" id="setUserPicture" class="hidden" name = "userPicture" value="${sessionScope.NowLoginUser.uhead}"/>
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
						                <em style='color:red'>200</em>/<span>200</span>
						            </div>
								</div>
								<button type="submit" class="btn btn-default" id="setUserInfo">Submit</button>
							</div>
							
						</form>

					</div>
				</div>

			</div>
		</div>
	</div>

</body>
<script type="text/javascript">
	$(function(){
		textAreaChange($("#userBio"));
	});
    //显示限制输入字符method
    function textAreaChange(obj){
        var $this = $(obj);
        var count_total = $this.next().children('span').text();
        var count_input = $this.next().children('em');
        var area_val = $this.val();
        if(area_val.len()>count_total){
            area_val = autoAddEllipsis(area_val,count_total);//根据字节截图内容
            $this.val(area_val);
            count_input.text(0);//显示可输入数
        }else{
            count_input.text(count_total - area_val.len());//显示可输入数
        }
    }
    //得到字符串的字节长度
    String.prototype.len = function(){
        return this.replace(/[^\x00-\xff]/g, "xx").length;
    };
    /*
     * 处理过长的字符串，截取并添加省略号
     * 注：半角长度为1，全角长度为2
     * pStr:字符串
     * pLen:截取长度
     * return: 截取后的字符串
     */
    function autoAddEllipsis(pStr, pLen) {
        var _ret = cutString(pStr, pLen);
        var _cutFlag = _ret.cutflag;
        var _cutStringn = _ret.cutstring;
        return _cutStringn;
    }
    /*
     * 取得指定长度的字符串
     * 注：半角长度为1，全角长度为2
     * pStr:字符串
     * pLen:截取长度
     * return: 截取后的字符串
     */
    function cutString(pStr, pLen) {
        // 原字符串长度
        var _strLen = pStr.length;
        var _tmpCode;
        var _cutString;
        // 默认情况下，返回的字符串是原字符串的一部分
        var _cutFlag = "1";
        var _lenCount = 0;
        var _ret = false;
        if (_strLen <= pLen/2){_cutString = pStr;_ret = true;}
        if (!_ret){
            for (var i = 0; i < _strLen ; i++ ){
                if (isFull(pStr.charAt(i))){_lenCount += 2;}
                else {_lenCount += 1;}
                if (_lenCount > pLen){_cutString = pStr.substring(0, i);_ret = true;break;}
                else if(_lenCount == pLen){_cutString = pStr.substring(0, i + 1);_ret = true;break;}
            }
        }
        if (!_ret){_cutString = pStr;_ret = true;}
        if (_cutString.length == _strLen){_cutFlag = "0";}
        return {"cutstring":_cutString, "cutflag":_cutFlag};
    }
    /*
     * 判断是否为全角
     *
     * pChar:长度为1的字符串
     * return: true:全角
     *         false:半角
     */
    function isFull (pChar){
        if((pChar.charCodeAt(0) > 128)){return true;}
        else{return false;}
    }
</script>
<script type="text/javascript">
		
		/*显示图片*/
		$(document).ready(function(){
			$("#setUserPicture").change(function(){
				if($(this).val()!=""){
					$("#userPicture").attr('src',getObjURL(this.files[0]));
				}
			});
			
		});
		function getObjURL(file){
			var url = null;
			if(window.createObjectURL!=undefined){
				url = window.createObjectURL(file);    //basic
			}else if(window.URL!=undefined){
				url = window.URL.createObjectURL(file);  //火狐
			}else if(window.webkitURL!=undefined){
				url = window.webkitURL.createObjectURL(file);   //google
			}
			return url;
		}
	</script>
</html>