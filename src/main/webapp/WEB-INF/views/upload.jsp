<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/plugins/jquery-3.2.1.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<center>
		<input type="file" id="myFile" name="file" /> <br> 
		测试:<input type="text" /> 
		<br> 
		<input id="myBtn" type="button" value="提交">
	<div id="img_div" style="width:100px;height:100px;">
	</div>
</center>
	<script type="text/javascript">
		$(function() {
			$('#myBtn').click(function() {
				var formData = new FormData();
				formData.append("myFile", $("#myFile")[0].files[0]);
				$.ajax({
					url : "doUpload",
					type : "post",
					data : formData,
					dataType : "json",
					processData : false,
					contentType:false,
					success : function(json) {
						var img="<img src='http://localhost:8080/SpringMVCFileUpload"+json.url+"' width='100' height='100'/>";
						$('#img_div').html(img);
					}
				})
			})
		})
	</script>
</body>
</html>