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


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale , HttpServletRequest request, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		
		Cookie[] myCookies = request.getCookies();

		if(myCookies != null) {
			for (int i = 0; i < myCookies.length; i++) {
				System.out.println(i + "번째 쿠키 이름: " + myCookies[i].getName());
				System.out.println(i + "번째 쿠키 값: " + myCookies[i].getValue());
			}
		}
		

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
