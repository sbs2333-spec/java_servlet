package contact_us;

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

public class contact_us_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;

	PrintWriter pw = null;
	Connection con = null;
	PreparedStatement st = null;	//setter DTO 형태 사용하는 방식
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		this.pw = response.getWriter();
		String partner_type = request.getParameter("partner_type");
		String com_name = request.getParameter("com_name");
		String manager_name = request.getParameter("manager_name");
		String manager_email = request.getParameter("manager_email");
		String manager_tel = request.getParameter("manager_tel");
		String contact_message = request.getParameter("contact_message");
		String agree = request.getParameter("agree");
		System.out.println(partner_type);
		System.out.println(com_name);
		System.out.println(manager_name);
		System.out.println(manager_email);
		System.out.println(manager_tel);
		System.out.println(contact_message);
		System.out.println(agree);

		try {
			this.con = new dbconfig().info();
			//? → setter의 키 이름 순으로 적용됨. 1번부터 들어감. 0부터가 아님. → prepareStatement
			String query = "insert into contact_us values ('0',?,?,?,?,?,?,?,now())";
			this.st = this.con.prepareStatement(query);
			//? 순서대로 적용하는 방식 (숫자번호, 데이터값);
			this.st.setString(1, partner_type);
			this.st.setString(2, com_name);
			this.st.setString(3, manager_name);
			this.st.setString(4, manager_email);
			this.st.setString(5, manager_tel);
			this.st.setString(6, contact_message);
			this.st.setString(7, agree);
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
