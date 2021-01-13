<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@page import="bean.MemberVo"%>
<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>json_toClass</title>
</head>
<body>
	<div id="jsonToClass">
	<h3>json to class 변환</h3>
	
	<%
	
	String json = "{'mid': 'song', 'name' : '송'}".replaceAll("'", "\"");
	
	Gson gson = new Gson();
	MemberVo vo =  gson.fromJson(json, MemberVo.class);
	
	out.print("<li>mid : " + vo.getMid());
	out.print("<li>name : " + vo.getName());
	out.print("<hr/>");
	out.print(vo);
	
	
	String jsonArray = "[{'mid' : 'song1'}, {'phone' : '010-1234-1234'}]".replaceAll("'", "\"");
	
	MemberVo[] voArray = gson.fromJson(jsonArray, MemberVo[].class);
	List<MemberVo> list = Arrays.asList(voArray);
	
	vo = list.get(0);
	out.print("<h3>json array to List : </h3>");
	out.print("<li>mid : " + vo.getMid());
	vo = list.get(1);
	out.print("<li>phone : " + vo.getPhone());
	
	%>
	</div>
</body>
</html>