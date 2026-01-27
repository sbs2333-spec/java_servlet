package web_ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class usercheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	PrintWriter pw = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.addHeader("access-control-allow-origin", "*");
		response.addHeader("access-control-allow-credentials", "true");
		this.pw = response.getWriter();
		try {
			String part = request.getParameter("part");
			String data = request.getParameter("data");	//아이디 및 사업자번호
			String find = "";
			
			if(part.equals("1")) {	//아이디 검색
				find = new data_check().idsearch(data);
				this.pw.print(find);			
			}
			else if (part.equals("2")) {  //사업자 번호 검색
				System.out.println(data);			
			}
			else {
				this.pw.print("error");					
			}
			
		} catch (Exception e) {
			this.pw.print("error");			
			
		} finally {
			this.pw.close();
		}		
	}

}