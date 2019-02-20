<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>毕设新闻网首页</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/bootstrap.min.css"
	type="text/css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/a.css" type="text/css" />
<script
	src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"
	type="text/javascript"></script>



<style type="text/css">
#div_buttom {
	width: 100%;
	height: 120px;
	padding: 0px;
	overflow: auto;
}

.new_img {
	float: left;
	margin: 1.3px;
	width: 19.7%;
	height: auto;
}

.new_img input {
	width: 100%;
}
</style>


</head>

<body style="background-color: #F0FFFF">
	<!-- 引入header.jsp -->
	<jsp:include page="/header.jsp"></jsp:include>



	<div class="container">
		<div class="row clearfix">

			<div class="col-md-12 column">
				<!-------------------------------------------------中间----------------------------------------  -->
				<div class="col-md-10 column">
					<div class="panel panel-default">
						<div class="panel-heading" id="showtime"></div>
						<div class="panel-body">
							<!-- 轮播图 -->
							<div class="container-fluid">
								<div id="carousel-example-generic" class="carousel slide"
									data-ride="carousel">
									<!-- 轮播图的中的小点 -->
									<ol class="carousel-indicators">
										<li data-target="#carousel-example-generic" data-slide-to="0"
											class="active"></li>
										<li data-target="#carousel-example-generic" data-slide-to="1"></li>
										<li data-target="#carousel-example-generic" data-slide-to="2"></li>
									</ol>
									<!-- 轮播图的轮播图片 -->
									<div class="carousel-inner" role="listbox">
										<div class="item active">
											<img src="img/h1.jpg" style="width: 1300px; height: 400px" 
												onclick="openNews(45)">
											<div class="carousel-caption">
												<!-- 轮播图上的文字 -->
												美媒：美军对华最大优势正逐渐丧失
											</div>
										</div>
										<div class="item">
											<img src="img/h2.jpg" style="width: 1300px; height: 400px"
												onclick="openNews(46)">
											<div class="carousel-caption">
												<!-- 轮播图上的文字 -->
												克什米尔地区发生恐袭 外交部：坚决反对并强烈谴责
											</div>
										</div>
										<div class="item">
											<img src="img/h3.jpg" style="width: 1300px; height: 400px"
												onclick="openNews(47)">
											<div class="carousel-caption">
												<!-- 轮播图上的文字 -->
												英航母要来南海？英专家：若真有冲突，中国1小时内就能击沉
											</div>
										</div>
									</div>
									<script type="text/javascript">
										function openNews(d){
											location.href = "http://localhost:8080/news/selectNewsById.action?id="
												+ d + "&url=news.jsp"
										}
									</script>

									<!-- 上一张 下一张按钮 -->
									<a class="left carousel-control"
										href="#carousel-example-generic" role="button"
										data-slide="prev"> <span
										class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
										<span class="sr-only">Previous</span>
									</a> <a class="right carousel-control"
										href="#carousel-example-generic" role="button"
										data-slide="next"> <span
										class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
										<span class="sr-only">Next</span>
									</a>
								</div>
							</div>

						</div>

						<ul class="list-group" style="list-style: none;">
							<c:forEach items="${newsList }" var="news" varStatus="var">
								<c:if test="${var.count>6&&var.count<=15 }">
									<li class="list-group-item"><a class="a1"
										style="color: black;"
										href="${pageContext.request.contextPath}/selectNewsById.action?id=${news.id }&url=news.jsp">
											${var.count-6}.${news.title }</a></a><span style="float: right;">${news.date }</span></li>
								</c:if>
							</c:forEach>
							<li><img alt="" src=""></li>
						</ul>

						<!--图片新闻栏  -->
						<div id="div_buttom">
							<div class="new_img">
								<input type="image" src="img/1.jpg" name="" id="40" value="" />
							</div>
							<div class="new_img">
								<input type="image" src="img/2.jpg" name="" id="41" value="" />
							</div>
							<div class="new_img">
								<input type="image" src="img/3.jpg" name="" id="42" value="" />
							</div>
							<div class="new_img">
								<input type="image" src="img/4.jpg" name="" id="43" value="" />
							</div>
							<div class="new_img">
								<input type="image" src="img/5.jpg" name="" id="44" value=""
									title="hahah" />
							</div>

						</div>

						<ul class="list-group" style="list-style: none;">
							<c:forEach items="${newsList }" var="news" varStatus="var">
								<c:if test="${var.count>15&&var.count<=100 }">
									<li class="list-group-item"><a class="a1"
										style="color: black;"
										href="${pageContext.request.contextPath}/selectNewsById.action?id=${news.id }&url=news.jsp">
											${var.count-6}.${news.title }</a><span style="float: right;">${news.date }</span></li>
								</c:if>
							</c:forEach>
							<li><img alt="" src=""></li>
						</ul>
					</div>
				</div>
				<!--------------热点新闻--------------------->
				<div class="col-md-2 column">
					<div class="panel panel-default">
						<div class="panel-heading"></div>
						<div class="panel-body"
							style="background-color: #B0E0E6; color: red; font-size: 18px; font-weight: bold;">热点新闻</div>

						<ul class="list-group" style="list-style: none;">
							<c:forEach items="${newsList }" var="news" varStatus="var">
								<c:if test="${var.count<=6 }">
									<li class="list-group-item"><a class="a1"
										style="color: black;"
										href="${pageContext.request.contextPath}/selectNewsById.action?id=${news.id }&url=news.jsp">
											${var.count}.${news.title }</a></li>
								</c:if>

							</c:forEach>
							<li><img alt="" src=""></li>
						</ul>
					</div>

				</div>

				<div class="row clearfix">
					<div class="col-md-3 column"></div>
					<div class="col-md-2 column"></div>
					<div class="col-md-2 column"></div>
					<div class="col-md-2 column"></div>
					<div class="col-md-3 column"></div>
				</div>


			</div>
		</div>

		<script>
			window.onload = function() {
				setInterval(showTime, 1000);
				var img = document.getElementById("div_buttom");
				var news = img.getElementsByTagName("input");
				for (var i = 0; i < news.length; i++) {
					news[i].onclick = function() {
						location.href = "http://localhost:8080/news/selectNewsById.action?id="
								+ this.id + "&url=news.jsp"
					}
				}
			}

			function showTime() {
				var date = new Date();
				var time = date.getFullYear();
				document.getElementById("showtime").innerHTML = date
						.getFullYear()
						+ "年"
						+ (date.getMonth() + 1)
						+ "月"
						+ date.getDate()
						+ "日" + " " + date.toLocaleTimeString()
			}
		</script>




		<!-- 引入footer.jsp -->
		<jsp:include page="/footer.jsp"></jsp:include>
</body>

</html>


