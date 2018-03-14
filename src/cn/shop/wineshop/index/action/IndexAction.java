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

	// ע��һ�������Service:
	private CategoryService categoryService;
	// ע����Ʒ��Service
	private ProductService productService;

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	/**
	 * ִ�еķ�����ҳ�ķ���:
	 */
	public String execute() {
		// ��ѯ����һ�����༯��
		List<Category> cList = categoryService.finAllCatrgory();
		// ��һ��������뵽Session�ķ�Χ:
		ActionContext.getContext().getSession().put("cList", cList);
		// ��ѯ������Ʒ:
		List<Product> hList = productService.findHot();
		// ���浽ֵջ��:
		ActionContext.getContext().getValueStack().set("hList", hList);
		// ��ѯ������Ʒ:
		List<Product> nList = productService.findNew();
		// ���浽ֵջ��:
		ActionContext.getContext().getValueStack().set("nList", nList);
		return "index";

	}

}
