package com.session.my;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class AdminController {
	
	@RequestMapping(value = "/adminPage", method = RequestMethod.GET)
	@ResponseBody
	public String adminPage(HttpServletRequest request, Model model) {
		
		System.out.println("adminPage - 진입");

		Cookie[] myCookies = request.getCookies();
		if(myCookies != null) {
			for (int i = 0; i < myCookies.length; i++) {
				System.out.println(i + "번째 쿠키 이름: " + myCookies[i].getName());
				System.out.println(i + "번째 쿠키 값: " + myCookies[i].getValue());
			}
		}
		
		
		return "관리자페이지입니다.";
	}
	
}
