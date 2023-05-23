package com.ssafy.trip.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.trip.dto.comment.CommentRequestDto;
import com.ssafy.trip.dto.comment.CommentResultDto;
import com.ssafy.trip.dto.notice.NoticeParamDto;
import com.ssafy.trip.dto.notice.NoticeResultDto;
import com.ssafy.trip.model.mapper.CommentMapper;
import com.ssafy.trip.model.mapper.FriendMapper;

@Service
public class CommentService {
	@Autowired
	CommentMapper commentMapper;

	public List<CommentResultDto> commentList(int contentId) {
		return commentMapper.commentList(contentId);
	}

	public int commentInsert(CommentRequestDto commentDto) {
		return commentMapper.commentInsert(commentDto);
	}

	public int updateLikeCount(int commentId) {
		return commentMapper.updateLikeCount(commentId);
	}
	
	public int commentDelete(int commentId) {
		return commentMapper.commentDelete(commentId);
	}
}
