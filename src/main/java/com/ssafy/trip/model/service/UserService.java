package com.ssafy.trip.model.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.trip.dto.User;
import com.ssafy.trip.model.mapper.UserMapper;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
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

}
