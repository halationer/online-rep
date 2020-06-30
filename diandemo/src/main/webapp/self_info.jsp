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
	<body>
			<!-- 更改用户名弹窗-->
		<div class="tanname">
			<div class="mod_tip_hd">
				<h4>修改个人资料</h4>
				<a class="guan">
					<img src="img/cuowu.png"/>
				</a>
			</div>
			<div class="mod_main">
				<dl>
 					<dt>请输入新的用户名</dt></br>
 					  	<dd><input class="shurukuang" type="text" name="username" placeholder="输入用户名"/></dd></br>
				</dl>
				
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
			<a href="./index.jsp" target="_blank"><div class="logo fl"></div></a>
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
					<li><a href="dingdanzhongxin.jsp" >全部订单</a></li>
					<li><a href="daifukuandingdan.jsp">待付款</a></li>
					<li><a href="daishouhuodingdan.jsp">待收货</a></li>
					<li><a href="gouwuche.jsp">我的购物车</a></li>
				</ul>
			</div>
			<div class="ddzx">个人中心</div>
			<div class="subddzx">
				<ul>
					<li><a href="./self_info.jsp" style="color:#ff6700;font-weight:bold;">我的个人中心</a></li>
					<li><a href="anquanshezhi.jsp">安全设置</a></li>
					<li><a href="shouhuodizhi.jsp">收货地址</a></li>
					<li><a href="#">消息通知</a></li>
				</ul>
			</div>
		</div>
		<div class="rtcont fr">
			<div class="grzlbt ml40">我的资料
		<!--头像-->
			<div class="touxiang">
				<img src="img/study.jpg"/ style="width: 85px;height: 85px;">
			</div>
			</div>
			
			<div class="subgrzl ml40"><span >用户名</span><span id="username">人声杳杳</span></div>
			<div class="subgrzl ml40"><span>绑定手机</span><span id="phone">15669097417</span></div>
			<div class="subgrzl ml40"><span>登录邮箱</span><span id="email" >287624075@qq.com</span></div>
			<div class="subgrzl ml40"><span>收货地址</span><span id="address" >浙江省杭州市江干区19号大街571号</span></div>
			<!-- 设置个人中心为用户名自 -->
									<script type="text/javascript">
										
										$(function(){
											$.ajax({
						            			type: "post",
						            			data: {}, //对应request
						            			url: "user?type=get_user_info", //对应url
						            			dataType: "json",
						            			success: function(res){
						            				if(res.status === 0){
						            					//console.log(res.data)
						            					const messages = res.data
						            					
						            					//进行参数的设置
						            					$('#username').text(messages.username)
						            					$('#phone').text(messages.phone)
						            					$('#email').text(messages.email)
						            					
						            					//参数信息设置完毕
						            					//let admin = JSON.stringify(res.data) //要传的参数
						            					
						            					//$(location).attr('href', encodeURI('index.jsp?admin='+admin)) //跳转地址
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
		$('.btnname').click(function () {
	  	$('.tanname').css('display', 'block')
	  	})
		$('.guan').click(function () {
    		$('.tanname').css('display', 'none')   
  		})
		$('.buttonstyle2').click(function () {
    		$('.tanname').css('display', 'none')   
  		})
		</script>
		
	</body>
</html>