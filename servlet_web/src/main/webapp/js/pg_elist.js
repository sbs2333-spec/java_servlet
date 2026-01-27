function gopage(pno){
	location.href='./pg_elist.do?pno='+pno;
}


function cancel_edu(eidx){
	if(confirm("수강취소를 할 경우 해당 수강내역은 복구 되지 않습니다. 진행 하시겠습니까?")){
		delfrm.eidx.value = eidx;
		delfrm.method = "post";
		delfrm.action = "./pg_elist.do";
		delfrm.submit();
	}
}

//검색 부분
function search_ck(){
	
	if(sfrm.search.value == ""){
		alert("과목명을 입력하셔야 합니다.");
		sfrm.search.focus();
		return false;
	}
	else{
		return;
	}
	
}