<%@page import="model.cate_dto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<cate_dto> all = (ArrayList)request.getAttribute("all");
	Integer total = Integer.valueOf(all.get(0).getCtn());
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>카테고리 관리</title>
    <link rel="stylesheet" href="../css/index.css">
    <link rel="stylesheet" href="css/cate_list.css?v=1">
</head>
<body>
    <header>
	<%@ include file="/admin/top.jsp" %>
    </header>

    <main>
        <div class="cate-list-container">
            <div class="list-header">
                <h1>카테고리 관리</h1>
                <p>카테고리 정보를 조회하고 관리할 수 있습니다.</p>
            </div>

            <div class="action-bar">
                <button class="btn-add" onclick="cate_add()">카테고리 추가</button>
            </div>

            <div class="table-wrapper">
                <table class="cate-table">
                    <thead>
                        <tr>
                            <th class="col-number">번호</th>
                            <th class="col-code">카테고리 코드</th>
                            <th class="col-name">카테고리명</th>
                            <th class="col-use">사용 유/무</th>
                            <th class="col-manage">카테고리 관리</th>
                        </tr>
                    </thead>
                    <tbody>
                    <% if(all == null) { %>
                    	<tr><td colspan="5">등록된 카테고리가 없습니다.</td></tr>
                    <% } else { 
                    	int w = 0;
                    	while(w < all.size()){
                    		Integer no = total - w;
                    %>
                        <tr>
                            <td class="col-number">1</td>
                            <td class="col-code"><%=all.get(w).getCate_code()%></td>
                            <td class="col-name"><%=all.get(w).getCate_name()%> (<%=all.get(w).getSubject_ea()%>)</td>
                            <td class="col-use"><%=all.get(w).getCate_use()%></td>
                            <td class="col-manage">
                                <a href="javascript:cate_modify('<%=all.get(w).getCate_code()%>')" class="btn-edit">수정</a>
                                <a href="javascript:cate_delete('<%=all.get(w).getCate_code()%>')" class="btn-delete">삭제</a>
                            </td>
                        </tr>
                    <%
                    	w++;
                    		}
                    	}
                    %>
                    </tbody>
                </table>
            </div>

            <div class="pagination">
                <a href="#" class="page-link prev">이전</a>
                <a href="#" class="page-link active">1</a>
                <a href="#" class="page-link">2</a>
                <a href="#" class="page-link">3</a>
                <a href="#" class="page-link">4</a>
                <a href="#" class="page-link">5</a>
                <a href="#" class="page-link next">다음</a>
            </div>
        </div>
    </main>

    <footer>
      <%@ include file="/admin/footer.jsp" %>
    </footer>
    <script src="/admin/js/cate_list.js?v=1"></script>
</body>
</html>
