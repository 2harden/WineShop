package cn.shop.wineshop.category.categorysecond.service;

import java.util.List;

import cn.shop.wineshop.category.categorysecond.domain.CategorySecond;
import cn.shop.wineshop.util.PageBean;

public interface CategorySecondService {

	// ����������з�ҳ�Ĳ�ѯ����:
	public PageBean<CategorySecond> findByPage(Integer page);

	// ҵ���ı����������Ĳ���
	public void save(CategorySecond categorySecond);

	// ҵ����ɾ����������Ĳ���
	public void delete(CategorySecond categorySecond);

	// ҵ������id��ѯ��������
	public CategorySecond findByCsid(Integer csid);

	// ҵ����޸Ķ�������ķ���
	public void update(CategorySecond categorySecond);

	// ҵ����ѯ���ж�������(������ҳ)
	public List<CategorySecond> findAll();

}
