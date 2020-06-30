<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link rel="stylesheet" href="../layui/css/layui.css">
        <title>订单管理——电商平台后台管理系统</title>
        <script src="../js/jquery.js"></script>
  		<style>
        	.layui-layout-admin .layui-body{
        		top: 0;
        	}
            .layui-layout-admin .layui-logo{
                background-color: #9f1212;
                color: #fff;
            }
            #tap{
                background-color: #00000080;
                color: #fff;
                position: fixed;
                top: 50%;
                left: 200px;
                width: 25px;
                height: 50px;
                border-radius: 0 15px 15px 0;
                display: flex;
            }
            #tap>i{
                font-weight: bold;
            	display: block;
            	margin: auto;
            	margin-right: 7px;
            }
            #tap,.layui-side,.layui-logo,.layui-footer,.layui-body{
            	transition: 0.5s;
            }
            .layui-form-label{
            	padding-left: 0;
            	width: 70px;
            }
            .layui-input-block{
            	margin-left: 85px;
            }
            #wrap{
            	padding: 15px;
            	position:relative;
            }
            #wrap>.left-page,#wrap>.right-page{
            	position: relative;
            	left: 0;
				transition: 0.5s;
            }
            #wrap>.right-page{
            	left: calc(100% + 15px);
            	top: 0;
            }*/
        </style>
    </head>
    <body class='layui-layout-body'>
        <div class="layui-layout layui-layout-admin">
            <div class='layui-logo layui-row'>
                <div class='layui-col-md3 layui-col-md-offset1' id='adminname'>未登录</div>
                <div class='layui-col-md2' id='exit'>
                    <i class='layui-icon layui-icon-next' style='font-size: 18px;'></i>
                </div>
            </div>
            <div class='layui-side layui-bg-cyan'>
                <div id='tap'><i class='layui-icon layui-icon-left'></i></div>
                <div class='layui-side-scroll'>
                    <ul class='layui-nav layui-nav-tree layui-bg-cyan' lay-shrink='all'>
                        <li class='layui-nav-item'>
                            <a href='layui-backuser.jsp'>
                            	<i class='layui-icon layui-icon-friends' style='font-size: 18px;'></i>
                            	<span>&nbsp;&nbsp;&nbsp;用户信息</span>
                            </a>
                        </li>
                        <li class='layui-nav-item'>
                            <a href='layui-backcategory.jsp'>
                            	<i class='layui-icon layui-icon-share' style='font-size: 18px;'></i>
                            	<span>&nbsp;&nbsp;&nbsp;商品类别</span>
                            </a>
                        </li>
                        <li class='layui-nav-item'>
                            <a href='layui-backgoods.jsp'>
                            	<i class='layui-icon layui-icon-app' style='font-size: 18px;'></i>
                            	<span>&nbsp;&nbsp;&nbsp;商品信息</span>
                            </a>
                        </li>
                        <li class='layui-nav-item layui-this'>
                            <a href='layui-backorder.jsp'>
                            	<i class='layui-icon layui-icon-form' style='font-size: 18px;'></i>
                            	<span>&nbsp;&nbsp;&nbsp;订单管理</span>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>

            <div class='layui-body'>
                <div id='wrap'>
                	<div class='left-page'>
						<table id="ordertable" lay-filter="ordertable"></table>
					</div>
					<div class='right-page'>
						<table id="detailtable" lay-filter="detailtable"></table>
						<table class="layui-table" id="detail-table">
							  <colgroup>
								    <col width="150">
								    <col>
								    <col width="150">
								    <col>
							  </colgroup>
							  <thead>
								    <tr>
									    <th>订单号</th>
									    <td colspan="3" id="detail-orderno">null</td>
								    </tr> 
							  </thead>
							  <tbody>
								    <tr>
										<th>用户ID</td>
										<td id="detail-userid">null</td>
										<th>用户名</th>
										<td id="detail-username">null</td>
								    </tr>
								    <tr>
										<th>收货人</td>
										<td id="detail-receivename">null</td>
										<th>邮编</th>
										<td id="detail-receivezip">null</td>
								    </tr>
								    <tr>
									    <th>收货地址</th>
									    <td colspan="3" id="detail-receiveadd">null</td>
								    </tr>
								    <tr>
									    <th>详细地址</th>
									    <td colspan="3" id="detail-receiveaddress">null</td>
								    </tr>
								    <tr>
									    <th>合计</th>
									    <td colspan="3" id="detail-totalprice">null</td>
								    </tr>
							  </tbody>
						</table>
					</div>
                </div>
            </div>

            <div class='layui-footer'>
                @电商平台后台管理系统
            </div>
        </div>

        <script src="../layui/layui.all.js"></script>
        <script type="text/html" id="tableBtn">
            <a class="layui-btn layui-btn-xs" lay-event="detail">详细</a>
			{{# if(d.status === 2){ }}
            	<a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="send">发货</a>
			{{# }else{ }}
            	<a class="layui-btn layui-btn-disabled layui-btn-xs" >发货</a>
			{{# } }}
        </script>
        <script type="text/html" id="searchbar">
           	<input style="height:30px;width:157px;" placeholder="请输入订单号" id="search-key">
           	<a href="javascript:void(0)" lay-event="search" style="position:absolute;left:144px;top:10px;">
           		<i class="layui-icon layui-icon-search" style="background:#fff;padding:5px;"></i>
           	</a>
		</script>
		<script type="text/html" id="backbar">
			<button class="layui-btn layui-btn-primary" lay-event="back" style="position:absolute;top:5px;display:flex;padding:0 5px;">
				<i class="layui-icon layui-icon-left" style="font-size:15px"></i><span>返回订单</span>
			</a>
		</script>
		<script type="text/html" id="main-status-show">
			{{# switch(d.status){
			case 0: }}
				<span class="layui-badge-dot layui-bg-gray"></span>
			{{# break;
			case 1: }}
				<span class="layui-badge-dot layui-bg-red"></span>
			{{# break;
			case 2: }}
				<span class="layui-badge-dot layui-bg-orange"></span>
			{{# break;
			case 3: }}
				<span class="layui-badge-dot layui-bg-blue"></span>
			{{# break;
			case 4: }}
				<span class="layui-badge-dot layui-bg-green"></span>
			{{# break;
			case 5: }}
				<span class="layui-badge-dot layui-bg-green"></span>
			{{# break;
			default: }}
				<span class="layui-badge-dot layui-bg-black"></span>
			{{# break;
			} }}
			&nbsp;{{d.statusDesc}}
		</script>
		<script type="text/html" id="main-image-show">
			<div style="background:url({{d.productImage}}) no-repeat;background-size:auto 100%;background-position:50%;height:100%;"></div>
		</script>

	    <script>
	    
            if( ${!empty admin} )
                admin = jQuery.parseJSON('${admin}')
            else
                $(location).attr('href', '../layindex.jsp')

            $(function(){
				
                const fixtop = $('#wrap>.left-page').height()
				$('#wrap>.right-page').css({'top':-fixtop, 'opacity':0})	
            	
                //接收参数
                $('#adminname').text(admin['username']).attr('class','layui-col-md6 layui-col-xs6')
                $('.layui-layout-admin .layui-logo').css({'background': '#08492e'})
                $('#exit>i').attr('class', 'layui-icon layui-icon-logout')
                .css({ 'font-weight':'bold', 'color':'#fff'})
                $('#exit').attr('class', 'layui-col-md4 layui-col-md-offset2 layui-col-xs4 layui-col-xs-offset2')
                .css({'background-color':'#FF5722'})
                .hover(function(){$(this).css({'cursor':'pointer'})})
                .click(function(){
                	$.ajax({
            			type: "post",
            			url: "../manage/user?type=exit",
            			dataType: "json",
            			success: function(res){
                            console.log(res.msg)
							var url = "../layindex.jsp"
							window.location.href = url
            			},
            			error: function(err){
            				console.log("server err")
            			}
            		})
            	})
            	let isShow = ${empty param.isshow}
                if(isShow) isShow=true
                else isShow=${true==param.isshow}
                if(!isShow){
                	hideitems()
                	$('.layui-nav-item span').each(function(){
                		$(this).hide()
                    })
                }
            	$('#tap').click(function(){
            		
            		$('.layui-nav-item span').each(function(){
                        if($(this).is(':hidden')) $(this).show()
                        else $(this).hide()
                    })
                    
                    if(isShow){
                    	hideitems()
                        isShow =false
                    }else{
                    	showitems()
                        isShow =true
                    }
            	})
            })
            function hideitems(){
            	$('#tap').css({'left':'60px'})
            	$('#tap>i').attr('class', 'layui-icon layui-icon-right')
                $('.layui-side').width(60)
                $('.layui-logo').width(60)
                $('.layui-body').css('left', 60+'px')
                $('.layui-footer').css('left', 60+'px')
                $('#adminname').hide()
                $('#exit').attr('class', 'layui-col-md12 layui-col-xs12')
                $('dd span').each(function(){
                    $(this).hide()
                })
            }
            function showitems(){
            	$('#tap').css({'left':'200px'})
            	$('#tap>i').attr('class', 'layui-icon layui-icon-left')
                $('.layui-side').width(200)
                $('.layui-logo').width(200)
                $('.layui-body').css('left', 200+'px')
                $('.layui-footer').css('left', 200+'px')
                $('#adminname').show()
                $('#exit').attr('class', 'layui-col-md4 layui-col-md-offset2 layui-col-xs4 layui-col-xs-offset2')
                $('dd span').each(function(){
                    $(this).show()
                })
            }

            function fixed(str){
            	if (str !== '' && str != null){
	            	if(str === 0){  //当为0时，不用处理
	            		return 0 ;
	            	}else {
	            		return "￥" + str.toFixed(2).replace(/(\d)(?=(\d{3})+\.)/g, '$1,');
	            	}
            	} else {
            		return '';
            	}
           	}
        </script>
        <div id="add-form" style="display:none">
		   	<form class="layui-form" lay-filter="save-form">
		  		<div class="layui-form-item">
		   		    <label class="layui-form-label">商品名称 <span style="color:red">*</span></label>
		   		    <div class="layui-input-block">
		   		    	<input type="text" name="name" required lay-verify="required" placeholder="输入商品名" autocomplete="off" class="layui-input">
		   		    </div>
		    	</div>
			    <div class="layui-form-item">
		   		    <label class="layui-form-label">商品类别 <span style="color:red">*</span></label>
		   		    <div class="layui-input-block">
		   		    	<select name="categoryId" required lay-verify="required">
			    		    <option value="">请选择</option>
			    		    <option value="1">服装</option>
			    		    <option value="2">电子</option>
			    		    <option value="3">家电</option>
			    		</select>
		  		    	</div>
		    	</div>
			    <div class="layui-form-item">
		   		    <label class="layui-form-label">副标题&nbsp;&nbsp;</label>
		   		    <div class="layui-input-block">
		    			<input type="text" name="subtitle" placeholder="输入副标题" autocomplete="off" class="layui-input">
		    		</div>
			    	</div>
				<div class="layui-form-item">
		   		    <label class="layui-form-label">封面图片 <span style="color:red">*</span></label>
		   		    <div class="layui-input-inline">
		    			<input type="text" name="mainImage" required  lay-verify="required" placeholder="点击右侧按钮上传" autocomplete="off" class="layui-input" disabled>
		    		</div>
		    		<button type="button" class="layui-btn" id="uploadmain">
  						<i class="layui-icon">&#xe67c;</i>上传图片
					</button>
					<div class="layui-input-block" style="margin-top: 10px;">
						<img class="layui-upload-img" id="mainpreview" style="width:300px;height:200px;">
					</div>
		    	</div>
			    <div class="layui-form-item">
		   		    <label class="layui-form-label">展示图片&nbsp;&nbsp;</label>
		   		    <div class="layui-input-block">
		    			<input type="text" name="subImage" placeholder="输入副图片" autocomplete="off" class="layui-input">
		    		</div>
		    	</div>
			    <div class="layui-form-item">
		   		    <label class="layui-form-label">商品描述&nbsp;&nbsp;</label>
		   		    <div class="layui-input-block">
		    			<textarea name="detail" placeholder="输入商品描述" class="layui-textarea"></textarea>
		    		</div>
		    	</div>
			    <div class="layui-form-item">
		   		    <label class="layui-form-label">单价 <span style="color:red">*</span></label>
		   		    <div class="layui-input-inline" style="width:100px;">
		    			<input type="text" name="price" required  lay-verify="required" placeholder="输入单价" autocomplete="off" class="layui-input">
		   		    </div>
		   		    <label class="layui-form-mid">元</label>
		   		</div>
		   		<div class="layui-form-item">
		   		    <label class="layui-form-label">库存 <span style="color:red">*</span></label>
		   		    <div class="layui-input-inline" style="width:100px;">
		    			<input type="text" name="stock" required lay-verify="required" placeholder="输入库存" autocomplete="off" class="layui-input">
		    		</div>
		   		    <label class="layui-form-mid">件</label>
		    	</div>
			    <div class="layui-form-item">
		   		    <label class="layui-form-label">状态 <span style="color:red">*</span></label>
				    <div class="layui-input-block">
				      <input type="radio" name="status" value="1" title="在售" checked>
				      <input type="radio" name="status" value="2" title="下架">
				    </div>
			    </div>
			    <div class="layui-form-item" style="margin-left:5%">
					<button class="layui-btn layui-btn-fluid" lay-submit lay-filter="save" id="saveall">保存</button>
				</div>
		  	</form>
		</div>
      	<script>
            ;!function() {

		    	let table = layui.table;
		    	//第一个实例
		    	table.render({
		    	    elem: '#ordertable'
		    	    ,limit: 10
		    	    ,url: '../manage/order?type=list' //数据接口
		    	    ,page: true //开启分页
                    ,parseData: function(res){
                        return {
                            'code': res.status,
                            'msg': res.msg,
                            'count': res.data.total,
                            'data': res.data.list
                        }
                    }
                    ,request:{
                        pageName: 'pageNum',
                        limitName: 'pageSize'
                    }
                    ,toolbar: '#searchbar'
                    ,defaultToolbar: ['filter', 'print', 'exports']
		    	    ,cols: [[ //表头
		    	        {field: 'orderNo', title: '订单号', rowspan:2, width:110, sort: true, fixed: 'left'},
		    	        {field: 'payment', title: '支付金额', rowspan:2, width:120, sort: true, templet:'<div>{{fixed(d.payment)}}</div>', align:'right'},
		    	        {field: 'paymentType', title: '支付方式', rowspan:2, width: 90, templet:'<div>{{d.paymentTypeDesc}}</div>'},
		    	        {field: 'postage', title: '运费', rowspan:2, width: 80, templet:'<div>{{fixed(d.postage)}}</div>', align:'right'},
		    	        {field: 'status', title: '订单状态', rowspan:2, width:90, templet: '#main-status-show'},
		    	        {align: 'center', title: '订单历史', colspan:5},
                        {title: '操作', fixed: 'right', rowspan:2, width: 120, align:'center', toolbar:'#tableBtn'},
		    	    ],[
		    	        {field: 'createTime', title: '创建', sort: true},
		    	        {field: 'paymentTime', title: '支付', sort: true},
		    	        {field: 'sendTime', title: '发货', sort: true},
		    	        {field: 'endTime', title: '完成', sort: true},
		    	        {field: 'closeTime', title: '关闭', sort: true},
		    	    ]]
                    ,done: function(res, curr, count){
                        if(res.code!==0)
                        	alert(res.msg)
                    }
		    	})
		    	//详细表
		    	table.render({
		    	    elem: '#detailtable'
		    	    ,limit: 10
		    	    ,url: '../manage/order?type=detail&orderNo=0' //数据接口
		    	    ,page: false //开启分页
                    ,parseData: function(res){
                    	if(res.status !== 0) 
                    		return null
                    	else
                    	{
                    		const data = res.data
                        	console.log(data)
                        	$("#detail-table #detail-orderno").text(data.orderlist.orderNo)
						    $("#detail-table #detail-userid").text(data.usertable.id)
							$("#detail-table #detail-username").text(data.usertable.username)
						    $("#detail-table #detail-receivename").text(data.shipping.receiverName)
                        	$("#detail-table #detail-receivezip").text(data.shipping.receiverZip)
						    $("#detail-table #detail-receiveadd").text(data.shipping.receiverProvince+data.shipping.receiverCity+data.shipping.receiverDistrict)
							$("#detail-table #detail-receiveaddress").text(data.shipping.receiverAddress)
						    $("#detail-table #detail-totalprice").text(fixed(data.orderlist.payment))
                    	}
                        return {
                            'code': res.status,
                            'msg': res.msg,
                            'count': res.data.orderitemvolist.total,
                            'data': res.data.orderitemvolist.list
                        }
                    }
                    ,request:{
                        pageName: 'pageNum',
                        limitName: 'pageSize'
                    }
                    ,toolbar: '#backbar'
                    ,defaultToolbar: ['filter', 'print', 'exports']
		    	    ,cols: [[ //表头
		    	        {field: 'productId', title: '商品号', width:90, fixed: 'left'},
		    	        {field: 'productName', title: '商品名'},
		    	        {field: 'productImage', title: '图片', templet:'#main-image-show'},
		    	        {field: 'currentUnitPrice', title: '单价', templet:'<div>{{fixed(d.currentUnitPrice)}}</div>', align:'right'},
		    	        {field: 'quantity', title: '数量', width:90},
		    	        {align: 'totalPrice', title: '合计', templet:'<div>{{fixed(d.totalPrice)}}</div>', align:'right'},
                    ]]
		    	})
		    	
		    	//监听右部工具条事件
		    	table.on('tool(ordertable)', function(obj){ //注：tool 是工具条事件名，()table 原始容器的属性 lay-filter="对应的值"
		    		var data = obj.data
		    		var layEvent = obj.event
		    		
		    		if(layEvent === 'send'){
		    			layer.confirm('确定要发货吗', function(index){
		    				$.ajax({
		    					type: "post",
		            			url: "../manage/order?type=send_goods",
		            			dataType: "json",
		            			data:{orderNo:data.orderNo},
		            			success: function(res){
		                            layer.msg(res.msg)
		                            table.reload('ordertable')
		            			},
		            			error: function(err){
		            				layer.msg("server err")
		            			}
		    				})
		    		  	});
		    		} else if(layEvent === 'detail'){
	                    const wrapwid = $('#wrap').width() + 15
	                    const fixtop = $('#wrap>.left-page').height();
						$('#wrap>.left-page').css({'left':-wrapwid})
						$('#wrap>.right-page').css({'left':0, 'width':100+'%', 'top':-fixtop, 'opacity':1})	
						
						table.reload('detailtable',{
							url: '../manage/order?type=detail',
		    				where: {orderNo:obj.data.orderNo}
		    			})	
		    		}
		    	})
		    	
		    	//监听顶部工具事件
		    	table.on('toolbar(ordertable)',function(obj){
		    		if(obj.event === 'search')
		    		{
		    			let searchkey = $('#search-key').val()
		    			let request = {'orderNo':searchkey}
		    			
		    			table.reload('ordertable',{
		    				url: '../manage/order?type=search',
		    				where: request,
		    				page: {
		    					curr: 1 //重新从第 1 页开始
		    				},
		    				done:function(res, curr, count){
		    					$('#search-key').val(searchkey)
		    					layer.msg('search ' + $('#search-key').val())
		    				}
		    			})	
		    		}
		    	})
		    	//详细表工具
		    	table.on('toolbar(detailtable)',function(obj){
		    		if(obj.event === 'back')
		    		{
		    			const wrapwid = $('#wrap').width() + 15
						$('#wrap>.left-page').css({'left':0})
						$('#wrap>.right-page').css({'left':wrapwid, 'opacity':0})	
		    		}
		    	})
            }()
        </script>
    </body>
</html>