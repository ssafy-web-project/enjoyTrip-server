package com.ssafy.trip.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ssafy.trip.dto.notice.NoticeDto;
import com.ssafy.trip.dto.notice.NoticeParamDto;
import com.ssafy.trip.dto.notice.NoticeResultDto;
import com.ssafy.trip.dto.popular.Schedule;
import com.ssafy.trip.dto.popular.ScheduleDetail;
import com.ssafy.trip.dto.popular.ScheduleSpot;
import com.ssafy.trip.model.service.BoardService;

@RestController
@CrossOrigin
public class BoardController extends HttpServlet {

	private final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;
	
    @GetMapping(value="/notices")
    public ResponseEntity<NoticeResultDto> noticeList(NoticeParamDto noticeParamDto){
    	NoticeResultDto noticeResultDto;
    	System.out.println(noticeParamDto);
    	System.out.println(111);
	    if( noticeParamDto.getSearchWord().isEmpty() ) {
	    	System.out.println(222);
	    	noticeResultDto = boardService.noticeList(noticeParamDto);
	    }else {
	    	System.out.println(333);
	    	noticeResultDto = boardService.noticeListSearchWord(noticeParamDto); // 검색어가 포함되어 있을 때
	    }
	    
		if( noticeResultDto != null ) {
			return ResponseEntity.ok().body(noticeResultDto);	
	    }else {
	    	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(noticeResultDto);
	    } 
	}
    
	// 최근 등록 매물 5개까지
    @GetMapping(value="/notices/latest")
    public ResponseEntity<NoticeResultDto> noticeLatestList(NoticeParamDto noticeParamDto){
    	NoticeResultDto noticeResultDto = new NoticeResultDto();
    	
    	noticeResultDto = boardService.noticeLatestList(noticeParamDto);
	    
		if( noticeResultDto != null ) {
			return ResponseEntity.ok().body(noticeResultDto);	
	    }else {
	    	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(noticeResultDto);
	    } 
	}
    
	@GetMapping(value="/notices/{noticeId}")
	public ResponseEntity<NoticeResultDto> noticeDetail(@PathVariable int noticeId, @RequestParam Map<String, Object> map){
	
	    map.put("noticeId", noticeId);
	    NoticeResultDto noticeResultDto = boardService.noticeDetail(map);
	
	    if( noticeResultDto != null ) {
			return ResponseEntity.ok().body(noticeResultDto);	
	    }else {
	    	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(noticeResultDto);
	    }         
	}

	@PostMapping(value="/notices")
	public ResponseEntity<?> noticeInsert(@RequestBody NoticeDto noticeDto) {
	    int ret = boardService.noticeInsert(noticeDto);
	    
	    if( ret == 1 ) {
			return ResponseEntity.ok().body(ret);	
	    }else {
	    	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ret);
	    }          
	}

	@PatchMapping(value="/notices") 
	public ResponseEntity<?> noticeUpdate(@RequestBody NoticeDto noticeDto){
	
	    int ret = boardService.noticeUpdate(noticeDto);
	    
	    if( ret == 1 ) {
			return ResponseEntity.ok().body(ret);	
	    }else {
	    	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ret);
	    }     
	    
	}

	@DeleteMapping(value="/notices/{noticeId}")
	public ResponseEntity<?> noticeDelete(@PathVariable(value="noticeId") int noticeId){
		int ret = boardService.noticeDelete(noticeId);
	    
	    if( ret == 1 ) {
			return ResponseEntity.ok().body(ret);	
	    }else {
	    	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ret);
	    }        
	}
	
	@PostMapping("/notices/writeSchedule")
	public ResponseEntity<?> writeSchedule(@RequestBody Map<String, String> map) {
		System.out.println("aaa");
		boardService.writeBoard(map);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PostMapping("/notices/writeScheduleSpot")
	public ResponseEntity<?> writeScheduleSpot(@RequestBody Map<String, String> map) {
		System.out.println("bbb");
		boardService.writeScheduleSpot(map);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}
	@GetMapping("/notices/writeSchedule/boardid/{userId}")
	public ResponseEntity<?> getBoardId(@PathVariable() String userId) {
		System.out.println("ccc");
		int boardId = boardService.getLastBoardid(userId);
		return new ResponseEntity<Integer>(boardId, HttpStatus.OK);

	}
	
	@GetMapping("/board/top")
	public ResponseEntity<?> getTopSchedules() {
		List<Schedule> boards = boardService.getTopBoards();
		if (boards != null && !boards.isEmpty()) {
			return new ResponseEntity<List<Schedule>>(boards, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}

	}

	@GetMapping("/board/top/{boardid}")
	public ResponseEntity<?> getTopScheduleSpots(@PathVariable int boardid) {

		List<ScheduleSpot> ret = boardService.getTopBoardSpots(boardid);
		if (ret != null && !ret.isEmpty()) {
			return new ResponseEntity<List<ScheduleSpot>>(ret, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}
	
	// 일정 상세 보기
	@GetMapping("/board/list/{scheduleId}")
	public ResponseEntity<?> planView(@PathVariable("scheduleId") String scheduleId){
		logger.debug("planView call");
		ScheduleDetail scheduleDetail = boardService.view(scheduleId);
		boardService.updateHit(scheduleId);
		if (scheduleDetail != null) {
			return new ResponseEntity<ScheduleDetail>(scheduleDetail, HttpStatus.OK);
		} else {
			return new ResponseEntity<ScheduleDetail>(scheduleDetail, HttpStatus.NO_CONTENT);
		}
	}
}
