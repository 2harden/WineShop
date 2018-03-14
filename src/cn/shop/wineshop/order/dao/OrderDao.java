package cn.shop.wineshop.order.dao;

import java.util.List;

import cn.shop.wineshop.order.domain.Order;
import cn.shop.wineshop.order.domain.OrderItem;

public interface OrderDao {

	// Dao��ı��涩�������
	public void save(Order order);

	// Dao���ѯ�ҵĶ�����ҳ��ѯ:ͳ�Ƹ���
	public int findCountByUid(Integer uid);

	// Dao���ѯ�ҵĶ�����ҳ��ѯ:��ѯ����
	public List<Order> findPageByUid(Integer uid, int begin, int limit);

	// DAO����ݶ���id��ѯ����
	public Order findByOid(Integer oid);

	// DAO���޸Ķ����ķ���:
	public void update(Order currOrder);

	// DAO��ͳ�ƶ��������ķ���
	public int findCount();

	// DAO�з�ҳ��ѯ�����ķ���
	public List<Order> findByPage(int begin, int limit);

	// DAo�и��ݶ���id��ѯ������
	public List<OrderItem> findOrderItem(Integer oid);

}
