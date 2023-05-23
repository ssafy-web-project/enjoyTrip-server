package com.ssafy.trip.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.trip.dto.User;
import com.ssafy.trip.dto.friend.FriendFollowingResponseDto;
import com.ssafy.trip.dto.user.UserIdCheckDto;
import com.ssafy.trip.dto.user.UserSearchResponseDto;

@Mapper
public interface UserMapper {

	public abstract User login(User loginInfo) throws SQLException;
	
	public abstract User SearchbyID(String id) throws SQLException;
	
	public abstract User profile(String name) throws SQLException;
	
	public abstract void regist(User user) throws SQLException;
	
	public abstract void delete(String id) throws SQLException;
	
	public abstract void update(User user) throws SQLException;

	public abstract int checkId(String id) throws SQLException;

	public abstract List<UserSearchResponseDto> friendSearch(Map<String, String> map) throws SQLException;

	public abstract int updateUser(User user);

	public abstract int updatePassword(User user);
}
