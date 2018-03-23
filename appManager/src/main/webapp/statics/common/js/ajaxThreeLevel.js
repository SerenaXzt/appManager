$("#level1").change(function(){
		change2();
	});
	
	$("#level2").change(function(){
		change3();
	});
	
function change2(){
	var parentId = $("#level1").val();
	if(parentId != "" && parentId >= 0){
		alert(parentId);
		$.ajax({
			url : "showCategory/"+parentId,
			type : "GET",
			success : function(result){
				$("#level2").html("<option value='100'>===请选择===</option>");
				for(var i = 0; i<result.extend.categoryList.length; i++){
					var $opt = $("<option></option>").html(result.extend.categoryList[i].categoryName)
													 .attr("value",result.extend.categoryList[i].id)
					if(i == 0){
						$opt.attr("selected",true);
					}
					
					$("#level2").append($opt);
				}
				change3();
			}
		})
	}else{
		$("#level2").html("<option value='100'>===请选择===</option>");
		change3();
	}
}

function change3(){
	var parentId = $("#level2").val();
	if(parentId != "" && parentId >= 0){
		alert(parentId);
		$.ajax({
			url : "showCategory/"+parentId,
			type : "GET",
			success : function(result){
				$("#level3").html("<option value='100'>===请选择===</option>");
				for(var i = 0; i<result.extend.categoryList.length; i++){
					var $opt = $("<option></option>").html(result.extend.categoryList[i].categoryName)
													 .attr("value",result.extend.categoryList[i].id)
					if(i == 0){
						$opt.attr("selected",true);
					}
					
					$("#level3").append($opt);
				}
			}
		})
	}else{
		$("#level3").html("<option value='100'>===请选择===</option>");
	}
}