package web_servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 해당 클래스는 웹에서 가상으로 제공되는 Java 입니다. 즉, extends HttpServlet
 servlet이라는 class를 상속 받아서 웹이 작동되도록 하는 웹 전용 클래스입니다.

doGet → GET통신
doPost → POST 통신
*/

//Controller 영역
public class servlet1 extends HttpServlet {
	//해당 웹페이지에 접근하는 호출 가능 용량
	private static final long serialVersionUID = 1L;	//접속자수 제한한다. 서버의 경우 1000L 으로도 사용한다.
	//request : 데이터를 받는 역할, response : 데이터를 출력하는 역할
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");	//jsp에 전달될 데이터를 문자 또는 html 코드로 전달할 수 있는 기능
		response.setCharacterEncoding("utf-8");	//jsp로 전달할 때 언어셋
		request.setCharacterEncoding("utf-8");	//HTML에서 name 속성을 받을 때 출력되는 가상의 언어셋	
		
		//request.getParameter : 프런트에서 name 속성의 이름
		String usernm = request.getParameter("usernm");
		String message = "";
		if(usernm.equals("홍길동")) {
			message = "해당 사용자는 실버회원입니다.";
		}
		else {
			message = "해당 사용자는 확인되지 않습니다.";
		}
	//request.setAttribute	→ Java 클래스에서 jsp에 출력하기 위한 메소드
	//request.getAttribute	→ Java 클래스에서 보내준 데이터를 로드하는 메소드
	request.setAttribute("message", message);  //해당("별명명칭", 변수)
	
	//RequestDispatcher : view를 담당하며 해당 jsp에 대한 경로및 파일명을 설정
	RequestDispatcher rd = request.getRequestDispatcher("/servlet1.jsp");
	rd.forward(request, response);  //.do가 실행되었을 때, .jsp파일을 로드하여 같이 출력
		
//		System.out.println(usernm);
	}
}









