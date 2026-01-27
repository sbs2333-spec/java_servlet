<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//Controller에서 보낸 2차 클래스를 jsp에서 받음
   ArrayList<ArrayList<String>> ad = (ArrayList<ArrayList<String>>)request.getAttribute("addr");

%>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>저장된 주소록 페이지</title>
</head>
<body>
<table border="1" cellpadding="0" cellspacing="0">
<thead>
	<tr>
		<th>우편번호</th>
		<th>도로명주소</th>
		<th>상세주소</th>
	</tr>
</thead>
<tbody>
<%
	if(ad.size()==0){	//해당 배열값이 데이터가 없을 경우 출력되는 조건문
%>
	<tr>
		<td colspan="3">등록된 주소가 없습니다. </td>
	</tr>
<%
	} else {	//배열에 데이터가 있을 경우 반복문으로 출력함
		int w = 0;
		while(w < ad.size()){		
		
%>		

<!--  저장된 database의 값이 출력되는 공간 -->
	<tr>
		<td><%=ad.get(w).get(1)%></td>	<!--  배열에 그룹 및 배열 노드번호를 적용하여 데이터 출력 -->
		<td><%=ad.get(w).get(2)%></td>
		<td><%=ad.get(w).get(3)%></td>
	</tr>
<!--  저장된 database의 값이 출력되는 공간 -->
<%
	w++;
	}
}		
%>		
	
</tbody>	
</table>

</body>
</html>