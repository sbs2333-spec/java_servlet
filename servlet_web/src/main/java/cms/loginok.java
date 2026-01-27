package cms;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.member_dto;
import model.query;

public class loginok extends HttpServlet {
	private static final long serialVersionUID = 1L;
  		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mid = request.getParameter("mid");
		String mpass = request.getParameter("mpass");
		String result = "";
		try {
			if(mid == null || mpass == null) {
				result = "alert('올바른 접근이 아닙니다.'); location.href='../member_login.jsp';";	
			}
			else {
				//Model에서 생성된 dto 값을 Controller에 받아서 처리
				member_dto dto = new mysql_querys().member_select(mid);	
				if(dto.getMid() == "") {
					result = "alert('회원정보가 확인 되지 않습니다.'); history.go(-1);";
				}
				else {
					if(dto.getMpass().equals(mpass)) {
						result = "alert('로그인 하셨습니다.'); location.href='../index.jsp';";
						/*
						 cookie : 브루아져에 cache 메모리에 값을 저장하는 방식 (20개) 
						 session : 일정시간 동안 브라우져에 해당 값을 저장 및 유지시키는 방식
						 storage(session) : cache메모리 (local, session) 
						 */
						HttpSession hs = request.getSession();	//메모리에 해당 정보를 저장하기 위한 클래스
						hs.setAttribute("mid", dto.getMid());	//사용자 관련 정보를 저장하게 됨
						hs.setAttribute("mname", dto.getMname());
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
class mysql_querys extends query{}
