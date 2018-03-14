package cn.shop.wineshop.index.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.shop.wineshop.category.category.domain.Category;
import cn.shop.wineshop.category.category.service.CategoryService;
import cn.shop.wineshop.product.domain.Product;
import cn.shop.wineshop.product.service.ProductService;

public class IndexAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 注入一级分类的Service:
	private CategoryService categoryService;
	// 注入商品的Service
	private ProductService productService;

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	/**
	 * 执行的访问首页的方法:
	 */
	public String execute() {
		// 查询所有一级分类集合
		List<Category> cList = categoryService.finAllCatrgory();
		// 将一级分类存入到Session的范围:
		ActionContext.getContext().getSession().put("cList", cList);
		// 查询热门商品:
		List<Product> hList = productService.findHot();
		// 保存到值栈中:
		ActionContext.getContext().getValueStack().set("hList", hList);
		// 查询最新商品:
		List<Product> nList = productService.findNew();
		// 保存到值栈中:
		ActionContext.getContext().getValueStack().set("nList", nList);
		return "index";

	}

}
