package com.ssafy.trip.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ssafy.trip.dto.BoardDto;
import com.ssafy.trip.dto.notice.NoticeDto;
import com.ssafy.trip.dto.notice.NoticeParamDto;
import com.ssafy.trip.dto.popular.Schedule;
import com.ssafy.trip.dto.popular.ScheduleDetail;
import com.ssafy.trip.dto.popular.ScheduleSpot;

@Mapper
public interface BoardMapper {

	public int noticeUserReadCount(NoticeParamDto noticeParamDto); 

	public int noticeDelete(int noticeId);    
	
	public int noticeReadCountDelete(int noticeId);

	public int noticeInsert(NoticeDto dto);

	public List<NoticeDto> noticeList(NoticeParamDto noticeParamDto);
	public List<NoticeDto> noticeLatestList(NoticeParamDto noticeParamDto);
	public int noticeListTotalCount();

	public List<NoticeDto> noticeListSearchWord(NoticeParamDto noticeParamDto);
	public int noticeListSearchWordTotalCount(NoticeParamDto noticeParamDto);

	public int noticeUpdate(NoticeDto dto);

	public void noticeReadCountUpdate(int noticeId);

	public int noticeUserReadCount(Map<String, Object> map);

	public NoticeDto noticeDetail(Map<String, Object> map);

	public void noticeUserReadInsert(Map<String, Object> map);

	public void writeBoard(Map<String, String> map);

	public void writeScheduleSpot(Map<String, String> map);

	public int getLastBoardid(String uid);

	public List<Schedule> getTopBoards();

	public List<ScheduleSpot> getTopBoardSpots(int boardid);

	public ScheduleDetail view(String scheduleId);

	public void updateHit(String scheduleId);
}
