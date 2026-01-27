package admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.admin_query;

//API 통신
public class cate_api extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	PrintWriter pw = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Access-control-allow-origin", "172.30.1.50");
		response.setHeader("Access-control-max-age", "600"); //10분
		
		String code = request.getParameter("code");	//front-end ajax 변수값
		this.pw = response.getWriter();
		if(code == null || code.equals("")) {
			this.pw.print("<script>history.go(-1);</script>");
		}
		else {
			try {
				Integer result = new admin_query().cate_del(code);
				if(result > 0) {
					this.pw.print("ok");
				}
				else {
					this.pw.print("no");
				}
			}catch (Exception e) {
				System.out.println(e);
				this.pw.print("no");
			}
			finally {
				this.pw.close();
			}
		}
	}

}
