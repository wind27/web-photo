<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>图片上传</title>
	<script type="text/javascript" src="../../../resources/js/lib/jquery.js"></script>
	
	<script type="text/javascript">
	
		$(document).ready(function () {
			$("#upload").click(function () {
				$.ajax({
				    url: '/upload/img',
				    type: 'POST',
				    cache: false,
				    data: new FormData($('#uploadForm')[0]),
				    processData: false,
				    contentType: false
				}).done(function(res) {
				}).fail(function(res) {});
			});
			
		});
	</script>

</head>
<body>
	<form id="uploadForm" enctype="multipart/form-data">
    <input id="file" type="file" name="file"/>
    <button id="upload" type="button">upload</button>
</form>
</body>
</html>