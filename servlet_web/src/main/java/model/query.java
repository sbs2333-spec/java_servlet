package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

public abstract class query {
	String sql = "";
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	//Model에서 Controller에 데이터를 이관하기 위해서 컬럼명과 동일한 변수에 데이터를 적용
	member_dto dto = new member_dto();	
	
	//수강신청 삭제
	public Integer edu_delete(String eidx, String mid) throws Exception{
		Integer sign = 0;
		try {
			//삭제시 고유값(auto_incrment), 사용자 id를 Controller에서 받아서 쿼리문을 작동시킴
			this.con = new dbinfo().info();
			this.sql = "delete from edu where eidx=? and mid=? order by eidx desc";
			this.ps = this.con.prepareStatement(this.sql);
			this.ps.setString(1, eidx);
			this.ps.setString(2, mid);
			sign = this.ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		} finally {
			this.ps.close();
			this.con.close();
		}
		return sign;
	}
	
  //수강신청 리스트에 과목명으로 검색시	
  public ArrayList<edu_dto> edu_search(String mid,String search) throws Exception {
		
		ArrayList<edu_dto> alldata = new ArrayList<edu_dto>(); 
		
		this.con = new dbinfo().info();
		this.sql = "select * from edu where mid=? and subject like ? order by eidx desc";
		this.ps = this.con.prepareStatement(this.sql);
		this.ps.setString(1, mid);
		this.ps.setString(2, '%'+search+'%');	//like에서 적용하는 방식을 % 포함하여 변수값를 설정함
		this.rs = this.ps.executeQuery();
		edu_dto ed = null;
		while(this.rs.next()) {
			ed = new edu_dto();
			ed.setEidx(Integer.valueOf(this.rs.getString("eidx")));
			ed.setMid(this.rs.getString("mid"));
			ed.setMname(this.rs.getString("mname"));
			ed.setSubject(this.rs.getString("subject"));
			ed.setIndate(this.rs.getString("indate"));
			alldata.add(ed);
		}
		this.rs.close();
		this.ps.close();
		this.con.close();
		return alldata;
	}
	
	
	//한페이지당 데이터 출력 갯수
	int ea = 3;
	
	//수강신청 리스트
	//ArrayList<edu_dto> => 여러개의 데이터를 가져와야 할 경우
	public ArrayList<edu_dto> edu_lists(String mid,Integer pno) throws Exception {
		
		//SQL 쿼리문 중 limit 시작값을 적용하기 위한 사칙연산 코드
		Integer startpg = (pno - 1) * this.ea;
		
		//1차 dto ArrayList에 해당 데이터를 순차적으로 저장시키 위함	
		ArrayList<edu_dto> alldata = new ArrayList<edu_dto>(); 
		
		this.con = new dbinfo().info();
		this.sql = "select *,(select count(*) from edu where mid=?) as ctn "
				+ "from edu where mid=? order by eidx desc limit ?,?";
		this.ps = this.con.prepareStatement(this.sql);
		this.ps.setString(1, mid);
		this.ps.setString(2, mid);
		this.ps.setInt(3, startpg);
		this.ps.setInt(4, this.ea);
		this.rs = this.ps.executeQuery();
		edu_dto ed = null;
		while(this.rs.next()) {
			ed = new edu_dto();
			ed.setEidx(Integer.valueOf(this.rs.getString("eidx")));
			ed.setMid(this.rs.getString("mid"));
			ed.setMname(this.rs.getString("mname"));
			ed.setSubject(this.rs.getString("subject"));
			ed.setIndate(this.rs.getString("indate"));
			ed.setCtn(this.rs.getString("ctn"));
			alldata.add(ed);	//setter에 입력된 내용을 1차 클래스 배열에 이관함
		}
		
		this.rs.close();
		this.ps.close();
		this.con.close();
		return alldata;
	}
	
	
	
	//수강신청 쿼리
	public int esubject(edu_dto edto) throws Exception {
		this.con = new dbinfo().info();
		this.sql = "insert into edu (eidx,mid,mname,subject,indate)"
				+ "values ('0',?,?,?,now())";
		this.ps = this.con.prepareStatement(this.sql);
		this.ps.setString(1, edto.getMid());
		this.ps.setString(2, edto.getMname());
		this.ps.setString(3, edto.getSubject());
		int call = this.ps.executeUpdate();
		
		this.ps.close();
		this.con.close();
		return call;
	}
	
	
	public member_dto member_select(String mid) throws Exception {
		this.sql = "select mid,mpass,mname from member where mid=?";
		this.con = new dbinfo().info();
		this.ps = this.con.prepareStatement(this.sql);
		this.ps.setString(1, mid);
		
		this.rs = this.ps.executeQuery();
		if(this.rs.next()) {
			//dto에 setter에 쿼리를 실행한 값을 이관 합니다.
			this.dto.setMid(this.rs.getString("mid"));	
			this.dto.setMname(this.rs.getString("mname"));
			this.dto.setMpass(this.rs.getString("mpass"));
		}		
		else {
			dto.setMid("");	//해당 쿼리문 실행시 데이터가 없을 경우
		}
		
		this.rs.close();
		this.ps.close();
		this.con.close();
		
		return this.dto;	//dto class명으로 return 시킴
	}
}

