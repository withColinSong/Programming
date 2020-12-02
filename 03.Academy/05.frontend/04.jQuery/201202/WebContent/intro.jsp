<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%-- CDN 형태 : 네트워크가 연결이 안될 시 문제가 생길 수 있다.--%>
<%-- <script 
  src="http://code.jquery.com/jquery-3.5.1.js"
  integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
  crossorigin="anonymous"></script>--%>
<script src="./lib/jquery-3.5.1.js"></script>
</head>
<body>
<h1 id="header">jQuery Test를 위한 태그</h1>
<ul>
	<li><a href="index.jsp?inc=./jquery/filter.jsp">Filter</a></li>
	<li><a href="index.jsp?inc=./jquery/traverse.jsp">TRAVERSE</a></li>
</ul>
<% 
	// 스크립트릿 영역 (scriptlet) : java coding area
	// java -> System.out.println();
	// js -> console.log();, document.write();
	out.print("hi jQuery...");
%>
<script>
$('#header').css('color', '#00f');
</script>
</body>
</html>