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
	// 用于接收数据的模型驱动.
	private Product product = new Product();
	// 注入商品的Service
	private ProductService productService;

	// 注入CategorySecondService
	private CategorySecondService categorySecondService;

	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}

	// 接收分类cid
	private Integer cid;
	// 接收二级分类id
	private Integer csid;

	public Integer getCsid() {
		return csid;
	}

	public void setCsid(Integer csid) {
		this.csid = csid;
	}

	// 注入一级分类的Service
	@SuppressWarnings("unused")
	private CategoryService categoryService;
	// 接收当前页数:
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

	// 根据商品的ID进行查询商品:执行方法:
	public String findByPid() {
		// 调用Service的方法完成查询.
		product = productService.findByPid(product.getPid());
		return "findByPid";
	}

	// 根据分类的id查询商品:
	public String findByCid() {
		// List<Category> cList = categoryService.findAll();
		PageBean<Product> pageBean = productService.findByPageCid(cid, page);// 根据一级分类查询商品,带分页查询
		// 将PageBean存入到值栈中:
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByCid";
	}

	// 根据二级分类id查询商品:
	public String findByCsid() {
		// 根据二级分类查询商品
		PageBean<Product> pageBean = productService.findByPageCsid(csid, page);
		// 将PageBean存入到值栈中:
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByCsid";
	}

	// 文件上传需要的三个属性:
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

	// 查询所有的商品:
	public String findAll() {
		PageBean<Product> pageBean = productService.findByPage(page);
		// 将PageBean数据存入到值栈中.
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		// 页面跳转
		return "findAll";
	}

	// 跳转到添加页面的方法:
	public String addPage() {
		// 查询所有的二级分类:
		List<CategorySecond> csList = categorySecondService.findAll();
		// 将二级分类的数据显示到页面上
		ActionContext.getContext().getValueStack().set("csList", csList);
		// 页面跳转
		return "addPageSuccess";
	}

	// 保存商品的方法:
	public String save() throws IOException {
		// 将提交的数据添加到数据库中.
		product.setPdate(new Date());
		// product.setImage(image);
		if (upload != null) {
			// 将商品图片上传到服务器上.
			// 获得上传图片的服务器端路径.
			String path = ServletActionContext.getServletContext().getRealPath("/products");
			// 创建文件类型对象:
			File diskFile = new File(path + "//" + uploadFileName);
			// 文件上传:
			FileUtils.copyFile(upload, diskFile);

			product.setImage("products/" + uploadFileName);
		}
		productService.save(product);
		return "saveSuccess";
	}

	// 删除商品的方法:
	public String delete() {
		// 根据id查询商品信息
		product = productService.findByPid(product.getPid());
		// 删除商品的图片:
		String path = ServletActionContext.getServletContext().getRealPath("/" + product.getImage());
		File file = new File(path);
		file.delete();
		// 删除数据库中商品记录:
		productService.delete(product);
		// 页面跳转
		return "deleteSuccess";
	}

	// 编辑商品的方法
	public String edit() {
		// 根据商品id查询商品信息
		product = productService.findByPid(product.getPid());
		// 查询所有二级分类
		List<CategorySecond> csList = categorySecondService.findAll();
		ActionContext.getContext().getValueStack().set("csList", csList);
		// 页面跳转到编辑页面:
		return "editSuccess";
	}

	// 修改商品的方法
	public String update() throws IOException {
		// 将信息修改到数据库
		product.setPdate(new Date());

		// 上传:
		if (upload != null) {
			String delPath = ServletActionContext.getServletContext().getRealPath("/" + product.getImage());
			File file = new File(delPath);
			file.delete();
			// 获得上传图片的服务器端路径.
			String path = ServletActionContext.getServletContext().getRealPath("/products");
			// 创建文件类型对象:
			File diskFile = new File(path + "//" + uploadFileName);
			// 文件上传:
			FileUtils.copyFile(upload, diskFile);

			product.setImage("products/" + uploadFileName);
		}
		productService.update(product);
		// 页面跳转
		return "updateSuccess";
	}

}
