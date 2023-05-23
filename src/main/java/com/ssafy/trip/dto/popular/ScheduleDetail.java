package com.ssafy.trip.dto.popular;

import java.util.ArrayList;
import java.util.List;

public class ScheduleDetail {
	private int scheduleId;
	private String title;
	private int hit;
	private String registerTime;
	private String email;
	private String name;
	private String userId;
	private List<ScheduleDetailSpotInfo> planInfos = new ArrayList<>();

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}


	public List<ScheduleDetailSpotInfo> getPlanInfos() {
		return planInfos;
	}

	public void setPlanInfos(List<ScheduleDetailSpotInfo> planInfos) {
		this.planInfos = planInfos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}