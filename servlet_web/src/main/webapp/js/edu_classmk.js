document.querySelector("#class_maker").addEventListener("click",function(){
	if(frm.subject_nm.value==""){
		alert("과목명을 입력하셔야 합니다.");
		frm.subject_nm.focus();
	}
	else if(frm.teacher_nm.value==""){
		alert("강사명을 입력하셔야 합니다.");
		frm.teacher_nm.focus();
	}
	else if(frm.class_time.value=="0"){
		alert("총 수업시간을 입력하셔야 합니다.");
		frm.class_time.value = 0;
	}
	else if(frm.cate_code.value==""){
		alert("과목 카테고리를 선택해 주세요");
	}
	else if(frm.start_day.value=="" || frm.end_day.value==""){
		alert("시작일자 및 종료일자를 선택해 주세요");
	}
	else if(frm.max_no.value == ""){
		alert("최대 수강인원을 입력하세요");
		frm.max_no.value = 1;
	}
	else if(frm.class_use.value == ""){
		alert("과목 상태를 선택해 주세요");
	}
	else{
		if(frm.start_day.value > frm.end_day.value){
			alert("시작일자 및 종료일자를 올바르게 설정 하세요");
		}
		else{
			frm.method = "post";
			frm.action = "/cms/edu_classmkok.jsp";
			frm.submit();
		}
	}
});