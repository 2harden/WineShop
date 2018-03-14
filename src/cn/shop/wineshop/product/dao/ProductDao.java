package cn.shop.wineshop.product.dao;

import java.util.List;

import cn.shop.wineshop.product.domain.Product;

public interface ProductDao {
	public void save(Product product);

	public void update(Product product);

	public void delete(Product product);

	public Product findById(Integer pid);

	public List<Product> findHot();// 热门商品

	public List<Product> findNew();// 最新

	public int findCount();// 后台统计商品的方法

	public int findCountCid(Integer cid);// 一级分类商品个数

	public int findCountCsid(Integer csid);// 二级分类商品个数

	public List<Product> findByPage(int begin, int limit); // 后台查询所有商品的方法

	public List<Product> findByPageCid(Integer cid, int begin, int limit);

	public List<Product> findByPageCsid(Integer csid, int begin, int limit); // 根据二级分类查询商品信息

}
