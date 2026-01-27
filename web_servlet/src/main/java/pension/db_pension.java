package pension;
//korea 사용자 맞는 db 정보

import java.sql.Connection;
import java.sql.DriverManager;

public class db_pension {
	//연결하고자 하는 db 정보 및 포트와 가상 사용자의 아이디 및 패스워드 적용
	public Connection info() throws Exception{
		String db = "com.mysql.jdbc.Driver";
		String db_url = "jdbc:mysql://172.30.1.32:3306/pension";
		String db_user = "korea";
		String db_pw = "b123456";
		
		Class.forName(db);
		Connection dbcon = DriverManager.getConnection(db_url, db_user, db_pw);
		return dbcon;
	}
}
