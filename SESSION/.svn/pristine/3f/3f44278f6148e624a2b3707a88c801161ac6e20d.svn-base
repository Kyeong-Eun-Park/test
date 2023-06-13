package com.session.my;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class JoinController {
	

	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value = "/joinPage", method = RequestMethod.GET)
	public String joinPage(HttpSession session) throws Exception{
		
		System.out.println("joinPage - 진입");
		System.out.println("session id : " + session.getId());
		
		
		return "joinPage";
	}
	
	//https://blog.naver.com/writer0713/221853596497
	@RequestMapping(value = "/joinProc", method = RequestMethod.POST)
	//@ModelAttribute 가 Uesr 앞에 암묵적으로 붙어있음.
	//@RequestBody 는 클라이언트에서 content-type 을 application/json으로 보낼때 사용.
	//@ModelAttribute 는 클라이언트에서 content-type 을 application/x-www-form-urlencoded 일때 사용.
	public String joinProc(User user, HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		System.out.println("joinProc - 진입");
		
		//세션
		HttpSession session =	request.getSession();
		
		
		//가입자 정보
		String sessionId = session.getId();
		String username = user.getUsername();
		String password = user.getPassword();
		String email = user.getEmail();

		System.out.println("id : "+ sessionId);
		System.out.println("username : "+ username);
		System.out.println("password : "+ password);
		System.out.println("email : "+ email);
		

		
		//회원정보 저장
		Map<String, String> userInfoMap = new HashMap<String, String>();
		userInfoMap.put("id", sessionId);
		userInfoMap.put("username", username);
		userInfoMap.put("password", password);
		userInfoMap.put("email", email);
		userInfoMap.put("role", "user");
		
		//db 에 저장
		userRepository.saveUser(userInfoMap);
		
		
		//스프링 서버에서 세션을 생성한다.
		//스프링에 세션 객체가 존재한다.
		//서버에서 생성한 세션은 서버에서 삭제해줘야한다. 
		//웹브라우저에서 캐쉬삭제해도 남는다.
		session.setAttribute("userSession", username);
		session.setAttribute("role", "user");
		
		
		//쿠키 셋팅
		Cookie loginCookie = new Cookie("userCookie", session.getId());
		loginCookie.setPath("/");
		loginCookie.setMaxAge(60 * 60 * 24 * 7);
		response.addCookie(loginCookie);
		
		return "home";
	}
	
	
	
	
}
