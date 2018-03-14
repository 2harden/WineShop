package cn.shop.wineshop.category.categorysecond.service;

import java.util.List;

import cn.shop.wineshop.category.categorysecond.domain.CategorySecond;
import cn.shop.wineshop.util.PageBean;

public interface CategorySecondService {

	// 二级分类带有分页的查询操作:
	public PageBean<CategorySecond> findByPage(Integer page);

	// 业务层的保存二级分类的操作
	public void save(CategorySecond categorySecond);

	// 业务层的删除二级分类的操作
	public void delete(CategorySecond categorySecond);

	// 业务层根据id查询二级分类
	public CategorySecond findByCsid(Integer csid);

	// 业务层修改二级分类的方法
	public void update(CategorySecond categorySecond);

	// 业务层查询所有二级分类(不带分页)
	public List<CategorySecond> findAll();

}
