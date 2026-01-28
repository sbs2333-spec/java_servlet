<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.*, java.util.*" %>
<%
    request.setCharacterEncoding("UTF-8");
    String search = request.getParameter("search");
    
    // 만약 검색어가 null이면 무조건 빈 문자열로!
    if(search == null) {
        search = ""; 
    }

    String p = request.getParameter("page");
    int page_no = (p == null) ? 1 : Integer.parseInt(p);
    int start_no = (page_no - 1) * 10;

    qna_query query = new qna_query();
    
    // 여기서 search가 ""(빈값)이면 모든 목록을 가져오게 됩니다.
    ArrayList<qna_dto> list = query.select_all(start_no, search);
    int total_records = query.get_total_count(search);
    int total_pages = (int)Math.ceil(total_records / 10.0);
%>

<%-- 상단 메뉴 --%>
<%@ include file="/top.jsp" %>

<%-- 전용 디자인 파일 연결 --%>
<link rel="stylesheet" href="./css/edu_qa.css">

<main>
    <div class="qa-container">
        <h1>질문과 답변</h1>
        
        <div class="search-box">
            <%-- 검색창: 현재 검색어를 value에 유지 --%>
            <input type="text" id="search_word" class="search-input" value="<%= search %>" placeholder="제목, 글쓴이로 검색하세요">
            <button type="button" class="search-btn" onclick="go_search()">검색</button>
            <button type="button" class="search-reset" onclick="location.href='./edu_qa.jsp'">초기화</button>
            <button type="button" class="btn-write" onclick="location.href='./edu_qawrite.jsp'">질문하기</button>
            
   
        </div>
        
        <table class="qa-table">
            <thead>
                <tr>
                    <th width="80">번호</th>
                    <th width="120">분류</th>
                    <th>질문</th>
                    <th width="150">글쓴이</th>
                    <th width="80">조회수</th>
                    <th width="100">답변</th>
                    <th width="130">작성일</th>
                </tr>
            </thead>
            <tbody>
                <%
                    if(list == null || list.size() == 0) {
                %>
                    <tr><td colspan="7" class="no-data" style="text-align:center; padding:50px 0;">등록된 게시물이 없습니다.</td></tr>
                <%
                    } else {
                        for(qna_dto dto : list) {
                %>
                    <tr>
                        <td style="text-align: center;"><%= dto.getQ_id() %></td>
                        <td style="text-align: center;"><%= dto.getCategory() %></td>
                        <td class="title-cell" style="padding-left: 15px;">
                            <a href="./edu_qaview.jsp?q_id=<%= dto.getQ_id() %>">
                                <%= dto.getTitle() %>
                            </a>
                        </td>
                        <td style="text-align: center;"><%= dto.getWriter() %></td>
                        <td style="text-align: center;"><%= dto.getHit() %></td>
                        <td style="text-align: center;">
                            <span class="answer-status <%= (dto.getStatus() == 0) ? "pending" : "" %>">
                                <%= (dto.getStatus() == 0) ? "대기" : "완료" %>
                            </span>
                        </td>
                        <td style="text-align: center;">
                            <%
                                String dateStr = dto.getIndate(); 
                                if(dateStr != null && dateStr.length() >= 10) {
                                    out.print(dateStr.substring(0, 10));
                                } else {
                                    out.print("-");
                                }
                            %>
                        </td>
                    </tr>
                <%
                        }
                    }
                %>
            </tbody>
        </table>

        <%-- 페이징 처리: 링크 클릭 시 검색어(search)를 같이 넘겨야 결과가 유지됩니다 --%>
        <div class="pagination" style="text-align: center; margin-top: 30px;">
            <% for(int i=1; i<=total_pages; i++) { %>
                <a href="./edu_qa.jsp?page=<%= i %>&search=<%= search %>" 
                   class="page-link <%= (page_no == i) ? "active" : "" %>" style="margin: 0 5px;">
                    <%= i %>
                </a>
            <% } %>
        </div>
    </div>
</main>

<script>
// 검색 실행 함수
function go_search() {
    var word = document.getElementById("search_word").value;
    // 검색어를 포함하여 자기 자신(edu_qa.jsp)으로 이동
    location.href = "./edu_qa.jsp?search=" + encodeURIComponent(word);
}

// 엔터키 검색 지원
document.getElementById("search_word").addEventListener("keypress", function(e) {
    if (e.key === 'Enter') {
        go_search();
    }
});
</script>

<%@ include file="/footer.jsp" %>