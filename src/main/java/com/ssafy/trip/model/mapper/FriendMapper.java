package com.ssafy.trip.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.trip.dto.friend.FriendDto;
import com.ssafy.trip.dto.friend.FriendFollowerResponseDto;
import com.ssafy.trip.dto.friend.FriendFollowingResponseDto;
import com.ssafy.trip.dto.friend.FriendRequestDto;

@Mapper
public interface FriendMapper {
	
	public int friendFollow(FriendRequestDto friendDto); // 팔로우 : 내가 친구 요청(추가)
	public int friendUnFollow(FriendRequestDto friendDto); // 친구 해제
	
	public List<FriendFollowerResponseDto> friendFollower(String toId); // 팔로워 : 나를 친구로 등록한 사람들 조회
	public int friendFollowerCount(String toId); // 팔로워 : 나를 친구로 등록한 사람들 수
	
	public List<FriendFollowingResponseDto> friendFollowing(String fromId); // 팔로잉 : 내가 친구로 등록한 사람들 조회
	public int friendFollowingCount(String fromId); // 팔로잉 : 내가 친구로 등록한 사람들 수
}
