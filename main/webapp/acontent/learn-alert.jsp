<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>警告框练习</title>
        <script src="../js/jquery.js"></script>
        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <script src="../js/bootstrap.min.js"></script>
        <style>
            *{margin: 0; padding: 0;}
            .btn:focus,.close:focus{
     			outline: none;
     			box-shadow: 0 0 0 0;
 			}
 			#wrap{
 				display: flex;
 				position: fixed;
 				width: 60%;
				height: 10px;
				top: 10%;
				left: 20%;
				flex-direction: column
 			}
        </style>
    </head>
    <body>
    	<button type='button' class="btn btn-primary" id='alert'>alert</button>
        <div id='wrap'></div>
        <script>
        	let count = 0;
        	let maxlen = 2;
        	let arr = new Array(maxlen)
        	$('#alert').click(function(){
        		if(count >= maxlen)
        		{
        			arr[0].alert('close')
        			count--;
        			for(let i=0; i<maxlen; i++)
						arr[i] = arr[i+1]
        		}
        		const alert = $("<div role='alert'></div>")
        		const button = $("<button type='button' data-dismiss='alert' aria-label='Close'></button>")
        		alert.append(button.addClass('close'))
        			.addClass('alert alert-warning alert-dismissible fade show')
        			.append("这是一个警告框" + count)
        		arr[count++] = alert
        		alert.appendTo($('#wrap'))
        		setTimeout(function(){
        			if(alert.parents().length > 0)
        			{
        				alert.alert('close')
        				count--
        				for(let i=0; i<maxlen; i++)
    						arr[i] = arr[i+1]
        			}
        		}, 2000)
        	})
        </script>
    </body>
</html>