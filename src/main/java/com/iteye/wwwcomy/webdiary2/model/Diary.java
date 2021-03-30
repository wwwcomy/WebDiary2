package com.iteye.wwwcomy.webdiary2.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(content = Include.NON_NULL)
public class Diary {

	private Long id;
	private Date diaryDate;
	private String username;
	private String weather;
	private String title;
	private String content;
	private Date createdDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the date of the Diary.
	 * 
	 * @return
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getDiaryDate() {
		return diaryDate;
	}

	public void setDiaryDate(Date date) {
		this.diaryDate = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Diary update(Diary diary) {
		if (null != diary.getContent()) {
			setContent(diary.getContent());
		}
		if (null != diary.getDiaryDate()) {
			setDiaryDate(diary.getDiaryDate());
		}
		if (null != diary.getTitle()) {
			setTitle(diary.getTitle());
		}
		return this;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return " [" + id + "\t " + diaryDate + "\t " + username + "\t " + weather + "\t " + title + "\t " + content
				+ "\t " + createdDate + "]";
	}

}