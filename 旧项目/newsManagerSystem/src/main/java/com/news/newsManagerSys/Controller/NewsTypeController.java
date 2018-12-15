package com.news.newsManagerSys.Controller;


import com.news.newsManagerSys.Dao.Entity.NewsType;
import com.news.newsManagerSys.Service.NewsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/newsType")
public class NewsTypeController {
    @Autowired
    private NewsTypeService newsTypeService;

    @RequestMapping(value = "/showNewsTypes")
    public List<NewsType> getAllNewsType() {
        return newsTypeService.getAllNewsType();
    }

    @PostMapping(value = "/addNewsType")
    public String addNewsType(@RequestBody NewsType newsType/**@RequestParam  long newsTypeId, @RequestParam String newsTypeName*/) {
//        NewsType newsType = new NewsType();
//        newsType.setNewsTypeId(newsTypeId);
//        newsType.setNewsTypeName(newsTypeName);
        System.out.print(newsType.getNewsTypeId()+newsType.getNewsTypeName());
        newsTypeService.addNewsType(newsType);
        return "新增成功！";
    }

    @PostMapping(value = "/getOne")
    public NewsType getOne(@RequestBody String newsTypeName){
        return newsTypeService.findNewsTypeByNewsTypeName(newsTypeName);
    }

    @RequestMapping(value = "/getNewsTypeName")
    public NewsType getNewsTypeNameByNewsTypeId(@RequestParam long newsTypeId){
        return newsTypeService.findNewsTypeByNewsTypeId(newsTypeId);
    }

    @PostMapping(value = "/update")
    public String addAndFlushNewsType(@RequestBody NewsType newsType/**@RequestParam  long newsTypeId, @RequestParam String newsTypeName*/) {
//        NewsType newsType = newsTypeService.findNewsTypeByNewsTypeName(oldNewsTypeName);
//        newsType.setNewsTypeName(newNewsTypeName);
        newsTypeService.addAndFlushNewsType(newsType);
        return "修改成功！";
    }
}
