package com.ssafy.trip.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.trip.dto.User;
import com.ssafy.trip.dto.comment.CommentRequestDto;
import com.ssafy.trip.dto.comment.CommentResultDto;

@Mapper
public interface CommentMapper {

	public abstract List<CommentResultDto> commentList(int contentId);

	public abstract int commentInsert(CommentRequestDto commentDto);

	public abstract int updateLikeCount(int commentId);
	
	public abstract int commentDelete(int commentId);
}
