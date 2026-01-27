package web_ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ajax3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//CORS를 정상적으로 요청을 받을 수 있도록 설정한 값
		/*
			access-control-allow-origin : 특정 도메인 및 모든 외부 client 서버에서 접근을 허용해주는 사항
			* : 모든 ip 및 도메인을 허락
			"http://도메인" : 특정 도메인에 해당되는 부분만 접속 허용
			
			access-control-allow-credentials : 인증 관련 사항을 정상적으로 외부에서 접근이 되도록 허용, origin과 함께 이 줄을 넣어야만 함. (API-KEY가 대표적인 것이고, 신분증, 자격증)

		*/
		response.setHeader("access-control-allow-origin", "*");		//setHeader → addHeader으로 해도 됨. 후자는 이전 Java 버전용 → *가 모든... 이라는 의미구나.. 
		//* 자리에 허락하고 싶은 IP를 넣으면 됨. → , 로 IP를 추가해 나가도 됨.
		response.setHeader("access-control-allow-credentials", "true");		//역시 set 말고 add를 써도 됨
		//위 2줄이 반드시 필요하다. CORS 문제를 해결하기 위해서는.. 
		//위 2줄이 있어야 다른 사람들이 내 컴에 접속이 가능함. → 예를 들어서 말이야.
		//백엔드가 위 2줄을 넣어줘야 프런트가 해결이 됨. 프런트는 해결을 할 수 없음. 백엔드가 해결해야 함.
		
		PrintWriter pw = response.getWriter();
		try {
			String data = "[50, 20, 30, 40, 50]";
//			String data = "['hong', 'kim', 'part']";
			pw.print(data);
			
		} catch (Exception e) {
			pw.print("error");
			
		} finally {
			pw.close();
		}
	}


}