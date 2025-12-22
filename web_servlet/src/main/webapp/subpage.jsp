<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 String user = "에이핑크";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<header>

 <%@ include file = "./top.jsp" %>
</header>
<main>
<section><%@ include file="./login.html" %></section>
</main>
<footer>
<%@ include file="./bottom.jsp" %>
</footer>
</body>
</html>