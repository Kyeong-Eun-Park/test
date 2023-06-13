package com.session.my;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

	private final List<Map<String, String>> userList = new ArrayList<>();
	

	public UserRepository() {

		System.out.println("UserRepository 초기화");
		
		Map<String, String> userInfoOne = new HashMap<String, String>();
		userInfoOne.put("username", "kim");
		userInfoOne.put("password", "1111");
		userInfoOne.put("email", "kim@naver.com");
		userInfoOne.put("role", "admin");
		
		
		Map<String, String> userInfoTwo = new HashMap<String, String>();
		userInfoTwo.put("username", "hong");
		userInfoTwo.put("password", "2222");
		userInfoTwo.put("email", "hong@naver.com");
		userInfoTwo.put("role", "admin");
		
		userList.add(userInfoOne);
		userList.add(userInfoTwo);
		
		System.out.println("UserRepository userList 개수 : " + userList.size());
	}

	//유저 저장
	public void saveUser(Map<String, String> userInfoMap) throws Exception{
		userList.add(userInfoMap);
		System.out.println("UserRepository userList 개수 : " + userList.size());

		
	}

	//유저 조회
	public Map<String, String> selectUser(Map<String, String> userInfoMap) throws Exception{
		//결과 문구
		Map<String, String> resultMap = new HashMap<>();
		
		//전달 받은 유저 정보
		String userName = userInfoMap.get("username");
		String userPassword = userInfoMap.get("password");
		
		
		//유저 정보 찾기
		for (int i = 0; i < userList.size(); i++) {
			
			Map<String, String> targetUser = userList.get(i);
			
			//서버에 저장된 유저 정보
			String targetUserName = targetUser.get("username");
			String targetUserPassword = targetUser.get("password");
			String targetUserRole = targetUser.get("role");
			
			
			//이름체크
			//db에 해당유저명이 존재한다면(참고로 유저명은 유니크하다고 가정한다.)
			if(userName.equals(targetUserName)) {
				
				//비밀번호 체크
				if(userPassword.equals(targetUserPassword)) {
					
					
					//로그인 성공
					resultMap.put("msg", "로그인성공");
					resultMap.put("rst", "S");
					resultMap.put("userRole", targetUserRole);
					resultMap.put("userName", targetUserName);
					
					return resultMap;
					
				}else {
					resultMap.put("msg", "비밀번호가 틀렸습니다.");
					resultMap.put("rst", "F");
				}
				
				
			}else {
				resultMap.put("msg", "username이 존재하지 않습니다.");
				resultMap.put("rst", "F");
				
			}

		}
		
		return resultMap;
	}
	
}
