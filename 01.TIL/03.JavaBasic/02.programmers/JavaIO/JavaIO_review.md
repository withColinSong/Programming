
# [목차](#목차)
- [목차](#목차)
- [JavaIO Review](#javaio-review)
- [1. Byte 출력](#1-byte-출력)
  - [1.1. ByteExam1](#11-byteexam1)
  - [1.2. copy.txt](#12-copytxt)
  - [2.1 ByteExample2](#21-byteexample2)
    - [2.1.1 문제점 -> copy.txt가 ByteExam2을 반복함.. ?!!!](#211-문제점---copytxt가-byteexam2을-반복함-)
    - [2.1.1. copy.txt](#211-copytxt)
  - [3. 다양한 출력 방식](#3-다양한-출력-방식)
    - [3.1.1. copy.txt](#311-copytxt)
    - [3.1.2. copy.txt 파일 크기](#312-copytxt-파일-크기)
- [2. 문자열 출력](#2-문자열-출력)
  - [2.1. CharExam1](#21-charexam1)
  - [2.2. copy.txt](#22-copytxt)
  - [References](#references)

# JavaIO Review
- TIL 20.11.21 복습

# 1. Byte 출력

## 1.1. ByteExam1

- FileInputStream 
- FileOutputStream 
- read()

```java
import java.io.*;

public class ByteExam1 {
    public static void main(String[] args){
        try(
        FileInputStream fis = new FileInputStream("src/ByteExam1.java");
        FileOutputStream fos = new FileOutputStream("copy.txt");
        ) {
            int readCount;
            while((readCount = fis.read()) != -1) {
               fos.write(readCount);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
```

## 1.2. copy.txt
![](https://images.velog.io/images/withcolinsong/post/91e114e5-d773-492b-be5c-bafca01a1bfc/image.png)


## 2.1 ByteExample2

### 2.1.1 문제점 -> copy.txt가 ByteExam2을 반복함.. ?!!!

- FileInputStream 
- FileOutputStream 
- read(byte[] b)

```java
import java.io.*;

public class ByteExam2 {
    public static void main(String[] args) {
        try(
                FileInputStream fis = new FileInputStream("src/ByteExam2.java");
                FileOutputStream fos = new FileOutputStream("copy.txt");
                ) {
                int readCount;
                byte[] buffer = new byte[512];
                while((readCount = fis.read(buffer)) != -1) {
                    fos.write(buffer);
                }

        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}

```

### 2.1.1. copy.txt

```java
import java.io.*;

public class ByteExam2 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("src/ByteExam2.java");
            fos = new FileOutputStream("copy.txt");

            int readCount;
            byte[] buffer = new byte[512];
            while((readCount = fis.read(buffer)) != -1) {
                fos.write(buffer);
            }

        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fis.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
        // 왜... 반복하는걸까...?
        fos = new FileOutputStream("copy.txt");

            int readCount;
            byte[] buffer = new byte[512];
            while((readCount = fis.read(buffer)) != -1) {
                fos.write(buffer);
            }

        }catch(Exception e //잘림

```
- byte배열 크기를 4096으로 하면 밑에 NULLNULLNULL로 뜬다.
  
![](https://images.velog.io/images/withcolinsong/post/feeb5fb7-9447-445c-95dc-0082484dc7e3/image.png)



## 3. 다양한 출력 방식

- DataInputStream
- DataOutputStream
- writeInt()
- writeBoolean()
- writeDouble()

```java
import java.io.*;

public class ByteExam3 {
    public static void main(String[] args) {

        DataOutputStream dos = null;

        try {

            // 파일을 저장할 경로 설정
            dos = new DataOutputStream(new FileOutputStream("copy.txt")); 

            // 파일에 쓸 내용 
            int int_i = 3; // 4byte
            boolean boolean_b = true; // 1byte
            Double double_d = 3.14; // 8byte

            dos.writeInt(int_i);
            dos.writeBoolean(boolean_b);
            dos.writeDouble(double_d);


        }catch(Exception e){
           e.printStackTrace();
       }finally {
            try {
                dos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
       }
    }
}

```
### 3.1.1. copy.txt 
- 인코딩은 아래처럼 나온다.
![](https://images.velog.io/images/withcolinsong/post/d016b069-42d9-4101-ad96-ff21e3877f2a/image.png)

### 3.1.2. copy.txt 파일 크기
- 13byte
- `int` + `boolean` + `double`

![](https://images.velog.io/images/withcolinsong/post/f2d7bd4c-4d31-4b4e-b63c-5d14458cc4c8/image.png)


# 2. 문자열 출력

## 2.1. CharExam1
```java
public class CharExam1 {
    public static void main(String[] args) {

        BufferedReader br = null;
        PrintWriter pw = null;
        try {
            br = new BufferedReader(new FileReader("src/byteExam1.java"));
            pw = new PrintWriter(new FileWriter("copy.txt"));

            String line = null;
            while((line = br.readLine()) != null) {
                pw.write(line+"\n"); // \n을 붙이지 않으면 다 연결되서 나온다.
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
           pw.close();
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

```

## 2.2. copy.txt
![](https://images.velog.io/images/withcolinsong/post/c0fffbe6-832c-49a7-8235-7954528f9f8f/image.png)

## References
- [프로그래머스](https://programmers.co.kr/) : TIL 복습
- 🎈2020.11.22
- 🎈정리 : VScode

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)