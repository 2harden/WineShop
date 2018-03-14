package cn.shop.wineshop.category.category.dao;

import java.util.List;

import cn.shop.wineshop.category.category.domain.Category;

public interface CategoryDao {
	public List<Category> findAll();
	public Category findById(Integer cid);
	public void save(Category categery);
	public void update(Category categery);
	public void delete(Category categery);
}
