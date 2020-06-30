package com.shopping.service;

import org.springframework.web.multipart.MultipartFile;

//import org.springframework.web.multipart.MultipartFile;

import com.shopping.common.Goods;
import com.shopping.common.ServerResponse;

public interface IGoodsService {
	//public  ServerResponse detailLogic(Integer projectId);
	public  ServerResponse saveOrUpdateLogic(Goods goods);
	public ServerResponse set_sale_statusLogic(Integer id,Integer status);
	public ServerResponse detailLogic(Integer id);
	public ServerResponse detail(Integer id);
	public ServerResponse listLogic(int pageNum,int pageSize);
	public ServerResponse searchLogic(int productId,String productName,int pageNum,int pageSize);
	public ServerResponse uploadLogic(MultipartFile multipartFile,String path);
	public ServerResponse list(Integer categoryId ,String keyword,Integer pageNum,Integer pageSize,String oderBy);

	public ServerResponse mListLogic(int pageNum,int pageSize);
	public ServerResponse mSearchLogic(int productId,String productName,int pageNum,int pageSize);
}
