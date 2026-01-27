package event;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class event_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	PrintWriter pw = null;
	Connection con = null;	//database 연결을 하기 위한 class
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		this.pw = response.getWriter();
		String nm = request.getParameter("nm");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");		//사용자가 직접 입력한 패스워드
		String favor = request.getParameter("favor");
		String p_info = request.getParameter("p_info");
		String third_info = request.getParameter("third_info");
		String m_info = request.getParameter("m_info");
		
		try {
			this.con = new dbconfig().info();	//database 실제 연결
			
			String repass = new repass_word().repass(pw);	//사용자 패스워드를 md5로 변환한다
			
			//sql에 적용하는 쿼리문을 작성합니다.
			String query = "insert into event values "
					+ "('0', '"+nm+"', '"+tel+"', '"+email+"', '"+repass+"', '"+favor+"','"+p_info+"','"+third_info+"','"+m_info+"',now())";
			
			//statement : database에 대한 내용을 실행하기 위한 interface 
			//createStatement()	→ 일반적인 쿼리문을 작성하는 방식	→ 공격에 취약하다고 함.(정적쿼리문)
			//prepareStatement() → 보안을 기준으로 sql 쿼리문을 작성하는 방식 → sql 인젝션 공격을 피하려면 이것을 쓴다고 함.(동적쿼리문)
			//select : 결과값이 배열 형태이다. → executeQuery()을 쓴다
			//insert, update, delete : 결과값이 숫자로 날라온다 → executeUpdate()을 쓴다.
			
			Statement st = this.con.createStatement();
			Integer result = st.executeUpdate(query);	//쿼리문을 실행하고 결과를 return 한다.
			
			//return 받은 결과를 조건문에 맞는 문법으로 출력
			if(result > 0) {
				this.pw.write("<script>"
						+ "alert('해당 이벤트에 정상적으로 신청되었습니다.');"
						+ "history.go(-1);"
						+ "</script>");
			}
			else {
				this.pw.write("<script>"
						+ "alert('database 오류로 인하여 현재 서비스 신청이 되지 않습니다.');"
						+ "history.go(-1);"
						+ "</script>");				
			}
			st.close();
		} catch (Exception e) {
			System.out.println(e);	//오류가 날때는 필히 이 줄을 찍어볼 것 26-1-8 12:30	
			System.out.println("데이터 베이스 접속 오류!!");

		} finally {
			try {
				this.con.close();	//con을 무조건 닫아야 한다. 안 닫으면 sql 인젝션 공격을 받은거나 다름없다고 함.
				this.pw.close();
			} catch (Exception e2) {
				System.out.println("db 서버 오류로 인하여 정상적인 종료가 되지 않습니다.");
			}
		}
		
		
	}

}
