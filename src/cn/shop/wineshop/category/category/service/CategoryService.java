package cn.shop.wineshop.category.category.service;

import java.util.List;

import cn.shop.wineshop.category.category.domain.Category;

public interface CategoryService {
	public List<Category> finAllCatrgory();
	public Category findCatrgoryById(Integer cid);
	public void saveCatrgory(Category category);
	public void updateCatrgory(Category category);
	public void deleteCatrgory(Category category);
}
