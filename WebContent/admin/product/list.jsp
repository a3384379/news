<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/css/Style1.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function addProduct() {
		window.location.href = "${pageContext.request.contextPath}/categoryList.action?url=admin/product/add.jsp";
	}
	function del(id) {
		var flag = confirm("是否删除信息");
		if(flag) {
			location.href="${pageContext.request.contextPath}/deleteNewsById.action?id="+id;
		}
}
</script>
</HEAD>
<body>
	<br>
	<form id="Form1" name="Form1"
		action="${pageContext.request.contextPath}/user/list.jsp"
		method="post">
		<table cellSpacing="1" cellPadding="0" width="100%" align="center"
			bgColor="#f5fafe" border="0">
			<TBODY>
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3"><strong>新闻列表</strong>
					</TD>
				</tr>
				<tr>
					<td class="ta_01" align="right">
						<button type="button" id="add" name="add" value="添加"
							class="button_add" onclick="addProduct()">
							&#28155;&#21152;</button>

					</td>
				</tr>
				<tr>
					<td class="ta_01" align="center" bgColor="#f5fafe">
						<table cellspacing="0" cellpadding="1" rules="all"
							bordercolor="gray" border="1" id="DataGrid1"
							style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
							<tr
								style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

								<td align="center" width="5%">序号</td>
								<td align="center" width="17%">标题</td>
								<td align="center" width="17%">日期</td>
								<td align="center" width="13%">分类</td>
								<td width="7%" align="center">编辑</td>
								<td width="7%" align="center">删除</td>
							</tr>


							<c:forEach items="${newsList}" var="news"  varStatus="var" >
								<tr onmouseover="this.style.backgroundColor = 'white'"
									onmouseout="this.style.backgroundColor = '#F5FAFE';">
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="5%">${var.count }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="25%">${news.title }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="20%">${news.date }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="13%">
											<c:forEach items="${categoryList }" var="category">
												<c:if test="${news.category_id==category.cid  }">
													${news.category_id} ${category.cname }
												</c:if> 
											</c:forEach>
										</td>
									<td align="center" style="HEIGHT: 22px"><a
										href="${pageContext.request.contextPath}/selectNewsById.action?id=${news.id}&url=admin/product/edit.jsp">
											<img
											src="${pageContext.request.contextPath}/images/i_edit.gif"
											border="0" style="CURSOR: hand">
									</a></td>

									<td align="center" style="HEIGHT: 22px"><a href="#" onclick="del(${news.id})"> <img
											src="${pageContext.request.contextPath}/images/i_del.gif"
											width="16" height="16" border="0" style="CURSOR: hand">
									</a></td>
								</tr>
							</c:forEach>


						</table>
					</td>
				</tr>

			</TBODY>
		</table>
	</form>
</body>
</HTML>

