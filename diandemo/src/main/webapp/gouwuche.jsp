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
						<li><a href="index.jsp" target="_blank">继续购物</a></li>
						<li>|</li>
						<li>共<span id="data_totalnum">2</span>件商品，已选择<span id="nowxuanzhong">0</span>件</li>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="jiesuan fr">
					<div class="jiesuanjiage fl">合计（不含运费）：<span id="data_totalprice">0.00元</span></div>
					<div class="jsanniu fr"><input class="jsan" type="submit" name="jiesuan"  value="去下单" id="jiesuan"/></div>
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
			</div>
			
			
		</div>

  
   	<!-- 购物车列表 -->
	
	<script type="text/javascript">
			$(function(){
				
				let totalprices = 0	//商品总价格
				let xuanzhongnum = 0 //商品选中数
				
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
		        			let arrays = new Array() //content的id
        					let array1 = new Array() //name
        					let array2 = new Array()  //jiage
        					let array3 = new Array()  //价格
        					let array4 = new Array()  //删除事件 的数组
        					let array5 = new Array()  // 多选框的父亲
        					let array6 = new Array()  //多选框
        					
        					
        					for(let i=0 ; i<cartProductVoList.length; i++ )
        					{
        						let id = 'linkid' + i;
        					    arrays[i] = $('<div class="content2 center"> </div>')
        						$('.firstadd').append(arrays[i])
        						arrays[i].attr('id',id)
        						
        						//succeed
        						array5[i] = $('<div class="sub_content fl"></div>')
        						$('#'+ id).append(array5[i])
        						let data_fu_duoxuan = 'data_fu_duoxuan' + i
        						array5[i].attr('id',data_fu_duoxuan)
        						array6[i] = $('<input type="checkbox" value="quanxuan" class="quanxuan" />')
        						$('#'+data_fu_duoxuan).append(array6[i])
        						let data_zi_duoxuan = 'duoxuan'+i
        						array6[i].attr('id',data_zi_duoxuan)
        						$('#'+data_zi_duoxuan).click(function(){
        							//console.log('test')
        							if($('#'+data_zi_duoxuan).prop('checked') === true)
        							{
        								xuanzhongnum = xuanzhongnum + 1
        								totalprices = totalprices + cartProductVoList[i].productPrice
        								
        							}
        							else
        							{
        								xuanzhongnum = xuanzhongnum - 1
        								totalprices = totalprices - cartProductVoList[i].productPrice
        								
        							
        							
        							}
        							//console.log(xuanzhongnum)
                					$('#nowxuanzhong').text(xuanzhongnum)
                					
                					$('#data_totalprice').text(totalprices)
                					
                					
        							
        						})
        						
        						
        						
        						//第二个
        						let imgs = $('<div class="sub_content fl"><img  class="daxiao" src="img/dianshi1.jpg"></div>')
        						$('#'+ id).append(imgs)
        						//第三个
        						array1[i] = $('<div class="sub_content fl ft20">小米电视 亮黑色</div>')
        						$('#'+ id).append(array1[i])
        						let nameid = 'nameid'+ i 
        						array1[i].attr('id',nameid)
        						//console.log(cartProductVoList[i].productName)
        						$('#'+ nameid ).text(cartProductVoList[i].productName) //输出name
        						
        						
        						
        						//价格
        						array2[i] = $('<div class="sub_content fl ">5499元</div>')
        						$('#'+ id).append(array2[i])
        						let priceid = 'priceid'+ i 
        						array2[i].attr('id',priceid)
        						//console.log(cartProductVoList[i].productPrice)
        						$('#'+ priceid ).text(cartProductVoList[i].productPrice)
        						//totalprices = totalprices + cartProductVoList[i].productPrice
        						
        						//数量
        						let contentnums = $('<div class="sub_content fl"><input class="shuliang" type="number" value="1" step="1" min="1" ></div>')
        						$('#'+ id).append(contentnums)
        						
        						//价格2
        						array3[i] = $('<div class="sub_content fl ">5499元</div>')
        						$('#'+ id).append(array3[i])
        						let priceid2 = 'priceidtest'+ i 
        						array3[i].attr('id',priceid2)
        						//console.log(cartProductVoList[i].productPrice)
        						$('#'+ priceid2 ).text(cartProductVoList[i].productPrice)
        						
        						array4[i] = $('<div class="sub_content fl"><a href="#">×</a></div>')
        						$('#'+ id).append(array4[i])
        						let shanchu = 'shanchu' + i
        						array4[i].attr('id',shanchu)
        						//console.log(cartProductVoList[i].id + '----' + shanchu)
        						$('#'+shanchu+'>a').click(function(){

        							console.log(cartProductVoList[i].id + '----' + shanchu)

//        			          		测试用户名
//        			          		alert(username)
//        			          		测试结束
        			            		$.ajax({
        			            			type: "post",
        			            			data: {Id:cartProductVoList[i].id}, //对应request
        			            			url: "cart?type=delete_product", //对应url
        			            			dataType: "json",
        			            			success: function(res){
        			            				if(res.status === 0){
        			            					console.log(res.data)
        			            					let gouwu = JSON.stringify(res.data) //要传的参数
        			            					
        			            					//$(location).attr('href', encodeURI('index.jsp?admin='+admin)) //跳转地址
        			            					location.href="gouwuche.jsp";
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
        						

        						
        						let clear = $('<div class="clear"></div>')
        						$('#'+ id).append(clear)
                	
                					
        					}
        					
					
        					
        					//购物车列表
        					
        					//$('#data_totalprice').text(totalprices)
        					$('#data_totalnum').text(cartProductVoList.length+1)
        					
        					
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
	
   <!-- 去下单-->

		<script type="text/javascript">
		
		$('#jiesuan').click(function(){
    		
			let shippingId = 1
			//console.log($('#data_totalprice').text())
			
            		$.ajax({
            			type: "post",
            			data: {shippingId:shippingId}, //对应request
            			url: "OrderTableServlet?type=create", //对应url
            			dataType: "json",
            			success: function(res){
            				if(res.status === 0){
            					
            					//orderNo: 9114432
            					//payment: 6394
            					let data_all = res.data
            					//console.log(res.data)
            					let orderNo = data_all.orderNo
            					let payment = data_all.payment
            					
            					console.log(orderNo)
            					console.log(payment)
            					
            					//let data_element = JSON.stringify(orderNo) //要传的参数
            					
            					$(location).attr('href', encodeURI('daifukuandingdan.jsp?orderNo='+orderNo+'&payment='+payment)) //跳转地址
            					//location.href="daifukuandingdan.jsp?data_order="+data_element;
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


	<!-- 结算结束 -->
	</body>
</html>
