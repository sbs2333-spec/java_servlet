package pension_reservation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import event.dbconfig;
import pension.db_pension;

public class pension_reserv_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;

	PrintWriter pw = null;
	Connection con = null;
	PreparedStatement st = null;	//setter DTO 형태 사용하는 방식
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		this.pw = response.getWriter();
		String checkin_date = request.getParameter("checkin_date");
		String checkout_date = request.getParameter("checkout_date");
		String room_name = request.getParameter("room_name");
		String adult_count = request.getParameter("adult_count");
		String child_count = request.getParameter("child_count");
		String infant_count = request.getParameter("infant_count");
		String total_price = request.getParameter("total_price");
		System.out.println(checkin_date);
		System.out.println(checkout_date);
		System.out.println(room_name);
		System.out.println(adult_count);
		System.out.println(child_count);
		System.out.println(infant_count);
		System.out.println(total_price);

		try {
			this.con = new db_pension().info();
			//? → setter의 키 이름 순으로 적용됨. 1번부터 들어감. 0부터가 아님. → prepareStatement
			String query = "insert into pension_reserv values ('0',?,?,?,?,?,?,?,now())";
			this.st = this.con.prepareStatement(query);
			//? 순서대로 적용하는 방식 (숫자번호, 데이터값);
			this.st.setString(1, checkin_date);
			this.st.setString(2, checkout_date);
			this.st.setString(3, room_name);
			this.st.setString(4, adult_count);
			this.st.setString(5, child_count);
			this.st.setString(6, infant_count);
			this.st.setString(7, total_price);
			Integer result = this.st.executeUpdate();
			if(result > 0) {
				this.pw.print("<script>"
						+ "alert('신규 데이터가 등록되었습니다.');"
						+ "history.go(-1);"
						+ "</script>");
			}else {
				this.pw.print("<script>"
						+ "alert('데이터값 오류로 인하여 신규 등록 불가!!!');"
						+ "history.go(-1);"
						+ "</script>");
			}			
			
		} catch (Exception e) {			
			System.out.println(e);
		} finally {
			try {
				this.st.close();
				this.con.close();
				this.pw.close();
			} catch (Exception e2) {
				System.out.println("데이타베이스가 정상적으로 종료하지 못하였습니다.");
			}
		}	
	}
}
