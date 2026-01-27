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
    if(frm.mpost.value == ""){
        alert("우편번호 및 주소를 검색해서 입력하세요!");
    }
    else if(frm.maddr2.value ==""){
        alert("상세주소를 입력하셔야 합니다.");
        frm.postaddr2.focus();
    }
    else {
        frm.method = "POST";
        frm.action = "./addrok.do";
        frm.submit();
    }
}