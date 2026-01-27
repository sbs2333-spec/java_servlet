package admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.admin_dto;
import model.admin_query;
import model.md5_pw;

public class cate_insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/cate_insert.jsp");
		rd.forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
//		String security = request.getParameter("security");
//		this.pw = response.getWriter();
//		try {
//			if(security == null || !security.equals("admin_602")) {
//				this.pw.print("<script>"
//						+ "alert('올바른 접근이 아닙니다.');"
//						+ "history.go(-1);"
//						+ "</script>");
//			}
//			else {
//				String admin_id = request.getParameter("admin_id");
//				String admin_pw = request.getParameter("admin_pw");
//				//사용자가 입력한 값을 md5 변환
//				String pw = new md5_pw().md5_encode(admin_pw);
//				//database 에서 query문 적용후 dto로 return 결과를 받음
//				admin_dto ad = new admin_query().admin_select(admin_id);
//				if(ad.getAdmin_pw().equals(pw)) {
//					//일반사용자에서 사용하는 세션 정보와 관리자에서 사용하는 세션 정보가 달라야 한다. 
//					HttpSession hs = request.getSession();	//메모리에 해당 정보를 저장하기 위한 클래스
//					hs.setAttribute("admin_id", ad.getAdmin_id());	//사용자 관련 정보를 저장하게 됨
//					hs.setAttribute("admin_name", ad.getAdmin_nm());
//					this.pw.print("<script>"
//							+ "alert('로그인하셨습니다.');"
//							+ "location.href='./admin_main.do';"
//							+ "</script>");
//
//
//				}
//				else {
//					this.pw.print("<script>"
//							+ "alert('아이디 및 패스워드를 확인하세요.');"
//							+ "history.go(-1);"
//							+ "</script>");
//				}
//				
//			}
//		} catch (Exception e) {
//			System.out.println(e);
//
//		} finally {
//			this.pw.close();
//		}
		
		
		
		
		
		
		
		
	}

}
