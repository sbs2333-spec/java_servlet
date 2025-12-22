package web_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	ArrayList<String> member = new ArrayList<String>();   
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String mid = request.getParameter("mid");
		String mpass = request.getParameter("mpass");
		String mname = request.getParameter("mname");
		String mtel = request.getParameter("mtel");
		String memail = request.getParameter("memail");
		
		//PrintWriter : 웹에서 js를 사용할 수 있는 유일한 io
		PrintWriter pw = response.getWriter();
		
		if (mid.equals("") || mpass.equals("") || mname.equals("") || mtel.equals("") || memail.equals("")) {
				//Javascript 코드를 PrintWriter에 사용하는 방식
				//history.go(-1) ☞ 전 페이지로 돌아가는 메소드
				pw.write("<script>"
						+ "alert('올바른 정보가 아닙니다.');"
						+ "history.go(-1);"
						+ "</script>");
				pw.close();
		}	
		else {
			this.member = new ArrayList<String>();
			this.member.add(mid);
			this.member.add(mpass);
			this.member.add(mname);
			this.member.add(mtel);
			this.member.add(memail);			
		}
		request.setAttribute("member", this.member);
		RequestDispatcher rd = request.getRequestDispatcher("servlet2.jsp");
		rd.forward(request, response);
		
	}
}


