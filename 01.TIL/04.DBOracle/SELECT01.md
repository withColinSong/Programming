# [목차](#)
- [1.1 SELECT 형태](#11-select-형태)
- [1.2 기본 SELECT문](12-기본-select문)
  - [1.2.1 특정 컬럼만 선택해서 조회하는 SELECT문](121-특정-컬럼만-선택해서-조회하는-select문)
  - [1.2.2 모든 컬럼을 조회하는 SELECT문](#122-기본-select문)
  - [1.2.3 SQL문 작성 유의 사항](#123-sql문-작성-유의-사항)
- [1.3 컬럼명에 별칭 붙이기 (예명 : Alias)](#13-컬럼명에-별칭-붙이기-예명--alias-1)
- [1.4 테이블 관련 정보 확인 SQL문](#14-테이블-관련-정보-확인-sql문)
  - [1.4.1 TAB 테이블](#141-tab-테이블)
  - [1.4.2 DESC(DESCRIBE)를 활용한 테이블 정보확인](#142-descdescribe를-활용한-테이블-정보확인)
- [1.5 중복을 제거하는 DISTINCT](#15-중복을-제거하는-distinct-1)
- [1.6 컬럼값 계산하는 산술연산자](16-컬럼값-계산하는-산술연산자)
- [Reference](#reference)
  
    
<br>

|분류|용도|키워드|
|-|-|-|
|DCL(Data Control Language)|객체 제어|GRANT, REVOKE|
|DDL(Data Definition Language)|테이블 생성/수정/삭제|CREATE, ALTER, DROP, TRUNCATE|
|DML(Data Manipulation Language)|데이터 저장/수정/삭제|INSERT, UPDATE, DELETE|
|DQL(Data Query Language)|데이터 조회|SELECT|
|TCL(Transaction Control Language))|트랜잭션 제어|COMMIT, ROLLBACK|


# SELECT
- 데이블에 저장된 데이터를 조회하기 위한 명령어

## 1.1 SELECT 형태
```sql
SELECT {* | [ DISTINCT ] column [as alias] | 계산식 | 함수식 | … }
FROM table_name
[WHERE 컬럼명 비교연산자 비교값]
[ORDER BY 정렬할 컬럼명 정렬방식];
```
|키워드|형태
|-|-|
|DISTINCT|중복 행 제거 옵션|
|\* 또는 컬럼명|테이블 모든 컬럼 조회 하거나 해당 컬럼만 조회
|alias|조회된 컬럼에 대해서 다른 이름을 부여할 때 사용, 컬럼명 뒤에 as는 생략 가능
|table_name|조회 대상 테이블 명
|WHERE|조건절로 비교한 결과에 일치하는 행만 검색
|ORDER BY|정렬 순서를 정함, DESC(내림차순), ASC(오름차순, default로 생략 가능)

- 구문에서 [ ]는 생략이 가능한 구문, { }는 안의 내용 중 하나는 입력해야 한다는 의미

## 1.2 기본 SELECT문
```sql
SELECT * --SELECT절 : 컬럼선택
FROM emp; --from절 : 검색대상 테이블 선택
```

### 1.2.1 특정 컬럼만 선택해서 조회하는 SELECT문
```sql
SELECT 컬럼이름1, 컬럼이름2, 컬럼이름3, …
FROM 테이블이름;
```
- SELECT문 뒤에 원하는 컬럼이 여러 개 일 경우 ‘ , ’ 로 구분

### 1.2.2 모든 컬럼을 조회하는 SELECT문
```sql
SELECT *
FROM 테이블이름;
```

### 1.2.3 SQL문 작성 유의 사항
- SQL 문장은 대소문자를 구별하지 않는다.

- SQL 문장은 한 줄 또는 여러 줄에 입력될 수 있다.

- 일반적으로 키워드는 대문자로 입력한다.

- 다른 모든 단어, 즉 테이블 이름, 열 이름은 소문자로 입력을 권장.

- 가장 최근의 명령어 한 개가 SQL buffer 에 저장 된다.
	- `버퍼(buffer)` : 성능 향상을 목적으로 데이터를 저장하는 메모리
    
- SQL문 마지막 절의 끝에 ";" 를 기술하여 명령의 끝을 표시한다.



## 1.3 컬럼명에 별칭 붙이기 (예명 : Alias)
```sql
1. SELECT 컬럼명 별칭, 컬럼명2 별칭 FROM 테이블이름;
2. SELECT 컬럼명 AS 별칭, 컬럼명2 AS 별칭 FROM 테이블이름; //추천방법
3. SELECT 컬럼명 "별칭", 컬럼명2 “별칭” FROM 테이블이름;
```
- 이 별칭은 DB에 저장되어 있는 컬럼명이 완전히 바뀌는 것이 아니고 
SELECT 문을 이용하여 결과를 조회할 때만 원하는 컬럼명으로 보여지는 것.


## 1.4 테이블 관련 정보 확인 SQL문
### 1.4.1 TAB 테이블
- TAB 테이블은 table의 약자로 접속한 계정이 소유하고 있는 테이블의 정보를 알려주는 데이터 딕셔너리이다.
	- `데이터 딕셔너리` : Oracle 시스템에서 객체(테이블)에 대한 정보를 저장하는 곳으로 테이블에 대한 컬럼, 도메인, 제약조건에 대한 메타 데이터를 저장.
#### 해당 테이블 유저 확인
```sql
show USER; 
```
- 계정을 확인했으면 SELECT 구문으로 tab 을 조회하여 USER가 소유하고 있는 테이블을 확인
![](https://images.velog.io/images/withcolinsong/post/65281bc8-1199-4983-811c-b9b52ff62da2/image.png)
    
### 1.4.2 DESC(DESCRIBE)를 활용한 테이블 정보확인
```sql
DESC 테이블명 ;
```
- 테이블에 대한 정보를 확인하려면 DESC 구문
![](https://images.velog.io/images/withcolinsong/post/7d1c6412-a5de-47be-8bef-24475a5dddbf/image.png)


### 1.5 중복을 제거하는 DISTINCT
- 값이 중복된 행을 한개씩만 선택하고자 할 때 사용하는 키워드
```sql
SELECT DISTINCT 컬럼명, 컬럼명1, 컬럼명2
FROM 테이블이름;
```
![](https://images.velog.io/images/withcolinsong/post/c7aad228-9226-4f30-a0da-2dba028e3900/image.png)

### 1.6 컬럼값 계산하는 산술연산자
```sql
1. SELECT 컬럼명 + 컬럼명1 FROM 테이블명;
2. SELECT 컬럼명 - 컬럼명1 FROM 테이블명;
3. SELECT 컬럼명 * 컬럼명1 FROM 테이블명;
4. SELECT 컬럼명 / 컬럼명1 FROM 테이블명;
```
```sql
SELECT ename, sal, sal * 12
FROM emp;
```
![](https://images.velog.io/images/withcolinsong/post/fc177aef-4c1c-4927-8d6d-b3efe6f65559/image.png)

## Reference
- 테이블 자료 : Oracle - `emp 테이블` 
- 참고도서 : SQL활용 
- 🎈2020.10.28

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)
