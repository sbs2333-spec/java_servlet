package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class admin_query_내것 {

	String sql = "";
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	admin_dto_내것 dto = null;	
		
	
	
public admin_dto_내것 admin_login(String mid) throws Exception {
		
		this.con = new dbinfo().info();
		this.sql  = "select * from admin where admin_id=?";
		this.ps = this.con.prepareStatement(this.sql);
		this.ps.setString(1, mid);
		this.rs = this.ps.executeQuery();
		/*
		System.out.println(this.sql);
		System.out.println(mid);
		*/
		
		admin_dto_내것 dto = null;
		
		while(this.rs.next()) {
			dto = new admin_dto_내것();
			dto.setAidx(Integer.valueOf(this.rs.getString("aidx")));
			dto.setAdmin_id(this.rs.getString("admin_id"));
			dto.setAdmin_nm(this.rs.getString("admin_nm"));
			dto.setAdmin_pw(this.rs.getString("admin_pw"));
			//System.out.println(this.rs.getString("admin_pw"));
		}
		this.rs.close();
		this.ps.close();
		this.con.close();
		
		return dto;
	}

}
