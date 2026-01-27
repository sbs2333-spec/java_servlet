<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%
	//trimDirectiveWhitespaces : false → 자바코드를 입력된 사항을 공백처리, true → 자바 코드 공백모두 삭제
	//위는 ajax 사용할때만 사용함. 유일하게..
	String msg = (String)request.getAttribute("msg");
%>
<%=msg%>