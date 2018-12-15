package com.news.newsManagerSys.Dao.Entity;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "newsinfo")
public class News {
    @Id
    @Column(name = "newsNo")
    private long newsNo;

    @Column(name = "newsTitle", nullable = false, length = 50)
    private String newsTitle;

    @Column(name = "newsContext", nullable = false, length = 2000)
    private String newsContext;

    @Column(name = "newsAuthor", nullable = false, length = 10)
    private String newsAuthor;

    @Temporal(TemporalType.DATE)
    private Date newsPubdate;

    @Column(name = "newsType", nullable = false, length = 11)
    private long newsType;

    @Column(name = "readCount", nullable = false, length = 11)
    private long readCount;

    @Column(name = "newsImage", nullable = true, length = 50)
    private String newsImage;


    public long getNewsNo() {
        return newsNo;
    }

    public void setNewsNo(long newsNo) {
        this.newsNo = newsNo;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsContext() {
        return newsContext;
    }

    public void setNewsContext(String newsContext) {
        this.newsContext = newsContext;
    }

    public String getNewsAuthor() {
        return newsAuthor;
    }

    public void setNewsAuthor(String newsAuthor) {
        this.newsAuthor = newsAuthor;
    }

    public Date getNewsPubdate() {
        return newsPubdate;
    }

    public void setNewsPubdate(Date newsPubdate) {
        this.newsPubdate = newsPubdate;
    }

    public long getNewsType() {
        return newsType;
    }

    public void setNewsType(long newsType) {
        this.newsType = newsType;
    }

    public long getReadCount() {
        return readCount;
    }

    public void setReadCount(long readCount) {
        this.readCount = readCount;
    }

    public String getNewsImage() {
        return newsImage;
    }

    public void setNewsImage(String newsImage) {
        this.newsImage = newsImage;
    }
}
