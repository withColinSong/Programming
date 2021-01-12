<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id ="filter_test">
		<h3>Filter Test</h3>
		<form name="frm" method="POST" action="/kh-web-2020/filter.do">
		<label>답글 내용</label><br>
		<textarea rows="5" cols="50" name="doc">${doc }</textarea>
		<p/>
		<input type="submit" value="저장"/>
		</form>
		<hr/>
		<h3>저장 내용 출력</h3>
		<h4>request.getAttribute("doc") :  <%=request.getAttribute("doc") %></h4>
		<h4>EL표기법 : ${doc }</h4>
	</div>
</body>
</html>