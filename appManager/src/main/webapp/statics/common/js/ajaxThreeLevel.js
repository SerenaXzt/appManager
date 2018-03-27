$("#level1").change(function(){
		change2();
	});
	
	$("#level2").change(function(){
		change3();
	});
	//上架操作
	$(".putAway").click(function(){
		var $span = $(this).parents("td").parent("tr").children("td:eq(5)").children("span");
		var appId = $(this).parents("ul").prev("input").val();
		$.ajax({
			url:"appsPutOrDwon?opt=1&appId="+appId,
			type:"GET",
			cache:false,
			success : function(result){
				if(result.code == 100){//表示成功修改
					//改变样式
					$span.css({
						"border":"1px solid",
						"border-radius":"5px",
						"background-color":"yellow",
						"font-size":"smaller",
						"padding":"5px"
					}).html("上架");
				}
			}
		});
		putOrDown(this , "putAway", "soldOut","下架");
		location.reload();
		return false;
	});
	
	$(".soldOut").click(function(){
		var $span = $(this).parents("td").parent("tr").children("td:eq(5)").children("span");
		var appId = $(this).parents("ul").prev("input").val();
		$.ajax({
			url:"appsPutOrDwon?opt=0&appId="+appId,
			type:"GET",
			cache:false,
			success : function(result){
				if(result.code == 100){//表示成功修改
					//改变样式
					$span.css({
						"border":"1px solid",
						"border-radius":"5px",
						"background-color":"yellow",
						"font-size":"smaller",
						"padding":"5px"
					}).html("下架");
				}
			}
		});
		putOrDown(this , "soldOut", "putAway","上架");
		location.reload();
		return false;
	});

function putOrDown(obj , oldValue, newValue,content){
	$(obj).removeClass(oldValue)
		  .addClass(newValue)
		  .html(content);
}
	
function change2(){
	var parentId = $("#level1").val();
	if(parentId != "" && parentId >= 0){
		$.ajax({
			url : "showCategory/"+parentId,
			type : "GET",
			success : function(result){
				$("#level2").html("<option value='10000'>===请选择===</option>");
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
		$("#level2").html("<option value='10000'>===请选择===</option>");
		change3();
	}
}

function change3(){
	var parentId = $("#level2").val();
	if(parentId != "" && parentId >= 0){
		$.ajax({
			url : "showCategory/"+parentId,
			type : "GET",
			success : function(result){
				$("#level3").html("<option value='10000'>===请选择===</option>");
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
		$("#level3").html("<option value='10000'>===请选择===</option>");
	}
}

