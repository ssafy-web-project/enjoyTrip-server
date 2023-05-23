package com.ssafy.trip.dto.board;

import java.time.LocalDateTime;

public class BoardDetailResponseDto {
	private String articleNo;
	private String id;
	private String name;
	private String subject;
	private String content;
	private LocalDateTime registerTime;
	private boolean sameUser;
	
	public boolean isSameUser() {
		return sameUser;
	}
	public void setSameUser(boolean sameUser) {
		this.sameUser = sameUser;
	}
	private int hit;
	 
	public String getArticleNo() {
		return articleNo;
	}
	public void setArticleNo(String articleNo) {
		this.articleNo = articleNo;
	}
	public String getId() {
		return id;
	}
	@Override
	public String toString() {
		return "BoardListResponseDto [articleNo=" + articleNo + ", id=" + id + ", name=" + name + ", subject=" + subject
				+ ", content=" + content + ", registerTime=" + registerTime + ", hit=" + hit + "]";
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public LocalDateTime getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(LocalDateTime registerTime) {
		this.registerTime = registerTime;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
}
