package cn.shop.wineshop.user.dao;

import java.util.List;

import cn.shop.wineshop.user.domain.User;

public interface UserDao {

	// �����β�ѯ�Ƿ��и��û�:
	public User findByUsername(String username);

	// ע���û��������ݿ����ʵ��
	public void save(User user);

	// ���ݼ������ѯ�û�
	public User findByCode(String code);

	// �޸��û�״̬�ķ���
	public void update(User existUser);

	// �û���¼�ķ���
	public User login(User user);

	public int findCount();

	public List<User> findByPage(int begin, int limit);

	public User findByUid(Integer uid);

	public void delete(User existUser);

}
