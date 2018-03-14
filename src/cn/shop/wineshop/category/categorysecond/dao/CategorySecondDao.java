package cn.shop.wineshop.category.categorysecond.dao;

import java.util.List;

import cn.shop.wineshop.category.categorysecond.domain.CategorySecond;

public interface CategorySecondDao {
	
	public int findCount();

	// DAO�з�ҳ��ѯ�ķ���
	public List<CategorySecond> findByPage(int begin, int limit);

	// DAO�еı����������ķ���
	public void save(CategorySecond categorySecond);

	// DAO�е�ɾ����������ķ���
	public void delete(CategorySecond categorySecond);

	// DAO�и���id��ѯ��������ķ���
	public CategorySecond findByCsid(Integer csid);

	// DAO�е��޸Ķ�������ķ���
	public void update(CategorySecond categorySecond);

	// DAO�еĲ�ѯ���ж�������ķ���
	public List<CategorySecond> findAll();

}
