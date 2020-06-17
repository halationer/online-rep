<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>用户管理——电商平台后台管理系统</title>
        <script src="../js/jquery.js"></script>
        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <script src="../js/bootstrap.min.js"></script>
        <style>
            *{padding: 0; margin: 0;}
            body{
                height: 100vh;
                width: 100vw;
                display: flex;
                flex-direction: column;
            }
            #top{
                height: 70px;
                width: 100%;
                position: fixed;
                background-color: #1d1d1d;
                z-index: 2;
                display: flex;
            }
            #bottom{
                width: 100%;
                height: calc(100% - 70px);
                position: relative;
                top: 70px;
            }
            #left{
                width: 200px;
                height: 100%;
                position: fixed;
                background-color: #d3d3d3;
                z-index: 1;
            }
            #right{
                position: absolute;
                left: 200px;
                top: 0;
                width: calc(100% - 200px);
                box-sizing: border-box;
                padding: 0 10px;
            }
            #admin, #exit, #title{
                color: #fff;
                margin: auto;
                float: right;
            }
            #title{
                margin-left: 30px;
                font-size: 20px;
                font-weight: bold;
            }
            #admin{
                display: flex;
                margin-right: 150px;
            }
            #admin>#adminname{
                border-radius: 10px;
                background-color: #808080;
                color: #ffffff;
                font-size: 13px;
                font-weight: bold;
                text-align: center;
                margin: auto;
                margin-left: 0;
                margin-top: 3px;
                box-sizing: border-box;
                padding: 0 5px;
            }
            #exit:link,#exit:visited{
                display: block;
                background-color: #ff6347;
                border-radius: 20px;
                width: 85px;
                text-align: center;
                font-size: 15px;
                font-weight: bold;
                letter-spacing: 2px;
                position: absolute;
                right: 30px;
                top: 25px;
	            text-decoration:none;
            }
            #exit:hover{
                background-color: #bb2d14;
            }
            #left>ul{
                width: 100%;
                font-size: 20px;
            }
            #left>ul>li{
                width: 100%;
                border-bottom: solid 1px #00000030;
                text-align: center;
                display: inline-block;
            }
            #left a:link, #left a:visited{
            	display: block;
            	width: 100%;
            	height: 100%;
	            text-decoration:none;
                padding: 20px 0;
                color: black;
                font-weight: bold;
            }
            #left a:hover{
                background: #e4e4e4;
            }
            #right th, #right td{
                min-width: 90px;
                text-align: center;
            }
            .btn:focus,.btn:active:focus,
            .btn.active:focus,.btn.focus,
            .btn:active.focus,.btn.active.focus {  
                outline: none; 
                box-shadow:none;
            }
            #right #but{
                min-width: 120px;
                display: flex;
            }
            #right #but>.btn{
                margin-right: 5px;
                min-width: 60px;
            }
            .final{
                float: right;
            }
            #page{
                display: flex;
            }
            #page>.btn-group{
                margin: auto;
            }
        </style>
    </head>
    <body>
    	<script>
    		console.log('${param.admin}')
            let admin = jQuery.parseJSON('${sessionScope.admin}')
    		$(function(){
                $('#adminname').text(admin['username'])
            })
    	</script>
    	<div id='top'>
            <div id='title'>电商平台后台管理系统</div>
            <div id='admin'>
                <div id='text'>当前用户：</div>
                <div id='adminname'></div>
            </div>
            <a id='exit' href='../index.jsp'>退出登录</a>
        </div>
        <div id='bottom'>
            <div id='left'>
                <ul>
                    <li><a href='../manage/user?type=list'>用户管理</a></li>
                    <li><a href='#'>商品管理</a></li>
                    <li><a href='#'>类别管理</a></li>
                    <li><a href='#'>订单管理</a></li>
                </ul>
            </div>
            <div id='right'>
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">编号</th>
                            <th scope="col">用户名</th>
                            <th scope="col">密码</th>
                            <th scope="col">邮箱</th>
                            <th scope="col">手机</th>
                            <th scope="col">密保问题</th>
                            <th scope="col">密保答案</th>
                            <th scope="col">权限</th>
                            <th scope="col">创建时间</th>
                            <th scope="col">修改时间</th>
                            <td id = 'but'>
                                <button type="button" class="btn btn-info btn-sm" id='b-btn'>添加</button>
                                <button type="button" class="btn btn-success btn-sm" id='b-btn'>保存</button>
                            </td>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <th scope="row">1</th>
                            <td>Mark</td>
                            <td>Otto</td>
                            <td>@mdo</td>
                            <td>Mark</td>
                            <td>Otto</td>
                            <td>@mdo</td>
                            <td>Mark</td>
                            <td>Otto</td>
                            <td>@mdo</td>
                            <td id = 'but'>
                                <button type="button" class="btn btn-primary btn-sm">修改</button>
                                <button type="button" class="btn btn-danger btn-sm">删除</button>
                            </td>
                        </tr>
                        <tr>
                            <td colspan = "11">
                                <div class="btn-group">
                                    <button class="btn btn-outline-primary">首页</button>
                                    <button class="btn btn-outline-primary">1</button>
                                    <button class="btn btn-outline-primary">2</button>
                                    <button class="btn btn-outline-primary">3</button>
                                    <button class="btn btn-outline-primary">...</button>
                                    <button class="btn btn-outline-primary">尾页</button>
                                </div>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>