package com.news.newsManagerSys.Dao;

import com.news.newsManagerSys.Dao.Entity.NewsType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface NewsTypeDao extends JpaRepository<NewsType, Long> {
    @Transactional
    NewsType findNewsTypeByNewsTypeName(String newsType);

    @Transactional
    NewsType findNewsTypeByNewsTypeId(long newsTypeId);
}
