<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<base href=" <%=basePath%>">
<script type="text/javascript" src="statics/jquery/jquery-1.12.4.js"></script>

<%@include file="/statics/common/head.jsp" %>
<h2>修改现有的版本</h2>
<c:if test="${requestScope.appversionvo != null }">
	<table class="table table-striped table-hover table-bordered">
  <tr>
    <th>软件名称</th>
    <th>版本号</th>
    <th>版本大小（单位：M）</th>
    <th>发布状态</th>
    <th>APK文件下载</th>
    <th>最近更新时间</th>
  </tr>
	<c:forEach items="${requestScope.appversionvo }" var="appVersion">
  <tr>
    <td>
    	${appVersion.softwareName }
    	<c:set var="appId" value="${appVersion.id}" scope="request"></c:set>
    </td>
    <td>${appVersion.versionNo }</td>
    <td>${appVersion.versionSize }</td>
    <td>${appVersion.publishStatus }</td>
    <td><a href="${pageContext.request.contextPath }/download?fileName=${appVersion.apkFileName }">${appVersion.apkFileName }</a></td>
    <td><fmt:formatDate value="${appVersion.modifyDate }" pattern="yyyy-MM-dd" /></td>
  </tr>
	</c:forEach> 
</table>
</c:if>
<form id="add_version" class="form-horizontal form-label-left" action="${pageContext.request.contextPath }/addVersion" method="post" enctype="multipart/form-data">
					<input type="hidden" name="appid" value="${appversionvo[0].id }"/>
                      <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">版本号*</label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                          <input type="text" id="versionno" class="form-control" value="${appversionvo[0].versionNo}" name="versionno">
                        	<span></span>
                        </div>
                      </div>
                      <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">版本大小*</label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                          <input type="text" class="form-control" id="versionsize" value="${appversionvo[0].versionSize }" name="versionsize">
                        	<span></span>
                        </div>
                      </div>
                        <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">发布状态*</label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                          <select name="publishstatus" class="form-control"> 
                          	<option value="1">不发布</option>
                          	<option value="2">以发布</option>
                          	<option value="3">预发布</option>
                          </select>
                      	</div>
                      </div>
                      <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">版本简介*<span class="required"></span>
                        </label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                          <textarea class="form-control" rows="3"  name="versioninfo">
                          	${appversionvo[0].versionInfo}
                          </textarea>
                        </div>
                      </div>
                      <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">apk文件*</label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                          <input type="file" class="form-control" name="apkfilename" id="apkfilename">
                        </div>
                      </div>
                      

                      
                      
                      <div class="ln_solid"></div>
                      <div class="form-group">
                        <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
                          <button class="btn btn-success" id="update_btn">更新</button>
                          <a href="appsInfo" class="btn btn-primary">取消</a>
                        </div>
                      </div>
                    </form>

<script type="text/javascript" src="statics/common/js/validate_version.js"></script>
<script type="text/javascript" src="statics/common/js/ajaxThreeLevel.js"></script>
<%@include file="/statics/common/footer.jsp" %>