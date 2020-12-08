# [목차](#목차)
- [목차](#목차)
- [1. XML](#1-xml)
	- [1.1 XML](#11-xml)
	- [1.2. xml의 단점](#12-xml의-단점)


# 1. XML

## 1.1 XML
- xml은 주석도 달지 않는다. 스크립트 영역에서 주석을 작성한다.
- 태그를 직접 만들 수 있다.

```java
<?xml version='1.0' encoding='UTF-8' ?> 
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
```

```java
<emps> <% // root element = root rode %>
	<% for(EmpVo vo : list) { %>
	<emp>
		<id><%=vo.getEmployee_id()%></id> <% 
        // 카멜방법으로 사용할 것.%>
		<name><%=vo.getFirst_name()%></name>
		<email><%=vo.getEmail()%></email>
		<phone><%=vo.getPhone_number()%></phone>
		<salary><%=vo.getSalary()%></salary>
	</emp>
	<% } %>
</emps>
```
## 1.2. xml의 단점
- 데이터 양보다, 태그 양이 많다.