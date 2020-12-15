<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl_test</title>
</head>
<body>
	<div id="jstl_ctrl">
	<h1>jstl(Java Standard Tag Library)</h1>
	</div>
	
	<%
		String name = "song";
		int score = 100;
		
		pageContext.setAttribute("page_name", name);
		pageContext.setAttribute("page_score", score);
		
		request.setAttribute("req_name", name);
		request.setAttribute("req_score", score);
		
		
	%>
	<h3>c:out ==> jstl를 사용한 출력문</h3>
	<li>Name : <c:out value='${pageScope.page_name }' default="이름을 입력하세요."/></li>
	<li>Score : <c:out value='${pageScope.page_score }' default="테스트"/></li>
	<li>Name(req) : <c:out value='${requestScope.req_name }' default="테스트"/></li>
	<li>Score(req) : <c:out value='${requestScope.req_score }' default="테스트"/></li>
	<li>Name : <c:out value='${page_name}'/>
	<li>Score : <c:out value='${page_score}'/>
	
	<h3>c:set | c:remove | c:out</h3>
	
	<c:set var='score' value='100'/>
	<li>Score 1 : <c:out value='${score}'/></li>
	<c:remove var='score'/>
	<li>Score 2: <c:out value='${score}' default='변수가 삭제됨'/></li>
	
	
	<h3>c:if</h3>
		<c:if test='${req_score >= 90 }'> <!-- 조건식  --> 
			<font color='red'></font>
		
		</c:if>
	
	<fieldset>
		<c:set var='kor' value="80"/>
		<c:set var='eng' value="100"/>
		
		<c:if test='${kor + eng >= 180 }'>
			<h1>우등생</h1>
		</c:if>
		<h1>하이</h1>
	</fieldset>
	<h3>c:choose | c:when | c:otherwise</h3>
	<xmp>
		[c:choose]
			[c:when test='조건식'] 
			[c:otherwise]
			맞는 조건식이 없을 경우 처리
			[/c:otherwise]
		[/c:choose]	
	</xmp>
	
	<fieldset>
		<div>
			- 1000원 이상: 화장지<br>
			- 10000원 이상 자전거<br>
			- 100000원 이상 아파트<br>
		</div>
		
		<h1>방법 1번</h1>
		<%
		
		int ea = 100;
		int price = 500;
		int amt = ea * price;
		
		request.setAttribute("amt", amt);
		
		%>
		<c:choose>
			<c:when test='${amt > 100000 }'>
				아파트
			</c:when>
			<c:when test='${amt >= 10000 }'>
				자전거
			</c:when>
			<c:when test='${amt > 1000 }'>
				화장지
			</c:when>
			<c:otherwise>
				다음에는 기회에는 1000원 이상 구매 부탁드립니다.
			</c:otherwise>
		</c:choose>
	</fieldset>
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>