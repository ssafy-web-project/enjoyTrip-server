package com.ssafy.trip.dto.comment;

import java.time.LocalDateTime;

public class CommentResultDto {
	private int commentId;
	private int contentId;
	private String userId;
	private String content;
	private LocalDateTime createdAt;
	private int likeUserCount;
	private int hateUserCount;
	
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public int getContentId() {
		return contentId;
	}
	public void setContentId(int contentId) {
		this.contentId = contentId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public int getLikeUserCount() {
		return likeUserCount;
	}
	public void setLikeUserCount(int likeUserCount) {
		this.likeUserCount = likeUserCount;
	}
	public int getHateUserCount() {
		return hateUserCount;
	}
	public void setHateUserCount(int hateUserCount) {
		this.hateUserCount = hateUserCount;
	}
	
	
}
