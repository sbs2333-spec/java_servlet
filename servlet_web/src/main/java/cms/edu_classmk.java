package cms;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.cate_dto;
import model.query2;

public class edu_classmk extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //WEB-INF => Controller에서 jsp를 로드하지 않는 이상 브라우져에서 URL로 접근이 불가능함   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ArrayList<cate_dto> all = new query2().cate_list();
			request.setAttribute("all", all);
		} catch (Exception e) {
			System.out.println(e);
		}
	
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/edu_classmk.jsp");
		rd.forward(request, response);
	}

}
