<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	HttpSession hs = request.getSession();
    String name = (String)hs.getAttribute("mname");
    String id = (String)hs.getAttribute("mid");
%>

 <header>
        <div class="container">
            <h1>E-Learning</h1>
            <nav>
                <ul>
                    <li><a href="/index.do">홈</a></li>
                    <li><a href="#">공지사항</a></li>
                    <li><a href="#">Q & A</a></li>
                    <li><a href="#">코스</a></li>
                    <li><a href="/cms/pg_elist.do">내 학습</a></li>
                    <% if(name == null) { %>
                    <li><a href="/member_login.jsp">로그인</a></li> 
                    <% } else { %>
                    <li> <%=name%>(<%=id%>) 님 <button type="button" onclick="logout()">로그아웃</button></li> 
                    <% } %>
                </ul>
            </nav>
        </div>
    </header>
    <script>
    	function logout(){
    		var url = window.location.origin;
    		if(confirm("로그아웃 하시겠습니까?")){
    			location.href=url + '/cms/logout.do';
    		}
    	}
    </script>
    