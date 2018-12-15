package com.news.newsManagerSys.Dao.Entity;

import javax.persistence.*;


@Entity
@Table(name = "userinfo")
public class User {

	@Id
	@Column(name = "userNo")
	private String userNo;

	@Column(name = "userName", nullable = false, length = 20)
	private String userName;

	@Column(name = "userPwd", nullable = false, length = 20)
	private String userPwd;

	@Column(name = "userRole", nullable = false, length = 11)
	private String userRole;

	@Column(name = "authorId", nullable = false, length = 10)
	private String authorId;

	@Column(name = "authorName", nullable = true, length = 20)
	private String authorName;

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

    @Override
    public String toString() {
        return "{" +
                "\nuserNo='" + userNo + '\'' +
                ",\nuserName='" + userName + '\'' +
                ",\nuserPwd='" + userPwd + '\'' +
                ",\nuserRole='" + userRole + '\'' +
                ",\nauthorId='" + authorId + '\'' +
                ",\nauthorName='" + authorName + '\'' +
                '}';
    }
}
