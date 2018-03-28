$("#logOut").click(function(){
	if(confirm("确定退出吗？")){
		$.ajax({
			url:"devLogin/logOut",
			type:"GET",
			success : function(result){
				if(result.code == 100){
					window.location.href="index.jsp";
				}
			}
		})
	}
	return false;
})