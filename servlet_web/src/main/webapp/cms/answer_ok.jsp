<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.*" %>
<%
    request.setCharacterEncoding("utf-8");

    // 1. 파라미터 받기
    int q_id = Integer.parseInt(request.getParameter("q_id"));
    String a_title = request.getParameter("a_title");
    String a_content = request.getParameter("a_content");

    // 2. DTO에 답변 내용 담기
    qna_dto dto = new qna_dto();
    dto.setQ_id(q_id);
    dto.setAnswer_title(a_title);
    dto.setAnswer_content(a_content);

    // 3. DAO(Query) 호출하여 업데이트
    qna_query query = new qna_query();
    int result = query.update_answer(dto);

    if(result > 0) {
%>
        <script>
            alert("답변 등록이 완료되었습니다.");
            location.href="../admin_list.jsp"; // 관리자 목록으로 이동
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