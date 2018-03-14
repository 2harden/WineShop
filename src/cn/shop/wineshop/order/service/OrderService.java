package cn.shop.wineshop.order.service;

import java.util.List;

import cn.shop.wineshop.order.domain.Order;
import cn.shop.wineshop.order.domain.OrderItem;
import cn.shop.wineshop.util.PageBean;

public interface OrderService {

	// ҵ��㱣�涩���ķ���
	public void save(Order order);

	// ҵ�������û�id��ѯ����,����ҳ��ѯ.
	public PageBean<Order> findByUid(Integer uid, Integer page);

	// ���ݶ���id��ѯ����
	public Order findByOid(Integer oid);

	// ҵ����޸Ķ����ķ���:
	public void update(Order currOrder);

	// ҵ����ѯ���ж�������
	public PageBean<Order> findAll(Integer page);

	// ҵ����ѯ������ķ���
	public List<OrderItem> findOrderItem(Integer oid);

}
