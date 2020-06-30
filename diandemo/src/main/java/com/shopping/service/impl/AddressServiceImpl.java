package com.shopping.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.shopping.common.Address;
import com.shopping.common.Goods;
import com.shopping.common.ServerResponse;
import com.shopping.dao.IAddressDao;
import com.shopping.dao.IGoodsDao;
import com.shopping.dao.impl.AddressDaoImpl;
import com.shopping.dao.impl.GoodsDaoImpl;
import com.shopping.service.IAddressService;
import com.shopping.vo.ProductListVO;

public class AddressServiceImpl implements IAddressService {

	IAddressDao addressDao=new AddressDaoImpl();
	public ServerResponse addLogic(Address address)
	{
		if(address==null)
		{
			return ServerResponse.serverResponseByError("参数错误");
		}
		if (addressDao.insert(address)) {
			Integer id=addressDao.selectIdByAll(address);
			Map<String, Integer>map=Maps.newHashMap();
			map.put("shippingId", id);
			return ServerResponse.serverResponseBySuccess(map);
			
		}
		else {
			return ServerResponse.serverResponseByError("添加失败");
		}
	}
	public ServerResponse delLogic(Integer id)
	{
		if(id==null)
		{
			return ServerResponse.serverResponseByError("参数错误");
		}
		if (addressDao.deleteByid(id)) {
			return ServerResponse.serverResponseBySuccess("删除成功");
			
		}
		else {
			return ServerResponse.serverResponseByError("删除失败");
		}
	}
	public ServerResponse selectLogic(Integer id)
	{
		if(id==null)
		{
			return ServerResponse.serverResponseByError("参数错误");
		}
		Address address=addressDao.selectByid(id);
		return ServerResponse.serverResponseBySuccess(address);
			
	
	}
	public ServerResponse updateLogic(Address address)
	{
		if(address==null)
		{
			return ServerResponse.serverResponseByError("参数错误");
		}
		if (addressDao.updateByid(address)) {
			return ServerResponse.serverResponseBySuccess("更新成功");
			
		}
		else {
			return ServerResponse.serverResponseByError("更新失败");
		}
	}
	 public ServerResponse listLogic(Integer id,int pageNum,int pageSize)
	 {
		   if(id==null)
			{
				return ServerResponse.serverResponseByError("参数错误");
			}
		   PageHelper.startPage(pageNum, pageSize);
		   List<Address> aList=addressDao.selectAllByUserId(id);
		   PageInfo pageInfo=new PageInfo(aList);
			  return ServerResponse.serverResponseBySuccess(pageInfo);
	
	 }
}
