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
		//���ݲ�Ϊ�ղ������
		if(news.getTitle()!=null&&news.getTest()!=null&&news.getTitle()!=""&&news.getTest()!="") {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
		String format = df.format(new Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��
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
		//���ݲ�Ϊ�ղ��޸�
		if(news.getTitle()!=null&&news.getTest()!=null&&news.getTitle()!=""&&news.getTest()!="") {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
		String format = df.format(new Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��
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

	
	//��ҳ����������Ϣ
	@Override
	public List<News> findLimit(PageBean<News> bean) {
		
		//ÿҳ��ʾ����
		bean.setCurrentCount(5);
		
		//������
		bean.setTotalCount(newsMapper.newsCount(bean.getCid()));
		
		//��ҳ��
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
		
		
		
		//��ҳʱ��ߵ�����
		bean.setLeftLimt((bean.getCurrentPage()-1)*bean.getCurrentCount());
		return newsMapper.findLimit(bean);
	}

	@Override
	public void saveComment(Comment comment) {//��������
		//������۲�Ϊ��
		if(comment.getTest()!=null||comment.getTest()!="") {
			newsMapper.saveComment(comment);
		}

	}

		
	@Override
	public List<Comment> findComment() {//��ѯ����
		// TODO Auto-generated method stub
		return newsMapper.findComment();
	}



}
