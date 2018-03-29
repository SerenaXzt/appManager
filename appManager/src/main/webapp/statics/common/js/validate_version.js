var flag = false;
$("#versionno").blur(function(){
	$(this).next("span").html("");
	var selfVal = $(this).val();
	var regVersionNo = /^[V]\d+(\.d+)*/;
	if(!regVersionNo.test(selfVal)){
		$(this).next("span").html("请按照正确的格式填写（例如V1.1.1）")
							.css("color","red");
	}else {
		flag = true;
	}
})

$("#versionsize").blur(function(){
	$(this).next("span").html("");
	var selfVal = $(this).val();
	var regVersionNo = /^[0-9]+$/;
	if(!regVersionNo.test(selfVal)){
		$(this).next("span").html("请输入整数")
							.css("color","red");
	}else if(selfVal > 20){
		$(this).next("span").html("大小超过20Mb")
							.css("color","red");
	}else{
		flag = true;
	}
})

$("#add_save").click(function(){
	if(flag){
		$("#add_version").submit();
	}
	return false;
})

$("#update_btn").click(function(){
	if(flag){
		$("#add_version").submit();
	}
	return false;
})
$("#apkfilename").change(function(){
	$(this).next("span").html("");
	var file = this.files[0]; 
	var fileSize = file.size / 1024 / 1024;
	var fileName = file.name;
	 var point = fileName.lastIndexOf("."); 
     var type = fileName.substr(point);
	if(fileSize > 20){
		$(this).next("span").html("文件大小超出20Mb")
							.css("color","red");
		flag = false ;
	}else if(type != ".apk"){
		$(this).next("span").html("文件格式不正确,必须是apk文件")
							.css("color","red");
		flag = false ;
	}else{
		flag = true;
	}
})
