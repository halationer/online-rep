package com.shopping.dao;

import java.util.List;

import com.shopping.common.Address;
import com.shopping.common.Goods;

import sun.net.www.content.text.plain;

public interface IAddressDao {
	public boolean insert (Address address) ;
	public Integer selectIdByAll(Address address);
	public boolean deleteByid(Integer id) ;
	public boolean updateByid(Address address) ;
	public Address selectByid(Integer id) ;
	public List<Address> selectAllByUserId(Integer id);
	
}
