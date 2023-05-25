package com.ssafy.trip.model.service;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ssafy.trip.dto.User;
import com.ssafy.trip.dto.friend.FriendFollowingResponseDto;
import com.ssafy.trip.dto.user.UserDto;
import com.ssafy.trip.dto.user.UserFindPasswordRequestDto;
import com.ssafy.trip.dto.user.UserIdCheckDto;
import com.ssafy.trip.dto.user.UserImgFileDto;
import com.ssafy.trip.dto.user.UserSearchResponseDto;
import com.ssafy.trip.model.mapper.FriendMapper;
import com.ssafy.trip.model.mapper.UserMapper;

@Service
public class UserService {

	
	@Value("${app.fileupload.uploadDir}")
	private String uploadFolder;

	@Value("${app.fileupload.uploadPath}")
	private String uploadPath;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private FriendMapper friendMapper;
	
	public User login(User loginInfo) throws SQLException {
		return userMapper.login(loginInfo);
	}
	
	public void regist(User user) throws SQLException {
		userMapper.regist(user);
	}
	
	public User profile(String name) throws SQLException {
		return userMapper.profile(name);
	}
	
	public void delete(String id) throws SQLException {
		userMapper.delete(id);
	}
	
	public User SearchbyID(String id) throws SQLException {
		return userMapper.SearchbyID(id);
	}
	
	public void update(User user) throws SQLException {
		userMapper.update(user);
	}

	public int checkId(String id) throws SQLException {
		return userMapper.checkId(id);
	}

	public List<UserSearchResponseDto> friendSearch(Map<String, String> map) throws SQLException {
		List<UserSearchResponseDto> list = userMapper.friendSearch(map);
		
		List<FriendFollowingResponseDto> friendList = friendMapper.friendFollowing(map.get("id"));
		
		for (UserSearchResponseDto user : list) {
			for (FriendFollowingResponseDto friend : friendList) {
				System.out.println("userId : " + user.getId()  + " , " + "friend id : " + friend.getToId());
				System.out.println(user.getId().equals(friend.getToId()));
				if (user.getId().equals(friend.getId())) {
					System.out.println(1111);
					user.setFriend(true);
				}
			}
			if (user.getId().equals(map.get("id"))) {
				user.setSameUser(true);
			}
		}

		return list;
	}

	public int updateUser(User user) {
		return userMapper.updateUser(user);
	}

	public int updatePassword(User user) {
		return userMapper.updatePassword(user);
	}

	public int findPassword(UserFindPasswordRequestDto userDto) {

		System.out.println(11);
		User findPwResultDto = userMapper.findPassword(userDto.getUserId());
//			System.out.println(findPwResultDto);
		if (findPwResultDto != null && findPwResultDto.getEmail().equals(userDto.getUserEmail())) {
			// 랜덤 PW로 변경
			System.out.println(22);
			final String newPassword = getRandomPassword(12);
			System.out.println(33);
			findPwResultDto.setPassword(newPassword);
			System.out.println(44);
			// 변경된 PW로 DB에 반영 후, 메일 전송
			// ?? 트랜잭션..??
			if (userMapper.updatePassword(findPwResultDto) == 1 && sendInitPwEmail(findPwResultDto)) {
				return 1;
			} else {
				return 0;
			}
		} else {
			System.out.println(55);
			return 0;
		}
	}
	
	private static String getRandomPassword(int len) {

        char[] charSet = new char[] {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            '@', '#', '$', '%', '^', '&', '!', '*'
        };
        StringBuilder sb = new StringBuilder(len);
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            sb.append(charSet[random.nextInt(charSet.length)]);
        }
        return sb.toString();
    }
	
	private static boolean sendInitPwEmail(User userDto) {


		final String charSet = "utf-8";
        final String hostSMTP = "smtp.naver.com";
        final String hostSMTPid = "testtest19";
        final String hostSMTPpwd = "spdlqjxptmxm19";

        final String fromEmail = "testtest19@naver.com";
        final String fromName = "Enjoy Trip";
        final String subject = "Enjoy Trip 계정 패스워드 초기화 정보입니다.";
        String msg = "<div style='border: 1px solid black; padding: 10px; font-family: verdana;'>";
        msg += "<h2>안녕하세요. <span style='color: blue;'>" + userDto.getName() + "</span>님.</h2>";
        msg += "<p>초기화된 비밀번호를 전송해 드립니다. 비밀번호를 변경하여 사용하세요.</p>";
        msg += "<p>임시 비밀번호 : <span style='color: blue;'>" + userDto.getPassword() + "</span></p></div>";

        try {

            HtmlEmail email = new HtmlEmail();

            email.setDebug(true);
            email.setCharset(charSet);
            email.setSSLOnConnect(true);
            email.setHostName(hostSMTP);
            email.setSmtpPort(465);

            email.setAuthentication(hostSMTPid, hostSMTPpwd);
            email.setStartTLSEnabled(true);
            email.addTo(userDto.getEmail(), userDto.getName(), charSet);
            email.setFrom(fromEmail, fromName, charSet);
            email.setSubject(subject);
            email.setHtmlMsg(msg);

            email.send();

            return true;
        } catch (Exception e) {
            return false;
        }
    }
	
	public String userFileInsert(MultipartHttpServletRequest request) throws IllegalStateException, IOException {

		String userId = request.getParameter("userId");
		// 파일 경로 찾기
        File uploadDir = new File(uploadPath + File.separator + uploadFolder);
        if (!uploadDir.exists()) uploadDir.mkdir();
        
        // 물리 파일 삭제 (존재 시)
        String fileUrl = userMapper.userDetailFile(userId);
        if (fileUrl != null && !fileUrl.isEmpty()) {
        	File file = new File(uploadPath + File.separator, fileUrl);
            if (file.exists()) file.delete();
        }
        
        // 파일 테이블에서 제거
        userMapper.userImgFileDelete(userId);
        MultipartFile part = request.getFile("userProfileImage");
        String fileName = part.getOriginalFilename();
          
        // Random File Id
        UUID uuid = UUID.randomUUID();
        
        // file 확장사
        String extension = FilenameUtils.getExtension(fileName); // vs FilenameUtils.getBaseName()

        String savingFileName = uuid + "." + extension;
    
        File destFile = new File(uploadPath + File.separator + uploadFolder + File.separator + savingFileName);
        
//            System.out.println("실제저장경로");
        part.transferTo(destFile);
    
        // Table Insert
        UserImgFileDto userFileDto = new UserImgFileDto();
        userFileDto.setUserId(userId);
        userFileDto.setFileName(fileName);
        userFileDto.setFileSize(part.getSize());
        userFileDto.setFileContentType(part.getContentType());
        String userFileUrl = "/" + uploadFolder + "/" + savingFileName;
        userFileDto.setFileUrl(userFileUrl);
//            System.out.println(userFileDto);
        userMapper.userImgFileInsert(userFileDto);

		return userFileUrl;
	}

}
