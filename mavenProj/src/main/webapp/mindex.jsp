<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>登录-电商平台后台管理系统</title>
        <script src="js/jquery.js"></script>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src="/js/bootstrap.min.js"></script>
        <style>
        	*{margin: 0; padding: 0}
        	body{
        		width: 100vw;
        		height: 100vh;
        		display: flex;
        	}
        	#background{
                width: 100%;
                height: 100%;
        		background: url('img/alogin-back.jpg') no-repeat;
        		background-size: 100%;
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
        	#wrap{
        		width: 400px;
        		height: 235px;
        		margin: auto;
        		background: #fff;
        		border-radius: 10px;
                box-shadow: 1px 1px 20px #00000080;
                display: flex;
                flex-direction: column;
        	}
        	h1{
        		font-size: 20px;
        		font-family: SimHei;
        		letter-spacing: 0.5em;
                text-align: center;
        	}
        	.form-group{
                display: flex;
                flex: 1;
            }
            .form-group>input{
                flex: 5;
                margin: auto;
            }
            .form-group>label{
                flex: 1;
                margin: auto;
            }
            #wrap>div, #login{
                margin: 10px 35px;
            }
            #wrap>#title{
            	margin-top: 20px;
            	margin-bottom: 0;
            }
            #login{
            	margin-bottom: 20px;
            }
        </style>
    </head>
    <body>
    	<div id='background'></div>
        <form id='wrap'>
            <div id='title'><h1>后台管理系统</h1></div>
            <div class="form-group">
                <input type="text" name="username" placeholder='账号' class="form-control" id="user" autocomplete="off" />
            </div>
            <div class="form-group">
                <input type="password" name="password" placeholder='密码' class="form-control" id="password" autocomplete="off" />
            </div>
            <button type="button" class="btn btn-primary" id='login'>登录</button>
            <script>
            	$('#login').click(function(){
            		let username = $('#user').val();
            		let password = $("#password").val();
            		$.ajax({
            			type: "post",
            			data: {username:username,password:password}, //对应request
            			url: "manage/user?type=login", //对应url
            			dataType: "json",
            			success: function(res){
            				if(res.status === 0){
            					// console.log(res.data)
            					// let admin = JSON.stringify(res.data) //要传的参数
            					// $(location).attr('href', encodeURI('acontent/auser.jsp?admin='+admin)) //跳转地址
								$(location).attr('href', 'acontent/auser.jsp')
							}
            				else{
            					console.log(res.msg)
            				}
            			},
            			error: function(err){
            				console.log(err)
            			}
            		})
            	})
            	$(document).keydown(function(event){
            		if(event.which == 13)
            			$('#login').triggerHandler("click");
            	})
            </script>
        </form>
    </body>
</html>