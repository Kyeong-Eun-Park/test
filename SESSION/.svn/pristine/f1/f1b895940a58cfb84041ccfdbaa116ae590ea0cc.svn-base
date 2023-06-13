package com.session.my;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ProductController {
	
	//상품 목록
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String selectProductList(HttpServletRequest request, Model model) {
		
		System.out.println("selectProductList - 진입");

		return "product";
	}
	
	//상품 상세
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String selectProduct(@RequestParam String name , @RequestParam String id ,HttpServletRequest request, Model model) {
		
		System.out.println("selectProduct - 진입");
		
		System.out.println("prodId : " + id);
		System.out.println("prodName : " + name);
		
		
		//세션에 클릭한 상품 정보 넣어주기
		HttpSession session =	request.getSession();
		session.setAttribute("prodId", id);
		session.setAttribute("prodName", name);
		
		
		//특정 세션 삭제
		//session.removeAttribute("prodId");
		//session.removeAttribute("prodName");

		
		model.addAttribute("prodId", id);
		model.addAttribute("prodName", name);
		
		return "productDetail";
	}
	
}
