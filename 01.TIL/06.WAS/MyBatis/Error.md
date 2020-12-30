# [목차](#목차)
- [목차](#목차)
- [1. Mybatis 사용 중 `Error` 원인](#1-mybatis-사용-중-error-원인)
  - [1.1 mapper namespace, select id 확인해볼 것.](#11-mapper-namespace-select-id-확인해볼-것)
  - [1.2 property `name` -> Const](#12-property-name---const)
  - [1.3 쿼리문에 세미콜론 문제](#13-쿼리문에-세미콜론-문제)
  - [References](#references)


# 1. Mybatis 사용 중 `Error` 원인
## 1.1 mapper namespace, select id 확인해볼 것.
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

## 1.2 property `name` -> Const

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

## 1.3 쿼리문에 세미콜론 문제

```xml
<mapper namespace="all">
	<select id="bbb" resultType="int">
	SELECT USER_NO FROM USER_TBL;
	</select>
</mapper>	
	
```
```java
Exception in thread "main" org.apache.ibatis.exceptions.PersistenceException: 
Error querying database.  Cause: java.sql.SQLSyntaxErrorException: ORA-00911: invalid character

The error may exist in prj/sql.xml
### The error may involve defaultParameterMap
### The error occurred while setting parameters
### SQL: SELECT USER_NO FROM USER_TBL;
### Cause: java.sql.SQLSyntaxErrorException: ORA-00911: invalid character

	at org.apache.ibatis.exceptions.ExceptionFactory.wrapException(ExceptionFactory.java:30)
	at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:149)
	at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:140)
	at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:135)
	at prj.BoardDao.<init>(BoardDao.java:24)
	at prj.BoardDao.main(BoardDao.java:37)
Caused by: java.sql.SQLSyntaxErrorException: ORA-00911: invalid character

	at oracle.jdbc.driver.T4CTTIoer.processError(T4CTTIoer.java:440)
	at oracle.jdbc.driver.T4CTTIoer.processError(T4CTTIoer.java:396)
	at oracle.jdbc.driver.T4C8Oall.processError(T4C8Oall.java:837)
	at oracle.jdbc.driver.T4CTTIfun.receive(T4CTTIfun.java:445)
	at oracle.jdbc.driver.T4CTTIfun.doRPC(T4CTTIfun.java:191)
	at oracle.jdbc.driver.T4C8Oall.doOALL(T4C8Oall.java:523)
	at oracle.jdbc.driver.T4CPreparedStatement.doOall8(T4CPreparedStatement.java:207)
	at oracle.jdbc.driver.T4CPreparedStatement.executeForDescribe(T4CPreparedStatement.java:863)
	at oracle.jdbc.driver.OracleStatement.executeMaybeDescribe(OracleStatement.java:1153)
	at oracle.jdbc.driver.OracleStatement.doExecuteWithTimeout(OracleStatement.java:1275)
	at oracle.jdbc.driver.OraclePreparedStatement.executeInternal(OraclePreparedStatement.java:3576)
	at oracle.jdbc.driver.OraclePreparedStatement.execute(OraclePreparedStatement.java:3677)
	at oracle.jdbc.driver.OraclePreparedStatementWrapper.execute(OraclePreparedStatementWrapper.java:1374)
	at org.apache.ibatis.executor.statement.PreparedStatementHandler.query(PreparedStatementHandler.java:64)
	at org.apache.ibatis.executor.statement.RoutingStatementHandler.query(RoutingStatementHandler.java:79)
	at org.apache.ibatis.executor.SimpleExecutor.doQuery(SimpleExecutor.java:63)
	at org.apache.ibatis.executor.BaseExecutor.queryFromDatabase(BaseExecutor.java:325)
	at org.apache.ibatis.executor.BaseExecutor.query(BaseExecutor.java:156)
	at org.apache.ibatis.executor.CachingExecutor.query(CachingExecutor.java:109)
	at org.apache.ibatis.executor.CachingExecutor.query(CachingExecutor.java:89)
	at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:147)
	... 4 more
```

## References
- 🎈vscode 정리
- 🎈2020.12.30