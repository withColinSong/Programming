# [목차](#목차)
- [목차](#목차)
- [1. Connection](#1-connection)
  - [driver](#driver)
  - [url](#url)
  - [configuration](#configuration)
  - [mapper](#mapper)
- [2. 순서](#2-순서)
  - [1. config.xml](#1-configxml)
  - [2. BoardFactory.java](#2-boardfactoryjava)
  - [3. BoardDao.java](#3-boarddaojava)
  - [4. board.xml](#4-boardxml)
    - [4.1. config.xml](#41-configxml)
- [3. Error 원인](#3-error-원인)
  - [References](#references)


# 1. Connection
## driver  
- oracle.jdbc.driver.OracleDriver

## url 
- jdbc:oracle:thin:@localhost:1521:XE

## configuration
```html
<!DOCTYPE configuration
	 PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
	"http://mybatis.org/dtd/mybatis-3-config.dtd">
```
## mapper
```html
<!DOCTYPE mapper
	 PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
	"http://mybatis.org/dtd/mybatis-3-mapper.dtd">
```

# 2. 순서

## 1. config.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE configuration
	 PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
	"http://mybatis.org/dtd/mybatis-3-config.dtd">

<configuration>
	<environments default="development"> 
		<environment id="development">
		
		<transactionManager type="JDBC"/>
			<dataSource type="POOLED">
				<property name="driver" value="oracle.jdbc.driver.OracleDriver"/> 
				<property name="url" value="jdbc:oracle:thin:@localhost:1521:XE"/>
				<property name="username" value="song"/>
				<property name="password" value="1234"/>

			</dataSource>
		</environment>
	</environments>

    <!-- 
    mappers 추가 자리
    
    <mappers>
        <mapper resource="패키지명/파일이름"></mapper>
    </mappers>
    
    -->
    
</configuration>    
```

## 2. BoardFactory.java
```java
package board;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BoardFactory {
	
	private static SqlSessionFactory factory;
	
	
	static {
		
		try {
            // Reader reader = Resources.getResourceAsReader("패키지명/소속파일");
			Reader reader = Resources.getResourceAsReader("board/config.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static SqlSessionFactory getFactory() {
		return factory;
	}
}

```

## 3. BoardDao.java
```java
package board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class BoardDao {
	SqlSession sqlSession;
	
	public BoardDao() {
		
		sqlSession = BoardFactory.getFactory().openSession();
		
		if(sqlSession == null) {
			System.out.println("연결 중 오류..");
		}else {
			System.out.println("연결 성공!");
			
            // board.xml -> <mapper namespace="name"> <select id="all_serial">
            // List<Integer> list = sqlSession.selectList("namespace값.id값");
			
            List<Integer> list = sqlSession.selectList("name.all_serial");
			System.out.println("list: " +  list);
		}
		
		sqlSession.close();
	}
	
	public static void main(String[] args) {
		new BoardDao();
	}
}
```

## 4. board.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
	 PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
	"http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="name">
    <select id="all_serial" resultType="int">
        SELECT serial FROM board;
    </select>
</mapper>
```
### 4.1. config.xml
- board.xml 맵핑 하기

```xml
	<mappers>
        <!-- <mapper resource="패키지명/소속파일"></mapper> -->
		<mapper resource="board/board.xml"></mapper>
	</mappers>
```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE configuration
	 PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
	"http://mybatis.org/dtd/mybatis-3-config.dtd">
	
<configuration>
	<environments default="develop">
		<environment id="develop">
			
			<transactionManager type="JDBC"/>
			<dataSource type="POOLED">
				<property name="driver" value="oracle.jdbc.driver.OracleDriver"/>
				<property name="url" value="jdbc:oracle:thin:@localhost:1521:XE"/>
				<property name="username" value="song"/>
				<property name="password" value="1234"/>
			
			</dataSource>
		</environment>
	
	</environments>
	<mappers>
		<mapper resource="board/board.xml"></mapper>
	</mappers>
</configuration>
```

# 3. Error 원인
- mapper namespace, select id 확인해볼 것.
```java
<mapper namespace="oh">
	<select id="all_serial" resultType="int">
		SELECT serial FROM board
	</select>
</mapper>

List<Integer> list = sqlSession.selectList("oh.all_serial");
List<Integer> list = sqlSession.selectList(".all_serial"); //에러

```
  
![](https://images.velog.io/images/withcolinsong/post/341260f8-f9fa-420c-9102-0d896d6cf17f/image.png)
```java
org.apache.ibatis.exceptions.PersistenceException: 
### Error querying database.  
Cause: java.lang.IllegalArgumentException: Mapped Statements collection does not contain value for boardaa.all_serial

### Cause: java.lang.IllegalArgumentException: Mapped Statements collection does not contain value for boardaa.all_serial
	at org.apache.ibatis.exceptions.ExceptionFactory.wrapException(ExceptionFactory.java:30)
	at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:149)
	at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:140)
	at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:135)
	at boardssss.BoardDao.<init>(BoardDao.java:22)
	at boardssss.BoardDao.main(BoardDao.java:40)
Caused by: java.lang.IllegalArgumentException: Mapped Statements collection does not contain value for boardaa.all_serial
	at org.apache.ibatis.session.Configuration$StrictMap.get(Configuration.java:1031)
	at org.apache.ibatis.session.Configuration.getMappedStatement(Configuration.java:821)
	at org.apache.ibatis.session.Configuration.getMappedStatement(Configuration.java:814)
	at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:146)
	... 4 more
```

- property `name` -> Const

```xml
<property name="driver" value="oracle.jdbc.driver.OracleDriver"/> 
<property name="url" value="jdbc:oracle:thin:@localhost:1521:XE"/>
<property name="username" value="song"/>
<property name="password" value="1234"/>

<property name="driver" value="oracle.jdbc.driver.OracleDriver"/> 
<property name="url" value="jdbc:oracle:thin:@localhost:1521:XE"/>
<property name="username" value="song"/>
<property name="userpw" value="1234"/> // 에러사항
```
```java
Exception in thread "main" java.lang.ExceptionInInitializerError
	at boardTest.BoardDao.<init>(BoardDao.java:14)
	at boardTest.BoardDao.main(BoardDao.java:41)
Caused by: org.apache.ibatis.exceptions.PersistenceException: 
### Error building SqlSession.
### The error may exist in SQL Mapper Configuration
### Cause: org.apache.ibatis.builder.BuilderException: Error parsing SQL Mapper Configuration. Cause: org.apache.ibatis.datasource.DataSourceException: Unknown DataSource property: userpw
	at org.apache.ibatis.exceptions.ExceptionFactory.wrapException(ExceptionFactory.java:30)
	at org.apache.ibatis.session.SqlSessionFactoryBuilder.build(SqlSessionFactoryBuilder.java:52)
	at org.apache.ibatis.session.SqlSessionFactoryBuilder.build(SqlSessionFactoryBuilder.java:36)
	at boardTest.BoardFactory.<clinit>(BoardFactory.java:18)
	... 2 more
Caused by: org.apache.ibatis.builder.BuilderException: Error parsing SQL Mapper Configuration. Cause: org.apache.ibatis.datasource.DataSourceException: Unknown DataSource property: userpw
	at org.apache.ibatis.builder.xml.XMLConfigBuilder.parseConfiguration(XMLConfigBuilder.java:122)
	at org.apache.ibatis.builder.xml.XMLConfigBuilder.parse(XMLConfigBuilder.java:99)
	at org.apache.ibatis.session.SqlSessionFactoryBuilder.build(SqlSessionFactoryBuilder.java:50)
	... 4 more
Caused by: org.apache.ibatis.datasource.DataSourceException: Unknown DataSource property: userpw
	at org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory.setProperties(UnpooledDataSourceFactory.java:55)
	at org.apache.ibatis.builder.xml.XMLConfigBuilder.dataSourceElement(XMLConfigBuilder.java:330)
	at org.apache.ibatis.builder.xml.XMLConfigBuilder.environmentsElement(XMLConfigBuilder.java:284)
	at org.apache.ibatis.builder.xml.XMLConfigBuilder.parseConfiguration(XMLConfigBuilder.java:117)
	... 6 more
```

## References
- 🎈vscode 정리
- 🎈2020.12.27