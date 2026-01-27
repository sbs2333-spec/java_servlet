<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	HttpSession hs = request.getSession();
    String name = (String)hs.getAttribute("admin_name");
    String id = (String)hs.getAttribute("admin_id");
    if(name != null || id != null){
%>
        <div class="container">
            <h1>E-Learning</h1>
            <nav>
                <ul>
                    <li><a href="./admin_main.do">홈</a></li>
                    <li class="menu-item">
                        <a href="#">관리</a>
                        <ul class="submenu">
                            <li><a href="#">회원관리</a></li>
                            <li><a href="#">공지사항 관리</a></li>
                            <li><a href="#">Q&A관리</a></li>
                            <li><a href="./cate_list.do">카테고리 관리</a></li>
                            <li><a href="./subject_list.do">과목 관리</a></li>
                        </ul>
                    </li>
                    <li><a href="#">통계</a></li>
                    <% if(name != null) { %>
                    <li><%=name%>(<%=id%>)님 환영합니다.</li>
                    <li><a href="./admin_logout.do">로그아웃</a></li>
                    <% } %>
                </ul>
            </nav>
        </div>
<%
    }
%>