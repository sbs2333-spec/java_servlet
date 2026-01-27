function eventinfo() {
    var cnm = document.getElementById("cnm");
    var ctel = document.getElementById("ctel");
    var cemail = document.getElementById("cemail");
    var cpw = document.getElementById("cpw");
    var caw = document.getElementById("caw");
    if (cnm.value == ""){
        alert("고객명을 입력하세요")
    }
    else if (ctel.value == ""){
        alert("연락처를 입력하세요")
    }
    else if (cemail.value == ""){
        alert("이메일을 입력하세요")
    }
    else if (cpw.value == ""){
        alert("비번을 입력하세요")
    }
    else if (caw.value == ""){
        alert("캐릭터명을 입력하세요")
    }
    else { //해당 모든 조건을 다 입력 후 추가 확인 작업을 함.
        if(cpw.value.length < 6) {
            alert("패스워드는 최소 6자 이상 입력하셔야 합니다.")
        }
        //개인정보 수집 동의 3가지 체크 유/무를 모두 확인하는 사항
        var f ;
        var sign = "no" ;
        for(f=0; f<3 ; f++) {
            var ck = document.getElementById("agree" + f).checked;
            if (ck == false){
                alert("개인정보 수집동의는 모두 체크하셔야 합니다") ;
                sign = "yes" ;
                break ;
            }
        }
        if (sign == "no") {
			frm.submit();
        }
    }
}









