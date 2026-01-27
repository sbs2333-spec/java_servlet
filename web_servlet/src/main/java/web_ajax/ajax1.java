package web_ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ajax1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//GET 통신
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		try {
			//프런트엔드에서 파라미터 이름으로 전송된 값을 받아서 확인
			String id = request.getParameter("data");
			
			if (id.equals("hong")){
				pw.print("okok!!");
			}
			else {
				pw.print("no!");
			}
			System.out.println(id);
			
			pw.print("okok!!");	//아래처럼 write를 써도 되고 이 줄처럼 써도 됨. 아무거나 가능. 
//			pw.write("ok!!!!!");	//Ajax에 응답결과를 보내주는 역할
			pw.close();			
		} catch (Exception e) {
			pw.close();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
