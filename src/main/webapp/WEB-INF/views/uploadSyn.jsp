<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<div>
			<h1>Spring MVC 文件上传练习</h1>
			<h3>请选择上传文件（文件大小在 30M 以内</h3>

			<form action="uploadSyn" method="post" enctype="multipart/form-data">
				<input type="file" id="myFile" name="file" /> <input id="myBtn"
					type="submit" value="提交"> <input id="myBtn" type="reset"
					value="重置">
			</form>
		</div>
	</center>
</body>
</html>