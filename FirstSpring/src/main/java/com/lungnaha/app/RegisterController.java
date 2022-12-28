package com.lungnaha.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller // 톰캣이 실행할 수 있도록 클래스 등록  
public class RegisterController {
	//@RequestMapping("/register/add")
	@GetMapping("/register/add")
	public String register() {
		return "registerForm"; // WEB-INF/views/registerForm.jsp 의미  
	}
	
	//@RequestMapping(value="/register/save", method=RequestMethod.POST) // GET 방식을 사용하지 못하도록 함
	@PostMapping("register/save") // 위와 동일한 의미 
	public String save() {
		return "registerinfo";
	}
}
