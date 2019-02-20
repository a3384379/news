<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath}/css/Style1.css"
	type="text/css" rel="stylesheet">
</HEAD>

<body>
	<!--  -->
	<form id="userAction_save_do" name="Form1"
		action="${pageContext.request.contextPath}/updateNewsById.action"
		method="post">
		<input type="hidden" name="id" value="${news.id }"> &nbsp;
		<table cellSpacing="1" cellPadding="5" width="100%" align="center"
			bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
					height="26"><strong><STRONG>修改新闻</STRONG> </strong></td>
			</tr>

			<tr>
				<td width="8%" align="center" bgColor="#f5fafe" class="ta_01">
					新闻标题：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text"
					style="width: 100%" name="title" value="${news.title }"
					id="userAction_save_do_logonName" class="bg" /></td>
			</tr>

			<tr>
				<td width="8%" align="center" bgColor="#f5fafe" class="ta_01">
					所属分类：</td>
				<td class="ta_01" bgColor="#ffffff" colspan="3"><select
					name="category_id">

						<c:forEach items="${categoryList }" var="categ">
							<c:if test="${news.category_id==categ.cid }">
								<option value="${categ.cid }" selected="selected">${categ.cname }</option>
							</c:if>
							<c:if test="${news.category_id!=categ.cid }">
								<option value="${categ.cid }">${categ.cname }</option>
							</c:if>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td width="8%" align="center" bgColor="#f5fafe" class="ta_01">
					新闻内容：</td>
				<td class="ta_01" bgColor="#ffffff" colspan="3">
					<div id="div1">
						${news.test }
						<textarea id="text1"
							style="width: 100%; height: 200px; display: none;" name="test"></textarea>
					</div>
				</td>
			</tr>
			<tr>
				<td class="ta_01" style="WIDTH: 100%" align="center"
					bgColor="#f5fafe" colSpan="4">
					<button type="submit" id="userAction_save_do_submit" value="确定"
						class="button_ok">&#30830;&#23450;</button> <FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
					<INPUT class="button_ok" type="button" onclick="history.go(-1)"
					value="返回" /> <span id="Label1"></span>
				</td>
			</tr>
		</table>
	</form>

	<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/wangEditor.js"></script>
	<script type="text/javascript">
		var E = window.wangEditor
		var editor = new E('#div1')
		var $text1 = $('#text1')
		editor.customConfig.onchange = function(html) {
			// 监控变化，同步更新到 textarea
			$text1.val(html)
		}
		editor.create()
		// 初始化 textarea 的值
		$text1.val(editor.txt.html())
	</script>

</body>
</HTML>