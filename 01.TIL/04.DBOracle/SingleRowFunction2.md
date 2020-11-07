# 단일행함수
## 2.2 문자함수

|이름|의미| 
|:-:|:-:|
UPPER| 대문자로 변환
LOWER| 소문자로 변환
INITCAP| 이니셜만 대문자로 변환
LENGTH| 문자 길이 반환
LENGTHB| 바이트 수 반환
INSTR| 특정 문자의 위치 반환
SUBSTR| 대상의 시작 위치부터 선택 개수만큼 추출
SUBSTRB| 대상의 시작 위치부터 선택 바이트만큼 추출
LPAD/RPAD| 빈칸만큼 특정문자로 채움
LTRIM/RTRIM| 공백문자 삭제
TRIM| 특정 문자 잘라내기

### 2.2.1 UPPER
- 대문자로 변환하는 함수로 UPPER(값 또는 컬럼명)을 넣으면 값 또는 해당 컬럼에 기록된 문자값이 모두 대문자로 반환된다.
```sql
SELECT UPPER('song') 
FROM dual;
```
![](https://images.velog.io/images/withcolinsong/post/6a4cc9c6-5591-4778-9eab-014410f79062/image.png)
### 2.2.2 LOWER
- 소문자로 변환하는 함수로 LOWER(값 또는 컬럼명)을 넣으면 값 또는 해당 컬럼에 기록된 문자열값이모두 소문자로 반환된다.
```sql
SELECT LOWER('SONG') 
FROM dual;
```
![](https://images.velog.io/images/withcolinsong/post/3ab7e867-f081-4309-a9d0-41215f00b4dc/image.png)

### 2.2.3 INITCAP
- 단어의 앞 글자만 대문자로 변환해주는 함수로 INITCAP(값 또는 컬럼명)을 넣으면 값 또는 해당 컬럼에 기록된 문자열 값의 첫 글자를 대문자로 변환하여 반환한다.
```sql
SELECT INITCAP('sin min a') AS INITCAP
FROM dual;
```
![](https://images.velog.io/images/withcolinsong/post/216ffb7d-1085-41a0-b18b-47cf8ca2d401/image.png)

### 2.2.4 LENGTH / LENGTHB
#### LENGTH
- LENGTH(문자열A 또는 문자형컬럼) 
- 컬럼에 기록된 문자열값의 길이를 반환하는 함수이다.
#### LENGTHB
- LENGTHB(문자열A 또는 문자형컬럼)
- 문자열A 또는 컬럼에 기록된 문자열값의 바이트 수를 반환한다.

```sql
SELECT LENGTH('한글'), LENGTHB('한글') 
FROM dual;
```
![](https://images.velog.io/images/withcolinsong/post/7f24b159-3fdd-40d2-93a6-f3c88c6931ba/image.png)

### 2.2.5 INSTR / INSTRB
#### INSTR
- INSTR은 문자 또는 컬럼에 포함된 문자의 위치를 찾는 함수
- 검색시작위치, 발견번째 수는 생략할 수 있고, 생략하게 되면 1로 값이 자동으로 들어가 
첫 번째부터 검색하여 첫 번째 발견문자의 위치를 반환하고, 만약 인자값을 원하
는 위치부터 시작하여 원하는 번째 문자를 검색할 때는 각 인자값에 값을 넣으면 된다.

```sql
SELECT INSTR(문자 또는 컬럼, '검색문자', 검색시작위치, 발견번째 수)
FROM 테이블명;

SELECT INSTR(‘ORACLE WELCOME','O') 
FROM dual;
```
![](https://images.velog.io/images/withcolinsong/post/697e1f05-926b-4438-bc4d-b3461d63864f/image.png)
- 시작위치 및 발견번째수를 입력하지 않아 1번째 글자부터 검색하여 첫 번째 번 검색된 값의
위치를 반환하여 ‘ORACLEWELCOME’이라는 문자중 ‘O’RALCE의 O위치를 반환하여 1이라는 반환값이 나온 것.

#### INSTRB
- INSTR을 바이트로 글자를 반환한다.
```sql
SELECT INSTR('한글','글'), INSTRB('한글','글')
FROM dual;
```
![](https://images.velog.io/images/withcolinsong/post/72e10819-5637-4cf4-ac51-2944bb309678/image.png)
- 영문과 숫자는 1BYTE

### 2.2.6 SUBSTR / SUBSTRB
- SUBSTR은 대상 문자열이나 컬럼의 자료에서 시작위치부터 선택 개수만큼의 문자를 반환하는 함수
- 해당 문자가 반환할 개수만 반환된다. 
- SUBSTR은 문자수, SUBSTRB 함수는 바이트수로 동작한다.
```sql
SELECT SUBSTR(대상, 시작위치, 반환할문자수)
FROM dual;

SELECT SUBSTR('오라클 데이터베이스',3) 
FROM dual;

```
![](https://images.velog.io/images/withcolinsong/post/a63ba14f-89cf-4133-bfb4-86df2996e067/image.png)
```sql
SELECT SUBSTR('오라클 데이터베이스',3,5), 
SUBSTRB('오라클 데이터베이스',3,5) 
FROM dual;
```
![](https://images.velog.io/images/withcolinsong/post/1ffc4983-21b0-44b8-886f-42b3a02851d8/image.png)

### 2.2.7 LPAD / RPAD
- 기준 공간 칸수를 지정하고 빈칸만큼 특정문자로 채우는 함수
- 공간칸수보다 첫 번째 인자 문자열의 크기가 크다면, 넘치는 문자열은 제거
#### LPAD
```sql
SELECT LPAD('ORACLE', 10, '+') 
FROM dual;
```
![](https://images.velog.io/images/withcolinsong/post/b7432cc3-1c4c-4458-bdd0-3cc9977803e3/image.png)

#### RPAD
```sql
SELECT RPAD('ORACLE', 10, '+') 
FROM dual;
```
![](https://images.velog.io/images/withcolinsong/post/34d848b1-5523-4a94-bf4d-4519e58782c7/image.png)

### 2.2.8 LTRIM / RTRIM
- 왼쪽 또는 오른쪽의 공백문자를 제거해주는 함수
```sql
SELECT ' ORACLE ',
LTRIM(' ORACLE '), -- 왼쪽 공백 제거
RTRIM(' ORACLE '), -- 오른쪽 공백 제거
FROM dual;
```
![](https://images.velog.io/images/withcolinsong/post/2fed6b9a-eff3-427b-8f42-9d7173ca4a06/image.png)

### 2.2.9 TRIM
- 양끝의 특정 문자를 제거하는 함수로, 특정 문자를 지정하지 않으면 양쪽 공백 제거
```sql
SELECT TRIM('a' FROM 'aaaOracleaaa') 
FROM dual;
```
![](https://images.velog.io/images/withcolinsong/post/ebd206e0-9bb7-4cb6-970e-219635b09a6c/image.png)

## Reference
- 테이블 자료 : Oracle - `EMP 테이블` 
- 참고도서(책) : SQL활용 + 실습 후 정리
- 🎈2020.11.07

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)
