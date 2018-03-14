package cn.shop.wineshop.user.service;

import cn.shop.wineshop.user.domain.User;
import cn.shop.wineshop.util.PageBean;

public interface UserService {

	// ���û�����ѯ�û��ķ���:
	public User findByUsername(String username);

	// ҵ�������û�ע�����:
	public void save(User user);

	// ҵ�����ݼ������ѯ�û�
	public User findByCode(String code);

	// �޸��û���״̬�ķ���
	public void update(User existUser);

	// �û���¼�ķ���
	public User login(User user);

	// ҵ����û���ѯ����
	public PageBean<User> findByPage(Integer page);

	public User findByUid(Integer uid);

	public void delete(User existUser);
}
