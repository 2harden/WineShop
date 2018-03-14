package cn.shop.wineshop.category.categorysecond.service.impl;

import java.util.List;

import cn.shop.wineshop.category.categorysecond.dao.CategorySecondDao;
import cn.shop.wineshop.category.categorysecond.domain.CategorySecond;
import cn.shop.wineshop.category.categorysecond.service.CategorySecondService;
import cn.shop.wineshop.util.PageBean;

public class CategorySecondServiceImpl implements CategorySecondService {
	// 注入Dao
	private CategorySecondDao categorySecondDao;

	public void setCategorySecondDao(CategorySecondDao categorySecondDao) {
		this.categorySecondDao = categorySecondDao;
	}

	@Override
	public PageBean<CategorySecond> findByPage(Integer page) {
		// TODO Auto-generated method stub
		PageBean<CategorySecond> pageBean = new PageBean<CategorySecond>();

		// 设置参数:
		pageBean.setPage(page);
		// 设置每页显示记录数:
		int limit = 10;
		pageBean.setLimit(limit);
		// 设置总记录数:
		int totalCount = categorySecondDao.findCount();
		pageBean.setTotalCount(totalCount);
		// 设置总页数:
		int totalPage = 0;
		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;
		} else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 设置页面显示数据的集合:
		int begin = (page - 1) * limit;
		List<CategorySecond> list = categorySecondDao.findByPage(begin, limit);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public void save(CategorySecond categorySecond) {
		// TODO Auto-generated method stub
		categorySecondDao.save(categorySecond);
	}

	@Override
	public void delete(CategorySecond categorySecond) {
		// TODO Auto-generated method stub
		categorySecondDao.delete(categorySecond);
	}

	@Override
	public CategorySecond findByCsid(Integer csid) {
		// TODO Auto-generated method stub
		return categorySecondDao.findByCsid(csid);
	}

	@Override
	public void update(CategorySecond categorySecond) {
		// TODO Auto-generated method stub
		categorySecondDao.update(categorySecond);
	}

	@Override
	public List<CategorySecond> findAll() {
		// TODO Auto-generated method stub
		return categorySecondDao.findAll();
	}

}
