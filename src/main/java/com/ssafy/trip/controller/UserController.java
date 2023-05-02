package com.ssafy.trip.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.ssafy.trip.dto.User;
import com.ssafy.trip.model.service.UserService;


@RestController
public class UserController extends HttpServlet {

	
	@Autowired
	private UserService userService;
	
	@PostMapping("/user-login")
	private ResponseEntity<?> login(@RequestBody User user, @RequestParam(name = "isRemember", required = false) String isRemember, HttpSession session, HttpServletResponse response) throws SQLException, IOException {

		//2.유저 정보 조회 요청 모델에 넘기기
		User result = userService.login(user);
		
		//3-1. 정보가 있다면 세션에 유저정보 저장
		if(result!=null) {
			session.setAttribute("userInfo", result);
			
			Cookie cookie = new Cookie("rememberId", result.getId());
			//isRemember 가 체크되어 있다면 쿠키에 아이디 저장
			if(isRemember!=null) {
				cookie.setMaxAge(60*60*3);//세시간
			}
			//체크되어있지 않다면 쿠키 유효성 제거
			else {
				cookie.setMaxAge(0);//0시간 유효하지 않은 쿠키가 만들어짐
			}
			response.addCookie(cookie);
			
			//4. 메인화면으로 리다이렉트
			return ResponseEntity.ok().build();	
		}
		//3-2. 정보가 없다면 로그인 화면으로 리다이렉트
		else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}			
	}	
	
	@GetMapping("/user-logout")
	public ResponseEntity<?> logout(HttpSession session) {
		session.invalidate();
		
		return ResponseEntity.ok().build();	
	}
	
	@PostMapping("/users")
	public ResponseEntity<?> regist(@RequestBody User user) throws SQLException {
		userService.regist(user);
		
		return ResponseEntity.ok().build();	
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<?> search(@PathVariable String id) throws SQLException {
		User ret = userService.SearchbyID(id);
					
		return ResponseEntity.ok().body(ret);	
	}
	
	@PatchMapping("/users")
	public ResponseEntity<?> search(@RequestBody User user) throws SQLException {
		userService.update(user);
		
		return ResponseEntity.ok().build();	
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<?> delete(@PathVariable String id) throws SQLException {
		userService.delete(id);
		
		return ResponseEntity.ok().build();	
	}
	
}
