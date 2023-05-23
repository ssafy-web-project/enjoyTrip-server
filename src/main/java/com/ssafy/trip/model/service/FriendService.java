package com.ssafy.trip.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.trip.dto.friend.FriendCountResponseDto;
import com.ssafy.trip.dto.friend.FriendDto;
import com.ssafy.trip.dto.friend.FriendFollowerResponseDto;
import com.ssafy.trip.dto.friend.FriendFollowingResponseDto;
import com.ssafy.trip.dto.friend.FriendRequestDto;
import com.ssafy.trip.model.mapper.FriendMapper;

@Service
public class FriendService {
	
	@Autowired
	FriendMapper friendMapper;
	
	public int friendFollow(FriendRequestDto friendDto) {
		return friendMapper.friendFollow(friendDto);
	}

	public int friendUnFollow(FriendRequestDto friendDto) {
		return friendMapper.friendUnFollow(friendDto);
	}

	public List<FriendFollowerResponseDto> friendFollower(String toId) {
		List<FriendFollowerResponseDto> followerList = friendMapper.friendFollower(toId);
		return followerList;
	}
	
	public FriendCountResponseDto friendCount(String id) {

		FriendCountResponseDto friendCountResponseDto = new FriendCountResponseDto();
		
		friendCountResponseDto.setFollowerCount(friendMapper.friendFollowerCount(id));
		friendCountResponseDto.setFollowingCount(friendMapper.friendFollowingCount(id));
		
		return friendCountResponseDto;
	}
	
	public List<FriendFollowingResponseDto> friendFollowing(String fromId) {
		List<FriendFollowingResponseDto> followingList = friendMapper.friendFollowing(fromId);
		return followingList;
	}
}

