<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>공지사항</title>
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="css/edu_notice.css">
</head>
<body>
<%@ include file="./top.jsp" %>
    <main>
        <div class="notice-container">
            <h1>공지사항</h1>
            <div class="search-box">
                <input type="text" name="title" class="search-input" placeholder="제목, 글쓴이로 검색하세요">
                <button class="search-btn">검색</button>
                <button class="search-reset">초기화</button>
            </div>
            <table class="notice-table">
                <thead>
                    <tr>
                        <th width="80">번호</th>
                        <th width="150">분류</th>
                        <th>제목</th>
                        <th width="150">글쓴이</th>
                        <th width="100">조회수</th>
                        <th width="130">작성일</th>
                    </tr>
                </thead>
                <tbody>
                    <tr><td colspan="6">등록된 게시물이 없습니다.</td></tr>
                    <tr>
                        <td>1</td>
                        <td>일반공지</td>
                        <td class="title-cell" style="text-align: left;"><a href="#">2026년 1월 강의 시작 안내</a></td>
                        <td>관리자</td>
                        <td>245</td>
                        <td>2026-01-15</td>
                    </tr>
                </tbody>
            </table>
            <div class="pagination">
                <a href="#" class="page-link">1</a>
                <a href="#" class="page-link">2</a>
                <a href="#" class="page-link">3</a>
                <a href="#" class="page-link">4</a>
                <a href="#" class="page-link">5</a>
            </div>
        </div>
    </main>
<%@ include file="./footer.jsp" %>
</body>
</html>
    