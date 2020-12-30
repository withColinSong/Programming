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

## References
- 🎈vscode 정리
- 🎈2020.12.27