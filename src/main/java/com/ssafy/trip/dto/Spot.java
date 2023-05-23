package com.ssafy.trip.dto;

public class Spot {
    private int contentId;
    private String title;
    private String addr1;
    private String tel;
    private String firstImage;
    private String readCount;
    private String contentTypeId;
    private String latitude;
    private String longitude;
    private String sidoId;
    private String gugunId;
    private String overview;
    private String memo;

	public Spot() {
	
	}
	
	
	public String getTitle() {
	    return title;
	}
	
	public void setTitle(String title) {
	    this.title = title;
	}
	
	
	public String getTel() {
	    return tel;
	}
	
	public void setTel(String tel) {
	    this.tel = tel;
	}
	
	
	
	
	public int getContentId() {
	    return contentId;
	}
	
	
	public void setContentId(int contentId) {
	    this.contentId = contentId;
	}
	
	
	public String getAddr1() {
	    return addr1;
	}
	
	
	public void setAddr1(String addr1) {
	    this.addr1 = addr1;
	}
	
	
	public String getFirstImage() {
	    return firstImage;
	}
	
	
	public void setFirstImage(String firstImage) {
	    this.firstImage = firstImage;
	}
	
	
	public String getReadCount() {
	    return readCount;
	}
	
	
	public void setReadCount(String readCount) {
	    this.readCount = readCount;
	}
	
	
	public String getContentTypeId() {
	    return contentTypeId;
	}
	
	
	public void setContentTypeId(String contentTypeId) {
	    this.contentTypeId = contentTypeId;
	}
	
	
	public String getLatitude() {
	    return latitude;
	}
	
	
	public void setLatitude(String latitude) {
	    this.latitude = latitude;
	}
	
	
	public String getLongitude() {
	    return longitude;
	}
	
	
	public void setLongitude(String longitude) {
	    this.longitude = longitude;
	}
	
	
	public String getSidoId() {
	    return sidoId;
	}
	
	
	public void setSidoId(String sidoId) {
	    this.sidoId = sidoId;
	}
	
	
	public String getGugunId() {
	    return gugunId;
	}
	
	
	public void setGugunId(String gugunId) {
	    this.gugunId = gugunId;
	}
	
	
	public String getOverview() {
	    return overview;
	}
	
	
	public void setOverview(String overview) {
	    this.overview = overview;
	}
	
	
	public String getMemo() {
	    return memo;
	}
	
	public void setMemo(String memo) {
	    this.memo = memo;
	}
}