
# BufferedReader 사용법


### abc.text
```text
1번째 줄  아무말
2번째 줄  아무말
3번째 줄  아무말
```

### BufferedReaderExample.java
```java
import java.io.*;

public class BufferedReaderExample {
    public static void main(String[] args) {
        try {
            InputStream in = new FileInputStream("C:\\Users\\user\\Desktop\\abc.txt");
            final InputStreamReader isr = new InputStreamReader(in);
            final BufferedReader br = new BufferedReader(isr);

            System.out.println(br.readLine());
            System.out.println(br.readLine());
            System.out.println(br.readLine());
            System.out.println("v:" + "".equals(br.readLine()));
            // br.readLine = null 일 시 false를 반환한다.

            } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
```

