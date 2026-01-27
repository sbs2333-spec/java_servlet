package admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.admin_dto_내것;
import model.admin_query_내것;
import model.member_dto;

public class admin_login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String mid = request.getParameter("admin_id");
		String mpass = request.getParameter("admin_pw");
		String result = "";
		System.out.println(mid);
		System.out.println(mpass);
		try {
			if(mid == null || mpass == null) {
				result = "alert('올바른 접근이 아닙니다.'); location.href='../admin_login.jsp';";	
			}
			else {
				//Model에서 생성된 dto 값을 Controller에 받아서 처리
				admin_dto_내것 dto = new admin_query_내것().admin_login(mid);	
				//System.out.println(dto.getAdmin_nm());
				if(dto.getAdmin_id() == "") {
					result = "alert('회원정보가 확인 되지 않습니다.'); history.go(-1);";
				}
				else {
					if(dto.getAdmin_pw().equals(mpass)) {
						result = "alert('로그인 하셨습니다.'); location.href='./admin_main.jsp';";
						HttpSession hs = request.getSession();	//메모리에 해당 정보를 저장하기 위한 클래스
						hs.setAttribute("admin_id", dto.getAdmin_id());	//사용자 관련 정보를 저장하게 됨
						hs.setAttribute("admin_nm", dto.getAdmin_nm());
					}
					else {
						result = "alert('회원정보를 확인하세요'); history.go(-1);";
					}
				}
			}
		} catch (Exception e) {
			
		} 
			
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("./message.jsp");
		rd.forward(request, response);
	}
}
