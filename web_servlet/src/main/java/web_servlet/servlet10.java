package web_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class servlet10 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String message ="";	//결과값을 view(jsp)에 전달하는 변수
	String part ="";	//결과값을 대한 조건 형태의 view를 설정하는 변수
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String info = request.getParameter("info");
		
		if(info.equals("idsearch")) {
			String mname = request.getParameter("mname");
			String memail = request.getParameter("memail");
			this.message = "hong";
			this.part = "id";
		}
		else if (info.equals("pwdsearch")) {	//패스워드 찾기
			String mid = request.getParameter("mid");
			String username = request.getParameter("username");			
			this.message = "a123456";
			this.part = "pw";
		}
		else {	//외부에서 허락없이 접근을 하였을 경우
			PrintWriter pw = response.getWriter();
			pw.write("<script>"
					+ "alert('올바른 접근이 아닙니다');"
					+"history.go(-1);"
					+"</script>");
			pw.flush();
			pw.close();
		}		
		
		request.setAttribute("part", this.part);	//jsp view 형태의 폼 구분 변수
		request.setAttribute("msg", this.message);	//controller 에서 view 결과값을 전달
		
		RequestDispatcher rd = request.getRequestDispatcher("./result.jsp");
		rd.forward(request, response);
		
		System.out.println(info);
		String mname = request.getParameter("mname");
		System.out.println(mname);
	}

}