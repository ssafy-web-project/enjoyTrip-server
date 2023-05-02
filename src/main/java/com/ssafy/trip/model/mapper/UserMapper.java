package com.ssafy.trip.model.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.trip.dto.User;

@Mapper
public interface UserMapper {

	public abstract User login(User loginInfo) throws SQLException;
	
	public abstract User SearchbyID(String id) throws SQLException;
	
	public abstract User profile(String name) throws SQLException;
	
	public abstract void regist(User user) throws SQLException;
	
	public abstract void delete(String id) throws SQLException;
	
	public abstract void update(User user) throws SQLException;
}
