<?xml version='1.0' encoding='UTF-8' ?> 
<%@page import="bean.EmpVo"%>
<%@page import="java.util.List"%>
<%@page import="bean.EmpDao"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
// 1. xml 구문 추가, contentType=text/xml;로 변경
// xml은 주석도 달지 않는다. 스크립트 영역에서 주석을 작성한다.
	String findStr = request.getParameter("findStr"); // ex-> ?findStr=ab 이 때 ab의 값을 나타내는 구문.
	EmpDao dao = new EmpDao();
	List<EmpVo> list = dao.search(findStr);
	
// <h2>태그 오류</h2> -> 루트가 2개가 될 순 없다.  %>
<emps> <% // root element = root rode %>
	<% for(EmpVo vo : list) { %>
	<emp>
		<id><%=vo.getEmployee_id()%></id> <% // 카멜방법으로 사용할 것.%>
		<name><%=vo.getFirst_name()%></name>
		<email><%=vo.getEmail()%></email>
		<phone><%=vo.getPhone_number()%></phone>
		<salary><%=vo.getSalary()%></salary>
	</emp>
	<% } %>
</emps>
