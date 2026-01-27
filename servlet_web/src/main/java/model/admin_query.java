package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

//관리자만 사용하는 query문
public class admin_query {
	String sql = "";
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	admin_dto dto = null;
	
	//카테고리 정보 수정 Model
	//수정 및 최초 입력시 매개변수가 너무 많을 경우 DTO를 이용하여 매개변수로 전달 할 수 있다.
	public Integer cate_update(cate_dto cd) throws Exception {	//매개변수를 dto로 받는다. dto가 아니면 저 괄호에 넣는게 매우 길어진다.
		Integer result = null;
		try{
			this.con = new dbinfo().info();
			this.sql = "update cate set cate_name=?, cate_use=?, where cate_code=?";
			this.ps = this.con.prepareStatement(this.sql);
			this.ps.setString(1, cd.getCate_name());
			this.ps.setString(2, cd.getCate_use());
			this.ps.setString(3, cd.getCate_code());
			result = this.ps.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			this.con.close();
			this.ps.close();
		}
		
		return result;
	}
	
	
	//한개의 카테고리 정보를 가져오는 Model
	public cate_dto cate_one(String code) throws Exception{
		cate_dto cd = new cate_dto();
		try {
			this.con = new dbinfo().info();
			this.sql = "select * from cate where cate_code=?";
			this.ps = this.con.prepareStatement(this.sql);
			this.ps.setString(1, code);
			this.rs = this.ps.executeQuery();
			if(this.rs.next()) {
				cd.setCate_code(this.rs.getString("cate_code"));
				cd.setCate_name(this.rs.getString("cate_name"));
				cd.setCate_use(this.rs.getString("cate_use"));
			}
			else {
				cd = null;
			}
		} catch (Exception e) {
			cd = null;
			System.out.println(e);
		} finally {
			this.rs.close();
			this.ps.close();
			this.con.close();
		}
		return cd;
	}
	
	
	//해당 카테고리를 삭제하는 Model
	public Integer cate_del(String code) throws Exception{
		Integer result = null;
		try {
			this.con = new dbinfo().info();		
			this.sql = "delete from cate where cate_code=?";
			this.ps = this.con.prepareStatement(this.sql);
			this.ps.setString(1, code);
			result = this.ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			this.ps.close();
			this.con.close();
		}
		return result;
	}
	
	
	
	
	//전체 카테고리 리스트를 가져오는 Model
	public ArrayList<cate_dto> all_cate() throws Exception {
		ArrayList<cate_dto> all = new ArrayList<cate_dto>();
		try {
			this.con = new dbinfo().info();
			this.sql = "select *, "
					+ "(select count(*) from subject as b where b.cate_code=a.cate_code) as subject_ea, "
					+ "(select count(*) from cate) as ctn "
					+ "from cate as a";
			this.ps = this.con.prepareStatement(this.sql);
			this.rs = this.ps.executeQuery();
			while(this.rs.next()) {
				cate_dto cd = new cate_dto();
				cd.setCate_code(this.rs.getString("cate_code"));
				cd.setCate_name(this.rs.getString("cate_name"));
				cd.setCate_use(this.rs.getString("cate_use"));
				cd.setSubject_ea(Integer.valueOf(this.rs.getString("subject_ea")));
				cd.setCtn(this.rs.getString("ctn"));
				all.add(cd);
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
	
	
	
	
	//관리자 정보를 확인하는 method 및 Controller에 dto로 return 결과 보냄
	public admin_dto admin_select(String mid) throws Exception {
		try {
			this.con = new dbinfo().info();
			this.sql = "select admin_id,admin_nm,admin_pw from admin where admin_id=?";
			this.ps = this.con.prepareStatement(this.sql);
			this.ps.setString(1, mid);
			this.rs = this.ps.executeQuery();
			if(this.rs.next()) {
				this.dto = new admin_dto();
				this.dto.setAdmin_id(this.rs.getString("admin_id"));
				this.dto.setAdmin_nm(this.rs.getString("admin_nm"));
				this.dto.setAdmin_pw(this.rs.getString("admin_pw"));
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			this.rs.close();
			this.ps.close();
			this.con.close();
		}
		return this.dto;
	}
	
}
