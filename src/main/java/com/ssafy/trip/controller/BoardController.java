package com.ssafy.trip.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.trip.dto.BoardDto;
import com.ssafy.trip.model.service.BoardService;

import util.PageNavigation;

@RestController
public class BoardController extends HttpServlet {

	private final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/boards")
	public ResponseEntity<?> list(@RequestParam Map<String, String> map) throws Exception {
		logger.debug("list parameter pgno : {}", map.get("pgno"));
		Map<String, Object> ret = new HashMap<>();
		
		List<BoardDto> list = boardService.listArticle(map);
		PageNavigation pageNavigation = boardService.makePageNavigation(map);
		
		ret.put("articles", list);
		ret.put("navigation", pageNavigation);
		ret.put("pgno", map.get("pgno"));
		ret.put("key", map.get("key"));
		ret.put("word", map.get("word"));
		
		return ResponseEntity.ok().body(ret);	
	}
	
	@GetMapping("/boards/{articleNo}")
	public ResponseEntity<?> view(@PathVariable int articleNo , @RequestParam Map<String, String> map) throws Exception {
		logger.debug("view articleNo : {}", articleNo);
		
		Map<String, Object> ret = new HashMap<>();

		BoardDto boardDto = boardService.getArticle(articleNo);
		boardService.updateHit(articleNo);
		
		ret.put("article", boardDto);
		ret.put("pgno", map.get("pgno"));
		ret.put("key", map.get("key"));
		ret.put("word", map.get("word"));
		
		return ResponseEntity.ok().body(ret);
	}
	
	@PostMapping("/boards")
	public ResponseEntity<?> write(@RequestBody Map<String, String> map) throws Exception {
			BoardDto boardDto = new BoardDto();
			boardDto.setUserId(map.get("userId"));
			boardDto.setSubject(map.get("subject"));
			boardDto.setContent(map.get("content"));
			
			boardService.writeArticle(boardDto);
			
			return ResponseEntity.ok().build();
	}

	@PatchMapping("/boards")
	private ResponseEntity<?> modify(@RequestBody Map<String, String> map) throws Exception {
		// TODO : 수정 할 글정보를 얻고 BoardDto에 set.
		// TODO : boardDto를 파라미터로 service의 modifyArticle() 호출.
		// TODO : 글수정 완료 후 view.jsp로 이동.(이후의 프로세스를 생각해 보세요.)
		BoardDto boardDto = new BoardDto();
		boardDto.setArticleNo(Integer.parseInt(map.get("articleno")));
		boardDto.setSubject(map.get("subject"));
		boardDto.setContent(map.get("content"));
		
		boardService.modifyArticle(boardDto);
		
		return ResponseEntity.ok().build();
	}
	

	@DeleteMapping("/boards/{articleNo}")
	private ResponseEntity<?> delete(@PathVariable int articleNo) throws Exception {
		// TODO : 삭제할 글 번호를 얻는다.
		// TODO : 글번호를 파라미터로 service의 deleteArticle()을 호출.
		// TODO : 글삭제 완료 후 list.jsp로 이동.(이후의 프로세스를 생각해 보세요.)
		boardService.deleteArticle(articleNo);
		
		return ResponseEntity.ok().build();
	}

}
