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

public class api_search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	PrintWriter pw = null;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		this.pw = response.getWriter();
		
		try {
			String person_nm = request.getParameter("person_nm");
			String person_hp = request.getParameter("person_hp");
			if(person_nm == null || person_hp == null) {
				this.pw.write("error");	
			}
			else {
				this.con = new db_pension().info();
				String query = "select check_in, check_out, room from pension where "
						+ "person_nm=? and person_hp=? order by pidx desc limit 0, 1";
				this.ps = this.con.prepareStatement(query);
				this.ps.setString(1, person_nm);
				this.ps.setString(2, person_hp);
				this.rs = this.ps.executeQuery();
				ArrayList<String> data = new ArrayList<String>();
				while(this.rs.next()) {
					data.add(this.rs.getString("check_in"));
					data.add(this.rs.getString("check_out"));
					data.add(this.rs.getString("room"));
				}
				String result = String.join(",", data);
				this.pw.write(result);				
			}
			
		} catch (Exception e) {
			this.pw.write("error");	
			
		} finally {
			try {
				this.rs.close();
				this.ps.close();
				this.con.close();
				this.pw.close();
				
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
		
	}

}
