package com.lungnaha.app;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller // 톰캣이 실행할 수 있도록 클래스 등록  
public class RegisterController {
	//@RequestMapping("/register/add")
//	@GetMapping("/register/add")
//	public String register() {
//		return "registerForm"; // WEB-INF/views/registerForm.jsp 의미  
//	}
	
	// 위의 주석은 단순 jsp 파일만을 보여주는 역할을 하므로 servlet-context.xml에 view-controller를 등록해서 사용 
	
	//@RequestMapping(value="/register/save", method=RequestMethod.POST) // GET 방식을 사용하지 못하도록 함
	@PostMapping("register/save") // 위와 동일한 의미 
	public String save(User user, Model model) throws Exception {
		//입력 값 유효성 검사 진행 
		if(!isValid(user)) {
			String msg = URLEncoder.encode("id를 잘못 입력하셨습니다.","utf-8");
			model.addAttribute("msg", msg);
			return "redirect:/register/add?msg="; // model에 담아서 메시지를 넘기면 아래의 한 문장과 동일  
//			return "redirect:/register/add?msg="+msg; // url 재작성 
			
		}
		return "registerinfo";
	}

	private boolean isValid(User user) {
		return false;
	}
}
