package com.ssafy.trip.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.trip.dto.BoardDto;

@Mapper
public interface BoardMapper {

	public abstract void writeArticle(BoardDto boardDto) throws SQLException;
	
	public abstract List<BoardDto> listArticle(Map<String, Object> param) throws SQLException;
	
	public abstract int getTotalArticleCount(Map<String, Object> param) throws SQLException;
	
	public abstract BoardDto getArticle(int articleNo) throws SQLException;
	
	public abstract void updateHit(int articleNo) throws SQLException;
	
	public abstract void modifyArticle(BoardDto boardDto) throws SQLException;
	
	public abstract void deleteArticle(int articleNo) throws SQLException;
}
