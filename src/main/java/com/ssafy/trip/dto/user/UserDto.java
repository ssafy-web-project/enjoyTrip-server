package com.ssafy.trip.dto.user;

import java.time.LocalDateTime;
import java.util.List;

public class UserDto {
	private String userId;
	private String userName;
	private String userPassword;
	private String userEmail;
	private String userPhone;
	private LocalDateTime registreTime;
	private String userProfileImage;
	private int code;
	
	private boolean sameUser;
	
	private boolean friend;
	
	private List<UserImgFileDto> fileList;

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

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public LocalDateTime getRegistreTime() {
		return registreTime;
	}

	public void setRegistreTime(LocalDateTime registreTime) {
		this.registreTime = registreTime;
	}

	public String getUserProfileImage() {
		return userProfileImage;
	}

	public void setUserProfileImage(String userProfileImage) {
		this.userProfileImage = userProfileImage;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public boolean isSameUser() {
		return sameUser;
	}

	public void setSameUser(boolean sameUser) {
		this.sameUser = sameUser;
	}

	public boolean isFriend() {
		return friend;
	}

	public void setFriend(boolean friend) {
		this.friend = friend;
	}

	public List<UserImgFileDto> getFileList() {
		return fileList;
	}

	public void setFileList(List<UserImgFileDto> fileList) {
		this.fileList = fileList;
	}
	
	
}
