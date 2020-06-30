<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>小米商城-个人中心</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<link rel="shortcut icon" href="favicon.ico" />
		
		<script type="text/javascript" src="js/jquery-3.5.1.min.js" ></script>
		
	</head>
	<body>
	<!-- start header -->
		<header>
			<div class="top center">
				<div class="left fl">
					<ul>
						<li><a href="index.jsp">小米商城</a></li>
						<li>|</li>
						<li><a href="">米聊</a></li>
						<li>|</li>
						<li><a href="">问题反馈</a></li>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="right fr">
					<div class="gouwuche fr"><a href="">我的订单</a></div>
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
	<!-- start banner_x -->
		<div class="banner_x center">
			<a href="./index.html" target="_blank"><div class="logo fl"></div></a>
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
					<li><a href="dingdanzhongxin.jsp">全部订单</a></li>
					<li><a href="daifukuandingdan.jsp">待付款</a></li>
					<li><a href="daishouhuodingdan.jsp" style="color:#ff6700;font-weight:bold;">待收货</a></li>
					<li><a href="">评价晒单</a></li>
				</ul>
			</div>
			<div class="ddzx">个人中心</div>
			<div class="subddzx">
				<ul>
					<li><a href="self_info.jsp">我的个人中心</a></li>
					<li><a href="gouwuche.jsp">我的购物车</a></li>
					<li><a href="">优惠券</a></li>
					<li><a href="shouhuodizhi.jsp">收货地址</a></li>
				</ul>
			</div>
		</div>
		<div class="rtcont fr">
			<div class="ddzxbt">待收货</div>
			<div class="ddxq">
				<div class="ddspt fl"><img src="img/gwc_xiaomi6.jpg" alt=""></div>
				<div class="ddbh fl">订单号:1705205643098724</div>
				<div class="ztxx fr">
					<ul>
						<li>已发货</li>
						<li>￥2499.00</li>
						<li>2017/05/20 13:30</li>
						<li><a href="">订单详情></a></li>
						
					</ul>
				</div>
				<div class="clear"></div>
			</div>
			<div class="ddxq">
				<div class="ddspt fl"><img src="img/liebiao_hongmin4_dd.jpg" alt=""></div>
				<div class="ddbh fl">订单号:170526435444865</div>
				<div class="ztxx fr">
					<ul>
						<li>已发货</li>
						<li>￥1999.00</li>
						<li>2017/05/26 14:02</li>
						<li><a href="">订单详情></a></li>
						
					</ul>
				</div>
				<div class="clear"></div>
			</div>
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
		
		
		<!-- 订单start -->
		
		<script>
		
		$(function() {
			let pageSize = 20
			let pageNum = 1

			$.ajax({
    			type: "post",
    			data: {}, //对应request
    			url: "order?type=list", //对应url
    			dataType: "json",
    			success: function(res){
    				if(res.status === 0){
    					//console.log(res.data)
    					//let admin = JSON.stringify(res.data) //要传的参数
    					let data_dingdan = res.data.list
    					
    					let array1 = new Array()
    					let array2 = new Array()
    					let array3 = new Array()
    					let array4 = new Array()
    					let array5 = new Array()
    					
    					for(let i = 0 ; i < data_dingdan.length; i++)
    					{
    						array1[i] = $('<div class="ddxq"></div>')
    						$('.rtcont').append(array1[i])
    						let data_fu = "data_fu" + i
    						$(array1[i]).attr('id',data_fu)
    						
    						//img
    						let data_tupian=$('<div class="ddspt fl"><img src="img/gwc_xiaomi6.jpg" alt=""></div>')
    						$('#'+ data_fu).append(data_tupian)
    						
    						//dingdan
    						array2[i] = $('<div class="ddbh fl">订单号:1705205643098724</div>')
    						$('#'+ data_fu).append(array2[i])
    						let data_dingdanid = 'data_dingdanid' + i
    						array2[i].attr('id',data_dingdanid)
    						$('#'+data_dingdanid).text('订单号：'+ data_dingdan.orderNo)
    						
    						
    						
    						array3[i] = $('<div class="ztxx fr"></div>')
    						$('#'+ data_fu).append(array3[i])
    						let data_uniqueid = 'data_uniqueid' + i
    						array3[i].attr('id',data_uniqueid)
    						$('#'+data_uniqueid).append($('<ul></ul>'))
    						$('#'+data_uniqueid+'>ul').append($('<li>已发货</li>'))
    						$('#'+data_uniqueid+'>ul').append($('<li>￥2499.00</li>'))
    						$('#'+data_uniqueid+'>ul').append($('<li>2017/05/20 13:30</li>'))
    						$('#'+data_uniqueid+'>ul').append($('<li><a href="#">订单详情></a></li>'))
    						
    						$('#'+data_uniqueid+'>ul>li:nth-child(2)').text(data_dingdan.payment)
    						$('#'+data_uniqueid+'>ul>li:nth-child(3)').text(data_dingdan.paymentTime)
    						
    						
    						
    						let data_clear = $('<div class="clear"></div>')
    						$('#'+ data_fu).append(data_clear)
    					}
    					
    					//$(location).attr('href', encodeURI('index.jsp?admin='+admin)) //跳转地址
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
	</script>
		
		
		
		<!-- 订单end -->
		
		
		
		
		
	</body>
</html>