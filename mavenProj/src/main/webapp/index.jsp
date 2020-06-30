<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>睿乐购商城-综合网购首选-来找我们呀</title>
		<!--说明-->
		<meta name="description" content="小米-专业的综合网上购物商城,销售家电、数码通讯、电脑、家居百货等多个品牌优质商品.便捷、诚信的服务，为您提供愉悦的网上购物体验!">
		<!--关键字-->
		<meta name="Keywords" content="网上购物,网上商城,手机,笔记本,电脑,家具产品,小米">
		
		<link rel="stylesheet" href="css/base.css" />
		<link rel="stylesheet" href="css/common.css" />
		
		<link rel="stylesheet" href="demo/iconfont.css" />
		
		<link rel="stylesheet" type="text/css" href="css/index.css"/>
		<link rel="stylesheet" type="text/css" href="css/shangpin.css"/>
		
		<script type="text/javascript" src="js/jquery-3.5.1.min.js" ></script>
		
		<style>	
			.nav h1{
				font-weight: 400;
				background-color: pink; 
				text-align: center;
			}
			
			.nav ul li {
				float: left;
				font-size: 16px;
				padding-left: 30px;
				color: black;
			}
			
		</style>
		
	<link rel="shortcut icon" href="favicon.ico" />
	<script src="js/jquery-3.5.1.min.js"></script>
	
	
	<!--<script>
		$(function(){
			
		})
	</script>-->
	
	
	</head>
	<body>
	
		<!--快捷导航模块-->
		<section class="shortcut">

			<div class="w">
				<div class="fl">
					<ul>
						<li>睿乐购欢迎您! &nbsp;</li>
						<li>
							<a href="login.jsp" class="msgtest">请登录</a>&nbsp;
							<a href="zhuce.jsp" class="style_red msgtest">免费注册</a>
						</li>
					</ul>
				</div>
				<div class="fr">
					<ul>
						<li><a href="dingdanzhongxin.jsp">我的订单</a></li>
						<li></li>
						<li class="arrow-icon"><a href="gouwuche.jsp">我的购物车</a></li>
						<li></li>
						<li>睿乐购会员</li>
						<li></li>
						<li>企业采购</li>
						<li></li>
						<li class="iconfont">关注睿乐购 &#xe797</li>
						<li></li>
						<li class="iconfont" ><a id="person" href="#">个人中心&#xe797</a></li>
						<li></li>
						<li >
							<select>
								<option >网站导航 </option>
								<option ><a href="self_info.jsp">购物车</a> </option>
							</select>
						</li>
					</ul>
				</div>
			</div>
				
		</section>
					<!--写关于客户服务的内容-->
					<script>
						 //$('#person').text('ly')
    					//console.log('${param.answer}')
    					let adminname = '${sessionScope.flag}'
						 console.log(adminname)
           			 //alert("hh")
    					$(function(){
    					if(adminname!== '')
    					{
    						$('#person').text(adminname)
            		    	$('.msgtest').text('')
    					}
    					else {
    						$('#person').text("尚未登录")
    						
    					}	
            		    //点击 事件
            		    $('#person').click(function(){
    					//alert('hh')
    					if(adminname !== '')
    						$(location).attr('href', encodeURI('self_info.jsp')) //跳转地址
    						//location.href="self_info.jsp'
    					else
    						//$(location).attr('href', encodeURI('login.jsp')) 
    						location.href='login.jsp'
    					
    					})
            		})
    				
//  				
					</script>
		
		<!--快捷导航栏结束-->
		<!--head盒子-->
		<header class="header w">
			<!--logo-->
			<div class="logo">
				<h1>
					<a href="index.jsp" title="小米商城">睿乐购商城</a>
				</h1>
			</div>
			
			<!--search搜索模块-->
			<div class="search">
				<input type="search" name="" id="" placeholder="睿乐购欢迎您" />
				<button>搜索</button>
			</div>
			
			<!--hotwords模块制作-->
			<div class="hotwords">
				<a href="#" class="style_red">优惠券首发</a>
				<a href="#">亿万优惠</a>
				<a href="#">9.9元团聚</a>
				<a href="#">美满99减30</a>
				<a href="#">办公用品</a>
				<a href="#">电脑</a>
				<a href="#">通信</a>
			</div>
			
			<!--购物车-->
			<div class="shopcar iconfont">
				<a href="gouwuche.jsp" target="_blank" ><span>&#xe661;</span>我的购物车  <span class="count">2</span> <span>&gt;</span></a>
			</div>
		</header>
		<!--nav模块-->
		<div class="nav w">
			<div class="dropdowm">
				<div class="dt">全部商品分类</div>
				<div class="dd">
					<ul>
						<li><a href="#shoujimaodian">手机 <span>&gt;</span></a></li>
						<li><a href="#jiadianmaodian">家电<span>&gt;</span></a></li>
						<li><a href="#fuzhuangmaodian">服装<span>&gt;</span></a></li>
						<li><a href="#shoushimaodian">首饰<span>&gt;</span></a></li>
						<li><a href="#tuijianmaodian">笔记本<span>&gt;</span></a></li>
						<li><a href="#jiadianmaodian">洗衣机<span>&gt;</span></a></li>
						<li><a href="#jiadianmaodian">出行<span>&gt;</span></a></li>
						<li><a href="#jiadianmaodian">智能<span>&gt;</span></a></li>
						<li><a href="#jiadianmaodian">路由器<span>&gt;</span></a></li>
						<li><a href="#jiadianmaodian">电源<span>&gt;</span></a></li>
						<li><a href="#jiadianmaodian">配件<span>&gt;</span></a></li>
						<li><a href="#jiadianmaodian">耳机<span>&gt;</span></a></li>
						<li><a href="#jiadianmaodian">音箱<span>&gt;</span></a></li>
						<li><a href="#jiadianmaodian">儿童<span>&gt;</span></a></li>
						<li><a href="#jiadianmaodian">箱包<span>&gt;</span></a></li>
					</ul>
				</div>
			</div>
			<div class="navitems">
				<ul>
					<li><a href="#shoujimaodian">手机</a></li>
					<li><a href="#fuzhuangmaodian">服装</a></li>
					<li><a href="#shoushimaodian">首饰</a></li>
					<li><a href="#jiadianmaodian">笔记本</a></li>
					<li><a href="#jiadianmaodian">家电</a></li>
					<li><a href="#jiadianmaodian">路由器</a></li>
					<li><a href="#fuwumaodian">服务</a></li>
					<li><a href="#fuwumaodian">社区</a></li>
					
				</ul>
			</div>
		</div>
		<!--nav模块-->
		<!--首页转门的模块 start-->
		<div class="w">
			<div id="wrap">
				<ul id="btn"></ul>
			</div>
		</div>
			<script>
			$(function(){
				const array = [
					'img/shou1.jpg',
					'img/pic1.jpg',
					'img/bing1.jpg',
					'img/tu1.jpg',
					'img/meinv1.jpg'
				]
				/**
				 * 创建虚拟dom 
				 * 	$(标签)
				 * 需要把虚拟dom 加载进实体dom 就可以让它存在
				 * 
				 * 
				 * */
				creatediv()
				function creatediv() {
					for(let i = 0; i < array.length; i++) {
						const div = $('<div></div>')
						const li = $('<li></li>')
						div.css({
							'background':'url(' + array[i] + ')',
							'background-size':'100% 100%'
						})
						$('#wrap').append(div)
						$('#btn').append(li)
					}
				}
				// 点击li 切换图片
				$('#btn>li').click(function(){
					// 获取到 点击的是 第几个 li
					// index方法 表示 获取 当前对象 在同级元素中排在第几个(0开始)
					const index = $(this).index()
					// 点击的是第几个li 就要显示第几个 div
					$('#wrap>div').eq(index).fadeIn(1000).siblings('div').fadeOut(1000)
				})
			})
		</script>
		
		<!--首页专门的模块结束-->
		
		<!--推荐模块开始-->
		<div class="recom w" id="tuijianmaodian">
			<h3>精品推荐</h3>
			
		<ul>
			<li><a href="#" target="_blank" id="linkid0">
				<div class="box">
				<div class="box-hd">
					<!--<h3>精品推荐</h3>-->
					<img src="img/p1.jpg" alt="" />
				</div>
				<div class="box-bd">
					<div class="contents" id="name0">
						小米10 青春版 5G
					</div>
					<div class="middles" id="subtitle0">
						50倍潜望望式变焦 / 轻薄5G手机
					</div>
					<div class="price" id="price0">
						4999元起
					</div>
				</div>
			</div>
			</a></li>
			<li><a href="#" id="linkid1"  target="_blank">
				<div class="box">
				<div class="box-hd">
					
					<img src="img/dianshi1.jpg" alt="" />
				</div>
				<div class="box-bd">
					<div class="contents" id="name1">
						 小米电视 聚优惠
					</div>
					<div class="middles" id="subtitle1">
						高清大屏 / 方便省心
					</div>
					<div class="price" id="price1">
						5999元起
					</div>
				</div>
			</div>
			</a></li>
			<li><a href="#" id="linkid2"  target="_blank">
				<div class="box">
				<div class="box-hd">
					
					<img src="img/jiadian4.jpg" alt="" />
				</div>
				<div class="box-bd">
					<div class="contents" id="name2">
						小米洗衣机
					</div>
					<div class="middles" id="subtitle2">
						省心 / 快捷
					</div>
					<div class="price" id="price2">
						1000元起
					</div>
				</div>
			</div>
			</a></li>
			<li><a href="#" id="linkid3"  target="_blank">
				<div class="box">
				<div class="box-hd">
					<!--<h3>精品推荐</h3>-->
					<img src="img/c1.jpg" alt="" />
				</div>
				<div class="box-bd">
					<div class="contents" id="name3">
						小米笔记本
					</div>
					<div class="middles" id="subtitle3">
						高清屏幕 / 急速开机
					</div>
					<div class="price" id="price3">
						7999元起
					</div>
				</div>
			</div>
			</a></li>
			<li><a href="#" id="linkid4"  target="_blank">
				<div class="box">
				<div class="box-hd">
					<!--<h3>精品推荐</h3>-->
					<img src="img/小米手环.jpg" alt="" />
				</div>
				<div class="box-bd">
					<div class="contents" id="name4">
						小米手环4
					</div>
					<div class="middles" id="subtitle4">
						大屏彩显，20天超长续航
					</div>
					<div class="price" id="price4">
						169元
					</div>
				</div>
			</div>
			</a></li>
		</ul>
		
		</div>
		
		
			
		
		<!--推荐模块结束-->
		
		<!--商品模块开始-->
		
		<div>
       			<img src="img/fengeshouji.jpg" style="width: 1200px;">
		</div>	
			
		<div class="peijian w" id="shoujimaodian">
			<h3>手机</h3>
			<div class="main center">
				<div class="content">
					<div class="remen fl"><a href="#"  target="_blank"><img src="img/shoujidatu.jpg"></a></div>
					<div class="remen fl">
						<div class="xinpin"><span style="background:#fff"></span></div>
						<div class="tu"><a href="#" target="_blank" id="linkid5" ><img src="img/xiaomi10.jpg"></a></div>
						<div class="miaoshu" id="name5">小米10</div>
						<div class="pingjia" id="subtitle5">骁龙865/1亿像素相机</div>
						<div class="jiage" id="price5">3999元起</div>	
					</div>
					<div class="remen fl">
						<div class="xinpin"><span style="background:#fff"></span></div>
						<div class="tu"><a href="#" target="_blank" id="linkid6" ><img src="img/Redmi K30 Pro 变焦版.jpg"></a></div>
						<div class="miaoshu" id="name6">Redmi K30 Pro 变焦版</div>
						<div class="pingjia" id="subtitle6">双模5G，骁龙865，弹出全面屏</div>
						<div class="jiage" id="price6">3799元</div>	
					</div>
					
					<div class="remen fl">
						<div class="xinpin"><span style="background:#fff"></span></div>
						<div class="tu"><a href="#" target="_blank" id="linkid7"><img src="img/xiaomi10qingchun.jpg"></a></div>
						<div class="miaoshu" id="name7">小米10 青春版 5G</div>
						<div class="pingjia" id="subtitle7">50倍潜望式变焦/轻薄5G手机</div>
						<div class="jiage" id="price7">2099元</div>						
					</div>
					
					
					
					<div class="remen fl">
						<div class="xinpin"><span style="background:#fff"></span></div>
						<div class="tu"><a href="#" target="_blank" id="linkid8" ><img src="img/Redmi K30 Pro.jpg"></a></div>
						<div class="miaoshu" id="name8">Redmi K30 Pro</div>
						<div class="pingjia" id="subtitle8">双模5G，骁龙865，弹出全面屏</div>
						<div class="jiage" id="price8">2999元起</div>
					</div>
					
					<div class="clear"></div>
				</div>
				
				<div class="content">
					<div class="remen fl"style="visibility:hidden;"></div>
					<div class="remen fl">
						<div class="xinpin"><span style="background:#fff"></span></div>
						<div class="tu"><a href="#" target="_blank" id="linkid9"><img src="img/小米10 Pro.jpg"></a></div>
						<div class="miaoshu" id="name9">小米10 Pro</div>
						<div class="pingjia" id="subtitle9">骁龙865/50倍变焦</div>
						<div class="jiage" id="price9">4999元起</div>	
					</div>
					
					<div class="remen fl">
						<div class="xinpin"><span style="background:#fff"></span></div>
						<div class="tu"><a href="#" target="_blank" id="linkid10"><img src="img/Redmi K30.jpg"></a></div>
						<div class="miaoshu" id="name10"> Redmi K30</div>
						<div class="pingjia" id="subtitle10">120Hz流速屏，全速热爱</div>
						<div class="jiage" id="price10">1499元起</div>		
					</div>
					
					<div class="remen fl">
						<div class="xinpin"><span style="background:#fff"></span></div>
						<div class="tu"><a href="#" target="_blank" id="linkid11" ><img src="img/Redmi K30 5G.jpg"></a></div>
						<div class="miaoshu" id="name11">Redmi K30 5G</div>
						<div class="pingjia" id="subtitle11">双模5G，120Hz流速屏</div>
						<div class="jiage" id="price11">1899元起</div>	
					</div>
					
					<div class="remen fl">
						<div class="xinpin"><span style="background:#fff"></span></div>
						<div class="tu"><a href="#" target="_blank" id="linkid12"><img src="img/Redmi 8.jpg"></a></div>
						<div class="miaoshu" id="name12" >Redmi 8</div>
						<div class="pingjia" id="subtitle12">5000mAh超长续航</div>
						<div class="jiage" id="price12">799元</div>		
					</div>
					
					<div class="clear"></div>
				</div>				
			</div>
		</div>
		
		
<!-- 服装模块 -->
		<div class="peijian w" style="margin-top: 27px;"id="fuzhuangmaodian">
			<div><img src="img/fengechaoliutu.jpg"style="width: 1200px;"></div>
			
		<div class="peijian w" >
			<h3>服装</h3>
			<div class="main center">
				<div class="content">
					<div class="remen fl"><a href="#"><img src="img/wuyifan.jpg"style="width:232px;"></a>
					</div>
					<div class="remen fl">
						<div class="xinpin"><span style="background:#fff"></span></div>
						<div class="tu"><a href="#" target="_blank" id="linkid13" ><img src="img/pphome.jpg"style="width:200px;"></a></div>
						<div class="miaoshu" id="name13">PPHOME今日温柔指标在线</div>
						<div class="pingjia" id="subtitle13">韩系ins清新少女复古方领褶皱高腰短衬衫</div>						
						<div class="jiage" id="price13">79元</div>
						
					</div>
									<div class="remen fl">
						<div class="xinpin"><span style="background:#fff"></span></div>
						<div class="tu"><a href="#" target="_blank" id="linkid14"><img src="img/only女裙.jpg"style="width:200px;"></a></div>
						<div class="miaoshu" id="name14">ONLY夏季新款</div>
						<div class="pingjia" id="subtitle14">高腰A字裙百搭休闲牛仔短裙半身裙女</div>
						<div class="jiage" id="price14">175元</div>
						
						
					</div>
					<div class="remen fl">
						<div class="xinpin"><span style="background:#fff"></span></div>
						<div class="tu"><a href="#" target="_blank" id="linkid15"><img src="img/Vero Moda连衣裙.jpg"style="width:200px;"></a></div>
						<div class="miaoshu" id="name15">Vero Moda连衣裙</div>
						<div class="pingjia" id="subtitle15">花苞连衣裙</div>
						<div class="jiage" id="price15">349元</div>
						
						
					</div>
					<div class="remen fl">
						<div class="xinpin"><span style="background:#fff"></span></div>
						<div class="tu"><a href="#" target="_blank" id="linkid16"><img src="img/破洞裤.jpg"style="width:200px;"></a></div>
						<div class="miaoshu" id="name16">dorastudio牛仔裤</div>
						<div class="pingjia" id="subtitle16">破洞牛仔裤女直筒宽松</div>
						<div class="jiage" id="price16">119元</div>
						
						
					</div>
					<div class="clear"></div>
				</div>
				<div class="content">
					<div class="remen fl"style="visibility:hidden;"></div>
					<div class="remen fl">
						<div class="xinpin"><span style="background:#fff"></span></div>
						<div class="tu"><a href="#" target="_blank" id="linkid17"><img src="img/nikeair.jpg"style="width:200px;"></a></div>
						<div class="miaoshu" id="name17">Nike 耐克官方</div>
						<div class="pingjia" id="subtitle17">NIKE SPORTSSWEAR男子T恤新品夏季全棉</div>
						<div class="jiage" id="price17">259元</div>
						
						
					</div>
					<div class="remen fl">
						<div class="xinpin"><span style="background:#fff"></span></div>
						<div class="tu"><a href="#" target="_blank" id="linkid18"><img src="img/李宁短袖.jpg"style="width:200px;"></a></div>
						<div class="miaoshu" id="name18">李宁短袖男</div>
						<div class="pingjia" id="subtitle18">2020夏季运动时尚大LOGO</div>
						<div class="jiage" id="price18">78元</div>
						
					</div>
					<div class="remen fl">
						<div class="xinpin"><span style="background:#fff"></span></div>
						<div class="tu"><a href="#" target="_blank" id="linkid19"><img src="img/youyiku.jpg"style="width:200px;"></a></div>
						<div class="miaoshu" id="name19">优衣库男装</div>
						<div class="pingjia" id="subtitle19">Fortnite 印花T恤（短袖）</div>
						<div class="jiage" id="price19">4899元</div>
						
					</div>
					<div class="remen fl">
						<div class="xinpin"><span style="background:#fff"></span></div>
						<div class="tu"><a href="#" target="_blank" id="linkid20"><img src="img/nike运动裤.jpg"style="width:200px;"></a></div>
						<div class="miaoshu" id="name20">Nike 耐克官方</div>
						<div class="pingjia" id="subtitle20">SPORTSWEAR CLUB FLEECE 男子长裤</div>
						<div class="jiage" id="price20">249元</div>
						
					</div>
					<div class="clear"></div>
				</div>				
			</div>
		</div>
		
		<!-- 家电 -->>			
		<div class="peijian w" style="margin-top: 20px;">
			<div><img src="img/fengejiadian.jpg"/ style="width: 1200px;"></div>
			
		<div class="peijian w" id="jiadianmaodian">
			<h3>家电</h3>
			<div class="main center">
				<div class="content">
					<div class="remen fl"><a href=""><img src="img/jiadiantu1.jpg"></a>
					</div>
					<div class="remen fl">
						<div class="xinpin"><span style="background:#fff"></span></div>
						<div class="tu"><a href="#" target="_blank" id="linkid21"><img src="img/Redmi 红米电视 70英寸.jpg"></a></div>
						<div class="miaoshu" id="name21">Redmi 红米电视 70英寸</div>
						<div class="pingjia" id="subtitle21">70英寸震撼巨屏，4K画质，细腻如真</div>
						<div class="jiage" id="price21">2999元</div>
						
					</div>
					<div class="remen fl">
						<div class="xinpin"><span style="background:#fff"></span></div>
						<div class="tu"><a href="#" target="_blank" id="linkid22"><img src="img/小米全面屏电视E32C.jpg"></a></div>
						<div class="miaoshu" id="name22">小米全面屏电视E32C</div>
						<div class="pingjia" id="subtitle22">全面屏设计，人工智能系统</div>
						<div class="jiage" id="price22">799元</div>
						
						
					</div>
					<div class="remen fl">
						<div class="xinpin"><span style="background:#fff"></span></div>
						<div class="tu"><a href="#" target="_blank" id="linkid36"><img src="img/小米全面屏电视E55A.jpg"></a></div>
						<div class="miaoshu" id="name36">>小米全面屏电视E55A</div>
						<div class="pingjia" id="subtitle36">全面屏设计，人工智能语音</div>
						<div class="jiage" id="price36">1799元</div>
						
						
					</div>
					<div class="remen fl">
						<div class="xinpin"><span style="background:#fff"></span></div>
						<div class="tu"><a href="#" target="_blank" id="linkid23"><img src="img/米家空调.jpg"></a></div>
						<div class="miaoshu" id="name23">米家空调</div>
						<div class="pingjia" id="subtitle23">出众静音，快速制冷热</div>
						<div class="jiage" id="price23">1499元</div>
						
						
					</div>
					<div class="clear"></div>
				</div>
				<div class="content">
					<div class="remen fl"><a href=""><img src="img/jiadiantu2.jpg"></a>
					</div>
					<div class="remen fl">
						<div class="xinpin"><span style="background:#fff"></span></div>
						<div class="tu"><a href="#" target="_blank" id="linkid24"><img src="img/米家互联网洗烘一体机 Pro 10kg.jpg"></a></div>
						<div class="miaoshu" id="name24">米家互联网洗烘一体机 Pro 10kg</div>
						<div class="pingjia" id="subtitle24">智能洗烘，省心省力</div>
						<div class="jiage" id="price24">2999元</div>
						
						
					</div>
					<div class="remen fl">
						<div class="xinpin"><span style="background:#fff"></span></div>
						<div class="tu"><a href="#" target="_blank" id="linkid25"><img src="img/Redmi全自动波轮洗衣机1A 8kg.jpg"></a></div>
						<div class="miaoshu" id="name25">Redmi全自动波轮洗衣机1A 8kg</div>
						<div class="pingjia" id="subtitle25">一键操作，父母都爱用</div>
						<div class="jiage" id="price25">779元</div>
						
					</div>
					<div class="remen fl">
						<div class="xinpin"><span style="background:#fff"></span></div>
						<div class="tu"><a href="#" target="_blank" id="linkid26"><img src="img/15.6'' 四核i7 16G 独显 512G.jpg"></a></div>
						<div class="miaoshu" id="name26">小米电脑15.6'' 四核i7 16G 独显 512G</div>
						<div class="pingjia" id="subtitle26">全面均衡的国民轻薄本</div>
						<div class="jiage" id="price26">4899元</div>
						
					</div>
					<div class="remen fl">
						<div class="xinpin"><span style="background:#fff"></span></div>
						<div class="tu"><a href="#" target="_blank" id="linkid27"><img src="img/小米电视4A 32英寸.jpg" style="width:198px;"></a></div>
						<div class="miaoshu" id="name27">小米电视4A 32英寸</div>
						<div class="pingjia" id="subtitle27">64位四核处理器 1GB+4GB大内存</div>
						<div class="jiage" id="price27">699元</div>
						
					</div>
					<div class="clear"></div>
				</div>				
			</div>
		</div>
		
		<!-- 首饰模块 -->
		<div class="peijian w" style="margin-top: 20px;"id="shoushimaodian">
		<div>
       			<img src="img/fengetu3.jpg" style="width: 1200px;">
		</div>	
		
				<div class="peijian w">
			<h3>首饰</h3>
			<div class="main center">
				<div class="content">
					<div class="remen fl"><a href=""><img src="img/大图戒指.jpg"style="width:300px;"></a>
					</div>
					<div class="remen fl">
						<div class="xinpin"><span style="background:#fff"></span></div>
						<div class="tu"><a href="#" target="_blank" id="linkid28"><img src="img/pandora.jpg"style="width:200px;"></a></div>
						<div class="miaoshu" id="name28">Pandora</div>
						<div class="pingjia" id="subtitle28">潘多拉官网海洋之心ZTO139</div>
						<div class="jiage" id="price28">826元</div>						
					</div>
					
					
					
					<div class="remen fl">
						<div class="xinpin"><span style="background:#fff"></span></div>
						<div class="tu"><a href="#" target="_blank" id="linkid29"><img src="img/天鹅.jpg"style="width:200px;"></a></div>
						<div class="miaoshu" id="name29">施华洛世奇</div>
						<div class="pingjia" id="subtitle29">DAZZLING SWAN 清雅天鹅 时尚迷人</div>
						<div class="jiage" id="price29">999元</div>
					</div>
					
						<div class="remen fl">
						<div class="xinpin"><span style="background:#fff"></span></div>
						<div class="tu"><a href="#" target="_blank" id="linkid30"><img src="img/项链施华洛世奇.jpg"style="width:200px;"></a></div>
						<div class="miaoshu" id="name30">施华洛世奇</div>
						<div class="pingjia" id="subtitle30">MADEMOISELLE 蝴蝶结元素</div>
						<div class="jiage" id="price30">719元</div>		
					</div>
					
					<div class="remen fl">
						<div class="xinpin"><span style="background:#fff"></span></div>
						<div class="tu"><a href="#" target="_blank" id="linkid31"><img src="img/DR戒指.jpg"style="width:200px;"></a></div>
						<div class="miaoshu" id="name31">DR BELIEVE</div>
						<div class="pingjia" id="subtitle31">典雅雪花款正品1克拉钻石</div>
						<div class="jiage" id="price31">5659元</div>	
					</div>
				
					
					
					<div class="clear"></div>
				</div>
				
				<div class="content">
					<div class="remen fl"><a href=""><img src="img/hefangcaihong.jpg"style="width:300px;"></a>
					</div>
					<div class="remen fl">
						<div class="xinpin"><span style="background:#fff"></span></div>
						<div class="tu"><a href="#" target="_blank" id="linkid32"><img src="img/施华洛世奇戒指.jpg"style="width:200px;"></a></div>
						<div class="miaoshu" id="name32">施华洛世奇</div>
						<div class="pingjia" id="subtitle32">DRAGONFLY 18k玫瑰金贝壳</div>
						<div class="jiage" id="price32">7800元</div>	
					</div>
						<div class="remen fl">
						<div class="xinpin"><span style="background:#fff"></span></div>
						<div class="tu"><a href="#" target="_blank" id="linkid33"><img src="img/周大福.jpg"style="width:200px;"></a></div>
						<div class="miaoshu" id="name33">周大福</div>
						<div class="pingjia" id="subtitle33">新款 ING系列复古风几何双环手链</div>
						<div class="jiage" id="price33">1770元</div>	
					</div>
					
					
					
				
					
					<div class="remen fl">
						<div class="xinpin"><span style="background:#fff"></span></div>
						<div class="tu"><a href="#" target="_blank" id="linkid34"><img src="img/HEFANG.jpg"style="width:200px;"></a></div>
						<div class="miaoshu" id="name34">HEFANG 野兽派</div>
						<div class="pingjia" id="subtitle34">星月手链925纯银个性首饰</div>
						<div class="jiage" id="price34">882元</div>	
					</div>
					
					<div class="remen fl">
						<div class="xinpin"><span style="background:#fff"></span></div>
						<div class="tu"><a href="#" target="_blank" id="linkid35"><img src="img/hefang22.jpg"style="width:200px;"></a></div>
						<div class="miaoshu" id="name35">HEFANG何方珠宝</div>
						<div class="pingjia" id="subtitle35">迷你符号手链</div>
						<div class="jiage" id="price35">580元</div>		
					</div>
					
					<div class="clear"></div>
				</div>				
			</div>
		</div>
		
		
		
		
		<!-- 商品的展示js -->
		
		<script>
		$(function(){
			let categoryId38 = "38"
    		//let categoryId3 = "3"
    		let pageNum = '1';
    		let pageSize = '9'
    		let	keyword = ''
    		let orderBy = ''
//  		测试用户名
//  		alert(username)
//  		测试结束
    		$.ajax({
    			type: "post",
    			data: {categoryId:categoryId38,pageNum:pageNum,pageSize:pageSize,keyword:keyword,orderBy:orderBy}, //对应request
    			url: "goods?type=list", //对应url
    			dataType: "json",
    			success: function(res){
    				if(res.status === 0){
    					let list = res.data.list
    					$('#name0').text(list[0].name)
    					$('#subtitle0').text(list[0].subtitle)
    					$('#price0').text(list[0].price+"元")
    					let linkid0 = list[0].id 
    					$("#linkid0").attr('href','xiangqing.jsp?id='+list[0].id)
    					
    					
    					
    					$('#name1').text(list[1].name)
    					$('#subtitle1').text(list[1].subtitle)
    					$('#price1').text(list[1].price+"元")
    					let linkid1 = list[1].id 
    					$("#linkid1").attr('href','xiangqing.jsp?id='+list[1].id)
    					
    					$('#name2').text(list[2].name)
    					$('#subtitle2').text(list[2].subtitle)
    					$('#price2').text(list[2].price+"元")
    					let linkid2 = list[2].id 
    					$("#linkid2").attr('href','xiangqing.jsp?id='+list[2].id)
    					
    					$('#name3').text(list[3].name)
    					$('#subtitle3').text(list[3].subtitle)
    					$('#price3').text(list[3].price+"元")
    					let linkid3 = list[3].id 
    					$("#linkid3").attr('href','xiangqing.jsp?id='+list[3].id)
    					
    					$('#name4').text(list[4].name)
    					$('#subtitle4').text(list[4].subtitle)
    					$('#price4').text(list[4].price+"元")
    					let linkid4 = list[4].id 
    					$("#linkid4").attr('href','xiangqing.jsp?id='+list[4].id)
    					
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
	
	//推荐完成
	
	//手机开始
	$(function(){
		let categoryId2 = "2"
        	let pageNum = '1'
    		let pageSize = '9'
    		let	keyword = ''
    		let orderBy = ''
        	//手机页面开始
        	$.ajax({
            			type: "post",
            			data: {categoryId:categoryId2,pageNum:pageNum,pageSize:pageSize,keyword:keyword,orderBy:orderBy}, //对应request
            			url: "goods?type=list", //对应url
            			dataType: "json",
            			success: function(res){
            				if(res.status === 0){
            					let list = res.data.list
            					//console.log(list)
            					$('#name5').text(list[0].name)
            					$('#subtitle5').text(list[0].subtitle)
            					$('#price5').text(list[0].price+'元')
            					let linkid5 = list[0].id 
    							$("#linkid5").attr('href','xiangqing1.jsp?id='+list[0].id)
            					
            					$('#name6').text(list[1].name)
            					$('#subtitle6').text(list[1].subtitle)
            					$('#price6').text(list[1].price+'元')
            					let linkid6 = list[1].id 
    							$("#linkid6").attr('href','xiangqing2.jsp?id='+list[1].id)
            					
            					$('#name7').text(list[2].name)
            					$('#subtitle7').text(list[2].subtitle)
            					$('#price7').text(list[2].price+'元')
            					let linkid7 = list[2].id 
    							$("#linkid7").attr('href','xiangqing.jsp?id='+list[2].id)
            					
            					$('#name8').text(list[3].name)
            					$('#subtitle8').text(list[3].subtitle)
            					$('#price8').text(list[3].price+'元')
            					let linkid8 = list[3].id 
    							$("#linkid8").attr('href','xiangqing.jsp?id='+list[3].id)
            					
            					$('#name9').text(list[4].name)
            					$('#subtitle9').text(list[4].subtitle)
            					$('#price9').text(list[4].price+'元')
            					let linkid9 = list[4].id 
    							$("#linkid9").attr('href','xiangqing.jsp?id='+list[4].id)
            					
    						
            					$('#name10').text(list[5].name)
            					$('#subtitle10').text(list[5].subtitle)
            					$('#price10').text(list[5].price+'元')
            					let linkid10 = list[5].id 
    							$("#linkid10").attr('href','xiangqing.jsp?id='+list[5].id)
            					
            					
            					$('#name11').text(list[6].name)
            					$('#subtitle11').text(list[6].subtitle)
            					$('#price11').text(list[6].price+'元')
            					let linkid11 = list[6].id 
    							$("#linkid11").attr('href','xiangqing.jsp?id='+list[6].id)
            					
            					$('#name12').text(list[7].name)
            					$('#subtitle12').text(list[7].subtitle)
            					$('#price12').text(list[7].price+'元')
            					let linkid12 = list[7].id 
    							$("#linkid12").attr('href','xiangqing.jsp?id='+list[7].id)
            				
            					
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
	
	//手机结束
	
	//服装开始
	$(function(){
            			let categoryId2 = "1"
                		//let categoryId3 = "3"
                		let pageNum = '1';
                		let pageSize = '9'
                		let	keyword = ''
                		let orderBy = ''
//              		测试用户名
//              		alert(username)
//              		测试结束
                		$.ajax({
                			type: "post",
                			data: {categoryId:categoryId2,pageNum:pageNum,pageSize:pageSize,keyword:keyword,orderBy:orderBy}, //对应request
                			url: "goods?type=list", //对应url
                			dataType: "json",
                			success: function(res){
                				if(res.status === 0){
                					let list = res.data.list
                					console.log(res.data)
                					$('#name13').text(list[0].name)
                					$('#subtitle13').text(list[0].subtitle)
                					$('#price13').text(list[0].price+"元")
                					let linkid13 = list[0].id 
    								$("#linkid13").attr('href','xiangqing3.jsp?id='+list[0].id)
                					
                					$('#name14').text(list[1].name)
                					$('#subtitle14').text(list[1].subtitle)
                					$('#price14').text(list[1].price+"元")
                					let linkid14 = list[1].id 
    								$("#linkid14").attr('href','xiangqing.jsp?id='+list[1].id)
                					
                					$('#name15').text(list[2].name)
                					$('#subtitle15').text(list[2].subtitle)
                					$('#price15').text(list[2].price+"元")
                					let linkid15 = list[2].id 
    								$("#linkid15").attr('href','xiangqing.jsp?id='+list[2].id)
                					
                					$('#name16').text(list[3].name)
                					$('#subtitle16').text(list[3].subtitle)
                					$('#price16').text(list[3].price+"元")
                					let linkid16 = list[3].id 
    								$("#linkid16").attr('href','xiangqing.jsp?id='+list[3].id)
                					
                					$('#name17').text(list[4].name)
                					$('#subtitle17').text(list[4].subtitle)
                					$('#price17').text(list[4].price+"元")
                					let linkid17 = list[4].id 
    								$("#linkid17").attr('href','xiangqing4.jsp?id='+list[4].id)
                					
                					$('#name18').text(list[5].name)
                					$('#subtitle18').text(list[5].subtitle)
                					$('#price18').text(list[5].price+"元")
                					let linkid18 = list[5].id 
    								$("#linkid18").attr('href','xiangqing.jsp?id='+list[5].id)
                					
                					$('#name19').text(list[6].name)
                					$('#subtitle19').text(list[6].subtitle)
                					$('#price19').text(list[6].price+"元")
                					let linkid19 = list[6].id 
    								$("#linkid19").attr('href','xiangqing.jsp?id='+list[6].id)
                					
                					$('#name20').text(list[7].name)
                					$('#subtitle20').text(list[7].subtitle)
                					$('#price20').text(list[7].price+"元")
                					let linkid20 = list[7].id 
    								$("#linkid20").attr('href','xiangqing.jsp?id='+list[7].id)
		
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
            	
	
	
	//服装结束
	

	
    			
        
	
    			
         <!--家电-->
            	$(function(){
            			let categoryId2 = "45"
                		//let categoryId3 = "3"
                		let pageNum = '1';
                		let pageSize = '9'
                		let	keyword = ''
                		let orderBy = ''
//              		测试用户名
//              		alert(username)
//              		测试结束
                		$.ajax({
                			type: "post",
                			data: {categoryId:categoryId2,pageNum:pageNum,pageSize:pageSize,keyword:keyword,orderBy:orderBy}, //对应request
                			url: "goods?type=list", //对应url
                			dataType: "json",
                			success: function(res){
                				if(res.status === 0){
                					console.log(res.data)
                					let list = res.data.list
                					$('#name21').text(list[0].name)
                					$('#subtitle21').text(list[0].subtitle)
                					$('#price21').text(list[0].price+"元")
                					let linkid21 = list[0].id 
    								//console.log(linkid21)
    								$("#linkid21").attr('href','xiangqing5.jsp?id='+list[0].id)
                					
                					$('#name22').text(list[1].name)
                					$('#subtitle22').text(list[1].subtitle)
                					$('#price22').text(list[1].price+"元")
                					let linkid22 = list[1].id 
    								//console.log(linkid22)
    								$("#linkid22").attr('href','xiangqing.jsp?id='+list[1].id)
                					
                					$('#name36').text(list[2].name)
                					$('#subtitle36').text(list[2].subtitle)
                					$('#price36').text(list[2].price+"元")
                					let linkid36 = list[2].id 
    								$("#linkid36").attr('href','xiangqing.jsp?id='+list[2].id)
                					
                					
                					$('#name27').text(list[3].name)
                					$('#subtitle27').text(list[3].subtitle)
                					$('#price27').text(list[3].price+"元")
                					let linkid27 = list[3].id 
    								$("#linkid27").attr('href','xiangqing.jsp?id='+list[3].id)
                					
                					$('#name24').text(list[4].name)
                					$('#subtitle24').text(list[4].subtitle)
                					$('#price24').text(list[4].price+"元")
                					let linkid24 = list[4].id 
    								$("#linkid24").attr('href','xiangqing.jsp?id='+list[4].id)
                					
                					$('#name25').text(list[5].name)
                					$('#subtitle25').text(list[5].subtitle)
                					$('#price25').text(list[5].price+"元")
                					let linkid25 = list[5].id 
    								$("#linkid25").attr('href','xiangqing6.jsp?id='+list[5].id)
                					
                					$('#name23').text(list[6].name)
                					$('#subtitle23').text(list[6].subtitle)
                					$('#price23').text(list[6].price+"元")
                					let linkid23 = list[6].id 
    								$("#linkid23").attr('href','xiangqing.jsp?id='+list[6].id)
                					
                					$('#name26').text(list[7].name)
                					$('#subtitle26').text(list[7].subtitle)
                					$('#price26').text(list[7].price+"元")
                					let linkid26 = list[7].id 
    								$("#linkid26").attr('href','xiangqing.jsp?id='+list[7].id)
                			
                					
                					
                					
                					
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
            	
            	
            	
            	
            	  <!--首饰-->
            	$(function(){
            			let categoryId2 = "35"
                		let pageNum = '1';
                		let pageSize = '9'
                		let	keyword = ''
                		let orderBy = ''
//              		测试用户名
//              		alert(username)
//              		测试结束
                		$.ajax({
                			type: "post",
                			data: {categoryId:categoryId2,pageNum:pageNum,pageSize:pageSize,keyword:keyword,orderBy:orderBy}, //对应request
                			url: "goods?type=list", //对应url
                			dataType: "json",
                			success: function(res){
                				if(res.status === 0){
                					console.log(res.data)
                					let list = res.data.list
                					$('#name28').text(list[0].name)
                					$('#subtitle28').text(list[0].subtitle)
                					$('#price28').text(list[0].price+"元")
                					let linkid28 = list[0].id 
    								$("#linkid28").attr('href','xiangqing7.jsp?id='+list[0].id)
                					
                					$('#name29').text(list[1].name)
                					$('#subtitle29').text(list[1].subtitle)
                					$('#price29').text(list[1].price+"元")
                					let linkid29 = list[1].id 
    								$("#linkid29").attr('href','xiangqing.jsp?id='+list[1].id)
                					
                					$('#name30').text(list[2].name)
                					$('#subtitle30').text(list[2].subtitle)
                					$('#price30').text(list[2].price+"元")
                					let linkid30 = list[2].id 
    								$("#linkid30").attr('href','xiangqing.jsp?id='+list[2].id)
                					
                					$('#name31').text(list[3].name)
                					$('#subtitle31').text(list[3].subtitle)
                					$('#price31').text(list[3].price+"元")
                					let linkid31 = list[3].id 
    								$("#linkid31").attr('href','xiangqing.jsp?id='+list[3].id)
                					
                					$('#name32').text(list[4].name)
                					$('#subtitle32').text(list[4].subtitle)
                					$('#price32').text(list[4].price+"元")
                					let linkid32 = list[4].id 
    								$("#linkid32").attr('href','xiangqing8.jsp?id='+list[4].id)
                					
                					$('#name33').text(list[5].name)
                					$('#subtitle33').text(list[5].subtitle)
                					$('#price33').text(list[5].price+"元")
                					let linkid33 = list[5].id 
    								$("#linkid33").attr('href','xiangqing.jsp?id='+list[5].id)
                					
                					$('#name34').text(list[6].name)
                					$('#subtitle34').text(list[6].subtitle)
                					$('#price34').text(list[6].price+"元")
                					let linkid34 = list[6].id 
    								$("#linkid34").attr('href','xiangqing.jsp?id='+list[6].id)
                					
                					$('#name35').text(list[7].name)
                					$('#subtitle35').text(list[7].subtitle)
                					$('#price35').text(list[7].price+"元")
                					let linkid35 = list[7].id 
    								$("#linkid35").attr('href','xiangqing.jsp?id='+list[7].id)
                			
                					
                					
                					
                					
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
		
		
		
		
		
		
		
		
		<!-- 商品的展示结束 -->
		
		
	
		
		<!--底部模块制作开始-->
		<footer class="footer" >
			<div class="w">
				<div class="mod_service">
					<ul>
						<li>
							<h5><img src="img/wei1.png"/></h5>
							<div class="service_txt">
								<h4>正品保障</h4>
								<p>正品保障，提供发票</p>
							</div>
						
						</li>
						<li>
							<h5><img src="img/d3.png"/></h5>
							<div class="service_txt">
								<h4>7天无理由退款</h4>
								<p>您的满意是我们最大的幸福</p>
							</div>
						
						</li>
						<li>
							<h5><img src="img/d2.png" alt="" /></h5>
							<div class="service_txt">
								<h4>15天免费换货</h4>
								<p>如果质量有问题，我们提供无偿换货服务</p>
							</div>
						
						</li>
						<li>
							<h5><img src="img/d4.png" alt="" /></h5>
							<div class="service_txt">
								<h4>500多家售后</h4>
								<p>选择小米，售后诚信为您服务</p>
							</div>
						
						</li>
					</ul>
				</div>
				
				<div class="mod_helper" id="fuwumaodian">
					<dl>
						<dt>帮助中心</dt>
						<dd><a href="https://www.mi.com/static/familyLocation" target="_blank" >授权体验店</a></dd>
						<dd><a href="#">购物指南</a></dd>
						<dd><a href="#">订单操作</a></dd>
						
					</dl>
					<dl>
						<dt>服务支持</dt>
						<dd><a href="https://www.mi.com/service/exchange" target="_blank">售后政策</a></dd>
						<dd><a href="#">自助服务</a></dd>
						<dd><a href="#">相关下载</a></dd>
						
					</dl>
					<dl>
						<dt>线下门店</dt>
						<dd><a href="https://www.mi.com/c/xiaomizhijia" target="_blank">小米之家</a></dd>
						<dd><a href="#">服务网站</a></dd>
						<dd><a href="#">账户管理</a></dd>
					
					</dl>
					<dl>
						<dt>关于小米</dt>
						<dd><a href="https://www.mi.com/about" target="_blank">了解小米</a></dd>
						<dd><a href="#">加入小米</a></dd>
						<dd><a href="#">投资者关系</a></dd>
						<dd><a href="#">企业社会责任</a></dd>
						<dd><a href="#">廉洁举报</a></dd>
						
					</dl>
					<dl>
						<dt>特色服务</dt>
						<dd><a href="https://weibo.com/xiaomishangcheng?is_all=1" target="_blank">新浪微博</a></dd>
						<dd><a href="#">礼物码</a></dd>
						<dd><a href="#">防伪查询</a></dd>
						<dd><a href="#">联系我们</a></dd>
						<dd><a href="#">公益基本会</a></dd>
						<dd><a href="#">官方微信</a></dd>
					</dl>
					<dl >
						<dt>400-100-5678</dt>
						<dd>8:00-18:00（仅收市话费）</dd>
						<dd class="rengong"><a href="https://support.kefu.mi.com/page/index/v2?tag=cn&token=Y24ud2ViLm1pLmh0dHBzLm1vYmlsZSNyZWZlcmVy">人工客服</a></dd>
						<dd>关注小米：<span></span> <span></span></dd>
					</dl>
				</div>
			
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
			</div>
		</footer>
		<!--底部模块制作完成-->
		
	</body>
</html>
