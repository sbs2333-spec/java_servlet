<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.*" %>
<%@ include file="/top.jsp" %>
<%
    // 1. 목록에서 보낸 q_id 받기
    String q_id = request.getParameter("q_id");
    
    // [중요] 2. 객체 생성을 먼저 해야 에러가 나지 않습니다.
    qna_query query = new qna_query(); 

    // 3. 조회수 1 증가 (상세 데이터를 가져오기 전에 실행)
    if(q_id != null) {
        query.update_hit(q_id); 
    }

    // 4. 상세 정보 가져오기
    qna_dto dto = query.select_one(q_id); 
%>

<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/edu_qa.css">

<main>
    <div class="qa-container">
        <h1>질문 상세보기</h1>
        
        <table class="qa-table view-table">
            <tr>
                <th width="150">분류</th>
                <td><%= dto.getCategory() %></td>
                <th width="150">작성자</th>
                <td><%= dto.getWriter() %></td>
            </tr>
            <tr>
                <th>제목</th>
                <td colspan="3" style="font-weight: bold;"><%= dto.getTitle() %></td>
            </tr>
            <tr>
                <th>내용</th>
                <td colspan="3" style="min-height: 300px; vertical-align: top; padding: 20px; line-height: 1.6;">
                    <%= (dto.getContent() != null) ? dto.getContent().replace("\n", "<br>") : "" %>
                </td>
            </tr>
            
            <%-- 학원에서 했던 기능: 관리자 답변이 있을 때만 예쁜 디자인으로 노출 --%>
            <% if(dto.getStatus() == 1) { %>
            <tr style="background-color: #f4f7f9; border-top: 2px solid #28a745;">
                <th style="color: #28a745;">관리자 답변</th>
                <td colspan="3">
                    <div style="font-weight: bold; margin-bottom: 10px;">
                        [답변] <%= dto.getAnswer_title() %>
                    </div>
                    <div style="line-height: 1.6;">
                        <%= (dto.getAnswer_content() != null) ? dto.getAnswer_content().replace("\n", "<br>") : "" %>
                    </div>
                </td>
            </tr>
            <% } %>
        </table>

        <div class="form-button-group" style="text-align: center; margin-top: 30px;">
            <button type="button" class="btn-submit" onclick="location.href='edu_qa.jsp'">목록으로</button>
            <%-- 본인 글일 때만 보이는 수정 버튼 --%>
            <% if(id != null && id.equals(dto.getWriter())) { %>
                <button type="button" class="btn-reset" onclick="alert('수정 기능 준비 중')">수정하기</button>
            <% } %>
        </div>
    </div>
</main>

<%@ include file="/footer.jsp" %>