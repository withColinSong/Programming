# NN 제약조건

두 가지 방법

```sql
-- 제약조건 이름이 없는 경우
CREATE TABLE account_info (
    id NUMBER,
    email VARCHAR2(128) NOT NULL
);

-- 제약조건 이름이 있는 경우
CREATE TABLE account_info (
    id NUMBER,
    email VARCHAR2(128) CONSTRAINT account_info_email_nn NOT NULL
);
```

실제로 테스트 해보기

```sql
INSERT INTO account_info(id, email) VALUES (1, 'abc@gmail.com');
INSERT INTO account_info(id, email) VALUES (2, NULL);
UPDATE account_info SET email = NULL WHERE id = 1;
```




# UQ 제약조건

세 가지 방법

```sql
-- 칼럼 레벨
CREATE TABLE account_info (
    id NUMBER,
    email VARCHAR2(128) UNIQUE
);

-- 칼럼 레벨
CREATE TABLE account_info (
    id NUMBER,
    email VARCHAR2(128) CONSTRAINT account_info_email_uq UNIQUE
);

-- 테이블 레벨
CREATE TABLE account_info(
    id NUMBER,
    email VARCHAR2(128),
    CONSTRAINT account_info_email_uq UNIQUE (email)
)


```

테스트 데이터

```sql
INSERT INTO account_info(id, email) VALUES (1, 'abc@gmail.com');
INSERT INTO account_info(id, email) VALUES (2, 'abcd@gmail.com');
UPDATE account_info SET email = 'abc@gmail.com' WHER

```

# PK 제약조건

```sql
CREATE TABLE account_info (
    id NUMBER PRIMARY KEY,
    email VARCHAR2(128) UNIQUE
);

CREATE TABLE account_info (
    id NUMBER CONSTRAINT account_info_pk PRIMARY KEY,
    email VARCHAR2(128) UNIQUE
);

CREATE TABLE account_info (
    id NUMBER,
    email VARCHAR2(128) UNIQUE,
    CONSTRAINT account_info_pk PRIMARY KEY (id)
);
```

테스트 데이터

```sql
SELECT * FROM account_info;
INSERT INTO account_info(id, email) VALUES (1, 'abc@gmail.com');
INSERT INTO account_info(id, email) VALUES (1, 'abcd@gmail.com');
INSERT INTO account_info(id, email) VALUES (NULL, 'abcd@gmail.com');
```

# FK 제약조건

```sql
CREATE TABLE account_authentication (
    id NUMBER PRIMARY KEY,
    password VARCHAR2(128) NOT NULL,
    account_info_id NUMBER,
    CONSTRAINT account_info_fk FOREIGN KEY (account_info_id) REFERENCES account_info(id)
);
```

테스트 데이터

```sql
SELECT * FROM account_info;
INSERT INTO account_info(id, email) VALUES (1, 'abc@gmail.com');
SELECT* FROM account_authentication;
INSERT INTO account_authentication(id, password, account_info_id) VALUES(1, '1234', 1);
INSERT INTO account_authentication(id, password, account_info_id) VALUES(1, '1234', 2);
```

# CHECK
```sql
CREATE TABLE account_authentication(
    password VARCHAR2(128) 
    CONSTRAINT aa_pwd_length_chk CHECK (length(password) > 3)
);

```

테스트 데이터
```sql
INSERT INTO account_authentication (password) VALUES ('3334');
```
