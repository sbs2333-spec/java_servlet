package web_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class servlet5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		res.setCharacterEncoding("UTF-8");
		PrintWriter pw = res.getWriter();
		pw.write("<script>"
				+ "location.href=' ./servlet5.html';"
//				+ "alert('해당 페이지 접근 금지!!');"
//				+ "window.self.close();"	//아래처럼 2줄로 하든지 혹은 이 줄처럼 창을 닫도록 한다. → 안되는 브라우저도 있음. 알아만 둘 것
//				+ "alert('해당 접근 방식은 올바르지 않습니다.');" 
//				+ "history.go(-1);"
				+ "</script>");
		pw.close();
	}
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");   //이메일중 도메인이 한글로 된 사항이 있음
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		//아래는 프런트가 잘못할때 변수를 2개 받아야 하는 경우
		/*
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		System.out.println(email1);
		System.out.println(email2);
		*/
		
		String email = request.getParameter("email");	//이 줄은 프런트가 경력이 많은 경우 이메일을 하나의 변수로 던져줄 때.
		PrintWriter pw = response.getWriter();
		String message = "";	//스크립트 언어를 적용하기 위한 변수
		if(email.equals("sbs2333@naver.com")) {
			message = "alert('이미 가입된 이메일입니다.');history.go(-1);";
		}
		else {
			message = "alert('인증 번호 이메일을 발송하였습니다. ');history.go(-1);";			
		}
		//Javascript 태그를 이용하여 작동시키는 코드
		pw.write("<script>" + message + "</script>");
		
		System.out.println(email);
	}

}