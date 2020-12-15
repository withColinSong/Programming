<%@page import="guestbook.GuestBookVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Select</title>
<link rel=stylesheet type="text/css" href="./css/gestbook.css">
<script src="./js/guestbook.js"></script>
</head>
<jsp:useBean id ="dao" class="guestbook.GuestBookDao"/>
<body>
 	
	<div id="guestbook">
		<h2>방명록</h2>
	</div>
	
	<form name="frm_gb" id="frm_gb" method="post">
		<input type="search" name="findStr" size="30" placeholder="작성자나 내용으로 검색"
		value= '${param.findStr}'>
		<input type="submit" value="검색" id="btnFind">
	</form>
	<% for (int i = 0;  i<10; i++ )  { %>
	<%
		String findStr = "";
		if(request.getParameter("findStr") != null) {
			findStr = request.getParameter("findStr");
			
		};
		
		List<GuestBookVo> list = dao.select(findStr);
		request.setAttribute("list", list);
		
	%>
	
	<div id="list">
		<c:forEach var='vo' items='${list }'>
		
		<div id="item">
			
			<label>작성자</label>
			<output class="mid">${vo.mid }</output>
			<label>작성일자</label>
			<output class="mdate">${vo.mdate }</output>
			
			<div>
			<textarea rows="5" cols="80"></textarea>
			</div>
			
			<div class="btns">
				<input type="button" value="수정" id="btnUpdate">
				<input type="button" value="삭제" id="btnDelete">
			</div>
		</div>
		</c:forEach>
	</div>
	<% } %>
	
	<%-- 
	<% for(GuestBookVo vo : list) { %>
		<div id="item">
			
			<label>작성자</label>
			<output class="mid">${vo.mid }</output>
			<label>작성일자</label>
			<output class="mdate">${vo.mdate }</output>
			
			<div>
			<textarea rows="5" cols="80"></textarea>
			</div>
			
			<div class="btns">
				<input type="button" value="수정" id="btnUpdate">
				<input type="button" value="삭제" id="btnDelete">
			</div>
		</div>

	<% } %>
	--%>
</body>
</html>