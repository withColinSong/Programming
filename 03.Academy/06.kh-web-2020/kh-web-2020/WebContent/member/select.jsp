<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리조회(select)</title>
<link rel="stylesheet" href="./css/member.css" type="text/css"/>
</head>
<body>
<div id="member">
	<h3>회원관리</h3>
	<form name="frm_member" method="post" id="frm_member">
		<input type="button" value="입력" id="btnInsert">
		<div>
			<input type="text" name="findStr" class="findStr">
			<input type="button" value="검색" id="btnFind"> 
		</div>
	</form>
	
	<div class="title">
		<span class="no">NO</span>
		<span class="mid">아이디</span>
		<span class="name">성명</span>
		<span class="email">이메일</span>
		<span class="mdate">가입일</span>		
	</div>
	
	<div class="items">
		<div class="item">
		<span class="no">1</span>
		<span class="mid">song</span>
		<span class="name">오</span>
		<span class="email">song@daum.net</span>
		<span class="mdate">2020-01-01</span>		
		</div>
	</div>
	
	<div class="items">
		<div class="item">
		<span class="no">2</span>
		<span class="mid">song</span>
		<span class="name">최</span>
		<span class="email">song@gmail.com</span>
		<span class="mdate">2020-06-21</span>		
		</div>
	</div>
	
	<div class="items">
		<div class="item">
		<span class="no">3</span>
		<span class="mid">song</span>
		<span class="name">송</span>
		<span class="email">song@naver.com</span>
		<span class="mdate">2020-01-01</span>		
		</div>
	</div>
	
	<div class="paging">
		<input type="button" value="start" id="btnFirst">
		<input type="button" value="이전" id="btnPrev">
		
		<input type="button" value="1" />
		<input type="button" value="2" />
		<input type="button" value="3" />
		<input type="button" value="4" />
		<input type="button" value="5" />

		<input type="button" value="다음" id="btnNext">
		<input type="button" value="맨끝" id="btnLast">

	</div>
</div>
</body>
</html>