
function gopage(){
    if(frm.checkin_date.value == ""){
        alert("입실일자를 선택해야 합니다.");
    }
    else if(frm.checkout_date.value ==""){
        alert("퇴실일자를 입력해야 합니다.");
    }
    else if(frm.room_name.value ==""){
        alert("객실명을 입력해야 합니다.");
    }
    else if(frm.adult_count.value =="0" && frm.child_count.value =="0" && frm.infant_count.value =="0"){
        alert("인원수를 입력해야 합니다.");
    }
    else {
//       frm.method = "POST";
  //      frm.action = "./contact_us_ok.do";
        frm.submit();
    }
}/**
 * 
 */