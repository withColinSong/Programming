# [목차](#목차)
- [목차](#목차)
- [1. Java IO](#1-java-io)
  - [1.1. byte단위 입출력](#11-byte단위-입출력)
    - [1.1.1 read()](#111-read)
    - [1.1.2 read(byte[] b)](#112-readbyte-b)
  - [1.2. 문자 단위 입출력](#12-문자-단위-입출력)
- [2. IO 클래스](#2-io-클래스)
  - [2.1. 장식대상 클래스](#21-장식대상-클래스)
  - [2.2. 장식하는 클래스](#22-장식하는-클래스)
  - [2.3. try-with-resources 블럭 선언](#23-try-with-resources-블럭-선언)
  - [2.4. 다양한 타입의 출력](#24-다양한-타입의-출력)
  - [References](#references)

# 1. Java IO

입출력을 위한 인터페이스와 클래스들

## 1.1. byte단위 입출력 

byte단위 입출력클래스는 모두 InputStream과 OutputStream이라는 추상클래스를 상속받아 만들어짐.

- InputStream -> 추상클래스
- OutPutStream -> 추상클래스

파일로 부터 읽어오기 위한 객체 -> FileInputStream
파일에 쓸수 있게 해주는 객체 -> FileOutputStream

### 1.1.1 read()

- read()메소드가 byte를 리턴한다면 끝을 나타내는 값을 표현할 수가 없기 때문에, byte가 아닌 int를 리턴한다.
- 읽어들일 것이 있다면 항상 양수를 리턴한다고 볼 수 있다.
- FileInputStream과 FileOutputStream을 이용하여, 1바이트씩 읽어들여 1바이트씩 저장
- read()메소드가 리턴하는 타입은 정수인데, 정수 4바이트중 마지막 바이트에 읽어들인 1바이트를 저장한다.
- **read()메소드는 더이상 읽어들일 것이 없을때 -1을 리턴한다.**
  
```java
import java.io.*;

public class ByteExam2 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        long StartTime = System.currentTimeMillis();
        try {
            fis = new FileInputStream("src\\Javabasic\\ByteExam1.java");
            fos = new FileOutputStream("copy1.txt");

            int readData = -1;
            while ((readData = fis.read()) != -1) {
                fos.write(readData);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            try {
                fis.close();
                fos.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        long lastTime = System.currentTimeMillis();
        System.out.println(lastTime-StartTime); //14
    }
}

```
### 1.1.2 read(byte[] b)

- 파일로 부터 512byte씩 읽어들여 파일에 512byte씩 저장하는 프로그램을 작성
- byte[] buffer = new byte[512];
- 512byte만큼 읽어 들이기 위해 byte배열을 사용
- read()보다 더 빠르다.
```java

import java.io.*;

public class ByteExam1 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        long StartTime = System.currentTimeMillis();
        try {

            fis = new FileInputStream("src\\Javabasic\\byteExam1.java");
            fos = new FileOutputStream("copy1.txt");
            
            int readCount;
            byte[] readByte = new byte[512];
            while ((readCount = fis.read(readByte)) != -1) {
                fos.write(readByte);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fis.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        long lastTime = System.currentTimeMillis();
        System.out.println(lastTime-StartTime); //9
    }
}

```
## 1.2. 문자 단위 입출력 

문자(char)단위 입출력클래스는 모두 Reader와 Writer라는 추상클래스를 상속받아 만들어짐.

- Reader -> 추상클래스
- Writer -> 추상클래스

# 2. IO 클래스

## 2.1. 장식대상 클래스

1. 파일로 부터 입력받고 쓰기 위한 클래스 : 
  - FileInputStream, FileOutputStream, FileReader, FileWriter

2. 배열로 부터 입력받고 쓰기 위한 클래스 : 
- ByteArrayInputStream, ByteArrayOutputStream, CharReader, CharWriter

## 2.2. 장식하는 클래스
- PrintWriter :  pintln()메소드를 가지고 있다.
- BufferedReader는 한줄 입력받는 readLine()메소드를 가지고 있다.

## 2.3. try-with-resources 블럭 선언

- java io객체는 인스턴스를 만들고, 모두 사용하면 close()메소드를 호출해야 한다.
- close()메소드를 사용자가 호출하지 않더라도, Exception이 발생하지 않았다면 자동으로 close()가 되게 할 수 있는 방법

```java
        try(
                //io객체 선언
        ){
                //io객체 사용
        }catch(Exception ex){
            ex.printStackTrace();
        }
```
## 2.4. 다양한 타입의 출력

다양한 타입으로 저장 할 수 있는 DataOutputStream
- wirteInt() - 정수값으로 저장
- wirteBoolean() - boolean값으로 저장
- writeDouble() - double 값으로 저장
  
```java
import java.io.*;

public class ByteExam3 {
    public static void main(String[] args) {

        DataInputStream in = null;
        DataOutputStream out = null;
        try {
            in = new DataInputStream(new FileInputStream("src\\javabasic\\byteExam3.java"));
            out = new DataOutputStream(new FileOutputStream("copy.txt"));
           
            int readCount;
            boolean typeBoolean = false;
            while((readCount = in.read()) != -1) {
                out.writeInt(readCount); // Int -> 4byte
                out.writeDouble(readCount); //Double -> 8byte
                out.writeBoolean(typeBoolean); //boolean ->  1byte         
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
```

대신 인코딩이 아래처럼 출력된다.

![](https://images.velog.io/images/withcolinsong/post/46a29a60-8931-4ff8-adf3-9766ab9842a4/image.png)

## References
- [프로그래머스](https://programmers.co.kr/) : ** 강의를 듣고 정리한 자료입니다.**
- 🎈2020.11.21
- 🎈정리 : VScode

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)