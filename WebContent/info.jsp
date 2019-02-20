<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>学生信息展示</title>
		<link rel="stylesheet" href="css/bootstrap.css" type="text/css" />
		<script src="js/jquery-3.3.1.js" type="text/javascript"></script>
		<script src="js/bootstrap.js" type="text/javascript"></script>
	</head>

	<body>
		<div class="container-fluid">

			<!-- 引入header.jsp -->
			<jsp:include page="/header.jsp"></jsp:include>

			<div class="container-fluid">
				<div class="main_con">
					<h2>学生简介</h2>
					<hr/>
					<div style="font-family: inherit;">
						<p>姓名：苏邱钊</p>
						<p>学院：漓江学院</p>
						<p>年级：2015</p>
						<p>专业：电子信息工程</p>
						<p>学号：201513007640</p>
					</div>
					<br><br>
					<h3>选题以及要求:</h2>
					<hr/>
					<div>
						<p>题目：基于SSM的新闻管理系统 </p>
						<p>对新闻管理系统进行需求分析和系统设计以及页面设计，并用Spring+SpringMVC+MyBatis进行框架的搭建，然后基于这些的企业级JAVA EE实现用户的登陆，退出，加密，验证码等功能，以及管理员对前面新闻网站的添加新闻。新闻分类，删除分类，添加分类，新闻编辑，视频新闻等功能。</p>
					</div>
				</div>
			</div>
		</div>
		
		<!-- 引入footer.jsp -->
		<jsp:include page="/footer.jsp"></jsp:include>

	</body>

</html>