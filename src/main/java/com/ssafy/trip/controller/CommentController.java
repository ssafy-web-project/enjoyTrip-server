package com.ssafy.trip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.trip.dto.comment.CommentRequestDto;
import com.ssafy.trip.dto.comment.CommentResultDto;
import com.ssafy.trip.dto.notice.NoticeDto;
import com.ssafy.trip.dto.notice.NoticeParamDto;
import com.ssafy.trip.dto.notice.NoticeResultDto;
import com.ssafy.trip.model.service.BoardService;
import com.ssafy.trip.model.service.CommentService;

@RestController
public class CommentController {

	@Autowired
	private CommentService commentService;
	
    @GetMapping(value="/spot/comment/{contentId}")
    public ResponseEntity<?> commentList(@PathVariable int contentId){
    	List<CommentResultDto> commentResultDto;

    	commentResultDto = commentService.commentList(contentId);

		if( commentResultDto != null ) {
			return ResponseEntity.ok().body(commentResultDto);	
	    }else {
	    	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(commentResultDto);
	    } 
	}
    
	@PostMapping(value="/spot/comment")
	public ResponseEntity<?> commentInsert(@RequestBody CommentRequestDto commentDto) {
		System.out.println(commentDto.getContentId() + " " + commentDto.getUserId() + " " + commentDto.getContent() + " ");
	    int ret = commentService.commentInsert(commentDto);
	    
	    System.out.println("###");
	    System.out.println(ret);
	    if( ret == 1 ) {
			return ResponseEntity.ok().body(ret);	
	    }else {
	    	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ret);
	    }          
	}
	
	@PatchMapping(value="/spot/comment/{commentId}") 
	public ResponseEntity<?> updateLikeCount(@PathVariable int commentId ){
	    int ret = commentService.updateLikeCount(commentId);
	    
	    if( ret == 1 ) {
			return ResponseEntity.ok().body(ret);	
	    }else {
	    	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ret);
	    }     
	}
	
	@DeleteMapping(value="/spot/comment/{commentId}")
	public ResponseEntity<?> commentDelete(@PathVariable int commentId){
		int ret = commentService.commentDelete(commentId);
	    
	    if( ret == 1 ) {
			return ResponseEntity.ok().body(ret);	
	    }else {
	    	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ret);
	    }        
	}
}
