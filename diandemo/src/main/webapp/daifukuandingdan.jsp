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
					<li><a href="dingdanzhongxin.jsp">全部订单</a></li>
					<li><a href="daifukuandingdan.jsp">待付款</a></li>
					<li><a href="daishouhuodingdan.jsp">待收货</a></li>
					<li><a href="#">评价晒单</a></li>
					<li><a href="self_info.jsp">我的个人中心</a></li>
					<li><a href="gouwuche.jsp">我的购物车</a></li>
					<li><a href="#">优惠券</a></li>
					<li><a href="shouhuodizhi.jsp">收货地址</a></li>
					<li><a href="#">社区</a></li>
				</ul>
			</div>
			
		</div>
<!-- end banner_x -->
<!-- self_info -->
	<div class="grzxbj">
		<div class="selfinfo center">
		
		<div class="rtcont">
			<div class="ddzxbt">交易订单</div>
			<div class="ddxq">
				<div class="ddspt fl"><img src="img/liebiao_hongmin4_dd.jpg" alt=""></div>
				<div class="ddbh fl" id="dingdan_number">订单号:1705205643098724</div>
				<div class="ztxx fr">
					<ul>
						<li>已发货</li>
						<li id="dingdan_price">￥2499.00</li>
						<li>2019/05/20 13:30</li>
						<li><a href="#">订单详情></a></li>
						<li><button id="fukuan">去付款</button> </li>
					</ul>
				</div>
				<div class="clear"></div>
			</div>
			
		</div>
		<div class="clear"></div>
		</div>
	</div>

		
		<!-- 订单start -->
		
		<script>
		
		$(function() {
			
			 function GetQueryString(name)
			    {
			        var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
			        var r = window.location.search.substr(1).match(reg);//search,查询？后面的参数，并匹配正则
			        if(r!=null)return  decodeURI(r[2]); return null;
			    }
			
			/*
			 function getUrlParam(name) {
		            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
		            var r = window.location.search.substr(1).match(reg);  //匹配目标参数
		            if (r != null) return unescape(r[2]); return null; //返回参数值
		        }
     		*/
			let orderNo = GetQueryString('orderNo');
			let payment = GetQueryString('payment');
			console.log(orderNo)
			console.log(payment)
			$('#dingdan_number').text(orderNo)
			$('#dingdan_price').text(payment)
			//orderNo = 1708351
			//订单付款
			$('#fukuan').click(function(){
				let orderNO1 = $('#dingdan_number').text()
				//console.log(orderNO)
				let orderNO = parseInt(orderNO1)
				console.log(typeof orderNO)
				console.log(orderNO)
				
	    		$.ajax({
	    			type: "get",
	    			data: {orderNO:orderNO}, //对应request
	    			url: "OrderServlet?type=pay", //对应url
	    			dataType: "json",
	    			success: function(res){
	    				if(res.status === 0){
	    					
	    					let pic1 = res.data.qrCode
	    					console.log(pic1)
	    					//
	    					window.open(pic1,"_blank")
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
			//click事件结束
		})
	</script>
	
		<!-- 订单end -->

		
	</body>
</html>