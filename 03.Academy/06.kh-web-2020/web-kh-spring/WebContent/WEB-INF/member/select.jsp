<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원조회</title>
<link rel="stylesheet" type="text/css" href="./css/select.css"/>
<script src="./js/member.js"></script>
</head>
<body>
	<div class="container">
		<form name="frm_member" id="frmMember" method="post" action="insertR.member">
			<h1>회원관리</h1>
			
			<div class="nav">
				<input type="button" id="btnInsert" value="입력"/>
				<input type="search" name="findStr" value="${param.findStr }"/>
				<input type="button" value="조회" id="btnFind"/>
				<input type="text" name="nowPage" value="${(empty nowPage) ? 1: nowPage }"/>
				<input type="text" name="mid"/>
			</div>
		</form>
		
		<hr class="hr_align"/>
		
	
		<div class="content">
		<c:forEach var="v" items="${list }">
			<div class="content_one" onclick="view(${v.mid})">
				<div class="content_align">
					<img src="http://placehold.it/100x100"/>
				</div>
				<ul class="content_list">
					<li>${v.mid }</li>
					<li>${v.name }</li>
					<li>${v.phone }</li>
					<li>${v.email }</li>
				</ul>
			</div>
		</c:forEach>
		</div>
	
		
		<div id="btnZone">
			<c:if test="${page.startPage > 1 }">
				<input type="button" value="맨첨" id="btnFirst" onclick="goPage(1)"/>
				<input type="button" value="이전" id="btnPrev" onclick="goPage(${page.startPage-1})"/>
			</c:if>
			
			<c:forEach var="i" begin="${page.startPage }" end="${page.endPage }">
			<input type="button" value="${i }" onclick="goPage(${i})"/>
			</c:forEach>
			
			<c:if test="${page.endPage < page.totPage }">
			<input type="button" value="다음" id="btnNext" onclick="goPage(${page.endPage+1})"/>
			<input type="button" value="맨끝" id="btnLast" onclick="goPage(${page.totPage})"/>
			</c:if>
		</div>
		
	</div>
	<script>member();</script>
</body>
</html>