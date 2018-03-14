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
	// ģ������ʹ�õĶ���
	private AdminUser adminUser = new AdminUser();

	public AdminUser getModel() {
		return adminUser;
	}

	// ע��AdminUserService
	private AdminUserService adminUserService;

	public void setAdminUserService(AdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}

	// ��̨��¼��ִ�еķ���
	public String login() {
		// ����service������ɵ�¼
		AdminUser existAdminUser = adminUserService.login(adminUser);
		// �ж�
		if (existAdminUser == null) {
			// �û������������
			this.addActionError("�û������������!");
			return "loginFail";
		} else {
			// ��¼�ɹ�:
			ServletActionContext.getRequest().getSession().setAttribute("existAdminUser", existAdminUser);
			return "loginSuccess";
		}
	}



	public String quit() {
		// ����session
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit";
	}
}
