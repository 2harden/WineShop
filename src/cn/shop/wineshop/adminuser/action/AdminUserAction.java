package cn.shop.wineshop.adminuser.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.shop.wineshop.adminuser.domain.AdminUser;
import cn.shop.wineshop.adminuser.service.AdminUserService;

public class AdminUserAction extends ActionSupport implements ModelDriven<AdminUser> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 模型驱动使用的对象
	private AdminUser adminUser = new AdminUser();

	public AdminUser getModel() {
		return adminUser;
	}

	// 注入AdminUserService
	private AdminUserService adminUserService;

	public void setAdminUserService(AdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}

	// 后台登录的执行的方法
	public String login() {
		// 调用service方法完成登录
		AdminUser existAdminUser = adminUserService.login(adminUser);
		// 判断
		if (existAdminUser == null) {
			// 用户名或密码错误
			this.addActionError("用户名或密码错误!");
			return "loginFail";
		} else {
			// 登录成功:
			ServletActionContext.getRequest().getSession().setAttribute("existAdminUser", existAdminUser);
			return "loginSuccess";
		}
	}



	public String quit() {
		// 销毁session
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit";
	}
}
