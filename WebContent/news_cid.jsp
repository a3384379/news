<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>${cname }</title>
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
</head>

<body style="background-color: #F0FFF0">
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
							style="background-color: #E6E6FA; color: red; font-size: 18px; font-weight: bold;">${cname }</div>

						<ul class="list-group" style="list-style: none;">
							<c:set var="num1" value="0" />
							<c:set var="num2" value="1" />
							<c:forEach items="${newsList }" var="news">
								<c:if test="${news.category_id==cid }">
									<c:set var="num1" value="${num1+num2 }" />
									<li class="list-group-item"><a class="a1" style="color: black;"
										href="${pageContext.request.contextPath}/selectNewsById.action?id=${news.id }&url=news.jsp">
											${num1}.${news.title }</a> <span style="float: right;">${news.date }</span></li>
								</c:if>

							</c:forEach>
							<li><img alt="" src=""></li>
						</ul>
					</div>
					<ul class="pagination">
						<li><a
							href="${pageContext.request.contextPath}/findLimit.action?url=news_cid.jsp&cid=${cid}&cname=${cname}&index=${bean.currentPage-1 }">&laquo;</a></li>
						<c:forEach begin="1" end="${bean.totalPage }" varStatus="var">
							<li><a
								href="${pageContext.request.contextPath}/findLimit.action?url=news_cid.jsp&cid=${cid}&cname=${cname}&index=${var.count }">${var.count }</a></li>
						</c:forEach>
						<li><a
							href="${pageContext.request.contextPath}/findLimit.action?url=news_cid.jsp&cid=${cid}&cname=${cname}&index=${bean.currentPage+1 }">&raquo;</a></li>
					</ul>
					<div style="text-align: center;">总页数：&nbsp;${bean.totalPage }&nbsp;&nbsp;当前页数：&nbsp;${bean.currentPage }&nbsp;&nbsp;总条数:${bean.totalCount }</div>

				</div>
				<div class="col-md-2 column"></div>
			</div>
		</div>
	</div>
</body>

</html>


