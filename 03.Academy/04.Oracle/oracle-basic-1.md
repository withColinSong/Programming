- [목차](#목차)

- [1. SELECT](#1-select)
  - [1.1. 실습 전 확인사항](#11-실습-전-확인사항)
  - [1.2. 데이터를 조회하는 방법](#12-데이터를-조회하는-방법)
    - [1.2.1. 셀렉션](#121-셀렉션)
    - [1.2.2. 프로젝션](#122-프로젝션)
    - [1.2.3. 조인](#123-조인)
  - [1.3. 조회 쿼리의 기본 - SELECT 절, FROM 절](#13-조회-쿼리의-기본---select-절-from-절)
    - [1.3.1. 전체 열을 조회](#131-전체-열을-조회)
    - [1.3.2. 일부 열을 조회](#132-일부-열을-조회)
  - [1.4. 중복 제거 - DISTINCT](#14-중복-제거---distinct)
    - [1.4.1. 열이 하나인 경우](#141-열이-하나인-경우)
    - [1.4.2. 열이 두 개 이상인 경우](#142-열이-두-개-이상인-경우)
    - [1.4.3. 별칭(alias) - AS](#143-별칭alias---as)
    - [1.4.4. 정렬 - ORDER BY](#144-정렬---order-by)
- [2. WHERE 절과 연산자](#2-where-절과-연산자)
  - [2.1. WHERE 절](#21-where-절)
  - [2.2. AND, OR](#22-and-or)
  - [2.3. 그 외 연산자](#23-그-외-연산자)
    - [2.3.1. LIKE](#231-like)
    - [2.3.1. IS NULL](#231-is-null)
    - [2.3.2. 집합연산](#232-집합연산)
- [3. Oracle functions](#3-oracle-functions)
  - [3.1. 문자 처리](#31-문자-처리)
    - [3.1.1. 대소문자 처리](#311-대소문자-처리)
    - [3.1.2. 문자열 길이](#312-문자열-길이)
    - [3.1.3. 문자열 추출 및 위치](#313-문자열-추출-및-위치)
    - [3.1.4. 문자열 치환](#314-문자열-치환)
    - [3.1.5. 문자열 패딩](#315-문자열-패딩)
    - [3.1.6. 문자열 연결](#316-문자열-연결)
  - [3.2. 숫자 처리](#32-숫자-처리)
    - [3.2.1. ROUND](#321-round)
    - [3.2.2. TRUNC](#322-trunc)
    - [3.2.3. CEIL, FLOOR](#323-ceil-floor)
    - [3.2.4. MOD](#324-mod)
  - [3.3. 날짜 처리](#33-날짜-처리)
    - [3.3.1 N개월 이후 날짜 구하기](#331-n개월-이후-날짜-구하기)
    - [3.3.2. 개월 수 차이 구하기](#332-개월-수-차이-구하기)
    - [3.3.3. 돌아오는 요일, 마지막 일수](#333-돌아오는-요일-마지막-일수)
  - [3.4. 형변환 함수](#34-형변환-함수)
    - [3.4.1. 날짜,숫자를 문자로 변환](#341-날짜숫자를-문자로-변환)
    - [3.4.2. 문자를 날짜로 변환](#342-문자를-날짜로-변환)
  - [3.5. NULL 처리](#35-null-처리)
    - [3.5.1. NVL](#351-nvl)
    - [3.5.2. NVL2](#352-nvl2)
  - [3.6. 분기 처리](#36-분기-처리)
- [4. 복수행 함수, 그룹화](#4-복수행-함수-그룹화)
  - [4.1. 다중행 함수](#41-다중행-함수)
    - [4.1.1. 합계 - SUM](#411-합계---sum)
    - [4.1.2. 칼럼(데이터) 개수 - COUNT](#412-칼럼데이터-개수---count)
    - [4.1.3. 평균 값 - AVG](#413-평균-값---avg)
  - [4.2. 그룹화](#42-그룹화)
  - [4.3. HAVING 절 - 조건부 그룹화](#43-having-절---조건부-그룹화)
- [5. join](#5-join)
  - [5.1. 조인](#51-조인)
    - [5.1.1. 카테시안 곱](#511-카테시안-곱)
  - [5.2. 조인 종류](#52-조인-종류)
    - [5.2.1. 등가 조인](#521-등가-조인)
    - [5.2.2. 비등가 조인](#522-비등가-조인)
    - [5.2.3. 자체 조인](#523-자체-조인)
    - [5.2.4. 외부 조인](#524-외부-조인)
- [6. 서브쿼리](#6-서브쿼리)
  - [6.1. 서브쿼리?](#61-서브쿼리)
  
# 1. SELECT

데이터 조회에 가장 기본적인 `SELECT`문을 학습한다.  

## 1.1. 실습 전 확인사항

우리가 세팅한 환경에는 직원을 나타내는 employee 테이블과 부서를 나타내는 department 테이블이 존재한다.  

우선 emplyee 테이블은 다음과 같다.  

|column name|column desc|type|description|
|-|-|-|-|
|id|직원번호|NUMBER|emplyee 테이블의 기본키|
|name|직원 이름|VARCHAR2(32)|32글자 제한이 있는 문자열|
|job|직무|VARCHAR2(8)|8글자 제한이 있는 문자열|
|manager_id|매니저의 직원번호|NUMBER|employee를 나타내는 외래키|
|hired_date|입사일|TIMESTAMP|날짜 데이터|
|salary|급여|FLOAT|소수점 데이터|
|commission|인센티브|FLOAT|소수점 데이터|
|department_id|부서 번호|NUMBER|department를 나타내는 외래키|

그 다음은 부서를 나타내는 테이블이다.  

|column name|column desc|type|description|
|-|-|-|-|
|id|부서번호|NUMBER|department 테이블의 기본키|
|department_name|부서명|VARCHAR2(16)|16글자 제한이 있는 문자열|
|location|부서위치|VARCHAR2(16)|16글자 제한이 있는 문자열|

## 1.2. 데이터를 조회하는 방법

데이터 조회에는 크게 세 가지 방법이 존재한다.  

- 셀렉션(selection)
- 프로젝션(projection)
- 조인(join)

### 1.2.1. 셀렉션

셀렉션은 행을 선택하는 방식을 의미한다. 가령 다음과 같다.  
다음 SQL을 실행시켜보자.  

```sql
> SELECT * FROM employee;
```

결과는 다음과 같다.  

| ID | COMMISSION | HIRED_DATE | JOB | NAME | SALARY | DEPARTMENT_ID | MANAGER_ID |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| 2 | 10 | 2020-10-11 05:18:51.552553 | design | 주호민 | 1000 | 1 | NULL |

위와 같은 경우 전체 테이블을 조회한다.  
다음과 같이 특정 직원의 이름으로 검색하고 싶다면?  

```sql
> SELECT * FROM employee WHERE name = '주호민';
```

### 1.2.2. 프로젝션

셀렉션이 `행(row)`을 선택하는 것이였다면 프로젝션은 `열(column)`을 선택하는 방식을 의미한다.  
직원 테이블에서 직원의 이름과 입사일만 추출하고 싶다면 다음과 같이 한다.  

```sql
> SELECT name, hired_date FROM employee;
```

결과는 다음과 같다.  

| NAME | HIRED_DATE |
| :--- | :--- |
| 주호민 | 2020-10-11 05:18:51.552553 |

참고로 특정 조건을 만족하는 행들을 선택하고, 추출된 행들에서 특정한 열만 보고 싶다면 다음과 같이 하면 된다.  

```sql
> SELECT name, hired_date FROM employee WHERE name = '주호민';
```

이렇게 하면 다음과 같은 동작을 기대할 수 있다.  

1. `주호민`이라는 이름을 가진 직원의 행을 추출한다.
2. 이 행에서 이름과 입사일만 추출한다.

이렇게 하면 주호민이라는 이름을 가진 레코드에서 이름과 입사일만 추출해서 볼 수 있다.  

### 1.2.3. 조인

두 개 이상의 테이블을 연결해 하나의 테이블처럼 조회하는 방식이다. 물론 조인의 결과로 나온 테이블은 실제로 존재하는 것이 아니다.  

직원테이블과 부서테이블을 조인하여 특정 부서에 근무중인 직원만 추출하고 싶다면 다음과 같이 하면 된다.  

```sql
SELECT e.*
  FROM employee e
  JOIN department d 
       ON e.DEPARTMENT_ID = d.ID
 WHERE d.DEPARTMENT_NAME = 'design'
```

## 1.3. 조회 쿼리의 기본 - SELECT 절, FROM 절

SELECT 문(select statement)은 DB에 보관된 데이터를 조회하는데 사용한다.  

다음 SELECT 문을 살펴보자.  

```sql
SELECT foo FROM bar JOIN boo WHERE x = y;
```

이 문장은 다음과 같은 절(clause)들로 구성이 되어 있다.  

- WHERE x = y
- SELECT foo
- FROM bar
- JOIN boo

여기서는 SELECT 절과 FROM 절을 살펴볼 것이다. 우선 SELECT 문장을 일반화 시켜서 기억해두자.  

```sql
SELECT [col 1], [col 2], ..., [col n]
  FROM table_name
```

|키워드|요소|설명|
|-|-|-|
|SELECT|조회할 열들|조회할 열을 지정한다. 애스터리스크(*)를 사용하면 전체를 의미|
|FROM|조회할 테이블|FROM 조회할 테이블을 지정한다.|

### 1.3.1. 전체 열을 조회

전체 열을 조회하려면 애스터리스크(*)를 사용하면 된다.  

```sql
SELECT * FROM employee;
```

### 1.3.2. 일부 열을 조회

일부 열을 조회하려면 칼럼 이름을 지정해주면 된다.

```sql
SELECT name, hired_date FROM employee;
```

## 1.4. 중복 제거 - DISTINCT

열의 중복된 값들을 제거하기 위해 사용한다.  
테이블에 값이 다음과 같이 저장되어 있다고 가정해보자.  

| ID | COMMISSION | HIRED_DATE | JOB | NAME | SALARY | DEPARTMENT_ID | MANAGER_ID |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| 4 | 10 | 2020-10-11 20:52:48.548930 | design | 주호민 | 1000 | 1 | NULL |
| 5 | 10 | 2020-10-11 20:52:48.548930 | programmer | 이병건 | 1000 | 2 | NULL |
| 6 | 10 | 2020-10-11 20:52:48.548930 | programmer | 이병건 | 1000 | 3 | NULL |
| 7 | 10 | 2020-10-11 20:52:48.548930 | programmer | 주호민 | 1000 | 2 | NULL |
| 8 | 10 | 2020-10-11 20:52:48.548930 | webdev | 주호민 | 1000 | 3 | NULL |

### 1.4.1. 열이 하나인 경우

위 테이블에서 departmenet_id의 중복을 해보자.  

```sql
SELECT DISTINCT DEPARTMENT_ID FROM employee;
```

이렇게 하면 직원이 어느 부서에 있는지 모아서 볼 수 있다.  
숫자가 불편해서 이름을 같이 보고 싶다면 다음과 같이 하면 된다.  

```sql
SELECT DISTINCT e.DEPARTMENT_ID, d.DEPARTMENT_NAME
  FROM employee e
  JOIN department d on e.DEPARTMENT_ID = d.ID;
```

### 1.4.2. 열이 두 개 이상인 경우

선택된 열이 두 개 이상인 경우에 어떤 동작을 보이는지 알아보자.  

```sql
SELECT DISTINCT job, department_id FROM employee;
```

결과는 다음과 같다.  

| JOB | DEPARTMENT_ID |
| :--- | :--- |
| design | 1 |
| programmer | 2 |
| programmer | 3 |
| webdev | 3 |

job 칼럼이 여러번 출력되고 있다.  

### 1.4.3. 별칭(alias) - AS

다음과 같이 부서에 몇 명이 있는지 알아내보자.  


```sql
SELECT d.DEPARTMENT_NAME, count(*)
FROM employee e
         JOIN department d ON e.DEPARTMENT_ID = d.ID
GROUP BY d.DEPARTMENT_NAME
```

결과를 살펴보자.  

| DEPARTMENT\_NAME | COUNT\(\*\) |
| :--- | :--- |
| frontend development | 2 |
| backend development | 2 |
| design | 1 |

여기서 보면 열의 이름이 `count(*)`인 것을 알 수 있다. 이와 같이 열의 이름은 연산식이 그대로 출력되어 직관적이지 않은 것을 알 수 있다.  

이 때 사용하는 것이 바로 별칭이다. 별칭을 지정하면 직관적인 이름을 지정해줄 수 있다.  

```sql
SELECT d.DEPARTMENT_NAME, count(*) AS 사원수
FROM employee e
         JOIN department d ON e.DEPARTMENT_ID = d.ID
GROUP BY d.DEPARTMENT_NAME
```

결과를 살펴보자.

| DEPARTMENT\_NAME | 사원수 |
| :--- | :--- |
| frontend development | 2 |
| backend development | 2 |
| design | 1 |

이렇게 하면 부서 별 사원수를 나타내는 정보라는 것을 한 눈에 파악할 수 있게 된다.  

이제 일반화 시켜서 기억해보자. 네 가지 방법이 존재하는데 마지막 방법만 기억하면 된다. 이유는 뒤에서 설명한다.  

|예시|설명|
|-|-|
|연산식 별칭|연산식 [공백] 별칭|
|연산식 "별칭"|연산식 [공백] "별칭". 유의할 점은 큰 따옴표를 사용함|
|연산식 AS "별칭"|연산식 AS "별칭". 유의할 점은 큰 따옴표를 사용함|
|연산식 AS 별칭|연산식 AS 별칭. 큰 따옴표를 사용하지 않음|

마지막 방법을 가장 많이 사용하는 이유는 다음과 같다.  

1. AS를 사용하면 어떤 별칭을 지정했는지 구분하기 편하다. (도구 지원)
2. 개발 시 문자열 처리가 편하다.

### 1.4.4. 정렬 - ORDER BY

문장의 가장 마지막에 정렬을 위한 ORDER BY 절을 사용한다.  
사용 방식은 다음과 같다.  

```sql
  SELECT [col 1], [col 2], ..., [col n]
    FROM table_name
ORDER BY [col...] [opt]
```

정렬하려는 열과 정렬 방식을 지정할 수 있다. 정렬 방식은 두 가지가 존재한다.  

- ASC: 오름차순. 기본값
- DESC: 내림차순

참고로 정렬은 추가적인 코스트가 발생하므로 유의해서 사용해야한다.  

# 2. WHERE 절과 연산자

WHERE 절은 데이터를 가져오기 위한 조건을 지정할 수 있게 해준다. 이 때 조건을 지정하기 위해 연산자가 필요하다.  

## 2.1. WHERE 절

WHERE 절을 사용하기 위한 형식은 다음과 같다.  

```sql
  SELECT [col 1], [col 2], ..., [col n]
    FROM table_name
   WHERE [condition]
```

직원 테이블에서 이름이 `주호민`인 사람을 찾아보자.  

```sql
SELECT * FROM employee WHERE name = '주호민';
```

조건인 name = '주호민'이 true인 모든 행을 선택해서 반환한다.  

## 2.2. AND, OR

조건식을 여러 개 지정할 때 적합한 연산자가 AND와 OR이다. 프로그래밍에서 등장하는 그 AND와 OR 연산이 맞다.  

가령 2020년 10월에 입사한 디자인팀 직원을 조회하고 싶다면 다음과 같이 쿼리를 작성하면 된다.  

```sql
SELECT e.*
  FROM EMPLOYEE e
         JOIN DEPARTMENT D ON D.ID = e.DEPARTMENT_ID
 WHERE d.DEPARTMENT_NAME = 'design'
         AND TO_CHAR(e.HIRED_DATE, 'YYYY-MM') = '2020-10';
```

## 2.3. 그 외 연산자

간단한 친구들은 표로 ~~때운다~~ 설명한다.  

|연산자 타입|키워드|예제|설명|
|-|-|-|-|
|산술|`+` `-` `*` `/`||가감승제. 필요할까..?|
|비교|`>` `>=` `<` `<=`||대소비교. 필요할까..?|
|등가비교|`!=` `<>` `^=`||xor|
|논리부정|`NOT`|WHERE NOT name = '주호민'|이름이 주호민이 아닌 사람|
|포함|`IN`|WHERE job IN ('programmer', 'manager')|직책이 프로그래머거나 매니저|
|범위|`BETWEEN [조건1] AND [조건2]`|WHERE salary BETWEEN 1000 AND 2000|급여가 1000과 2000사이|

### 2.3.1. LIKE

텍스트 칼럼에서 문자열을 검색할 때 사용한다. 보통 게시판에서 검색 기능을 구현할 때 사용하는데, 사실 성능 때문에 고민을 해봐야 한다. 레코드 수가 많아지면 성능이 매우 저하되기 때문에 다른 방법을 사용해야한다. 하지만 여기선 논외로한다.  

LIKE를 사용해보기에 앞서 사용할 수 있는 와일드카드에 대해 알아보자.  

|종류|설명|
|-|-|
|`_`|종류에 상관 없이 한 개의 문자|
|`%`|길이와 종류와 상관 없이 모든 문자|

이는 쿼리를 작성해보는 것이 이해에 빠르다.  

직원 중 `이`씨 성을 가진 외자이름 직원을 검색한다고 가정해보자.  

```sql
SELECT * FROM EMPLOYEE WHERE name LIKE '이_';
```

결과는 다음과 같다.  

| ID | COMMISSION | HIRED\_DATE | JOB | NAME | SALARY | DEPARTMENT\_ID | MANAGER\_ID |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| 6 | 10 | 2020-10-11 20:52:48.548930 | programmer | 이적 | 1000 | 3 | NULL |

직원 중 `이`씨 성을 가진 직원을 검색한다고 가정해보자.  

```sql
SELECT * FROM EMPLOYEE WHERE name LIKE '이%';
```

결과는 다음과 같다.

| ID | COMMISSION | HIRED\_DATE | JOB | NAME | SALARY | DEPARTMENT\_ID | MANAGER\_ID |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| 5 | 10 | 2020-10-11 20:52:48.548930 | programmer | 이병건 | 1000 | 2 | NULL |
| 6 | 10 | 2020-10-11 20:52:48.548930 | programmer | 이적 | 1000 | 3 | NULL |

### 2.3.1. IS NULL

`IS NULL` 연산자는 값이 없는 칼럼을 조회한다. 칼럼에 `NOT NULL` 제약 조건이 없는 경우에 쓰면 된다. `NN` 제약이 걸려 있는 곳에 굳이 쓸 필요가 없다.  

직원 중 매니저가 없는 경우를 조회해보자.  

```sql
SELECT * FROM EMPLOYEE WHERE manager_id IS NULL;
```

결과는 다음과 같다.  


| ID | COMMISSION | HIRED\_DATE | JOB | NAME | SALARY | DEPARTMENT\_ID | MANAGER\_ID |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| 4 | 10 | 2020-10-11 20:52:48.548930 | design | 주호민 | 1000 | 1 | NULL |
| 5 | 10 | 2020-10-11 20:52:48.548930 | programmer | 이병건 | 1000 | 2 | NULL |
| 6 | 10 | 2020-10-11 20:52:48.548930 | programmer | 이적 | 1000 | 3 | NULL |
| 7 | 10 | 2020-10-11 20:52:48.548930 | programmer | 주호민 | 1000 | 2 | NULL |
| 8 | 10 | 2020-10-11 20:52:48.548930 | webdev | 주호민 | 1000 | 3 | NULL |

### 2.3.2. 집합연산

관계형 데이터 모델은 집합론에서 파생된 개념이다. 우리가 앞서 공부한 조회는 실행의 결과로 결과셋(result set)을 반환하는 것을 확인하였다. 이 결과셋의 합집합, 차집합, 교집합을 구하는 연산을 학습해보자.  

(1) UNION

`UNION`은 결과셋을 합집합으로 묶어준다. `UNION ALL` 키워드와 구분되는 점은 `UNION ALL`은 중복제거를 하지 않는다. (엄밀한 정의의 집합과는 거리가 있지만)

아주 간단하게 다음 쿼리 두 개를 읽고 결과를 예측해보자.  

```sql
SELECT * FROM EMPLOYEE UNION SELECT * FROM EMPLOYEE;
SELECT * FROM EMPLOYEE UNION ALL SELECT * FROM EMPLOYEE;
```

각각의 결과는 다음과 같다.  

`UNION`의 결과

| ID | COMMISSION | HIRED\_DATE | JOB | NAME | SALARY | DEPARTMENT\_ID | MANAGER\_ID |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| 4 | 10 | 2020-10-11 20:52:48.548930 | design | 주호민 | 1000 | 1 | NULL |
| 5 | 10 | 2020-10-11 20:52:48.548930 | programmer | 이병건 | 1000 | 2 | NULL |
| 6 | 10 | 2020-10-11 20:52:48.548930 | programmer | 이적 | 1000 | 3 | NULL |
| 7 | 10 | 2020-10-11 20:52:48.548930 | programmer | 주호민 | 1000 | 2 | NULL |
| 8 | 10 | 2020-10-11 20:52:48.548930 | webdev | 주호민 | 1000 | 3 | NULL |


`UNION ALL`의 결과

| ID | COMMISSION | HIRED\_DATE | JOB | NAME | SALARY | DEPARTMENT\_ID | MANAGER\_ID |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| 4 | 10 | 2020-10-11 20:52:48.548930 | design | 주호민 | 1000 | 1 | NULL |
| 5 | 10 | 2020-10-11 20:52:48.548930 | programmer | 이병건 | 1000 | 2 | NULL |
| 6 | 10 | 2020-10-11 20:52:48.548930 | programmer | 이적 | 1000 | 3 | NULL |
| 7 | 10 | 2020-10-11 20:52:48.548930 | programmer | 주호민 | 1000 | 2 | NULL |
| 8 | 10 | 2020-10-11 20:52:48.548930 | webdev | 주호민 | 1000 | 3 | NULL |
| 4 | 10 | 2020-10-11 20:52:48.548930 | design | 주호민 | 1000 | 1 | NULL |
| 5 | 10 | 2020-10-11 20:52:48.548930 | programmer | 이병건 | 1000 | 2 | NULL |
| 6 | 10 | 2020-10-11 20:52:48.548930 | programmer | 이적 | 1000 | 3 | NULL |
| 7 | 10 | 2020-10-11 20:52:48.548930 | programmer | 주호민 | 1000 | 2 | NULL |
| 8 | 10 | 2020-10-11 20:52:48.548930 | webdev | 주호민 | 1000 | 3 | NULL |

중복이 제거된 것을 볼 수 있다.  

고민해볼 것

> 같은 테이블 끼리만 가능할까?
# 3. Oracle functions

오라클에서 제공하는 내장 함수에 대해서 다룬다. 내장 함수는 오라클 외에도 다른 벤더들도 제공하는 내장 함수들이 존재한다. 이는 각 벤더사의 매뉴얼을 참고할 것.

참고로 어떤 RDBMS가 되었든 간에 내장 함수를 사용하는데 있어서 충분한 고민이 필요하다. 비즈니스 로직에 들어가야 할 코드가 SQL로 오는 경우를 실무에서 꽤 자주 볼 수 있는데, 이는 위험하다. 또한 데이터셋이 커지는 경우 문제가 발생할 수 있다.  

## 3.1. 문자 처리

공부할 함수들을 요약해서 살펴보자.  

|함수|설명|
|-|-|
|UPPPER|모든 문자를 대문자로 변환|
|LOWER|모든 문자를 소문자로 변환|
|INITCAP|첫 글자를 대문자로|
|LENGTH|문자열 길이를 반환|
|SUBSTR(origin,begin[,size])|문자열 substring|
|INSTR|문자 위치 반환|
|REPLACE|문자 치환|
|LPAD,RPAD|문자 패딩 설정|
|CONCAT|문자열 연결|

많은데 별 내용 없음.  

### 3.1.1. 대소문자 처리

|함수|설명|
|-|-|
|UPPPER|모든 문자를 대문자로 변환|
|LOWER|모든 문자를 소문자로 변환|
|INITCAP|첫 글자를 대문자로|

문자열의 대소문자를 처리한다. 물론 문자를 다루는 타입의 칼럼이여야 한다.  

별 내용 없으니 딱 하나만 살펴보자. 직원 테이블의 job 칼럼의 문자열을 대문자로 뽑아보자.  

```sql
SELECT upper(job) FROM EMPLOYEE
```

간단하다.  

### 3.1.2. 문자열 길이

|함수|설명|
|-|-|
|LENGTH|문자열 길이를 반환|

문자열의 길이를 반환한다. 직원 테이블의 job 칼럼의 문자열 길이를 출력해보자.  

```sql
SELECT DISTINCT job, LENGTH(job) FROM employee;
```

### 3.1.3. 문자열 추출 및 위치

|함수|설명|
|-|-|
|SUBSTR(origin,begin[,size])|문자열 substring|
|INSTR|문자 위치 반환|

`design`이라는 문자열의 세 번째 글자부터 끝까지 추출하면 `sign`이라는 단어가 나온다. 쿼리로 살펴보자.  

```sql
SELECT substr(job, 3) FROM employee WHERE job = 'design';
```

여기서 주의할 점이 있는데 프로그래밍에서 문자열의 세 번째 문자의 인덱스는 2인데 SQL에서는 그렇지 않다.  

이번에는 `design`이라는 단어의 s 위치를 추출해보자.  

```sql
SELECT instr(job, 's') FROM employee WHERE job = 'design';
```

참고로 대소문자를 구분하며 없는 경우 0이다. 자바에서 문자열의 `indexOf`는 없는 경우 -1을 반환하는데 이런 것이 차이점이다.  

### 3.1.4. 문자열 치환

|함수|설명|
|-|-|
|REPLACE|문자 치환|

`design`이라는 단어를 `designer`로 치환해보자.  

```sql
SELECT replace(job, 'design', 'designer') FROM EMPLOYEE;
```

### 3.1.5. 문자열 패딩

|함수|설명|
|-|-|
|LPAD,RPAD|문자 패딩 설정|

문자열에 지정한 특정 문자를 집어넣을 수 있다.  

```sql
SELECT RPAD('121212-', 14, '*') FROM DUAL;
```

### 3.1.6. 문자열 연결

|함수|설명|
|-|-|
|CONCAT|문자열 연결|

```sql
SELECT concat('str1', 'str2') as result FROM DUAL;
```

## 3.2. 숫자 처리

|함수|설명|
|-|-|
|ROUND|특정 위치 반올림|
|TRUNC|특정 위치 버림|
|CEIL|천장 함수|
|FLOOR|바닥 함수|
|MOD|모듈러|

### 3.2.1. ROUND

```sql
SELECT round(3.1415926535) FROM DUAL;
```

결과는 3

### 3.2.2. TRUNC

```sql
SELECT trunc(3.1415926535, 2) FROM DUAL;
```

결과는 3.14. 
참고

- 생략 시: 모두 버림
- 음수: 정수 부분

### 3.2.3. CEIL, FLOOR

```sql
SELECT ceil(1233.1415926535) FROM DUAL;
SELECT floor(-4.124) FROM DUAL;
```

### 3.2.4. MOD

```sql
SELECT mod(15, 2) FROM DUAL;
```

결과는 1

## 3.3. 날짜 처리

날짜 조회는 SQL에서 매우 중요한 부분 중 하나이다. 날짜 처리에서 지원되는 연산자를 정리해보자.  

|연산자|설명|
|-|-|
|날짜데이터 + 숫자|날짜데이터에 숫자만큼의 일수 이후|
|날짜데이터 - 숫자|날짜데이터에 숫자만큼의 일수 이전|
|날짜 - 날짜|두 날짜의 일수 차이|

```sql
SELECT SYSDATE AS now,
       SYSDATE - 1 AS yesterday,
       SYSDATE + 1 AS tomorrow,
       (SYSDATE + 1) - (SYSDATE -1) AS offset
FROM DUAL;
```

이제 함수를 정리해보자.  

### 3.3.1 N개월 이후 날짜 구하기

`ADD_MONTHS` 함수를 사용하면 된다. 사용 형식은 다음과 같다.  

```sql
ADD_MONTHS(날짜,개월 수)
```

실제로 사용해보자.  

```sql
SELECT add_months(SYSDATE, 3) FROM DUAL;
```

결과는 `2021-01-13 02:19:39`이다.  

### 3.3.2. 개월 수 차이 구하기

```sql
MONTHS_BETWEEN(날짜1,날짜2)
```

### 3.3.3. 돌아오는 요일, 마지막 일수

현재를 기준으로 돌아오는 월요일을 구하고 싶다면 NEXT_DAY 함수를 사용하자.  

```sql
NEXT_DAY(기준일, '요일')
SELECT next_day(SYSDATE, '월요일') FROM DUAL;
```

참고로 시스템이 영어를 사용하고 있다면 `MON`을 문자열로 넣어야 한다. 자신의 시스템이 어떤 언어를 사용하는지 알고 싶다면 다음과 같은 쿼리를 사용해보자.  

```sql
SELECT value
FROM NLS_SESSION_PARAMETERS
WHERE PARAMETER = 'NLS_DATE_LANGUAGE';
```

기준일이 포함된 달의 마지막 날짜는 다음과 같이 구한다.  

```sql
SELECT last_day(SYSDATE) FROM DUAL;
```

## 3.4. 형변환 함수

프로그래밍을 공부할 때 했던 그 친구를 떠올리면 쉽다. 날짜를 문자열로, 문자열을 날짜로, 숫자-문자 변환 등이 있다. 실무에서 자주 보이는 친구는 TO_CHAR, TO_DATE 정도가 될 것이다.  

### 3.4.1. 날짜,숫자를 문자로 변환

사용자가 문자로 입력한 날짜 등을 검색할 때 사용되곤 한다. 안티패턴이지만..  

```sql
TO_CHAR(날짜, 날짜포맷)
```

일단 예제를 간단히 살펴보자.  

```sql
SELECT TO_CHAR(SYSDATE, 'CC YYYY/MM/DD HH24:MI:SS') FROM DUAL;
```

Date format은 다양하므로 문서를 참고하자.  

https://docs.oracle.com/cd/B28359_01/server.111/b28286/sql_elements004.htm#SQLRF00212

### 3.4.2. 문자를 날짜로 변환

```sql
TO_DATE(날짜문자열, 포맷(형태))
```

간단히 쿼리로.  

```sql
SELECT TO_DATE('2020-10-13 03:02:24', 'YYYY-MM-DD HH24:MI:SS') FROM DUAL;
```

## 3.5. NULL 처리

값이 NULL인 경우 대체할 값이나 처리 방식을 지정하는 함수이다. NVL이라는 함수이며 NVL, NVL2가 존재한다. NVL은 Null Value Logic의 약어이다.  

### 3.5.1. NVL

```sql
NVL(데이터 혹은 칼럼, NULL이면 반환할 값)
```

### 3.5.2. NVL2

```sql
NVL2(
  데이터 혹은 칼럼, 
  NULL이 아닌 경우 반환할 값이나 식,
  NULL인 경우 반환할 값이나 식
)
```

## 3.6. 분기 처리

오라클에서 지원하는 DECODE가 있긴 한데 소개하지 않는다. 소개하지 않는 배경에는:

- 표준이 아니다. 오라클의 독자적인 똥이다.  
- 표준인 CASE랑 비슷해서 DECODE가 나오더라도 어려울 일이 없다.

CASE의 기본적인 형식은 다음과 같다.  


```sql
CASE
    WHEN condition1 THEN result1
    WHEN condition2 THEN result2
    WHEN conditionN THEN resultN
    ELSE result
END;
```

급여가 1000 미만이면 먼지탱이라고 출력되도록 해보자.  

```sql
SELECT name,
    CASE
        WHEN SALARY <= 1000 THEN '먼지탱이'
        ELSE '뭐'
    END
FROM EMPLOYEE;
```

# 4. 복수행 함수, 그룹화

`복수행`이라는 것이 와닿지 않을 수 있는데, 지금까지 함수들은 칼럼 값 하나를 받았다면 복수행 함수는 여러 칼럼을 받아서 계산한다. 이 함수들은 통계 데이터를 만들거나 데이터를 취합할 때 유리하게 사용되므로 알아두자.  

그룹화는 결과 값을 특정한 칼럼들을 중심으로 묶을 수 있게 해준다.  

## 4.1. 다중행 함수

그룹화에 앞서 다중행 함수부터 공부해보자.  

### 4.1.1. 합계 - SUM

합계를 구하는데 사용되는 SUM의 형식은 다음과 같다.  

```sql
SUM([DISTINCT, ALL] [연산자 혹은 칼럼명])
```

전체 직원의 연봉 합계를 살펴보자.  

```sql
SELECT sum(SALARY) FROM EMPLOYEE;
```

결과는 다음과 같다.  

| SUM\(SALARY\) |
| :--- |
| 5000 |

여러 행이 하나의 행으로 나온 것을 확인할 수 있다.  

### 4.1.2. 칼럼(데이터) 개수 - COUNT

아주 흔하게 사용할 것이다. 테이블의 레코드 개수를 카운트 할 때 쓰기 좋다.  


```sql
SELECT count(*) FROM employee;
```

### 4.1.3. 평균 값 - AVG

평균 값을 구한다.  

```sql
SELECT avg(salary) FROM employee;
```

## 4.2. 그룹화

앞선 복수행 함수는 하나의 값에 대해서만 출력을 했다. 따라서 직원 테이블에서 부서별/직군별 급여 평균을 계산하려면 모두 하나하나 작성을 해야한다. 하지만 이를 `GROUP BY`절이 해결해준다.  

기본적인 사용법은 다음과 같다.  

```sql
GROUP BY 그룹으로_묶을_칼럼
```

직군별 급여 평균을 구해보자.  

```sql
SELECT job, avg(SALARY) FROM EMPLOYEE GROUP BY JOB
```

| JOB | AVG\(SALARY\) |
| :--- | :--- |
| webdev | 1000 |
| programmer | 1000 |
| design | 1000 |

참고로 그룹화 대상이 아니라면 SELECT에서 지정할 수 없기 때문에 유의하기 바란다.  

## 4.3. HAVING 절 - 조건부 그룹화

`GROUP BY`절로 지정된 칼럼을 `HAVING`절로 제한할 수 있다.  
평균 급여가 500을 넘는 직군을 출력해보자.  

```sql
SELECT job, avg(SALARY)
FROM EMPLOYEE
GROUP BY job
HAVING avg(SALARY) >= 500;
```

WHERE로 하면 안되는 이유는? -> WHERE는 출력할 레코드를 제한

# 5. join

관계형 모델을 다루는 RDB는 여러 종류의 데이터를 나누어 저장하고, 다른 테이블을 참조할 땐 해당 테이블의 기본키만 저장하는 방식(FK)을 사용한다.  

조인은 앞선 챕터에서도 간접적으로 소개한 바가 있다. 조인을 사용하면 두 개 이상의 테이블을 특정 조건 하에 연결하여 하나의 테이블처럼 사용할 수 있다.  

## 5.1. 조인

조인을 사용하기 위한 기본 형식을 살펴보자.  
우선 `JOIN` 절을 사용하는 방법이다.  

```sql
FROM 테이블1 테이블1_별칭
  JOIN 테이블2 테이블2_별칭 ON 조건
  ...
  JOIN 테이블N 테이블N_별칭 ON 조건
```

FROM 절에도 여러 테이블을 걸 수 있다.  

```sql
FROM 테이블1, 테이블2, ..., 테이블N
```

하지만 FROM 절에 여러 테이블을 걸 때에는 WHERE 절로 조건을 걸어주어야 한다.  

우선 JOIN과 FROM을 이용해 각각 실습해보자.  

```sql
SELECT * FROM EMPLOYEE e JOIN DEPARTMENT D on e.DEPARTMENT_ID = D.ID;
SELECT * FROM EMPLOYEE e, DEPARTMENT d WHERE e.DEPARTMENT_ID = D.ID;
```

### 5.1.1. 카테시안 곱

FROM절을 사용할 때 조건을 걸지 않으면 카테시안 곱 문제가 생긴다. 더불어 정보가 부정확한 문제도 덤으로 발생한다. 한 번 FROM절에 JOIN에 필요한 조건을 걸지 않고 실행해보자.  

```sql
SELECT * FROM EMPLOYEE e, DEPARTMENT d;
```

이렇게 하면 카테시안 곱으로 된 결과가 나온다. 결과 셋도 감당할 수 없을만큼 크다.  

## 5.2. 조인 종류

조인에는 다음과 같은 것들이 존재한다.  

- 등가 조인(equi join)
- 비등가 조인(Non-equi join)
- 자기 조인(self join)
- 외부 조인(outer join)

### 5.2.1. 등가 조인

등가 조인은 각 테이블의 연결 후 각 테이블의 특정 열을 조건에 따라 일치시켜 선정하는 방식을 의미한다. 앞서 기본 키를 조건으로 조인을 했는데 이 방식이 등가 조인이다. 등가 조인은 내부 조인(inner join, simple join)이라고 부른다. 단순하게 조인이라고 일컫는 것들이 이에 해당한다.  

### 5.2.2. 비등가 조인

등가 조인 방식의 이외의 것을 의미한다. 등가 조인에서는 조인 조건에 해당하는 두 칼럼의 값이 동일한 경우 일치시켰다. 비등가에서는 다음과 같이 범위로 지정할 수도 있다.  

```sql
SELECT s.GRADE, e.*
FROM employee e,
     salary s
WHERE e.SALARY BETWEEN s.LOW_SAL AND s.HIGH_SAL;
```

### 5.2.3. 자체 조인

자기 자신과 조인할 때 사용한다. 보통 계층 구조를 가지고 있을 때 플랫하게 만들 때 사용하면 좋다. 왜냐하면 계층 구조를 표현하기 위해 테이블을 두 개 사용하는 것 보다 절약될 수 있기 때문이다. 하지만 이는 충분히 판단하고 생각해볼 것.  

```sql
SELECT e2.name as 매니저이름, e2.id as 매니저사원번호, e1.*
FROM employee e1, employee e2
WHERE e1.MANAGER_ID = e2.id;
```

혹은 다음과 같이 표현도 가능하다.  

```sql
SELECT e2.name as 매니저이름, e2.id as 매니저사원번호, e1.*
FROM EMPLOYEE e1
INNER JOIN EMPLOYEE e2 ON e1.MANAGER_ID = e2.ID
```

### 5.2.4. 외부 조인

외부 조인의 종류는 다음과 같다.  

!["외부 조인 종류"](assets/3-1.png)

# 6. 서브쿼리

서브 쿼리는 상황에 따라 가변적인 값을 비교하거나 기준으로 삼기 위해 쿼리 내에 작성하는 또 다른 쿼리이다.  

## 6.1. 서브쿼리?

서브쿼리의 사용 형식을 보자.  

```sql
FROM (서브쿼리)
WHERE (서브쿼리)
```

서브쿼리는 FROM절에도, WHERE절에도 위치할 수 있다.  


### Reference
- [원치호강사님](https://github.com/hyeyoom/kh-lecture-2020/blame/master/database/3.%20%EC%A1%B0%ED%9A%8C%20-%20SELECT.md)
