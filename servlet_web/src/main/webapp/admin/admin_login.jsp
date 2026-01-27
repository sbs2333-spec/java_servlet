<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 로그인</title>
    <link rel="stylesheet" href="../css/index.css?v=2">
    <link rel="stylesheet" href="css/admin_login.css?v=2">
</head>
<body>
    <header>
  	<%@ include file="/admin/top.jsp" %>
  	<%
  	if(name != null || id != null){
  	%>
  	<script>location.href='./admin_main.do';</script>
  	<%
  		}
  	%>
    </header>

    <main>
        <div class="admin-login-container">
            <div class="admin-header">
                <h1>관리자 로그인</h1>
                <p>E-Learning 관리 시스템</p>
            </div>
            <form id="frm" class="admin-login-form" method="post" action="./admin_loginok.do">
            	<input type="hidden" name="security" value="admin_602">
                <div class="form-group">
                    <label>관리자 아이디</label>
                    <input type="text" name="admin_id" class="input-field" placeholder="관리자 아이디를 입력하세요">
                </div>
                <div class="form-group">
                    <label>패스워드</label>
                    <input type="password" name="admin_pw" class="input-field" placeholder="패스워드를 입력하세요">
                </div>
                <button type="submit" class="login-btn">로그인</button>
            </form>
            <div class="admin-links">
                <a href="#" class="link">비밀번호 찾기</a>
                <span class="divider">|</span>
                <span class="link" id="home_btn">홈으로</span>
            </div>
        </div>
    </main>
    <footer>
        <%@ include file="/admin/footer.jsp" %>
    </footer>
    <script type="module">
		//import : es7 ~ 사용하는 방식 함수를 로드
		import {login} from "/admin/js/admin_login.js?v=1";
		document.querySelector("#frm").addEventListener("submit",function(z){
			z.preventDefault();		//form action을 작동시키지 않음
			new login(this.admin_id.value,this.admin_pw.value).login_check();
		});
	</script>
</body>
</html>
