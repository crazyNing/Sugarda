package com.news.newsManagerSys.Service.Impl;

import com.news.newsManagerSys.Dao.Entity.News;
import com.news.newsManagerSys.Dao.NewsDao;
import com.news.newsManagerSys.Service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsDao newsDao;

    @Override
    public Page<News> findNewsNoCriteria(Integer page, Integer size) {
        Sort sort = new Sort(Sort.Direction.ASC, "newsNo");
        Pageable pageable = new PageRequest(page, size, sort);
        return newsDao.findAll(pageable);
    }

    @Override
    public void addNews(News news) {
        newsDao.save(news);
    }

    @Override
    public void saveAndFlush(News news) {
        newsDao.saveAndFlush(news);
    }

    @Override
    public void deleteNews(String newsTitle) {
        newsDao.deleteNewsByNewsTitle(newsTitle);
    }

    @Override
    public News findNewsByNewsTitle(String newsTitle) {
        return newsDao.findNewsByNewsTitle(newsTitle);
    }

    @Override
    public List<News> finaAll() {
        return newsDao.findAll();
    }

    @Override
    public News findOne(long newsNo) {
        return newsDao.findNewsByNewsNo(newsNo);
    }
}
