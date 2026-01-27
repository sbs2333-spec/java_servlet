/* jquery를 실행 시키는 함수 */
$(document).ready(function(){
    $("#btn").postcodifyPopUp();
    $.fn.aaa = function(){  /* jquery 표현식 일반함수 */
        //console.log("test");
        //$(document).postcodifyPopUp();
    }
});

//javascript onclick 이벤트 함수
function addr_api(){
   //$.fn.aaa(); //jquery 함수를 javascript에서 실행
}

function new_addr(){
    if(frm.partner_type.value == ""){
        alert("제휴구분을 선택해야 합니다.");
    }
    else if(frm.com_name.value ==""){
        alert("회사명을 입력해야 합니다.");
    }
    else if(frm.manager_name.value ==""){
        alert("담당자명을 입력해야 합니다.");
    }
    else if(frm.manager_email.value ==""){
        alert("담당자 이메일 주소를 입력해야 합니다.");
    }
    else if(frm.manager_tel.value ==""){
        alert("담당자 휴대폰 번호를 입력해야 합니다.");
    }
    else if(frm.contact_message.value ==""){
        alert("제휴문의 내용을 입력해야 합니다.");
    }
    else {
//       frm.method = "POST";
  //      frm.action = "./contact_us_ok.do";
        frm.submit();
    }
}