package cn.shop.wineshop.product.service.impl;

import java.util.List;

import cn.shop.wineshop.product.dao.ProductDao;

import cn.shop.wineshop.product.domain.Product;
import cn.shop.wineshop.product.service.ProductService;
import cn.shop.wineshop.util.PageBean;

public class ProductServiceImpl implements ProductService {
	// 注入ProductDao
	private ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public List<Product> findHot() {
		// TODO Auto-generated method stub
		return productDao.findHot();
	}

	@Override
	public List<Product> findNew() {
		// TODO Auto-generated method stub
		return productDao.findNew();
	}

	@Override
	public Product findByPid(Integer pid) {
		// TODO Auto-generated method stub
		return productDao.findById(pid);
	}

	@Override
	public PageBean<Product> findByPageCid(Integer cid, int page) {
		// TODO Auto-generated method stub
		PageBean<Product> pageBean = new PageBean<Product>();
		// 设置当前页数:
		pageBean.setPage(page);
		// 设置每页显示记录数:
		int limit = 12;
		pageBean.setLimit(limit);
		// 设置总记录数:
		int totalCount = 0;
		totalCount = productDao.findCountCid(cid);
		pageBean.setTotalCount(totalCount);
		// 设置总页数:
		int totalPage = 0;
		// Math.ceil(totalCount / limit);
		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;
		} else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 每页显示的数据集合:
		// 从哪开始:
		int begin = (page - 1) * limit;
		List<Product> list = productDao.findByPageCid(cid, begin, limit);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public PageBean<Product> findByPageCsid(Integer csid, int page) {
		// TODO Auto-generated method stub
		PageBean<Product> pageBean = new PageBean<Product>();
		// 设置当前页数:
		pageBean.setPage(page);
		// 设置每页显示记录数:
		int limit = 12;
		pageBean.setLimit(limit);
		// 设置总记录数:
		int totalCount = 0;
		totalCount = productDao.findCountCsid(csid);
		pageBean.setTotalCount(totalCount);
		// 设置总页数:
		int totalPage = 0;
		// Math.ceil(totalCount / limit);
		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;
		} else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 每页显示的数据集合:
		// 从哪开始:
		int begin = (page - 1) * limit;
		List<Product> list = productDao.findByPageCsid(csid, begin, limit);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public PageBean<Product> findByPage(Integer page) {
		// TODO Auto-generated method stub
		PageBean<Product> pageBean = new PageBean<Product>();
		// 设置当前页数:
		pageBean.setPage(page);
		// 设置每页显示记录数:
		int limit = 10;
		pageBean.setLimit(limit);
		// 设置总记录数:
		int totalCount = 0;
		totalCount = productDao.findCount();
		pageBean.setTotalCount(totalCount);
		// 设置总页数:
		int totalPage = 0;
		// Math.ceil(totalCount / limit);
		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;
		} else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 每页显示的数据集合:
		// 从哪开始:
		int begin = (page - 1) * limit;
		List<Product> list = productDao.findByPage(begin, limit);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public void save(Product product) {
		// TODO Auto-generated method stub
		productDao.save(product);
	}

	@Override
	public void delete(Product product) {
		// TODO Auto-generated method stub
		productDao.delete(product);
	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		productDao.update(product);
	}

}
