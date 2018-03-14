package cn.shop.wineshop.category.categorysecond.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.shop.wineshop.category.categorysecond.dao.CategorySecondDao;
import cn.shop.wineshop.category.categorysecond.domain.CategorySecond;
import cn.shop.wineshop.util.PageHibernateCallback;

public class CategorySecondDaoImpl extends HibernateDaoSupport implements CategorySecondDao {

	@Override
	public int findCount() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from CategorySecond";
		@SuppressWarnings("unchecked")
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	public List<CategorySecond> findByPage(int begin, int limit) {
		// TODO Auto-generated method stub
		String hql = "from CategorySecond order by csid desc";
		List<CategorySecond> list = this.getHibernateTemplate()
				.execute(new PageHibernateCallback<CategorySecond>(hql, null, begin, limit));
		return list;
	}

	@Override
	public void save(CategorySecond categorySecond) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(categorySecond);
	}

	@Override
	public void delete(CategorySecond categorySecond) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(categorySecond);
	}

	@Override
	public CategorySecond findByCsid(Integer csid) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(CategorySecond.class, csid);
	}

	@Override
	public void update(CategorySecond categorySecond) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(categorySecond);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CategorySecond> findAll() {
		// TODO Auto-generated method stub
		String hql = "from CategorySecond";
		return this.getHibernateTemplate().find(hql);
	}

}
