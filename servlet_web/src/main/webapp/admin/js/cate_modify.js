function modify_check(){
	if(frm.cate_name.value==""){
		alert("카테고리명을 입력하셔야 수정이 가능합니다.");
		return false;
	}
	else {
		frm.method="post";
		frm.action="./cate_modifyok.do";
		frm.submit();
	}
 }
 