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

public class api_pension extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	Connection con = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	PrintWriter pw = null;
	ArrayList<String> rooms = null;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Credentials", "true");
		response.setContentType("text/html;charset=UTF-8");
		
		this.rooms = new ArrayList<String>();
		this.rooms.add("디럭스");
		this.rooms.add("스탠다드");
		this.rooms.add("패밀리");
		this.rooms.add("하우스");
		System.out.println(this.rooms);
		String data = request.getParameter("today");	//프런트가 post로 today값을 전송
		String key = request.getParameter("key");
		this.pw = response.getWriter();
		try {
			if(!key.equals("mapo") || key == null) {
				this.pw.write("error");
			}
			else {
				this.con = new db_pension().info();
				String query = "select room from pension where check_in=?";
				this.ps = this.con.prepareStatement(query);
				this.ps.setString(1, data);
				
				this.rs = this.ps.executeQuery();
				//이미 예약된 정보가 있을 경우, 배열값을 비교하여 해당 예약된 객실은 배열에서 삭제시켜서 던져준다.
				while (this.rs.next()) {
					if(this.rooms.contains(this.rs.getString("room"))) {
						this.rooms.remove(this.rs.getString("room"));
					}
				}
				System.out.println(this.rooms);
				String result = String.join(",", this.rooms);
				this.pw.write(result);
//				System.out.println(result);
			}
			
		} catch (Exception e) {
			this.pw.write("error");
			
		} finally {
			try {
				this.rs.close();
				this.ps.close();
				this.con.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
//		System.out.println(key);
//		System.out.println(data);
		
	}

}
