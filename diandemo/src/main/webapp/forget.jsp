<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>找回密码</title>
		<link rel="shortcut icon" href="favicon.ico" />
		<link rel="stylesheet" type="text/css" href="css/base.css"/>
		
		<link rel="stylesheet" type="text/css" href="css/register.css"/>
		
		<script type="text/javascript" src="js/jquery-3.5.1.min.js" ></script>
		
	</head>
	<body>
		<div class="w">
			<header>
				<a href="index.jsp"><img src="img/m2.jpg"/></a>
			</header>
			<div class="registerarea">
				<h3>
					找回密码
				<div class="logins">想起账号，去<a href="login.jsp">登录</a></div>
				</h3>
				
				<!--注册区域-->
				<div class="reg_form">
					<form action="" method="post">
					  <ul>
						<li><label for="">用户名：</label> <input type="text"  required="required" class="inp" id="user"/></li>
						<li class="mibao"><label for="">密保问题：</label><input type="text" value="你印象最深刻的老师是谁？" id="question" /></li>
						<li><label for="">密保答案：</label> <input type="text" class="inp"  required="required" id="answer" /></li>
						
						
						<!--提交按钮-->
						<li><input type="button" value="找回密码" class="btn" id="logins"/></li>
						
					   </ul>
		
					</form>
				</div>
			
			<!-- js代码 -->
			<script type="text/javascript">
            	$('#logins').click(function(){
            		let username = $('#user').val();
            		let question = $("#question").val();
            		let answer = $("#answer").val();
//          		测试用户名
//          		alert(username)
//          		测试结束
            		$.ajax({
            			type: "get",
            			data: {username:username,question:question,
            			answer:answer	
            			}, //对应request
            			url: "user?type=forget_check_answer", //对应url
            			dataType: "json",
            			success: function(res){
            				if(res.status === 0){
            					console.log(res.data)
            					
            					let token = JSON.stringify(res.data) //要传的参数
            					//$(location).attr('href', encodeURI('index.jsp?admin='+admin)) //跳转地址
            					location.href="configsecret.jsp?token="+token;
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
				
			<!-- js代码结束 -->	
			</div>
			<!-- 版心结束 -->
			<footer class="footer">
					<div class="mod_copyright">
					<div class="links">
						小米商城 | MIUI | 米家 | 米聊 | 多看 | 
						游戏 | 政企服务 | 小米天猫店 | 小米集团隐私政策 | 
						小米公司儿童信息保护规则 | 小米商城隐私政策 | 
						小米商城用户协议 | 问题反馈 | Select Location
					</div>
					<div class="copyright">
						© mi.com 京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号 京网文[2020]0276-042号
（京）网械平台备字（2018）第00005号 互联网药品信息服务资格证 (京)-非经营性-2014-0090 营业执照 医疗器械质量公告
增值电信业务许可证 网络食品经营备案（京）【2018】WLSPJYBAHF-12  食品经营许可证
违法和不良信息举报电话：185-0130-1238 知识产权侵权投诉 本网站所列数据，除特殊说明，所有数据均出自我司实验室测试
					</div>
				</div>
			</footer>
		</div>
	</body>
</html>
