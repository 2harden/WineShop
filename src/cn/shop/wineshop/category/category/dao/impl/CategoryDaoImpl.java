package cn.shop.wineshop.category.category.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import cn.shop.wineshop.category.category.dao.CategoryDao;
import cn.shop.wineshop.category.category.domain.Category;

public class CategoryDaoImpl extends HibernateDaoSupport implements CategoryDao{

	public List<Category> findAll() {
		// TODO Auto-generated method stub
		String sql = "from Category";
		
		@SuppressWarnings("unchecked")
		List<Category> list = this.getHibernateTemplate().find(sql);
		return list;
		}

	@Override
	public Category findById(Integer cid) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Category.class, cid);
	}

	@Override
	public void save(Category category) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(category);
	}

	@Override
	public void update(Category category) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(category);
	}

	@Override
	public void delete(Category category) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(category);
	}

}
