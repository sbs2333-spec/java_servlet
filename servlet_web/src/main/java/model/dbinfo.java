package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbinfo {
	public static Connection info() throws Exception{
		String dbinfo = "com.mysql.cj.jdbc.Driver";
		String dburl = "jdbc:mysql://localhost:3306/cms";
		String dbuser = "web_cms";
		String dbpass = "cms_1234";
		
		Class.forName(dbinfo);
		Connection con = DriverManager.getConnection(dburl,dbuser,dbpass);
		return con;
	}
}
