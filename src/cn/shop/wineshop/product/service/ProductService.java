package cn.shop.wineshop.product.service;

import java.util.List;

import cn.shop.wineshop.product.domain.Product;
import cn.shop.wineshop.util.PageBean;

public interface ProductService {

	// ��ҳ��������Ʒ��ѯ
	public List<Product> findHot();

	// ��ҳ��������Ʒ�Ĳ�ѯ
	public List<Product> findNew();

	// ������ƷID��ѯ��Ʒ
	public Product findByPid(Integer pid);

	// ����һ�������cid���з�ҳ��ѯ��Ʒ
	public PageBean<Product> findByPageCid(Integer cid, int page);

	// ���ݶ��������ѯ��Ʒ��Ϣ
	public PageBean<Product> findByPageCsid(Integer csid, int page);

	// ��̨��ѯ������Ʒ����ҳ
	public PageBean<Product> findByPage(Integer page);

	// ҵ��㱣����Ʒ����:
	public void save(Product product);

	// ҵ���ɾ����Ʒ
	public void delete(Product product);

	// ҵ����޸���Ʒ�ķ���
	public void update(Product product);
}
