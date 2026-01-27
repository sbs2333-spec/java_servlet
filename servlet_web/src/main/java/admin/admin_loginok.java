package admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.admin_dto;
import model.admin_query;
import model.md5_pw;

public class admin_loginok extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	PrintWriter pw = null;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String security = request.getParameter("security");
		this.pw = response.getWriter();
		try {
				if(security == null || !security.equals("admin_602")) {
					this.pw.print("<script>"
							+ "alert('올바른 접근이 아닙니다.');"
							+ "history.go(-1);"
							+ "</script>");
				}
				else {
					String admin_id = request.getParameter("admin_id");
					String admin_pw = request.getParameter("admin_pw");
					//사용자가 입력한 값을 md5 변환
					String pw = new md5_pw().md5_encode(admin_pw);
					
					//Database에서 query문 적용 후 dto로 return 결과를 받음
					admin_dto ad = new admin_query().admin_select(admin_id);
					if(ad.getAdmin_pw().equals(pw)) {
						//일반사용자에 사용하는 session 정보와 관리자에서 사용하는 session 정보가 달라야 합니다.
						HttpSession hs = request.getSession();
						hs.setAttribute("admin_id", ad.getAdmin_id());
						hs.setAttribute("admin_name", ad.getAdmin_nm());
						this.pw.print("<script>"
								+ "alert('로그인 하셨습니다.');"
								+ "location.href='./admin_main.do';"
								+ "</script>");
					}
					else {
						this.pw.print("<script>"
								+ "alert('아이디 및 패스워드를 확인하세요');"
								+ "history.go(-1);"
								+ "</script>");
					}
				}
		}catch (Exception e) {
			System.out.println(e);
			this.pw.print("<script>"
					+ "alert('아이디 및 패스워드를 확인하세요');"
					+ "history.go(-1);"
					+ "</script>");
		}finally {
			this.pw.close();
		}
	}

}
