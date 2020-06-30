<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>商品详情</title>
<meta charset="UTF-8">
		<title>小米商城-个人中心</title>
		<link rel="shortcut icon" href="favicon.ico" />
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<link rel="stylesheet" type="text/css" href="css/tanchuang.css">
		<script src="js/jquery-3.5.1.min.js" type="text/javascript"></script>
		
		
		<style>
		 .bianju {
		 	margin-top: 200px;
		 }
		 .daxiao {
		 	font-size: 25px;
		 	color: #ff6700;
		 	padding-left: 30px;
		 }
		 .nums {
		 	width: 50px;
		 	height: 30px;
		 	padding-left: 10px;
		 }
		</style>
</head>
<body>
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

	
	<!-- xiangqing -->
	<form action="post" method="">
	<div class="xiangqing">
		<div class="neirong w">
			<div class="xiaomi6 fl">小米6</div>
			<nav class="fr">
				<li><a href="">概述</a></li>
				<li>|</li>
				<li><a href="">变焦双摄</a></li>
				<li>|</li>
				<li><a href="">设计</a></li>
				<li>|</li>
				<li><a href="">参数</a></li>
				<li>|</li>
				<li><a href="">F码通道</a></li>
				<li>|</li>
				<li><a href="">用户评价</a></li>
				<div class="clear"></div>
			</nav>
			<div class="clear"></div>
		</div>	
	</div>
	
	<div class="jieshao mt20 w">
		<div class="left fl"><a href="xiangqing.jsp" target="_blank"><img src="img/xiaomi10.jpg"  style="width:550px;height:550px;"></a></div>
		<div class="right fr">
			<div class="h3 ml20 mt20 bianju" id="data_name" >小米10</div>
			<div class="jianjie mr40 ml20 mt10" id="subtitle">变焦双摄，4 轴防抖 / 骁龙835 旗舰处理器，6GB 大内存，最大可选128GB 闪存 / 5.15" 护眼屏 / 四曲面玻璃/陶瓷机身</div>
			<div class="daxiao" id="price">2499.00元</div>
			<div class="daxiao" style="color: black;">输入加购数量：<input id="nums" type="text" placeholder="1" class="nums" /></div>
			<div class="xiadan ml20 mt20">
	
					<input class="jrgwc" type="button" name="jrgwc" value="加入购物车" id="shoppings"/>		
			</div>
		</div>
		<div class="clear"></div>
	</div>
	</form>
	
	
	
	<!-- js代码开始 -->
	
		<script>
         
            	$(function(){
            		let productId = "2"
            		
            		
            		 function getUrlParam(name) {
      		            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
      		            var r = window.location.search.substr(1).match(reg);  //匹配目标参数
      		            if (r != null) return unescape(r[2]); return null; //返回参数值
      		        }
      				
            		
      				let idtest = getUrlParam('id');
      				console.log(idtest)
            		
            		productId = idtest
            		

//          		测试用户名
//          		alert(username)
//          		测试结束
            		$.ajax({
            			type: "post",
            			data: {productId:productId}, //对应request
            			url: "goods?type=detail", //对应url
            			dataType: "json",
            			success: function(res){
            				if(res.status === 0){
            					console.log(res.data)
            					let datas = res.data
            					//console.log(datas.name)
            					$('#data_name').text(datas.name)
            					//console.log(datas.price)
            					$('#price').text(datas.price + '元')
            					//console.log(subtitle)
            					$('#subtitle').text(datas.subtitle)
            					
            					//let admin = JSON.stringify(res.data) //要传的参数
            					
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
            	$(document).keydown(function(event){
            		if(event.which == 13)
            			$('#logins').triggerHandler("click");
            	})
           	
            	
            	
            // 加入购物车点击事件开始
            
            $('#shoppings').click(function(){
            	
            	//productId
					
         			let productId = "1"
         			let count = $('#nums').val()
         			console.log(count)
//          		测试用户名
//          		alert(username)
//          		测试结束  
            		$.ajax({
            			type: "post",
            			//data: {productId:productId,count:count}, //对应request
            			//url: "cart?type=add", //对应url
            					
            			data: {productId:productId}, //对应request
            			url: "goods?type=detail", //对应url
            					
            			dataType: "json",
            			success: function(res){
            				if(res.status === 0){
            					console.log(res.data)
            					
            					//let admin = JSON.stringify(res.data) //要传的参数
            					
            					$(location).attr('href', encodeURI('gouwuche.jsp')) //跳转地址
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
   
            
            //加入购物车点击事件结束
            
        </script>
	
	<!-- js代码结束 -->
	
	<!-- footer -->
	<footer class="mt20 center">
			
			<div class="mt20">小米商城|MIUI|米聊|多看书城|小米路由器|视频电话|小米天猫店|小米淘宝直营店|小米网盟|小米移动|隐私政策|Select Region</div>
			<div>©mi.com 京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号 京网文[2014]0059-0009号</div> 
			<div>违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</div>

		</footer>

</body>
</html>