package com.ssafy.trip.model.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ssafy.trip.dto.BoardDto;
import com.ssafy.trip.dto.notice.NoticeDto;
import com.ssafy.trip.dto.notice.NoticeParamDto;
import com.ssafy.trip.dto.notice.NoticeResultDto;
import com.ssafy.trip.dto.popular.Schedule;
import com.ssafy.trip.dto.popular.ScheduleDetail;
import com.ssafy.trip.dto.popular.ScheduleSpot;
import com.ssafy.trip.model.mapper.BoardMapper;
import com.ssafy.trip.util.PageNavigation;
import com.ssafy.trip.util.SizeConstant;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper boardMapper;

    private static final int SUCCESS = 1;
    private static final int FAIL = -1;
    
	@Override
	public NoticeResultDto noticeDetail(Map<String, Object> map) {
		NoticeResultDto noticeResultDto = new NoticeResultDto();
	    
        int userReadCnt = boardMapper.noticeUserReadCount(map);
        if( userReadCnt == 0 ) {
        	System.out.println(map.get("noticeId") + " " +  map.get("userId"));
        	boardMapper.noticeUserReadInsert(map);
        	boardMapper.noticeReadCountUpdate((int)map.get("noticeId"));
        }
        NoticeDto noticeDto = boardMapper.noticeDetail(map);
        
        if(noticeDto.getUserId().equals((String) map.get("userId"))) {
            noticeDto.setSameUser(true);
        } else {
            noticeDto.setSameUser(false);
        }
        
        noticeResultDto.setDto(noticeDto);
	
	    return noticeResultDto;
	}
	
	@Override
	public int noticeDelete(int noticeId) {
		NoticeResultDto noticeResultDto = new NoticeResultDto();

		System.out.println(111);
	    int ret = boardMapper.noticeReadCountDelete(noticeId);
	    System.out.println(222);
	    int ret2 = boardMapper.noticeDelete(noticeId); // 원본글 삭제       
	    System.out.println(333);
	    
	    return ret2;
	}
	@Override
	public int noticeUpdate(NoticeDto dto) {
	    int ret = boardMapper.noticeUpdate(dto);
     
	    return ret;
	}
	@Override
	public int noticeInsert(NoticeDto dto) {
        int ret = boardMapper.noticeInsert(dto);

	    return ret;
	}
	
	@Override
	public NoticeResultDto noticeList(NoticeParamDto noticeParamDto) {
		NoticeResultDto noticeResultDto = new NoticeResultDto();
		    
		System.out.println(333);
        List<NoticeDto> list = boardMapper.noticeList(noticeParamDto);
        System.out.println(444);
        int count = boardMapper.noticeListTotalCount();            
        System.out.println(555);
        noticeResultDto.setList(list);
        noticeResultDto.setCount(count);
	        
	    return noticeResultDto;
	}

	
	@Override
	public NoticeResultDto noticeLatestList(NoticeParamDto noticeParamDto) {
		NoticeResultDto noticeResultDto = new NoticeResultDto();
	    
        List<NoticeDto> list = boardMapper.noticeLatestList(noticeParamDto);           
        noticeResultDto.setList(list);

	    return noticeResultDto;
	}
	
	@Override
	public NoticeResultDto noticeListSearchWord(NoticeParamDto noticeParamDto) {

		NoticeResultDto noticeResultDto = new NoticeResultDto();
    
        List<NoticeDto> list = boardMapper.noticeListSearchWord(noticeParamDto);
        int count = boardMapper.noticeListSearchWordTotalCount(noticeParamDto);
        
        noticeResultDto.setList(list);
        noticeResultDto.setCount(count);
        
	    return noticeResultDto;
	}

	@Override
	public void writeBoard(Map<String, String> map) {
		boardMapper.writeBoard(map);
	}

	@Override
	public void writeScheduleSpot(Map<String, String> map) {
		boardMapper.writeScheduleSpot(map);
	}
	
	@Override
	public int getLastBoardid(String uid) {
		return boardMapper.getLastBoardid(uid);
	}

	@Override
	public List<Schedule> getTopBoards() {
		return boardMapper.getTopBoards();
	}

	@Override
	public List<ScheduleSpot> getTopBoardSpots(int boardid) {
		return boardMapper.getTopBoardSpots(boardid);
	}

	@Override
	public ScheduleDetail view(String scheduleId) {
		return boardMapper.view(scheduleId);
	}

	@Override
	public void updateHit(String scheduleId) {
		boardMapper.updateHit(scheduleId);
	}
}
