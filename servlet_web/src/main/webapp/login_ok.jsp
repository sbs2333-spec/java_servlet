<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.*, java.sql.*" %>
<%
    request.setCharacterEncoding("utf-8");
    String userid = request.getParameter("userid");
    String userpass = request.getParameter("userpass");

    // 선생님 가이드: DB 연결은 항상 dbinfo 활용
    Connection conn = dbinfo.info();
    
    // member 테이블에서 아이디와 비번이 일치하는지 확인 (이미지 구조 참고)
	// login_ok.jsp의 쿼리 부분을 아래와 같이 수정하세요.
	String sql = "select mname from member where mid=? and mpass=?"; 
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, userid);
	pstmt.setString(2, userpass);
	ResultSet rs = pstmt.executeQuery();
	
	if(rs.next()) {
	    // top.jsp의 세션 변수명(mname, mid)과 반드시 일치시켜야 함 [cite: 21]
	    session.setAttribute("mname", rs.getString("mname")); 
	    session.setAttribute("mid", rs.getString("mid"));
	%>
	    <script>
	        alert("<%= rs.getString("mname") %>님 환영합니다!");
	        location.href="./index.do"; // 사용자 홈(index.jsp)으로 이동 
	    </script>
	<%
	} else {
%>
        <script>
            alert("아이디 또는 비밀번호가 틀립니다.");
            history.back();
        </script>
<%
    }
    rs.close(); pstmt.close(); conn.close();
%>