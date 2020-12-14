
/* 회원정보 */
CREATE TABLE members(
    mid VARCHAR2(20),
    pwd VARCHAR2(20),
    name VARCHAR2(20),
    email VARCHAR2(100),
    phone VARCHAR2(20),
    zipcode VARCHAR2(10),
    address VARCHAR2(100)

);


/* 방명록 */
CREATE TABLE guestbook(
    serial INTEGER,
    mid VARCHAR2(20),
    pwd VARCHAR2(20),
    mdate VARCHAR(12),
    doc VARCHAR(500)
);

/* 회원관리 테이블에 테스트용 자료 입력 */
INSERT INTO members
VALUES('song', '1111', '송', 'song@gmail.com', 
'010-1111-1111', '11-111', '서울');

INSERT INTO members 
VALUES('oh', '1111', '오', 'oh@gmail.com', 
'010-1111-1111', '11-222', '부산');

INSERT INTO members 
VALUES('choi', '1111', '최', 'choi@gmail.com', 
'010-1111-1111', '11-333', '부산');

commit