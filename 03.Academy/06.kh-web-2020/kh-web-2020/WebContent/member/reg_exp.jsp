<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
<script>
	function msg(reg, str) {
		var temp = '<li><b>' + reg + '</b> : ' + str + '---->' + reg.test(str) + '</li>';
		return temp;	
	
	}
	
	try {
		var str = '123';
		var str2 = 'abc123';
		var str3 = 'abc';
		var str4 = '!@#$';
		var str5 ='가나다';
		var str6 = '!@#$가나다1234';
		
		// ^ 시작
		// $ 끝
		
		// 숫자만
		reg = /^[0-9]+$/;
		document.write(msg(reg, str1));
		document.write(msg(reg, str2));
		document.write(msg(reg, str3));
		document.write(msg(reg, str4));
		document.write(msg(reg, str5));
		document.write(msg(reg, str6));
		
		
	}catch(err) {
		alert(err);
	}
</script>
</html>