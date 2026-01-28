<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.*" %>
<%
    request.setCharacterEncoding("UTF-8");

    String category = request.getParameter("category");
    String title = request.getParameter("title");
    String content = request.getParameter("content");
    String writer = request.getParameter("writer");

    qna_dto dto = new qna_dto();
    dto.setCategory(category);
    dto.setTitle(title);
    dto.setContent(content);
    dto.setWriter(writer);

    qna_query query = new qna_query();
    int result = query.insert_qna(dto); // 아까 수정한 insert_qna 호출

    if(result > 0) {
%>
    <script>
        alert("질문이 성공적으로 등록되었습니다.");
        location.href="./edu_qa.jsp";
    </script>
<%
    } else {
%>
    <script>
        alert("등록에 실패했습니다.");
        history.back();
    </script>
<%
    }
%>