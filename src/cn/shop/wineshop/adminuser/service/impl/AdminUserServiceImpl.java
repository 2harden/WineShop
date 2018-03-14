package cn.shop.wineshop.adminuser.service.impl;

import org.springframework.transaction.annotation.Transactional;

import cn.shop.wineshop.adminuser.dao.AdminUserDao;
import cn.shop.wineshop.adminuser.domain.AdminUser;
import cn.shop.wineshop.adminuser.service.AdminUserService;
@Transactional
public class AdminUserServiceImpl implements AdminUserService {
	
	private AdminUserDao adminUserDao;

	public void setAdminUserDao(AdminUserDao adminUserDao) {
		this.adminUserDao = adminUserDao;
	}

	public AdminUser login(AdminUser adminUser) {
		return adminUserDao.login(adminUser);
	}
	
}
