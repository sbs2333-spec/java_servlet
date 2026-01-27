package pension;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class pensionok extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection con = null;
	PreparedStatement ps = null;	//? 형태로 select, update, 
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//프런트에서 배열로 생성하여 보내면 받는 상황, 기준으로 문자형태로 받게 됨
		request.setCharacterEncoding("UTF-8");
		
		String person = request.getParameter("person");
		String money = request.getParameter("money");
		String check_in = request.getParameter("check_in");
		String check_out = request.getParameter("check_out");
		String room = request.getParameter("room");
		String person_nm = request.getParameter("person_nm");
		String person_hp = request.getParameter("person_hp");
		try {
			this.con = new db_pension().info();
			String query = "insert into pension (person_nm, person_hp, check_in, check_out, room, person, money, indate)"
						+ "values (?,?,?,?,?,?,?,now())";
			//String query = "insert into pension values (?,?,?,?,?,now())"		→ 이렇게 하면 안됨!!!
			this.ps = this.con.prepareStatement(query);		
			this.ps.setString(1, person_nm);
			this.ps.setString(2, person_hp);
			this.ps.setString(3, check_in);
			this.ps.setString(4, check_out);
			this.ps.setString(5, room);
			this.ps.setString(6, person);
			this.ps.setString(7, money);
			this.ps.executeUpdate();
			Integer result = this.ps.executeUpdate();
			if(result > 0) {
				System.out.println("정상적으로 예약이 완료되었습니다.");
			} else {
				System.out.println("시스템 오류로 인해 현재 예약서비스가 되지 않습니다.");
			}
			
		} catch (Exception e) {
				System.out.println(e);
				System.out.println("database 오류 사항 발생!!!");
			
		} finally {
			try {
				this.ps.close();
				this.con.close();
				
			} catch (Exception e2) {
				System.out.println(e2);
			}
			
		}
		
//		System.out.println(person);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			this.con = new db_pension().info();
			int w = 0;
			while(w < 10) {
				String query = "insert into notice values ('0',?,?,?,now())";
				this.ps = this.con.prepareStatement(query);
				this.ps.setString(1, "공지사항" + w);
				this.ps.setString(2, "관리자" + w);
				this.ps.setString(3, "내용" + w);
				this.ps.executeUpdate();
			w++;	
			}
			
			
			
		} catch (Exception e) {

		} finally {
			try {
				this.ps.close();
				this.con.close();
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
		
	
	}


}
