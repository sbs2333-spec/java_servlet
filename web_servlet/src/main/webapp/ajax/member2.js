//동기화 통신으로 적용된 스크립트
function gopage() { //회원가입시 적용되는 함수
	if(frm.userid.value == ""){
		alert("아이디를 입력하세요");
		return false;		
	}
	else if(frm.userpw.value == ""){
		alert("패스워드를 입력하세요");
		return false;				
	}
	else if(frm.companynm.value == ""){
		alert("회사명을 입력하세요");
		return false;
	}
	else if (frm.ceonm.value == ""){
		alert("대표자명을 입력하세요");
		return false;		
	}
	else if (frm.corpno.value == ""){
		alert("사업자 번호를 입력하세요");
		return false;		
	}
	else {
		if(frm.userid.readOnly == false){
			alert("아이디 중복체크를 하셔야만 회원가입이 진행됩니다.");
			return false;
		}
		else {
			return true;
		}
		
		
	}
}

function ajax_data() {	//아이디 중복체크
	if(frm.userid.value == ""){
		alert("아이디를 입력해주세요");
		frm.userid.focus();
	}
	else{		
		//동기화 통신
		var check = ajax_get(frm.userid.value, "1");
		if(check=="ok"){
			alert("사용 가능한 아이디입니다.")
			frm.userid.readOnly=true;	//이 줄을 안 넣으면 무조건  사고 터진다.
		}
		else{
			alert("해당 아이디는 사용할 수 없습니다.")
			frm.userid.value = "";
		}		
	}
}

function ajax_data2() {	//사업자 번호 중복체크
	if(frm.corpno.value==""){
		alert("사업자 번호를 입력해 주세요");
		frm.corpno.focus();
	}
	else{
		var check = ajax_get(frm.corpno.value, "2");
	}
}

//백엔드와 get 통신
/*
  readystate : 숫자를 적용
  0 (UNSENT) : 객체 생성 → XMLHttpRequest.UNSENT 와 같음.
  1 (OPENED): open(GET, POST, PUT, ... 정상적으로 실행)
  2 (HEADERS_RECEIVED): 서버쪽에서 응답 결과만 체크
  3 (LOADING): 요청에 대한 처리 결과 (데이터 처리하고 있는 상황을 확인할 때)
  4 (DONE): 요청된 데이터를 보낸 후 결과에 대한 값을 return 받을 때.. → done과 같음	
*/
function ajax_get(infodata, part) {
	var pm = ""; //GET 전송에 대한 값을 어떻게 전송할 것인지 적용하는 변수
	if(part == "1"){ //아이디
		pm = "?data="+infodata+"&part="+part;
	}
	else if(part == "2"){ //사업자번호
		pm = "?data="+infodata+"&part="+part;		
	}
	
	
	var data;	//결과값을 받는 변수 및 return 형태
	var ajaxs = new XMLHttpRequest();
	ajaxs.onreadystatechange = function () {
		if(ajaxs.readyState == 4 && ajaxs.status==200){
			data = this.response;	//백엔드에서 처리된 결과값을 받아서 변수에 이관
		}
	}
	
	//동기화를 사용한 이유는 백엔드에 데이터 전송 후 return 결과를 받기 전에 Javascript가 먼저 return을 시켜버림.
	//결과값이 없다는 undefined가 무조건 출력될 수 밖에 없음 → 왜냐? 통신 전송에는 딜레이가 발생함
	ajaxs.open("GET", "../web_ajax/usercheck.jsp"+pm, false);	//do말고 jsp로 web.xml에 적은 경우 이렇게 해도 됨. → var data = 100 인 경우, return을 받으려면 동기화를 사용해야 함, 즉 false를 사용해야 한다. 
	ajaxs.send();
	
	return data;
	

}

