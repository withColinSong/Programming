# [목차](#목차)
- [목차](#목차)
- [1. Java IO](#1-java-io)
  - [1.1. byte단위 입출력](#11-byte단위-입출력)
    - [1.1.1 read()](#111-read)
    - [1.1.2 read(byte[] b)](#112-readbyte-b)
  - [1.2. 문자 단위 입출력](#12-문자-단위-입출력)
    - [1.2.1. Char 단위 입출력(Console)](#121-char-단위-입출력console)
    - [1.2.2 Char 단위 입출력(File)](#122-char-단위-입출력file)
- [2. IO 클래스](#2-io-클래스)
  - [2.1. 장식대상 클래스](#21-장식대상-클래스)
  - [2.2. 장식하는 클래스](#22-장식하는-클래스)
    - [2.1.1. try-with-resources 블럭 선언](#211-try-with-resources-블럭-선언)
    - [2.1.2. Try-with-resources로 close()가 호출되는 객체는?](#212-try-with-resources로-close가-호출되는-객체는)
  - [2.4. 다양한 타입의 출력](#24-다양한-타입의-출력)
  - [References](#references)

# 1. Java IO

입출력을 위한 인터페이스와 클래스들

## 1.1. byte단위 입출력 

byte단위 입출력클래스는 모두 InputStream과 OutputStream이라는 추상클래스를 상속받아 만들어짐.

- InputStream -> 추상클래스
- OutPutStream -> 추상클래스

- 파일로 부터 읽어오기 위한 객체 -> FileInputStream
- 파일에 쓸수 있게 해주는 객체 -> FileOutputStream

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
            fos = new FileOutputStream("copy1.txt"); //경로를 따로 저장하지 않으면 현재 디렉토리에 저장된다.

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

char단위 입출력 클래스는 클래스 이름이 Reader나 Writer로 끝이 난다.
문자(char)단위 입출력클래스는 모두 Reader와 Writer라는 추상클래스를 상속받아 만들어짐.

- Reader -> 추상클래스
- Writer -> 추상클래스

### 1.2.1. Char 단위 입출력(Console)


char단위 입출력 클래스를 이용해서 키보드로부터 한 줄 입력받아서 콘솔에 출력

- System.in - 키보드를 의미 (InputStream)
  - System.in은 InputStream 타입이므로 BufferedReader의 생성자에 바로 들어갈 수 없으므로 InputStreamReader 클래스를 이용해야 함.

- BufferedReader - 한 줄씩 입력받기 위한 클래스
  - BufferedReader 클래스의 생성자는 InputStream을 입력받는 생성자가 없다.

```java
import java.io.*;

public class CharIOExam1 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        try {
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(line);
    }
}
```

### 1.2.2 Char 단위 입출력(File)

- 파일에서 한 줄씩 입력 받아서 파일에 출력
  - 파일에서 읽기위해서 FileReader 클래스 이용
  - 한 줄 읽어 들이기 위해서 BufferedReader 클래스 이용
    - BufferedReader 클래스가 가지고 있는 readLine() 메소드가 한줄씩 읽게 해준다.
    - readLine()메소드는 읽어낼 때 더 이상 읽어 들일 내용이 없을 때 null을 리턴한다.
  - 파일에 쓰게하기 위해서 FileWriter 클래스 이용
  - 편리하게 출력하기 위해서 PrintWriter 클래스 이용

# 2. IO 클래스

## 2.1. 장식대상 클래스

1. 파일로 부터 입력받고 쓰기 위한 클래스 : 
  - FileInputStream, FileOutputStream, FileReader, FileWriter

2. 배열로 부터 입력받고 쓰기 위한 클래스 : 
- ByteArrayInputStream, ByteArrayOutputStream, CharReader, CharWriter

## 2.2. 장식하는 클래스
- PrintWriter :  pintln()메소드를 가지고 있다.
- BufferedReader는 한줄 입력받는 readLine()메소드를 가지고 있다.

### 2.1.1. try-with-resources 블럭 선언

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

### 2.1.2. Try-with-resources로 close()가 호출되는 객체는?

Try-with-resources가 모든 객체의 close()를 호출해주지 않는다.

- AutoCloseable을 구현한 객체만 close()가 호출.
- AutoCloseable은 인터페이스이며 자바7부터 지원

```java
java.lang.Object
  java.io.InputStream
    java.io.FilterInputStream
      java.io.BufferedInputStream

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

- 콘솔창에서 값 확인하기
```java
import java.io.*;

public class ByteExam4 {
    public static void main(String[] args) {
        try(
                DataInputStream in = new DataInputStream(new FileInputStream("copy.txt"));

                ) {
             // 순서대로 ByteExam3의  int, boolean, double
            //copy.txt에서는 볼 순 없지만 console로 확인할 수 있다.
            int i = in.readInt();
            Boolean B = in.readBoolean();
            Double d = in.readDouble();


            System.out.println(i);
            System.out.println(B);
            System.out.println(d);

        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
```

## References
- [프로그래머스](https://programmers.co.kr/) : ** 강의를 듣고 정리한 자료입니다.**
- 🎈2020.11.21
- 🎈정리 : VScode

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)