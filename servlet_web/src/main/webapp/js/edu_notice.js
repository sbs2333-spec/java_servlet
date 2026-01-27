function gopage(){
	if(frm.title.value == ""){
		alert("제목을 등록하세요");
		frm.title.focus();
	}
	else if(frm.writer.value == ""){
		alert("글쓴이를 등록하세요");
		frm.writer.focus();
	}
	else if(frm.contents.value == ""){
		alert("내용을 등록하세요");
		frm.contents.focus();
	}
	else if(frm.cat.value == ""){
		alert("카테고리를 등록하세요");
		frm.cat.focus();
	} else {
		if (confirm("등록하시겠습니까?")){
			delfrm.eidx.value = eidx;
			delfrm.method = "post";
			delfrm.action = "./pg_elist.do";
			delfrm.submit();
		}
	}	 	
}
