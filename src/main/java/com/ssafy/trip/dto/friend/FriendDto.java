package com.ssafy.trip.dto.friend;

public class FriendDto {
	private int id;
	private String fromId;
	private String toId;
	
	private String userId;
	private String userName;
	private String userEmail;
	
	private int FollowerCount;
	private int FollowingCount;
	
	public int getId() {
		return id;
	}
	public int getFollowerCount() {
		return FollowerCount;
	}
	public void setFollowerCount(int followerCount) {
		FollowerCount = followerCount;
	}
	public int getFollowingCount() {
		return FollowingCount;
	}
	public void setFollowingCount(int followingCount) {
		FollowingCount = followingCount;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFromId() {
		return fromId;
	}
	public void setFromId(String fromId) {
		this.fromId = fromId;
	}
	public String getToId() {
		return toId;
	}
	public void setToId(String toId) {
		this.toId = toId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	
}