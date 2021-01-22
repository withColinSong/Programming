<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원조회</title>
<link rel="stylesheet" type="text/css" href="./css/select.css"/>
</head>
<body>
	<div class="container">
		<form name="frmMember" id="frmMember" method="post" action="insertR.member">
			<h1>회원관리</h1>
			
			<div class="nav">
				<input type="button" value="입력"/>
				<input type="text"/>
				<input type="button" value="조회"/>
			</div>
		</form>
		
		<hr class="hr_align"/>
		
		<div class="content">
			<div class="content_one">
				<div class="content_align">
					<img src="http://placehold.it/100x100"/>
				</div>
				<ul class="content_list">
					<li>아이디</li>
					<li>성명</li>
					<li>연락처</li>
					<li>이메일</li>
				</ul>
			</div>
			
			<div class="content_one">
				<div class="content_align">
					<img src="http://placehold.it/100x100"/>
				</div>
				<ul class="content_list">
					<li>아이디</li>
					<li>성명</li>
					<li>연락처</li>
					<li>이메일</li>
				</ul>
			</div>
			
			<div class="content_one">
				<div class="content_align">
					<img src="http://placehold.it/100x100"/>
				</div>
				<ul class="content_list">
					<li>아이디</li>
					<li>성명</li>
					<li>연락처</li>
					<li>이메일</li>
				</ul>
			</div>
			
		</div>
		
		<div id="btnZone">
			<input type="button" value="맨첨" id="btnFirst"/>
			<input type="button" value="이전" id="btnPrev"/>
			
			<input type="button" value="1" />
			<input type="button" value="2" />
			<input type="button" value="3" />
			<input type="button" value="4" />
			<input type="button" value="5" />
			
			<input type="button" value="다음" id="btnFirst"/>
			<input type="button" value="맨끝" id="btnPrev"/>
		</div>
		
	</div>
</body>
</html>