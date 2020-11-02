[목차](#목차)
- [1. ORDER BY](#1-order-by)
  - [1.1 데이터형별 기준](#11-데이터형별-기준)
  - [1.2 ORDER BY Example](#12-order-by-example)
- [2. 연결 연산자 ||](#2-연결-연산자-||)
- [Reference](#reference)

# ORDER BY
```sql
SELECT * 
FROM 테이블명
ORDER BY 컬럼명 정렬방식(ASC, DESC);
```
- 특정컬럼의 데이터를 중심으로 오름차순, 내림차순으로 정렬하는 기능
- ORDER BY절은 쿼리문의 맨 끝에 위치된다.
- 정렬방식을 명시하지 않으면 오름차순이 기본값이다.
- ORDER BY를 적용할 컬럼의 표현은 컬럼명, 컬럼별칭, 컬럼순번 총 3가지로 표현할 수 있다.

## 데이터형별 기준
구분|오름차순(ASC)|내림차순(DESC)
|:-:|:-:|:-:|
숫자|작은 값 부터 정렬|큰 값부터 정렬
문자|사전 순서대로 정렬|사전 순서 반대로 정렬
날짜|빠른 날짜 순서로 정렬|늦은 날짜 순서로 정렬
NULL|가장 마지막에 나옴|가장 먼저 나옴


## ORDER BY Example
#### 1. EMP 테이블에서 연봉(sal)을 오름차순으로 정렬하여 조회하기
```sql
SELECT * 
FROM emp 
ORDER BY SAL ASC; //ASC 생략 가능
```
![](https://images.velog.io/images/withcolinsong/post/04f6afd9-3802-43b4-b2cd-a0ffbc649336/image.png)

#### 2. EMP 테이블에서 연봉(sal)을 내림차순으로 정렬하여 조회하기
```sql
SELECT * 
FROM emp 
ORDER BY SAL DESC;
```
![](https://images.velog.io/images/withcolinsong/post/4f739221-c612-4bfa-9d9e-820300de17b6/image.png)

#### 3. ORDER BY절을 컬럼 별칭으로 표현하기
```sql
SELECT ename 이름, job 직업 , sal 연봉 
FROM emp
ORDER BY sal DESC;
```
![](https://images.velog.io/images/withcolinsong/post/06409c44-d68c-4ea0-aa5b-822c6725d897/image.png)

#### 4. ORDER BY절을 컬럼 순번으로 표현하기
```sql
- 연봉이 높은 순서대로 정렬하기

SELECT * 
FROM emp
ORDER BY 6 DESC ; //6번째 : sal 컬럼
```
![](https://images.velog.io/images/withcolinsong/post/33b422bb-fa3e-4cda-a92b-6df12714dd41/image.png)

# 연결 연산자 ||
```sql
SELECT 컬럼명 || '문자 리터럴' || 컬럼명
FROM 테이블명
```
```sql
SELECT ename || ' 연결 '||sal
FROM emp;
```
![](https://images.velog.io/images/withcolinsong/post/070da43c-e341-4575-9adb-57174f49f588/image.png)

- `Java`로 표현한다면 아래 코드로 표현할 수 있다.

```java
System.out.println("문자" + "연결")
```

## Reference
- 테이블 자료 : Oracle - `EMP 테이블` 
- 참고도서(책) : SQL활용 + 실습 후 정리
- 🎈2020.11.02
