# 목차

- [목차](#목차)
- [1. Java IO](#1-java-io)
- [2. 입력 스트림 / 출력 스트림](#2-입력-스트림--출력-스트림)
  - [2.1. InputStream(도착지)](#21-inputstream도착지)
  - [2.2. OutputStream(출발지)](#22-outputstream출발지)
  - [2.3. Reader](#23-reader)
  - [2.4. Writer](#24-writer)
- [3. 파일 입출력](#3-파일-입출력)
  - [3.1. File 클래스](#31-file-클래스)
  - [3.2. FileInputStream / FileOutputStream](#32-fileinputstream--fileoutputstream)
- [4. 네트워크 입출력](#4-네트워크-입출력)

# 1. Java IO

- 스트림은 데이터가 단일 방향으로 연속으로 흐르는 것을 의미

출발지(입력)
- 키보드
- 파일(읽기)
- 소켓(외부의 데이터가 프로그램으로)

도착지(출력)
- 화면
- 파일(쓰기)
- 소켓(프로그램에서 데이터가 외부로)

# 2. 입력 스트림 / 출력 스트림

프로그램이 데이터의 출발지냐 도착지냐에 따라 스트림의 종류가 결정된다.  

1. 프로그램이 출발지인 경우:
     1. 파일 쓰기
     2. 데이터 송신(소켓)

- 프로그램의 데이터가 모니터로 나감(화면 출력)
- 프로그램의 데이터가 네트워크를 통해 나감(데이터 전송)
- 프로그램의 데이터가 파일로 나감(파일 쓰기)

2. 프로그램이 도착지인 경우:
     1. 파일 읽기
     2. 데이터 수신(소켓)
     3. 키 입력
   
- 키보드에서 입력된 데이터가 프로그램에 도착(키 입력)
- 네트워크 통해 들어온 데이터가 프로그램에 도착(데이터 수신)
- 파일로 부터 들어온 데이터가 프로그램에 도착(파일 읽기)

스트림은 크게 두 가지 종류로 나뉜다.  

- 바이트 기반 스트림
- 문자 기반 스트림

바이트 기반 스트림의 입력 스트림과 출력 스트림의 최상위 클래스
- InputStream(abstract)
- OutputStream(abstract)

문자 기반 스트림
- Reader (Input)
- Writer (Ouput)

## 2.1. InputStream(도착지)

InputStream -  바이트 기반 입력 스트림의 최상위 클래스  

|리턴타입|메소드|설명|
|-|-|-|
|int|read()|입력 스트림에서 1바이트 읽고 읽은 바이트 반환|
|int|read(byte[] b)|입력 스트림에서 읽은 바이트를 파라미터로 넘어온 바이트 배열에 저장하고 읽은 바이트 수를 반환|
|int|read(byte[] b, int off, int len)|len개의 바이트만큼 읽고, 파라미터로 넘어온 배열의 b[off]부터 len개를 저장한다. 반환되는 값은 실제로 읽은 바이트 수이기 때문에 len보다 작을 수 있다.|
|void|close()|사용한 자원을 반납하고 입력 스트림을 닫는다. 필수.|


- `int read()` : 한 바이트만 읽음
-  `int read(byte[] b)` : 파라미터로 넘겨준 b에 데이터를 저장하고, 읽은 바이트 수를 반환
-  `read(byte[] b, int off, int len)`
   - length개의 바이트를 읽어
   - b[offset]에 저장
- `void close()` : 자원 반납을 하고 입력 스트림을 받음 (필수)

## 2.2. OutputStream(출발지)

OutputStream - 바이트 기반 출력 스트림의 최상위 클래스  

|리턴 타입|메소드|설명|
|-|-|-|
|void|write(int b)|출력 스트림으로 1바이트 보냄. (int의 끝 바이트)|
|void|write(byte[] b)|출력 스트림으로 b의 데이터를 모두 보냄.|
|void|write(byte[] b, int off, int len)|b[off]부터 len만큼 보냄|
|void|flush()|버퍼에 있는 모든 바이트를 출력함(보냄)|
|void|close()|사용한 자원을 반납하고 출력 스트림을 닫는다. 필수.|

- `void write(int b)` : int 중에서 끝의 바이트 하나만 씀
- `void write(byte[] b)` : 출력 스트림으로 b를 보냄
- `void write(byte[] b, int offset, int length)` : b[offset]으로 부터 length만큼을 출력
- `void flush()`: 버퍼에 있는 모든 데이터 출력(보냄)
- `void close()`: 사용한 자원을 반납하고 출력 스트림을 닫음 (필수)


## 2.3. Reader

Reader는 문자 기반 입력 스트림의 최상위 클래스다.  

|리턴 타입|메소드|설명|
|-|-|-|
|int|read()|단 하나의 문자를 읽고 리턴|
|int|read(char[] cbuf)|cbuf에 읽은 문자 배열을 저장하고 읽은 문자 수 리턴|
|int|read(char[] cbuf, int off, int len)|len개의 문자를 읽고 cbuf[off]부터 len개 저장. 읽은 문자 수 리턴|
|void|close()|사용한 자원을 반납하고 입력 스트림을 닫는다. 필수.|


- `int read(char[] cbuf)` : cbuf에 읽은 문자 배열을 저장하고 읽은 문자 수를 리턴(int)
- `void close()`: 사용한 자원 반납. 입력 스트림 닫음(필수)

## 2.4. Writer

Writer는 문자 기반 출력 스트림의 최상위 클래스다.  

|리턴 타입|메소드|설명|
|-|-|-|
|void|write(int c)|한 문자를 보냄(c 끝의 2바이트)|
|void|write(char[] cbuf)|cbuf의 모든 문자를 보냄|
|void|write(char[] cbuf, int off, int len)|cbuf[off]부터 len개의 문자를 보냄|
|void|write(String str)|문자열을 보냄|
|void|write(String str, int off, int len)|문자열의 off번째부터 len개 보냄|
|void|flush()|버퍼에 있는 모든 바이트를 출력함(보냄)|
|void|close()|사용한 자원을 반납하고 출력 스트림을 닫는다. 필수.|

- `void write(char[] cbuf)` : cbuf를 출력함
- `void close()`

# 3. 파일 입출력

파일 읽기

- File 클래스
- FileInputStream/FileOutputStream
- FileReader/FileWriter

## 3.1. File 클래스

기본적인 사용 방법은 다음과 같다.  

```java
File file = new File("path/to/file");
```

대표적으로 많이 사용할 메소드만 정리함.  

|리턴 타입|메소드|설명|
|-|-|-|
|boolean|exists()|파일 존재 여부|
|boolean|createNewFile()|새 파일 생성|
|File|getParentFile()|부모 디렉토리를 File 객체로 리턴|
|String|getPath()|전체 경로 리턴|
|boolean|isFile()|파일이야?|
|boolean|isDirectory()|디렉토리야?|
|long|length()|파일 크기|

- `boolean exists()`: 해당 파일이 존재하는지 여부
- `boolean createNewFile()`: 생성 성공 시 true
- `long length()`: 파일 크기

## 3.2. FileInputStream / FileOutputStream

간단한 파일 카피 프로그램을 만들어보자.  

```java
final File fileToCopy = new File("source/file/path");
try (
        final FileInputStream fis = new FileInputStream(fileToCopy);
        final FileOutputStream fos = new FileOutputStream("dest/file/path");
) {
    final byte[] buffer = new byte[4096];
    int result;
    while ((result = fis.read(buffer)) != -1) {
        fos.write(buffer);
        System.out.println("read byte: " + result);
    }
} catch (FileNotFoundException e) {
    System.err.println("파일이 없어요!");
} catch (IOException e) {
    System.err.println("파일을 읽는 도중 문제가 발생했어요!");
}
```

```java
public class Application {

    public static void main(String[] args) throws InterruptedException {
        try (
                final FileInputStream fis =
                        new FileInputStream("C:\\Users\\user1\\Desktop\\dog.png");
                final FileOutputStream fos =
                        new FileOutputStream("C:\\Users\\user1\\Desktop\\dog_copied.png");
        ) {
            // fis - 읽을 파일
            final byte[] buffer = new byte[4096];
            int result;     // 읽은 바이트 수
            while ((result = fis.read(buffer)) != -1) {
                // fos - 쓸 파일
                fos.write(buffer);
                System.out.println("읽은 바이트 수: " + result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


```

# 4. 네트워크 입출력

```java
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Application {

	public static void main(String[] args) {
		try {
			// 서버 소켓 생성
			final ServerSocket serverSocket = new ServerSocket(12345);
			
			//외부에 접속을 기다림
			final Socket socket = serverSocket.accept();
			socket.getInputStream(); // from client (클라이언트에서 오는 데이터)
			socket.getOutputStream(); // to client(클라이언트로 보내는 데이터)
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}

```
