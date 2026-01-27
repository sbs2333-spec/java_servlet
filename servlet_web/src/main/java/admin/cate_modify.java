package admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.admin_query;
import model.cate_dto;

public class cate_modify extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		cate_dto cd = null;
		try{
			if(code != null || !code.equals("")) {
				cd = new admin_query().cate_one(code);
			}else {
				cd = null;
			}
		}
		catch (Exception e) {
			cd = null;
			e.printStackTrace();
		}
		finally {

		}
		request.setAttribute("cd", cd);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/cate_modify.jsp");
		rd.forward(request, response);
	}

}
