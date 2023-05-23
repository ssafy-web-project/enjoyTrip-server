package com.ssafy.trip.dto.friend;

public class FriendRequestDto {
	private String fromId;
	private String toId;
	
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
}
