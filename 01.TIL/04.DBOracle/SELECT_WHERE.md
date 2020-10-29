
# WHERE
[목차](#목차)
- [1.SELECT](https://github.com/withColinSong/Programming/blob/master/01.TIL/04.DBOracle/SELECT01.md)
- [2.1 기본 WHERE절](#21-기본-where-절)
- [2.2 오라클 기본 연산자](#22-오라클-기본-연산자)
  - [2.2.1 비교 연산자](#221-비교-연산자)
  - [2.2.2 논리연산자](#221-논리-연산자) 
- [2.3 WHERE 절에서 사용할 수 있는 기타 연산자](#23-where-절에서-사용할-수-있는-기타-연산자)
  - [2.3.1 IN, NOT IN 연산자](#231-in-not-in-연산자)
  - [2.3.2 BETWEEN, NOT BETWEEN 연산자](#232-between-not-between-연산자)
  - [2.3.3 LIKE, NOT LIKE 연산자](#233-like-not-like-연산자)
  - [2.3.4 IS NULL, IS NOT NULL 연산자](#234-is-null-is-not-null-연산자)
- [Reference](#reference)

## 2.1 기본 WHERE절
```sql
SELECT 칼럼명, 칼럼명1... 칼럼명n
FROM 테이블명
WHERE 칼럼이름 비교연산자 조건값;
```
#### EMP 테이블로 실습해보자!
```sql
SELECT * FROM emp;
```
![](https://images.velog.io/images/withcolinsong/post/4e55be09-d9f0-416f-84ac-a157cbbf192f/image.png)

## 2.2 오라클 기본 연산자
### 2.2.1 비교 연산자
|연산자|설명
|:-:|:-:|
|=|같다
|>| 크다
|<| 작다
|>=| 크거나 같다
|<=| 작거나 같다
|<>,| !=, ^= 같지 않다
```sql
SELECT * FROM emp
1. WHERE deptno <> 30;
2. WHERE deptno != 30;
3. WHERE deptno ^= 30;
4. WHERE NOT deptno = 30;
```
#### 1. EMP 테이블에서 deptno 가 20 이고 sal 이 2000 이상이거나 hiredate 가 82년 01월 01일 이전인 사원 을 조회해 보자.

![](https://images.velog.io/images/withcolinsong/post/470a51e4-7a1d-4780-beb5-59bf1e94130a/image.png)

#### CODE
```sql
SELECT * FROM emp WHERE deptno = 20 AND (sal >= 2000 OR hiredate <= '82/01/01');
```

### 2.2.2 논리연산자
- 비교 연산자나 기타 WHERE 에 조건구문이 두 개 이상일 경우 논리연산자를 이용하여 조건을 논리적 으로 연결하여 조건에 맞는 값을 조회


|연산자|설명| |
|:-:|:-:|:-:|
조건A AND 조건B|두 가지 조건이 모두 만족되도록 결과 조회|교집합
조건A OR 조건B|두 가지 조건 중 하나라도 만족되도록 결과 조회|합집합
NOT 조건A| 조건을 만족하지 않도록 결과 조회|여집합

## 2.3 WHERE 절에서 사용할 수 있는 기타 연산자

|연산자|설명| 
|:-:|:-:|
BETWEEN 조건 A AND 조건 B| a 와 b 사이의 데이터를 출력(a, b 포함)
IN (값1...) | 테이블 데이터 값 중 어느 하나와 일치하는 데이터를 출력
LIKE | 문자 형태로 일치하는 데이터를 출력(%, _사용)
IS NULL| NULL 값을 가진 데이터를 출력
NOT BETWEEN a AND b| a 와 b 사이에 있지 않은 데이터를 출력(a, b 포함하지 않음)
NOT IN (값1...)| 테이블 데이터 값의 값과 일치하지 않는 데이터를 출력
NOT LIKE| 문자 형태와 일치하지 않는 데이터를 출력
IS NOT NULL |NULL 값을 갖지 않는 데이터를 출력

#### 2. EMP 테이블에서 deptno 가 20,30인 사원들의 정보를 조회해 보자.

![](https://images.velog.io/images/withcolinsong/post/8f1dacad-9c8b-4b3b-9515-24807e5b03ee/image.png)

#### CODE
```sql
SELECT * FROM emp WHERE deptno IN(20,30);
```
### 2.3.1 IN, NOT IN 연산자

#### 3. empno가 7698 에서 7902 까지의 사원을 조회해 보자.

![](https://images.velog.io/images/withcolinsong/post/81b02fda-3d0f-4b28-96cb-15e1f60a2f86/image.png)

#### CODE
```sql
SELECT * FROM emp WHERE empno BETWEEN 7698 AND 7902;
```
### 2.3.2 BETWEEN, NOT BETWEEN 연산자
#### 4. 1980년이 아닌 해에 입사한 직원을 조회해 보자.
![](https://images.velog.io/images/withcolinsong/post/ff5f4861-b584-4cfb-ad62-d99cf913b920/image.png)
#### CODE
```sql
SELECT * FROM emp WHERE hiredate NOT BETWEEN '1980/01/01' AND '1980/12/31';
```

### 2.3.3 LIKE, NOT LIKE 연산자
#### 5. EMP 테이블에서 이름에 K가 들어가는 사원의 empno 와 ename 을 조회해 보자.

![](https://images.velog.io/images/withcolinsong/post/eb497d57-c3e7-4474-8b60-77ee5640ebf3/image.png)
#### CODE
```sql
SELECT ename, empno FROM emp WHERE ename LIKE '%K%';
```

### 2.3.4 IS NULL, IS NOT NULL 연산자
#### 6. EMP 테이블에서 이름에 K로 시작하는 사원의 empno 와 ename 을 조회해 보자.
![](https://images.velog.io/images/withcolinsong/post/7a5b64d8-b992-4b7c-acb7-5d96c4eadf2f/image.png)
#### CODE
```sql
SELECT ename, empno FROM emp WHERE ename LIKE 'K%';
```

#### 7. EMP 테이블에서 이름에 K 로 끝나는 사원의 empno 와 ename 을 조회해 보자.

![](https://images.velog.io/images/withcolinsong/post/f48b3363-3bd8-475c-9b4b-b9470f1018db/image.png)
#### CODE
```sql
SELECT ename, empno FROM emp WHERE ename LIKE '%K';
```
#### 8. EMP 테이블에서 이름에 두 번째 문자가 A인 사원의 empno 와 ename 을 조회해 보자.
![](https://images.velog.io/images/withcolinsong/post/f92a2cfe-ee63-4ac7-b113-f9613f72d85a/image.png)
#### CODE
```sql
SELECT ename, empno FROM emp WHERE ename LIKE '_A%';
```

#### 9. 이름에 'A'가 없는 직원 정보를 조회해 보자.

![](https://images.velog.io/images/withcolinsong/post/3cafff10-b279-4949-a622-8106128c6e83/image.png)
#### CODE
```sql
SELECT * FROM emp WHERE ename NOT LIKE '%A%'
```

## Reference
- 테이블 자료 : Oracle - `EMP 테이블` 
- 참고도서(책) : SQL활용 + 실습 후 정리
- 🎈2020.10.29

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)
