<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link rel="stylesheet" href="../layui/css/layui.css">
        <title>类别管理——电商平台后台管理系统</title>
        <script src="../js/jquery.js"></script>
        <script src="../js/echarts.min.js"></script>
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
            #select-mode{
            	margin-bottom: 10px;
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
                        <li class='layui-nav-item layui-this'>
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
                        <li class='layui-nav-item'>
                            <a href='layui-backorder.jsp'>
                            	<i class='layui-icon layui-icon-form' style='font-size: 18px;'></i>
                            	<span>&nbsp;&nbsp;&nbsp;订单管理</span>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>

            <div class='layui-body'>
                <div id = 'category-box' style='padding: 15px; height: calc(100% - 30px);'>
                	<div id='select-mode' class='layui-btn-group'>
                		<button type="button" id='select-tree' class="layui-btn layui-btn-primary layui-bg-green">树图</button>
  						<button type="button" id='select-box' class="layui-btn layui-btn-primary">盒子</button>
                	</div>
                    <div id="category-tree"></div>
                </div>
            </div>

            <div class='layui-footer'>
                @电商平台后台管理系统
            </div>
        </div>

        <script src="../layui/layui.all.js"></script>
        <script type="text/html" id="tableBtn">
            <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
            <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
        </script>
	    <script>
            if( ${!empty admin} )
                admin = jQuery.parseJSON('${admin}')
            else
                $(location).attr('href', '../layindex.jsp')
                
            //categroy_tree
            let category_tree = null
            //select
            let select = 0
            //echart
            let chart = echarts.init($('#category-tree')
            		.css({'width':'100%','height':'calc(100% - 40px)'})[0])
            $('#category-tree').resize(function(){
            	chart.resize()
            })
            		
            let option = {
	            title: {
	                text: '商品类别管理',
	                left: 'center',
	            },
	            tooltip: {},//设置鼠标hover弹框
	            color: ['#3782d8','#67e0e3','#9fe688','#b9ba72',
	            '#ff9f7f','#fb7923','#e062ae','#e690d1','#e7bcf3',
	            '#9d96f5','#8378ea','#96bfff','#3275a9'],
	            series: [
	            	{
	            		name: '商品类别',
	            		type: 'treemap',
	            		leafDepth: 1,
	            		levels:[
	            			{
	            				label:{fontSize: 20},
	                            itemStyle: {
	                                borderColor: '#555',
	                                borderWidth: 4,
	                                gapWidth: 4
	                            },
	            				emphasis:{//hover效果
	            					label:{fontSize: 23}
	            				}
	                        },
	                        {
	                        	upperLabel:{show:true, height:30, fontWeight:'bold'},
	            				label:{fontSize: 20},
	                            colorSaturation: [0.3, 0.6],
	                            itemStyle: {
	                                borderColorSaturation: 0.7,
	                                gapWidth: 2,
	                                borderWidth: 2
	                            },
	            				emphasis:{
	            					label:{fontSize: 23}
	            				}
	                        },
	                        {
	                        	upperLabel:{show:true, height:30, fontWeight:'bold'},
	            				label:{fontSize: 20},
	                            colorSaturation: [0.3, 0.5],
	                            itemStyle: {
	                                borderColorSaturation: 0.6,
	                                gapWidth: 1
	                            },
	            				emphasis:{
	            					label:{fontSize: 23}
	            				}
	                        },
	                        {
	                        	upperLabel:{show:true, height:30, fontWeight:'bold'},
	            				label:{fontSize: 20},
	                            colorSaturation: [0.3, 0.5],
	            				emphasis:{
	            					label:{fontSize: 23}
	            				}
	                        }
	            		],
	            		data: category_tree,
	            	}
	            ],
        	}
            function loadcategory(tree, chart, json, option)
            {
            	$.ajax({
            		type : 'get',
					url : '../manage/category?type=get_category_treeall',
					dataType : 'json',
					success : function(data) {
						if (data.status == 0) {
							categorytree = data.data
							console.log(categorytree)
							if(select === 0)
							{
								json.data = categorytree
								tree.render(json)
							}
							if(select === 1)
							{
								option.series[0].data = categorytree
								chart.setOption(option, true)
							}
						} else {
							layer.msg(data.msg, {
								icon : 2
							})
						}
					}
            	})	
            }
            //side-init
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
            
            //layui
		    ;!function() {
		    	
		    	let tree = layui.tree
		    	let json = {
		        	elem: '#category-tree'  //绑定元素
		        	,edit: ['add','update','del']
		        	,operate: function(obj){
		        		let data = obj.data
		        		switch(obj.type)
		        		{
		        			case 'add':
		        			{
		        				$.ajax({
		        					type : 'post',
		        					url : '../manage/category?type=add_category',
		        					dataType : 'json',
		        					data:{parentId:data.id, categoryName:'未命名'},
		        					success : function(res) {
		        						if (res.status == 0) {
		        							console.log(res.msg)
		        			        		loadcategory(tree, null, json, null)
		        						} else {
		        							alert(res.msg)
		        						}
		        					}
		        				})
		        				break
		        			}
		        			case 'update':
		        			{
		        				let fixedname = obj.elem.find('.layui-tree-txt').html()
		        				$.ajax({
		        					type : 'post',
		        					url : '../manage/category?type=set_category_name',
		        					dataType : 'json',
		        					data:{categoryId:data.id, categoryName:fixedname},
		        					success : function(res) {
		        						if (res.status == 0) {
		        							console.log(res.msg)
		        						} else {
		        							alert(res.msg)
		        						}
		        					}
		        				})
		        				break
		        			}
		        			case 'del':
		        			{
		        				$.ajax({
		        					type : 'post',
		        					url : '../manage/category?type=del_category',
		        					dataType : 'json',
		        					data:{categoryId:data.id},
		        					success : function(res) {
		        						if (res.status == 0) {
		        							console.log(res.msg)
		        						} else {
		        							alert(res.msg)
		        						}
		        					}
		        				})
								break
		        			}
		        		}
		        	}
		        	,data: category_tree
		    	}
        		loadcategory(tree, null, json, null)
		    	
		    	$('#select-tree').click(function(){
	            	if(select === 1){
	            		$('#select-tree').addClass('layui-bg-green')
	            		$('#select-box').removeClass('layui-bg-green')
	            		select = 0
		        		loadcategory(tree, null, json, null)
	            	}
	            })
	            $('#select-box').click(function(){
	            	if(select === 0){
	            		$('#select-tree').removeClass('layui-bg-green')
	            		$('#select-box').addClass('layui-bg-green')
	            		select = 1
	            		$('#category-tree').remove()
	            		$('#category-box').append($('<div id="category-tree"></div>'))
	            		let chart = echarts.init($('#category-tree')
	                    		.css({'width':'100%','height':'calc(100% - 40px)'})[0])
	                    $('#category-tree').resize(function(){
	                    	chart.resize()
	                    })
	                    loadcategory(null, chart, null, option)
	            	}
	            })
		    	
		        //渲染
            }()
        </script>
    </body>
</html>