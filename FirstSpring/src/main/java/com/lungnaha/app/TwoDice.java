package com.lungnaha.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// command + shift + o  -> 자동 import 기능 (MAC 기준)
@Controller
public class TwoDice {
	@RequestMapping("/dice")
	public void main(HttpServletResponse response) throws IOException{
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter(); // html을 화면에 띄워줄 객체
		
		// 나중에는 안 하겠지만, 지금은 html 파일을 아래와 같이 객체 형식으로 전달...(초심에서부터 하자)...
		// 보여지는 이미지 파일을 /src/main/webapp/resources/dice 폴더 내부에 위치(위치 주의)
		
		int randNum = (int)(Math.random()*6) + 1; // 1과 6 사이의 수를 랜덤하 출
		
		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<html>");
		out.println("<body>");
		out.println("<img src='resources/dice/dice"+ randNum + ".jpg'>");
		out.println("</body>");
		out.println("</html>");
		
	}
}
