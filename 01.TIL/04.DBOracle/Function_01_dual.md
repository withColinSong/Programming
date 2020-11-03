# 함수

## 1. DUAL 테이블
- SYS 계정에서 제공하는 테이블로 함수나 계산식을 테이블 참조 없이 실행해보기 위해 FROM 절에 사용하는 더미(DUMMY) 테이블로 가상의 테이블이라고 생각하면 된다.

```sql
DESC SYS.dual; // dual 유형 확인
SELECT * FROM dual; //dual 테이블 확인
```

- 사용자 테이블에서 산술연산을 수행하면 똑같은 값이 테이블에 있는 데이터 수 만큼 나오게 되지만, DUAL 테이블은 단 한개의 행만 조회되어 출력된다.
```sql 
SELECT * FROM emp;
```
![](https://images.velog.io/images/withcolinsong/post/d3f92b9a-8659-4b75-a593-a1a7413814a4/image.png)



```sql
SELECT 20*30
FROM dual;
```
![](https://images.velog.io/images/withcolinsong/post/a701dd94-c944-4af1-9921-694f1ec3a386/image.png)

## Reference
- 테이블 자료 : Oracle - `EMP 테이블` 
- 참고도서(책) : SQL활용 + 실습 후 정리
- 🎈2020.11.03

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)
