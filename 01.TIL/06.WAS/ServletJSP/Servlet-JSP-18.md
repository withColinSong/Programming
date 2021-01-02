# [목차](#목차)
- [목차](#목차)
- [MVC 1 방식](#mvc-1-방식)
  - [1.1 기존 스파게티 방식 코드](#11-기존-스파게티-방식-코드)
  - [1.2. MVC1 코드](#12-mvc1-코드)
  - [1.3. 📁코드](#13-코드)
  - [References](#references)


# MVC 1 방식
- detail.jsp
## 1.1 기존 스파게티 방식 코드
```java

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:XE";
String JDBC_USER = "song";
String JDBC_PW ="1234";
String sql = "SELECT * FROM NOTICE";

Class.forName("oracle.jdbc.driver.OracleDriver");
Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PW);	
PreparedStatement ps = conn.prepareStatement(sql);
ResultSet rs = ps.executeQuery();

%>

<!DOCTYPE html>
<html>
    <head>
    <title>MVC 1</title>
    </head>
    <body>
        <% while(rs.next()) { %>		             
            <tr>
                <td><%=rs.getInt("ID") %></td>
                <td class="title indent text-align-left"><a href="detail.jsp?id=<%=rs.getInt("ID")%>"><%= rs.getString("TITLE") %></a></td>
                <td><%=rs.getString("WRITER_ID") %></td>
                <td>
                    <%=rs.getDate("REGDATE") %>		
                </td>
                <td><%=rs.getInt("HIT") %></td>
            </tr>
            <% } %>

        <% 
        rs.close() 
        ps.close();
        conn.close();
        %>    	
    </body>
</html>
```

## 1.2. MVC1 코드
- detail.jsp
```java

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
String writerId =  rs.getString("WRITER_ID");
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
                    <td><%=title %></td>
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

## 1.3. 📁코드
- [detail.jsp](prj/WebContent/admin/board/notice/detail.jsp)

## References
- [뉴렉처](https://www.youtube.com/watch?v=drCj2k50j_k&list=PLq8wAnVUcTFVOtENMsujSgtv2TOsMy8zd): `Servlet / JSP`
- 🎈vscode 정리
- 🎈2021.01.01

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)
