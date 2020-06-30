package com.shopping.service;

import java.util.Map;

import javax.imageio.spi.ServiceRegistry;

import com.shopping.common.OrderDetail;
import com.shopping.common.ServerResponse;

public interface IOrderTableService {
	 /**
     * 创建订单
     * */
    public ServerResponse createOrder(Integer userId,Integer shippingId);

    /**
     * 取消订单
     *
     */
   public ServerResponse cancel(Integer userId,Long orderNo);
   /**
    * 获取购物车中订单明细
    * */
   public ServerResponse get_order_cart_product(Integer userId);
   /**
    * 订单列表
    * */
   public ServerResponse list(Integer userId,Integer pageNum,Integer pageSize);
   /**
    * 订单详情
    * */
   public ServerResponse detail(Long orderNo);
   /**
    *
    * 支付接口
    * */
   public ServerResponse pay(Integer userId,Long orderNo);

   /**
    *
    * 支付宝回调接口
    * */
   public ServerResponse alipay_callback(Map<String,String> map);
    /**
     *
     * 查询订单的支付状态
     * */
   public ServerResponse  query_order_pay_status(Long orderNo);


  /**
   * 根据创建时间查询订单
   * */
   public void closeOrder(String time);
   
   public ServerResponse orderCancel(Integer userId, Integer orderNo) ;
  
   //所有订单
   public ServerResponse mAllOrders(int pageNum, int pageSize);
   public ServerResponse mSearchOrderById(int pageNum, int pageSize, int orderNo);
   public ServerResponse mSearchDetailById(int pageNum, int pageSize, int orderNo);
   public ServerResponse mSendGoods(Integer orderNo);
}
