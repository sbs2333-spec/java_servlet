<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>카테고리 등록</title>
    <link rel="stylesheet" href="../css/index.css">
    <link rel="stylesheet" href="css/cate_insert.css">
</head>
<body>
    <header>
        	 <%@ include file="/admin/top.jsp"%>
    </header>

    <main>
        <div class="cate-insert-container">
            <div class="form-header">
                <h1>카테고리 등록</h1>
                <p>새로운 카테고리를 등록하실 수 있습니다.</p>
            </div>

            <form id="frm" class="cate-insert-form">
                <div class="form-section">
                    <h2>카테고리 정보</h2>

                    <div class="form-group">
                        <label class="form-label">카테고리 코드 <span class="required">*</span></label>
                        <div class="input-wrapper">
                            <input name="cate_code" type="text" class="input-field input-code" placeholder="카테고리 코드를 입력하세요">
                            <button type="button" class="btn-check" onclick="cate_dup()">중복체크</button>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="form-label">카테고리명 <span class="required">*</span></label>
                        <input name="cate_name" type="text" class="input-field input-name" placeholder="카테고리명을 입력하세요">
                    </div>

                    <div class="form-group">
                        <label class="form-label">카테고리 관리 <span class="required">*</span></label>
                        <div class="radio-group">
                            <div class="radio-item">
                                <input name="cate_use" type="radio" value="Y" class="radio-input">
                                <label class="radio-label">사용</label>
                            </div>
                            <div class="radio-item">
                                <input name="cate_use" type="radio" value="N" class="radio-input" checked>
                                <label class="radio-label">미사용</label>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="form-actions">
                    <button type="button" class="btn-submit" onclick="cate_ins()">카테고리 등록</button>
                    <a href="cate_list.html" class="btn-list">카테고리 목록</a>
                </div>
            </form>
        </div>
    </main>

    <footer>
        <%@ include file="/admin/footer.jsp"%>
    </footer>
</body>
    <script src="/admin/js/cate_insert.js"></script>
</html>
