package cn.mycase.mapper;

import java.util.List;

import cn.mycase.entity.Comment;
import cn.mycase.entity.News;
import cn.mycase.entity.PageBean;

public interface NewsMapper {
	void addNews(News news);//���
	List<News> selectNewsList();//��ѯ����
	void deleteNewsById(Integer id);//����idɾ��
	News selectNewsById(Integer id);//����id��ѯ
	void updateNewsById(News news);//��������
	List<News> searchResult(String keyword);//�ؼ�������
	List<News> findLimit(PageBean<News> bean);//��ҳ��ѯ
	Integer newsCount(Integer cid);//��������
	void saveComment(Comment comment);//�������
	List<Comment> findComment();//��������
}
