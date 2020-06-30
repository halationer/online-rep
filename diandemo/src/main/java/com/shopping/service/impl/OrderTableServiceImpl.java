package com.shopping.service.impl;

import java.awt.Robot;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.shopping.common.CartOrderDetailVO;
import com.shopping.common.CartVO;
import com.shopping.common.Const;
import com.shopping.common.Goods;
import com.shopping.common.Order;
import com.shopping.common.OrderDetail;
import com.shopping.common.OrderDetailVO;
import com.shopping.common.OrderTable;
import com.shopping.common.OrderVO;
import com.shopping.common.ServerResponse;
import com.shopping.common.Shipping;
import com.shopping.common.ShippingVO;
import com.shopping.common.ShoppingCart;
import com.shopping.common.UserInfo;
import com.shopping.common.UserTable;
import com.shopping.common.VirtualPage;
import com.shopping.dao.IGoodsDao;
import com.shopping.dao.IOrderDetailDao;
import com.shopping.dao.IOrderTableDao;
import com.shopping.dao.IShippingDao;
import com.shopping.dao.IShoppingCartDao;
import com.shopping.dao.IUserDao;
import com.shopping.dao.impl.GoodsDaoImpl;
import com.shopping.dao.impl.OrderDetailDaoImpl;
import com.shopping.dao.impl.OrderTableDaoImpl;
import com.shopping.dao.impl.ShippingDaoImpl;
import com.shopping.dao.impl.ShoppingCartDaoImpl;
import com.shopping.dao.impl.UserDaoImpl;
import com.shopping.service.IOrderTableService;
import com.shopping.util.BigDecimalUtils;
import com.shopping.util.DateUtil;
import com.shopping.util.PropertiesUtil;
import com.shopping.vo.DetailVO;
import com.shopping.vo.OrderDetailListVO;
import com.shopping.vo.OrderListVO;
import com.shopping.vo.ProductListVO;

public class OrderTableServiceImpl implements IOrderTableService {
	IShoppingCartDao shoppingCartDao = new ShoppingCartDaoImpl();
	IGoodsDao goodsDao = new GoodsDaoImpl();
	IOrderTableDao orderTableDao = new OrderTableDaoImpl();
	IOrderDetailDao orderDetailDao = new OrderDetailDaoImpl();
	IShippingDao shippingDao = new ShippingDaoImpl();

	public ServerResponse createOrder(Integer userId, Integer shippingId) {
		// TODO Auto-generated method stub
		// 参数非空校验
		if (shippingId == null) {
			return ServerResponse.serverResponseByError("地址参数不能为空");
		}

		// 根据userid查询购物车中已选择的商品->List<Cart>
		List<ShoppingCart> cartList = shoppingCartDao.findCartListByUserIdAndChecked(userId);

		// List<Cart>-->List<OrderItem>
		ServerResponse serverResponse = getCartOrderItem(userId, cartList);
		if (!serverResponse.isSuccess()) {
			return serverResponse;
		}

		// 创建订单order并保存
		// 计算订单的价格
		BigDecimal orderTotalPrice = new BigDecimal(0);
		System.out.println(serverResponse.getData());
		System.out.println(456);
		List<OrderDetail> orderDetailList = (List<OrderDetail>) serverResponse.getData();

		if (orderDetailList == null || orderDetailList.size() == 0) {
			return ServerResponse.serverResponseByError("购物车为空");
		}
		orderTotalPrice = getOrderPrice(orderDetailList);

		OrderTable orderTable = createOrder(userId, shippingId, orderTotalPrice);
		if (orderTable == null) {
			return ServerResponse.serverResponseByError("订单创建失败");
		}
		// 将List<OrderItem>保存到数据库
		for (OrderDetail orderDetail : orderDetailList) {
			orderDetail.setOrder_no(orderTable.getOrder_no());
		}
		// 批量插入
		// orderDetailDao.insertBatch(orderDetailList);
		// 插入
		for (int i = 0; i < orderDetailList.size(); i++) {
			orderDetailDao.insert(orderDetailList.get(i));
		}
		orderDetailDao.insert(orderDetailList.get(0));
		// 扣库存
		reduceProductStock(orderDetailList);

		// 清空已经下单的商品
		clearCart(cartList);

		// 返回OrderVO
		OrderVO orderVO = assembleOrderVO(orderTable, orderDetailList, shippingId);
		return ServerResponse.serverResponseBySuccess(orderVO);
	}

	private OrderVO assembleOrderVO(OrderTable orderTable, List<OrderDetail> orderDetailList, Integer shippingId) {
		OrderVO orderVO = new OrderVO();
		List<OrderDetailVO> orderDetailVOList = new ArrayList();
		// orderVO.setOrderDetailVO(orderDetailVO);
		for (OrderDetail orderDetail : orderDetailList) {
			OrderDetailVO orderDetailVO = assembleOrderDetailVO(orderDetail);
			orderDetailVOList.add(orderDetailVO);
		}
		orderVO.setOrderDetailVO(orderDetailVOList);
		orderVO.setImageHost(PropertiesUtil.readByKey("imageHost"));
		Shipping shipping = shippingDao.selectByPrimaryKey(shippingId);

		if (shipping != null) {
			orderVO.setShippingId(shippingId);
			ShippingVO shippingVO = assembleShippingVO(shipping);
			orderVO.setReceiverName(shipping.getReceiverName());
		}
		orderVO.setStatus(orderTable.getStatus());
		// orderVO.setStatusDesc(orderTable.getStatus());
		Const.OrderStatusEnum orderStatusEnum = Const.OrderStatusEnum.codeOf(orderTable.getStatus());

		if (orderStatusEnum != null) {
			orderVO.setStatusDesc(orderTable.getStatus());
		}
		orderVO.setPostage(0);
		orderVO.setPayment(orderTable.getPayment());
		orderVO.setPaymentType(orderTable.getPaymentType());
		Const.PaymentEnum paymentEnum = Const.PaymentEnum.codeOf(orderTable.getStatus());
		if (paymentEnum != null) {
			orderVO.setPaymentTypeDesc(paymentEnum.getDesc());
		}
		orderVO.setOrderNo(orderTable.getOrder_no());

		return orderVO;
	}

	private ShippingVO assembleShippingVO(Shipping shipping) {
		ShippingVO shippingVO = new ShippingVO();
		if (shipping != null) {
			shippingVO.setReceiverAddress(shipping.getReceiverAddress());
			shippingVO.setReceiverCity(shipping.getReceiverCity());
			shippingVO.setReceiverDistrict(shipping.getReceiverDistrict());
			shippingVO.setReceiverMobile(shipping.getReceiverMobile());
			shippingVO.setReceiverName(shipping.getReceiverName());
			shippingVO.setReceiverPhone(shipping.getReceiverPhone());
			shippingVO.setReceiverProvince(shipping.getReceiverProvince());
			shippingVO.setReceiverZip(shipping.getReceiverZip());
		}
		return shippingVO;
	}

	// private OrderItemVO assembleOrderItemVO(OrderItem orderItem)
	private OrderDetailVO assembleOrderDetailVO(OrderDetail orderDetail) {
		OrderDetailVO orderDetailVO = new OrderDetailVO();
		if (orderDetail != null) {
			orderDetailVO.setQuantity(orderDetail.getQuantity());
			// System.out.println(123);
			Date date = new Date();
			System.out.println(date);
			// orderDetailVO.setCreateTime(DateUtil.dataToStr(orderDetail.getCreate_time()));
			orderDetailVO.setCreateTime(DateUtil.dataToStr(date));
			// Date date=new Date(2020-06-27 17:10:27);

//			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss SSS");
//
//		    Date date=new Date();
//
//			String dateStr=sdf.format(date);
//
//			System.out.println(dateStr);

//			orderDetailVO.setCreateTime(DateUtil.dataToStr(date));
			// System.out.println(456);
			orderDetailVO.setCurrentUnitPrice(orderDetail.getCurrent_unit_price());
			orderDetailVO.setProductImage(orderDetail.getProduct_image());
			orderDetailVO.setProductName(orderDetail.getProduct_name());
			orderDetailVO.setTotalPrice(orderDetail.getTotal_price());

		}
		return orderDetailVO;
	}

	// 清空已经下单的商品
	private void clearCart(List<ShoppingCart> cartList) {
		if (cartList != null && cartList.size() > 0) {
			// shoppingCartDao.batchDelete(cartList);

			// 未完成
		}

	}

	// 扣库存
	private void reduceProductStock(List<OrderDetail> orderDetailList) {
		if (orderDetailList != null || orderDetailList.size() > 0) {
			for (OrderDetail orderDetail : orderDetailList) {
				Integer productId = orderDetail.getProduct_id();
				Integer quantity = orderDetail.getQuantity();
				Goods goods = goodsDao.selectGoodsInfoById(productId);
				goods.setStock(goods.getStock() - quantity);
				goodsDao.updateById(goods);

			}
		}
	}

	// 计算订单的总价格
	private BigDecimal getOrderPrice(List<OrderDetail> orderDetailList) {
		BigDecimal bigDecimal = new BigDecimal(0);
//		if(orderDetailList==null||orderDetailList.size()==0) {
//			return ServerResponse.serverResponseByError("购物车为空");
//		}
		for (OrderDetail orderDetail : orderDetailList) {
			bigDecimal = BigDecimalUtils.add(bigDecimal.doubleValue(), orderDetail.getTotal_price().doubleValue());
		}

		return bigDecimal;
	}

	// 创建订单
	private OrderTable createOrder(Integer userId, Integer shippingId, BigDecimal orderTotalPrice) {
		OrderTable orderTable = new OrderTable();
		orderTable.setOrder_no(generateOrderNo());
		orderTable.setUser_id(userId);
		orderTable.setShopping_id(shippingId);
		orderTable.setStatus(Const.OrderStatusEnum.ORDER_UN_PAY.getCode());
		orderTable.setPayment(orderTotalPrice);// 订单金额
		orderTable.setPostage(BigDecimal.valueOf(0));
		orderTable.setPaymentType(Const.PaymentEnum.ONLINE.getCode());
		// System.err.println(orderTable);
		if (orderTableDao.insert(orderTable)) {
			return orderTable;
		}
		return null;
	}

	// 生成订单编号
	private Integer generateOrderNo() {

		return (int) (System.currentTimeMillis() % 10000000 + new Random().nextInt(100));
	}

	private ServerResponse getCartOrderItem(Integer userId, List<ShoppingCart> cartList) {// 购物车明细转订单明细
		if (cartList == null || cartList.size() == 0) {
			return ServerResponse.serverResponseByError("购物车空");
		}
		List<OrderDetail> orderItemList = new ArrayList();

		for (ShoppingCart cart : cartList) {
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setUser_id(userId);
			Goods goods = goodsDao.selectGoodsInfoById(cart.getProductId());
			if (goods == null) {
				return ServerResponse.serverResponseByError("商品id为" + cart.getProductId() + "的商品不存在");
			}
			if (goods.getStatus() == Const.ProductStatusEnum.PRODUCT_OFFLINE.getCode()) {// 商品下架
				return ServerResponse.serverResponseByError("id为" + goods.getId() + "的商品已经下架");
			}
			if (goods.getStock() < cart.getQuantity()) {// 库存不足
				return ServerResponse.serverResponseByError("id为" + goods.getId() + "的商品库存不足");
			}

			orderDetail.setQuantity(cart.getQuantity());
			orderDetail.setCurrent_unit_price(goods.getPrice());
			orderDetail.setProduct_id(goods.getId());
			orderDetail.setProduct_image(goods.getMain_image());
			orderDetail.setProduct_name(goods.getName());
			orderDetail.setTotal_price(
					BigDecimalUtils.mul(goods.getPrice().doubleValue(), cart.getQuantity().doubleValue()));

			orderItemList.add(orderDetail);
		}
		return ServerResponse.serverResponseBySuccess(orderItemList);
	}

	public ServerResponse get_order_cart_product(Integer userId) {
		// step1:查询购物车
		List<ShoppingCart> cartList = shoppingCartDao.findCartListByUserIdAndChecked(userId);
		// step2:List<Cart>-->List<OrderItem>
		ServerResponse serverResponse = getCartOrderItem(userId, cartList);
		if (!serverResponse.isSuccess()) {
			return serverResponse;
		}
		// step3:组装vo
		CartOrderDetailVO cartOrderDetailVO = new CartOrderDetailVO();
		cartOrderDetailVO.setImageHost(PropertiesUtil.readByKey("imageHost"));
		List<OrderDetail> orderDetailList = (List<OrderDetail>) serverResponse.getData();
		List<OrderDetailVO> orderDetailVOList = new ArrayList();
		if (orderDetailList == null || orderDetailList.size() == 0) {
			return ServerResponse.serverResponseByError("购物车空");
		}
		for (OrderDetail orderDetail : orderDetailList) {
			orderDetailVOList.add(assembleOrderDetailVO(orderDetail));
		}
		cartOrderDetailVO.setOrderItemVOList(orderDetailVOList);
		cartOrderDetailVO.setTotalPrice(getOrderPrice(orderDetailList));
		// cartOrderItemVO.setTotalPrice();
		// step4:返回结果
		return ServerResponse.serverResponseBySuccess(cartOrderDetailVO);
	}

	public ServerResponse list(Integer userId, Integer pageNum, Integer pageSize) {
		System.out.println("789");
		PageHelper.startPage(1, 20);
		System.out.println("7890");
		// System.out.println();
		List<OrderTable> orderList = new ArrayList();
		if (userId == null) {// 查询所有
			orderList = orderTableDao.mFindAllOrders();
		} else {// 查询当前用户
			orderList = orderTableDao.findOrderByUserid(userId);
		}
		System.out.println("12");
		for (OrderTable orderTable : orderList) {
			System.out.println(orderTable.toString());
		}

		if (orderList == null || orderList.size() == 0) {
			return ServerResponse.serverResponseByError("未查询到订单信息");
		}
		List<OrderVO> orderVOList = new ArrayList();
		for (OrderTable orderTable : orderList) {
			List<OrderDetail> orderItemList = orderDetailDao.findOrderDetailByOrderNo(orderTable.getOrder_no());
			OrderVO orderVO = assembleOrderVO(orderTable, orderItemList, orderTable.getShopping_id());
			orderVOList.add(orderVO);
		}

		PageInfo pageInfo = new PageInfo(orderVOList);
		return ServerResponse.serverResponseBySuccess(pageInfo);
	}

	// 取消订单
	public ServerResponse orderCancel(Integer userId, Integer orderNo) {
		// step1:参数非空校验
		if (orderNo == null) {
			return ServerResponse.serverResponseByError("参数不能为空");
		}
		// step2:根据userid和orderNO查询订单
		OrderTable orderTable = orderTableDao.findOrderTableByUserIdAndOrderNo(userId, orderNo);
		if (orderTable == null) {
			return ServerResponse.serverResponseByError("订单不存在");
		}
		// step3:判断订单状态并取消
		if (orderTable.getStatus() != Const.OrderStatusEnum.ORDER_UN_PAY.getCode()) {
			return ServerResponse.serverResponseByError("订单不可取消");
		}
		// step4:返回结果
		orderTable.setStatus(Const.OrderStatusEnum.ORDER_CANCELED.getCode());
		// int result=;
		if (orderTableDao.updateByPrimaryKey(orderTable)) {
			return ServerResponse.serverResponseBySuccess();
		}
		return ServerResponse.serverResponseByError("订单取消失败");
	}

	@Override
	public ServerResponse cancel(Integer userId, Long orderNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServerResponse detail(Long orderNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServerResponse pay(Integer userId, Long orderNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServerResponse alipay_callback(Map<String, String> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServerResponse query_order_pay_status(Long orderNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void closeOrder(String time) {
		// TODO Auto-generated method stub

	}

	@Override
	public ServerResponse mAllOrders(int pageNum, int pageSize) {
		
		List<OrderListVO> orderListVOList = new ArrayList<OrderListVO>();
		IOrderTableDao orderDao = new OrderTableDaoImpl();
		List<OrderTable> orderList = orderDao.mFindAllOrders();
		if (orderList!=null && orderList.size()>0) {
			for(OrderTable order : orderList) {
				OrderListVO orderListVO = fromOrderToOrderListVO(order);
				orderListVOList.add(orderListVO);
			}
		}
		ServerResponse<List<OrderListVO>> res= 
				ServerResponse.serverResponseBySuccess(orderListVOList);
		VirtualPage pageInfo = new VirtualPage(res, pageSize, pageNum);
		return ServerResponse.serverResponseBySuccess(pageInfo);
	}
	private OrderListVO fromOrderToOrderListVO(OrderTable order)
	{
		OrderListVO vo = new OrderListVO();
		vo.setOrderNo(order.getOrder_no());
		vo.setPayment(order.getPayment());
		vo.setPaymentType(order.getPaymentType());
		switch (vo.getPaymentType()) {
			case 0: vo.setPaymentTypeDesc("线下支付");break;
			case 1: vo.setPaymentTypeDesc("支付宝");break;
			case 2: vo.setPaymentTypeDesc("微信");break;
			default: vo.setPaymentTypeDesc("未知");break;
		}
		vo.setPostage(order.getPostage());
		vo.setStatus(order.getStatus());
		switch(vo.getStatus()) {
			case 0: vo.setStatusDesc("取消");break;
			case 1: vo.setStatusDesc("未付款");break;
			case 2: vo.setStatusDesc("已付款");break;
			case 3: vo.setStatusDesc("已发货");break;
			case 4: vo.setStatusDesc("交易成功");break;
			case 5: vo.setStatusDesc("关闭");break;
			default: vo.setStatusDesc("未知");break;
		}

		if(order.getCreate_time() != null)
			vo.setCreateTime(order.getCreate_time().toString().substring(0, 19));
		if(order.getPayment_time() != null)
			vo.setPaymentTime(order.getPayment_time().toString().substring(0,19));
		if(order.getSend_time() != null)
			vo.setSendTime(order.getSend_time().toString().substring(0,19));
		if(order.getEnd_time() != null)
			vo.setEndTime(order.getEnd_time().toString().substring(0,19));
		if(order.getClose_time() != null)
			vo.setCloseTime(order.getClose_time().toString().substring(0,19));
		return vo;
	}
	public ServerResponse mSearchDetailById(int pageNum, int pageSize, int orderNo)
	{
		IOrderTableDao orderDao = new OrderTableDaoImpl();
		IOrderDetailDao detailDao = new OrderDetailDaoImpl();
		IUserDao userDao = new UserDaoImpl();
		IShippingDao shippingDao = new ShippingDaoImpl();
		
		OrderDetailListVO detail = new OrderDetailListVO();
		
		//获取订单信息
		OrderTable order = orderDao.findOrderByOrderNo(orderNo);
		if(order == null || orderNo == 0)
			return ServerResponse.serverResponseByError("no such order");
		detail.setOrderlist(fromOrderToOrderListVO(order));
		
		//获取用户信息
		detail.setUsertable(userDao.getUser(order.getUser_id()));
		
		//获取商品信息
		List<DetailVO> detailvos = new ArrayList<DetailVO>();
		List<OrderDetail> orderdetails = detailDao.findOrderDetailByOrderNo(orderNo);
		if(orderdetails != null && orderdetails.size() > 0) {
			for(OrderDetail orderdetail : orderdetails) {
				DetailVO detailvo = fromDetailToVO(orderdetail);
				detailvos.add(detailvo);
			}
		}
		ServerResponse<List<DetailVO>> res= 
				ServerResponse.serverResponseBySuccess(detailvos);
		VirtualPage pageInfo = new VirtualPage(res, pageSize, pageNum);
		detail.setOrderitemvolist(pageInfo);
		
		//获取收货地址
		detail.setShipping(shippingDao.selectByPrimaryKey(order.getShopping_id()));
		System.out.println(detail.getShipping());
		
		return ServerResponse.serverResponseBySuccess(detail);
	}
	private DetailVO fromDetailToVO(OrderDetail orderdetail) {
		DetailVO detailvo = new DetailVO();
		detailvo.setProductId(orderdetail.getProduct_id());
		detailvo.setProductName(orderdetail.getProduct_name());
		detailvo.setProductImage(orderdetail.getProduct_image());
		detailvo.setCurrentUnitPrice(orderdetail.getCurrent_unit_price());
		detailvo.setQuantity(orderdetail.getQuantity());
		detailvo.setTotalPrice(orderdetail.getTotal_price());
		return detailvo;
	}
	public ServerResponse mSearchOrderById(int pageNum, int pageSize, int orderNo)
	{
		List<OrderListVO> orderListVOList = new ArrayList<OrderListVO>();
		IOrderTableDao orderDao = new OrderTableDaoImpl();
		OrderTable order = orderDao.findOrderByOrderNo(orderNo);
		if (order!=null) {
			OrderListVO orderListVO = fromOrderToOrderListVO(order);
			orderListVOList.add(orderListVO);
		}
		ServerResponse<List<OrderListVO>> res= 
				ServerResponse.serverResponseBySuccess(orderListVOList);
		VirtualPage pageInfo = new VirtualPage(res, pageSize, pageNum);
		return ServerResponse.serverResponseBySuccess(pageInfo);
	}
	public ServerResponse mSendGoods(Integer orderNo) {
		if(orderNo==null){
			return  ServerResponse.serverResponseByError("参数不能为空");
	    }
	    //step2:查询订单
	    OrderTable orderTable=orderTableDao.findOrderByOrderNo(orderNo);
	    if(orderTable==null){
	        return  ServerResponse.serverResponseByError("订单不存在");
	    }
	    //step3判断订单状态
	    if(!orderTableDao.mUpdateStatusByOrderNo(orderTable)) {
	    	return  ServerResponse.serverResponseByError("发货失败");
	    }
	        return ServerResponse.serverResponseBySuccess(null, "发货成功");
	 }
}
