 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리(insert)</title>
<link rel='stylesheet' type='text/css' href='./css/member.css'>
<script src="./js/member.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
</head>
<body>
<div id='member'>
	<h2>회원관리</h2>
	<form name='frm_member' method='post' class='update'>
		<label>아이디</label>
		<input type='text' name='mid' size='10' readOnly required/><br/>
		
		<label>성명</label>
		<input type='text' name='name' size='12' required/><br/>
		
		
		<label>이메일</label>
		<input type='email' name='email' size='35' /><br/>
		
		<label>연락처</label>
		<input type='text' name='phone' size='15' /><br/>
		
		<label>우편번호</label>
		<input type='button' name='btnZipcode' id="btnFindZip" value="우편번호검색">
		<input type='text' name='zipcode' size='6'  required/><br/>
		
		
		<label>주소</label>
		<input type='text' name='address' size='60'  required /> <br/>
		
		<label>사진</label>
		<input type='file' name='photo' id='btnPhoto' /><br/>
		<label></label>
		<img src='http://placehold.it/200x140' id='photo' width="200px" height="140px"/>
		<hr/>

		<input type='hidden' name='pwd' /><br/>
		
		<div class='btns'>
			<input type='button' value='수정' id='btnUpdate' />
			<input type='button' value='목록으로' id='btnSelect' />
			
			<input type='text' name='findStr' value='${param.findStr }' />
			<input type='text' name='nowPage' value='${param.nowPage }' />
		</div>
	</form>

</div>
<script>member()</script>
</body>
</html>