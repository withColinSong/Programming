# [목차](#목차)
- [목차](#목차)
- [서블릿 정리](#서블릿-정리)
  - [References](#references)

# 서블릿 정리
- 서블릿 : **자바 웹 프로그램**
- -> 입/출력 request, response
- -> 웹문서 출력
- -> 서블릿에서 출력의 번거로움 
- -> 문서 기반 (jsp의 코드블록) 
```java
	out.write("<!DOCTYPE html>");
    out.write("<html>");
    out.write("<head>");
    out.write("<meta charset=\"UTF-8\">");
    out.write("<title>Insert title here</title>");
    out.write("<style>");

    out.write("input {");
    out.write("width : 50px;");
    out.write("height: 50px;");
    out.write("}");

    out.write(".output {");
    out.write("height: 50px;");
    out.write("background: #e9e9e9;");
    out.write("font-size: 24px;");
    out.write("font-weight: bold;");
    out.write("text-align:right;");
    out.write("padding: 0px 5px;");
    out.write("}");
    .....
```
- -> 문제점 : 스파게티 코드가 됨.
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
- -> MVC model 방식
- -> View에서 코드 블록이 꼭 필요한 경우 -> `EL` ,  `JSTL`

## References
- [뉴렉처](https://www.youtube.com/watch?v=drCj2k50j_k&list=PLq8wAnVUcTFVOtENMsujSgtv2TOsMy8zd): `Servlet / JSP`
- 🎈vscode 정리
- 🎈2021.01.15

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)