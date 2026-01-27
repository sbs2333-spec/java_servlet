package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class query3 {
	String sql = "";
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public Integer file_save(String filenm, String fileurl) throws Exception{
		Integer result = null;
		try{
			this.con = new dbinfo().info();
			this.sql = "insert into filelist values ('0',?,?,now())";
			this.ps = this.con.prepareStatement(this.sql);
			this.ps.setString(1, filenm);
			this.ps.setString(2, fileurl);
			result = this.ps.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			this.ps.close();
			this.con.close();
		}
		return result;
	}
}
