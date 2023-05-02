package com.ssafy.trip.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.trip.dto.AttractionDto;
import com.ssafy.trip.dto.SidoDto;
import com.ssafy.trip.model.service.AttractionService;


@RestController
public class AttractionController extends HttpServlet {

	@Autowired
	private AttractionService attractionService;
		
	@GetMapping("/attractions")
	public ResponseEntity<?> list(@RequestParam Map<String, String> map, Model model) throws SQLException {
		
		List<SidoDto> sidoList = attractionService.selectAllSido();
		
		System.out.println("sidoCode : " + map.get("sidoCode"));
		System.out.println("contentType : " + map.get("contentType"));
		System.out.println("search : " + map.get("search"));
		
		String strSidoCode = map.get("sidoCode");
		String strContentType = map.get("contentType");
		String search = map.get("search");
		
		int sidoCode = 0;
		int contentType = 0;
		if(!strSidoCode.isEmpty()) {
			sidoCode = Integer.parseInt(strSidoCode);
		}
		if(!strContentType.isEmpty()) {
			contentType = Integer.parseInt(strContentType);
		}
		
		List<AttractionDto> attractionList = attractionService.selectAttraction(map);
		
		
		Map<String, Object> ret = new HashMap<>();
		
		for(SidoDto s : sidoList) {
			System.out.println(s);
		}
		
		ret.put("sidoCode", sidoCode);
		ret.put("sidoList", sidoList);
		ret.put("contentType", contentType);
		ret.put("search", search);
		ret.put("attractionList", attractionList);
		
		return ResponseEntity.ok().body(ret);
	}

}
