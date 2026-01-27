//동기화 통신으로 적용된 스크립트
function gopage() { 
	if(frm.title.value == ""){
		alert("제목을 입력하세요");
		return false;		
	}
	else if(frm.writer.value == ""){
		alert("글쓴이를 입력하세요");
		return false;				
	}
	else if(frm.content.value == ""){
		alert("내용을 입력하세요");
		return false;
	}
	else {
		alert("공지사항이 올바르게 등록되었습니다.");
		return true;
	}
		
}

