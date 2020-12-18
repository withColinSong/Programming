<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View</title>
</head>
<body>
<div id="member">
	<h2>회원관리</h2>
	<form name="frm_member" method="post">
		<div>
		<label>아이디</label>
		<input type="text" name="mid"/>
		</div>
		
		<div>
		<label>성명</label>
		<input type="text" name="name"/>
		</div>

		<div>
		<label>이메일</label>
		<input type="email" name="email" size="50"/>
		</div>
		
		<div>
		<label>연락처</label>
		<input type="text" name="phone" size="30"/>
		</div>
		
		<div>
		<label>우편번호</label>
		<input type="text" name="zipcode" size="6"/>
		</div>
		
		<div>
		<label>주소</label>
		<input type="text" name="address" size="80"/>
		</div>
		
		<div>
		<label>사진</label>
		<input type="file" name="photo"/>
		<img src="http://placehold.it/150x200"/>
		</div>
		
		<hr/>
		
		<div class="btns">
			<input type="button" value="수정" id="btnModify"/>
			<input type="button" value="삭제" id="btnDelete"/>
			<input type="button" value="목록" id="btnSelect"/>
		</div>
		
	</form>
</div>
</body>
</html>