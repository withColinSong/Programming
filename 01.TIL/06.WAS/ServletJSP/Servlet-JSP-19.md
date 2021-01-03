# [목차](#목차)
- [목차](#목차)
- [1. MVC 2 방법](#1-mvc-2-방법)
  - [View와 Controller 부분을 물리적으로 나누는 방식](#view와-controller-부분을-물리적으로-나누는-방식)
  - [Servlet과 JSP 연결 저장소](#servlet과-jsp-연결-저장소)
  - [1.1. 이전 코드](#11-이전-코드)
    - [Servlet-JSP-18](#servlet-jsp-18)
  - [1.2. 코드](#12-코드)
    - [detail.jsp](#detailjsp)
    - [1.2. `Servlet` NoticeDetailController.java](#12-servlet-noticedetailcontrollerjava)
    - [1.3. detail.jsp](#13-detailjsp)
  - [1.3. redirect, forward 사용 예시](#13-redirect-forward-사용-예시)
  - [References](#references)

# 1. MVC 2 방법

## View와 Controller 부분을 물리적으로 나누는 방식
- Control : Servlet
- Model : bean
- View : JSP

## Servlet과 JSP 연결 저장소
- pageContext 
- request 
- Session 
- application

## 1.1. 이전 코드
### [Servlet-JSP-18](Servlet-JSP-18.md)

## 1.2. 코드

### detail.jsp

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
int id = Integer.parseInt(request.getParameter("id"));

String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:XE";
String JDBC_USER = "song";
String JDBC_PW ="1234";
String sql = "SELECT * FROM NOTICE WHERE ID=?";

Class.forName("oracle.jdbc.driver.OracleDriver");

Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PW);	
PreparedStatement ps = conn.prepareStatement(sql);
ps.setInt(1, id);

ResultSet rs = ps.executeQuery();
rs.next();

String title = rs.getString("TITLE");
Date regdate = rs.getDate("REGDATE");
String writer_id =  rs.getString("WRITER_ID");
String hit = rs.getString("HIT");
String files = rs.getString("FILES");
String content = rs.getString("CONTENT");

rs.close();
ps.close();
conn.close();

%>
<!DOCTYPE html>
<html>
    <head>
    <title>MVC 1</title>
    </head>
    <body>
        <table class="table">
            <tbody>
                <tr>
                    <th>제목</th>
                    <td><%=title%></td>
                </tr>
                <tr>
                    <th>작성일</th>
                    
                    <td><%=regdate %></td>
                </tr>
                <tr>
                    <th>작성자</th>
                    <td><%=writerId %></td>
                    <th>조회수</th>
                    <td><%=hit %></td>
                </tr>
                <tr>
                    <th>첨부파일</th>
                    <td><%=files %></td>
                </tr>
                <tr class="content">
                    <td><%=content %><div><br></div></td>
                </tr>
            </tbody>
    </table>
    </body>
</html>
```

### 1.2. `Servlet` NoticeDetailController.java 
```java
package com.song.web.controller;

import java.io.IOException;
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

@WebServlet("/notice/detail")
public class NoticeDetailController extends HttpServlet {
		
	@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			int id = Integer.parseInt(request.getParameter("id"));

			String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:XE";
			String JDBC_USER = "song";
			String JDBC_PW ="1234";
			String sql = "SELECT * FROM NOTICE WHERE ID=?";

			try {
				
                // jsp 파일에서 코드블럭을 복사해서 붙여넣기.
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PW);	
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, id);

				ResultSet rs = ps.executeQuery();
				rs.next();

				String title = rs.getString("TITLE");
				Date regdate = rs.getDate("REGDATE");
				String writer_id =  rs.getString("WRITER_ID");
				String hit = rs.getString("HIT");
				String files = rs.getString("FILES");
				String content = rs.getString("CONTENT");

				
				request.setAttribute("title", title);
				request.setAttribute("regdate", regdate);
				request.setAttribute("writer_id", writer_id);
				request.setAttribute("hit", hit);
				request.setAttribute("files", files);
				request.setAttribute("content", content);
				
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
			
			// redirect 게시글 등록 목록 페이지, 로그인 페이지

			// forward
			request.getRequestDispatcher("/notice/detail.jsp").forward(request, response);
		}
		
		
}

```
### 1.3. detail.jsp
```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <title>MVC 1</title>
    </head>
    <body>
        <table class="table">
            <tbody>
                <tr>
                    <th>제목</th>
                    <td><%=request.getAttribute("title") %></td>
                </tr>
                <tr>
                    <th>작성일</th>
                    
                    <td><%=request.getAttribute("regdate") %></td>
                </tr>
                <tr>
                    <th>작성자</th>
                    <td><%=request.getAttribute("writerId") %></td>
                    <th>조회수</th>
                    <td><%=request.getAttribute("hit") %></td>
                </tr>
                <tr>
                    <th>첨부파일</th>
                    <td><%=request.getAttribute("files") %></td>
                </tr>
                <tr class="content">
                    <td><%=request.getAttribute("content") %><div><br></div></td>
                </tr>
            </tbody>
    </table>
    </body>
</html>
```

## 1.3. redirect, forward 사용 예시
- `redirect`
  - 게시글 등록 목록 페이지로 이동
  - 로그인 페이지 이동
- `forward`
  - jsp와 데이터를 연결할 때

## References
- [뉴렉처](https://www.youtube.com/watch?v=drCj2k50j_k&list=PLq8wAnVUcTFVOtENMsujSgtv2TOsMy8zd): `Servlet / JSP`
- 🎈vscode 정리
- 🎈2021.01.03

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)