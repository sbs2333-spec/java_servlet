package web_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class slex1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<String> bbsdata = null;    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
	
		String tt = request.getParameter("tt");
		String mname = request.getParameter("mname");
		String note = request.getParameter("note");		
		String mpass = request.getParameter("mpass");
		
		PrintWriter pw = response.getWriter();
		
		if(tt.equals("") || tt.equals(null) || mname.equals("") || mname.equals(null) || note.equals("") || note.equals(null) || mpass.equals("") || mpass.equals(null)) {
			pw.write("<script>"
					+ "alert('올바른 정보가 입력되지 않았습니다.');"
					+ "history.go(-1);"
					+ "</script>");
			pw.close();
			// System.out.println("올바른 정보가 입력되지 않았습니다.");
		}
		else {
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String wdate = sdf.format(now);
			
			this.bbsdata = new ArrayList<String>();  
			
			this.bbsdata.add(tt);
			this.bbsdata.add(mname);
			this.bbsdata.add(note);
			this.bbsdata.add(mpass);
			this.bbsdata.add(wdate);
		}
		request.setAttribute("bbsdata", this.bbsdata);	
		RequestDispatcher rd = request.getRequestDispatcher("./slex1.jsp");
		rd.forward(request, response);
		
	}

}




		