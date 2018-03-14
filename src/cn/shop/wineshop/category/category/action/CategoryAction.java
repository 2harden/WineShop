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
	// ��װ����
	Category category = new Category();

	@Override
	public Category getModel() {
		// TODO Auto-generated method stub
		return this.category;
	}

	// ģ������ʹ�õĶ���.
	private CategoryService categoryService;

	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	// ����һ��Ŀ¼
	public String save() {
		this.categoryService.saveCatrgory(category);
		return "saveSuccess";

	}

	// �޸�һ��Ŀ¼
	public String update() {
		categoryService.updateCatrgory(category);
		return "updateSuccess";
	}

	// ɾ��
	public String delete() {
		// ͨ��һ�������Ų�ѯ
		category = categoryService.findCatrgoryById(category.getCid());
		// ɾ��һ��Ŀ¼
		categoryService.deleteCatrgory(category);
		return "deleteSuccess";
	}

	// ��ѯ����һ������
	public String findAll() {
		// ����Service��ѯ����һ������
		List<Category> cList = categoryService.finAllCatrgory();
		// ͨ��ֵջ����һ�����༯��:
		ActionContext.getContext().getValueStack().set("cList", cList);
		return "findAll";
	}

	// �༭һ������ķ���:
	public String edit() {
		// ����cid:
		// ����cid���в�ѯ:
		category = categoryService.findCatrgoryById(category.getCid());
		// ���ҳ��ת��:��һ������������ʾ��ҳ����.
		return "editSuccess";
	}

}
