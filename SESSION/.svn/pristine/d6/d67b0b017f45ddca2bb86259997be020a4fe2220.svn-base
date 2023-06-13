package com.session.my;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//Interceptor를 구현하는 방법은 2가지가 있는데, 
//HandlerInterceptor 인터페이스를 구현하는 방법과 HandlerInterceptorAdapter 클래스를 상속 받는 방법이 있습니다.
public class AuthLoginInterceptor extends HandlerInterceptorAdapter{
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
								Object handler) throws Exception {
		
		// 이렇게 설정을 하면 컨트롤러에서 /joinProc 요청을 처리하는 메서드가 있을 필요가 없습니다.
		System.out.println("AuthLoginInterceptor - preHandle");
		
		
		/*
		
		HttpSession session =	request.getSession();
		
		
		String sessionId = session.getId();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");

		
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
		
	
		userRepository.saveUser(userInfoMap);
		
		
		
		//세션에 넣기
		User user  = new User();
		user.setId(sessionId);
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
				
		session.setAttribute("LOGIN", user);
		
*/
		
//		//쿠키 셋팅
//		HttpSession session =	request.getSession();
//		Cookie loginCookie = new Cookie("loginCookie", session.getId());
//		loginCookie.setPath("/");
//		loginCookie.setMaxAge(60 * 60 * 24 * 7);
//		response.addCookie(loginCookie);
		
		return true;
	}
	
	
	//가입 후
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		
		System.out.println("AuthLoginInterceptor - postHandle");
			
		
		
//			HttpSession session =	request.getSession();
//			ModelMap modelMap =  modelAndView.getModelMap();
//			Object userVO = modelMap.get("userVO");
//			
//			
//			
//		if (userVO != null) {
//			
//			session.setAttribute("LOGIN", userVO);
//		}
//			
//			
//			
//			if (request.getParameter("useCookie") != null) {
//
//				Cookie loginCookie = new Cookie("loginCookie", session.getId());
//				loginCookie.setPath("/");
//				loginCookie.setMaxAge(60 * 60 * 24 * 7);
//
//				response.addCookie(loginCookie);
//
//		}
//			Object dest = session.getAttribute("dest");
//			response.sendRedirect(dest != null ? (String)dest : "/");
//			
//			
			
	}
}