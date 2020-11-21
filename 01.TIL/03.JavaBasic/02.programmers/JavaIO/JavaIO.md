# [목차](#목차)
- [목차](#목차)
- [1. Java IO](#1-java-io)
  - [1.1. byte단위 입출력](#11-byte단위-입출력)
    - [1.1.1 read()](#111-read)
  - [1.2. 문자 단위 입출력](#12-문자-단위-입출력)
- [2. IO 클래스](#2-io-클래스)
  - [2.1. 장식대상 클래스](#21-장식대상-클래스)
  - [2.2. 장식하는 클래스](#22-장식하는-클래스)

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

public class ByteExam1 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream("src\\Javabasic\\byteExam1.java");
            fos = new FileOutputStream("copy2.txt");
            
            int readCount;
            while ((readCount = fis.read()) != -1) {
                fos.write(readCount);
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



