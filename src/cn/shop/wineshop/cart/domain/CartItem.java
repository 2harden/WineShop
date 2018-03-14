package cn.shop.wineshop.cart.domain;

import cn.shop.wineshop.product.domain.Product;

public class CartItem {
	private Product product; // ����������Ʒ��Ϣ
	private int count; // ����ĳ����Ʒ����
	@SuppressWarnings("unused")
	private double subtotal; // ����ĳ����ƷС��

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	// С���Զ������.
	public double getSubtotal() {
		return count * product.getShop_price();
	}
	/*
	 * public void setSubtotal(double subtotal) { this.subtotal = subtotal; }
	 */

}
