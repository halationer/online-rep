package com.shopping.dao;

import java.util.List;

import com.shopping.common.Goods;

public interface IGoodsDao {
	public boolean insert (Goods goods) ;
	public boolean updateById(Goods goods);
	public boolean selectGoodsById(Integer id) ;
	public boolean updateStatusById(Integer id,Integer status) ;
	public Goods selectGoodsInfoById(Integer id) ;
	public List<Goods> queryGoodsByPage(int pageNum, int pageSize);
	public List<Goods> findGoodsByName(String productName,int pageNum, int pageSize);
	public List<Goods> selectGoodsByCategoryId(Integer categoryid);
	public List<Goods> selectGoodsByCategoryIdAndKeyword(Integer categoryid,String keyword);
	public List<Goods> findByName(String productName);
	
	public List<Goods> mFindAllGoods();
	public List<Goods> mFindGoodsByName(String productName);
}
