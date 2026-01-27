package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class query2 {
	String sql = "";
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	//메인 인기코스에 출력될 과목 리스트
	public ArrayList<subject_dto> course() throws Exception {
		ArrayList<subject_dto> all = new ArrayList<subject_dto>();
		try {
			this.con = new dbinfo().info();
			all = new ArrayList<subject_dto>();
			this.sql = "select sidx,subject_nm,subject_text,class_use from subject "
					+ "where class_use != 'N' order by sidx desc limit 0,6";
			this.ps = this.con.prepareStatement(this.sql);
			this.rs = this.ps.executeQuery();
			while(this.rs.next()) {
				subject_dto dto = new subject_dto();
				dto.setSidx(this.rs.getInt("sidx"));
				dto.setSubject_nm(this.rs.getString("subject_nm"));
				dto.setSubject_text(this.rs.getString("subject_text"));
				dto.setClass_use(this.rs.getString("class_use"));
				all.add(dto);
			}
			
		}catch (Exception e) {
			System.out.println(e);
		}finally {
			this.rs.close();
			this.ps.close();
			this.con.close();
		}
		
		return all;
	}
		
	
	//ArrayList => select
	public ArrayList<cate_dto> cate_list() throws Exception {	
		//getter,setter를 적용한 dto를 1차 클래스 배열에 순차적으로 저장 시킴
		ArrayList<cate_dto> all = null;
		try {
			this.con = new dbinfo().info();
			all = new ArrayList<cate_dto>();
			this.sql = "select * from cate where cate_use='Y'";
			this.ps = this.con.prepareStatement(this.sql);
			this.rs = this.ps.executeQuery();
			while(this.rs.next()) {
				cate_dto dto = new cate_dto();
				dto.setCate_use(this.rs.getString("cate_use"));
				dto.setCate_name(this.rs.getString("cate_name"));
				dto.setCate_code(this.rs.getString("cate_code"));
				all.add(dto);
			}	
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			this.rs.close();
			this.ps.close();
			this.con.close();
		}
		
		return all;
	}
	
}
