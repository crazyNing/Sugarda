package com.news.newsManagerSys.Service;

import com.news.newsManagerSys.Dao.Entity.News;
import org.springframework.data.domain.Page;

import java.util.List;


public interface NewsService {

	Page<News> findNewsNoCriteria(Integer page, Integer size);

	void addNews(News news);

	void saveAndFlush(News news);

	void deleteNews(String newsTitle);

	News findNewsByNewsTitle(String newsTitle);

	List<News> finaAll();

	News findOne(long newsNo);
}
