package cms;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession();
		hs.invalidate();	//session으로 생성 되어 있는 모든 데이터를 파기 함
		String result = "alert('정상적으로 로그아웃 되었습니다.'); location.href='../index.jsp';";
		
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("./message.jsp");
		rd.forward(request, response);
	}
}
