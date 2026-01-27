<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>공지사항 작성</title>
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="css/edu_notice_write.css">
</head>
<body>

    <%@ include file="./top.jsp"%>
    
    <main>
        <div class="write-container">
            <h1>공지사항 작성</h1>
            <form id="frm" class="write-form">
                <div class="form-group">
                    <label>제목 <span class="required">*</span></label>
                    <input type="text" name="title" class="input-field" placeholder="공지사항 제목을 입력하세요" required>
                </div>
                <div class="form-group">
                    <label>글쓴이 <span class="required">*</span></label>
                    <input type="text" name="writer" class="input-field" placeholder="글쓴이를 입력하세요" value="관리자" readonly>
                </div>
                <div class="form-group">
                    <label>내용 <span class="required">*</span></label>
                    <textarea name="contents" class="textarea-field" placeholder="공지사항 내용을 입력하세요" required></textarea>
                </div>
                <div class="form-group">
                    <label>카테고리 <span class="required">*</span></label>
                    <select name="cat" class="select-field">
                        <option>일반공지</option>
                        <option>긴급공지</option>
                        <option>강의공지</option>
                        <option>시스템공지</option>
                    </select>
                </div>
                <div class="form-buttons">
                    <button type="button" class="btn-submit" onclick="gopage()">등록</button>
                    <button type="reset" class="btn-reset">취소</button>
                </div>
            </form>
        </div>
    </main>
<%@ include file="./footer.jsp" %>
</body>
<script src="./js/edu_notice_write.js"></script>
</html>
