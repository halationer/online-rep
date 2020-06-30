package com.shopping.service;

import java.util.Map;

import com.shopping.common.ServerResponse;

public interface IOrderService {
	public ServerResponse payLogic(Long orderNO);
	public ServerResponse alipay_callbackLogic(Map<String, String>map);
	public ServerResponse  query_order_pay_statusLogic(Long orderNo);
}
