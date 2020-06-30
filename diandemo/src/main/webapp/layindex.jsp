<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>登录-电商平台后台管理系统</title>
<link rel="stylesheet" href="layui/css/layui.css">
<style>
#background {
	width: 100vw;
	height: 100vh;
	background: url('img/bg2.jpg') no-repeat;
	background-size: 100% 100%;
	background-position: 50% 50%;
	display: flex;
	position: absolute;
	left: 0;
	top: 0;
	z-index: -1;
	background-color: inherit;
	-webkit-filter: blur(3px);
	-moz-filter: blur(3px);
	-ms-filter: blur(3px);
	-o-filter: blur(3px);
	filter: blur(3px);
	filter: progid:DXImageTransform.Microsoft.Blur(PixelRadius=3, MakeShadow=false);
}

#center {
	width: 100vw;
	height: 100vh;
	display: flex;
}

form {
	margin: auto;
	margin-top: 7%;
	padding: 20px;
	padding-bottom: 0;
	background: #fff;
	border-radius: 10px;
	box-shadow: 1px 1px 20px #00000080;
}
</style>
</head>
<body>
	<div id='background'></div>
	<!-- 你的HTML代码 -->
	<div id='center'>
		<form class='layui-form layui-bg-gray' method='post'>
			<div class='layui-form-item'>后台管理系统登录</div>
			<div class='layui-form-item'>
				<input type="text" name="username" required lay-verify="required"
					placeholder="账号" autocomplete="off" class="layui-input">
			</div>
			<div class='layui-form-item'>
				<input type="password" name="password" required lay-verify="required"
					placeholder="密码" autocomplete="off" class="layui-input">
			</div>
			<div class="layui-form-item">
				<button type="submit" class="layui-btn layui-btn-fluid" lay-submit
					lay-filter="login">登录</button>
			</div>
		</form>
	</div>
	<script src="js/jquery.js"></script>
	<script src="layui/layui.all.js"></script>
	<script>
		;
		!function() {
			let form = layui.form
			form.on('submit(login)', function(data) {
				let username = data.field.username
				let password = data.field.password
				$.ajax({
					type : 'post',
					url : 'manage/user?type=login',
					data : {
						username : username,
						password : password
					},
					dataType : 'json',
					success : function(data) {
						if (data.status == 0) {
							var url = "acontent/layui-backplane.jsp"
							window.location.href = url
						} else {
							layer.msg(data.msg, {
								icon : 2
							})
						}
					}
				})
				return false
			})
		}()
	</script>
</body>
</html>