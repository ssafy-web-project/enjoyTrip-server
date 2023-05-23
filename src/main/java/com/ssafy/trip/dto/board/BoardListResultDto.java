package com.ssafy.trip.dto.board;

import java.util.List;

public class BoardListResultDto {
	private List<BoardListResponseDto> list; // 목록
	private int count; // 글 개수
	
	public List<BoardListResponseDto> getList() {
		return list;
	}
	public void setList(List<BoardListResponseDto> list) {
		this.list = list;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
