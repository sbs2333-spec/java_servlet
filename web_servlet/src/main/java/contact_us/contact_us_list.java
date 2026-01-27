package contact_us;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//db에 저장된(my_address)에 저장된 값을 jsp에 출력

import com.mysql.cj.xdevapi.Result;

import event.dbconfig;
public class contact_us_list extends HttpServlet {
	
	Connection con = null;	
	PreparedStatement ps = null;
	ResultSet rs = null;	//ResultSet → DML 중에서 select에서만 사용함
	
	//database에서 저장된 값을 배열에 저장하여 jsp에 전달하기 위함
	ArrayList<String> data = null;
	ArrayList<ArrayList<String>> alldata = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			this.con = new dbconfig().info();
			//select 쿼리문
			String query = "select * from my_address order by midx desc";
			this.ps = this.con.prepareStatement(query);
			
			this.rs = this.ps.executeQuery();  //executeQuery() : select문 전용
			
			this.alldata = new ArrayList<ArrayList<String>>();	//jsp로 전달한 2차 배열
			while(this.rs.next()) {
				this.data = new ArrayList<String>();	//1차 클래스를 생성하여 2차 배열에 적용
				//database에서 사용하는 칼럼명을 순서에 맞게 적용
				this.data.add(this.rs.getString("midx"));
				this.data.add(this.rs.getString("mpost"));
				this.data.add(this.rs.getString("maddr1"));
				this.data.add(this.rs.getString("maddr2"));
				this.data.add(this.rs.getString("mdate"));
				this.alldata.add(this.data);		//2차 클래스 배열에 추가
			}
			System.out.println(this.alldata);			
			
		} catch (Exception e) {
			System.out.println("db 서버 오류로 인하여 원활한 서비스 불가능!!");
		} finally {
			try {
				this.ps.close();
				this.con.close();				
			} catch (Exception e2) {
				System.out.println(e2);
			}
			
		}
		
		request.setAttribute("addr", this.alldata);	//jsp로 2차 배열 전달
		RequestDispatcher rd = request.getRequestDispatcher("./addr_list.jsp");
		rd.forward(request, response);		
	}

}
