package event;

import java.sql.Connection;
import java.sql.DriverManager;

//database를 servlet에서 사용할 수 있도록 database 정보를 세팅하는 모델
public class dbconfig {
	public Connection info() throws Exception{
		//mysql 버전별로 드라이버 항목을 적용함
		//com.mysql.cj.jdbc.Driver → mysql 5.7 대부터 ~ 10까지는 이렇게 씀
		//com.mysql.jdbc.Driver → mysql 5.1 ~ .5.5대 버전까지		
		String db_driver = "com.mysql.cj.jdbc.Driver";
		//db 연결서버정보
		String db_url = "jdbc:mysql://localhost:3306/website";
		//db 가상 사용자의 아이디 및 패스워드
		String db_user = "hong";
		String db_pass = "a123456";
		
		Class.forName(db_driver);		
		Connection dbcon = DriverManager.getConnection(db_url, db_user, db_pass);
		
		return dbcon;
	}
	
	
	
}
