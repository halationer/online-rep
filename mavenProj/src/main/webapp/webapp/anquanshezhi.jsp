<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>小米商城-个人中心</title>
		<link rel="shortcut icon" href="favicon.ico" />
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<link rel="stylesheet" type="text/css" href="css/tanchuang.css">
		<script src="js/jquery-3.5.1.min.js" type="text/javascript"></script>
	</head>
	<!--<script>
		/*当点击调用此方法后,将悬浮窗口显示出来,背景变暗*/
		function displayWindow() {
			/*悬浮窗口的显示,需要将display变成block*/
			document.getElementById("window").style.display = "block";
			/*将背景变暗*/
			document.getElementById("shadow").style.display = "block";
		}

		/*当点击调用此方法,将悬浮窗口和背景全部隐藏*/
		function hideWindow() {
			document.getElementById("window").style.display = "none";
			document.getElementById("shadow").style.display = "none";
		}
//	</script>-->


	<body class="body">
		<!--出现悬浮窗口后,背景变暗-->
		<div id="shadow" class="shadow_css"></div>

		<!-- 账号密码弹窗-->
		<div class="tanmima">
			<div class="mod_tip_hd">
				<h4>修改密码</h4>
				<a class="guan">
					<img src="img/cuowu.png"/>
				</a>
			</div>
			<div class="mod_main">
				<dl>
 				
				   	<dt></dt></br>
  						 <dd><input class="shurukuang" type="text" name="password" placeholder="输入旧密码" id="oldpassword" /></dd></br>
  						 <dd><input class="shurukuang" type="text" name="password" placeholder="输入新密码" id="newpassword" /></dd></br>
  					
				</dl>
				<div class="yanzheng">
						<div class="left fl">验证码:<input class="yanzhengma" type="text" name="username" placeholder="请输入验证码"/></div>
						<div class="right fl"><img src="img/yanzhengma.jpg"></div>
						<div class="clear"></div>
				</div>
				<!-- 确认修改密码按钮-->
				<div class="mimabutton">
					<div class="update_submit">
						<input class="buttonstyle" type="button" name="submit" value="确认" id="configs" >
					</div>
					<div class="update_submit">
						<input class="buttonstyle2" type="button" name="submit" value="取消" >
					</div>
					
					
				</div>
				
				
						<!--登录后修改密码-->
					<script>
         
            	$('#configs').click(function(){
            		let passwordOld = $('#oldpassword').val();
            		let passwordNew = $("#newpassword").val();

            		$.ajax({
            			type: "post",
            			data: {passwordOld:passwordOld,passwordNew:passwordOld}, //对应request
            			url: "user?type=reset_password", //对应url
            			dataType: "json",
            			success: function(res){
            				if(res.status === 0){
            					console.log(res.data)
            					$('.tanmima').css('display', 'none')
            					location.href="self_info.jsp"
            				}
            				else{
            					$('.tanmima').css('display', 'none')
            					alert("接口管理蹦了，请稍后修改")
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
            			$('#logins').triggerHandler("click");
            	})
           
        </script>
				
				
				
				
				
				
				
				
				
			</div>
			
			

			</div>
			
		
		</div>
		
		<!-- 安全密保弹窗
		
		<div class="tanmibao">
			<div class="mod_tip_hd">
				<h4>请牢记您的密保问题</h4>
				<a class="guan">
					<img src="img/cuowu.png"/>
				</a>
			</div>
			<div class="mod_main">
				<dl>
 					<dt>设置密保问题</dt></br>
 					  	<dd><input class="shurukuang" type="text" name="username" placeholder="请输入答案"/></dd></br>
 					<dt>设置密保问题</dt></br>
 					  	<dd><input class="shurukuang" type="text" name="username" placeholder="请输入答案"/></dd></br>
 					<dt>设置密保问题</dt></br>
 					  	<dd><input class="shurukuang" type="text" name="username" placeholder="请输入答案"/></dd></br>
				</dl>
			
				<div class="mimabutton">
					<div class="update_submit">
						<input class="buttonstyle" type="submit" name="submit" value="确认" >
					</div>
					<div class="update_submit">
						<input class="buttonstyle2" type="submit" name="submit" value="取消" >
					</div>
					
					
				</div>
				
			</div>
			
			

			</div>
			
		
		</div>
		
		
		
		-->
		
		
		<!-- 安全手机弹窗-->
		<div class="tanshouji">
			<div class="mod_tip_hd">
				<h4>修改安全手机</h4>
				<a class="guan">
					<img src="img/cuowu.png"/>
				</a>
			</div>
			<div class="mod_main">
				<dl>
 					<dt>请输入新的安全手机号码</dt></br>
 					  	<dd><input class="shurukuang" id="shouji" type="text" name="username" placeholder="请输入手机号码"/></dd></br>
				</dl>
				<div class="yanzheng">
						<div class="left fl"><input class="yanzhengma" type="text" name="username" placeholder="图片验证码"/></div>
						<div class="right fl"><img src="img/yanzhengma.jpg" /></div>
						<div class="clear"></div>
				</div>
				<!-- 确认修改密码按钮-->
				<div class="mimabutton">
					<div class="update_submit">
						<input class="buttonstyle" type="button" name="submit" id="shoujihao" value="确认" >
					</div>
					<div class="update_submit">
						<input class="buttonstyle2" type="button" name="submit" value="取消" >
					</div>
					
					
				</div>
				
			</div>
			
			

			</div>
			
				<!-- 安全手机弹窗-->
		<div class="tanyouxiang">
			<div class="mod_tip_hd">
				<h4>绑定安全邮箱</h4>
				<a class="guan">
					<img src="img/cuowu.png"/>
				</a>
			</div>
			<div class="mod_main">
				<dl>
 					<dt>请输入邮箱账号</dt></br>
 					  	<dd><input class="shurukuang" type="text" name="username" placeholder="请输入邮箱"/></dd></br>
				</dl>
				<div class="yanzheng">
						<div class="left fl"><input class="yanzhengma" type="text" name="username" placeholder="图片验证码"/></div>
						<div class="right fl"><img src="./img/yanzhengma.jpg"></div>
						<div class="clear"></div>
				</div>
				<!-- 确认修改密码按钮-->
				<div class="mimabutton">
					<div class="update_submit">
						<input class="buttonstyle" type="submit" name="submit" value="确认" >
					</div>
					<div class="update_submit">
						<input class="buttonstyle2" type="submit" name="submit" value="取消" >
					</div>
					
					
				</div>
				
			</div>
			
			

			</div>
			

			
			
		</div>
		
		
	<!-- start header -->
		<header>
			<div class="top center">
				<div class="left fl">
					<ul>
						<li><a href="index.jsp" >小米商城</a></li>
						<li>|</li>
						<li><a href="">米聊</a></li>
						<li>|</li>
						<li><a href="">问题反馈</a></li>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="right fr">
					<div class="gouwuche fr"><a href="./dingdanzhongxin.jsp">我的订单</a></div>
					<div class="fr">
						<ul>
							<li><a href="index.jsp" >返回首页</a></li>
							<li>|</li>
							<li><a href="login.jsp" id="logout">退出登录</a></li>
							<li>|</li>
							<li><a href="self_info.jsp" >个人中心</a></li>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
			</div>
		</header>
	<!--end header -->
	
	   <!--退出登录-->
		<script>
         
            	$('#logout').click(function(){
            		
            		$.ajax({
            			type: "post",
            			data: {}, //对应request
            			url: "user?type=logout", //对应url
            			dataType: "json",
            			success: function(res){
            				if(res.status === 0){
            					console.log(res.data)
            					location.href="login.jsp"
            					//密码修改
          					//界面隐藏
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
            			$('#logins').triggerHandler("click");
            	})
           
        </script>
	
	
	<!-- start banner_x -->
		<div class="banner_x center">
			<a href="index.jsp" target="_blank"><div class="logo fl"></div></a>
			<a href=""><div class="ad_top fl"></div></a>
			<div class="nav fl">
				<ul>
					<li><a href="">小米手机</a></li>
					<li><a href="">红米</a></li>
					<li><a href="">平板·笔记本</a></li>
					<li><a href="">电视</a></li>
					<li><a href="">盒子·影音</a></li>
					<li><a href="">路由器</a></li>
					<li><a href="">智能硬件</a></li>
					<li><a href="">服务</a></li>
					<li><a href="">社区</a></li>
				</ul>
			</div>
			<div class="search fr">
				<form action="" method="post">
					<div class="text fl">
						<input type="text" class="shuru"  placeholder="小米6&nbsp;小米MIX现货">
					</div>
					<div class="submit fl">
						<input type="submit" class="sousuo" value="搜索"/>
					</div>
					<div class="clear"></div>
				</form>
				<div class="clear"></div>
			</div>
		</div>
<!-- end banner_x -->
<!-- self_info -->
	<div class="grzxbj">
		<div class="selfinfo center">
		<div class="lfnav fl">
			<div class="ddzx">订单中心</div>
			<div class="subddzx">
				<ul>
					<li><a href="dingdanzhongxin.jsp" >我的订单</a></li>
					<li><a href="">我的关注</a></li>
					<li><a href="">我的收藏</a></li>
					<li><a href="gouwuche.jsp">我的购物车</a></li>
				</ul>
			</div>
			<div class="ddzx">个人中心</div>
			<div class="subddzx">
				<ul>
					<li><a href="./self_info.jsp">我的个人中心</a></li>
					<li><a href="anquanshezhi.jsp" style="color:#ff6700;font-weight:bold;">安全设置</a></li>
					<li><a href="#">收货地址</a></li>
					<li><a href="#">消息通知</a></li>
				</ul>
			</div>
		</div>
		<div class="rtcont fr">
			<div class="grzlbt2 ml40">安全设置
			
			</div>
			<div class="subgrzl2 ml40"><span>账号密码</span></br><span>用于保护账号信息和登录安全</span><span><a href="javascript:void(0)" class="btnmima">修改</a></span></div>
			<div class="subgrzl2 ml40"><span>安全邮箱</span></br><span>安全邮箱将可用于登录账号和重置密码，建议立即设置</span><span><a href="javascript:void(0)" class="btnyouxiang">绑定</a></span></div>
			<div class="subgrzl2 ml40"><span>安全手机</span></br><span>安全手机可以用来登录账号，重置密码或其他安全验证</span><span><a href="javascript:void(0)" class="btntelphone">修改</a></span></div>
			<!--隐藏
			<div class="subgrzl2 ml40"><span>密保问题</span></br><span>密保问题用于安全验证，建议立即设置</span><span><a href="javascript:void(0)" class="btnmibao">设置</a></span></div>
			-->
			
			
		</div>
		<div class="clear"></div>
		</div>
	</div>
	
	
<!-- self_info -->
		
		<footer class="mt20 center">			
			<div class="mt20">小米商城|MIUI|米聊|多看书城|小米路由器|视频电话|小米天猫店|小米淘宝直营店|小米网盟|小米移动|隐私政策|Select Region</div>
			<div>©mi.com 京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号 京网文[2014]0059-0009号</div> 
			<div>违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</div>
		</footer>
		
		
		<script type="text/javascript">
		$('.btnmima').click(function () {
	  	$('.tanmima').css('display', 'block')
	  	})
		$('.guan').click(function () {
    		$('.tanmima').css('display', 'none')   
  		})
		$('.buttonstyle2').click(function () {
    		$('.tanmima').css('display', 'none')   
  		})
		
		<!--邮箱弹窗-->
		$('.btnyouxiang').click(function () {
	  	$('.tanyouxiang').css('display', 'block')
	  
	  	})
		$('.guan').click(function () {
    		$('.tanyouxiang').css('display', 'none')   
  		})
		$('.buttonstyle2').click(function () {
    		$('.tanyouxiang').css('display', 'none')   
  		})
		
		<!--安全手机弹窗-->
		$('.btntelphone').click(function () {
	  	$('.tanshouji').css('display', 'block')
	  	})
		$('.guan').click(function () {
    		$('.tanshouji').css('display', 'none')   
  		})
		$('.buttonstyle2').click(function () {
    		$('.tanshouji').css('display', 'none')   
  		})
		
		<!--安全密保弹窗
		
		$('.btnmibao').click(function () {
		  	$('.tanmibao').css('display', 'block')
		  	
		  	})
			$('.guan').click(function () {
	    		$('.tanmibao').css('display', 'none')   
	  		})
			$('.buttonstyle2').click(function () {
	    		$('.tanmibao').css('display', 'none')   
	  		})
		-->
		
		
		
		</script>
		
		
			<!-- 设置个人中心为用户名自 -->
										<script>
										
										$(function(){
											$.ajax({
						            			type: "post",
						            			data: {}, //对应request
						            			url: "user?type=get_user_info", //对应url
						            			dataType: "json",
						            			success: function(res){
						            				if(res.status === 0){
						            					//console.log(res.data)
						            					const megs = res.data
						            				
						            					$('.tanyouxiang').css('display', 'none')
						            					//$('#email').text(messages.email)
						            					
						            					//参数信息设置完毕
						            					//let admin = JSON.stringify(res.data) //要传的参数
						            					
						            					//$(location).attr('href', encodeURI('anquanshezhi.jsp')) //跳转地址
						            					//location.href="index.jsp?admin="+admin;
						            				}
						            				else{
						            					console.log(res.msg)
						            				}
						            			},
						            			error: function(err){
						            				console.log(err)
						            			}
						            		})
						            		
						            		
						            	$(document).keydown(function(event){
						            		if(event.which == 13)
						            			$('#logins').triggerHandler("click");
						            	})
						            	
										})
						            		
						          
						           
						        </script>
								
			<!-- 设置结束 -->
		
	</body>
</html>