package web_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class servlet11 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
//		response.setCharacterEncoding("UTF-8");		//이 줄을 지우고 위처럼 ;charset=UTF-8을 쓰면 한줄로 됨.  
		request.setCharacterEncoding("UTF-8");
		
		//프런트에서 같은 name 속성의 이름으로 전달하였을 경우 배열값으로 받아야 하며, getParameterValues 메소드를 이용한다. 
		String user[] = request.getParameterValues("user");
		PrintWriter pw = response.getWriter();
		if(user.length < 2) {
			pw.write("<script>"
					+ "alert('2개 이상의 데이터가 아닙니다.');"
					+"history.go(-1);"
					+"</script>");
			pw.flush();
			pw.close();			
		}
		else {
			request.setAttribute("user", user);
			RequestDispatcher rd = request.getRequestDispatcher("./servlet11.jsp");
			rd.forward(request, response);
		}
		
		System.out.println(Arrays.toString(user));
	}

}