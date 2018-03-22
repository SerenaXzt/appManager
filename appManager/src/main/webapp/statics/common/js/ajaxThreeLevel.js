$("#level1").change(function(){
		change2();
	});
	
	$("#level2").change(function(){
		change3();
	});
	
function change2(){
	var parentId = $("#level1").val();
	if(parentId != null && parentId >= 0){
		$.ajax({
			url : "showCategory/"+parentId,
			type : "GET",
			success : function(result){
				$("#level2").html("<option>===请选择===</option>");
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
		$("#level2").html("<option>===请选择===</option>");
	}
}

function change3(){
	var parentId = $("#level2").val();
	if(parentId != null && parentId >= 0){
		$.ajax({
			url : "showCategory/"+parentId,
			type : "GET",
			success : function(result){
				$("#level3").html("<option>===请选择===</option>");
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
		$("#level3").html("<option>===请选择===</option>");
	}
}