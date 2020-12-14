<%@page import="bean.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	/* response.setContentType("text/html; charset=utf-8"); */
	String mid = request.getParameter("mid"); // 파라미터 : name값 / value를 가져옴.
	String pwd = request.getParameter("pwd");

	// database에 존재 유무
	
/* 	session.setAttribute("mid", mid); //"mid": 속성명, mid:속성값
	response.sendRedirect("../index.jsp"); */
	
	MemberDao dao = new MemberDao();
	boolean b = dao.login(mid, pwd);
	if(b) {
		session.setAttribute("mid", mid);
		response.sendRedirect("../index.jsp");
	} else {
		// 로그인 실패
		out.println("<script>");
		out.println("		alert('fail')");
		out.println("		location.href='../index.jsp'");
		out.println("</script>");
	}

%>