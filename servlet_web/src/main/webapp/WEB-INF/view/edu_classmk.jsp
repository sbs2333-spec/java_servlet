<%@page import="model.cate_dto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
ArrayList<cate_dto> all = (ArrayList)request.getAttribute("all");
if(all.size() > 0) {
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>과목 등록</title>
    <link rel="stylesheet" href="/css/index.css">
    <link rel="stylesheet" href="/css/edu_classmk.css">
</head>
<body>
   <%@ include file="/top.jsp"%>
    <main>
        <div class="classmk-container">
            <h1>과목 등록</h1>
            <form id="frm" class="classmk-form">
                <div class="form-group">
                    <label>과목명</label>
                    <input type="text" name="subject_nm" class="input-field" placeholder="과목명을 입력하세요">
                </div>

                <div class="form-group">
                    <label>강사명</label>
                    <input type="text" name="teacher_nm" class="input-field" placeholder="강사명을 입력하세요">
                </div>

                <div class="form-group">
                    <label>총 수업시간</label>
                    <input type="number" name="class_time" class="input-field" placeholder="총 수업시간을 입력하세요" min="0">
                </div>

                <div class="form-group">
                    <label>과목 카테고리</label>
                    <select class="input-field" name="cate_code">
                        <option value="">-- 과목 선택 --</option>
                        <%
                        	int w = 0;
                        	while(w < all.size()){
                        %>
                        <option value="<%=all.get(w).getCate_code()%>">
                        <%=all.get(w).getCate_name()%>
                        </option>
                        <%
                        	w++;
                        	}
                        %>
                    </select>
                </div>

                <div class="form-group">
                    <label>난이도</label>
                    <select class="input-field" name="class_level">
                        <option value="">-- 선택 --</option>
                        <option value="1">초급</option>
                        <option value="2">중급</option>
                        <option value="3">고급</option>
                    </select>
                </div>

                <div class="form-group">
                    <label>수강 대상</label>
                    <textarea class="input-field textarea" name="class_text" placeholder="수강 대상을 입력하세요" rows="3"></textarea>
                </div>

                <div class="form-group">
                    <label>과목 설명</label>
                    <textarea class="input-field textarea" name="subject_text" placeholder="과목 설명을 입력하세요" rows="5"></textarea>
                </div>

                <div class="form-row">
                    <div class="form-group">
                        <label>시작일</label>
                        <input type="date" name="start_day" class="input-field">
                    </div>
                    <div class="form-group">
                        <label>종료일</label>
                        <input type="date" name="end_day" class="input-field">
                    </div>
                </div>

                <div class="form-group">
                    <label>최대 수강인원</label>
                    <input type="number" name="max_no" class="input-field" placeholder="최대 수강인원을 입력하세요" min="1" maxlength="4">
                </div>

                <div class="form-group">
                    <label>과목 상태</label>
                    <select class="input-field" name="class_use">
                        <option value="">-- 선택 --</option>
                        <option value="R">개설예정</option>
                        <option value="Y">개설중</option>
                        <option value="N">종료</option>
                    </select>
                </div>

                <div class="button-group">
                    <button type="button" class="btn btn-primary" id="class_maker">등록</button>
                    <button type="reset" class="btn btn-secondary">초기화</button>
                    <button type="button" class="btn btn-cancel" onclick="location.href='./index.jsp';">취소</button>
                </div>
            </form>
        </div>
    </main>
  <script src="/js/edu_classmk.js"></script>
  <%@ include file="/footer.jsp"%>
<%
  }
%>
</body>
</html>
