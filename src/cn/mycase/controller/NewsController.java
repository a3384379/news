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
	
	//根据传入的url将news的数据传递
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
	
	
	//添加新闻
	@RequestMapping(value="addNews.action")
	public String addNews(News news) {
		newsService.addNews(news);
		return "showNewsList.action?url=admin/product/list.jsp";
	}
	
	//删除新闻
	@RequestMapping(value="deleteNewsById.action")
	public String deleteNewsById(Integer id) {
		newsService.deleteNewsById(id);
		return "showNewsList.action?url=admin/product/list.jsp";
	}
	//根据id查询新闻,并根据传入的url指定转发位置
	@RequestMapping(value="selectNewsById.action")
	public String selectNewsById(Integer id,HttpServletRequest request, HttpServletResponse response,Map<String,Object> map) {
		News news = newsService.selectNewsById(id);
		List<Comment> commentList = newsService.findComment();
		List<Category> categoryList = service.queryCategoryList();
		map.put("commentList", commentList);//所有评论
		map.put("categoryList", categoryList);//所有新闻类别
		map.put("news", news);//当前新闻所有信息
		return "forward:"+request.getParameter("url");
	}
	
	//根据id修改新闻
	@RequestMapping(value="updateNewsById.action")
	public String updateNewsById(News news) {
		newsService.updateNewsById(news);
		return "showNewsList.action?url=admin/product/list.jsp";
	}
	
	//根据关键词搜索
	@RequestMapping(value="searchResult.action")
	public String searchResult(String keyword,Map<String,Object> map) {
		List<News> searchResult = newsService.searchResult(keyword);
		map.put("searchResult", searchResult);
		map.put("keyword", keyword);
		return "result.jsp";
	}
	
	//分页查询
	@RequestMapping(value="findLimit.action")
	public String findLimit(PageBean<News> bean,HttpServletRequest request, HttpServletResponse response,Map<String,Object> map) {
		bean.setCurrentPage(Integer.valueOf(request.getParameter("index")));//当前页
		List<News> newsList = newsService.findLimit(bean);
		List<Category> categoryList = service.queryCategoryList();
		map.put("newsList", newsList);
		map.put("categoryList", categoryList);
		map.put("cid", request.getParameter("cid"));
		map.put("cname", request.getParameter("cname"));
		map.put("bean", bean);
		return "forward:"+request.getParameter("url");
	}
	
	//根据id更新新闻评论
	@RequestMapping(value="updateComment.action")
	public String updateComment(String test,Comment comment,HttpServletRequest request,Integer idnum) {
		String username=null;
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			//获取用户名
			if("username".equals(cookie.getName()) ) {
				username=cookie.getValue();
			}
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String format = df.format(new Date());// new Date()为获取当前系统时间
		comment.setUser(username);
		comment.setDate(format);
		newsService.saveComment(comment);
		return "redirect:selectNewsById.action?id="+comment.getNews_id()+"&url=news.jsp";
	}

}
