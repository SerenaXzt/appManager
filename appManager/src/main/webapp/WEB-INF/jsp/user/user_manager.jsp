<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href=" <%=basePath%>">
<script type="text/javascript" src="statics/jquery/jquery-1.12.4.js"></script>

<%@include file="/statics/common/back_head.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<div class="col-md-12">
		<table class="table table-bordered table-hover text-center">
			<tr class="text-center">
				<th>用户id</th>
				<th>登录名</th>
				<th>用户名</th>
				<th>登陆密码</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${requestScope.allUser }" var="allUser">
				<tr>
					<td><small>${allUser.id }</small></td>
					<td><small>${allUser.usercode }</small></td>
					<td><small>${allUser.username }</small></td>
					<td><small>${allUser.userpassword }</small></td>
					<td>
						<div class="dropdown">
							<button class="btn btn-success" id="dLabel" type="button" data-toggle="dropdown"
								aria-haspopup="true" aria-expanded="false">
								操作 <span class="caret"></span>
							</button>
							<input type="hidden" name="userId" value="${allUser.id }" />
							<ul class="dropdown-menu" aria-labelledby="dLabel">
								<li><a href="userInfo/${allUser.id }">查看</a></li>
								<li><a href="userModify/${allUser.id }">修改</a></li>
								<li><a class="delete" delete_user="${allUser.id }" href="#">删除</a></li>
							</ul>
						</div>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>

<script>
$(".delete").click(function(){
	var delId = $(this).attr("delete_user");
	if(confirm("确定删除吗？")){
	$.ajax({
		url:"${pageContext.request.contextPath }/deleteUser/"+delId,
		type : "GET",
		success : function(result){
			if(result.code == 100){
				alert("删除成功！");
				location.reload();
			}else{
				alert("删除失败！");
				location.reload();
			}
		}
	});
	}
	return false;
});
</script>

<script type="text/javascript" src="statics/jquery/jquery-1.12.4.js"></script>
<script type="text/javascript" src="statics/common/js/ajaxThreeLevel.js"></script>
<%@include file="/statics/common/footer.jsp"%>