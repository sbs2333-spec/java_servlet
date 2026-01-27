<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // 선생님 가이드: 로그인 안 한 사용자가 오면 "망합니다" (로그인 체크)
    String userId = (String) session.getAttribute("userid"); // 세션 키값은 확인 필요
    
    if(userId == null) {
%>
        <script>
            alert("로그인 후 이용 가능합니다.");
            location.href="../login.jsp"; // 학원 프로젝트의 로그인 페이지 경로로 수정
        </script>
<%
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>질문 작성</title>
</head>
<body>
    <h2>질문 작성</h2>
    <form action="write_ok.jsp" method="post">
        <input type="hidden" name="writer" value="<%= userId %>">
        
        <table border="1">
            <tr>
                <th>분류</th>
                <td>
                    <select name="category">
                        <option value="수강신청">수강신청</option>
                        <option value="과제제출">과제제출</option>
                        <option value="강의듣기">강의듣기</option>
                        <option value="시험">시험</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>제목</th>
                <td><input type="text" name="title" style="width:90%;" required></td>
            </tr>
            <tr>
                <th>질문 내용</th>
                <td><textarea name="content" rows="10" style="width:90%;" required></textarea></td>
            </tr>
        </table>
        <br>
        <button type="submit">질문 등록</button>
        <button type="button" onclick="history.back();">취소</button>
    </form>
</body>
</html>