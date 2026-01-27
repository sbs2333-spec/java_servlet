package web_servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class servlet13 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String message = "";	//Javascript 언어를 적용하기 위한 변수
		String agree1 = request.getParameter("agree1");
		String agree2 = request.getParameter("agree2");
		String agree3 = request.getParameter("agree3");
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String memail = request.getParameter("memail");
		String person = request.getParameter("person");
		
		ArrayList<String> info = new ArrayList<String>();
		if(!"Y".equals(agree1) || !"Y".equals(agree2) || !"Y".equals(agree3)) {
			message = "alert('올바른 방식의 접근이 아닙니다.'); history.go(-1);";
		}		
		else {
			info.add(mid);
			info.add(mpw);
			info.add(memail);
			info.add(person);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("./servlet13.jsp");
		rd.forward(request, response);
		request.setAttribute("message", message);
		request.setAttribute("info", info);
		
		
	}

}