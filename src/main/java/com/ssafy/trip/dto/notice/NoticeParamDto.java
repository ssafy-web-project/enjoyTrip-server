package com.ssafy.trip.dto.notice;

// 글 목록을 가지고 올 때 서버쪽으로 보내는 데이터
public class NoticeParamDto {

	private int limit;
	private int offset;
	private String searchWord;
	
	// 특정 게시글에 대한 상세가 들어가기 위해
	private int noticeId;
	private int userId;
	
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public String getSearchWord() {
		return searchWord;
	}
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}
	public int getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	
}
