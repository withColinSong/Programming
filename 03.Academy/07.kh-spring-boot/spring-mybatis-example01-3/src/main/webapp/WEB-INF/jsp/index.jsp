<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- JQuery -->
<script
  src="https://code.jquery.com/jquery-3.5.1.js"
  integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
  crossorigin="anonymous"></script>


<link rel="stylesheet" type="text/css" href="css/index.css">
<script src="js/index.js"></script>
<script src="js/board.js"></script>
<title>Spring Boot Final Example</title>
</head>
<body>
	<div id="index">
		<!-- 헤더 -->
		<header id="header">
			<h2>Spring Boot final Example</h2>
		</header>
		
		<!-- nav -->
		<nav id="menu">
			<ul>
			 	<li><a href="#" onclick="goURL('/bSelect')">공지사항</a></li>
			</ul>
		
			<section id="here">
			
			</section>
		</nav>
		
		
		<!-- 푸터 -->
		<footer id="footer">
			좋은 우리 주식 회사
		</footer>
	</div>

</body>
</html>