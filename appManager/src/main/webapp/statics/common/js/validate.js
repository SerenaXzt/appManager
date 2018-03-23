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
