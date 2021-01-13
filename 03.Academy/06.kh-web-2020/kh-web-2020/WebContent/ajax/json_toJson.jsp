<%@page import="com.google.gson.JsonArray"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.google.gson.JsonElement"%>
<%@page import="com.google.gson.JsonParser"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="bean.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>json_toJson</title>
</head>
<body>
	<div id="json_toJson">
		<h3>Java Vo를 사용하여 GSON 라이브러리를 사용하여 JSON 구조로 만들기</h3>
		<h3>Java class -> json</h3>
		<%
			MemberVo vo = new MemberVo();
			vo.setMid("song"); // "song" -> rs.getString("mid");
			vo.setEmail("song@abc.com");
			vo.setPhoto("song.png");
			
		Gson gson = new Gson(); 
		
		// json 자바에 문자열 구조로 가지고 있기 때문에 아래 코드를 사용한다. 
		// 이것을 오브젝트로 변경 해야 함.
		// js 문자열로 넘어온 것을 JSON.parse() -> object로 변환
		String str = gson.toJson(vo);
		out.print("str : " + str);
		
		// 문자열로 되어 있는 JSON 구조를 JSON object로 변환
		JsonParser parser = new JsonParser();
		
		JsonElement ele = parser.parse(str); // 문자열을 JsonElement로 변환
		JsonObject obj = ele.getAsJsonObject(); // JsonElement를 obj로 변경
		
		
		out.print("<hr/>");
		out.print("obj : " + obj);
		out.print("<hr/>");
		out.print("parser.parse(str) : " + parser.parse(str));
		out.print("<hr/>");
		out.print("<li>mid : " + obj.get("mid"));
		out.print("<li>email : " + obj.get("email"));
		out.print("<li>photo : " + obj.get("photo"));
		
		// List<MemberVo>를 생성하여 GSON을 사용한 배열 처리
		List<MemberVo> list = new ArrayList<>();
		MemberVo vo1 = new MemberVo();
		vo1.setMid("song");
		vo1.setName("송");
		
		list.add(vo1);
		
		MemberVo vo2 = new MemberVo();
		vo2.setMid("yeon");
		vo2.setName("연");
		
		list.add(vo2);
		out.print("<hr/>");
		str = gson.toJson(list);
		out.print("List to JSON : " + str);
		out.print("<hr/>");
		
		ele = parser.parse(str);
		JsonArray array = ele.getAsJsonArray();
		out.print("array : " + array);
		
		JsonElement ele2 = array.get(0);
		JsonObject obj2 = ele2.getAsJsonObject();
		
		out.print("<li>mid : " + obj2.get("mid"));
		out.print("<li>name : " + obj2.get("name"));
		
		JsonElement ele3 = array.get(1);
		JsonObject obj3 = ele3.getAsJsonObject();
		
		out.print("<li>mid : " + obj3.get("mid"));
		out.print("<li>name : " + obj3.get("name"));
		%>
	</div>
</body>
</html>