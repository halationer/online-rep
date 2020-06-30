<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link rel="stylesheet" href="../layui/css/layui.css">
        <title>商品管理——电商平台后台管理系统</title>
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
                        <li class='layui-nav-item layui-this'>
                            <a href='layui-backgoods.jsp'>
                            	<i class='layui-icon layui-icon-app' style='font-size: 18px;'></i>
                            	<span>&nbsp;&nbsp;&nbsp;商品信息</span>
                            </a>
                        </li>
                        <li class='layui-nav-item'>
                            <a href='javascript:;'>
                            	<i class='layui-icon layui-icon-form' style='font-size: 18px;'></i>
                            	<span>&nbsp;&nbsp;&nbsp;订单管理</span>
                            </a>
                            <dl class='layui-nav-child'>
                                <dd><a href='#'><span>订单信息</span></a></dd>
                                <dd><a href='#'><span>订单详细</span></a></dd>
                            </dl>
                        </li>
                    </ul>
                </div>
            </div>

            <div class='layui-body'>
                <div style='padding: 15px;'>
                    <table id="goodtable" lay-filter="good"></table>
                </div>
            </div>

            <div class='layui-footer'>
                @电商平台后台管理系统
            </div>
        </div>

        <script src="../layui/layui.all.js"></script>
        <script type="text/html" id="tableBtn">
            <a class="layui-btn layui-btn-xs" lay-event="detail">编辑</a>
            <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
        </script>
        <script type="text/html" id="searchbar">
           	<input style="height:30px;width:157px;" placeholder="请输入关键词" id="search-key">
           	<a href="javascript:void(0)" lay-event="search" style="position:absolute;left:144px;top:10px;">
           		<i class="layui-icon layui-icon-search" style="background:#fff;padding:5px;"></i>
           	</a>
		</script>
		<script type="text/html" id="main-image-show">
			<div style="background:url({{d.mainImage}}) no-repeat;background-size:auto 100%;background-position:50%;height:100%;"></div>
		</script>

	    <script>
	    
            if( ${!empty admin} )
                admin = jQuery.parseJSON('${admin}')
            else
                $(location).attr('href', '../layindex.jsp')

            $(function(){

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
		    	    elem: '#goodtable'
		    	    ,limit: 10
		    	    ,url: '../manage/goods?type=list' //数据接口
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
                    ,defaultToolbar: [{
                    	title: '添加新商品',
                    	layEvent: 'add',
                    	icon: 'layui-icon-addition'
                    },'filter']
		    	    ,cols: [[ //表头
		    	        {field: 'id', title: 'ID', width:60, sort: true, fixed: 'left'},
		    	        {field: 'categoryId', title: '类别', width:80, sort: true},
		    	        {field: 'name', title: '名称'},
		    	        {field: 'subtitle', title: '副标题'},
		    	        {field: 'mainImage', title: '主图片', width:80, templet: '#main-image-show'},
		    	        {field: 'status', title: '状态', width: 80, sort: true},
		    	        {field: 'price', title: '单价', width:120, align:'right', templet:'<div>{{fixed(d.price)}}</div>'},
                        {title: '操作', fixed: 'right', width: 120, align:'center', toolbar:'#tableBtn'},
		    	    ]]
                    ,done: function(res, curr, count){
                        if(res.code!==0)
                        	alert(res.msg)
                    }
		    	})
		    	
		    	//监听右部工具条事件
		    	table.on('tool(good)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
		    		var data = obj.data
		    		var layEvent = obj.event

		    		if(layEvent === 'del'){
		    			layer.confirm('确定要删除这个商品吗', function(index){
		    				$.ajax({
		    					type: "post",
		            			url: "../manage/goods?type=set_sale_status",
		            			dataType: "json",
		            			data:{id:data.id,status:0},
		            			success: function(res){
		                            layer.msg(res.msg)
		            			},
		            			error: function(err){
		            				layer.msg("server err")
		            			}
		    				})
		    		    	obj.del()
		    		    	layer.close(index)
		    		  	});
		    		} else if(layEvent === 'detail'){
		    			layer.open({
		    				title: '编辑商品   ID：' + data.id,
		    				content: $('#add-form')[0].innerHTML,
		    				btn:[],
		    				area: ['50%','80%'],
		    				success:function(){
		    					$.ajax({
		    						type: "post",
			            			url: "../manage/goods?type=detail",
			            			dataType: "json",
			            			data:{id:data.id},
			            			success: function(res){
			            				layui.form.val('save-form',{
			            					'name':res.data.name, 'detail':res.data.detail, 'price':res.data.price,
			            					'stock':res.data.stock, 'subtitle':res.data.subtitle, 'mainImage':res.data.mainImage,
			            					'subImage':res.data.subImages
			            				})
			            				$('.layui-layer-content>form #mainpreview').css({
			            					'background':'url('+res.data.mainImage+') no-repeat',
			            					'background-size':'auto 100%',
			            					'background-position':'50%',
			            				})
			            				$('.layui-layer-content>form [name="categoryId"]').val(res.data.categoryId)
				    					$('.layui-layer-content>form [name="status"][value='+res.data.status+']').attr("checked",true)
				    					$('<input type="hidden" name="id">').val(res.data.id).appendTo($('.layui-layer-content>form'))
				    					$('<div class="layui-form-item">更新时间：&nbsp;&nbsp;&nbsp;&nbsp;'+res.data.updateTime+'</div>').prependTo($('.layui-layer-content>form'))
				    					$('<div class="layui-form-item">创建时间：&nbsp;&nbsp;&nbsp;&nbsp;'+res.data.createTime+'</div>').prependTo($('.layui-layer-content>form'))
				    					layui.form.render()
				    				//图片上传
				    					layui.upload.render({
			            					elem: '.layui-layer-content>form #uploadmain',
			            					url: '../manage/goods?type=upload',
			            					field: 'upload_file',
			            					accept: 'image',
			            					before: function(obj){
			            						obj.preview(function(index, file, result){
			            					        $('.layui-layer-content>form #mainpreview').attr('src', result) //图片链接（base64）
			            					    });
			            					},
			            					done: function(res){
			            						$('.layui-layer-content>form [name="mainImage"]').val(res.data)
			            					},
			            					err: function(res){
			            						console.log('server err')
			            					}
			            				})
										layui.form.on('submit(save)', function(data){
											console.log(data)
					    					$.ajax({
							    				type: "post",
						            			url: "../manage/goods?type=save",
						            			dataType: "json",
						            			data:data.field,
						            			success: function(res){
						                            console.log(res.msg)
						                            table.reload('goodtable')
						            			},
						            			error: function(err){
						            				layer.msg("server err")
						            			}
							    			})
										})
			            			},
			            			error: function(err){
			            				layer.msg("server err")
			            			}
		    					})
		    					
		    				},
		    			})
		    		}
		    	})
		    	
		    	//监听顶部工具事件
		    	table.on('toolbar(good)',function(obj){
		    		if(obj.event === 'add')
		    		{
		    			layer.open({
		    				title: '添加商品',
		    				content: $('#add-form')[0].innerHTML,
		    				btn:[],
		    				area: ['50%','80%'],
		    				success:function(){
		    					layui.upload.render({
		        					elem: '.layui-layer-content>form #uploadmain',
		        					url: '../manage/goods?type=upload',
		        					field: 'upload_file',
		        					accept: 'image',
		        					before: function(obj){
		        						obj.preview(function(index, file, result){
		        					        $('.layui-layer-content>form #mainpreview').attr('src', result) //图片链接（base64）
		        					    });
		        					},
		        					done: function(res){
		        						$('.layui-layer-content>form [name="mainImage"]').val(res.data)
		        					},
		        					err: function(res){
		        						console.log('server err')
		        					}
		        				})
		    					layui.form.render()
								layui.form.on('submit(save)', function(data){
									console.log(data)
			    					$.ajax({
					    				type: "post",
				            			url: "../manage/goods?type=save",
				            			dataType: "json",
				            			data:data.field,
				            			success: function(res){
				                            console.log(res.msg)
				                            table.reload('goodtable')
				            			},
				            			error: function(err){
				            				layer.msg("server err")
				            			}
					    			})
								})
		    				},
		    			})
		    		}
		    		else if(obj.event === 'search')
		    		{
		    			let searchkey = $('#search-key').val()
		    			let request = {'productName':searchkey}
		    			if(searchkey.substr(0,3)==='id:')
		    				request = {'productId':searchkey.substr(3)}
		    			else if(searchkey.substr(0,5)==='name:')
		    				request = {'productName':searchkey.substr(5)}
		    			
		    			table.reload('goodtable',{
		    				url: '../manage/goods?type=search',
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
            }()
        </script>
    </body>
</html>