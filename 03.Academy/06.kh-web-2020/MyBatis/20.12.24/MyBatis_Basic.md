# [목차](#목차)
- [목차](#목차)
- [myBatis .jar 프레임워크 사용하기.](#mybatis-jar-프레임워크-사용하기)
  - [1. myBatis Basic](#1-mybatis-basic)
    - [1.1. import](#11-import)
    - [1.2. 기본 문법](#12-기본-문법)
    - [1.3. property](#13-property)
  - [2. Connection](#2-connection)
  - [3. sqlMap](#3-sqlmap)
  - [4. 테이블 생성](#4-테이블-생성)
  - [5. Connection 후](#5-connection-후)


# myBatis .jar 프레임워크 사용하기.

## 1. myBatis Basic

### 1.1. import
```java
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE configuration
	 PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
	"http://mybatis.org/dtd/mybatis-3-config.dtd">

```

### 1.2. 기본 문법

```java
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE configuration
	 PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
	"http://mybatis.org/dtd/mybatis-3-config.dtd">

<configuration>
	<environments default="development"> 
		<environment id="devleopment"> 
		
		<transactionManager type="JDBC"/>  // 고정값

			<dataSource type="POOLED">
				<property name="driver" value=""/> //Java 필드명
				<property name="url" value=""/>
				<property name="username" value=""/>
				<property name="password" value=""/>
			</dataSource>
		
        </environment>
	</environments>
	
	<mappers>
	
	</mappers>
</configuration>

```
- `environments default="variable"`, `environment id="variable"` 는 값이 매치가 되어야 한다.

### 1.3. property
```java
<property name="driver" value="oracle.jdbc.driver.OracleDriver"/> 
<property name="url" value="jdbc:oracle:thin:@localhost:1521:XE"/>
<property name="username" value="oracle계정이름"/>
<property name="password" value="oracle계정비밀번호"/>

```


## 2. Connection

- BoardFactory.java
```java
package board;

import java.io.Reader;
import java.sql.Connection;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.TransactionIsolationLevel;

public class BoardFactory {
	private static SqlSessionFactory factory;
	
	static {
		
		try {
			
			Reader reader = Resources.getResourceAsReader("board/comfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);				
				
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	public static SqlSessionFactory getFactory() {
		return factory;
	}

}
```

- BoardDao.java
```java
package board;

import org.apache.ibatis.session.SqlSession;

public class BoardDao {
	
	SqlSession sqlSession;
	
	public BoardDao() {
		
		try {
			
			sqlSession = BoardFactory.getFactory().openSession();
			
			if(sqlSession == null) {
				System.out.println("시스템 연결 중 오류");
			}else {
				System.out.println("연결 성공");
			}
			
			sqlSession.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new BoardDao();
		
	}
}
```
- config.xml
```java
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
	
	<mappers>
	
	</mappers>
</configuration>
```

## 3. sqlMap


- SQL 문장중 `${var}` 또는 `#{var}`를 기술하는데 이는 PrepareStatement 문장의 역할
  - ${var} : 양옆에 작은 따옴표를 붙여주지 않는다.(잠재적인 SQL 주입 공격에 노출될 수
있음)
  - #{var} : 양옆에 작은 따옴표를 붙여준다. -> `권장`
  - 예) id값이 park 인 경우

```java
where id=${id} : where id=park
where id=#{id} : where id='park'
```

- insert, update, delete시 mybatis의 세션을 commit하고 닫아 주어야 한다.

## 4. 테이블 생성
- [게시판 테이블 생성 및 시퀀스](20.12.24.sql)


## 5. Connection 후
- BoardDao.java

```java
package board;

import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class BoardDao {
	
	SqlSession sqlSession;
	
	public BoardDao() {
		
		try {
			
			sqlSession = BoardFactory.getFactory().openSession();
			
			if(sqlSession == null) {
				System.out.println("시스템 연결 중 오류");
			} else {
				System.out.println("연결 성공");
				
				
				// board.xml 만들고 작성 -> 모든 serial값을 가져온다.
				List<Integer> list = sqlSession.selectList("board.all_serial");
				System.out.println(Arrays.toString(list.toArray()));
				
//				int serial = sqlSession.selectOne("board.one_serial");
//				System.out.println("serial : " + serial);
			}
			
			sqlSession.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new BoardDao();
		
	}
}
```

- board.xml
```java
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
	PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
	"http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="board">
	<select id="all_serial" resultType="int">
		SELECT serial FROM board
	</select>
	
	<select id="one_serial" resultType="int">
		SELECT serial FROM board WHERE serial = 1;
	</select>

</mapper>
```