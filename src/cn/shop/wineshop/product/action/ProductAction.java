package cn.shop.wineshop.product.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.shop.wineshop.category.category.service.CategoryService;
import cn.shop.wineshop.category.categorysecond.domain.CategorySecond;
import cn.shop.wineshop.category.categorysecond.service.CategorySecondService;
import cn.shop.wineshop.product.domain.Product;
import cn.shop.wineshop.product.service.ProductService;
import cn.shop.wineshop.util.PageBean;

public class ProductAction extends ActionSupport implements ModelDriven<Product> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// ���ڽ������ݵ�ģ������.
	private Product product = new Product();
	// ע����Ʒ��Service
	private ProductService productService;

	// ע��CategorySecondService
	private CategorySecondService categorySecondService;

	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}

	// ���շ���cid
	private Integer cid;
	// ���ն�������id
	private Integer csid;

	public Integer getCsid() {
		return csid;
	}

	public void setCsid(Integer csid) {
		this.csid = csid;
	}

	// ע��һ�������Service
	@SuppressWarnings("unused")
	private CategoryService categoryService;
	// ���յ�ǰҳ��:
	private int page;

	public void setPage(int page) {
		this.page = page;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getCid() {
		return cid;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public Product getModel() {
		return product;
	}

	// ������Ʒ��ID���в�ѯ��Ʒ:ִ�з���:
	public String findByPid() {
		// ����Service�ķ�����ɲ�ѯ.
		product = productService.findByPid(product.getPid());
		return "findByPid";
	}

	// ���ݷ����id��ѯ��Ʒ:
	public String findByCid() {
		// List<Category> cList = categoryService.findAll();
		PageBean<Product> pageBean = productService.findByPageCid(cid, page);// ����һ�������ѯ��Ʒ,����ҳ��ѯ
		// ��PageBean���뵽ֵջ��:
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByCid";
	}

	// ���ݶ�������id��ѯ��Ʒ:
	public String findByCsid() {
		// ���ݶ��������ѯ��Ʒ
		PageBean<Product> pageBean = productService.findByPageCsid(csid, page);
		// ��PageBean���뵽ֵջ��:
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByCsid";
	}

	// �ļ��ϴ���Ҫ����������:
	private File upload;
	private String uploadFileName;
	private String uploadContentType;

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	// ��ѯ���е���Ʒ:
	public String findAll() {
		PageBean<Product> pageBean = productService.findByPage(page);
		// ��PageBean���ݴ��뵽ֵջ��.
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		// ҳ����ת
		return "findAll";
	}

	// ��ת�����ҳ��ķ���:
	public String addPage() {
		// ��ѯ���еĶ�������:
		List<CategorySecond> csList = categorySecondService.findAll();
		// �����������������ʾ��ҳ����
		ActionContext.getContext().getValueStack().set("csList", csList);
		// ҳ����ת
		return "addPageSuccess";
	}

	// ������Ʒ�ķ���:
	public String save() throws IOException {
		// ���ύ��������ӵ����ݿ���.
		product.setPdate(new Date());
		// product.setImage(image);
		if (upload != null) {
			// ����ƷͼƬ�ϴ�����������.
			// ����ϴ�ͼƬ�ķ�������·��.
			String path = ServletActionContext.getServletContext().getRealPath("/products");
			// �����ļ����Ͷ���:
			File diskFile = new File(path + "//" + uploadFileName);
			// �ļ��ϴ�:
			FileUtils.copyFile(upload, diskFile);

			product.setImage("products/" + uploadFileName);
		}
		productService.save(product);
		return "saveSuccess";
	}

	// ɾ����Ʒ�ķ���:
	public String delete() {
		// ����id��ѯ��Ʒ��Ϣ
		product = productService.findByPid(product.getPid());
		// ɾ����Ʒ��ͼƬ:
		String path = ServletActionContext.getServletContext().getRealPath("/" + product.getImage());
		File file = new File(path);
		file.delete();
		// ɾ�����ݿ�����Ʒ��¼:
		productService.delete(product);
		// ҳ����ת
		return "deleteSuccess";
	}

	// �༭��Ʒ�ķ���
	public String edit() {
		// ������Ʒid��ѯ��Ʒ��Ϣ
		product = productService.findByPid(product.getPid());
		// ��ѯ���ж�������
		List<CategorySecond> csList = categorySecondService.findAll();
		ActionContext.getContext().getValueStack().set("csList", csList);
		// ҳ����ת���༭ҳ��:
		return "editSuccess";
	}

	// �޸���Ʒ�ķ���
	public String update() throws IOException {
		// ����Ϣ�޸ĵ����ݿ�
		product.setPdate(new Date());

		// �ϴ�:
		if (upload != null) {
			String delPath = ServletActionContext.getServletContext().getRealPath("/" + product.getImage());
			File file = new File(delPath);
			file.delete();
			// ����ϴ�ͼƬ�ķ�������·��.
			String path = ServletActionContext.getServletContext().getRealPath("/products");
			// �����ļ����Ͷ���:
			File diskFile = new File(path + "//" + uploadFileName);
			// �ļ��ϴ�:
			FileUtils.copyFile(upload, diskFile);

			product.setImage("products/" + uploadFileName);
		}
		productService.update(product);
		// ҳ����ת
		return "updateSuccess";
	}

}
