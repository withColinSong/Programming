

-- 시리얼 넘버 추가
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


-- photo, mdate 추가
ALTER TABLE members ADD photo VARCHAR(200);
ALTER TABLE members ADD mdate VARCHAR(20);
DESC members;