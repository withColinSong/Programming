<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>filter</title>
<script src="./lib/jquery-3.5.1.js">
</script>
</head>
<%
 String inc = "intro.jsp";
 if(request.getParameter(inc) != null) {
	 inc = request.getParameter(inc);
 }
%>
<body>
<div id='index'>
	<header id='header'>헤더</header>
	<section id='contents'>contents
		<article class='content'>
		</article>
		<jsp:include page="<%=inc %>"></jsp:include>
		<aside class='aside'>
		<img src="http://placehold.it/150X100">
		</aside>
	</section>
	<footer id='footer'>융합 S/W 개발(주)</footer>
</div>
<script>

$('*').css({
	'box-sizing' : 'border-box',
	'margin' : '0px',
});

// index
$('#index').css({
	'margin' : 'auto',
	'width' : '800px'
	
});

// header
$('#header').css({
	'background-color' : 'gray',
	'height' : '100px'
});

// section
$('#contents').css({
	'min-height' : '250px',
	'background-color' : 'black',
	'color' : 'white'
});



// aside
$('.aside').css({
	'width': '150px',
	'float' : 'left'
});

//article
$('.content').css({
	'width': '650px',
	'float' : 'left'
});

// footer
$('#footer').css({
	'background-color' : 'gray',
	'height' : '100px',
	'text-align': 'center',
	'line-hight' : '100px'
});


</script>
</body>
</html>