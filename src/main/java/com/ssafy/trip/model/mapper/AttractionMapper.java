package com.ssafy.trip.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.trip.dto.AttractionDto;
import com.ssafy.trip.dto.SidoDto;


@Mapper
public interface AttractionMapper {

	public abstract List<SidoDto> selectAllSido() throws SQLException;
	
	public abstract List<AttractionDto> selectAttraction(Map<String, Object> map) throws SQLException;
	
}
