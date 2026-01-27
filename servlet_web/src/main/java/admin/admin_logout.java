package admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class admin_logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession();
		//특정 session 값만 삭제 할 때 사용하는 메소드 입니다.
		hs.removeAttribute("admin_id");
		hs.removeAttribute("admin_name");
		String result = "alert('정상적으로 로그아웃 되었습니다.'); location.href='./admin_login.jsp';";
		
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("/cms/message.jsp");
		rd.forward(request, response);
	}

}
