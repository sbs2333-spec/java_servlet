<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.*" %>
<%
    String admin_id = (String)session.getAttribute("admin_id");
    if(admin_id == null || !admin_id.equals("master")) {
        out.print("<script>alert('관리자 전용입니다.'); location.href='admin_login.jsp';</script>");
    }
    String q_id = request.getParameter("q_id");
    qna_query query = new qna_query();
    qna_dto dto = query.select_one(q_id);
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>질문 상세 보기 및 답변 (70% 최적화 모드)</title>
    <link rel="stylesheet" href="../css/index.css">
    <link rel="stylesheet" href="../css/edu_qa.css">
    <style>
        /* 상단 드롭다운 메뉴 (유지) */
        header { background: #333 !important; height: 80px !important; position: relative; width: 100%; z-index: 1000; }
        .nav-container { max-width: 1400px; margin: 0 auto; display: flex; justify-content: space-between; align-items: center; height: 100%; padding: 0 20px; }
        .logo { color: white; font-size: 24px; font-weight: bold; text-decoration: none; }
        .admin-menu { display: flex; list-style: none; gap: 30px; align-items: center; }
        .admin-menu > li { position: relative; }
        .admin-menu > li > a { color: white !important; text-decoration: none; font-size: 15px; font-weight: bold; padding: 30px 0; display: block; }
        .dropdown-content {
            display: none; position: absolute; top: 80px; left: 50%; transform: translateX(-50%);
            background-color: #444; min-width: 140px; box-shadow: 0px 8px 16px rgba(0,0,0,0.2); z-index: 1001; border-radius: 4px;
        }
        .dropdown-content a { color: white !important; padding: 12px 16px; text-decoration: none; display: block; font-size: 13px; border-bottom: 1px solid #555; }
        .admin-menu li:hover .dropdown-content { display: block; }

        /* 본문 레이아웃 (요청하신 70% 폭 적용) */
        .view-container { 
            width: 70%;           /* 전체 화면의 70% */
            min-width: 1000px;    /* 너무 좁아지는 것 방지 */
            max-width: 1600px;    /* 너무 퍼지는 것 방지 */
            margin: 40px auto; 
            background: #fff; 
            padding: 50px; 
            border-radius: 10px; 
            box-shadow: 0 0 15px rgba(0,0,0,0.1); 
            box-sizing: border-box;
        }
        
        .content-box { 
            background-color: #f8f9fa; 
            padding: 30px; 
            border-radius: 5px; 
            border-left: 6px solid #007bff; 
            margin: 25px 0 50px; 
            line-height: 1.8; 
            font-size: 16px;
        }
        
        .form-control { 
            width: 100%; border: 1px solid #ddd; padding: 15px; border-radius: 4px; 
            box-sizing: border-box; font-size: 16px;
        }
        
        .status-done-badge { background-color: #28a745; color: white; padding: 6px 15px; border-radius: 4px; font-weight: bold; font-size: 14px; }
        .btn-group { text-align: center; margin-top: 40px; display: flex; justify-content: center; gap: 15px; }
        .btn-save { background: #28a745; color: white; border: none; padding: 15px 40px; border-radius: 4px; cursor: pointer; font-weight: bold; font-size: 16px; }
        .btn-reset { background: #6c757d; color: white; border: none; padding: 15px 40px; border-radius: 4px; cursor: pointer; font-size: 16px; }
        .btn-cancel { background: #dc3545; color: white; border: none; padding: 15px 40px; border-radius: 4px; cursor: pointer; font-size: 16px; }

        footer { background: #333; color: #aaa; padding: 40px 0; text-align: center; font-size: 14px; margin-top: 60px; }
    </style>
</head>
<body>
    <header>
        <div class="nav-container">
            <a href="admin_main.do" class="logo">E-Learning Admin</a>
            <ul class="admin-menu">
                <li><a href="admin_main.do">홈</a></li>
                <li>
                    <a href="#">관리</a>
                    <div class="dropdown-content">
                        <a href="#">회원관리</a>
                        <a href="#">공지사항 관리</a>
                        <a href="admin_qa.jsp">Q&A관리</a>
                    </div>
                </li>
                <li><a href="#">통계</a></li>
                <li style="color: #ccc; font-size: 13px; margin-left: 10px;">관리자님 환영합니다</li>
                <li><a href="admin_logout.jsp">로그아웃</a></li>
            </ul>
        </div>
    </header>

    <main>
        <div class="view-container">
            <div style="display: flex; justify-content: space-between; align-items: center;">
                <h2 style="margin: 0; font-size: 28px;">질문 상세 및 답변 등록</h2>
                <% if(dto.getStatus() == 1) { %><span class="status-done-badge">답변완료</span><% } %>
            </div>
            
            <div class="view-info" style="margin-top: 20px; color: #666; font-size: 15px; border-bottom: 1px solid #eee; padding-bottom: 15px;">
                <span>분류: <b><%= dto.getCategory() %></b></span> | 
                <span>작성자: <b><%= dto.getWriter() %></b></span> | 
                <span>조회수: <b><%= dto.getHit() %></b></span>
            </div>

            <div class="content-box">
                <p style="font-weight: bold; font-size: 20px; margin-bottom: 15px; color: #333;"><%= dto.getTitle() %></p>
                <%= (dto.getContent() != null) ? dto.getContent().replace("\n", "<br>") : "" %>
            </div>

            <div class="answer-form" style="border-top: 2px solid #eee; padding-top: 30px;">
                <h3 style="margin-bottom: 25px;">답변 작성</h3>
                <form action="admin_answer_ok.jsp" method="post">
                    <input type="hidden" name="q_id" value="<%= dto.getQ_id() %>">
                    <div style="margin-bottom: 20px;">
                        <label style="display: block; margin-bottom: 10px; font-weight: bold;">답변 제목</label>
                        <input type="text" name="answer_title" class="form-control" value="Re: <%= dto.getTitle() %>" required>
                    </div>
                    <div>
                        <label style="display: block; margin-bottom: 10px; font-weight: bold;">답변 내용</label>
                        <textarea name="answer_content" class="form-control" style="height: 300px;" required><%= (dto.getAnswer_content() != null) ? dto.getAnswer_content() : "" %></textarea>
                    </div>
                    <div class="btn-group">
                        <button type="submit" class="btn-save">답변 등록</button>
                        <button type="reset" class="btn-reset">초기화</button>
                        <button type="button" class="btn-cancel" onclick="location.href='admin_qa.jsp'">목록으로</button>
                    </div>
                </form>
            </div>
        </div>
    </main>

    <footer>
        <p>&copy; 2026 E-Learning Admin System</p>
    </footer>
</body>
</html>