<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.*" %>
<%
    request.setCharacterEncoding("utf-8");

    // 1. 파라미터 받기
    String category = request.getParameter("category");
    String title = request.getParameter("title");
    String content = request.getParameter("content");
    String writer = request.getParameter("writer"); // hidden으로 넘어온 세션 아이디

    // 2. DTO에 담기
    qna_dto dto = new qna_dto();
    dto.setCategory(category);
    dto.setTitle(title);
    dto.setContent(content);
    dto.setWriter(writer);

    // 3. DAO(Query) 호출
    qna_query query = new qna_query();
    int result = query.insert_qna(dto);

    if(result > 0) {
%>
        <script>
            alert("질문이 등록되었습니다.");
            location.href="../list.jsp";
        </script>
<%
    } else {
%>
        <script>
            alert("등록 실패! 다시 시도해주세요.");
            history.back();
        </script>
<%
    }
%>