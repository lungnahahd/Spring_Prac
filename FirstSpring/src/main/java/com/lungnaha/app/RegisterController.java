package com.lungnaha.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 톰캣이 실행할 수 있도록 클래스 등록  
public class RegisterController {
	@RequestMapping("/register/add")
	public String register() {
		return "registerForm"; // WEB-INF/views/registerForm.jsp 의미  
	}
	
	@RequestMapping("/register/save")
	public String save() {
		return "registerinfo";
	}
}
