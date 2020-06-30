package com.shopping.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.shopping.common.CartProductVoList;
import com.shopping.common.CartVO;
import com.shopping.common.Const;
import com.shopping.common.Goods;
import com.shopping.common.ResponseCode;
import com.shopping.common.ServerResponse;
import com.shopping.common.ShoppingCart;
import com.shopping.common.UserInfo;
import com.shopping.dao.IGoodsDao;
import com.shopping.dao.IShoppingCartDao;
import com.shopping.dao.IUserDao;
import com.shopping.dao.impl.GoodsDaoImpl;
import com.shopping.dao.impl.ShoppingCartDaoImpl;
import com.shopping.dao.impl.UserDaoImpl;
import com.shopping.service.IShoppingCartService;
import com.shopping.util.BigDecimalUtils;
import com.shopping.util.DateUtil;

public class ShoppingCartService implements IShoppingCartService{
	IUserDao userDao=new UserDaoImpl();
	IShoppingCartDao shoppingCartDao=new ShoppingCartDaoImpl();
	IGoodsDao goodsDao=new GoodsDaoImpl();
	@Override
	public ServerResponse ShoppingCartList(Integer userId) {
		// TODO Auto-generated method stub
		IShoppingCartDao shoppingCartDao=new ShoppingCartDaoImpl();
		if(userId==null) {
			return ServerResponse.serverResponseByError(10,"用户未登录，请登录");
		}
		//List<ShoppingCart> ShoppingCartList=shoppingCartDao.ShoppingCartList(userId);
		//ShoppingCart cart=shoppingCartDao.selectCartByUserIdAndPrductId(userId,productId);
	    //List<CartVO> cartVO=
		ShoppingCart shoppingCart=shoppingCartDao.ShoppingCartVO(userId);
		CartVO cartVO=getCartVOLimit(userId);
		return ServerResponse.serverResponseBySuccess(cartVO);	
		//return ServerResponse.serverResponseBySuccess(ShoppingCartList);
	}
	public ServerResponse ShoppingCartAdd(Integer userId,Integer productId,Integer count) {
		// TODO Auto-generated method stub
		//参数非空校验
		IShoppingCartDao shoppingCartDao=new ShoppingCartDaoImpl();
		ShoppingCart shoppingCart=null;
		if(productId==null||count==null) {
			return ServerResponse.serverResponseByError("参数不能为空");
		}
		if(userId==null){
			return ServerResponse.serverResponseByError(10,"用户未登录，请登录");
		}
		//ShoppingCart cart=shoppingCartDao.selectCartByUserIdAndPrductId(userId,productId);
		ShoppingCart cart1=new ShoppingCart();
		//cart1.setId(cart.getId());
		cart1.setUser_id(userId);
		cart1.setProductId(productId);
		cart1.setQuantity(count);
		//cart1.setId(11);//让其自加
		cart1.setChecked(Const.CartCheckedEnum.PRODUCT_CHECKED.getCode());
		shoppingCartDao.ShoppingCartAdd(cart1);
		
		CartVO cartVO=getCartVOLimit(cart1.getUser_id());
		return ServerResponse.serverResponseBySuccess(cartVO);
		
//		//根据信息查询购物信息
//		ShoppingCart cart=shoppingCartDao.selectCartByUserIdAndPrductId(userId,productId);
//		if(cart==null) {//添加
//			ShoppingCart cart1=new ShoppingCart();
//			cart1.setId(cart.getId());
//			cart1.setUser_id(userId);
//			cart1.setProductId(productId);
//			cart1.setQuantity(count);
//			cart1.setChecked(Const.CartCheckedEnum.PRODUCT_CHECKED.getCode());
//			shoppingCartDao.insert(cart1);
//		}else {//更新
//			ShoppingCart cart1=new ShoppingCart();
//			cart1.setId(cart.getId());
//			cart1.setUser_id(userId);
//			cart1.setProductId(productId);
//			cart1.setQuantity(count);
//			cart1.setChecked(cart.getChecked());
//			shoppingCartDao.updateByPrimaryKey(cart1);//未完成
//		}
//		CartVO CartVO=getCartVOLimit(userId);
//		return ServerResponse.serverResponseBySuccess(CartVO);
	}
	
	private CartVO getCartVOLimit(Integer userid) {
		CartVO cartVO=new CartVO();
		//根据userid查询购物信息->得到List<cart>
		//List<CartProductVoList> cartList=new List<CartProductVoList>();
		
		List<ShoppingCart>cartList=shoppingCartDao.selectCartByUserid(userid);
		List<CartProductVoList> cartProductVoList=new ArrayList();
		
		BigDecimal carttotalprice=new BigDecimal("0");//购物车总价格
		if(cartList!=null&&cartList.size()>0) {
			for(ShoppingCart cart:cartList) {
				CartProductVoList cart1=new CartProductVoList();
				//CartVO carVO=new CartVO();
				cart1.setId(cart.getId());
				cart1.setQuantity(cart.getQuantity());
				cart1.setUser_id(userid);
				cart1.setProductChecked(cart.getChecked());
				//查询商品
				Goods goods=goodsDao.selectGoodsInfoById(cart.getProductId());
				if(goods!=null) {
					cart1.setProduct_id(cart.getProductId());
					cart1.setProductMainImage(goods.getMain_image());
					cart1.setProductName(goods.getName());
					cart1.setProductPrice(goods.getPrice());
					cart1.setProductStatus(goods.getStatus());
					cart1.setProductStock(goods.getStock());
					cart1.setProductSubtitle(goods.getSubtile());
					int stock=goods.getStock();
					int limitGoodCount=0;
					if(stock>cart.getQuantity()) {
						limitGoodCount=cart.getQuantity();
						cart1.setLimitQuantity("LIMIT_NUM_SUCCESS");
					}else {//商品库存不足
						//更新购物车中商品的数量
						ShoppingCart cart2=new ShoppingCart();
						cart2.setId(cart.getId());
						cart2.setQuantity(stock);
						cart2.setProductId(cart.getProductId());
						cart2.setChecked(cart.getChecked());
						cart2.setUser_id(userid);
						shoppingCartDao.updateByPrimaryKey(cart2);
						
						cart1.setLimitQuantity("LIMIT_NUM_FAIL");
					}
					cart1.setQuantity(limitGoodCount);
					cart1.setProductTotalPrice(BigDecimalUtils.mul(goods.getPrice().doubleValue(),Double.valueOf(cart1.getQuantity())));
					
				}
				
				carttotalprice=BigDecimalUtils.add(carttotalprice.doubleValue(),cart1.getProductTotalPrice().doubleValue());
				cartProductVoList.add(cart1);
			}
		}
		cartVO.setCartProductVoList(cartProductVoList);
		//计算总价格
		cartVO.seticarttotalprice(carttotalprice);
		
		//判断购物车是否全选
		//int count=shoppingCartDao.isCheckedAll(userid);
		if(shoppingCartDao.isCheckedAll(userid)) {
			cartVO.setisallchecked(false);
		}else {
			cartVO.setisallchecked(true);
		}
		//返回结果
		return cartVO;
	}
	
	public ServerResponse ShoppingCartUpdate(Integer userId,Integer productId,Integer count) {//更新购物车
		// TODO Auto-generated method stub
		if(productId==null||count==null) {
			return ServerResponse.serverResponseByError("参数不能为空");
		}
		if(userId==null){
			return ServerResponse.serverResponseByError(10,"用户未登录，请登录");
		}
		ShoppingCart cart1=new ShoppingCart();
		ShoppingCart cart=shoppingCartDao.selectCartByUserIdAndPrductId(userId,productId);
		cart1.setId(cart.getId());
		cart1.setUser_id(userId);
		cart1.setProductId(productId);
		cart1.setQuantity(count);
		cart1.setChecked(cart.getChecked());
		shoppingCartDao.updateByPrimaryKey(cart1);
		CartVO cartVO=getCartVOLimit(userId);
		return ServerResponse.serverResponseBySuccess(cartVO);	
		
	}

	public ServerResponse ShoppingCartRemove(Integer userId,Integer productId) {
		// TODO Auto-generated method stub
		
		if(productId==null) {
			return ServerResponse.serverResponseByError("参数不能为空");
		}
		if(userId==null){
			return ServerResponse.serverResponseByError(10,"用户未登录，请登录");
		}
		ShoppingCart cart1=new ShoppingCart();
		ShoppingCart cart=shoppingCartDao.selectCartByUserIdAndPrductId(userId,productId);
		cart1.setId(cart.getId());
		cart1.setUser_id(userId);
		cart1.setProductId(productId);
		Integer count = 1;
		cart1.setQuantity(count);
		cart1.setChecked(cart.getChecked());
		shoppingCartDao.deleteByPrimaryKey(cart1);
		CartVO cartVO=getCartVOLimit(userId);
		return ServerResponse.serverResponseBySuccess(cartVO);	
		
	}

	public ServerResponse ShoppingCartSelectOne(Integer userId,Integer productId) {
		// TODO Auto-generated method stub
		IShoppingCartDao shoppingCartDao=new ShoppingCartDaoImpl();
		if(productId==null) {
			return ServerResponse.serverResponseByError("参数不能为空");
		}
		if(userId==null){
			return ServerResponse.serverResponseByError(10,"用户未登录，请登录");
		}
		//ShoppingCartDao 
		return ServerResponse.serverResponseBySuccess();
		//return null;
	}

	public ServerResponse ShoppingCartQueryNumber(Integer userId) {
		// TODO Auto-generated method stub
		if(userId==null){
			return ServerResponse.serverResponseByError(10,"用户未登录，请登录");
		}
		Integer quantity = shoppingCartDao.getShoppingCartQuantity(userId);
		return ServerResponse.serverResponseBySuccess(quantity);
		
	}

	public ServerResponse ShoppingCartSelectAll(Integer userid) {//判断购物车是否全选
		// TODO Auto-generated method stub
		if(userid==null){
			return ServerResponse.serverResponseByError(10,"用户未登录，请登录");
		}
		CartVO cartVO=new CartVO();
		//int count=shoppingCartDao.isCheckedAll(userid);
		if(shoppingCartDao.isCheckedAll(userid)) {
			cartVO.setisallchecked(false);
		}else {
			cartVO.setisallchecked(true);
		}
		return ServerResponse.serverResponseBySuccess(cartVO);
	}

	public ServerResponse ShoppingCartCancelSelectAll(Integer userid) {//取消全选
		// TODO Auto-generated method stub
		if(userid==null){
			return ServerResponse.serverResponseByError(10,"用户未登录，请登录");
		}
		CartVO cartVO=new CartVO();
		shoppingCartDao.isCancelCheckedAll(userid);
		if(!shoppingCartDao.isCheckedAll(userid)) {
			cartVO.setisallchecked(false);
		}else {
			cartVO.setisallchecked(true);
		}
		return ServerResponse.serverResponseBySuccess(cartVO);
	}

	
	
public ServerResponse ShoppingCartRemoveById(Integer id) {
		
		ShoppingCart cart1=new ShoppingCart();
		ShoppingCart cart=new ShoppingCart();
		cart1.setId(id);
		//cart.id=cart1.setId(id);
		boolean flagTest=shoppingCartDao.deleteById(cart1);
		System.out.println(flagTest);
				
		CartVO cartVO=getCartVOLimit(cart1.getId());
		return ServerResponse.serverResponseBySuccess(cartVO);	
	}

	
}
