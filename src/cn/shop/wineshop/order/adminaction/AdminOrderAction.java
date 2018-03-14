package cn.shop.wineshop.order.adminaction;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.shop.wineshop.order.domain.Order;
import cn.shop.wineshop.order.domain.OrderItem;
import cn.shop.wineshop.order.service.OrderService;
import cn.shop.wineshop.util.PageBean;

public class AdminOrderAction extends ActionSupport implements ModelDriven<Order> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// ģ������ʹ�õ���
	private Order order = new Order();

	public Order getModel() {
		return order;
	}

	// ����page����
	private Integer page;

	public void setPage(Integer page) {
		this.page = page;
	}

	// ע��OrderService
	private OrderService orderService;

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	// �ṩ��̨��ѯ���ж����ķ���:
	public String findAll() {
		// �����ķ�ҳ��ѯ
		PageBean<Order> pageBean = orderService.findAll(page);
		// �����ݴ��뵽ֵջ�б��浽ҳ��
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		// ҳ����ת:
		return "findAll";
	}

	// �޸Ķ���״̬
	public String updateState() {
		// ����id��ѯ����
		Order currOrder = orderService.findByOid(order.getOid());
		currOrder.setState(3);
		orderService.update(currOrder);
		// ҳ����ת
		return "updateStateSuccess";
	}

	// ���ݶ�����id��ѯ������:
	public String findOrderItem() {
		// ���ݶ���id��ѯ������:
		List<OrderItem> list = orderService.findOrderItem(order.getOid());
		// ��ʾ��ҳ��:
		ActionContext.getContext().getValueStack().set("list", list);
		// ҳ����ת
		return "findOrderItem";
	}
}
