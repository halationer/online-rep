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
            #exit{
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
            }
            #exit:hover{
                background-color: #bb2d14;
                cursor: pointer;
            }
            #left>ul{
                width: 100%;
                font-size: 20px;
            }
            #left>ul>li{
                width: 100%;
                height: 80px;
                border-bottom: solid 1px #00000030;
                display: flex;
                align-items: center;
				padding: 0 30%;
                font-weight: bold;
            }
            #left li:hover{
                background: #e4e4e4;
                cursor: pointer;
            }
            #right th, #right td{
                font-size: 15px;
                text-align: center;
                vertical-align: middle;
            }
            .btn:focus,.btn:active:focus,
            .btn.active:focus,.btn.focus,
            .btn:active.focus,.btn.active.focus {  
                outline: none; 
                box-shadow:none;
            }
            #right #but{
                min-width: 120px;
            }
            #right #but>.btn{
                margin: 5px;
                width: 50px;
                height: 30px;
                font-size: 15px;
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
    		let titlemap = {
    				'id' : '编号',
    				'username':'用户名',
    				'password':'密码',
    				'phone':'手机',
    				'email':'邮箱',
    				'role':'权限',
    				'question':'密保问题',
    				'answer':'密保答案',
    				'createTime':'创建时间',
    				'updateTime':'更新时间',
    		}
    		let admin = {'username':'未登录'}
    		if( ${!empty admin} )
            	admin = jQuery.parseJSON('${admin}')
            else
            	$(location).attr('href', '../layindex.jsp')
    		$(function(){

                //接收参数
                $('#adminname').text(admin['username'])

                //设置响应
                $('#exit').click(function(){
                	$.ajax({
            			type: "post",
            			url: "../manage/user?type=exit", //对应url
            			dataType: "json",
            			success: function(res){
                            console.log(res.msg)
							var url = "../layindex.jsp"
							window.location.href = url
            			},
            			error: function(err){
            				console.log("err")
            				console.log(err)
            			}
            		})
            	})
                $('#user-manage').click(function(){
            		$.ajax({
            			type: "post",
            			url: "../manage/user?type=list", //对应url
            			dataType: "json",
            			success: function(res){
            				if(res.status === 0){
                                console.log(res.data)
                            	$('thead>tr').empty()
                            	$('tbody').empty()
                                makeThead(res)
                                makeTbody(res)
                                makeNavigatePages("user", res)
							}
            				else{
            					console.log(res.msg)
            				}
            			},
            			error: function(err){
            				console.log("err")
            				console.log(err)
            			}
            		})
            	})
				
            	function makeThead(res){
                	const example = res.data.list[0]
                    $.each(example, function(key,val){
                        let th = $('<th scope="col"></th>')
                        th.appendTo($('thead>tr')).text(titlemap[key])
                    })
                    let but = $("<td id = 'but'>\
                        <button type='button' class='btn btn-info btn-sm' id='b-btn'>添加</button>\
                        <button type='button' class='btn btn-success btn-sm' id='b-btn'>保存</button>\
                        </td>\
                    ").appendTo($('thead>tr'))
                }
                function makeTbody(res){
                	const list = res.data.list
                    for(let i=res.data.startRow-1; i<res.data.endRow; i++)
                    {
                        let tr = $('<tr></tr>').appendTo('tbody')
                        const example = res.data.list[i]
                        $.each(example, function(key,val){
                            let td = $('<td></td>')
                            td.appendTo(tr).text(val)
                        })
                        let but = $("<td id = 'but'>\
                            <button type='button' class='btn btn-primary btn-sm'>修改</button>\
                            <button type='button' class='btn btn-danger btn-sm'>删除</button></td>\
                        ").appendTo(tr)
                    }
                }
                function makeNavigatePages(table, res){
                    const page = res.data
                    let tr = $('<tr></tr>').appendTo('tbody')
                    let td = $('<td colspan = "'+(Object.keys(page.list[0]).length+1)+'"></td>').appendTo(tr)
                    let bg = $('<div class="btn-group"></div>').appendTo(td)
                    newbutton().appendTo(bg).text("首页").click(function(){onnavigateclick(table,page.firstPage)})
                    newbutton().appendTo(bg).text("上一页").click(function(){onnavigateclick(table,page.prePage)})
                    const navigate = page.navigatepageNums
                    for(let i=0; i<navigate.length; i++)
                    {
                    	newbutton().appendTo(bg).text(navigate[i]).click(function(){onnavigateclick(table,navigate[i])})
                    }
                    newbutton().appendTo(bg).text("下一页").click(function(){onnavigateclick(table,page.nextPage)})
                    newbutton().appendTo(bg).text("尾页").click(function(){onnavigateclick(table,page.lastPage)})
                }
                function newbutton()
                {
                	return $('<button class="btn btn-outline-primary"></button>')
                }
                function onnavigateclick(table, pagenum){
                	$.ajax({
            			type: "post",
            			url: "../manage/"+table+"?type=list&pageNum="+pagenum, //对应url
            			dataType: "json",
            			success: function(res){
            				if(res.status === 0){
                                console.log(res.data)
                            	$('thead>tr').empty()
                            	$('tbody').empty()
                                makeThead(res)
                                makeTbody(res)
                                makeNavigatePages("user", res)
							}
            				else{
            					console.log(res.msg)
            				}
            			},
            			error: function(err){
            				console.log("err")
            				console.log(err)
            			}
            		})
                }
            })
    	</script>
    	<div id='top'>
            <div id='title'>电商平台后台管理系统</div>
            <div id='admin'>
                <div id='text'>当前用户：</div>
                <div id='adminname'></div>
            </div>
            <div id='exit'>退出登录</div>
        </div>
        <div id='bottom'>
            <div id='left'>
                <ul>
                    <li id="user-manage">用户管理</li>
                    <li>商品管理</li>
                    <li>类别管理</li>
                    <li>订单管理</li>
                </ul>
            </div>
            <div id='right'>
                <table class="table">
                    <thead><tr></tr></thead>
                    <tbody></tbody>
                </table>
            </div>
        </div>
    </body>
</html>