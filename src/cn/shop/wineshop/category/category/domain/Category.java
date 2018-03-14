package cn.shop.wineshop.category.category.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import cn.shop.wineshop.category.categorysecond.domain.CategorySecond;

public class Category implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer cid;
	private String cname;
	// 一级分类中存放二级分类的集合:
	private Set<CategorySecond> categorySeconds = new HashSet<CategorySecond>();
	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Set<CategorySecond> getCategorySeconds() {
		return categorySeconds;
	}
	public void setCategorySeconds(Set<CategorySecond> categorySeconds) {
		this.categorySeconds = categorySeconds;
	}
	
}
