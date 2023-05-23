package com.ssafy.trip.dto.friend;

public class FriendCountResponseDto {
	private int FollowerCount;
	private int FollowingCount;
	
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
}
