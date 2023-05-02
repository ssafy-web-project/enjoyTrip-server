package com.ssafy.trip.dto;

public class AttractionDto {
	private int sidoCode;
	private int contentType;
	private String title;
	private String addr;
	private String img;
	private double latitude;
	private double longitude;
	private String description;
	
	public AttractionDto() {}
	
	public AttractionDto(int sidoCode, int contentType, String title, String addr, String img, double latitude,
			double longitude, String description) {
		super();
		this.sidoCode = sidoCode;
		this.contentType = contentType;
		this.title = title;
		this.addr = addr;
		this.img = img;
		this.latitude = latitude;
		this.longitude = longitude;
		this.description = description;
	}


	public int getSidoCode() {
		return sidoCode;
	}

	public void setSidoCode(int sidoCode) {
		this.sidoCode = sidoCode;
	}

	public int getContentType() {
		return contentType;
	}

	public void setContentType(int contentType) {
		this.contentType = contentType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "AttractionDto [sidoCode=" + sidoCode + ", contentType=" + contentType + ", title=" + title + ", addr="
				+ addr + ", img=" + img + ", latitude=" + latitude + ", longitude=" + longitude + ", description="
				+ description + "]";
	}
}
