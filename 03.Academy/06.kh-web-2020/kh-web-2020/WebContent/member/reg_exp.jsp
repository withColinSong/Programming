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
		var str1 = '123';
		var str2 = 'abc123';
		var str3 = 'abc';
		var str4 = '!@#$';
		var str5 ='가나다';
		var str6 = '!@#$가나다1234';
		var str7 = '@sdf1234';
		
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
		document.write(msg(reg, str7));
		document.write("<hr/>");
		
		// 영문자
		reg = /^[a-zA-Z]+$/;
		document.write(msg(reg, str1));
		document.write(msg(reg, str2));
		document.write(msg(reg, str3));
		document.write(msg(reg, str4));
		document.write(msg(reg, str5));
		document.write(msg(reg, str6));
		document.write(msg(reg, str7));
		document.write("<hr/>");
		
		// 첫글자는 무조건 대문자이고 영숫자(\w:영숫자)
		reg = /^[A-Z][a-zA-Z0-9]+$/
		document.write(msg(reg, str1));
		document.write(msg(reg, str2));
		document.write(msg(reg, str3));
		document.write(msg(reg, str4));
		document.write(msg(reg, str5));
		document.write(msg(reg, str6));
		document.write(msg(reg, str7));
		document.write("<hr/>");
		
		// 한글만 입력
		reg = /^[가-힣]+$/
		document.write(msg(reg, str1));
		document.write(msg(reg, str2));
		document.write(msg(reg, str3));
		document.write(msg(reg, str4));
		document.write(msg(reg, str5));
		document.write(msg(reg, str6));
		document.write(msg(reg, str7));
		document.write("<hr/>");
		
		//연락처 \d
		var str1 = '02-123'; // x
		var str2 = '02-123-1234'// o
		var str3 = '031-12-1111'// x
		var str4 = '031-1234-123' // x
		var str5 = '031-1234-1234' // o
		var str6 = '017-123-1234' // o
		var str7 = '010-1234-234' // x
		
		reg = /\d{2,3}-\d{3,4}-\d{4}/
		
		document.write(msg(reg, str1));
		document.write(msg(reg, str2));
		document.write(msg(reg, str3));
		document.write(msg(reg, str4));
		document.write(msg(reg, str5));
		document.write(msg(reg, str6));
		document.write(msg(reg, str7));
		document.write("<hr/>");
		
	}catch(err) {
		alert(err);
	}
</script>
</html>