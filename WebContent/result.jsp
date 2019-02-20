<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>查询结果</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/bootstrap.min.css"
	type="text/css" />
<script
	src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"
	type="text/javascript"></script>

</head>
<body style="background-color: #FFFACD">
	<!-- 引入header.jsp -->
	<jsp:include page="/header.jsp"></jsp:include>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<div class="col-md-2 column"></div>
				<div class="col-md-8 column">
					<div class="panel panel-default">
						<div class="panel-heading"></div>
						<div class="panel-body"
							style="background-color: #E6E6FA; color: red; font-size: 18px; font-weight: bold;">查询结果</div>

						<ul class="list-group" style="list-style: none;">
							<c:forEach items="${searchResult }" var="news" varStatus="var">
								<li class="list-group-item"><a style="color: black;"
									href="${pageContext.request.contextPath}/selectNewsById.action?id=${news.id }&url=news.jsp">
										${var.count} .${news.title }</a><span style="float: right;">${news.date }</span></li>
							</c:forEach>
						</ul>

					</div>
				</div>
				<div class="col-md-2 column"></div>
			</div>
		</div>
	</div>

</body>
</html>