package com.lungnaha.app;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

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
	
	@PostMapping("/login")
	public String login(String id, String pwd, boolean rememberId, HttpServletResponse response) throws Exception {
		// id와 pwd를 확인
		if(!loginCheck(id,pwd)) {
			String msg = URLEncoder.encode("id 또는 pwd가 일치하지 않습니다.","utf-8");
			return "redirect:/login/login?msg=" + msg;
		}
		Cookie cookie = new Cookie("id",id); // 쿠키 생성
		if(rememberId) {
			cookie.setMaxAge(60*60*24); // 유효기간 지정
		}else {
			cookie.setMaxAge(0);
		}
		response.addCookie(cookie);
		

		return "redirect:/";
	}

	private boolean loginCheck(String id, String pwd) {
		return "test".equals(id) && "1234".equals(pwd);
	}
}
