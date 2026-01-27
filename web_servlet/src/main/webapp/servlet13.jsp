<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String message = (String)request.getAttribute("message");
	ArrayList<String> info = (ArrayList)request.getAttribute("info");
%>
<script>
	<%=message%>

</script>
<%
if(info.size() > 0){
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 완료</title>
</head>
<body>
가입자 정보 : <%=info.get(0)%>

</body>
</html>
<%
}
%>


