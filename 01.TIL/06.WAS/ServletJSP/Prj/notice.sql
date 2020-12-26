CREATE TABLE NOTICE(
    ID	NUMBER,
    TITLE 	NVARCHAR2(100),
    WRITER_ID NVARCHAR2(50),
    CONTENT	CLOB,
    REGDATE  TIMESTAMP,
    HIT	NUMBER,
    FILES	NVARCHAR2(1000)
);


CREATE SEQUENCE ID_NUM
INCREMENT BY 1
START WITH 1
MINVALUE 1
NOMAXVALUE
NOCYCLE
NOCACHE;

INSERT INTO NOTICE(ID,TITLE,WRITER_ID,CONTENT,REGDATE) VALUES(ID_NUM.NEXTVAL, '제목1', 'id1', '콘텐츠1',SYSDATE);
INSERT INTO NOTICE(ID,TITLE,WRITER_ID,CONTENT,REGDATE) VALUES(ID_NUM.NEXTVAL, '제목2', 'id2', '콘텐츠2',SYSDATE);
INSERT INTO NOTICE(ID,TITLE,WRITER_ID,CONTENT,REGDATE) VALUES(ID_NUM.NEXTVAL, '제목3', 'id3', '콘텐츠3',SYSDATE);
INSERT INTO NOTICE(ID,TITLE,WRITER_ID,CONTENT,REGDATE) VALUES(ID_NUM.NEXTVAL, '제목4', 'id4', '콘텐츠4',SYSDATE);
INSERT INTO NOTICE(ID,TITLE,WRITER_ID,CONTENT,REGDATE) VALUES(ID_NUM.NEXTVAL, '제목5', 'id5', '콘텐츠5',SYSDATE);
INSERT INTO NOTICE(ID,TITLE,WRITER_ID,CONTENT,REGDATE) VALUES(ID_NUM.NEXTVAL, '제목6', 'id6', '콘텐츠6',SYSDATE);

INSERT INTO NOTICE(ID,TITLE,WRITER_ID,CONTENT,REGDATE) VALUES(ID_NUM.NEXTVAL, '제목7', 'id7', '콘텐츠7',SYSDATE);
INSERT INTO NOTICE(ID,TITLE,WRITER_ID,CONTENT,REGDATE) VALUES(ID_NUM.NEXTVAL, '제목8', 'id8', '콘텐츠8',SYSDATE);
INSERT INTO NOTICE(ID,TITLE,WRITER_ID,CONTENT,REGDATE) VALUES(ID_NUM.NEXTVAL, '제목9', 'id9', '콘텐츠9',SYSDATE);
INSERT INTO NOTICE(ID,TITLE,WRITER_ID,CONTENT,REGDATE) VALUES(ID_NUM.NEXTVAL, '제목10', 'id10', '콘텐츠10',SYSDATE);
INSERT INTO NOTICE(ID,TITLE,WRITER_ID,CONTENT,REGDATE) VALUES(ID_NUM.NEXTVAL, '제목11', 'id11', '콘텐츠11',SYSDATE);
INSERT INTO NOTICE(ID,TITLE,WRITER_ID,CONTENT,REGDATE) VALUES(ID_NUM.NEXTVAL, '제목12', 'id12', '콘텐츠12',SYSDATE);

commit