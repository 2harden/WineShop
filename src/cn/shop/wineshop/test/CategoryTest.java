package cn.shop.wineshop.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.shop.wineshop.category.category.domain.Category;
import cn.shop.wineshop.category.category.service.CategoryService;

public class CategoryTest {
	@Test
	public void categoryfinall(){
		String xmlpath = "applicationContext.xml";
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlpath);
		CategoryService categoryService = (CategoryService) applicationContext.getBean("categoryService"); 
		List<Category> list = categoryService.finAllCatrgory();
		for (Category category : list) {
			System.out.println(category);
		}
	}
	@Test
	public void save(){
		String xmlpath = "applicationContext.xml";
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlpath);
		CategoryService categoryService = (CategoryService) applicationContext.getBean("categoryService",CategoryService.class);
		Category category = new Category();
		category.setCname("фоля╬ф");
		categoryService.saveCatrgory(category);
	}
	@Test
	public void update(){
		String xmlpath = "applicationContext.xml";
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlpath);
		CategoryService categoryService = (CategoryService) applicationContext.getBean("categoryService",CategoryService.class);
		Category category = new Category();
		category.setCname("фоля╬ф");
		categoryService.saveCatrgory(category);
	}
}
