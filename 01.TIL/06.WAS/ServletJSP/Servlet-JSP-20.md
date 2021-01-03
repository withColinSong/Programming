# [목차](#목차)
- [목차](#목차)
- [1. MVC model 1](#1-mvc-model-1)
  - [1.1 스파게티 jsp 코드](#11-스파게티-jsp-코드)
  - [1.2. MVC model 1 방식](#12-mvc-model-1-방식)
- [2. MVC model 2 방식](#2-mvc-model-2-방식)
  - [2.1. Vo.java](#21-vojava)
  - [2.2. `Servlet`](#22-servlet)
  - [2.3. `jsp`](#23-jsp)
    - [파일 경로](#파일-경로)
  - [References](#references)

# 1. MVC model 1
## 1.1 스파게티 jsp 코드
```java
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>model 1 방식 사용하기</title>
<%


String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:XE";
String JDBC_USER = "song";
String JDBC_PW = "1234";


Class.forName("oracle.jdbc.driver.OracleDriver");
Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PW);

String sql = "SELECT * FROM notice WHERE ID = ?";
PreparedStatement ps = conn.prepareStatement(sql);
ps.setInt(1, 1);
ResultSet rs = ps.executeQuery();



%>
</head>
<body>
	<table border="2">
		<th>NO</th>
		<th>제목</th>
		<th>작성자</th>
		<th>내용</th>
		<th>게시날짜</th>
		<th>조회수</th>
		<th>파일</th>
		
		<tr>
		<% if(rs.next()) { %>
			<td><%=rs.getInt("id") %></td>
			<td><%=rs.getString("title") %></td>
			<td><%=rs.getString("writer_id") %></td>
			<td><%=rs.getString("content") %></td>
			<td><%=rs.getDate("regdate") %></td>
			<td><%=rs.getInt("hit") %></td>
			<td><%=rs.getString("files") %></td>
		<% } %>
		</tr>
	</table>
	
	<% 
	rs.close();
	ps.close();
	conn.close();
	
	%>
</body>
</html>

```

## 1.2. MVC model 1 방식
```jsp
<%@page import="java.util.Date"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:XE";
String JDBC_USER = "song";
String JDBC_PW = "1234";

Class.forName("oracle.jdbc.driver.OracleDriver");
Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PW);

String sql = "SELECT * FROM notice WHERE id=?";
PreparedStatement ps = conn.prepareStatement(sql);
ps.setInt(1, 1);
ResultSet rs = ps.executeQuery();

rs.next();
int id = rs.getInt("id");
String title = rs.getString("title");
String writer_id = rs.getString("writer_id");
String content = rs.getString("content");
Date regdate = rs.getDate("regdate");
int hit = rs.getInt("hit");
String files = rs.getString("files");

rs.close();
ps.close();
conn.close();
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>model 2 방식 사용하기</title>
</head>
<body>
	<table border="2">
		<th>NO</th>
		<th>제목</th>
		<th>작성자</th>
		<th>내용</th>
		<th>게시날짜</th>
		<th>조회수</th>
		<th>파일</th>
		
		<tr>
			<td><%=id %></td>
			<td><%=title %></td>
			<td><%=writer_id %></td>
			<td><%=content %></td>
			<td><%=regdate %></td>
			<td><%=hit %></td>
			<td><%=files %></td>
		</tr>
	</table>
</body>
</html>
```

![](https://images.velog.io/images/withcolinsong/post/a2d74fb0-3059-4c76-8883-4322ad3c21b1/image.png)

# 2. MVC model 2 방식
## 2.1. Vo.java
```java
package com.yj.web.vo;

import java.util.Date;

public class MemberVo {
	public MemberVo() {	}

	public MemberVo(int id, String title, String writer_id, String content, Date regdate, int hit, String files) {

		this.id = id;
		this.title = title;
		this.writer_id = writer_id;
		this.content = content;
		this.regdate = regdate;
		this.hit = hit;
		this.files = files;
	}

	private int id;
	private String title;
	private String writer_id; 
	private String content;
	private Date regdate;
	private int hit;
	private String files;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter_id() {
		return writer_id;
	}
	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getFiles() {
		return files;
	}
	public void setFiles(String files) {
		this.files = files;
	}

	@Override
	public String toString() {
		return "MemberVo [id=" + id + ", title=" + title + ", writer_id=" + writer_id + ", content=" + content
				+ ", regdate=" + regdate + ", hit=" + hit + ", files=" + files + "]";
	}

}

```
## 2.2. `Servlet`
```java
package com.yj.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yj.web.vo.MemberVo;

@WebServlet("/mvc/mvc2")
public class Controller extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		
		String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:XE";
		String JDBC_USER = "song";
		String JDBC_PW = "1234";

		PrintWriter out = response.getWriter();
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PW);

			String sql = "SELECT * FROM notice WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, 1);
			ResultSet rs = ps.executeQuery();

			rs.next();
			
			int id = rs.getInt("id");
			out.println(id);
			String title = rs.getString("title");
			String writer_id = rs.getString("writer_id");
			String content = rs.getString("content");
			Date regdate = rs.getDate("regdate");
			int hit = rs.getInt("hit");
			String files = rs.getString("files");

			MemberVo vo = new MemberVo(id, title, writer_id, content, regdate, hit, files);
			
			request.setAttribute("vo", vo);
			
			rs.close();
			ps.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/mvc/mvc2.jsp").forward(request, response);
		
	}

}
```

## 2.3. `jsp`
```jsp
<%@page import="java.util.Date"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>model 2 방식 사용하기</title>
</head>
<body>
	<table border="2">
		<th>NO</th>
		<th>제목</th>
		<th>작성자</th>
		<th>내용</th>
		<th>게시날짜</th>
		<th>조회수</th>
		<th>파일</th>
		
		<tr>
			<td>${vo.id}</td>
			<td>${vo.title }</td>
			<td>${vo.writer_id }</td>
			<td>${vo.content }</td>
			<td>${vo.regdate }</td>
			<td>${vo.hit }</td>
			<td>${vo.files }</td>
		</tr>
	</table>
	
	
</body>
</html>
```

![](https://images.velog.io/images/withcolinsong/post/20201898-cb02-47a4-9d1c-0f22e5b2c192/image.png)

### 파일 경로
![](https://images.velog.io/images/withcolinsong/post/ee5bc7ea-74f5-4a8e-9b9c-9bf5fb14ee07/image.png)

## References
- [뉴렉처](https://www.youtube.com/watch?v=drCj2k50j_k&list=PLq8wAnVUcTFVOtENMsujSgtv2TOsMy8zd): `Servlet / JSP`
- 🎈vscode 정리
- 🎈2021.01.03

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)