<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>scope</title>
</head>
<body>
<div id='scope'>
	<h3>application | session | request | pageContext</h3>
	<%
		String msg = "Message";
		application.setAttribute("msg", msg);
		session.setAttribute("msg", msg);
		request.setAttribute("msg", msg);
		pageContext.setAttribute("msg", msg);
		
		//session영역의 유지 시간 설정(5초)
		session.setMaxInactiveInterval(5);
	%>
	
	<a href='scope_check.jsp'>scope message check</a>
	<form method='post' action='scope_check_relay.jsp'>
		<input type='submit'/>
	
	</form>
	

</div>
</body>
</html>