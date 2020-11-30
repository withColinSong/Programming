<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
<script src="./lib/jquery-3.5.1.js"></script>
</head>
<body>
<%
	String inc = "intro.jsp";
	if(request.getParameter("inc") != null) {
		inc = request.getParameter("inc");
	}
	
%>
<%-->http://localhost:9090/web-2020/index.jsp?inc=./jquery/filter.jsp --%>
<div id="index">
	<header id="header">헤더</header>
	<section id="contents">
		<article class="content">
		<jsp:include page="<%=inc %>"/> <%--동적 include --%>
		</article>
		<aside class="aside">
			<img src="http://placehold.it/150X100"/>
		</aside>
		</section>
	<footer id="footer">융합 S/W 개발(주)</footer>
</div>
<script>
 // 모든 기본태그의 마진, 패딩을 0으로 설정
 $('*').css('margin', '0px');
 $('*').css('padding', '0px');

 // 패딩의 증가의 영향을 최소화
 $('*').css('box-sizing', 'border-box');
 
 // index페이지의 넓이와 중앙배치
 $('#index').css('width', '800px');
 $('#index').css('margin', 'auto');
 
 //header 높이와 색깔
 $('#index>#header').css('height', '150px');
 $('#index>#header').css('background-color', '#ccc');
 $('#index>#header').css('margin-top', '5px');
 // #header라고 선택해도 되지만, 보다 빠르게 선택하기 위해 위에 코드로 실행한다.

 // contents는 최소 높이
 $('#index>#contents').css('min-height', '250px');
 // height -> 고정높이 min-height -> 유동성'
 
 // footer 높이와 바탕색
 /*
 $('#index>#footer').css('height', '100px')
 $('#index>#footer').css('background-color', '#bbb');
 $('#index>#footer').css('text-align', 'center');
 $('#index>#footer').css('line-height', '100px');*/
 
 // footer의 속성들을 -> json 표기법으로 변경
 $('#index>#footer').css({
	 'height' : '100px',
	 'background-color' : '#bbb',
	 'text-align' : 'center',
	 'line-height' : '100px'
	 });
 
 $('#index>#contents').css({
	'margin-top' : '5px',
	'margin-bottop' : '5px',
 });
 
 $('#index>#contents>.content').css({
	 'width' : '650px',
	 'float' : 'left'

 });
 
 $('#index>#contents>.aside').css({
	 'width' : '150px',
	 'float' : 'left'
 });

 
</script>
</body>
</html>