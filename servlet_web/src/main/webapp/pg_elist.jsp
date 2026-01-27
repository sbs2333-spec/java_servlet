<%@page import="model.edu_dto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//Java > javascript > html > css
	String result = (String)request.getAttribute("result");
	ArrayList<edu_dto> alldata = (ArrayList)request.getAttribute("alldata");
	String search = (String)request.getAttribute("search");		//사용자가 검색한 단어를 가져옴
	Integer total = (Integer)request.getAttribute("total");
%>
<%
if(result != "") {
%>
<script>
<%=result%>
</script>
<% } else {  %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>수강신청 리스트</title>
    <link rel="stylesheet" href="../css/index.css">
    <link rel="stylesheet" href="../css/pg_elist.css">
</head>
<body>
   <%@ include file="./top.jsp"%>
    <main>
        <div class="elist-container">
            <h1>수강신청 리스트</h1>
            
            <!-- 과목을 검색시 해당 데이터를 검색할 수 있는 기능 -->
            <form id="sfrm" method="get" action="./pg_elist.do" onsubmit="return search_ck()">
            <div class="search-box">
                <input type="text" name="search" value="<%=search%>" class="search-input" placeholder="과목명으로 검색하세요">
                <button class="search-btn" value="">검색</button>
                <button type="button" class="search-reset" onclick="location.href='./pg_elist.do';">초기화</button>
            </div>
            </form>
             <!-- 과목을 검색시 해당 데이터를 검색할 수 있는 기능 끝 -->
             
            <table class="elist-table">
                <thead>
                    <tr>
                        <th>아이디</th>
                        <th>학생명</th>
                        <th>과목명</th>
                        <th>신청일자</th>
                        <th>수강여부</th>
                    </tr>
                </thead>
                <tbody>
                <%
                	if(alldata.size() == 0) {
                %>
                	<tr><td colspan="5">수강신청한 과목이 없습니다.</td></tr>
                <%
                	} else {
                		int w=0;
                		while(w < alldata.size()){
                %>
                    <tr>
                        <td><%=alldata.get(w).getMid()%></td>
                        <td><%=alldata.get(w).getMname()%></td>
                        <td><%=alldata.get(w).getSubject()%></td>
                        <td><%=alldata.get(w).getIndate().substring(0,10)%></td>
                        <td class="action-cell">
                            <button type="button" class="btn-start">강의시작</button>
                            <button type="button" class="btn-cancel" onclick="cancel_edu(<%=alldata.get(w).getEidx()%>)">수강취소</button>
                        </td>
                    </tr>
                <%
                		w++;
                		}
                	} 
                 %>   
                </tbody>
            </table>
            <div class="pagination">
            <%
            if(total > 0) {	//수강신청 데이터가 있는 아이디만 페이지 네이션이 작동 되도록 함
            	//Math.ceil => 소수점을 무조건 올림처리 하여 Integer로 변환하여 페이지 반영
            	Integer pgno = (int)Math.ceil((double)total / 3);
            	int f = 1;
            	while(f <= pgno){
            %>
                <a href="javascript:gopage(<%=f%>)" class="page-link"><%=f%></a>
            <%
            	f++;
            	}
            }
            %>
            </div>
        </div>
        <!-- 삭제 전용으로 사용하는 form 이며, security 적용한 이유는 Guest가 강제 삭제 못하도록 설정 -->
        <form id="delfrm">
        	<input type="hidden" name="eidx" value="">
        	<input type="hidden" name="mid" value="<%=id%>">
        	<input type="hidden" name="security" value="educode">
        </form>
    </main>
  <script src="/js/pg_elist.js?v=20260116"></script>
  <%@ include file="./footer.jsp"%>
</body>
</html>
<%
	}
%>
