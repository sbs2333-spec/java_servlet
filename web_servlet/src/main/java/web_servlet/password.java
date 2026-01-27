package web_servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class password extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String mid = request.getParameter("mid");
		String username = request.getParameter("username");
		
		String message = "";
		if(mid.equals("hong_gil_dong") && username.equals("홍길동")) {
			message = "a123456";
		}
		else {
			message = "해당 사용자의 정보를 확인하지 못하였습니다.";
		}
		request.setAttribute("msg", message);
		request.setAttribute("part", "pw");
//		request.setAttribute("part", "id");		//id는 상황에 따라서 다른건가? 25-12-23 15:41
		
		RequestDispatcher rd = request.getRequestDispatcher("./result.jsp");
		rd.forward(request, response);
	}

}








