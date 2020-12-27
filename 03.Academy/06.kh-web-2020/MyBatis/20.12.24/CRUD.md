# [목차](#목차)
- [목차](#목차)
- [1. SELECT](#1-select)
	- [.java](#java)
	- [.xml](#xml)
- [2. INSERT](#2-insert)
	- [.java](#java-1)
	- [.xml](#xml-1)
- [3. UPDATE](#3-update)
	- [.java](#java-2)
	- [.xml](#xml-2)
- [4. DELETE](#4-delete)
	- [.java](#java-3)
	- [.xml](#xml-3)

# 1. SELECT

## .java
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
				
				int serial = sqlSession.selectOne("board.one_serial");
				System.out.println("serial : " + serial);
				
				// 모든 데이터를 BoardVo에 담아 출력
				List<BoardVo> list_two = sqlSession.selectList("board.list");
				for(BoardVo vo : list_two) {
					System.out.println("vo.getSerial() : " + vo.getSerial());
					System.out.println("vo.getSubject() : " + vo.getSubject());
				}
			}
			
			
			// Serial번호에 해당하는 BoardVo 한 건 출력
			// - BoardVo vo = sqlSession.selectOne("board.view", parameterType="타입");
			
			BoardVo vo = sqlSession.selectOne("board.view", 3);
			System.out.println();
			System.out.println("serial : " + vo.getSerial());
			System.out.println("subject : " + vo.getSubject());
			
			// 검색어를 전달받아 해당 자료를 BoardVo에 담아 출력하기
			List<BoardVo> list_three = sqlSession.selectList("board.select", "1");
			
			for(BoardVo v : list_three) {
				System.out.println();
				System.out.println("v.getSerial() : " + v.getSerial());
				System.out.println("v.getSubject() : " +v.getSubject());
			}

			sqlSession.close();
	public static void main(String[] args) {
		new BoardDao();
		
	}
}




```

## .xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
	PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
	"http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="board">
	<select id="all_serial" resultType="int">
		SELECT serial FROM board
	</select>
	
	<select id="one_serial" resultType="int">
		SELECT serial FROM board WHERE serial = 1
	</select>

	<select id="list" resultType="board.BoardVo"> <!-- 쿼리문을 실행해서 데이터들을 BoardVo에 담아라. -->
		SELECT * FROM board
	</select>
	
	<select id="view" resultType="board.BoardVo" parameterType="int">
		SELECT serial, subject FROM board WHERE serial = #{_parameter}
	</select>
	
	<select id="select" resultType="board.BoardVo" parameterType="String">
		SELECT * FROM board WHERE subject LIKE '%${_parameter}%' OR doc LIKE '%${_parameter}%'
	
	</select>
</mapper>
```


# 2. INSERT

## .java

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

			// INSERT
			// 한 건의 데이터를 BoardVo에 담아 저장하기
			BoardVo v_two = new BoardVo();
			v_two.setMid("song!");
			v_two.setPwd("5555");
			
			int cnt = sqlSession.insert("board.insert", v_two);
			if( cnt > 0 ) {
				System.out.println("INSERT : " + v_two);
				sqlSession.commit();
			}else {
				System.out.println("Insert 오류");
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

## .xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
	PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
	"http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="board">
	<insert id="insert" parameterType="board.BoardVo">
		INSERT INTO board(serial, mid, pwd) VALUES(seq_board.nextval, #{mid}, #{pwd})
	</insert>
</mapper>
```


# 3. UPDATE

## .java
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
			
			// UPDATE
			// serial = 1인 자료의 subject, doc를 수정
			BoardVo v_three = new BoardVo();
			v_three.setSubject("수정된 제목");
			v_three.setDoc("수정된 내용");
			v_three.setSerial(3);
			v_three.setPwd("1234");
			
			int cnt = sqlSession.update("board.update", v_three);
			if(cnt > 0) {
				System.out.println("Update : " + v_three);
				sqlSession.commit();
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

## .xml
```java
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
	PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
	"http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="board">
	<update id="update" parameterType="board.BoardVo">
		UPDATE board SET subject = #{subject}, doc = #{doc} WHERE serial = #{serial} AND pwd = #{pwd}
	</update>
</mapper>
```

# 4. DELETE
## .java
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
			// DELETE
			BoardVo v_four = new BoardVo();
			v_four.setSerial(5);
			v_four.setPwd("1234");

			int cnt = sqlSession.delete("board.delete", v_four);
			if( cnt > 0) {
				System.out.println("Delete : " + v_four);
				sqlSession.commit();
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

## .xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
	PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
	"http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="board">
	<delete id="delete" parameterType="board.BoardVo">
		DELETE FROM board WHERE serial = #{serial} AND pwd = #{pwd}
	</delete>
</mapper>
```