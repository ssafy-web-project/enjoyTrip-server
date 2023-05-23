package com.ssafy.trip.model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.trip.dto.User;
import com.ssafy.trip.dto.friend.FriendFollowingResponseDto;
import com.ssafy.trip.dto.user.UserIdCheckDto;
import com.ssafy.trip.dto.user.UserSearchResponseDto;
import com.ssafy.trip.model.mapper.FriendMapper;
import com.ssafy.trip.model.mapper.UserMapper;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private FriendMapper friendMapper;
	
	public User login(User loginInfo) throws SQLException {
		return userMapper.login(loginInfo);
	}
	
	public void regist(User user) throws SQLException {
		userMapper.regist(user);
	}
	
	public User profile(String name) throws SQLException {
		return userMapper.profile(name);
	}
	
	public void delete(String id) throws SQLException {
		userMapper.delete(id);
	}
	
	public User SearchbyID(String id) throws SQLException {
		return userMapper.SearchbyID(id);
	}
	
	public void update(User user) throws SQLException {
		userMapper.update(user);
	}

	public int checkId(String id) throws SQLException {
		return userMapper.checkId(id);
	}

	public List<UserSearchResponseDto> friendSearch(Map<String, String> map) throws SQLException {
		List<UserSearchResponseDto> list = userMapper.friendSearch(map);
		
		List<FriendFollowingResponseDto> friendList = friendMapper.friendFollowing(map.get("id"));
		
		for (UserSearchResponseDto user : list) {
			for (FriendFollowingResponseDto friend : friendList) {
				if (user.getId().equals(friend.getToId())) {
					user.setFriend(true);
				}
			}
			if (user.getId().equals(map.get("id"))) {
				user.setSameUser(true);
			}
		}

		return list;
	}

	public int updateUser(User user) {
		return userMapper.updateUser(user);
	}

	public int updatePassword(User user) {
		return userMapper.updatePassword(user);
	}

}
