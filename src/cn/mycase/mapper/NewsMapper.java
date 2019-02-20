package cn.mycase.mapper;

import java.util.List;

import cn.mycase.entity.Comment;
import cn.mycase.entity.News;
import cn.mycase.entity.PageBean;

public interface NewsMapper {
	void addNews(News news);//添加
	List<News> selectNewsList();//查询所有
	void deleteNewsById(Integer id);//根据id删除
	News selectNewsById(Integer id);//根据id查询
	void updateNewsById(News news);//更新新闻
	List<News> searchResult(String keyword);//关键词搜索
	List<News> findLimit(PageBean<News> bean);//分页查询
	Integer newsCount(Integer cid);//新闻数量
	void saveComment(Comment comment);//添加评论
	List<Comment> findComment();//所有评论
}
