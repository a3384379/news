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
	//��ѯ��𲢸��ݴ����urlת����ָ��ҳ��
	@RequestMapping(value="categoryList.action")
	public String categoryList(HttpServletRequest request, HttpServletResponse response,Map<String,Object> map) {
		List<Category> categoryList = service.queryCategoryList();
		map.put("categoryList", categoryList);
		return "forward:"+request.getParameter("url");
	}
	//��json��ʽ������ҳ�������
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
	//��ӷ���
	public String addCategory(String cname) {
		service.addCategory(cname);
		return "categoryList.action?url=admin/category/list.jsp";
	}
	
	@RequestMapping(value="editCategory.action")
	//�޸ķ���
	public String editCategory(Category category) {
		service.editCategory(category);
		return "categoryList.action?url=admin/category/list.jsp";
	}
	
	@RequestMapping(value="deleteCategory.action")
	//ɾ������
	public String deleteCategory(Integer cid) {
		service.deleteCategory(cid);
		return "categoryList.action?url=admin/category/list.jsp";
	}
	
	@RequestMapping(value="toedit.action")
	//��ת����༭ҳ��
	public String toedit(Integer cid,Map<String, Object> map,HttpServletRequest request, HttpServletResponse response) {
		Category category = service.queryByid(cid);
		map.put("cid", cid);
		map.put("cname",category.getCname());
		return "categoryList.action?url=admin/category/edit.jsp";
	}
	
	
	
}
