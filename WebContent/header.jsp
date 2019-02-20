<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<!-- 导航条 -->
<div class="container-fluid">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand"
					href="${pageContext.request.contextPath }/index.jsp">首页</a>
			</div>

			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav" id="categoryUl"></ul>

				<div style="float: right;">
					<c:if test="${not empty cookie.username.value}">
						<div style="width: 110px; height: 50px; float: right;padding-top: 15px">
							<ul>
								<li class="dropdown"><a class="dropdown"
									data-toggle="dropdown" style="color: white;text-decoration: none;cursor:pointer">${cookie.username.value}
										<span class="caret"></span>
								</a>
									<ul class="dropdown-menu" style="min-width: 10px;">
										<li><a
											href="${pageContext.request.contextPath }/ordinaryUserclose.action">退出</a></li>
									</ul></li>
							</ul>
						</div>
					</c:if>

					<c:if test="${cookie.username.value==null}">
						<div style="width: 110px; height: 50px; float: right;padding-top:15px">
							<ul>
								<li class="dropdown" ><a class="dropdown"
									data-toggle="dropdown" style="color: white;text-decoration: none;cursor:pointer">帐号 <span
										class="caret"></span></a>
									<ul class="dropdown-menu" style="min-width: 10px;">
										<li><a href="login.jsp">登录</a></li>
										<li><a href="register.jsp">注册</a></li>
									</ul></li>
							</ul>
						</div>
					</c:if>
				</div>
				<form class="navbar-form" style="float: right;" role="search"
					action="${pageContext.request.contextPath }/searchResult.action">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search" name="keyword" value="${keyword }">
					</div>
					<button type="submit" class="btn btn-default">搜索</button>
				</form>

			</div>
		</div>

		<script type="text/javascript">
			//header.jsp加载完毕后 去服务器端获得所有的category数据
			$(function() {
				var content = "";
				$
						.post(
								"${pageContext.request.contextPath}/categoryListJson.action",
								function(data) {
									//[{"cid":"xxx","cname":"xxxx"},{},{}]
									//动态创建<li><a href="#">${category.cname }</a></li>
									for (var i = 0; i < data.length; i++) {
										content += "<li><a href='${pageContext.request.contextPath}/findLimit.action?url=news_cid.jsp&cid="
												+ data[i].cid
												+ "&cname="
												+ data[i].cname
												+ "&index=1"
												+ "'>"
												+ data[i].cname + "</a></li>";
									}

									//将拼接好的li放置到ul中
									$("#categoryUl").html(content);
								}, "json");
			});
		</script>



	</nav>
</div>