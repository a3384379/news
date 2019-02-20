package cn.mycase.service;

import java.util.List;

import cn.mycase.entity.Comment;
import cn.mycase.entity.News;
import cn.mycase.entity.PageBean;

public interface NewsService {
	void addNews(News news);
	List<News> selectNewsList();
	void deleteNewsById(Integer id);
	News selectNewsById(Integer id);
	void updateNewsById(News news);
	List<News> searchResult(String keyword);
	List<News> findLimit(PageBean<News> bean);
	void saveComment(Comment comment);//添加评论
	List<Comment> findComment();//所有评论
}
