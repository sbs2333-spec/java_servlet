<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>수강신청</title>
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="css/pg_eclass.css">
</head>
<script src="https://cdn.example.com/agent-version.js"></script>
<body>
<%@ include file="./top.jsp"%>
<%
		if(name == null || id == null){
			out.print("<script>\n" +
					"alert('해당 서비스는 로그인 하셔야만 신청 됩니다.');\n" +
					"location.href='./index.jsp';\n" +
					"</script>");	
		}
	%>
    <main>
        <div class="enroll-container">
            <h1>수강신청</h1>
            <form id="frm" class="enroll-form">
                <div class="form-group">
                    <label>아이디 <span class="required">*</span></label>
                    <input type="text" class="input-field" name="mid" value="<%=id%>" readonly>
                </div>
                <div class="form-group">
                    <label>학생명 <span class="required">*</span></label>
                    <input type="text" class="input-field" name="mname" value="<%=name%>" readonly>
                </div>
                <div class="form-group">
                    <label>과목 선택</label>
                    <div class="subject-list">
                        <div class="subject-item">
                            <input type="radio" name="subject" class="radio" value="프로그래밍 기초">
                            <div class="subject-info">
                                <h3>프로그래밍 기초</h3>
                                <p>코딩의 세계로 첫 발을 내딛어보세요. 기본적인 프로그래밍 개념과 실습을 포함합니다.</p>
                            </div>
                        </div>
                        <div class="subject-item">
                            <input type="radio" name="subject" class="radio" value="데이터 분석">
                            <div class="subject-info">
                                <h3>데이터 분석</h3>
                                <p>데이터를 통해 인사이트를 얻는 방법을 배우세요. 통계와 도구 사용법을 다룹니다.</p>
                            </div>
                        </div>
                        <div class="subject-item">
                            <input type="radio" name="subject" class="radio" value="디자인 원리">
                            <div class="subject-info">
                                <h3>디자인 원리</h3>
                                <p>창의적인 디자인 스킬을 개발하세요. 색상, 레이아웃, 타이포그래피를 학습합니다.</p>
                            </div>
                        </div>
                    </div>
                </div>
                <button type="button" onclick="class_reg()" class="enroll-btn">수강신청</button>
            </form>
        </div>
    </main>
  <%@ include file="./footer.jsp"%>
</body>
<script src="./js/pg_eclass.js"></script>
</html>