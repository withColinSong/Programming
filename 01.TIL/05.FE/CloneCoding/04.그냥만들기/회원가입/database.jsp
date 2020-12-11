<%@page import="db.Database"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="user.User" %>

<% 
	String userId = request.getParameter("userid");
	String password = request.getParameter("password");
	String name = request.getParameter("name");
	String email = request.getParameter("email");

	User user = new User(userId, password, name, email);
	Database.addUser(user);
	
	// 로그인 시 이동하는 페이지
	response.sendRedirect("./login.jsp");
	
%>