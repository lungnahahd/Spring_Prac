package com.lungnaha.app;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
	@GetMapping("/login")
	public String loginForm() {
		return "loginForm";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();// 세션을 종료 
		
		
		return "redirect:/";
	}
	
	@PostMapping("/login")
	public String login(String id, String pwd, String toURL, boolean rememberId, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// id와 pwd를 확인
		if(!loginCheck(id,pwd)) {
			String msg = URLEncoder.encode("id 또는 pwd가 일치하지 않습니다.","utf-8");
			return "redirect:/login/login?msg=" + msg;
		}
		
		HttpSession session = request.getSession();// 세션 가져오기
		session.setAttribute("id", id);// 세션에 정보 포함 
		
		Cookie cookie = new Cookie("id",id); // 쿠키 생성
		if(rememberId) {
			cookie.setMaxAge(60*60*24); // 유효기간 지정
		}else {
			cookie.setMaxAge(0);
		}
		response.addCookie(cookie);
		
		toURL = toURL == null || toURL.equals("") ? "/" : toURL; // 삼항 연산자를 사용해서 처리 
		
		return "redirect:" + toURL;
	}

	private boolean loginCheck(String id, String pwd) {
		return "test".equals(id) && "1234".equals(pwd);
	}
}
