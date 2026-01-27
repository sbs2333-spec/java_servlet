package admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.admin_query;
import model.cate_dto;

public class cate_list extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<cate_dto> all = null;
		try {
			all = new admin_query().all_cate();
		} catch (Exception e) {
			all = null;
			System.out.println(e);
		}
		request.setAttribute("all", all);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/cate_list.jsp");
		rd.forward(request, response);
	}

}
