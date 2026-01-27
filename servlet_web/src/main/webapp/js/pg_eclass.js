function class_reg(){
	var ea = document.getElementsByName("subject").length;
	var ck = false;
	var f;
	for(f=0; f<ea; f++){
		if(document.getElementsByName("subject")[f].checked == true){
			ck = true;
			break;
		}
	}
	
	if(ck == false){
		alert("수강할 과목을 선택해주세요.");
	}
	else{
		if(confirm("해당 과목을 신청하시겠습니까?")){
			frm.method = "post";
			frm.action = "./cms/pg_eclassok.do";
			frm.submit();
		}
	}
	
}