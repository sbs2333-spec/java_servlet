<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 메인</title>
    <link rel="stylesheet" href="../css/index.css">
    <link rel="stylesheet" href="css/admin_main.css">
</head>
<body>
    <header>
	<%@ include file="/admin/top.jsp" %>
    </header>

    <main>
        <div class="admin-dashboard">
            <div class="dashboard-header">
                <h1>관리자 대시보드</h1>
                <p>E-Learning 관리 시스템</p>
            </div>

            <div class="dashboard-content">
                <div class="stats-grid">
                    <div class="stat-card">
                        <div class="stat-icon">👥</div>
                        <div class="stat-info">
                            <h3>회원 수</h3>
                            <p class="stat-number">256명</p>
                        </div>
                    </div>

                    <div class="stat-card">
                        <div class="stat-icon">📚</div>
                        <div class="stat-info">
                            <h3>과목 수</h3>
                            <p class="stat-number">48개</p>
                        </div>
                    </div>

                    <div class="stat-card">
                        <div class="stat-icon">📢</div>
                        <div class="stat-info">
                            <h3>공지사항</h3>
                            <p class="stat-number">12개</p>
                        </div>
                    </div>

                    <div class="stat-card">
                        <div class="stat-icon">❓</div>
                        <div class="stat-info">
                            <h3>Q&A</h3>
                            <p class="stat-number">34개</p>
                        </div>
                    </div>
                </div>

                <div class="menu-grid">
                    <div class="menu-box">
                        <div class="menu-title">👥 회원관리</div>
                        <p>회원 정보 관리, 권한 설정, 회원 이력 조회</p>
                        <a href="#" class="menu-link">관리하기</a>
                    </div>

                    <div class="menu-box">
                        <div class="menu-title">📚 과목 관리</div>
                        <p>과목 생성, 수정, 삭제 및 강사 배정</p>
                        <a href="#" class="menu-link">관리하기</a>
                    </div>

                    <div class="menu-box">
                        <div class="menu-title">📢 공지사항 관리</div>
                        <p>공지사항 작성, 수정, 삭제 관리</p>
                        <a href="#" class="menu-link">관리하기</a>
                    </div>

                    <div class="menu-box">
                        <div class="menu-title">❓ Q&A 관리</div>
                        <p>사용자 문의 답변, 답변 관리</p>
                        <a href="#" class="menu-link">관리하기</a>
                    </div>

                    <div class="menu-box">
                        <div class="menu-title">🏷️ 카테고리 관리</div>
                        <p>과목 카테고리 추가, 수정, 삭제</p>
                        <a href="#" class="menu-link">관리하기</a>
                    </div>

                    <div class="menu-box">
                        <div class="menu-title">📊 통계</div>
                        <p>회원, 과목, 수강 현황 통계</p>
                        <a href="#" class="menu-link">보기</a>
                    </div>
                </div>
            </div>
        </div>
    </main>

    <footer>
      <%@ include file="/admin/footer.jsp" %>
    </footer>
</body>
</html>
