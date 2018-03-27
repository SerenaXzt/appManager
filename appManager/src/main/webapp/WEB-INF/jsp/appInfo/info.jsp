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
  	<form class="form-horizontal form-label-left">
         <div class="form-group">
           <label class="control-label col-md-3 col-sm-3 col-xs-12">软件名称*</label>
           <div class="col-md-9 col-sm-9 col-xs-12">
             <input type="text" id="softwareName" class="form-control" value="${requestScope.appInfoVo.softwarename }" >
           	<span></span>
           </div>
         </div>
         <div class="form-group">
           <label class="control-label col-md-3 col-sm-3 col-xs-12">APK名称*</label>
           <div class="col-md-9 col-sm-9 col-xs-12">
             <input type="text" class="form-control" value="${requestScope.appInfoVo.apkname }">
           </div>
         </div>
         <div class="form-group">
           <label class="control-label col-md-3 col-sm-3 col-xs-12">支持ROM*</label>
           <div class="col-md-9 col-sm-9 col-xs-12">
             <input type="text" class="form-control" value="${requestScope.appInfoVo.supportrom}">
           </div>
         </div>
         <div class="form-group">
           <label class="control-label col-md-3 col-sm-3 col-xs-12">界面语言*</label>
           <div class="col-md-9 col-sm-9 col-xs-12">
             <input type="text" class="form-control" value="${requestScope.appInfoVo.interfacelanguage}">
           </div>
         </div>
         <div class="form-group">
           <label class="control-label col-md-3 col-sm-3 col-xs-12">软件大小*</label>
           <div class="col-md-9 col-sm-9 col-xs-12">
             <input type="text" class="form-control" value="${requestScope.appInfoVo.softwaresize}">
           </div>
         </div>
         <div class="form-group">
           <label class="control-label col-md-3 col-sm-3 col-xs-12">下载次数*</label>
           <div class="col-md-9 col-sm-9 col-xs-12">
             <input type="text" class="form-control" value="${requestScope.appInfoVo.downloads}">
           </div>
         </div>
         <div class="form-group">
           <label class="control-label col-md-3 col-sm-3 col-xs-12">所属平台*</label>
           <div class="col-md-9 col-sm-9 col-xs-12">
             <select class="form-control" name="flatformid">
               <option>${requestScope.appInfoVo.flatformid}</option>
              
             </select>
           </div>
         </div>
         <div class="form-group">
           <label class="control-label col-md-3 col-sm-3 col-xs-12">一级分类*</label>
           <div class="col-md-9 col-sm-9 col-xs-12">
             <select id="level1" class="select2_single form-control" name="categorylevel1">
               <option value="">${requestScope.appInfoVo.categorylevel1}</option>
             </select>
           </div>
         </div>
         <div class="form-group">
           <label class="control-label col-md-3 col-sm-3 col-xs-12">二级分类*</label>
           <div class="col-md-9 col-sm-9 col-xs-12">
             <select id="level2" class="select2_single form-control" name="categorylevel2">
               <option value="">${requestScope.appInfoVo.categorylevel2}</option>
             </select>
           </div>
         </div>
         <div class="form-group">
           <label class="control-label col-md-3 col-sm-3 col-xs-12">三级分类*</label>
           <div class="col-md-9 col-sm-9 col-xs-12">
             <select id="level3" class="select2_single form-control" name="categorylevel3">
              <option >${requestScope.appInfoVo.categorylevel3}</option>
             </select>
           </div>
         </div>

         <div class="form-group">
           <label class="control-label col-md-3 col-sm-3 col-xs-12">APP状态*</label>
           <div class="col-md-9 col-sm-9 col-xs-12">
             <input type="text" class="form-control" value="${requestScope.appInfoVo.status}" >
           </div>
         </div>
         <div class="form-group">
           <label class="control-label col-md-3 col-sm-3 col-xs-12">应用简介*<span class="required"></span>
           </label>
           <div class="col-md-9 col-sm-9 col-xs-12">
             <textarea style="resize: none" class="form-control" rows="3" readonly="readonly">
             	${requestScope.appInfoVo.appinfo}
             </textarea>
           </div>
         </div>
         <div class="form-group">
           <label class="control-label col-md-3 col-sm-3 col-xs-12">图片*</label>
           <div class="col-md-9 col-sm-9 col-xs-12">
             <img style="width: 100px" src="${requestScope.appInfoVo.logopicpath}">
           </div>
         </div>
         <div class="ln_solid"></div>
          <div class="form-group">
            <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
              <a href="${pageContext.request.contextPath }/appsInfo" class="btn btn-primary" >返回</a>
            </div>
          </div>
       </form>
<script type="text/javascript" src="statics/common/js/ajaxThreeLevel.js"></script>
<%@include file="/statics/common/footer.jsp" %>