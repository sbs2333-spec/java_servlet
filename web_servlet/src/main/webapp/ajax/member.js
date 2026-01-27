//비동기 통신으로 적용된 스크립트
function gopage() { //회원가입시 적용되는 함수
	return false;
}

var check;	//비동기화 통신으로 인하여 전역변수로 뺌 → print_result() 함수에 사용하기 위해서

function ajax_data() {	//아이디 중복체크
	if(frm.userid.value == ""){
		alert("아이디를 입력해주세요");
		frm.userid.focus();
	}
	else{		
		//비동기화 통신
		ajax_get(frm.userid.value, "3");
		
		//백엔드에서 결과값을 가져올 때 딜레이 상황이 발생하므로 시간 함수를 이용하여 적용함
		setTimeout(()=>{	
			console.log(this.check);		
		}, 2500);			
		
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
			data = this.response;
			print_result(data);					
		}
	}
	
	//동기화를 사용한 이유는 백엔드에 데이터 전송 후 return 결과를 받기 전에 Javascript가 먼저 return을 시켜버림.
	//결과값이 없다는 undefined가 무조건 출력될 수 밖에 없음 → 왜냐? 통신 전송에는 딜레이가 발생함
	ajaxs.open("GET", "../web_ajax/usercheck.jsp"+pm, true);	//do말고 jsp로 web.xml에 적은 경우 이렇게 해도 됨. → var data = 100 인 경우, return을 받으려면 동기화를 사용해야 함, 즉 false를 사용해야 한다. 
	//위처럼 동기화 통신을 사용하는 이유 → 딜레이 상황이 발생. 바로 아래에 return을 해야 하는 경우.. 타이밍 문제가 있음.
	ajaxs.send();
	
	function print_result(data){
		this.check = data;	//전역변수 값을 이관
	}	
	
	/*
	//아래로 해도 안 됨. 참고로 걍 냅둔다. 25-12-30 12:21
	setTimeout(()=>{	//화살표 함수는 즉시 실행됨. 화살표 함수를 이용해서 실행한다.
		return data;
	}, 2000);	
	*/
}

