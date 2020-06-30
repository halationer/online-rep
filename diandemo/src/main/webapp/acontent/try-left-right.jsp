<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>左右</title>
        <script src="../js/jquery.js"></script>
		<style>
			*{margin: 0; padding: 0;}
			body,.wrap{
				width: 100vw;
				height: 100vh;
				position: relative;
			}
			.left-page{
				width: 100%;
				height: 100%;
				background-color: #800;
				position: absolute;
				left: 0;
				transition: 0.2s;
			}
			.right-page{
				width: 0;
				height: 100%;
				background-color: #080;
				position: absolute;
				left: 100%;
				transition: 0.2s;
			}
		</style>
	</head>
	<body>
		<div class='wrap'>
			<div class='left-page'></div>
			<div class='right-page'></div>
		</div>
		<script>
			$('.wrap').mousedown(function(e){
				if(e.which === 1)
				{
					const startx = e.pageX || e.clientX
                    const lleft = $('.wrap>.left-page').offset().left
                    const rleft = $('.wrap>.right-page').offset().left
					$(document).mousemove(function(e){
						const endx = e.pageX || e.clientX
						const flleft = endx - startx + lleft
						const frleft = endx - startx + rleft
						$('.wrap>.left-page').css({'left':flleft})
						$('.wrap>.right-page').css({'left':frleft})
					})
					.mouseup(function(e){
						const endx = e.pageX || e.clientX
	                    const wrapwid = $('.wrap').width()
	                    if(endx - startx >= wrapwid / 10)
	                    {
							$('.wrap>.left-page').css({'left':0})
							$('.wrap>.right-page').css({'left':wrapwid,'width':0})
	                    }
	                    else if(startx - endx >= wrapwid / 10)
	                    {
							$('.wrap>.left-page').css({'left':-wrapwid})
							$('.wrap>.right-page').css({'left':0, 'width':100+'%'})	
	                    }
	                    else
	                    {
	                    	$('.wrap>.left-page').css({'left':lleft})
							$('.wrap>.right-page').css({'left':rleft})	
	                    }
						$(document).off()
					})
				}
			})
		</script>
	</body>
</html>