package com.session.my;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LoginController {
	

	@Autowired
	private UserRepository userRepository;
	
	//로그인 페이지
	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public String loginPage(Model model) {
		
		System.out.println("loginPage - 진입");
		
		//model.addAttribute("serverTime", formattedDate );
		
		return "loginPage";
	}
	
	//로그인
	@RequestMapping(value = "/loginProc", method = RequestMethod.POST)
	public String loginProc(User user, HttpServletRequest request, HttpServletResponse response, Model model) throws Exception{
		
		System.out.println("loginProc - 진입");
		
		String username = user.getUsername();
		String password = user.getPassword();


		System.out.println("username : "+ username);
		System.out.println("password : "+ password);

		
		//회원정보 저장
		Map<String, String> userInfoMap = new HashMap<String, String>();
		userInfoMap.put("username", username);
		userInfoMap.put("password", password);

		
		//db에서 조회
		Map<String, String> resultMap = userRepository.selectUser(userInfoMap);
		
		//로그인 성공
		if(resultMap.get("rst").equals("S")) {
			
			//세션 : 유저명 + 권한
			HttpSession session =	request.getSession();
			session.setAttribute("userSession", resultMap.get("userName"));
			session.setAttribute("role", resultMap.get("userRole"));
			
			
			return "redirect:/";
		
		}else {
			//로그인 실패
			model.addAttribute("msg", resultMap.get("msg") );
			
		}
		
		
		return "loginPage";

	}
	
	
	//로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		
		System.out.println("logout - 진입");
		
		//세션 끊기		
		HttpSession session = request.getSession();
        session.invalidate();

		
		return "home";
	}
	
	
}
