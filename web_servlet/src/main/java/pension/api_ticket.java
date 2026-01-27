package pension;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class api_ticket extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	Connection con = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	PrintWriter pw = null;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/plain; charset=UTF-8");

	    PrintWriter pw = response.getWriter();   // ✅ 반드시 초기화

	    String visit_date = request.getParameter("visit_date");
	    String visit_time = request.getParameter("visit_time");
	    String headcount  = request.getParameter("headcount");

	    try {
	        this.con = new db_pension().info();

	        String query = "select ifnull(sum(headcount),0) as total " +
	                       "from chang " +
	                       "where visit_date=? " +
	                       "and visit_time=?";

	        this.ps = this.con.prepareStatement(query);
	        this.ps.setString(1, visit_date);
	        this.ps.setString(2, visit_time);
	        this.rs = this.ps.executeQuery();

	        int total = 0;
	        if (this.rs.next()) {
	            total = this.rs.getInt("total");
	        }

	        int add = Integer.parseInt(headcount);

	        if (total + add > 100) {
	            pw.print("인원초과");   // ✅ 브라우저로 응답
	            return;                // ✅ 여기서 종료
	        }

	        query = "insert into chang (visit_date, visit_time, headcount, created_at) values (?,?,?,now())";
	        this.ps = this.con.prepareStatement(query);
	        this.ps.setString(1, visit_date);
	        this.ps.setString(2, visit_time);
	        this.ps.setString(3, headcount);

	        int result = this.ps.executeUpdate();  // ✅ 딱 1번만 실행

	        if (result > 0) {
	            pw.print("OK"); // ✅ 성공도 응답으로 명확히
	        } else {
	            pw.print("FAIL");
	        }

	    } catch (Exception e) {
	        System.out.println(e);
	        pw.print("ERROR"); // ✅ 예외도 브라우저로 전달(프론트가 판단 가능)
	    } finally {
	        try { if (this.rs != null) this.rs.close(); } catch(Exception ignore) {}
	        try { if (this.ps != null) this.ps.close(); } catch(Exception ignore) {}
	        try { if (this.con != null) this.con.close(); } catch(Exception ignore) {}
	    }
	}
}