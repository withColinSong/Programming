<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	

	String cnt_ = request.getParameter("cnt");

	int cnt = 50;
	
	if (cnt_ != null && !cnt_.equals("")) {
		cnt = Integer.parseInt(cnt_);
	}

	

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	안녕
	
	<% for(int i = 0; i<cnt; i++) { %>
	
		안녕 Servlet<br>
	
	<% } %>
	
	
	
</body>
</html>