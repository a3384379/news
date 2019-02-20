package cn.mycase.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

import cn.mycase.entity.Category;
import cn.mycase.service.CategoryService;

@Controller
public class CategoryController {
	@Autowired
	private CategoryService service;
	public void setService(CategoryService service) {
		this.service = service;
	}
	//查询类别并根据传入的url转发到指定页面
	@RequestMapping(value="categoryList.action")
	public String categoryList(HttpServletRequest request, HttpServletResponse response,Map<String,Object> map) {
		List<Category> categoryList = service.queryCategoryList();
		map.put("categoryList", categoryList);
		return "forward:"+request.getParameter("url");
	}
	//以json格式返回首页新闻类别
	@RequestMapping(value="categoryListJson.action")
	public void categoryListJson(HttpServletRequest request, HttpServletResponse response,Map<String,Object> map) {
		List<Category> categoryList = service.queryCategoryList();
		Gson gson=new Gson();
		String json = gson.toJson(categoryList);
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="addCategory.action")
	//添加分类
	public String addCategory(String cname) {
		service.addCategory(cname);
		return "categoryList.action?url=admin/category/list.jsp";
	}
	
	@RequestMapping(value="editCategory.action")
	//修改分类
	public String editCategory(Category category) {
		service.editCategory(category);
		return "categoryList.action?url=admin/category/list.jsp";
	}
	
	@RequestMapping(value="deleteCategory.action")
	//删除分类
	public String deleteCategory(Integer cid) {
		service.deleteCategory(cid);
		return "categoryList.action?url=admin/category/list.jsp";
	}
	
	@RequestMapping(value="toedit.action")
	//跳转分类编辑页面
	public String toedit(Integer cid,Map<String, Object> map,HttpServletRequest request, HttpServletResponse response) {
		Category category = service.queryByid(cid);
		map.put("cid", cid);
		map.put("cname",category.getCname());
		return "categoryList.action?url=admin/category/edit.jsp";
	}
	
	
	
}
