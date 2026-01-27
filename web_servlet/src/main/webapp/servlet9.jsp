<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Integer count = (Integer) request.getAttribute("count");
ArrayList<ArrayList<String>> result = (ArrayList) request.getAttribute("result");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 검색 결과 출력</title>
</head>
<body>
	<p>
		검색 결과
		<%=count%>건
	</p>
	<%
	if (count == 0) {
	%><br>
	<br>검색결과가 없습니다.<%
	} else {
	%>
	<ul>
		<%
		String stitle = "";
		String reresult = "";
		for (int a = 0; a < count; a++) {
			for (int b = 0; b < result.get(a).size(); b++) {
				if (b == 0) {
			stitle = "도서명 : ";
				} else if (b == 1) {
			stitle = "저자명 : ";
				} else if (b == 2) {
			stitle = "가격 : ";
				}
				reresult = stitle + result.get(a).get(b);
		%>
		<li><%=reresult%></li>
		<%
		}
		%>
		<br>
		<br>
		<%
		}
		}
		%>
	</ul>
</body>
</html>