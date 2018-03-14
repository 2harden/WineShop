package cn.shop.wineshop.product.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.shop.wineshop.product.dao.ProductDao;
import cn.shop.wineshop.product.domain.Product;
import cn.shop.wineshop.util.PageHibernateCallback;

public class ProductDaoImpl extends HibernateDaoSupport implements ProductDao {

	@Override
	public void save(Product product) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(product);
	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(product);
	}

	@Override
	public void delete(Product product) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(product);
	}

	@Override
	public Product findById(Integer pid) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Product.class, pid);
	}

	@Override
	public List<Product> findHot() {
		// TODO Auto-generated method stub
		// 使用离线条件查询.
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		// 查询热门的商品,条件就是is_host = 1
		criteria.add(Restrictions.eq("is_hot", 1));
		// 倒序排序输出:
		criteria.addOrder(Order.desc("pdate"));
		// 执行查询:
		@SuppressWarnings("unchecked")
		List<Product> list = this.getHibernateTemplate().findByCriteria(criteria, 0, 10);
		return list;
	}

	@Override
	public List<Product> findNew() {
		// TODO Auto-generated method stub
		// 使用离线条件查询:
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		// 按日期进行倒序排序:
		criteria.addOrder(Order.desc("pdate"));
		// 执行查询:
		@SuppressWarnings("unchecked")
		List<Product> list = this.getHibernateTemplate().findByCriteria(criteria, 0, 10);
		return list;
	}

	@Override
	public int findCountCid(Integer cid) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Product p where p.categorySecond.category.cid = ?";
		@SuppressWarnings("unchecked")
		List<Long> list = this.getHibernateTemplate().find(hql, cid);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	public List<Product> findByPageCid(Integer cid, int begin, int limit) {
		// TODO Auto-generated method stub
		String hql = "select p from Product p join p.categorySecond cs join cs.category c where c.cid = ?";
		// 分页另一种写法:
		List<Product> list = this.getHibernateTemplate()
				.execute(new PageHibernateCallback<Product>(hql, new Object[] { cid }, begin, limit));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	@Override
	public int findCountCsid(Integer csid) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Product p where p.categorySecond.csid = ?";
		@SuppressWarnings("unchecked")
		List<Long> list = this.getHibernateTemplate().find(hql, csid);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	public List<Product> findByPage(int begin, int limit) {
		// TODO Auto-generated method stub
		String hql = "from Product order by pdate desc";
		List<Product> list = this.getHibernateTemplate()
				.execute(new PageHibernateCallback<Product>(hql, null, begin, limit));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	@Override
	public int findCount() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Product";
		@SuppressWarnings("unchecked")
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	public List<Product> findByPageCsid(Integer csid, int begin, int limit) {
		// TODO Auto-generated method stub
		String hql = "select p from Product p join p.categorySecond cs where cs.csid = ?";
		List<Product> list = this.getHibernateTemplate()
				.execute(new PageHibernateCallback<Product>(hql, new Object[] { csid }, begin, limit));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

}
