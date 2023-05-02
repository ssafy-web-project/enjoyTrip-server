package com.ssafy.trip.model.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.trip.dto.AttractionDto;
import com.ssafy.trip.dto.SidoDto;
import com.ssafy.trip.model.mapper.AttractionMapper;


@Service
public class AttractionService {

	@Autowired
	private AttractionMapper attractionMapper;
	
	//3. 메서드 추가
	public List<SidoDto> selectAllSido() throws SQLException{
		return attractionMapper.selectAllSido();
	}
	
	public List<AttractionDto> selectAttraction(Map<String, String> map) throws SQLException{
		Map<String, Object> param = new HashMap<String, Object>();
		String strSidoCode = (String) map.get("sidoCode");
		String strContentType = (String) map.get("contentType");
		String search = (String) map.get("search");

		param.put("sidoCode", strSidoCode.isEmpty() ? 0 : Integer.parseInt(strSidoCode));
		param.put("contentType", strContentType.isEmpty() ? 0 : Integer.parseInt(strContentType));
		param.put("search", map.get("search"));
		
		return attractionMapper.selectAttraction(param);
	}
}
