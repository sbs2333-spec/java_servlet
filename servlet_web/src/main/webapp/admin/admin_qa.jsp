<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.*, java.util.*" %>
<%
    // Java 로직 (기본 유지)
    String admin_id = (String)session.getAttribute("admin_id");
    if(admin_id == null || !admin_id.equals("master")) {
        out.print("<script>alert('관리자 전용 페이지입니다.'); location.href='admin_login.jsp';</script>");
    }
    request.setCharacterEncoding("UTF-8");
    String search = request.getParameter("search");
    if(search == null) search = "";
    String p = request.getParameter("page");
    int page_no = (p == null) ? 1 : Integer.parseInt(p);
    int start_no = (page_no - 1) * 10;
    qna_query query = new qna_query();
    ArrayList<qna_dto> list = query.select_all(start_no, search);
    int total_records = query.get_total_count(search);
    int total_pages = (int)Math.ceil(total_records / 10.0);
%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>질문과 답변 관리</title>
    <link rel="stylesheet" href="../css/index.css">
    <link rel="stylesheet" href="../css/edu_qa.css">
    <style>
        /* 1. 선생님 포맷 드롭다운 메뉴 스타일 복구 */
        header { background: #333 !important; height: 80px !important; position: relative; width: 100%; }
        .nav-container { max-width: 1200px; margin: 0 auto; display: flex; justify-content: space-between; align-items: center; height: 100%; padding: 0 20px; }
        .logo { color: white; font-size: 24px; font-weight: bold; text-decoration: none; }
        
        .admin-menu { display: flex; list-style: none; gap: 30px; margin: 0; padding: 0; align-items: center; }
        .admin-menu > li { position: relative; }
        .admin-menu > li > a { color: white !important; text-decoration: none; font-size: 15px; font-weight: bold; padding: 30px 0; display: block; }

        /* 마우스 올리면 나타나는 하위 메뉴 */
        .dropdown-content {
            display: none; position: absolute; top: 80px; left: 50%; transform: translateX(-50%);
            background-color: #444; min-width: 140px; box-shadow: 0px 8px 16px rgba(0,0,0,0.2); z-index: 1001; border-radius: 4px;
        }
        .dropdown-content a { color: white !important; padding: 12px 16px; text-decoration: none; display: block; font-size: 13px; border-bottom: 1px solid #555; }
        .dropdown-content a:last-child { border-bottom: none; }
        .dropdown-content a:hover { background-color: #555; }
        .admin-menu li:hover .dropdown-content { display: block; }

        /* 2. 표 내부 정렬 및 버튼 스타일 */
        .qa-table td { vertical-align: middle !important; text-align: center !important; height: 70px; }
        .title-cell { text-align: left !important; padding-left: 20px !important; }

        .status-badge { display: inline-block; width: 45px; height: 25px; line-height: 25px; border-radius: 4px; font-weight: bold; font-size: 11px; }
        .status-wait { background: #ffc107; color: #212529 !important; }
        .status-done { background: #28a745; color: white !important; }
        
        .btn-action { display: block; width: 45px; height: 22px; line-height: 22px; font-size: 11px; border-radius: 3px; border: none; color: white !important; cursor: pointer; text-decoration: none; margin: 2px auto; }
        .btn-blue { background: #007bff; }
        .btn-red { background: #dc3545; }

        .pagination { margin: 30px 0 50px; text-align: center; }
        .pagination a { padding: 6px 12px; border: 1px solid #ddd; text-decoration: none; margin: 0 3px; border-radius: 3px; color: #007bff; }
        .pagination a.active { background: #007bff; color: white !important; border-color: #007bff; }
    </style>
</head>
<body>
    <header>
        <div class="nav-container">
            <a href="admin_main.do" class="logo">E-Learning</a>
            <ul class="admin-menu">
                <li><a href="admin_main.do">홈</a></li>
                <li>
                    <a href="#">관리</a>
                    <div class="dropdown-content">
                        <a href="#">회원관리</a>
                        <a href="#">공지사항 관리</a>
                        <a href="admin_qa.jsp">Q&A관리</a>
                        <a href="#">카테고리 관리</a>
                        <a href="#">과목 관리</a>
                    </div>
                </li>
                <li><a href="#">통계</a></li>
                <li style="color: #ccc; font-size: 13px; margin-left: 10px;">최고관리자(master)님 환영합니다.</li>
                <li><a href="admin_logout.jsp" style="font-size: 13px;">로그아웃</a></li>
            </ul>
        </div>
    </header>

    <main>
        <div class="qa-container" style="max-width: 1100px; margin: 40px auto; background: #fff; padding: 20px; border-radius: 8px; box-shadow: 0 0 10px rgba(0,0,0,0.05);">
            <h1 style="text-align: center; margin-bottom: 30px;">질문과 답변 관리</h1>
            
            <div class="search-box" style="text-align: center; margin-bottom: 30px;">
                <input type="text" id="search_word" value="<%= search %>" placeholder="제목, 글쓴이로 검색" style="width: 280px; padding: 10px; border: 1px solid #ddd; border-radius: 4px;">
                <button type="button" onclick="go_search()" style="background: #007bff; color: white; padding: 10px 20px; border: none; border-radius: 4px; cursor: pointer;">검색</button>
                <button type="button" onclick="location.href='admin_qa.jsp'" style="background: #6c757d; color: white; padding: 10px 20px; border: none; border-radius: 4px; cursor: pointer; margin-left: 5px;">초기화</button>
            </div>

            <table class="qa-table">
                <thead>
                    <tr>
                        <th width="60">번호</th>
                        <th width="100">분류</th>
                        <th>질문</th>
                        <th width="120">글쓴이</th>
                        <th width="80">조회수</th>
                        <th width="80">상태</th>
                        <th width="120">작성일</th>
                        <th width="80">관리</th>
                    </tr>
                </thead>
                <tbody>
                    <% for(qna_dto dto : list) { %>
                    <tr>
                        <td><%= dto.getQ_id() %></td>
                        <td><%= dto.getCategory() %></td>
                        <td class="title-cell">
                            <a href="admin_qaview.jsp?q_id=<%= dto.getQ_id() %>" style="color: #007bff; text-decoration: none; font-weight: bold;">
                                <%= dto.getTitle() %>
                            </a>
                        </td>
                        <td><%= dto.getWriter() %></td>
                        <td><%= dto.getHit() %></td>
                        <td>
                            <span class="status-badge <%= (dto.getStatus() == 0) ? "status-wait" : "status-done" %>">
                                <%= (dto.getStatus() == 0) ? "대기" : "완료" %>
                            </span>
                        </td>
                        <td><%= (dto.getIndate() != null) ? dto.getIndate().substring(0, 10) : "-" %></td>
                        <td>
                            <a href="admin_qaview.jsp?q_id=<%= dto.getQ_id() %>" class="btn-action btn-blue">답변</a>
                            <a href="javascript:del_qna('<%= dto.getQ_id() %>')" class="btn-action btn-red">삭제</a>
                        </td>
                    </tr>
                    <% } %>
                </tbody>
            </table>

            <div class="pagination">
                <% for(int i=1; i<=total_pages; i++) { %>
                    <a href="admin_qa.jsp?page=<%= i %>&search=<%= search %>" class="<%= (page_no == i) ? "active" : "" %>">
                        <%= i %>
                    </a>
                <% } %>
            </div>
        </div>
    </main>

    <script>
        function go_search() {
            var word = document.getElementById("search_word").value;
            location.href = "admin_qa.jsp?search=" + encodeURIComponent(word);
        }
        function del_qna(id) {
            if(confirm("정말 이 질문을 삭제하시습니까?")) {
                location.href = "admin_delete_ok.jsp?q_id=" + id;
            }
        }
    </script>

<style>
    /* admin_qaview.jsp와 동일한 블랙 푸터 스타일 */
    footer { 
        background: #333; 
        color: #aaa; 
        padding: 40px 0; 
        text-align: center; 
        font-size: 14px; 
        margin-top: 60px; 
        width: 100%;
        clear: both;
    }
    footer p { margin: 5px 0; }
</style>

<footer>
    <div class="container">
        <p>&copy; 2026 E-Learning Admin System. All rights reserved.</p>
        <p>관리 시스템 지원: master@elearning.com | 개인정보처리방침</p>
    </div>
</footer>

</body>
</html>