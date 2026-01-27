package pension;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class notice_list extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	List<String> data = null;
	List<List<String>> alldata = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			this.con = new db_pension().info();
			this.alldata = new ArrayList<List<String>>();
			String sql = "select * from notice order by nidx desc limit ?,5";
			this.ps = this.con.prepareStatement(sql);
			//setInt : 사용한 이유는 '' 없이 숫자로 쿼리문에 적용할 경우 사용함.
			this.ps.setInt(1, 0);
			this.rs = this.ps.executeQuery();
			while(this.rs.next()) {
				this.data = new ArrayList<String>();
				this.data.add(this.rs.getString("nidx"));
				this.data.add(this.rs.getString("nsubject"));
				this.data.add(this.rs.getString("nwriter"));
				this.data.add(this.rs.getString("ndate"));
				this.alldata.add(this.data);
			}			
			
			//게시물의 전체 갯수를 가져오는 쿼리문
			String ctn = "select count(*) as total from notice";
			this.ps = this.con.prepareStatement(ctn);
			this.rs = this.ps.executeQuery();
			this.rs.next();					
			Integer total = Integer.valueOf(this.rs.getString("total"));
			request.setAttribute("total", total);				
			
			this.rs.close();
			this.ps.close();
			this.con.close();
		} catch (Exception e) {
			
		}
		request.setAttribute("alldata", this.alldata);
		RequestDispatcher rd = request.getRequestDispatcher("./notice_list.jsp");
		rd.forward(request, response);		
	}

}
