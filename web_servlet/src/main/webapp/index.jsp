<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% //자바 코드를 사용할 수 있는 기호	
	String user = "홍길동";
//자바 코드 종료 기호 %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
jsp작동 <br>

<% out.print(user); 
//Integer no = Integer.parseInt(user);

%>
<br>
<%=user%>

</body>
</html>