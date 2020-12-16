<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kr">
<head>
<meta charset="UTF-8">
<title>네비게이션</title>
<style>
.navi>li{
	background-color: black;
	list-style-type: none;
	width: 150px;
	height: 50px;
	text-align: center;

	/* 방법 1 --------------*/
	float:left;
	
	/* 방법 2 -------------
	display: inline-block;
	margin-right:-6px;
	vertical-align: top;
	*/
}

.navi>li>a{
	color: white;
	text-decoration: none;
	line-height: 50px;
	width: 100%;
	height: 100%;
}

.navi>li:hover{
	font-size: 1.2em;
	font-weight: bold;
	cursor: pointer;
}

</style>
	<script src="https://code.jquery.com/jquery-3.5.1.js" 
	        integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" 
	        crossorigin="anonymous"></script>
</head>

<body>
<form>
	<label for='userId'>ID</label>
	<input type='text' id='userId' pattern="^[A-Z][a-z]{3,6}">
	<input type='submit' value='chk' id='btn'>
<div id="genderbox">
    <label>성별 </label>
    <label>남 </label>
    <input type="radio" name="gender" value="male" required
    oninvalid="this.setCustomValidity('성별을 선택하세요.')"
    />
    <label class ="space">여 </label>
    <input type="radio" name="gender" value="female" />
</div>​
</form>
<script>

</script>
</body>

</html>