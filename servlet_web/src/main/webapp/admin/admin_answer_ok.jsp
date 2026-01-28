<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.*" %>
<%
    request.setCharacterEncoding("UTF-8");

    // 1. 파라미터 받기
    int q_id = Integer.parseInt(request.getParameter("q_id"));
    String answer_title = request.getParameter("answer_title");
    String answer_content = request.getParameter("answer_content");

    // 2. DTO에 담기
    qna_dto dto = new qna_dto();
    dto.setQ_id(q_id);
    dto.setAnswer_title(answer_title);
    dto.setAnswer_content(answer_content);

    // 3. DB 업데이트 (이미 만들어둔 update_answer 메서드 사용)
    qna_query query = new qna_query();
    int result = query.update_answer(dto);
 
    if(result > 0) {
%>
    <script>
        alert("답변이 성공적으로 등록되었습니다.");
        location.href="admin_qa.jsp";
    </script>
<%
    } else {
%>
    <script>
        alert("답변 등록에 실패했습니다.");
        history.back();
    </script>
<%
    }
%>