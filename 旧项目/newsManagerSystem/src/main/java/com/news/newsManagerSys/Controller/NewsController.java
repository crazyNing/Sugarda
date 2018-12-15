package com.news.newsManagerSys.Controller;


import com.news.newsManagerSys.Dao.Entity.News;
import com.news.newsManagerSys.Service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @GetMapping(value = "/page")
    public Page<News> findNewsNoCriteria(@RequestParam Integer page, @RequestParam Integer size) {
        return newsService.findNewsNoCriteria(page, size);
    }

    @GetMapping(value = "/getSize")
    public long getNewsNumber() {
        return newsService.finaAll().size();
    }

    @GetMapping(value = "/getAll")
    public List<News> getAll() {
        return newsService.finaAll();
    }

    @PostMapping(value = "/addNews")
    String addNews(@RequestBody News news/**@RequestParam long newsNo, @RequestParam String newsTitle, @RequestParam String newsContext, @RequestParam String newsAuthor, @RequestParam int newsType, @RequestParam String newsImage*/) {
        String message = "";
//        News news = new News();
//        news.setNewsNo(newsNo);
//        news.setNewsTitle(newsTitle);
//        news.setNewsContext(newsContext);
//        news.setNewsAuthor(newsAuthor);
        news.setNewsPubdate(new Date());
//        news.setNewsType(newsType);
        news.setReadCount(0);
//        news.setNewsImage(null);
        newsService.addNews(news);
        message = "新增成功！";
        return message;
    }

    @PostMapping(value = "/updateNews")
    String saveAndFlush(@RequestBody News news/**@RequestParam String newsTitle, @RequestParam String newsContext, @RequestParam String newsAuthor, @RequestParam int newsType, @RequestParam String newsImage*/) {
        String message = "";
        if (findNewsByNewsNo(news.getNewsNo()).getNewsTitle().equals("error")) {
            message = "没有这个新闻，抱歉。";
        } else {
            news.setReadCount(findNewsByNewsNo(news.getNewsNo()).getReadCount() + 1);
            news.setNewsPubdate(findNewsByNewsNo(news.getNewsNo()).getNewsPubdate());
            newsService.saveAndFlush(news);
            message = "修改成功！";
        }
        return message;
    }

    @PostMapping(value = "/deleteNews")
    String deleteNews(@RequestBody String newsTitle/**@RequestParam String newsTitle*/) {
        String message = "删除成功！";
        News news = findNewsByNewsTitle(newsTitle);
        if (news.getNewsTitle().equals("error")) {
            message = "删除失败，没有这条新闻！";
        }
        System.out.print(newsTitle);
        newsService.deleteNews(newsTitle);
        return message;
    }

    @PostMapping(value = "/findByTitle")
    News findNewsByNewsTitle(@RequestBody String newsTitle) {
        News news = newsService.findNewsByNewsTitle(newsTitle);
        if (news == null) {
            news = new News();
            news.setNewsTitle("error");
            news.setNewsContext("没有这个新闻");
        }
        return news;
    }

    @GetMapping(value = "/findByNo")
    News findNewsByNewsNo(@RequestParam long newsNo){
        return  newsService.findOne(newsNo);
    }
}
