package com.news.newsManagerSys.Dao.Entity.Vo;

import com.news.newsManagerSys.Dao.Entity.User;

public class UserVo {
    private int stateNo;
    private String notice;
    private String userName;
    private String userRole;
    private String userAuthor;

    public UserVo(User user) {
        this.setUserName(user.getUserName());
        this.setUserRole(user.getUserRole());
        this.setUserAuthor(user.getAuthorName());
    }

    public String getUserAuthor() {
        return userAuthor;
    }

    public void setUserAuthor(String userAuthor) {
        this.userAuthor = userAuthor;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getStateNo() {
        return stateNo;
    }

    public void setStateNo(int stateNo) {
        this.stateNo = stateNo;
    }

}
