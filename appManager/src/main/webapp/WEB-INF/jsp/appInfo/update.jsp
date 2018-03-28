<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href=" <%=basePath%>">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript" src="statics/jquery/jquery-1.12.4.js"></script>

<%@include file="/statics/common/head.jsp" %>
  	<form action="appsUpdate" class="form-horizontal form-label-left" method="POST">
  		<input type="hidden" name="_method" value="PUT" />
  		<input type="hidden" name="id" value="${requestScope.appInfoVo.id}" />
         <div class="form-group">
           <label class="control-label col-md-3 col-sm-3 col-xs-12">软件名称*</label>
           <div class="col-md-9 col-sm-9 col-xs-12">
             <input type="text" id="softwareName" name="softwarename" class="form-control" value="${requestScope.appInfoVo.softwarename }" >
           	<span></span>
           </div>
         </div>
         <div class="form-group">
           <label class="control-label col-md-3 col-sm-3 col-xs-12">APK名称*</label>
           <div class="col-md-9 col-sm-9 col-xs-12">
             <input type="text" id="apkName" name="apkname" class="form-control" readonly="readonly" value="${requestScope.appInfoVo.apkname }">
           		<span></span>
           </div>
         </div>
         <div class="form-group">
           <label class="control-label col-md-3 col-sm-3 col-xs-12">支持ROM*</label>
           <div class="col-md-9 col-sm-9 col-xs-12">
             <input type="text" id="supportRom" name="supportrom" class="form-control" value="${requestScope.appInfoVo.supportrom}">
           		<span></span>
           </div>
         </div>
         <div class="form-group">
           <label class="control-label col-md-3 col-sm-3 col-xs-12">界面语言*</label>
           <div class="col-md-9 col-sm-9 col-xs-12">
             <input type="text" id="interfaceLanguage" name="interfacelanguage" class="form-control" value="${requestScope.appInfoVo.interfacelanguage}">
           		<span></span>
           </div>
         </div>
         <div class="form-group">
           <label class="control-label col-md-3 col-sm-3 col-xs-12">软件大小*</label>
           <div class="col-md-9 col-sm-9 col-xs-12">
             <input type="text" id="softwareSize" name="softwaresize" class="form-control" value="${requestScope.appInfoVo.softwaresize}">
           		<span></span>
           </div>
         </div>
         <div class="form-group">
           <label class="control-label col-md-3 col-sm-3 col-xs-12">下载次数*</label>
           <div class="col-md-9 col-sm-9 col-xs-12">
             <input type="text" id="downloads" name="downloads" class="form-control" value="${requestScope.appInfoVo.downloads}">
           		<span></span>
           </div>
         </div>
         <div class="form-group">
           <label class="control-label col-md-3 col-sm-3 col-xs-12">所属平台*</label>
           <div class="col-md-9 col-sm-9 col-xs-12">
             <select class="form-control" name="flatformid">
              <option value="">===请选择===</option>
		      	<c:forEach items="${requestScope.dataDictionaryVo['APP_FLATFORM'] }" var="flatform">
		      		<option value="${flatform.valueid }" <c:if test="${flatform.valueid == requestScope.appInfoVo.flatformidVo }"> selected='selected' </c:if>>${flatform.valuename }</option>
		      	</c:forEach>
             </select>
           </div>
         </div>
         <div class="form-group">
           <label class="control-label col-md-3 col-sm-3 col-xs-12">一级分类*</label>
           <div class="col-md-9 col-sm-9 col-xs-12">
             <select id="level1" class="select2_single form-control" name="categorylevel1">
               <option value="10000">===请选择===</option>
		      	<option value="1" <c:if test="${1 == requestScope.appInfoVo.categorylevel1Vo }"> selected='selected' </c:if>>全部应用</option>
		      	<option value="2" <c:if test="${2 == requestScope.appInfoVo.categorylevel1Vo }"> selected='selected' </c:if>>全部游戏</option>
             </select>
           </div>
         </div>
         <div class="form-group">
           <label class="control-label col-md-3 col-sm-3 col-xs-12">二级分类*</label>
           <div class="col-md-9 col-sm-9 col-xs-12">
             <select id="level2" class="select2_single form-control" name="categorylevel2">
               <option value="${requestScope.appInfoVo.categorylevel2Vo}">
               		${requestScope.appInfoVo.categorylevel2}
              </option>
             </select>
           </div>
         </div>
         <div class="form-group">
           <label class="control-label col-md-3 col-sm-3 col-xs-12">三级分类*</label>
           <div class="col-md-9 col-sm-9 col-xs-12">
             <select id="level3" class="select2_single form-control" name="categorylevel3">
              <option value="${requestScope.appInfoVo.categorylevel3Vo}">
              	${requestScope.appInfoVo.categorylevel3}
              </option>
             </select>
           </div>
         </div>

         <div class="form-group">
           <label class="control-label col-md-3 col-sm-3 col-xs-12">APP状态*</label>
           <div class="col-md-9 col-sm-9 col-xs-12">
           <select name="status" class="form-control input-sm">
		      	<c:forEach items="${requestScope.dataDictionaryVo['APP_STATUS'] }" var="stat">
		      		<c:if test="${stat.valueid == requestScope.appInfoVo.statusVo }">
		      			<option selected="selected" value="${stat.valueid }">${stat.valuename }</option>
		      		</c:if>
		      	</c:forEach>
	      </select>
           </div>
         </div>
         <div class="form-group">
           <label class="control-label col-md-3 col-sm-3 col-xs-12">版本号*</label>
           <div class="col-md-9 col-sm-9 col-xs-12">
           		<input type="text" readonly="readonly"  value="${requestScope.appInfoVo.versionNo}" />
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
            	<c:if test="${requestScope.appInfoVo.statusVo == 3 }">
            		<input type=hidden name="_status" value="1" />
            		<input type="submit" class="btn btn-success" value="保存并在此提交审核"/>
            	</c:if>
              <input class="btn btn-primary" type="submit" value="保存" />
              <a class="btn btn-primary" href="appsInfo" >返回</a>
            </div>
          </div>
       </form>
<script type="text/javascript">
	$("#level2").click(function(){
		var parentId = $("#level1").val();
		var selfVal = $(this).val();
		$.ajax({
			url:"${pageContext.request.contextPath}/showCategory/"+parentId,
			type:"GET",
			success : function(result){
				$("#level2").html("<option value='10000'>===请选择===</option>");
				for(var i = 0; i<result.extend.categoryList.length; i++){
					var $opt = $("<option></option>").html(result.extend.categoryList[i].categoryName)
													 .attr("value",result.extend.categoryList[i].id)
					if(selfVal == $opt.attr("value")){
						$opt.attr("selected",true);
					}
					$("#level2").append($opt);
				}
			}
		})
	});
	
	$("#level3").click(function(){
		var parentId = $("#level2").val();
		var selfVal = $(this).val();
		$.ajax({
			url:"${pageContext.request.contextPath}/showCategory/"+parentId,
			type:"GET",
			success : function(result){
				$("#level3").html("<option value='10000'>===请选择===</option>");
				for(var i = 0; i<result.extend.categoryList.length; i++){
					var $opt = $("<option></option>").html(result.extend.categoryList[i].categoryName)
													 .attr("value",result.extend.categoryList[i].id)
					if(selfVal == $opt.attr("value")){
						$opt.attr("selected",true);
					}
					$("#level3").append($opt);
				}
			}
		})
	});
</script>
<script type="text/javascript" src="statics/common/js/ajaxThreeLevel.js"></script>
<script type="text/javascript" src="statics/common/js/validate.js"></script>
<%@include file="/statics/common/footer.jsp" %>