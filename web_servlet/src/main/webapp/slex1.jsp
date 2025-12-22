<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
	ArrayList<String> myinfo = (ArrayList)request.getAttribute("bbsdata");  
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 등록완료</title>
</head>
<body>
	게시판 등록완료
	<br> 제목 : <%=myinfo.get(0) %>
	<br> 글쓴이 : <%=myinfo.get(1) %>
	<br> 내용 : <%=myinfo.get(2) %>
	<br>
	<br> 등록일 : <%=myinfo.get(4) %>
</body>
</html>