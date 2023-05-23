package com.ssafy.trip.dto.popular;

public class ScheduleDetailSpotInfo {
	private String contentId;
	private String firstImage;
	private String title;
	private String memo;
	private String contentTypeId;

	public String getContentId() {
		return contentId;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public void setContentId(String string) {
		this.contentId = string;
	}

	public String getFirstImage() {
		return firstImage;
	}

	public void setFirstImage(String firstImage) {
		this.firstImage = firstImage;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	public String getContentTypeId() {
		return contentTypeId;
	}

	public void setContentTypeId(String contentTypeId) {
		this.contentTypeId = contentTypeId;
	}

}
