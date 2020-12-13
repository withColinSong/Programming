<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String temp = request.getParameter("dan");
	List<String> list = new ArrayList<>();
	
	if(temp != null && !temp.equals("")) {
		int dan = Integer.parseInt(temp);
		
		for(int i = 1; i < 10; i++) {
			list.add("'" + dan + "+" + i + "=" + (dan*i) + " "+"'");
			
			// 웹은 \n 일반적인 부분을 인식하지 못한다.
		}
		String str = Arrays.toString(list.toArray());
		str = str.replaceAll("'", "\"");
		out.print(str);
	}

%>