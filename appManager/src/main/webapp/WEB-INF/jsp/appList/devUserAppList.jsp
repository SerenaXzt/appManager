<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href=" <%=basePath%>">
<script type="text/javascript" src="statics/jquery/jquery-1.12.4.js"></script>

<%@include file="/statics/common/head.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
			<div class="container">
					<div class="row">
						<div class="col-md-12">
							<p>APP信息管理维护</p>
						</div>
					</div>
					<hr/>
					<form action="" class="form-horizontal">
						<div class="row">
							<div class="col-md-4">
								  <div class="form-group">
								    <label for="inputPassword3" class="col-sm-4 control-label text-right">软件名称</label>
								    <div class="col-sm-6">
								      <input type="password" class="form-control" id="inputPassword3" placeholder="Password">
								    </div>
								  </div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
								    <label for="inputPassword3" class="col-sm-4 control-label text-right">app状态</label>
								    <div class="col-sm-6">
								      <select class="form-control input-sm">
								      	<option>===请选择===</option>
								      	<option value="1">待审核</option>
								      	<option value="2">审核通过</option>
								      	<option value="3">审核未通过</option>
								      	<option value="4">已上架</option>
								      	<option value="5">已下架</option>
								      </select>
								    </div>
								 </div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
								    <label for="inputPassword3" class="col-sm-4 control-label text-right">所属平台</label>
								    <div class="col-sm-6">
								      <select class="form-control input-sm">
								      	<option>===请选择===</option>
								      	<option value="1">手机</option>
								      	<option value="2">平板</option>
								      	<option value="3">通用</option>
								      </select>
								    </div>
								 </div>
							</div>
						</div>
						
						<div class="row">
							<div class="col-md-4">
								  <div class="form-group">
								    <label for="inputPassword3" class="col-sm-4 control-label text-right">一级分类</label>
								    <div class="col-sm-6">
								      <select id="level1" class="form-control input-sm" >
								      	<option>===请选择===</option>
								      	<option value="1">全部应用</option>
								      	<option value="2">全部游戏</option>
								      </select>
								    </div>
								 </div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
								    <label for="inputPassword3" class="col-sm-4 control-label text-right">二级分类</label>
								    <div class="col-sm-6">
								      <select id="level2" class="form-control input-sm" >
								      	<option>===请选择===</option>
								      </select>
								    </div>
								 </div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
								    <label for="inputPassword3" class="col-sm-4 control-label text-right">三级分类</label>
								    <div class="col-sm-6">
								      <select id="level3"  class="form-control input-sm">
								      	<option>===请选择===</option>
								      </select>
								    </div>
								 </div>
							</div>
						</div>
						<div class="row">
							<button class="btn btn-primary">查询</button>
						</div>
					</form>
				</div>
				
				<br/><br/>
				<div class="container">
					<div class="row">
						<div class="col-md-12">
							<a id="add_new_app" href="appAdd" class="btn btn-success">点击新增APP基础信息</a>
						</div>
					</div>
					<br/>
					<div class="row">
						<div class="col-md-12">
							<table class="table table-bordered table-hover text-center">
								<tr class="text-center">
									<th>软件名称</th>
									<th>APK名称</th>
									<th>软件大小（单位：M）</th>
									<th>所属平台</th>
									<th>所属分类（一级、二级、三级）</th>
									<th>状态</th>
									<th>下载次数</th>
									<th>最新版本号</th>
									<th>操作</th>
								</tr>
								<c:forEach items="${requestScope.appInfoVoList }" var="appInfo">
									<tr>
										<td><small>${appInfo.softwarename }</small></td>
										<td><small>${appInfo.apkname }</small></td>
										<td><small>${appInfo.softwaresize }</small></td>
										<td>
											<small>${appInfo.flatformid }</small>
										</td>
										<td>
											<small>${appInfo.categorylevel1 }-->
											${appInfo.categorylevel2}-->
											${appInfo.categorylevel3}
											</small>
										</td>
										<td><small>${appInfo.status }</small></td>
										<td><small>${appInfo.downloads }</small></td>
										<td><small>${appInfo.versionNo }</small></td>
										<td>
											<div class="dropdown">
											  <button class="btn btn-success" id="dLabel" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
											  	  操作
											    <span class="caret"></span>
											  </button>
											  <ul class="dropdown-menu" aria-labelledby="dLabel">
											    <li >
											    	<a data-toggle="tooltip" href="#">下架</a>
											    	<div class="tooltip top" role="tooltip">
													  <div class="tooltip-arrow"></div>
													  <div class="tooltip-inner">
													    Some tooltip text!
													  </div>
													</div>
											    </li>
											    <li role="separator" class="divider"></li>
											    <li><a href="#">新增版本</a></li>
											    <li><a href="#">修改</a></li>
											    <li><a href="#">查看</a></li>
											    <li><a class="delete" delete_app="${appInfo.id }" href="#">删除</a></li>
											  </ul>
											</div>
										</td>
									</tr>
								</c:forEach>
							</table>
						</div>
					</div>
				</div>

<script>
	$(".delete").click(function(){
		var delId = $(this).attr("delete_app");
		$.ajax({
			url:"${pageContext.request.contextPath }/deleteApp/"+delId,
			type : "GET",
			success : function(result){
				if(result.code == 100){
					alert("删除成功！");
					location.reload();
				}
			}
		});
		
		return false;
	});
</script>

<script type="text/javascript" src="statics/jquery/jquery-1.12.4.js"></script>
<script type="text/javascript" src="statics/common/js/ajaxThreeLevel.js"></script>
<%@include file="/statics/common/footer.jsp" %>
