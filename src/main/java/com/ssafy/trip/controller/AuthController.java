package com.ssafy.trip.controller;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.trip.dto.User;
import com.ssafy.trip.model.service.UserService;
import com.ssafy.trip.util.JwtUtil;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	//로그인 요청 처리 - POST /user/login
	@PostMapping("/login")
	public ResponseEntity<?> doLogin( @RequestBody User user) throws SQLException, UnsupportedEncodingException{
		//유저 정보 조회
		System.out.println(1234);
		System.out.println(user);
		System.out.println(user.getId() + " " + user.getPassword());
		User userInfo = userService.login(user);
		System.out.println(userInfo.getId());
		System.out.println(userInfo.getName());
		//로그인 성공
		if(userInfo!=null) {
			System.out.println("1111");
			String token = jwtUtil.createToken(userInfo, 60*60 );	//60초 * 60분
			
			Map<String, String> result = new HashMap<>();
			result.put("token", token);
			
			System.out.println("2222");
			return new ResponseEntity<Map<String, String>>(result, HttpStatus.OK);
			
			/*
			 * 
			 * {
			 * 	"token":"12311445252112326fgdfgfd gdsf"
			 * }
			 */
		}
		//로그인 실패
		else return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
