<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.*, java.util.*" %>

<%
    // 페이지 번호를 파라미터로 받습니다. (없으면 1페이지)
    String p = request.getParameter("page");
    int page_no = (p == null) ? 1 : Integer.parseInt(p);
    
    // 시작 번호 계산 (1페이지면 0번부터, 2페이지면 10번부터...)
    int start_no = (page_no - 1) * 10;
    qna_query query = new qna_query();
    ArrayList<qna_dto> list = query.select_all(start_no);
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
    
    
    <%
    // 전체 글 개수 가져오기
    int total_records = query.get_total_count();
    // 전체 페이지 수 계산 (예: 11개면 2페이지)
    int total_pages = (int)Math.ceil(total_records / 10.0);
	%>
	<div style="text-align:center; margin-top:20px;">
	    <% for(int i=1; i<=total_pages; i++) { %>
	        <a href="list.jsp?page=<%= i %>" 
	           style="margin:0 5px; text-decoration:none; <%= (page_no==i)?"font-weight:bold; color:red;":"" %>">
	           [<%= i %>]
	        </a>
	    <% } %>
	</div>
    
    
    
    
    
    <br>
    <button onclick="location.href='cms/write.jsp'">질문하기</button>
</body>
</html>