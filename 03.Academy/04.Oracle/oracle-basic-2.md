# 목차

- [목차](#목차)
- [(시험보기 위해) 학습할 내용](#시험보기-위해-학습할-내용)
- [1. DBMS란?](#1-dbms란)
- [2. SQL의 목적에 따른 분류 ❌](#2-sql의-목적에-따른-분류-)
- [3. 계정 관리와 리소스](#3-계정-관리와-리소스)
  - [3.1. 사용자 생성](#31-사용자-생성)
  - [3.2. 사용자 패스워드 변경과 삭제 ❌](#32-사용자-패스워드-변경과-삭제-)
  - [3.3. 권한(privilege) 관리](#33-권한privilege-관리)
  - [3.4. 롤](#34-롤)
- [4. 테이블 생성](#4-테이블-생성)
- [5. 제약 조건](#5-제약-조건)

# (시험보기 위해) 학습할 내용

1. DBMS란?
2. 계정 관리와 리소스
3. SQL의 목적에 따른 분류
4. 테이블 생성
5. 제약 조건

# 1. DBMS란?

데이터베이스로 부터 데이터를:  

- `추출`
- `조작`
- `정의`
- `제어`

할 수 있도록 도와주는 데이터베이스 `전용 관리 프로그램`을 의미한다.  

# 2. SQL의 목적에 따른 분류 ❌

SQL은 Structured Query Language의 약어이다. RDBMS에게 질문하고 결과를 받기 위해 필요한 도구 정도로 알아두면 충분하다.  

SQL은 사용 목적에 따라서 다음과 같이 분류한다.  

|분류|용도|키워드|
|-|-|-|
|❌DCL(Data Control Language)|객체 제어|GRANT, REVOKE|
|✔️DDL(Data Definition Language)|테이블 생성/수정/삭제|CREATE, ALTER, DROP, TRUNCATE|
|✔️DML(Data Manipulation Language)|데이터 저장/수정/삭제|INSERT, UPDATE, DELETE|
|✔️DQL(Data Query Language)|데이터 조회|SELECT|
|✔️TCL(Transaction Control Language))|트랜잭션 제어|COMMIT, ROLLBACK|

DDL이란? ✏️
> 객체의 `생성`, `수정`, `삭제`등 데이터의 전체 구조를 정의하는 언어. 주로 DB 관리자 또는 설계자가 사용함.
DDL에서 CREATE는 무엇인가? ✏️
> `테이블`이나 인덱스, 뷰 등 다양한 `데이터베이스 객체`를 `생성`하는 구문
# 3. 계정 관리와 리소스

DBMS에 접속하기 위해서 입력했던 id와 비밀번호를 떠올려보자. 지금까지 system 계정으로 접속을 하였다.  
계정에는 크게 두 가지가 존재한다.  

1. 관리자 계정  
    데이터베이스의 `생성`과 `관리`를 담당하는 계정이며 `모든 권한`과 책임을 가지고 있다.  
2. 사용자 계정
    데이터베이스에 대한 질의(query), 갱신(modify), 보고서 작성 등의 작업을 수행할 수 있는 계정으로, `업무`에 필요한 `최소한의 권한`만 가지는 것을 `원칙`으로 한다.  

## 3.1. 사용자 생성

사용자를 생성하기 위한 문장은 다음과 같다.  

```sql
CREATE USER 사용자_이름(required) IDENTIFIED BY 패스워드(required);
```

이렇게 하면 계정이 생성된다. 사용자 정보는 다음과 같이 조회가 가능하다.  

```sql
SELECT * FROM ALL_USERS;
SELECT * FROM DBA_USERS;
SELECT * FROM DBA_OBJECTS;
```
## 3.2. 사용자 패스워드 변경과 삭제 ❌

사용자 정보를 변경해보자.  

```sql
ALTER USER 사용자_이름 IDENTIFIED BY 새로운_비밀번호;
```

사용자를 삭제해보자.  

```sql
DROP USER 삭제할_사용자_이름;
```

## 3.3. 권한(privilege) 관리

사용자가 데이터베이스에서 행할 수 있는 것들을 의미한다.  
큰 분류로 분류하면 다음과 같다.  

- 사용자 관리
- 접속 관리
- 테이블 관리
- 인덱스 관리
- 롤 관리
- 그 외

권한을 부여하기 위한 문장은 다음과 같다.  

```sql
GRANT 권한(혹은 롤) TO 사용자_이름;
```

권한을 회수하기 위한 문장은 다음과 같다.  

```sql
REVOKE 권한(혹은 롤) FROM 사용자_이름
```

## 3.4. 롤

롤은 여러 권한을 하나의 이름으로 묶어둔 것이라고 생각하면 쉽다.  
사전 정의된 롤은 크게 세 가지가 존재하는데 다음과 같다.  

- `CONNECT`: 사용자가 데이터 베이스에 `접속` 가능하도록 하기위한 CREATE SESSION `권한`이 있는 ROLE
- `RESOURCE`: CREATE 구문을 통해 `객체`를 `생성`할 수 있는 `권한`과 INSERT, UPDATE, DELETE 구문을 사용할 수 있는 권한을 모아 놓은 ROLE.
- `DBA`: 대부분의 권한을 가지고 있는 롤

일반적으로 DB를 사용하기 위해서는 다음과 같이 사용자에게 권한을 부여해줄 수 있다.  

```sql
GRANT CONNECT, RESOURCE TO 사용자_이름;
```

# 4. 테이블 생성

```sql
CREATE TABLE 테이블_이름 (
    칼럼_이름1 데이터_타입 제약조건,
    칼럼_이름2 데이터_타입 제약조건,
    ...,
    칼럼_이름N 데이터_타입 제약조건
);
```

# 5. 제약 조건

[제약 조건(constraint)](https://github.com/withColinSong/Programming/blob/master/03.Academy/04.Oracle/CONSTRAINTEx.md)


### Reference
- [원치호강사님](https://github.com/hyeyoom/kh-lecture-2020/blame/master/database/3.%20%EC%A1%B0%ED%9A%8C%20-%20SELECT.md)
- `Day24` `20.10.26`
