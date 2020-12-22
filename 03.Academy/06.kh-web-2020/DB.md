
# members 테이블

```sql

CREATE TABLE members(
    mid varchar2(20),
    pwd varchar2(20),
    name varchar2(20),
    email varchar2(100),
    phone varchar2(20),
    zipcode varchar2(10),
    address varchar2(100)

);

SELECT * FROM members;

/* 회원관리 테이블에 테스트용 자료 입력*/
INSERT INTO members
VALUES('song', '1111', '송', 'song@gmail.com', '010-1111-1111', '11-111', '서울');
INSERT INTO members VALUES('oh', '1111', '오', 'oh@gmail.com', '010-1111-1111', '11-222', '부산');
INSERT INTO members VALUES('choi', '1111', '최', 'choi@gmail.com', '010-1111-1111', '11-333', '부산');

-- photo, mdate 추가
ALTER TABLE members ADD photo VARCHAR(200);
ALTER TABLE members ADD mdate VARCHAR(20);
DESC members;


-- 페이징 구현
SELECT * FROM -- StartNo ~ endno 선택 -> 페이징 구현
(SELECT ROWNUM no, m.* FROM -- row num 행번호
(SELECT * FROM members ORDER BY name desc) m) -- 검색정보
WHERE no BETWEEN 1 and 3

-- 데이터 추가
INSERT INTO members values('song2','1111','song2', 'song@gmail.com', '010-1111-1111', '11-111', '서울', '', SYSDATE);
INSERT INTO members values('song3','1111','song3', 'song@gmail.com', '010-1111-1111', '11-111', '서울', '', SYSDATE);
INSERT INTO members values('song4','1111','song4', 'song@gmail.com', '010-1111-1111', '11-111', '서울', '', SYSDATE);
INSERT INTO members values('song5','1111','song5', 'song@gmail.com', '010-1111-1111', '11-111', '서울', '', SYSDATE);
INSERT INTO members values('song6','1111','song6', 'song@gmail.com', '010-1111-1111', '11-111', '서울', '', SYSDATE);
INSERT INTO members values('song7','1111','song7', 'song@gmail.com', '010-1111-1111', '11-111', '서울', '', SYSDATE);
INSERT INTO members values('song8','1111','song8', 'song@gmail.com', '010-1111-1111', '11-111', '서울', '', SYSDATE);
INSERT INTO members values('song9','1111','song9', 'song@gmail.com', '010-1111-1111', '11-111', '서울', '', SYSDATE);
INSERT INTO members values('song10','1111','song10', 'song@gmail.com', '010-1111-1111', '11-111', '서울', '', SYSDATE);
INSERT INTO members values('song11','1111','song11', 'song@gmail.com', '010-1111-1111', '11-111', '서울', '', SYSDATE);
INSERT INTO members values('song12','1111','song12', 'song@gmail.com', '010-1111-1111', '11-111', '서울', '', SYSDATE);
INSERT INTO members values('song13','1111','song13', 'song@gmail.com', '010-1111-1111', '11-111', '서울', '', SYSDATE);
INSERT INTO members values('song14','1111','song14', 'song@gmail.com', '010-1111-1111', '11-111', '서울', '', SYSDATE);
INSERT INTO members values('song15','1111','song15', 'song@gmail.com', '010-1111-1111', '11-111', '서울', '', SYSDATE);
INSERT INTO members values('song16','1111','song16', 'song@gmail.com', '010-1111-1111', '11-111', '서울', '', SYSDATE);
```


# gusetbook 테이블

```sql
SELECT * from guestbook;

/* 방명록 */
create table guestbook(
    serial integer,
    mid varchar2(20),
    pwd varchar2(20),
    mdate varchar(12),
    doc varchar(500)
);

-- 시리얼 넘버 , 데이터 추가
create sequence seq_guestbook;

INSERT INTO guestbook values(seq_guestbook.nextval, 'song' , '1111', sysdate, '1');
INSERT INTO guestbook values(seq_guestbook.nextval, 'choi' , '2222', sysdate, '2');
INSERT INTO guestbook values(seq_guestbook.nextval, 'oh' , '1111', sysdate, '3');
INSERT INTO guestbook values(seq_guestbook.nextval, 'jeon' , '1111', sysdate, '4');
INSERT INTO guestbook values(seq_guestbook.nextval, 'kim' , 'kwak', sysdate, '5');
INSERT INTO guestbook values(seq_guestbook.nextval, 'lee' , 'kwak', sysdate, '6');
INSERT INTO guestbook values(seq_guestbook.nextval, 'yun' , 'kwak', sysdate, '7');
INSERT INTO guestbook values(seq_guestbook.nextval, 'park' , 'kwak', sysdate, '8');

commit
```

