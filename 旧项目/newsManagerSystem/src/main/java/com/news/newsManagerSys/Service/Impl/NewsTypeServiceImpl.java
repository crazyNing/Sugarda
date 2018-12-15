package com.news.newsManagerSys.Service.Impl;

import com.news.newsManagerSys.Dao.Entity.NewsType;
import com.news.newsManagerSys.Dao.NewsTypeDao;
import com.news.newsManagerSys.Service.NewsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsTypeServiceImpl implements NewsTypeService {

    @Autowired
    private NewsTypeDao newsTypeDao;

    @Override
    public List<NewsType> getAllNewsType() {
        return newsTypeDao.findAll();
    }

    @Override
    public void addNewsType(NewsType newsType) {
        newsTypeDao.save(newsType);
    }

    @Override
    public void addAndFlushNewsType(NewsType newsType) {
        newsTypeDao.saveAndFlush(newsType);
    }

    @Override
    public NewsType findNewsTypeByNewsTypeName(String newsTypeName) {
        return newsTypeDao.findNewsTypeByNewsTypeName(newsTypeName);
    }

    @Override
    public NewsType findNewsTypeByNewsTypeId(long newsTypeId) {
        return newsTypeDao.findNewsTypeByNewsTypeId(newsTypeId);
    }


}
