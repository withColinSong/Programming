<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String temp = request.getParameter("dan");
	List<String> list = new ArrayList<String>();
	
	if(temp != null && !temp.equals("")) {
		int dan = Integer.parseInt(temp);
		
		for(int i = 1; i < 10; i++) {
			String str = dan + "+" + i + "=" + (dan*i) + " ";
			out.print(str);
			// 웹은 \n 일반적인 부분을 인식하지 못한다.
		}
	}

%>