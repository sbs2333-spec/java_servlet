<%@page import="model.subject_dto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
ArrayList<subject_dto> all = (ArrayList)request.getAttribute("all");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>E-Learning Platform</title>
    <link rel="stylesheet" href="/css/index.css">
</head>
<body>
<%@ include file="/top.jsp"%>
    <main>
        <section class="hero">
            <div class="container">
                <h2>미래를 위한 학습</h2>
                <p>다양한 온라인 코스로 지식을 넓혀보세요.</p>
                <a href="#" class="btn">코스 둘러보기</a>
            </div>
        </section>

        <section class="courses">
            <div class="container">
                <h2>인기 코스</h2>
                <div class="course-grid">
                <%
                	if(all.size() > 0) {
                		int w = 0;
                		while(w < all.size()){
                %>
                	<div class="course-card">
                        <h3><%=all.get(w).getSubject_nm()%></h3>
                        <p><%=all.get(w).getSubject_text()%></p>
                        <a href="./pg_eclass.jsp" class="btn">
                        <!-- 삼항 연산자 -->
                        <%=all.get(w).getClass_use().equals("Y") ? "수강하기" : "수강예정" %>
                        </a>
                    </div>
                <%
                		w++;
                		}
                	}
                %>
                   <!-- 
                    <div class="course-card">
                        <h3>프로그래밍 기초</h3>
                        <p>코딩의 세계로 첫 발을 내딛어보세요.</p>
                        <a href="./pg_eclass.jsp" class="btn">수강하기</a>
                    </div>
                    <div class="course-card">
                        <h3>데이터 분석</h3>
                        <p>데이터를 통해 인사이트를 얻는 방법을 배우세요.</p>
                        <a href="./pg_eclass.jsp" class="btn">수강하기</a>
                    </div>
                    <div class="course-card">
                        <h3>디자인 원리</h3>
                        <p>창의적인 디자인 스킬을 개발하세요.</p>
                        <a href="./pg_eclass.jsp" class="btn">수강하기</a>
                    </div>
                    -->
                </div>
            </div>
        </section>

        <section class="features">
            <div class="container">
                <h2>왜 우리 플랫폼인가?</h2>
                <div class="feature-list">
                    <div class="feature">
                        <h3>유연한 학습</h3>
                        <p>언제 어디서나 학습할 수 있습니다.</p>
                    </div>
                    <div class="feature">
                        <h3>전문 강사</h3>
                        <p>업계 전문가들이 가르칩니다.</p>
                    </div>
                    <div class="feature">
                        <h3>인증서 제공</h3>
                        <p>완료 시 인증서를 받으세요.</p>
                    </div>
                </div>
            </div>
        </section>
    </main>
    <%@ include file="/footer.jsp"%>
</body>
</html>