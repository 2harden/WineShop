package cn.shop.wineshop.user.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.shop.wineshop.user.dao.UserDao;
import cn.shop.wineshop.user.domain.User;
import cn.shop.wineshop.user.service.UserService;
import cn.shop.wineshop.util.MailUitls;
import cn.shop.wineshop.util.PageBean;
import cn.shop.wineshop.util.UUIDUtils;

@Transactional
public class UserServiceImpl implements UserService {
	// ע��UserDao
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	
	// ���û�����ѯ�û��ķ���:
	public User findByUsername(String username){
		return userDao.findByUsername(username);
	}

	// ҵ�������û�ע�����:
	public void save(User user) {
		// �����ݴ��뵽���ݿ�
		user.setState(0); // 0:�����û�δ����.  1:�����û��Ѿ�����.
		String code = UUIDUtils.getUUID()+UUIDUtils.getUUID();
		user.setCode(code);
		userDao.save(user);
		// ���ͼ����ʼ�;
		MailUitls.sendMail(user.getEmail(), code);
	}

	// ҵ�����ݼ������ѯ�û�
	public User findByCode(String code) {
		return userDao.findByCode(code);
	}

	// �޸��û���״̬�ķ���
	public void update(User existUser) {
		userDao.update(existUser);
	}

	// �û���¼�ķ���
	public User login(User user) {
		return userDao.login(user);
	}

	// ҵ����û���ѯ����
	public PageBean<User> findByPage(Integer page) {
		PageBean<User> pageBean = new PageBean<User>();
		// ���õ�ǰҳ��:
		pageBean.setPage(page);
		// ����ÿҳ��ʾ��¼��:
		// ��ʾ5��
		int limit = 5;
		pageBean.setLimit(limit);
		// �����ܼ�¼��:
		int totalCount = 0;
		totalCount = userDao.findCount();
		pageBean.setTotalCount(totalCount);
		// ������ҳ��
		int totalPage = 0;
		if(totalCount % limit == 0){
			totalPage = totalCount / limit;
		}else{
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// ����ÿҳ��ʾ���ݼ���:
		int begin = (page - 1)*limit;
		List<User> list = userDao.findByPage(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}


	public User findByUid(Integer uid) {
		return userDao.findByUid(uid);
	}


	public void delete(User existUser) {
		userDao.delete(existUser);
	}
}
