<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>


		<head>
		<meta charset="utf-8">
		<meta name="viewport"
			content="width=device-width, initial-scale=1, maximum-scale=1">
		<title>收货地址</title>
		<link rel="stylesheet" href="layui/css/layui.css">
		<link rel="shortcut icon" href="favicon.ico" />
		</head>



		<body>
		
			<!-- 你的HTML代码 -->
			<style type="text/css">
		.layui-input-block {
			width: 500px;
		}
		</style>
		
			<form class="layui-form" action="">
		
				<div class="layui-form-item">
					<label class="layui-form-label">姓名：</label>
					<div class="layui-input-block" style="width: 500px;">
						<input type="text" name="title" required lay-verify="required"
							placeholder="长度不超过10个字符" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">固定电话：</label>
					<div class="layui-input-block" style="width: 500px;">
						<input type="text" name="title" required lay-verify="required"
							placeholder="长度不超过10个字符" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">手机号码：</label>
					<div class="layui-input-block" style="width: 500px;">
						<input type="text" name="title" required lay-verify="required"
							placeholder="长度不超过10个字符" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">邮政编码：</label>
					<div class="layui-input-inline">
						<input type="text" name="title" required lay-verify="required"
							placeholder="请输入邮政编码" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">地址信息：</label>
					<div class="layui-input-inline" style="width: 160px;">
						<input type="text" name="title" required lay-verify="required"
							placeholder="请输入省份" autocomplete="off" class="layui-input">
					</div>
					<div class="layui-input-inline" style="width: 160px;">
						<input type="text" name="title" required lay-verify="required"
							placeholder="请输入城市" autocomplete="off" class="layui-input">
					</div>
					<div class="layui-input-inline" style="width: 160px;">
						<input type="text" name="title" required lay-verify="required"
							placeholder="请输入区县" autocomplete="off" class="layui-input">
					</div>
		
		
				</div>
				<!--<div class="layui-form-item">
		    <label class="layui-form-label">地址信息：</label>
		    <div class="layui-input-block">
		      <select name="city" lay-verify="">
		  		<option value="">请选择省</option>
		  		<option value="010">北京</option>
		  		<option value="021">上海</option>
		  		<option value="0571">杭州</option>
		  		<option value="0571">广州</option>
		  		<option value="0571">河北</option>
		  		<option value="0571">湖北</option>
		  		<option value="0571">山东</option>
		  		<option value="0571">浙江</option>
			</select>  
		    </div>
		    <div class="layui-input-block">
		      <select name="city" lay-verify="">
		  		<option value="">请选择市</option>
		  		<option value="010">北京</option>
		  		<option value="021">上海</option>
		  		<option value="0571">杭州</option>
		  		<option value="0571">广州</option>
		  		<option value="0571">河北</option>
		  		<option value="0571">湖北</option>
		  		<option value="0571">山东</option>
		  		<option value="0571">浙江</option>
			</select>  
		    </div>
		    <div class="layui-input-block">
		      <select name="city" lay-verify="">
		  		<option value="">请选择区县</option>
		  		<option value="010">北京</option>
		  		<option value="021">上海</option>
		  		<option value="0571">杭州</option>
		  		<option value="0571">广州</option>
		  		<option value="0571">河北</option>
		  		<option value="0571">湖北</option>
		  		<option value="0571">山东</option>
		  		<option value="0571">浙江</option>
			</select>  
		    </div>
		  </div>-->
		
		
		
				<div class="layui-form-item layui-form-text">
					<label class="layui-form-label">详细信息：</label>
					<div class="layui-input-block">
						<textarea name="desc" placeholder="请输入详细地址信息，如道路、门牌号、小区、楼栋号、单元等信息"
							class="layui-textarea" required lay-verify="required"></textarea>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label"></label>
					<div class="layui-input-block">
						<input type="checkbox" name="" title="设置为默认收货地址" lay-skin="primary">
					</div>
		
					<div class="layui-form-item">
						<div class="layui-input-block">
							<button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
							<button type="reset" class="layui-btn layui-btn-primary">重置</button>
						</div>
					</div>
			</form>
			<script src="layui/layui.all.js"></script>
			<script>
		//由于模块都一次性加载，因此不用执行 layui.use() 来加载对应模块，直接使用即可：
		;!function(){
		 //Demo
		layui.use('form', function(){
		  var form = layui.form;
		  
		  //监听提交
		  form.on('submit(formDemo)', function(data){
		    layer.msg(JSON.stringify(data.field));
		    return false;
		  });
		});
		</script>
		</body>
</html>