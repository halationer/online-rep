package com.shopping.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

//import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shopping.common.Category;
import com.shopping.common.Const;
import com.shopping.common.Goods;
import com.shopping.common.ServerResponse;
import com.shopping.common.VirtualPage;
import com.shopping.dao.ICategoryDao;
import com.shopping.dao.IGoodsDao;
import com.shopping.dao.impl.CategoryDaoImpl;
import com.shopping.dao.impl.GoodsDaoImpl;
import com.shopping.service.IGoodsService;
import com.shopping.vo.ProductDetailVO;
import com.shopping.vo.ProductListVO;

public class GoodsServiceImpl implements IGoodsService 
{
	public  ServerResponse saveOrUpdateLogic(Goods goods)
	{
		IGoodsDao goodsDao=new GoodsDaoImpl();
		if (goods==null)
		{
			return ServerResponse.serverResponseByError("参数为空");
			
		}
		String subImage=goods.getSub_image();
		if (subImage!=null&&!subImage.equals(""))
		{
			String [] subImageArr=subImage.split(",");
//			if (subImageArr.length>0) 
//			{
//				goods.setMain_image(subImageArr[0]);
//			}
		}
		if (goods.getId()==null) 
		{
			if (goodsDao.insert(goods))
			{
				return ServerResponse.serverResponseBySuccess(null,"添加成功");
			}
			else
			{
				return ServerResponse.serverResponseByError("添加失败");
			}
		}
		else 
		{
			if (goodsDao.updateById(goods))
			{
				return ServerResponse.serverResponseBySuccess(null, "更新成功");
			}
			else 
			{
				return ServerResponse.serverResponseByError("更新失败");
			}
		}
	}
	public ServerResponse set_sale_statusLogic(Integer id,Integer status)
	{
		IGoodsDao goodsDao=new GoodsDaoImpl();
		if (id==null)
		{
			return ServerResponse.serverResponseByError("商品id不能为空");
			
		}
		if (status==null)
		{
			return ServerResponse.serverResponseByError("商品状态不能为空");
			
		}
		if (goodsDao.selectGoodsById(id)) {
			if (goodsDao.updateStatusById(id, status)) {
				return ServerResponse.serverResponseBySuccess(null, "更新成功");
				
			}
			else {
				return ServerResponse.serverResponseByError("更新失败");
			}
		}
		return ServerResponse.serverResponseByError("不存在");
		
		
		
	}
	public ServerResponse detailLogic(Integer id)
	{
		IGoodsDao goodsDao=new GoodsDaoImpl();
		if (id==null)
		{
			return ServerResponse.serverResponseByError("商品id不能为空");
			
		}
		
		Goods goods=goodsDao.selectGoodsInfoById(id);
		if (goods==null) {
			return ServerResponse.serverResponseByError("商品不存在");
		}
		ProductDetailVO productDetailVO=assembleProductDetailVO(goods);
		return ServerResponse.serverResponseBySuccess(productDetailVO);
		
	}
	private ProductDetailVO assembleProductDetailVO( Goods goods) 
	{
		ProductDetailVO productDetailVO=new ProductDetailVO();
		productDetailVO.setCategoryId(goods.getCategory_id());
		productDetailVO.setCreateTime(goods.getCreat_time().toString().substring(0, 19));
		productDetailVO.setDetail(goods.getDetail());
		productDetailVO.setImageHost("http://locahost:8080");
		productDetailVO.setId(goods.getId());
		productDetailVO.setMainImage(goods.getMain_image());
		productDetailVO.setName(goods.getName());
		productDetailVO.setPrice(goods.getPrice());
		productDetailVO.setStatus(goods.getStatus());
		productDetailVO.setStock(goods.getStock());
		productDetailVO.setSubImages(goods.getSub_image());
		productDetailVO.setSubtitle(goods.getSubtile());
		productDetailVO.setUpdateTime(goods.getUpdate_time().toString().substring(0, 19));
		ICategoryDao categoryDao= new CategoryDaoImpl();
		Category category=categoryDao.selectByPrimaryKey(goods.getCategory_id());
		if (category!=null) {
			productDetailVO.setParentCategoryId(category.getParentId());
		}
		else {
			productDetailVO.setParentCategoryId(0);
		}
		return productDetailVO;
	}
	public ServerResponse listLogic(int pageNum,int pageSize) {
		return ServerResponse.serverResponseByError();
	}
	private ProductListVO assembleProductListVO( Goods goods) 
	{
		ProductListVO productListVO=new ProductListVO();
		productListVO.setCategoryId(goods.getCategory_id());
		productListVO.setId(goods.getId());
		productListVO.setMainImage(goods.getMain_image());
		productListVO.setName(goods.getName());
		productListVO.setPrice(goods.getPrice());
		productListVO.setStatus(goods.getStatus());
		productListVO.setSubtitle(goods.getSubtile());
		return productListVO;
	}
	public ServerResponse searchLogic(int productId,String productName,int pageNum,int pageSize)
	{
		List<ProductListVO> productListVOList=new ArrayList<ProductListVO>();
		Goods good;
		IGoodsDao goodsDao=new GoodsDaoImpl();
		if (productId>0) {
			 good=goodsDao.selectGoodsInfoById(productId);
			 ProductListVO productListVO=assembleProductListVO(good);//?
			 productListVOList.add(productListVO);

		}
		else if(productName!=null&&!productName.equals("")) {
			productName="%"+productName+"%";
			List<Goods> goodsList=goodsDao.findGoodsByName(productName,pageNum, pageSize);
			if (goodsList!=null&&goodsList.size()>0) {
				for(Goods goods:goodsList) {
					ProductListVO productListVO=assembleProductListVO(goods);//?
					productListVOList.add(productListVO);
				}
			}
		}
		else {
			List<Goods> goodsList=goodsDao.queryGoodsByPage(pageNum, pageSize);
			if (goodsList!=null&&goodsList.size()>0) {
				for(Goods goods:goodsList) {
					ProductListVO productListVO=assembleProductListVO(goods);//?
					productListVOList.add(productListVO);
				}
			}
			
		}
		 PageInfo pageInfo=new PageInfo(productListVOList);
		 return ServerResponse.serverResponseBySuccess(pageInfo);
		
	}
	public ServerResponse uploadLogic(MultipartFile multipartFile,String path)
	{
		if (multipartFile==null) {
			return ServerResponse.serverResponseByError("no file");
			
		}
		String originalFileName=multipartFile.getOriginalFilename();
		String exName=originalFileName.substring(originalFileName.lastIndexOf("."));
		String newFileName=UUID.randomUUID().toString()+exName;
		File pathFile=new File(path);
		if (!pathFile.exists()) {
			pathFile.setWritable(true);
			pathFile.mkdirs();
			
		}
		File file1=new File(path,newFileName);
		try {
			multipartFile.transferTo(file1);
			return ServerResponse.serverResponseBySuccess("/upload"+"/"+newFileName);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	public ServerResponse detail(Integer id)
	{
		IGoodsDao goodsDao=new GoodsDaoImpl();
		if (id==null)
		{
			return ServerResponse.serverResponseByError("商品id不能为空");
			
		}
		
		Goods goods=goodsDao.selectGoodsInfoById(id);
		if (goods==null) {
			return ServerResponse.serverResponseByError("商品不存在");
		}
		if (goods.getStatus()!=Const.GoodsStatusEnum.GOODS_ONLINE.getCode()) {
			return ServerResponse.serverResponseByError("商品下架或删除");
		}
		ProductDetailVO productDetailVO=assembleProductDetailVO(goods);
		return ServerResponse.serverResponseBySuccess(productDetailVO);
		
	}
	public ServerResponse list(Integer categoryId ,String keyword,Integer pageNum,Integer pageSize,String orderBy)
	{
		List<ProductListVO> productListVOList=new ArrayList<ProductListVO>();//?
		List<Goods> goodsList=new ArrayList<Goods>();
		PageInfo pageInfo;
		ICategoryDao categoryDao=new CategoryDaoImpl();
		IGoodsDao goodsDao=new GoodsDaoImpl();
		if (orderBy.equals("")) {
			PageHelper.startPage(pageNum, pageSize);
		}
		else {
			String [] orderByArr=orderBy.split("_");
			if (orderByArr.length>1) {
				String order=orderByArr[0]+" "+orderByArr[1];
				PageHelper.startPage(pageNum, pageSize,order);
			}
			else {
				PageHelper.startPage(pageNum,pageSize);
			}
		}
		if (categoryId==null&&(keyword==null||keyword.equals(""))) {
			return ServerResponse.serverResponseByError("参数错误");
		}
		if(categoryId!=null)
		{
			Category category=categoryDao.selectByPrimaryKey(categoryId);
			if (category==null&&(keyword==null||keyword.equals(""))) 
			{
				pageInfo=new PageInfo(productListVOList);
				return ServerResponse.serverResponseBySuccess(pageInfo);
			}
			if (keyword==null||keyword.equals("")) {
				
			   goodsList=goodsDao.selectGoodsByCategoryId(categoryId);
			}
			if (keyword!=null||!keyword.equals("")){
				keyword="%"+keyword+"%";
			    goodsList=goodsDao.selectGoodsByCategoryIdAndKeyword(categoryId, keyword);
			}
		}
		else if (keyword!=null&&!keyword.equals("")) 
		{
			keyword="%"+keyword+"%";
			 goodsList=goodsDao.findByName(keyword);
			
		}
		if (goodsList!=null&&goodsList.size()>0) {
			for(Goods goods:goodsList) {
				ProductListVO productListVO=assembleProductListVO(goods);//?
				productListVOList.add(productListVO);
			}
		}
		pageInfo=new PageInfo(productListVOList);
		return ServerResponse.serverResponseBySuccess(pageInfo);
	}

	public ServerResponse mListLogic(int pageNum,int pageSize)
	{
		//pageHelper
		List<ProductListVO> productListVOList=new ArrayList<ProductListVO>();
		IGoodsDao goodsDao=new GoodsDaoImpl();
		List<Goods> goodsList=goodsDao.mFindAllGoods();
		if (goodsList!=null&&goodsList.size()>0) {
			for(Goods goods:goodsList) {
				ProductListVO productListVO=assembleProductListVO(goods);//?
				productListVOList.add(productListVO);
			}
		}
		ServerResponse<List<ProductListVO>> res= 
				ServerResponse.serverResponseBySuccess(productListVOList);
		VirtualPage pageInfo = new VirtualPage(res, pageSize, pageNum);
		return ServerResponse.serverResponseBySuccess(pageInfo);
	}
	public ServerResponse mSearchLogic(int productId,String productName,int pageNum,int pageSize)
	{
		List<ProductListVO> productListVOList=new ArrayList<ProductListVO>();
		Goods good;
		IGoodsDao goodsDao=new GoodsDaoImpl();
		if (productId>0) {
			System.out.println("id search");
			good=goodsDao.selectGoodsInfoById(productId);
			ProductListVO productListVO=assembleProductListVO(good);//?
			productListVOList.add(productListVO);
		}
		else if(productName!=null&&!productName.equals("")) {
			System.out.println("product search");
			productName="%"+productName+"%";
			List<Goods> goodsList=goodsDao.mFindGoodsByName(productName);
			if (goodsList!=null&&goodsList.size()>0) {
				for(Goods goods:goodsList) {
					ProductListVO productListVO=assembleProductListVO(goods);//?
					productListVOList.add(productListVO);
				}
			}
		}
		else {
			System.out.println("all search");
			List<Goods> goodsList=goodsDao.mFindAllGoods();
			if (goodsList!=null&&goodsList.size()>0) {
				for(Goods goods:goodsList) {
					ProductListVO productListVO=assembleProductListVO(goods);//?
					productListVOList.add(productListVO);
				}
			}
			
		}
		ServerResponse<List<ProductListVO>> res= 
				ServerResponse.serverResponseBySuccess(productListVOList);
		VirtualPage pageInfo = new VirtualPage(res, pageSize, pageNum);
		return ServerResponse.serverResponseBySuccess(pageInfo);
	}
}

