<%@page import="bean.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<jsp:useBean id="dao" class="bean.MemberDao"/>
<jsp:useBean id="vo" class="bean.MemberVo"/>

<%-- vo객체가 가지고 있는 모든 setter를 사용하여 값을 대입 --%>
<jsp:setProperty property="*" name="vo"/>

<% 
	vo.setMid(request.getParameter("mid"));
	vo.setPwd(request.getParameter("pwd"));
	
	boolean b = dao.login(vo.getMid(), vo.getPwd());
	if(b) {
		session.setAttribute("mid", vo.getMid());
		response.sendRedirect("../index.jsp");
	} else {
		// 로그인 실패
		out.println("<script>");
		out.println("		alert('fail')");
		out.println("		location.href='../index.jsp'");
		out.println("</script>");
	}

%>