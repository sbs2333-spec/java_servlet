<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String msg = (String)request.getAttribute("msg");
    String part = (String)request.getAttribute("part");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개인정보 확인 페이지</title>
</head>
<body>
<!--  
1:1 1개의 컨트롤에 1개의 뷰 
n:1 여러개의 컨트롤에 1개의 뷰
-->
<%
if(part.equals("id")){
%>
	
아이디 : <%=msg%>
<%	
} else {
	%>	
	패스워드 : <%=msg%>
<%}
%>

</body>
</html>