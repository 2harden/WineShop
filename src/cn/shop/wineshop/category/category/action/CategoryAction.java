package cn.shop.wineshop.category.category.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.shop.wineshop.category.category.domain.Category;
import cn.shop.wineshop.category.category.service.CategoryService;

public class CategoryAction extends ActionSupport implements ModelDriven<Category> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 封装数据
	Category category = new Category();

	@Override
	public Category getModel() {
		// TODO Auto-generated method stub
		return this.category;
	}

	// 模型驱动使用的对象.
	private CategoryService categoryService;

	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	// 增加一级目录
	public String save() {
		this.categoryService.saveCatrgory(category);
		return "saveSuccess";

	}

	// 修改一级目录
	public String update() {
		categoryService.updateCatrgory(category);
		return "updateSuccess";
	}

	// 删除
	public String delete() {
		// 通过一级分类编号查询
		category = categoryService.findCatrgoryById(category.getCid());
		// 删除一级目录
		categoryService.deleteCatrgory(category);
		return "deleteSuccess";
	}

	// 查询所有一级分类
	public String findAll() {
		// 调用Service查询所有一级分类
		List<Category> cList = categoryService.finAllCatrgory();
		// 通过值栈保存一级分类集合:
		ActionContext.getContext().getValueStack().set("cList", cList);
		return "findAll";
	}

	// 编辑一级分类的方法:
	public String edit() {
		// 接收cid:
		// 根据cid进行查询:
		category = categoryService.findCatrgoryById(category.getCid());
		// 完成页面转向:将一级分类数据显示到页面上.
		return "editSuccess";
	}

}
