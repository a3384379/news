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
<script
	src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"
	type="text/javascript"></script>

<script>
	window.onload = function() {
		setInterval(showTime, 1000);
	}

	function showTime() {
		var date = new Date();
		var time = date.getFullYear();
		document.getElementById("showtime").innerHTML = "当前时间："
				+ date.toLocaleDateString() + "--" + date.toLocaleTimeString()
	}
</script>

<style>
#myBtn {
	display: none;
	position: fixed;
	bottom: 70px;
	right: 30px;
	width: 50px;
	height: 50px;
}
</style>


</head>

<body style="background-color: #F5FFFA">
	<!-- 引入header.jsp -->
	<jsp:include page="/header.jsp"></jsp:include>
	<h3>${news.title }</h3>


	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<div class="col-md-1 column"></div>
				<div class="col-md-8 column">
					<div style="text-align: left;">${news.test }</div>
				</div>
				<div class="col-md-1 column"></div>
			</div>
		</div>
	</div>
	<h style="font-size: 30px; color: red;">最新评论 </h>
	评论数:
	<span id="sp1"></span>
	<div
		style="width: 100%; height: 250px; background-color: #F0FFFF; overflow: auto;">
		<hr>
		<%-- 		<c:if test="${empty commentList}">
			<p style="font-size: 13px; text-align: center; color: #082E54;">暂无评论</p>
		</c:if> --%>
		<c:forEach items="${commentList }" var="comment">
			<c:if test="${comment.news_id==news.id }">
				<p name='a1'>用户名：${comment.user}&nbsp;&nbsp;&nbsp;评论时间：
					${comment.date}</p>
				${comment.test }
				<hr>
			</c:if>
		</c:forEach>

	</div>
	<hr>
	<script type="text/javascript">
		var ptest = document.getElementsByName('a1')
		document.getElementById('sp1').innerText = ptest.length
	</script>

	<div class="row clearfix">
		<div class="col-md-2 column"></div>
		<div class="col-md-8 column">

			<form
				action="${pageContext.request.contextPath }/updateComment.action">
				<textarea id="text1" name="test"
					style="width: 100%; height: 200px; resize: none;"></textarea>
				<input type="hidden" name="news_id" value="${news.id }">
				<button type="submit" value="" style="float: right;">提交</button>
			</form>
		</div>


		<div class="col-md-2 column"></div>
	</div>

	<button
		style="width: 50px; height: 50px; position: fixed; bottom: 20px;right: 30px; font-size: 15px;"
		onclick="back()">返回</button>
	<script type="text/javascript">
		function back() {
			window.history.back()
		}
	</script>

	<button onclick="topFunction()" id="myBtn" title="回顶部">返回顶部</button>
	<script>
		// 当网页向下滑动 20px 出现"返回顶部" 按钮
		window.onscroll = function() {
			scrollFunction()
		};

		function scrollFunction() {
			console.log(121);
			if (document.body.scrollTop > 20
					|| document.documentElement.scrollTop > 20) {
				document.getElementById("myBtn").style.display = "block";
			} else {
				document.getElementById("myBtn").style.display = "none";
			}
		}

		// 点击按钮，返回顶部
		function topFunction() {
			document.body.scrollTop = 0;
			document.documentElement.scrollTop = 0;
		}
	</script>

	<!-- 引入footer.jsp -->
	<jsp:include page="/footer.jsp"></jsp:include>

</body>

</html>