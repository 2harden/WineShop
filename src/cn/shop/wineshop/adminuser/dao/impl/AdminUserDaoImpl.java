package cn.shop.wineshop.adminuser.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.shop.wineshop.adminuser.dao.AdminUserDao;
import cn.shop.wineshop.adminuser.domain.AdminUser;

public class AdminUserDaoImpl extends HibernateDaoSupport implements AdminUserDao {

	public AdminUser login(AdminUser adminUser) {
		String hql = "from AdminUser where username = ? and password = ?";
		@SuppressWarnings("unchecked")
		List<AdminUser> list = this.getHibernateTemplate().find(hql, adminUser.getUsername(), adminUser.getPassword());
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
}
