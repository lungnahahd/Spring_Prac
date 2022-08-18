package com.lungnaha.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

@Controller
public class YoilTeller {
    @RequestMapping("/getYoil") // http://localhost:8080/app/getYoil?year=2021&month=10&day=1
    //    public static void main(String[] args) {
    //public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
    public String main(int year, int month, int day , Model model) throws IOException {
        // 1. 입력
//        String year = args[0];
//        String month = args[1];
//        String day = args[2];

    	// MVC 를 위해 관심사를 분리하면서 아래의 코드는 필요 없음...
//        String year = request.getParameter("year");
//        String month = request.getParameter("month");
//        String day = request.getParameter("day");
//        int yyyy = Integer.parseInt(year);
//        int mm = Integer.parseInt(month);
//        int dd = Integer.parseInt(day);

    	// 1. 유효성 검사
    	if (!isValid(year, month, day)) {
    		return "yoilError";
    	}
    	
        // 2. 처리(요일 계산)
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        char yoil = " 일월화수목금토".charAt(dayOfWeek);
        
        // 3. 계산 결과를 model에 저장
        	// model이 매개 변수로 지정되면 DispatcherServelt이 자동 생
        model.addAttribute("year", year);
        model.addAttribute("month", month);
        model.addAttribute("day", day);
        model.addAttribute("yoil", yoil);
        
        // /WEB-INF/views/yoil.jsp 를 호출해서 보여주겠다는 의미(경로는 정해져 있기에 생략..)
        // 해당 경로는 /WEB-INF/spring/appServlet/servlet-context.xml 에서 기본 경로 설정 변경 가능 
        return "yoil"; 
        
        // 참고로 반환타입은 String이 jsp만 반환하는 것이 일반적..
        // 그러나 ModelAndView 로 Model과 View를 같이 갖는 객체를 반환하도록 하는 것도 가능!
        // 위의 방식을 위해서는 Return 타입을 ModelAndView로 지정하고, 매개변수에서 model 제거
        	// 제거된 model은 ModelAndView 객체를 생성해주면서 생성됨  
        
        
        
        // 출력 부분을 View(jsp) 로 뺐기에 아래 부분은 사용 X
        // 3. 출력
//        System.out.println(year + "년 " + month + "월 " + day + "일은 ");
//        System.out.println(yoil + "요일입니다.");
//        response.setContentType("text/html");    // 응답의 형식을 html로 지정
//        response.setCharacterEncoding("utf-8");  // 응답의 인코딩을 utf-8로 지정
//        PrintWriter out = response.getWriter();  // 브라우저로의 출력 스트림(out)을 얻는다.
//        out.println("<html>");
//        out.println("<head>");
//        out.println("</head>");
//        out.println("<body>");
//        out.println(year + "년 " + month + "월 " + day + "일은 ");
//        out.println(yoil + "요일입니다.");
//        out.println("</body>");
//        out.println("</html>");
//        out.close();
    }

	private boolean isValid(int year, int month, int day) {
		// TODO Auto-generated method stub
		return true;
	}
}
