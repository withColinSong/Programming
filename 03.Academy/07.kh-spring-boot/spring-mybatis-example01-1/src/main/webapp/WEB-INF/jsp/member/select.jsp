<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>select</title>
</head>
<body>
	<h3>검색하기</h3>
	<form action="select" name="frmSearch" method="POST">
	<input type="text" name="findStr" value="${param.findStr }">
	<input type="submit" value="sumbit">
	</form>
	
	<h3>result</h3>
	<div id="resultFrm">
		<c:forEach items="${list }" var="vo" varStatus="i">
			<span>${vo.mid }</span>
			<span>${vo.name }</span>
			<span>${vo.phone }</span>
			<span>${vo.email }</span>
		</c:forEach>
	</div>
	
	<div id="test">
		<h1>테스트</h1>
		${list }
	</div>
	
</body>
</html>