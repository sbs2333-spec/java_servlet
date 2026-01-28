<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/top.jsp" %>
<%
    // 로그인 체크 (top.jsp의 id 변수 활용)
    if (id == null) {
%>
    <script>
        alert("로그인이 필요한 서비스입니다.");
        location.href="./member_login.jsp";
    </script>
<%
    }
%>

<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/edu_qa.css">

<main>
    <div class="qawrite-container">
        <div class="back-button">
            <a href="edu_qa.jsp">목록으로 돌아가기</a>
        </div>
        
        <div class="write-question-section">
            <h1>질문 작성</h1>
            <%-- action 경로를 write_ok.jsp로 정확히 지정합니다 --%>
            <form action="write_ok.jsp" method="post" class="question-form">
                <%-- 작성자 ID를 hidden으로 포함 --%>
                <input type="hidden" name="writer" value="<%= id %>">
                
                <div class="form-group">
                    <label for="question-category">분류 *</label>
                    <select name="category" class="question-select" required>
                        <option value="">분류를 선택하세요</option>
                        <option value="수강신청">수강신청</option>
                        <option value="과제제출">과제제출</option>
                        <option value="강의듣기">강의듣기</option>
                        <option value="시험">시험</option>
                        <option value="수료증">수료증</option>
                        <option value="기타">기타</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="question-title">제목 *</label>
                    <input type="text" name="title" class="question-input" placeholder="질문의 제목을 입력하세요" required>
                </div>

                <div class="form-group">
                    <label for="question-content">질문 내용 *</label>
                    <textarea name="content" class="question-textarea" placeholder="질문의 내용을 자세히 작성해주세요" rows="12" required></textarea>
                </div>

                <div class="form-notice">
                    <strong>유의사항:</strong>
                    <ul>
                        <li>질문 제목과 내용은 명확하고 구체적으로 작성해주세요.</li>
                        <li>이미 답변된 질문이 있는지 먼저 확인해주세요.</li>
                        <li>개인정보는 포함하지 말아주세요.</li>
                        <li>부적절한 내용은 관리자에 의해 삭제될 수 있습니다.</li>
                    </ul>
                </div>

                <div class="form-button-group">
                    <button type="submit" class="btn-submit">질문 등록</button>
                    <button type="reset" class="btn-reset">초기화</button>
                    <a href="edu_qa.jsp" class="btn-cancel">취소</a>
                </div>
            </form>
        </div>
    </div>
</main>

<%@ include file="/footer.jsp" %>