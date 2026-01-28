<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.*, java.util.*" %>
<%
    // 관리자 세션 체크 (관리자 아이디가 'admin'이라고 가정)
    String adminId = (String) session.getAttribute("userid");
    if(adminId == null || !adminId.equals("admin")) {
%>
        <script>alert("관리자만 접근 가능합니다."); location.href="login.jsp";</script>
<%
        return;
    }

    qna_query query = new qna_query();
    ArrayList<qna_dto> list = query.select_all(0); // 관리자는 일단 전체를 본다고 가정
%>
<!DOCTYPE html>
<html>
<head><title>관리자 질문 관리</title></head>
<body>
    <h2>관리자 전용 - 질문 답변 관리</h2>
    <table border="1" style="width:100%">
        <tr>
            <th>번호</th><th>분류</th><th>질문</th><th>글쓴이</th><th>상태</th><th>관리</th>
        </tr>
        <% for(qna_dto dto : list) { %>
        <tr>
            <td><%= dto.getQ_id() %></td>
            <td><%= dto.getCategory() %></td>
            <td><%= dto.getTitle() %></td>
            <td><%= dto.getWriter() %></td>
            <td><%= (dto.getStatus()==0) ? "대기" : "완료" %></td>
            <td>
                <button onclick="location.href='cms/answer.jsp?q_id=<%= dto.getQ_id() %>'">답변하기</button>
            </td>
        </tr>
        <% } %>
    </table>
</body>
</html>