<%@page import="com.google.gson.JsonElement"%>
<%@page import="com.google.gson.JsonArray"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.google.gson.JsonObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSON Test</title>
</head>
<body>
<script>

/*
	JSON은 데이터 형식이 기본적으로 `문자열` 패턴을 가지고 있다.
	- object 구조 o
	
	JSON의 기본적인 데이터 구조 
	1. map구조 : {"key" : "value", ...}
	2. list 구조(배열) : ["value", ...]
	3. 혼합구조 : {[]} or [{}] or {{}} or [[]]

	 
 */
</script>

<%
  // 1. gson 라이브러리를 설치	
  // 2. gson을 사용하여 json의 object 생성하기
  
  JsonObject obj1 = new JsonObject();
  obj1.addProperty("mid", "a001"); // addProperty("key", "value");
  obj1.addProperty("name", "송"); // 테이블로 가져온다면 송 자리에 rs.getString("mid");
  obj1.addProperty("address", "서울");
  obj1.addProperty("phone", "010-1234-1234");
  obj1.addProperty("mdate", new Date().toGMTString());
  
 
  out.print("<h3>gson으로 만든 object</h3>");
  out.print(obj1);
  
  out.print("<li>mid : " + obj1.get("mid"));
  out.print("<li>name : " + obj1.get("name"));
  out.print("<li>address : " + obj1.get("address"));
  out.print("<li>phone : " + obj1.get("phone"));
  out.print("<li>date : " + obj1.get("mdate"));
	
  
  // gson 라이브러리의 json 배열 구조
  
  JsonArray array = new JsonArray();
  JsonObject obj2 = new JsonObject();
  obj2.addProperty("mid", "b001");
  obj2.addProperty("name", "연");
  
  array.add(obj2);
  
  JsonObject obj3 = new JsonObject();
  obj3.addProperty("mid", "c001");
  obj3.addProperty("name", "song");
  array.add(obj3);
  
  out.print("<h3>gson 라이브러리를 사용한 Object 배열</h3>");
  out.print("array : " + array); // ajax -> JSON.parse(array);
  
  JsonElement ele = array.get(0); // value 값
  out.print("<li>mid : " + ele.getAsJsonObject().get("mid"));
  out.print("<li>name : " + ele.getAsJsonObject().get("name"));
  
%>
</body>
</html>