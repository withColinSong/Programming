/* 게시판 테이블 생성 및 시퀀스 */
CREATE TABLE board(
    serial INTEGER Primary Key,
    mid VARCHAR2 (20),
    pwd VARCHAR2 (20),
    subject VARCHAR2 (200),
    doc VARCHAR2 (3000),
    mdate VARCHAR2(20),
    hit INTEGER,
    pserial INTEGER
);

/* 첨부파일 */

CREATE TABLE boardAtt(
    serial INTEGER PRIMARY KEY,
    board_serial INTEGER,
    oriFile VARCHAR2(200),
    sysFile VARCHAR2(200)
);

ALTER TABLE boardAtt RENAME COLUMN board_serial TO pserial;
/*borad, boardAtt 시퀀스 */

CREATE SEQUENCE seq_board;
CREATE SEQUENCE seq_boardAtt;


/* 조회 */
SELECT * FROM board;
SELECT * FROM boardAtt;


INSERT INTO board VALUES(SEQ_BOARD.nextval, 'song', '1234', 'Java', '', SYSDATE, 1, 1);
INSERT INTO board VALUES(SEQ_BOARD.nextval, 'song', '1234', 'Java', '', SYSDATE, 2, 2);
INSERT INTO board VALUES(SEQ_BOARD.nextval, 'song', '1234', 'Java', '', SYSDATE, 3, 3);
INSERT INTO board VALUES(SEQ_BOARD.nextval, 'song', '1234', 'Java', '', SYSDATE, 4, 4);
INSERT INTO board VALUES(SEQ_BOARD.nextval, 'song', '1234', 'Java', '', SYSDATE, 5, 5);

INSERT INTO boardAtt VALUES(SEQ_BOARDATT.nextval, 1, '', '');
INSERT INTO boardAtt VALUES(SEQ_BOARDATT.nextval, 2, '', '');
INSERT INTO boardAtt VALUES(SEQ_BOARDATT.nextval, 3, '', '');
INSERT INTO boardAtt VALUES(SEQ_BOARDATT.nextval, 4, '', '');


/* insert */
BEGIN
    FOR i IN 1..1000 LOOP
    INSERT INTO board(serial, mid, pwd, subject, doc, mdate)
    values(seq_board.nextval, 'song' ||i, '1111', '제목입니다.' ||i , '내용입니다.'|| i, sysdate);
    END LOOP;
END;

commit


/* 시퀀스가 증가되는 함수 만들기 */
CREATE FUNCTION getBoardAttSeq
RETURN NUMBER
IS
    seq NUMBER;
BEGIN
    SELECT seq_boardAtt.nextval INTO seq from dual;
    RETURN seq;
END;

SELECT getBoardAttSeq() FROM dual;