<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String userId = request.getParameter("userid");
	String password = request.getParameter("password");
	String name = request.getParameter("name");
	String email = request.getParameter("email");

	out.println(userId + " : " + password + " : " + name + " : " + email);
%>