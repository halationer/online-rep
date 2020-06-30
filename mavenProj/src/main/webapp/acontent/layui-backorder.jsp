<script>
			var addform = '\
	    		<form class="layui-form">\
    			<div class="layui-form-item">\
	    		    <div class="layui-input-block">\
	    		    	<input type="text" name="name" required  lay-verify="required" placeholder="商品名" autocomplete="off" class="layui-input">\
	    		    </div>\
		    	</div>\
			    <div class="layui-form-item">\
	    		    <div class="layui-input-block">\
	    		    	<select name="categoryId" lay-verify="required">\
			    		    <option value="">请选择商品类别</option>\
			    		    <option value="1">服装</option>\
			    		    <option value="2">电子</option>\
			    		    <option value="3">家电</option>\
			    		</select>\
    		    	</div>\
		    	</div>\
			    <div class="layui-form-item">\
	    		    <div class="layui-input-block">\
		    			<input type="text" name="subtitle" required  lay-verify="required" placeholder="副标题" autocomplete="off" class="layui-input">\
		    		</div>\
			    	</div>\
				    <div class="layui-form-item">\
	    		    <div class="layui-input-block">\
		    			<input type="text" name="mainImage" required  lay-verify="required" placeholder="主图片" autocomplete="off" class="layui-input">\
		    		</div>\
		    	</div>\
			    <div class="layui-form-item">\
	    		    <div class="layui-input-block">\
		    			<input type="text" name="subImage" required  lay-verify="required" placeholder="副图片" autocomplete="off" class="layui-input">\
		    		</div>\
		    	</div>\
			    <div class="layui-form-item">\
	    		    <div class="layui-input-block">\
		    			<input type="text" name="detail" required  lay-verify="required" placeholder="详细描述" autocomplete="off" class="layui-input">\
		    		</div>\
		    	</div>\
			    <div class="layui-form-item">\
	    		    <div class="layui-input-block">\
		    			<input type="text" name="price" required  lay-verify="required" placeholder="单价" autocomplete="off" class="layui-input">\
		    		</div>\
		    	</div>\
			    <div class="layui-form-item">\
	    		    <div class="layui-input-block">\
		    			<input type="text" name="stock" required  lay-verify="required" placeholder="库存" autocomplete="off" class="layui-input">\
		    		</div>\
		    	</div>\
			    <div class="layui-form-item">\
	    		    <div class="layui-input-block">\
		    			<input type="text" name="status" required  lay-verify="required" placeholder="状态" autocomplete="off" class="layui-input">\
		    		</div>\
			    </div>\
    		</form>'
		</script>