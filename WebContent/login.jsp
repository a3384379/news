<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>会员登录</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="css/style.css" type="text/css" />

<style>
body {
	margin-top: 20px;
	margin: 0 auto;
}

.carousel-inner .item img {
	width: 100%;
	height: 300px;
}

.container .row div {
	/* position:relative;
				 float:left; */
	
}

font {
	color: #666;
	font-size: 22px;
	font-weight: normal;
	padding-right: 17px;
}
</style>
</head>
<body style="background-color: #F8F8FF">

	<!-- 引入header.jsp -->
	<jsp:include page="/header.jsp"></jsp:include>


	<div class="container"
		style="width: 100%; height: 440px; background-color: #E6E6FA;">
		<div class="row">
			<div class="col-md-7">
				<!--<img src="./image/login.jpg" width="500" height="330" alt="会员登录" title="会员登录">-->
			</div>

			<div class="col-md-5">
				<div
					style="width: 440px; border: 1px solid #E7E7E7; padding: 20px 0 20px 30px; border-radius: 5px; margin-top: 60px; background: #fff;">
					<font>会员登录</font>USER LOGIN
					<div>&nbsp;</div>
					<form class="form-horizontal"
						action="${pageContext.request.contextPath}/ordinaryUserLogin.action">
						<div class="form-group">
							<label for="username" class="col-sm-2 control-label">用户名</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" name="username" value="${use }"
									id="username" placeholder="请输入用户名">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
							<div class="col-sm-6">
								<input type="password" class="form-control" id="inputPassword3"  value="${pas }"
									name="password" placeholder="请输入密码">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label" style="margin-top: 20PX;">验证码</label>
							<div class="form-group  col-lg-4" >
								<div class="col-sm-7">
									    <input type="text" id="code" name="code"
										class="form-control" style="width: 190px;"/>         <img
										id="imgObj" alt="验证码" src="${pageContext.request.contextPath }/validateCode.action"
										onclick="changeImg()" />         <a href="#"
										onclick="changeImg()">换一张</a>    
								</div>
							</div>

							<script type="text/javascript">
								// 刷新图片
								function changeImg() {
									var imgSrc = $("#imgObj");
									var src = imgSrc.attr("src");
									imgSrc.attr("src", changeUrl(src));
								}
								//为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳
								function changeUrl(url) {
									var timestamp = (new Date()).valueOf();
									var index = url.indexOf("?", url);
									if (index > 0) {
										url = url.substring(0, index);
									}
									if ((url.indexOf("&") >= 0)) {
										url = url + "×tamp=" + timestamp;
									} else {
										url = url + "?timestamp=" + timestamp;
									}
									return url;
								}
							</script>

						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<input type="submit" width="100" value="登录" name="submit"
									style="background: url('./images/login.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0); height: 35px; width: 100px; color: white;">
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- 引入footer.jsp -->
	<jsp:include page="/footer.jsp"></jsp:include>

</body>
</html>