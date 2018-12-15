package com.news.newsManagerSys.Service;

import java.util.List;

import com.news.newsManagerSys.Dao.Entity.NewsType;

public interface NewsTypeService {
	List<NewsType> getAllNewsType();

	void addNewsType(NewsType newsType);

	void addAndFlushNewsType(NewsType newsType);

	NewsType findNewsTypeByNewsTypeName(String newsTypeName);

	NewsType findNewsTypeByNewsTypeId(long newsTypeId);
}
