package cn.mycase.mapper;

import java.util.List;

import cn.mycase.entity.Category;

public interface CategoryMapper {
	public List<Category> queryCategoryList();
	
	public Category queryByid(Integer cid);

	public void addCategory(String cname);

	public void editCategory(Category category);
	
	public void deleteCategory(Integer cid);
	
	
}
