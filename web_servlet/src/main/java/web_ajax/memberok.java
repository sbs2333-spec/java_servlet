package web_ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class memberok extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//form통신
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userid = request.getParameter("userid");
		String userpw = request.getParameter("userpw");
		String companynm = request.getParameter("companynm");
		String ceonm = request.getParameter("ceonm");
		String corpno = request.getParameter("corpno");
	}

}