<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 String user = "에이핑크";
 Integer number = 123456789;	//Javascript에 할당
 String userid = "apink";	//html value에 할당
 String color1 = "red";		//css에 값을 할당
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<header>
<!--  
include file → 다른 외부의 .jsp 파일을 가져올 때 사용합니다. (변수,  상수 같은 사항을 상속받음) → 이것을 주력으로 사용한다..라고 생각할 것
include page → 동적 웹페이지 이므로, main.jsp에 상속받지 못함. → 백엔드 코드가 필요없음.

include file이나 include page => .jsp으로 시작하는 파일만 로드합니다.
 -->
 <%--
<jsp:include page="./top.jsp"></jsp:include>
 --%>
 <%@ include file = "./top.jsp" %>
</header>
<main>
<section>공지사항 및 상품출력</section>
<br>
<input type = "button" value = "클릭" onclick="abc()"></br>
<input type="text" value="<%=userid%>" class="box">
<footer>
<%@ include file="./bottom.jsp" %>
</footer>
</body>
<style>
.box{
background-color: <%=color1%>;
}
</style>
<script>
function abc(){
	var n = <%=number%>;
	alert(n);
}

</script>

</html>