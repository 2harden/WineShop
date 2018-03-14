package cn.shop.wineshop.category.category.service.impl;

import java.util.List;

import cn.shop.wineshop.category.category.dao.CategoryDao;
import cn.shop.wineshop.category.category.domain.Category;
import cn.shop.wineshop.category.category.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

	// “¿¿µ◊¢»Î
	private CategoryDao categoryDao;

	public CategoryDao getCategoryDao() {
		return categoryDao;
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	public List<Category> finAllCatrgory() {
		// TODO Auto-generated method stub
		return this.categoryDao.findAll();
	}

	public Category findCatrgoryById(Integer cid) {
		// TODO Auto-generated method stub
		return this.categoryDao.findById(cid);
	}

	public void saveCatrgory(Category category) {
		// TODO Auto-generated method stub
		this.categoryDao.save(category);
	}

	public void updateCatrgory(Category category) {
		// TODO Auto-generated method stub
		this.categoryDao.update(category);
	}

	public void deleteCatrgory(Category category) {
		// TODO Auto-generated method stub
		this.categoryDao.delete(category);
	}
}
