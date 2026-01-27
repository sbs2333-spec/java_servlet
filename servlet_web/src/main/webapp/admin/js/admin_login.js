document.querySelector("#home_btn").addEventListener("click",function(){
	location.href='http://localhost:8080/';
});


export class login{		//class 선언문
	constructor(...data){	//즉시실행 함수
		this.mid = data[0];
		this.mpass = data[1];
	}
	login_check(){	//method
		if(this.mid == "" || this.mpass == ""){
			alert("관리자 아이디 및 패스워드를 입력하셔야 합니다.");
		}
		else {
			frm.submit();
		}
	}
}