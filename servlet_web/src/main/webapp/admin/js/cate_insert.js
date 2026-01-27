function cate_dup(){
	if(frm.cate_code.value==""){
		alert("카테고리 코드를 입력하세요");
		return false;
	}
	else {
		frm.method="post";
		frm.action="./admin/cate_dupcheck.do";
		frm.submit();
	}
 }
 
 
function cate_ins(){
	if(frm.cate_code.value==""){
		alert("카테고리 코드를 입력하세요");
		return false;
	}
	else if(frm.cate_name.value==""){
		alert("카테고리명을 입력하세요");
		return false;
	}
	else {
		frm.method="post";
		frm.action="./admin/cate_insert.do";
		frm.submit();
	}
 }
 
 