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
    serial integer primary key,
    board_serial integer,
    oriFile VARCHAR2(200),
    sysFile VARCHAR2(200)
);

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

commit
