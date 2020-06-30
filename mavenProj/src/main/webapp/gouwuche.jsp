<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>我的购物车-小米商城</title>
		<link rel="shortcut icon" href="favicon.ico" />
		<script type="text/javascript" src="js/jquery-3.5.1.min.js" ></script>
		
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
				
				
				<!-- 添加购物车开始 -->
			  <div class="firstadd"> 
				
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
				<!-- 添加购物车结束 -->
				
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

  
   	<!-- 购物车列表 -->
	
	<script type="text/javascript">
			$(function(){
				
//      		测试结束
        		$.ajax({
        			type: "post",
        			data: {}, //对应request
        			url: "cart?type=list", //对应url
        			dataType: "json",
        			success: function(res){
        				if(res.status === 0){
        					
        					let cartProductVoList = res.data.cartProductVoList
        					console.log(cartProductVoList)
        					
        					//购物车列表
		        			let arrays = new Array()
        					let array1 = new Array()
        					let array2 = new Array()
        					let array3 = new Array()
        					
        					
        					for(let i=0 ; i<cartProductVoList.length; i++ )
        					{
        						let id = 'linkid' + i;
        					    arrays[i] = $('<div class="content2 center"> </div>')
        						$('.firstadd').append(arrays[i])
        						arrays[i].attr('id',id)
        						
        						//succeed
        						let sub_content = $('<div class="sub_content fl"><input type="checkbox" value="quanxuan" class="quanxuan" /></div>')
        						$('#'+ id).append(sub_content)
        						
        						//第二个
        						let imgs = $('<div class="sub_content fl"><img  class="daxiao" src="img/dianshi1.jpg"></div>')
        						$('#'+ id).append(imgs)
        						//第三个
        						array1[i] = $('<div class="sub_content fl ft20">小米电视 亮黑色</div>')
        						$('#'+ id).append(array1[i])
        						let nameid = 'nameid'+ i 
        						array1[i].attr('id',nameid)
        						//console.log(cartProductVoList[i].productName)
        						$('#'+ nameid ).text(cartProductVoList[i].productName)
        						
        						
        						//价格
        						array2[i] = $('<div class="sub_content fl ">5499元</div>')
        						$('#'+ id).append(array2[i])
        						let priceid = 'priceid'+ i 
        						array2[i].attr('id',priceid)
        						//console.log(cartProductVoList[i].productPrice)
        						$('#'+ priceid ).text(cartProductVoList[i].productPrice)
        						
        						//数量
        						let contentnums = $('<div class="sub_content fl"><input class="shuliang" type="number" value="1" step="1" min="1" ></div>')
        						$('#'+ id).append(contentnums)
        						
        						//价格2
        						array3[i] = $('<div class="sub_content fl ">5499元</div>')
        						$('#'+ id).append(array3[i])
        						let priceid2 = 'priceidtest'+ i 
        						array3[i].attr('id',priceid2)
        						console.log(cartProductVoList[i].productPrice)
        						$('#'+ priceid2 ).text(cartProductVoList[i].productPrice)
        						
        						let chaolianjie = $('<div class="sub_content fl"><a href="">×</a></div>')
        						$('#'+ id).append(chaolianjie)
        						
        						let clear = $('<div class="clear"></div>')
        						$('#'+ id).append(clear)
                	
                					
        					}
        					
		
        					
        					//购物车列表
        					
        					
        					
        				}
        				else{
        					console.log(res.msg)
        				}
        			},
        			error: function(err){
        				console.log("err")
        			}
        		})
				
        		
        		$(document).keydown(function(event){
            		if(event.which == 13)
            			$('#logins').triggerHandler("click");
            	})
            	
			})
	</script>
	
	
	<!-- 购物车列表结束 -->
	


	</body>
</html>
