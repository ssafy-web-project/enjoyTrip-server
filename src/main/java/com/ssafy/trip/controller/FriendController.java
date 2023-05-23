package com.ssafy.trip.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.trip.dto.friend.FriendCountResponseDto;
import com.ssafy.trip.dto.friend.FriendDto;
import com.ssafy.trip.dto.friend.FriendFollowerResponseDto;
import com.ssafy.trip.dto.friend.FriendFollowingResponseDto;
import com.ssafy.trip.dto.friend.FriendRequestDto;
import com.ssafy.trip.model.service.FriendService;

@RestController
@CrossOrigin
public class FriendController {
	
	@Autowired
	FriendService friendService;
	
	private static final int SUCCESS = 1;
	private static final int INCORRECT_INFO = 2;
	
	@PostMapping(value="/friend")
	public ResponseEntity<?> friendFollow(@RequestBody FriendRequestDto friendRequestDto) {
		
		int ret = friendService.friendFollow(friendRequestDto);
		
		if( ret == 1 ) {
			return ResponseEntity.ok().body(ret);	
	    }else {
	    	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ret);
	    } 
	}
	
	@DeleteMapping(value="/friend")
	public ResponseEntity<?> friendUnfollow(@RequestBody FriendRequestDto friendRequestDto) {

		int ret = friendService.friendUnFollow(friendRequestDto);
		
		if( ret == 1 ) {
			return ResponseEntity.ok().body(ret);	
	    }else {
	    	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ret);
	    } 
	}
	
	@GetMapping("/friend/follower")
	public ResponseEntity<?> friendFollower(@RequestParam Map<String, String> map) {

		List<FriendFollowerResponseDto> ret = friendService.friendFollower(map.get("id"));
		
		if( ret != null ) {
			return ResponseEntity.ok().body(ret);	
	    }else {
	    	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    } 
	}
	
	@GetMapping("/friend/count")
	public ResponseEntity<?> friendCount(@RequestParam Map<String, String> map){

		FriendCountResponseDto ret = friendService.friendCount(map.get("id"));
		
		if( ret != null ) {
			return ResponseEntity.ok().body(ret);	
	    }else {
	    	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    } 
	}
	
	@GetMapping("/friend/following")
	public ResponseEntity<?> friendFollowing(@RequestParam Map<String, String> map) {
		
		List<FriendFollowingResponseDto> ret = friendService.friendFollowing(map.get("id"));
		
		if( ret != null ) {
			return ResponseEntity.ok().body(ret);	
	    }else {
	    	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    } 
	}
}