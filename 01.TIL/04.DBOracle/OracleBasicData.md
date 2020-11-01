[목차](#)
- [1. Character 형식](#1-character-형식)
  - [1.1 CHAR](#11-char)
  - [1.2 VARCHAR2(byte)](#12-varchar2byte)
  - [1.3 NCHAR](#13-nchar)
  - [1.4 NVARCHAR2](#14-nvarchar2)
  - [1.5 LONG](#15-long)
  - [1.6 CLOB](#16-clob)
  - [1.7 NCLOB](#17-nlcob)
- [2. Numberic](#2-NUMBERIC)
  - [2.1 NUMBER](#21-number)
- [3. DATE](#3-date)
  - [3.1 DATE](#31-date)
  - [3.2 TIMESTAMP](32-timestamp)
- [Reference](#reference)

# 1. Character 형식 
### 1.1 CHAR
- Character
- 기본 값은 바이트
- 고정 길이 문자 데이터
- 입력된 데이터의 크기와 무관하게 고정된 길이만큼 저장
- 저장 공간의 크기를 명시 ex) CHAR(10) 
 	- 최소 크기는 1byte
```sql
SELECT LENGTH ('한글') FROM dual; //길이:2
SELECT LENGTHB ('한글') FROM dual; //6BYTE
```
### 1.2 VARCHAR2(byte)
- Variable Character
- 가변 길이 문자 데이터
- 실제 입력된 데이터의 크기만큼 저장 공간 차지
- 최대 크기를 명시 ex) VARCHAR2(100)
	- 최소 크기는 1byte
- CHAR에 비해 검색속도가 느리다
- 최대 4000byte
 
### 1.3 NCHAR
 - National Character
 - 전세계적 언어
```sql
1. GENDER CHAR(2, CHAR) 
2. GENDER NCHAR(2) // 1번 선언보다 바람직한 데이터 타입과 바이트
```
### 1.4 NVARCHAR2
- National Variable Character
 - 전세계적 언어
 - 가변길이 데이터

### 1.5 LONG
- 2GB
- 주로 CLOB를 사용한다.
- 테이블 한 개의 컬럼만 생성 가능

### 1.6 CLOB
- 대용량 텍스트 데이터 타입(최대 4GB)
- LONG를 보완한 타입

### 1.7 NCLOB
- 대용량 텍스트 유니코드 데이터 타입(최대 4GB)

# 2. Numberic
### 2.1 NUMBER
NUMBER | 최대 38자리까지의 숫자 저장 가능|
|:-:|:-:|
NUMBER(n)|n자리까지 숫자 저장
NUMBER(n, m)|1. 소수점 m까지를 포함하는 최대 6자리의 숫자
||2. 소수점 m까지에서의 반올림
NUMBER(n, -m)|소수점 -m까지에서 반올림하는 최대 6자리의 숫자
NUMBER|NUMBER(38,\*)
NUMBER(\*,5)|NUMBER(38,5)

# 3. DATE
### 3.1 DATE
- 날짜와 시간을 저장하는 날짜형 데이터 타입
- BC 4712년 1월 1일 ~ AD 4712년 12월 31일까지의 날짜를 저장할 수 있다.
- 세기, 년도, 월, 일, 시간, 분, 초 데이터를 포함한다.
- DATE 타입으로, SYSDATE는 현재 날짜와 시간을 제공한다.

### 3.2 TIMESTAMP
- DATE형의 확장된 표시
- 밀리초 단위까지 표현 가능하다.

## Reference
- [뉴렉쳐 , 오라클(Oracle) SQL 강의 강좌](https://www.youtube.com/user/newlec1)
- 참고도서(책) : 데이터베이스
- 🎈2020.11.1

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)
