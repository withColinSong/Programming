<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginfo</title>
<script src="./js/login.js"></script>
</head>
<body>
	<%--로그인 이전 화면 --%>
	<div id="Loginfo">
		<%	
			//session.setAttribute("mid", "송");
			//session.setAttribute("mid", "song");
			if(session.getAttribute("mid") == null) {
		%>
		<form name="frm_log" method="POST" id="frm_log">
			<label for="mid" >아이디</label>
			<input type="text" id="mid" name="mid" size="20" placeholder="아이디를 입력해주세요." pattern='[A-za-z0-9]{8,20}$'>
			<br>
			<label for="pwd">비밀번호 </label>
			<input type="password" id="pwd" name="pwd" size="20" value="1111">
			<div>
			<input type="button" id="btnLogin" value="로그인"/>
			</div>
		</form>
		<div>
			<a href="">아이디|비밀번호 찾기</a> 
		</div>
		<% } else { %>
		<%--로그인 이후 화면 --%>
		<span>[<%=session.getAttribute("mid") %>]님 어서오세요.</span>
		<div>
		<input type="button" id="btnLogout" value="로그아웃">
		</div>
		
		<% } %>
	</div>
	<script>
		logInOut();
	</script>
</body>
</html>