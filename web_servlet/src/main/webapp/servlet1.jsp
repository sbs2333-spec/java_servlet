<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String message = (String)request.getAttribute("message");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색한 사용자 레벨 정도</title>
</head>
<body>
결과값 출력 : <% out.print(message); %>
</body>
</html>