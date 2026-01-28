<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.*" %>
<%
    String q_id = request.getParameter("q_id");
    qna_query query = new qna_query();
    qna_dto dto = query.select_one(q_id); // 질문 내용 미리 보기용
%>
<!DOCTYPE html>
<html>
<head><title>답변 등록</title></head>
<body>
    <h2>질문 내용</h2>
    <p>제목: <%= dto.getTitle() %></p>
    <p>내용: <%= dto.getContent() %></p>
    <hr>
    <h2>답변 작성</h2>
    <form action="answer_ok.jsp" method="post">
        <input type="hidden" name="q_id" value="<%= q_id %>">
        답변 제목: <input type="text" name="a_title" style="width:80%"><br><br>
        답변 내용: <textarea name="a_content" rows="5" style="width:80%"></textarea><br><br>
        <button type="submit">답변 완료</button>
    </form>
</body>
</html>