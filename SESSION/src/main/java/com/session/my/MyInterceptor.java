package com.session.my;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//Interceptor를 구현하는 방법은 2가지가 있는데, 
//HandlerInterceptor 인터페이스를 구현하는 방법과 HandlerInterceptorAdapter 클래스를 상속 받는 방법이 있습니다.
public class MyInterceptor  implements HandlerInterceptor{
	// controller로 보내기 전에 처리하는 인터셉터
	// 반환이 false라면 controller로 요청을 안함
	// 매개변수 Object는 핸들러 정보를 의미한다. ( RequestMapping , DefaultServletHandler ) 
	
	
	
	/*
	 1.preHandle() 메서드는  컨트롤러가 호출되기 전에 실행됩니다. 
    매개변수 obj는 Dispatcher의 HandlerMapping 이 찾아준 컨트롤러의 메서드를 참조할 수 있는 HandlerMethod 객체입니다.
	 */
	@Override
	public boolean preHandle(
			HttpServletRequest request, HttpServletResponse response,
			Object obj) throws Exception {
		
		System.out.println("MyInterCeptor - preHandle");
		System.out.println("obj : " + obj.getClass());
		
		HttpSession session =	request.getSession();
		
		if(session != null) {
			
			String username = (String)session.getAttribute("userSession");
			
			if(username != null) {
				
				String role = (String)session.getAttribute("role");
				
				System.out.println("role : " + role);
				
				if(role.equals("admin")) {
					return true;
				}
				
			}else {
				System.out.println("username이 존재하지 않습니다.");
			}
			
		}else {
			System.out.println("세션이 존재하지 않습니다.");
			
		}

		//home으로 리턴 (특정페이지로 리턴 가능)
		response.sendRedirect(request.getContextPath() + "/");
		
		//false 가 리턴되면 요청 이후로 안넘어간다.
		return false;
	}

	// controller의 handler가 끝나면 처리됨
	@Override
	public void postHandle(
			HttpServletRequest request, HttpServletResponse response,
			Object obj, ModelAndView mav)
			throws Exception {
	}

	// view까지 처리가 끝난 후에 처리됨
	@Override
	public void afterCompletion(
			HttpServletRequest request, HttpServletResponse response,
			Object obj, Exception e)
			throws Exception {
	}
}