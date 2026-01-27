package web_ajax;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ajax4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hp = request.getParameter("hp");
		String msg = "";
		try {
			if(hp.equals("")) {
				msg = "error";
			}
			else {
				msg = "234561";						
			}
			
		} catch (Exception e) {
			msg = "error";
		}
		request.setAttribute("msg", msg);
		RequestDispatcher rd = request.getRequestDispatcher("./ajax4.jsp");
		rd.forward(request, response);
	}


}