package web_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class servlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//해당 class는 view가 없이 스크립트로 핸들링 후 다른 페이지로 이동
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Integer no = request.getParameter("number");	//무조건 스트링. 숫자는 안 됨. integer는 안 됨. 무조건 String이어야 함
		
		//해당 자바에서 Javascript으로 메시지를 출력하기 위해 한글깨짐 방지
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");	
		String corp = request.getParameter("corp");
		if(corp.equals("")) {
			System.out.println("통신사 선택을 안함");
		} else {
			System.out.println(corp);
		}
		
		//체크 박스는 체크를 안할 경우 null으로 적용되므로, equals를 절대!!!!!! 사용하지 못함!!!!!!
		String ck = request.getParameter("ck");
		PrintWriter pw = response.getWriter();
		
		try {
			//checkbox를 적용시 필수조건이 아닐 경우는 다음과 같이 적용해야만 한다.
			if(ck == null) {	//equals를 쓰면 안됨. 유일하게 체크박스만 null을 써야 한다. 필수사항은 equals를 사용하면 됨. 하지만, 필수가 아닐때는 equals를 쓰면 사고 터짐.
				pw.write("<script>"
						+ "alert('자동 로그인이 무조건 체크 되어야 함');"
						+"history.go(-1);"
						+"</script>");										
			}
			else {
				pw.write("<script>"
						+ "alert('pc방이나 공공장소에는 유의하세요');"
						/* +"location.href='http://naver.com';" */
						+"</script>");						
//				System.out.println("pc방이나 공공장소에는 유의하세요");
			}
			
		} catch (Exception e) {
			System.out.println("전송 오류 발생");
		
		} finally {
			pw.close();
		}
		
			//pw.write(null);
		
		//intern() : HTML에서 필수로 사용자가 무조건 입력하는 사항에서만 가능하다!!!!
		String no = request.getParameter("no").intern();
		String ag = request.getParameter("ag");
		if(no == "") {
			System.out.println("테스트");
		}
		System.out.println(ck);
	}

}
