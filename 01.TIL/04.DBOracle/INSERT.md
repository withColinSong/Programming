# 데이터 삽입
## INSERT

```sql
INSERT INTO 테이블명 (column명1, column명2....)
VALUES (값, 값)
```

- 테이블명에 명시한 속성에 `VALUES`절에 지정한 값을 입력.
- 테이블명에 속성을 명시하지 않으면 테이블 생성시 정의한 컬럼 순서와 동일한 순서로 입력한다.

```sql
CREATE TABLE EMP (
    ENO NUMBER,
    ENAME VARCHAR2(20), 
    JAB VARCHAR2(20),
    MANAGER NUMBER,
    HIREDATE TIMESTAMP,
    SALARY NUMBER,
    COMMISIONN NUMBER,
    DNO NUMBER,
);


INSERT INTO EMP
VALUES (50, '홍길동', 'staff', NULL, SYSDATE, 500, 30, 10);
```

#### 데이터 입력

1. 묵시적인 방법 : `INSERT INTO`절에 해당 속성명 생략
2. 명시적인 방법 : `VALUES`절에 있는 속성값에 `NULL`을 사용

#### NULL의 입력
- 데이터를 입력하는 시점에서 해당 속성값을 모르거나, 미확정일 때 사용함


## References

- 🎈2020.10.27

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)
