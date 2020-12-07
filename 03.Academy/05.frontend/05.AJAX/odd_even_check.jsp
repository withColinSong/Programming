<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String temp = request.getParameter("su");
String msg = ""; // 결과 메세지	
int su = 0;
if(temp != null && !temp.equals("")) {
	su = Integer.parseInt(temp); // 문자열을 Int 변환. Wrapper class
	if(su % 2 == 0) {
		msg = su + " 는 짝수입니다.";				
	} else {
		msg = su + " 는 홀수입니다.";
	}
}
	out.print(msg);
%>