package com.ssafy.trip.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ssafy.trip.dto.BoardDto;
import com.ssafy.trip.dto.notice.NoticeDto;
import com.ssafy.trip.dto.notice.NoticeParamDto;
import com.ssafy.trip.dto.notice.NoticeResultDto;
import com.ssafy.trip.dto.popular.Schedule;
import com.ssafy.trip.dto.popular.ScheduleDetail;
import com.ssafy.trip.dto.popular.ScheduleSpot;
import com.ssafy.trip.util.PageNavigation;

public interface BoardService {
	
	public NoticeResultDto noticeDetail(Map<String, Object> map);
	public int noticeDelete(int noticeId);
	public NoticeResultDto noticeList(NoticeParamDto noticeParamDto);
	public NoticeResultDto noticeLatestList(NoticeParamDto noticeParamDto);
	public NoticeResultDto noticeListSearchWord(NoticeParamDto noticeParamDto);
	int noticeInsert(NoticeDto dto);
	int noticeUpdate(NoticeDto dto);
	public void writeBoard(Map<String, String> map);
	public void writeScheduleSpot(Map<String, String> map);
	public int getLastBoardid(String uid);
	public List<Schedule> getTopBoards();
	public List<ScheduleSpot> getTopBoardSpots(int boardid);
	public ScheduleDetail view(String scheduleId);
	public void updateHit(String scheduleId);
}
