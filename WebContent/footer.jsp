<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div style="width: 100%; height: 10px; background-color: #0B1746;float: left;"></div>
<div class="container-fluid" >
	<div style="text-align: center; margin-top: 5px;">
		<ul class="list-inline">
			<li><a href="info.jsp" style="color: black;">关于我们</a></li>
			<li data-toggle="modal" data-target="#myModal" >
			<a style="color: black;" href="javascript:void(0);">联系我们</a></li>
			<li><a style="color: black;">招贤纳士</a></li>
			<li><a style="color: black;">法律声明</a></li>
			<li><a style="color: black;">友情链接</a></li>
			<li><a style="color: black;">服务声明</a></li>
			<li><a style="color: black;">广告声明</a></li>
		</ul>
	</div>

	<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel"
						style="text-align: center;">请用QQ扫码添加</h4>
				</div>
				<div class="modal-body">
					<img style="width: 300px; height: 400px; margin-left: 130px"
						src="${pageContext.request.contextPath }/img/qq.jpg">
				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭
					</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->


	<div style="text-align: center; margin-top: 5px; margin-bottom: 20px;">
		Copyright &copy; 2018-2019 版权所有</div>
</div>