<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>个人注册</title>
		<link rel="shortcut icon" href="favicon.ico" />
		<link rel="stylesheet" type="text/css" href="css/base.css" />

		<link rel="stylesheet" type="text/css" href="css/register.css" />

		<script type="text/javascript" src="js/jquery-3.5.1.min.js"></script>

	</head>

	<body>
		<div class="w">
			<header>
				<a href="index.jsp"><img src="img/m2.jpg" /></a>
			</header>
			<div class="registerarea">
				<h3>
					注册新用户
				<div class="logins">已有账号，去<a href="login.jsp">登录</a></div>
				</h3>

				<!--注册区域-->
				<div class="reg_form">
					<form >
						<ul>
							<li><label for="">用户名：</label> <input type="text" required="required" class="inp" id="username" /></li>
							<li><label for="">密码：</label> <input type="password" required="required" class="inp"  id="password"/></li>
							<li><label for="">电子邮箱：</label> <input type="email" required="required" class="inp" id="email" /> </li>
							<li><label for="">手机号：</label> <input type="tel" required="required" class="inp" id="phone"  /></li>

							<!--安全等级-->
							<li class="safe">
								安全程度： <em class="ruo">弱</em> <em class="zhong">中</em> <em class="qiang">强</em>
							</li>

							<li class="mibao"><label for="">密保问题：</label><input type="text" name="" id="question" value="你印象最深刻的老师是谁？" /></li>
							<li><label for="">密保答案：</label> <input type="text" class="inp" required="required"  id="answer"/></li>

							<!--同意注册-->
							<li class="agree">
								<input type="checkbox" name="" id="" value="" checked="checked" /> 同意协议并注册
								<a href="xieyi.html" target="_blank">知晓用户协议</a>
							</li>

							<!--提交按钮-->
							<li><input type="button" value="完成注册" class="btn"  id="logins"/></li>

						</ul>
					</form>
					
					<!--ajax开始-->
					<script>
            	$('#logins').click(function(){
            		let username = $('#username').val();
            		let password = $('#password').val();
            		let email = $('#email').val();
            		let phone = $('#phone').val();
            		let question = $('#question').val();
            		let answer = $('#answer').val();
           
//          		测试用户名
//          		alert(username)
//          		测试结束
            		$.ajax({
            			type: "post",
            			data: {username:username,password:password,
            				email:email,phone:phone,
            				question:question,answer:answer
            				}, //对应request
            			url: "user?type=register", //对应url
            			dataType: "json",
            			success: function(res){
            				if(res.status === 0){
            					$(location).attr('href', encodeURI('login.jsp')) //跳转地址
            				}
            				else{
            					alert(res.msg)
            				}
            			},
            			error: function(err){
            				console.log(err)
            			}
            		})
            	})
            	$(document).keydown(function(event){
            		if(event.which == 13)
            			$('#logins').triggerHandler("click");
            	})
        </script>
					
					<!--ajax结束-->

				</div>

			</div>
			<footer class="footer">
				<div class="mod_copyright">
					<div class="links">
						小米商城 | MIUI | 米家 | 米聊 | 多看 | 游戏 | 政企服务 | 小米天猫店 | 小米集团隐私政策 | 小米公司儿童信息保护规则 | 小米商城隐私政策 | 小米商城用户协议 | 问题反馈 | Select Location
					</div>
					<div class="copyright">
						© mi.com 京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号 京网文[2020]0276-042号 （京）网械平台备字（2018）第00005号 互联网药品信息服务资格证 (京)-非经营性-2014-0090 营业执照 医疗器械质量公告 增值电信业务许可证 网络食品经营备案（京）【2018】WLSPJYBAHF-12 食品经营许可证 违法和不良信息举报电话：185-0130-1238 知识产权侵权投诉 本网站所列数据，除特殊说明，所有数据均出自我司实验室测试
					</div>
				</div>
			</footer>
		</div>
	</body>

</html>