## UPDATE
- 테이블에 저장된 데이터를 수정하기 위한 데이터 조작어
```sql
UPDATE 테이블명
SET COLUMN = 값 ...
WHERE 조건
```
- WHERE 절이 생략되면 테이블의 모든 행이 수정된다.


EMPTEST에 있는 모든 사원의 연봉의 10% 인상.

```sql
UPDATE emp
SET SALARY = SALARY * 1.1
```

![](https://images.velog.io/images/withcolinsong/post/25dd5ef0-5151-418b-b859-292912911ba3/image.png)

![](https://images.velog.io/images/withcolinsong/post/4c8a30fc-5660-476a-a4ce-f3897962453b/image.png)


## DELETE
- 테이블에 저장된 데이터 삭제를 위한 조작어
```sql
DELETE FROM 테이블명
WHERE 조건
```
- WHERE 절이 생략되면 테이블의 모든 행을 삭제한다.

<br>

### Example01

![](https://images.velog.io/images/withcolinsong/post/e082856a-1c38-4c2f-a9bd-5cd66d217e06/image.png)

```sql
DELETE EMP;
```
![](https://images.velog.io/images/withcolinsong/post/e895ef90-83a1-4e2d-b585-e2eef21d8278/image.png)


### Example02
![](https://images.velog.io/images/withcolinsong/post/0e62c3df-63f1-4db9-8584-6e40867ba8e6/image.png)

```sql
DELETE EMP;
WHERE SALARY < 400; -- 급여가 400미만인 직원을 제거하는 조건
```

![](https://images.velog.io/images/withcolinsong/post/5f2771e0-8292-4303-a2e2-ad6d3d7c6158/image.png)

## References

- 🎈2020.10.27

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)
