<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.*, java.util.*" %>
<%
    // 1. DAO(Query) 객체 생성 및 목록 가져오기
    qna_query query = new qna_query();
    ArrayList<qna_dto> list = query.select_all();
    
    // 2. 선생님 가이드: 10개씩 출력 로직은 데이터 출력 확인 후 적용하겠습니다.
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>E-Learning 질문과 답변</title>
<style>
    table { width: 100%; border-collapse: collapse; margin-top: 20px; }
    th, td { border: 1px solid #ddd; padding: 12px; text-align: center; }
    th { background-color: #f4f4f4; }
    .status-wait { color: orange; font-weight: bold; }
    .status-done { color: green; font-weight: bold; }
</style>
</head>
<body>
    <h2>질문과 답변</h2>
    <table>
        <thead>
            <tr>
                <th>번호</th>
                <th>분류</th>
                <th>질문</th>
                <th>글쓴이</th>
                <th>조회수</th>
                <th>답변</th>
                <th>작성일</th>
            </tr>
        </thead>
        <tbody>
            <% if(list.size() == 0) { %>
                <tr><td colspan="7">등록된 게시물이 없습니다.</td></tr>
            <% } else { 
                for(qna_dto dto : list) { %>
                <tr>
                    <td><%= dto.getQ_id() %></td>
                    <td><%= dto.getCategory() %></td>
                    <td><a href="view.jsp?q_id=<%= dto.getQ_id() %>"><%= dto.getTitle() %></a></td>
                    <td><%= dto.getWriter() %></td>
                    <td><%= dto.getHit() %></td>
                    <td>
                        <% if(dto.getStatus() == 0) { %>
                            <span class="status-wait">대기</span>
                        <% } else { %>
                            <span class="status-done">완료</span>
                        <% } %>
                    </td>
                    <td><%= dto.getReg_date() %></td>
                </tr>
            <%  } 
               } %>
        </tbody>
    </table>
    <br>
    <button onclick="location.href='write.jsp'">질문하기</button>
</body>
</html>