<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드 및 database에 저장</title>
</head>
<body>
<form id="frm" method="post" action="./cdn/fileok.do" enctype="multipart/form-data">
첨부파일 : <input type="file" name="f_img">
<button type="button" onclick="save_file()">저장</button>
</form>
</body>
<script>
function save_file(){
	if(frm.f_img.value==""){
		alert("등록할 파일을 첨부해 주세요!");
	}
	else{
		frm.submit();
	}
}
</script>

</html>