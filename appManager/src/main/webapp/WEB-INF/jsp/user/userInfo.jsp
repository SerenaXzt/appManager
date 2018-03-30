<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href=" <%=basePath%>">
<script type="text/javascript" src="statics/jquery/jquery-1.12.4.js"></script>

<%@include file="/statics/common/back_head.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<form class="form-horizontal form-label-left">
         <div class="form-group">
           <label class="control-label col-md-3 col-sm-3 col-xs-12">用户id*</label>
           <div class="col-md-9 col-sm-9 col-xs-12">
             <input type="text" id="softwareName" class="form-control" value="${requestScope.userInfo.id }" readonly="readonly">
           	<span></span>
           </div>
         </div>
         <div class="form-group">
           <label class="control-label col-md-3 col-sm-3 col-xs-12">登录名*</label>
           <div class="col-md-9 col-sm-9 col-xs-12">
             <input type="text" class="form-control" value="${requestScope.userInfo.usercode }" readonly="readonly">
           </div>
         </div>
         <div class="form-group">
           <label class="control-label col-md-3 col-sm-3 col-xs-12">用户名*</label>
           <div class="col-md-9 col-sm-9 col-xs-12">
             <input type="text" class="form-control" value="${requestScope.userInfo.username}" readonly="readonly">
           </div>
         </div>
         <div class="form-group">
           <label class="control-label col-md-3 col-sm-3 col-xs-12">用户类型*</label>
           <div class="col-md-9 col-sm-9 col-xs-12">
             <input type="text" class="form-control" value="${requestScope.userInfo.usertype}" readonly="readonly">
           </div>
         </div>
         <div class="form-group">
           <label class="control-label col-md-3 col-sm-3 col-xs-12">创建者*</label>
           <div class="col-md-9 col-sm-9 col-xs-12">
             <input type="text" class="form-control" value="${requestScope.userInfo.createdby}" readonly="readonly">
           </div>
         </div>
         <div class="form-group">
           <label class="control-label col-md-3 col-sm-3 col-xs-12">创建时间*</label>
           <div class="col-md-9 col-sm-9 col-xs-12">
             <input type="text" class="form-control" value='<fmt:formatDate value="${requestScope.userInfo.creationdate }" pattern="yyyy-MM-dd" />' readonly="readonly">
           </div>
         </div>
         <div class="form-group">
           <label class="control-label col-md-3 col-sm-3 col-xs-12">修改时间*</label>
           <div class="col-md-9 col-sm-9 col-xs-12">
             <input type="text" class="form-control" value="${requestScope.userInfo.modifydate}" readonly="readonly">
           </div>
         </div>
         <div class="form-group">
           <label class="control-label col-md-3 col-sm-3 col-xs-12">用户密码*</label>
           <div class="col-md-9 col-sm-9 col-xs-12">
             <input type="text" class="form-control" value="${requestScope.userInfo.userpassword}" readonly="readonly">
           </div>
         </div>
         <div class="ln_solid"></div>
          <div class="form-group">
            <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
              <a href="${pageContext.request.contextPath }/userManager" class="btn btn-primary" >返回</a>
            </div>
          </div>
       </form>



<script type="text/javascript" src="statics/jquery/jquery-1.12.4.js"></script>
<script type="text/javascript" src="statics/common/js/ajaxThreeLevel.js"></script>
<%@include file="/statics/common/footer.jsp"%>