package cn.mycase.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.mycase.entity.Comment;
import cn.mycase.entity.News;
import cn.mycase.entity.PageBean;
import cn.mycase.mapper.NewsMapper;
import cn.mycase.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService {
	@Autowired
	private NewsMapper newsMapper;
	public void setNewsMapper(NewsMapper newsMapper) {
		this.newsMapper = newsMapper;
	}

	@Override
	public void addNews(News news) {
		//内容不为空才能添加
		if(news.getTitle()!=null&&news.getTest()!=null&&news.getTitle()!=""&&news.getTest()!="") {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String format = df.format(new Date());// new Date()为获取当前系统时间
		news.setDate(format);
		newsMapper.addNews(news);
		}
	}

	@Override
	public List<News> selectNewsList() {
		return newsMapper.selectNewsList();
	}

	@Override
	public void deleteNewsById(Integer id) {
		newsMapper.deleteNewsById(id);
	}

	@Override
	public News selectNewsById(Integer id) {
		return newsMapper.selectNewsById(id);
	}

	@Override
	public void updateNewsById(News news) {
		//内容不为空才修改
		if(news.getTitle()!=null&&news.getTest()!=null&&news.getTitle()!=""&&news.getTest()!="") {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String format = df.format(new Date());// new Date()为获取当前系统时间
		news.setDate(format);
		newsMapper.updateNewsById(news);
		}
	}

	@SuppressWarnings("unused")
	@Override
	public List<News> searchResult(String keyword) {
		if(keyword!=null&&keyword!="") {
			return newsMapper.searchResult(keyword);
		}else {
			return null;
		}
	}

	
	//分页返回新闻信息
	@Override
	public List<News> findLimit(PageBean<News> bean) {
		
		//每页显示条数
		bean.setCurrentCount(5);
		
		//总条数
		bean.setTotalCount(newsMapper.newsCount(bean.getCid()));
		
		//总页数
		Integer pageCount=(int) Math.ceil(1.0*bean.getTotalCount()/bean.getCurrentCount());
		bean.setTotalPage(pageCount);
		
		if(bean.getCurrentPage()<1)
		{
			bean.setCurrentPage(1);
		}
		
		if(bean.getCurrentPage()>pageCount)
		{
			bean.setCurrentPage(pageCount);
		}
		
		
		
		//分页时左边的数据
		bean.setLeftLimt((bean.getCurrentPage()-1)*bean.getCurrentCount());
		return newsMapper.findLimit(bean);
	}

	@Override
	public void saveComment(Comment comment) {//保存评论
		//如果评论不为空
		if(comment.getTest()!=null||comment.getTest()!="") {
			newsMapper.saveComment(comment);
		}

	}

		
	@Override
	public List<Comment> findComment() {//查询评论
		// TODO Auto-generated method stub
		return newsMapper.findComment();
	}



}
