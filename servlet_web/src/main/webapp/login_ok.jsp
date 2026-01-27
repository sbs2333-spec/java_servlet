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
	    // 로그인 성공 시 세션에 저장
	    session.setAttribute("userid", userid);
	    session.setAttribute("username", rs.getString("mname")); // mname으로 가져오기
	%>
	    <script>
	        alert("<%= rs.getString("mname") %>님 환영합니다!");
	        location.href="list.jsp";
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