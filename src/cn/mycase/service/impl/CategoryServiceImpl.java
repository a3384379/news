package cn.mycase.service.impl;

import java.util.List;

import cn.mycase.entity.Category;
import cn.mycase.mapper.CategoryMapper;

public class CategoryServiceImpl implements cn.mycase.service.CategoryService {
	private CategoryMapper categoryMapper;
	public void setCategoryMapper(CategoryMapper categoryMapper) {
		this.categoryMapper = categoryMapper;
	}


	@Override
	public List<Category> queryCategoryList() {
		return categoryMapper.queryCategoryList();
	}


	@Override
	public void addCategory(String cname) {
		categoryMapper.addCategory(cname);
	}


	@Override
	public void editCategory(Category category) {
		categoryMapper.editCategory(category);
	}


	@Override
	public Category queryByid(Integer cid) {
		return categoryMapper.queryByid(cid);
	}


	@Override
	public void deleteCategory(Integer cid) {
		categoryMapper.deleteCategory(cid);
	}

}
