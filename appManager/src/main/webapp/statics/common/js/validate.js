$("#softwareName").blur(function(){
	var name = $(this).val();
	$.ajax({
		url : "validate/"+name,
		type : "GET",
		success : function(result){
			if(result.code == 200){
				alert("app名称已存在！");
				location.reload();
			}
		}
	})
});
/*$("#add_save").click(function(){
	alert($("#level3").val());
	if(isNaN($("#level3").val())){
		$("#level3").val("107");
		alert($("#level3").val());
	}
	$("#add_APP").submit();
});*/