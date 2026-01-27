<%@page import="java.util.Arrays"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.util.Enumeration"%>
<%@page import="model.dbinfo"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	//Front-end에 넘어오는 모든 name값을 가져오는 배열
	Enumeration<String> data = request.getParameterNames();	//html태그 기준으로 name 순서가 정해짐
	String msg = "";

	String rows[] = {"cate_code","subject_nm","teacher_nm","class_time","class_level","class_text","subject_text","start_day","end_day","max_no","class_use"};
	
	Connection con = new dbinfo().info();
	PreparedStatement ps = null;
	try{
		String sql = "insert into subject (cate_code,subject_nm,teacher_nm,class_time,class_level,class_text,subject_text,start_day,end_day,max_no,class_use,indate)";
		sql += "values (?,?,?,?,?,?,?,?,?,?,?,now())";
		ps = con.prepareStatement(sql);
		while(data.hasMoreElements()){	//모든 name에 해당되는 key값을 출력하는 형태
			String nm = data.nextElement();		//name key명을 출력
			String aa = request.getParameter(nm);
			
			int node = Arrays.asList(rows).indexOf(nm);
			
			if(nm.equals("class_time") || nm.equals("class_level") || nm.equals("max_no")){
				ps.setInt(node+1, Integer.parseInt(aa));	
			}
			else{
				ps.setString(node+1, aa);	
			}
		
		}
		Integer result = ps.executeUpdate();

		if(result > 0){
			msg = "alert('정상적으로 과목등록이 저장 되었습니다.'); location.href='/cms/edu_classlist.do';";
		}
		else{
			msg = "alert('올바른 접근이 아닙니다.'); history.go(-1);";
		}
		
	}catch(Exception e){
		out.print(e);
	}finally{
		ps.close();
		con.close();
	}

%>
<meta charset="UTF-8">
<script>
<%=msg%>
</script>