function gopage(){
	if(frm.partner_type==""){
		alert("제휴 구분을 선택하세요");
		frm.partner_type.focus();
	}
	else {
		frm.method="post";
	 	frm.action="./contact_us_ok.do";
	 	frm.submit();
 	}
} 