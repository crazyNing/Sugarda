package com.news.newsManagerSys.Dao;

import com.news.newsManagerSys.Dao.Entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface NewsDao extends JpaRepository<News, String>, JpaSpecificationExecutor<News> {
    @Transactional
    News findNewsByNewsTitle(String newsName);

    @Transactional
    void deleteNewsByNewsTitle(String newsTitle);

    @Transactional
    News findNewsByNewsNo(long id);
}
