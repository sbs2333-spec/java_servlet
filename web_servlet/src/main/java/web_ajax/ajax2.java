package web_ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ajax2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
      //jquery로 ajax GET 통신 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	PrintWriter pw = response.getWriter();
		try {
			String mid = request.getParameter("mid");
			if(mid.equals("hong") || mid.equals("apink")) {
				pw.print("no");
			}
			else {
				pw.print("ok");
			}
			
			//pw.print("ok");
			pw.close();
			
		} catch (Exception e) {
			pw.print("error");
			pw.close();
		}
	}

}
