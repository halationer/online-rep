<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">

	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<meta http-equiv="X-UA-Compatible" content="ie=edge" />
		<title>login</title>
		<link rel="shortcut icon" href="favicon.ico" />
		<link rel="stylesheet" type="text/css" href="css/base.css"/>
		
		<script type="text/javascript" src="js/jquery-3.5.1.min.js" ></script>
		<style>
			
			
			/*tou*/
			.shangcheng {
				height: 98px;
			}
			.shangcheng img {
				float: left;
				height: 60px;
				width: 60px;
				margin: 19px 0;
				
			}
			.shangcheng span {
				float: left;
				height: 60px;
				line-height: 98px;
				font-size: 50px;
			}
			
			.container{
				/*background: url(img/p1.jpg) no-repeat;
				background-position: 10px 10px;*/
				background: url(img/dianzi2.jpg);
				width: 100vw;
				height: calc(100vh - 98px);
				/*opacity: 0.3;*/
				
			}
			/*main*/
			.main {
				position: absolute;
				top: 193px;
				right: 130px;
				width: 320px;
				height: 400px;
				background-color: aliceblue;
				
			}
			.login input {
				display: block;
				width: 310px;
				height: 48px;
				margin-left: 5px;
				padding: 13px 14px;
				/*background-color: #cccc;*/
				margin-top: 17px;
				border: 1px solid #CCCCCC;
				
			}
			.denglu {
				height: 32px;
				text-align: center;
				line-height: 32px;
				color: #EE9900;
				font-size: 20px;
				
			}
			.login input[type="button"] {
				font-size: 20px;
				line-height: 20px;
				background-color: #DF5000;
				color: #FFFFFF;
			}
			.login a{
				/*display: inline-block;*/
				float: right;
				margin-right: 20px;
			}
		</style>
		
	</head>

	<body>
		<div class="shangcheng w">
			<a href="index.jsp"><img src="img/m2.jpg"/> </a>
			<span>小米商城</span>
		</div>
		<div class="container">
			
			<div class="main w">
			<div class="denglu">
				账号登录
			</div>
			<form  class="login"  >
				</span><input type="text" class="user" id="user" placeholder="用户名" />
				</span><input type="password" class="password" id="password" placeholder="密码"/>
				<input type="button" name="" id="logins" value="登录" />
				
				<a href="forget.jsp">忘记密码?</a>
				<a href="zhuce.jsp">立即注册|</a>
			</form>

		</div>
			
		</div>
		
		<!--登录的请求和响应-->
		<script>
         
            	$('#logins').click(function(){
            		let username = $('#user').val();
            		let password = $("#password").val();
//          		测试用户名
//          		alert(username)
//          		测试结束
            		$.ajax({
            			type: "post",
            			data: {username:username,password:password}, //对应request
            			url: "user?type=login", //对应url
            			dataType: "json",
            			success: function(res){
            				if(res.status === 0){
            					console.log(res.data)
            					let admin = JSON.stringify(res.data) //要传的参数
            					
            					$(location).attr('href', encodeURI('index.jsp?admin='+admin)) //跳转地址
            					//location.href="index.jsp?admin="+admin;
            				}
            				else{
            					console.log(res.msg)
            				}
            			},
            			error: function(err){
            				console.log("err")
            			}
            		})
            	})
            	$(document).keydown(function(event){
            		if(event.which == 13)
            			$('#logins').triggerHandler("click");
            	})
           
        </script>
        <!--登录请求响应结束-->

	</body>

</html>