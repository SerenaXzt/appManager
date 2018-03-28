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
					<form id="searchApp" action="appsSearch" class="form-horizontal" method="post">
						<input type="hidden" id="pageNum" name="pageNum" value="${requestScope.page.pageNum }"/>
						<div class="row">
							<div class="col-md-4">
								  <div class="form-group">
								    <label for="inputPassword3" class="col-sm-4 control-label text-right">软件名称</label>
								    <div class="col-sm-6">
								      <input type="text" class="form-control" name="softwarename" placeholder="softwarename">
								    </div>
								  </div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
								    <label for="inputPassword3" class="col-sm-4 control-label text-right">app状态</label>
								    <div class="col-sm-6">
								      <select name="appStatus" class="form-control input-sm">
								      	<option value="">===请选择===</option>
								      	<c:forEach items="${requestScope.dataDictionaryVo['APP_STATUS'] }" var="stat">
								      		<option value="${stat.valueid }" <c:if test="${stat.valueid == param.appStatus }"> selected='selected' </c:if> >${stat.valuename }</option>
								      	</c:forEach>
								      </select>
								    </div>
								 </div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
								    <label for="inputPassword3" class="col-sm-4 control-label text-right">所属平台</label>
								    <div class="col-sm-6">
								      <select name="flatFormId" class="form-control input-sm">
								      	<option value="">===请选择===</option>
								      	<c:forEach items="${requestScope.dataDictionaryVo['APP_FLATFORM'] }" var="flatform">
								      		<option value="${flatform.valueid }" <c:if test="${flatform.valueid == param.flatFormId }"> selected='selected' </c:if>>${flatform.valuename }</option>
								      	</c:forEach>
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
								      <select name="categoryLevel1" id="level1" class="form-control input-sm" >
								      	<option value="10000">===请选择===</option>
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
								      <select name="categoryLevel2" id="level2" class="form-control input-sm" >
								      	<option value="10000">===请选择===</option>
								      </select>
								    </div>
								 </div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
								    <label for="inputPassword3" class="col-sm-4 control-label text-right">三级分类</label>
								    <div class="col-sm-6">
								      <select name="categoryLevel3" id="level3"  class="form-control input-sm">
								      	<option value="10000">===请选择===</option>
								      </select>
								    </div>
								 </div>
							</div>
						</div>
						<div class="row">
							<button id="search" class="btn btn-primary">查询</button>
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
								<c:forEach items="${requestScope.page.list }" var="appInfo">
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
										<td><span>${appInfo.status }</span></td>
										<td><small>${appInfo.downloads }</small></td>
										<td><small>${appInfo.versionNo }</small></td>
										<td>
											<div class="dropdown">
											  <button class="btn btn-success" id="dLabel" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
											  	  操作
											    <span class="caret"></span>
											  </button>
											  <input type="hidden" name="appId" value="${appInfo.id }" />
											  <ul class="dropdown-menu" aria-labelledby="dLabel">
											  	<c:choose>
											  		<c:when test="${appInfo.statusVo==1 || appInfo.statusVo==3 }">
											  			<li><a href="#">修改（已有版本）</a></li>
											  		</c:when>
											  		<c:when test="${appInfo.statusVo==2 || appInfo.statusVo==5 }">
											  			<li><a class="putAway" href="#">上架</a></li>
											  		</c:when>
											  		<c:when test="${appInfo.statusVo==2 || appInfo.statusVo==4 }">
											  			 <li><a class="soldOut" href="#">下架</a></li>
											  		</c:when>
											  	</c:choose>
											    <li role="separator" class="divider"></li>
											    <li><a href="appVersion/${appInfo.id }">新增版本</a></li>
											    <li><a href="appsUpdate/${appInfo.id }">修改</a></li>
											    <li><a href="appsInfo/${appInfo.id }">查看</a></li>
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
				<div class="container">
					<div class="row">
						<div class="col-md-4">
						<span>
						共有${requestScope.page.pages==null?0:requestScope.page.pages }页，
						当前第${requestScope.page.pageNum==null?0:requestScope.page.pageNum }页 ，
						总记录数为${requestScope.page.total==null?0:requestScope.page.total }</span>
						</div>
						<div class="col-md-4 col-md-offset-4">
							<nav aria-label="Page navigation">
							  <ul class="pagination">
							   <li <c:if test="${requestScope.page.pageNum == 1}">class="disabled"</c:if> >
							      <a class="showPage" pageNum="1" href="#">
							       	 首页
							      </a>
							    </li>
							  <c:if test="${requestScope.page.hasPreviousPage}">
							  	 <li <c:if test="${!requestScope.page.hasPreviousPage}">class="disabled"</c:if> >
							      <a class="showPage" pageNum="${requestScope.page.pageNum - 1 }" href="#" aria-label="Previous">
							        <span aria-hidden="true">&laquo;</span>
							      </a>
							    </li>
							  </c:if>
							  <c:forEach items="${requestScope.page.navigatepageNums}" var="num">
							  
							    <li <c:if test="${requestScope.page.pageNum == num}">class="active"</c:if>>
							    	<a class="showPage" pageNum="${num }" href="#">${num }</a>
							    </li>
							  </c:forEach>
							    <c:if test="${requestScope.page.hasNextPage}">
								    <li>
								      <a pageNum="${requestScope.page.pageNum }" class="showPage" href="#" aria-label="Next">
								        <span aria-hidden="true">&raquo;</span>
								      </a>
								    </li>
							    </c:if>
							    <li <c:if test="${requestScope.page.pageNum == requestScope.page.pages}">class="disabled"</c:if>>
							      <a class="showPage" pageNum="${requestScope.page.pages}" href="#">
							       	 末页
							      </a>
							    </li>
							  </ul>
							</nav>
						</div>
					</div>
				</div>
<script type="text/javascript">
	$(".delete").click(function(){
		var delId = $(this).attr("delete_app");
		$.ajax({
			url:"${pageContext.request.contextPath }/deleteApp/"+delId,
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
		return false;
	});
	$(".showPage").click(function(){
		var page = $(this).attr("pageNum");
		$("#pageNum").val(page);
		$("#searchApp").submit();
		return false;
	})
	
	
</script>

<script type="text/javascript" src="statics/jquery/jquery-1.12.4.js"></script>
<script type="text/javascript" src="statics/common/js/ajaxThreeLevel.js"></script>
<script type="text/javascript">
	$("#search").click(function(){
		$("#searchApp").submit();
	})
</script>
<%@include file="/statics/common/footer.jsp" %>
