
var flag = "";
$("#softwareName").blur(function(){
	$(this).next("span").html("");
	var name = $(this).val();
	var regSoft = /^[\u4E00-\u9FA5A-Za-z0-9]{3,}$/;
	if(!regSoft.test(name)){
		$(this).next("span").html("请输入至少3个字符")
		  .css("color","red");
		flag = false;
	}else{
		$.ajax({
			url : "validate/"+name,
			type : "GET",
			success : function(result){
				console.log(result);
				if(result.code == 200){
					$("#softwareName").next("span").html("软件名称已经存在").css("color","red");
					flag = false;
				}else{
					$("#softwareName").next("span").html("软件名称可以使用").css("color","green");
					flag = true;
				}
			}
		})
	}
});

$("#apkName").blur(function(){
	$(this).next("span").html("");
	var selfVal = $(this).val();
	var regAPKName = /^[A-Za-z]{5,}$/;
	if(!regAPKName.test(selfVal)){
		$(this).next("span").html("请输入至少5个字符")
						  .css("color","red");
		flag = false;
	}else{
		$(this).next("span").html("apk名称可以使用").css("color","green");
		flag = true;
	}
});
	
$("#softwareSize").blur(validate_num);
$("#downloads").blur(validate_num)
function validate_num(obj){
	if($(this).attr("id") == "softwareSize"){
		$(this).next("span").html("");
		var selfVal = $(this).val();
		var regSize = /^[0-9]+$/;
		if(!regSize.test(selfVal)){
			$(this).next("span").html("请输入数字")
			.css("color","red");
			flag = false;
		}else if(selfVal > 20) {
			$(this).next("span").html("软件大于20Mb")
			.css("color","red");
			flag = false;
		}else{
			flag = true;
		}
	}else if($(this).attr("id") == "downloads"){
		$(this).next("span").html("");
		var selfVal = $(this).val();
		var regSize = /^[0-9]+$/;
		if(!regSize.test(selfVal)){
			$(this).next("span").html("请输入数字")
			.css("color","red");
			flag = false;
		}else{
			flag = true;
		}
	}
}

$("#supportRom").blur(function(){
	$(this).next("span").html("");
	var selfVal = $(this).val();
	var regRom = /^[\u4E00-\u9FA5A-Za-z0-9]{5,}$/;
	if(!regRom.test(selfVal)){
		$(this).next("span").html("请输入至少5个字符")
		.css("color","red");
		flag = false;
	}else{
		$(this).next("span").html("验证通过").css("color","green");
		flag = true;
	}
})

$("#add_save").click(function(){
	if(flag){
		$("#add_APP").submit();
	}
})

