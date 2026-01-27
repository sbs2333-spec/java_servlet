<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String list[] = (String[])request.getAttribute("user");

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>함께 할 조별 결과</title>
</head>
<body>
<fieldset>	<!--  백엔드가 직접 자바 코드를 이용하여 출력한 상황 -->
	<legend>A조 - 멤버</legend>
	<%
	int w = 0;
	while(w < list.length){
	%>
	<label><%=list[w]%></label><br>		
	<%
	w++;
	}	
	%>	

</fieldset>
<br><br>
<!--  프런트 엔드가 직접 백엔드의 변수를 활용하여 Javascript 출력하는 방식 → 좋은 점은 크롤링이 안됨. -->
<fieldset>
	<legend>A조 - 멤버</legend>
	<div id="views">
	
	</div>

</fieldset>
</body>
<script>
var ori_data = "<%=list%>";
console.log(ori_data);
var data = [
	<%
	int ww = 0;
	while(ww < list.length){
	%>
		"<%=list[ww]%>"<%=","%>
	<%
		ww++;
	}
	%>	
];
var node = document.getElementById("views");
var f;
for(f=0; f<data.length; f++){
	var html = document.createElement("p");
	var text = document.createTextNode(data[f]);
	html.append(text);
	node.append(html);
}

//console.log(data);


</script>


</html>