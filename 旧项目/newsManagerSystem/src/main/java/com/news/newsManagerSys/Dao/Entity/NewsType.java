package com.news.newsManagerSys.Dao.Entity;


import javax.persistence.*;


@Entity
@Table(name = "newstype")
public class NewsType {

	@Id
	@Column(name = "newsTypeid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long newsTypeId;

	@Column(name = "newsTypename", nullable = false, length = 20)
	private String newsTypeName;

	public String getNewsTypeName() {
		return newsTypeName;
	}

	public void setNewsTypeName(String newsTypeName) {
		this.newsTypeName = newsTypeName;
	}

	public long getNewsTypeId() {
		return newsTypeId;
	}

	public void setNewsTypeId(long newsTypeId) {
		this.newsTypeId = newsTypeId;
	}
}
