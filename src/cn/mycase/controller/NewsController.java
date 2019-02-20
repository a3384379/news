package cn.mycase.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.mycase.entity.Category;
import cn.mycase.entity.Comment;
import cn.mycase.entity.News;
import cn.mycase.entity.PageBean;
import cn.mycase.service.CategoryService;
import cn.mycase.service.NewsService;

@Controller
public class NewsController {
	@Autowired
	private NewsService newsService;
	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}
	
	@Autowired
	private CategoryService service;
	public void setService(CategoryService service) {
		this.service = service;
	}
	
	//���ݴ����url��news�����ݴ���
	@RequestMapping(value="showNewsList.action")
	public String showNewsList(HttpServletRequest request, HttpServletResponse response,Map<String,Object> map) {
		List<News> newsList = newsService.selectNewsList();
		List<Category> categoryList = service.queryCategoryList();
		map.put("newsList", newsList);
		map.put("categoryList", categoryList);
		map.put("cid", request.getParameter("cid"));
		map.put("cname", request.getParameter("cname"));
		return "forward:"+request.getParameter("url");
	}
	
	
	//�������
	@RequestMapping(value="addNews.action")
	public String addNews(News news) {
		newsService.addNews(news);
		return "showNewsList.action?url=admin/product/list.jsp";
	}
	
	//ɾ������
	@RequestMapping(value="deleteNewsById.action")
	public String deleteNewsById(Integer id) {
		newsService.deleteNewsById(id);
		return "showNewsList.action?url=admin/product/list.jsp";
	}
	//����id��ѯ����,�����ݴ����urlָ��ת��λ��
	@RequestMapping(value="selectNewsById.action")
	public String selectNewsById(Integer id,HttpServletRequest request, HttpServletResponse response,Map<String,Object> map) {
		News news = newsService.selectNewsById(id);
		List<Comment> commentList = newsService.findComment();
		List<Category> categoryList = service.queryCategoryList();
		map.put("commentList", commentList);//��������
		map.put("categoryList", categoryList);//�����������
		map.put("news", news);//��ǰ����������Ϣ
		return "forward:"+request.getParameter("url");
	}
	
	//����id�޸�����
	@RequestMapping(value="updateNewsById.action")
	public String updateNewsById(News news) {
		newsService.updateNewsById(news);
		return "showNewsList.action?url=admin/product/list.jsp";
	}
	
	//���ݹؼ�������
	@RequestMapping(value="searchResult.action")
	public String searchResult(String keyword,Map<String,Object> map) {
		List<News> searchResult = newsService.searchResult(keyword);
		map.put("searchResult", searchResult);
		map.put("keyword", keyword);
		return "result.jsp";
	}
	
	//��ҳ��ѯ
	@RequestMapping(value="findLimit.action")
	public String findLimit(PageBean<News> bean,HttpServletRequest request, HttpServletResponse response,Map<String,Object> map) {
		bean.setCurrentPage(Integer.valueOf(request.getParameter("index")));//��ǰҳ
		List<News> newsList = newsService.findLimit(bean);
		List<Category> categoryList = service.queryCategoryList();
		map.put("newsList", newsList);
		map.put("categoryList", categoryList);
		map.put("cid", request.getParameter("cid"));
		map.put("cname", request.getParameter("cname"));
		map.put("bean", bean);
		return "forward:"+request.getParameter("url");
	}
	
	//����id������������
	@RequestMapping(value="updateComment.action")
	public String updateComment(String test,Comment comment,HttpServletRequest request,Integer idnum) {
		String username=null;
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			//��ȡ�û���
			if("username".equals(cookie.getName()) ) {
				username=cookie.getValue();
			}
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
		String format = df.format(new Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��
		comment.setUser(username);
		comment.setDate(format);
		newsService.saveComment(comment);
		return "redirect:selectNewsById.action?id="+comment.getNews_id()+"&url=news.jsp";
	}

}
