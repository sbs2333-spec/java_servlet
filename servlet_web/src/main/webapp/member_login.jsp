<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 로그인</title>
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="css/member_login.css">
</head>
<body>
    <%@ include file="./top.jsp"%>
    <%
		if(name != null || id != null){
			out.print("<script>location.href='./index.jsp';</script>");
		}
	%>
    <main>
    <div class="login-container">
        <h1>로그인</h1>
        <form id="frm" class="login-form" onsubmit="return loginck()">
            <div class="form-group">
                <label for="username">아이디</label>
                <input type="text" name="mid" class="input-field">
            </div>
            <div class="form-group">
                <label for="password">패스워드</label>
                <input type="password" name="mpass" class="input-field">
            </div>
            <button type="submit" class="login-btn">로그인</button>
        </form>
        <div class="links">
            <a href="member_register.html" class="link">회원가입</a>
            <a href="find_id.html" class="link">아이디 찾기</a>
            <a href="find_password.html" class="link">패스워드 찾기</a>
        </div>
    </div>
    </main>
 <%@ include file="./footer.jsp"%>
</body>
<script src="./js/member_login.js"></script>
</html>