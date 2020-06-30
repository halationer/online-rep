<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>我的购物车-小米商城</title>
		<link rel="shortcut icon" href="favicon.ico" />
		<style>
		
		   .shangcheng {
				height: 90px;
			}
			.shangcheng a img {
				float: left;
				height: 60px;
				width: 60px;
				margin: 15px 0;
				
			}
			.shangcheng .tips {
				float:left;
				margin-top: 30px;
				font-size: 20px;
				padding-left: 30px;
			}
			.daxiao {
				width: 80px;
				height: 90px;
			}
			.tip1 a{
			 	float:right;
			 	
			 	width:150px;
			 	height:30px;
			 	font-size: 16px;
			 	margin-right: 20px;
			 	margin-top: 30px;
			}
			.tip1 a:hover{
				background-color: rgb(254, 106, 0);
			}
		</style>
		
		<link rel="stylesheet" type="text/css" href="css/base.css"/>
		
		<link rel="stylesheet" type="text/css" href="css/style.css">
	</head>
	<body>
	<!-- start header -->
	<!--end header -->

<!-- start banner_x -->

		<div class="shangcheng w">
			<a href="index.jsp"><img src="img/m2.jpg"/> </a>
			<div class="tips"> 我的购物车</div>
			<div class="tip1"> <a href="self_info.jsp">返回个人中心</a></div>
			<div class="tip1"> <a href="index.jsp">返回首页</a></div>
		</div>
	
		<div class="xiantiao"></div>
		<div class="gwcxqbj">
			<div class="gwcxd center">
				<div class="top2 center">
					<div class="sub_top fl">
						<input type="checkbox" value="quanxuan" class="quanxuan" />全选
					</div>
					<div class="sub_top fl">商品名称</div>
					<div class="sub_top fl">单价</div>
					<div class="sub_top fl">数量</div>
					<div class="sub_top fl">小计</div>
					<div class="sub_top fr">操作</div>
					<div class="clear"></div>
				</div>
				<div class="content2 center">
					<div class="sub_content fl ">
						<input type="checkbox" value="quanxuan" class="quanxuan" />
					</div>
					<div class="sub_content fl"><img  class="daxiao" src="img/dianshi1.jpg"></div>
					<div class="sub_content fl ft20">小米电视 亮黑色</div>
					<div class="sub_content fl ">5499元</div>
					<div class="sub_content fl">
						<input class="shuliang" type="number" value="1" step="1" min="1" >
					</div>
					<div class="sub_content fl">5499元</div>
					<div class="sub_content fl"><a href="">×</a></div>
					<div class="clear"></div>
				</div>
				<div class="content2 center">
					<div class="sub_content fl ">
						<input type="checkbox" value="quanxuan" class="quanxuan" />
					</div>
					<div class="sub_content fl"><img class="daxiao" src="img/mi1.jpg"></div>
					<div class="sub_content fl ft20">小米10 8+128G 亮黑色</div>
					<div class="sub_content fl ">2499元</div>
					<div class="sub_content fl">
						<input class="shuliang" type="number" value="1" step="1" min="1" >
					</div>
					<div class="sub_content fl">2499元</div>
					<div class="sub_content fl"><a href="">×</a></div>
					<div class="clear"></div>
				</div>
			</div>
			<div class="jiesuandan mt20 center">
				<div class="tishi fl ml20">
					<ul>
						<li><a href="./liebiao.html">继续购物</a></li>
						<li>|</li>
						<li>共<span>2</span>件商品，已选择<span>1</span>件</li>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="jiesuan fr">
					<div class="jiesuanjiage fl">合计（不含运费）：<span>2499.00元</span></div>
					<div class="jsanniu fr"><input class="jsan" type="submit" name="jiesuan"  value="去结算"/></div>
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
			</div>
			
		</div>

  

	
	<!-- footer -->
	<footer class="center">
			
			<div class="mt20">小米商城|MIUI|米聊|多看书城|小米路由器|视频电话|小米天猫店|小米淘宝直营店|小米网盟|小米移动|隐私政策|Select Region</div>
			<div>©mi.com 京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号 京网文[2014]0059-0009号</div> 
			<div>违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</div>
		</footer>

	</body>
</html>