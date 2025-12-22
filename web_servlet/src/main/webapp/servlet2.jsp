<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
ArrayList<String> myinfo = (ArrayList)request.getAttribute("member");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 완료</title>
</head>
<body>
회원가입 완료<br>
가입하신 아이디 : <%=myinfo.get(0)%><br>
고객명 : <%=myinfo.get(2)%><br>
연락처 : <%=myinfo.get(3)%><br>
<input type="button" value="확인" onclick="gapage()">
</body>
<script>
function gopage(){
	location.href = "./servlet2.html"
}

</script>
</html>