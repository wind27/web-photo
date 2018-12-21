<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>图片上传</title>

	<script type="text/javascript" src="../../../resources/js/lib/jquery.js"></script>
	<script src="https://cdn.bootcss.com/jsencrypt/3.0.0-rc.1/jsencrypt.js"></script>


	<script type="text/javascript">
		$(document).ready(function () {
			$("#upload").click(function () {
				encrypt();
			});

		});
		var encrypt = function() {
			$.ajax({
				url: "/pubsign",
				type:'get',
				dataType : 'json',
				success: function(result){
					var data = result["data"];
					console.log(data);
					var publickey = data["publickey"];
					console.log(publickey);

					var username = $("#username").val();
					var pwd = $("#pwd").val();

					//使用公钥加密
					var encrypt = new JSEncrypt();
					encrypt.setPublicKey(publickey);

					// 将data数组赋给ajax对象
					var encrypted = encrypt.encrypt(pwd);
//					encrypted= encodeURI(encrypted).replace(/\+/g, '%2B');
					console.log('加密后数据:%o', encrypted);
					$.ajax({
						url: "/login",
						type:'post',
						data:{
							'username':username,
							'pwd':encrypted
						},
						success: function(data){
							console.info(data);
						}});
				}});
		};
	</script>

</head>
<body>

<form id="uploadForm" enctype="multipart/form-data">
	用户名:<input id="username" type="text" name="username"/><br/>
	密&nbsp;&nbsp;&nbsp;&nbsp;码:<input id="pwd" type="password" name="pwd"/><br/>
	<button id="upload" type="button">upload</button>
</form>
</body>
</html>