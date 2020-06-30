<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link rel="stylesheet" href="../layui/css/layui.css">
        <title>主页——电商平台后台管理系统</title>
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
                    <table id="usertable" lay-filter="user"></table>
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
	    
		    ;!function() {

            }()
        </script>
    </body>
</html>