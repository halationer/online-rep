<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>小米商城-综合网购首选-电子产品来找我们呀</title>
		<!--说明-->
		<meta name="description" content="小米-专业的综合网上购物商城,销售家电、数码通讯、电脑、家居百货等多个品牌优质商品.便捷、诚信的服务，为您提供愉悦的网上购物体验!">
		<!--关键字-->
		<meta name="Keywords" content="网上购物,网上商城,手机,笔记本,电脑,家具产品,小米">
		
		<link rel="stylesheet" href="css/base.css" />
		<link rel="stylesheet" href="css/common.css" />
		
		<link rel="stylesheet" href="demo/iconfont.css" />
		
		<link rel="stylesheet" type="text/css" href="css/index.css"/>
		
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
	 	<!--<div class="nav w">
	 		<h1>欢迎来到小米商城</h1>	
	 		
	 		<ul class="btm">
	 			<li><a href="#">登录</a></li>
	 			<li><a href="#">注册</a></li>
	 			<li><a href="#">个人中心</a></li>
	 			<li><a href="#">购物车</a></li>
	 			<li><a href="#">小米手机</a></li>
	 			<li><a href="#">Redmi红米</a></li>
	 			<li><a href="#">电视</a></li>
	 			<li><a href="#">笔记本</a></li>
	 			<li><a href="#">家电</a></li>
	 			<li><a href="#">路由器</a></li>
	 			<li><a href="#">智能硬件</a></li>
	 			<li><a href="#">社区</a></li>
	 		
	 		</ul>
	 	</div>
		-->
		<!--快捷导航模块-->
		<section class="shortcut">

			<div class="w">
				<div class="fl">
					<ul>
						<li>小米欢迎您! &nbsp;</li>
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
						<li class="arrow-icon">我的小米购</li>
						<li></li>
						<li>小米会员</li>
						<li></li>
						<li>企业采购</li>
						<li></li>
						<li class="iconfont">关注小米 &#xe797</li>
						<li></li>
						<li class="iconfont" ><a id="person" href="#">个人中心&#xe797</a></li>
						<li></li>
						<li >
							<select>
								<option class="iconfont" >网站导航 &#xe797</option>
								<option class="iconfont" ><a href="self_info.jsp">购物车</a> &#xe797</option>
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
					<a href="index.jsp" title="小米商城">小米商城</a>
				</h1>
			</div>
			
			<!--search搜索模块-->
			<div class="search">
				<input type="search" name="" id="" placeholder="小米欢迎您" />
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
				<span>&#xe661;</span>我的购物车  <span class="count">8</span> <span>&gt;</span>
			</div>
		</header>
		<!--nav模块-->
		<div class="nav w">
			<div class="dropdowm">
				<div class="dt">全部商品分类</div>
				<div class="dd">
					<ul>
						<li><a href="#">手机</a> <span>&gt;</span></li>
						<li><a href="#">电话卡、</a> <a href="#">电视、</a> <a href="#">盒子</a><span>&gt;</span></li>
						<li><a href="#">笔记本</a><span>&gt;</span></li>
						<li><a href="#">显示器</a><span>&gt;</span></li>
						<li><a href="#">平板</a><span>&gt;</span></li>
						<li><a href="#">家电</a><span>&gt;</span></li>
						<li><a href="#">出行</a><span>&gt;</span></li>
						<li><a href="#">智能</a><span>&gt;</span></li>
						<li><a href="#">路由器</a><span>&gt;</span></li>
						<li><a href="#">电源</a><span>&gt;</span></li>
						<li><a href="#">配件</a><span>&gt;</span></li>
						<li><a href="#">耳机</a><span>&gt;</span></li>
						<li><a href="#">音箱</a><span>&gt;</span></li>
						<li><a href="#">儿童</a><span>&gt;</span></li>
						<li><a href="#">箱包</a><span>&gt;</span></li>
					</ul>
				</div>
			</div>
			<div class="navitems">
				<ul>
					<li><a href="#">小米手机</a></li>
					<li><a href="#">红米手机</a></li>
					<li><a href="#">电视</a></li>
					<li><a href="#">笔记本</a></li>
					<li><a href="#">家电</a></li>
					<li><a href="#">路由器</a></li>
					<li><a href="#">服务</a></li>
					<li><a href="#">社区</a></li>
					
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
			$(()=>{
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
		<div class="recom w">
			<h3>精品推荐</h3>
			
		<ul>
			<li><a href="#">
				<div class="box">
				<div class="box-hd">
					<!--<h3>精品推荐</h3>-->
					<img src="img/p1.jpg" alt="" />
				</div>
				<div class="box-bd">
					<div class="contents">
						小米10 青春版 45G
					</div>
					<div class="middles">
						50倍潜望望式变焦 / 轻薄5G手机
					</div>
					<div class="price">
						4999元起
					</div>
				</div>
			</div>
			</a></li>
			<li><a href="#">
				<div class="box">
				<div class="box-hd">
					
					<img src="img/dianshi1.jpg" alt="" />
				</div>
				<div class="box-bd">
					<div class="contents">
						 小米电视 聚优惠
					</div>
					<div class="middles">
						高清大屏 / 方便省心
					</div>
					<div class="price">
						5999元起
					</div>
				</div>
			</div>
			</a></li>
			<li><a href="#">
				<div class="box">
				<div class="box-hd">
					
					<img src="img/jiadian4.jpg" alt="" />
				</div>
				<div class="box-bd">
					<div class="contents">
						小米洗衣机
					</div>
					<div class="middles">
						省心 / 快捷
					</div>
					<div class="price">
						1000元起
					</div>
				</div>
			</div>
			</a></li>
			<li><a href="#">
				<div class="box">
				<div class="box-hd">
					<!--<h3>精品推荐</h3>-->
					<img src="img/c1.jpg" alt="" />
				</div>
				<div class="box-bd">
					<div class="contents">
						小米笔记本
					</div>
					<div class="middles">
						高清屏幕 / 急速开机
					</div>
					<div class="price">
						7999元起
					</div>
				</div>
			</div>
			</a></li>
			<li><a href="#">
				<div class="box">
				<div class="box-hd">
					<!--<h3>精品推荐</h3>-->
					<img src="img/shouji4.jpg" alt="" />
				</div>
				<div class="box-bd">
					<div class="contents">
						小米9 青春版 4G
					</div>
					<div class="middles">
						50倍潜望望式变焦 / 轻薄5G手机
					</div>
					<div class="price">
						3299元起
					</div>
				</div>
			</div>
			</a></li>
		</ul>
		
		</div>
		
		
			
		
		<!--推荐模块结束-->
		
		
		<!--底部模块制作开始-->
		<footer class="footer">
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
				
				<div class="mod_helper">
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
