<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>主界面</title>
		<style>
			*{margin: 0; padding: 0;}
			#wrap{
				width: 400px;
				height: 400px;
				background: #00ffee;
			}
		</style>
	</head>
	<body>
		<div id = 'wrap'>
			${sessionScope.studentname}
			${studentname}
			${param.studentname}
		</div>
		<a href="#">Click Me</a>	
		<script>
			//encoedeURIComponent可以将中文嵌入到url中
			let url = "TestServlet?haha=" + encodeURIComponent("王五")
			document.querySelector('a').href = url;
		</script>
	</body>
</html>