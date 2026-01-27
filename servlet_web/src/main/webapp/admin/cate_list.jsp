<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>카테고리 관리</title>
    <link rel="stylesheet" href="../css/index.css">
    <link rel="stylesheet" href="css/cate_list.css">
</head>
<body>
    <header>
	 <%@ include file="top.jsp"%>
    </header>

    <main>
        <div class="cate-list-container">
            <div class="list-header">
                <h1>카테고리 관리</h1>
                <p>카테고리 정보를 조회하고 관리할 수 있습니다.</p>
            </div>

            <div class="action-bar">
               <!-- 
               <button class="btn-add" onclick="location.href='./admin/cate_insert.do">카테고리 추가</button>
               -->
                <button class="btn-add" onclick="cate_add()">카테고리 추가</button>
            </div>

            <div class="table-wrapper">
                <table class="cate-table">
                    <thead>
                        <tr>
                            <th class="col-number">번호</th>
                            <th class="col-code">카테고리 코드</th>
                            <th class="col-name">카테고리명</th>
                            <th class="col-manage">카테고리 관리</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td class="col-number">1</td>
                            <td class="col-code">CAT001</td>
                            <td class="col-name">프로그래밍</td>
                            <td class="col-manage">
                                <a href="#" class="btn-edit">수정</a>
                                <a href="#" class="btn-delete">삭제</a>
                            </td>
                        </tr>
                        <tr>
                            <td class="col-number">2</td>
                            <td class="col-code">CAT002</td>
                            <td class="col-name">웹 개발</td>
                            <td class="col-manage">
                                <a href="#" class="btn-edit">수정</a>
                                <a href="#" class="btn-delete">삭제</a>
                            </td>
                        </tr>
                        <tr>
                            <td class="col-number">3</td>
                            <td class="col-code">CAT003</td>
                            <td class="col-name">데이터베이스</td>
                            <td class="col-manage">
                                <a href="#" class="btn-edit">수정</a>
                                <a href="#" class="btn-delete">삭제</a>
                            </td>
                        </tr>
                        <tr>
                            <td class="col-number">4</td>
                            <td class="col-code">CAT004</td>
                            <td class="col-name">모바일 앱</td>
                            <td class="col-manage">
                                <a href="#" class="btn-edit">수정</a>
                                <a href="#" class="btn-delete">삭제</a>
                            </td>
                        </tr>
                        <tr>
                            <td class="col-number">5</td>
                            <td class="col-code">CAT005</td>
                            <td class="col-name">클라우드 컴퓨팅</td>
                            <td class="col-manage">
                                <a href="#" class="btn-edit">수정</a>
                                <a href="#" class="btn-delete">삭제</a>
                            </td>
                        </tr>
                        <tr>
                            <td class="col-number">6</td>
                            <td class="col-code">CAT006</td>
                            <td class="col-name">인공지능</td>
                            <td class="col-manage">
                                <a href="#" class="btn-edit">수정</a>
                                <a href="#" class="btn-delete">삭제</a>
                            </td>
                        </tr>
                        <tr>
                            <td class="col-number">7</td>
                            <td class="col-code">CAT007</td>
                            <td class="col-name">빅데이터</td>
                            <td class="col-manage">
                                <a href="#" class="btn-edit">수정</a>
                                <a href="#" class="btn-delete">삭제</a>
                            </td>
                        </tr>
                        <tr>
                            <td class="col-number">8</td>
                            <td class="col-code">CAT008</td>
                            <td class="col-name">보안</td>
                            <td class="col-manage">
                                <a href="#" class="btn-edit">수정</a>
                                <a href="#" class="btn-delete">삭제</a>
                            </td>
                        </tr>
                        <tr>
                            <td class="col-number">9</td>
                            <td class="col-code">CAT009</td>
                            <td class="col-name">네트워크</td>
                            <td class="col-manage">
                                <a href="#" class="btn-edit">수정</a>
                                <a href="#" class="btn-delete">삭제</a>
                            </td>
                        </tr>
                        <tr>
                            <td class="col-number">10</td>
                            <td class="col-code">CAT010</td>
                            <td class="col-name">소프트웨어 아키텍처</td>
                            <td class="col-manage">
                                <a href="#" class="btn-edit">수정</a>
                                <a href="#" class="btn-delete">삭제</a>
                            </td>
                        </tr>
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
		<%@ include file="footer.jsp"%>
    </footer>
</body>
<script src="/admin/js/cate_list.js?v=1"></script>
</html>
    