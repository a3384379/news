package cn.mycase.service;

import java.util.List;

import cn.mycase.entity.Category;

public interface CategoryService {
	public List<Category> queryCategoryList();

	public void addCategory(String cname);

	public void editCategory(Category category);
	
	public Category queryByid(Integer cid);

	public void deleteCategory(Integer cid);
}
