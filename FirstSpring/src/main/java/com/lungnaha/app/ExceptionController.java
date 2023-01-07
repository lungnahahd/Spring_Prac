package com.lungnaha.app;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;


// 사용자 정의 에러 클래스 생성 
@ResponseStatus(HttpStatus.BAD_REQUEST)
class MyException extends RuntimeException{
	MyException(String msg){
		super(msg);
	}
	MyException() {this("");}
}



@Controller
//@ControllerAdvice 어노테이션을 사용하면 해당 컨트롤러가 아니라도 어디에서든 @ExceptionHandler 호출 가
public class ExceptionController {
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // 해당 어노테이션으로 상태코드를 200 -> 500 으로 변경 
	public String catcher(Exception ex, Model m) {
		m.addAttribute("ex",ex); // view 에서 보여주기 위한 정보를 model을 통해서 넘겨주
		return "error";
	}
	
	@RequestMapping("/ex")
	public void main() throws Exception {
		throw new Exception("예외가 발생했습니다. "); 
	}
	
	@RequestMapping("/ex2")
	public String main2() throws Exception{
		throw new MyException("예외가 발생했습니다. ");
	}
	
}
