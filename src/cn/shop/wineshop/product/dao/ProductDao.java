package cn.shop.wineshop.product.dao;

import java.util.List;

import cn.shop.wineshop.product.domain.Product;

public interface ProductDao {
	public void save(Product product);

	public void update(Product product);

	public void delete(Product product);

	public Product findById(Integer pid);

	public List<Product> findHot();// ������Ʒ

	public List<Product> findNew();// ����

	public int findCount();// ��̨ͳ����Ʒ�ķ���

	public int findCountCid(Integer cid);// һ��������Ʒ����

	public int findCountCsid(Integer csid);// ����������Ʒ����

	public List<Product> findByPage(int begin, int limit); // ��̨��ѯ������Ʒ�ķ���

	public List<Product> findByPageCid(Integer cid, int begin, int limit);

	public List<Product> findByPageCsid(Integer csid, int begin, int limit); // ���ݶ��������ѯ��Ʒ��Ϣ

}
