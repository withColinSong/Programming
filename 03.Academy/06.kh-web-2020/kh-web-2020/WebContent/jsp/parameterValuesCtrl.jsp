<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ParameterValuesCtrl</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8"); // 요청 정보
	response.setContentType("text/html; charset=utf-8"); // 응답 정보
	
	if(request.getMethod().equals("GET")) {
 		String mid = request.getParameter("mid"); // input name='mid'
		String gender = request.getParameter("gender");
		
		String[] hobby = request.getParameterValues("hobby");
		String[] subject = request.getParameterValues("subject");
		String[] attFile = request.getParameterValues("attFile");
		
		out.println("<li>아이디" + mid);
		out.println("<li>성별" + gender);
		out.println("<li>취미" + Arrays.toString(hobby));
		out.println("<li>과목" + Arrays.toString(subject));
		out.println("<li>파일" + Arrays.toString(attFile));
		out.println("<hr>"); 
		
		out.print("<h3>getParameterNames()</h3>");
		
		
		Enumeration<String> e = request.getParameterNames();
		while(e.hasMoreElements()) {
			// hasMoreElements 시작은 BOF(Begin of File)
			// EOT(End of Tape), EOF(End of File)
			String str = e.nextElement();
			out.print("<li>"+str);
		}
		
		out.print("<h3>getParameterMap()</h3>");
		
		Map<String, String[]> map = null;
		map = request.getParameterMap();
		
		
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String key = it.next();
			String[] values = map.get(key);
			out.print("<li>" + key + " : " + Arrays.toString(values));
		}
		
		out.print("<hr/>");
	}

%>
</body>
</html>