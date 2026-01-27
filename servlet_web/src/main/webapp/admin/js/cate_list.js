function cate_modify(code){
	location.href='./cate_modify.do?code='+code;
}

function cate_delete(code){
	if(confirm("해당 카테고리를 삭제시 데이터는 복구 되지 않습니다.")){
		ajax(code);
	}
}

//ajax로 Controller에 통신을 진행함
function ajax(code){
	var http,result;
	http = new XMLHttpRequest();
	http.onreadystatechange = function(){
		if(http.readyState == 4 && http.status == 200){
			result = this.response;
			if(result == "ok"){
				alert("해당 카테고리가 정상적으로 삭제 되었습니다.");
				window.location.reload();
			}
			else{
				alert("시스템 장애로 해당 카테고리가 삭제 되지 않습니다.");
			}
		}
	}
	http.open("get","./cate_api.do?code="+code,true);
	http.send();
}

