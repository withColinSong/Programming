# 1. Thread

- 동시에 여러가지 작업을 동시에 수행할 수 있게 하는 것
- 프로세스란 현재 실행되고 있는 프로그램
- 자바 프로그램은 JVM에 위해 실행된다. 이 JVM도 프로그램중에 하나이다.
- 운영체제 입장으로 보면 자바도 하나의 프로세스로 실행
- 워드프로세서가 하나의 프로세스라면, 하나의 프로세스 안에서도 여러개의 흐름이 동작할 수 있다. 

## 1.1 스레드 만들기

### 1.1.1 Extends Thread

1. Thread를 상속 받아서 쓰레드를 생성하는 방법
- java.lang.Thread클래스를 상속받는다. 
- Thread가 가지고 있는 run()메소드를 오버라이딩.
- 쓰레드를 생성하고, Thread 클래스가 가지고 있는 start() 메소드를 호출 한다.
```java
public class MyThread extends Thread {
        String str;
        public MyThread(String str){
            this.str = str;
        }

        public void run(){
            for(int i = 0; i < 10; i ++){
                System.out.print(str);
                try {
                    //컴퓨터가 너무 빠르기 때문에 수행결과를 잘 확인 할 수 없어서 Thread.sleep() 메서드를 이용해서 조금씩 
                    //쉬었다가 출력할 수 있게 한다. 
                    Thread.sleep((int)(Math.random() * 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } 
        } 
    }

```

### 1.1.2 Runnable

1. Java는 단일상속으로, 이미 상속 받은 클래스는 상속을 받을 수 없기 때문에
interface Runnable을 사용한다.
`Runnable -> interface`

```java
    public class MyThread implements Runnable {
        String str;
        public MyThread(String str){
            this.str = str;
        }

        public void run(){
            for(int i = 0; i < 10; i ++){
                System.out.print(str);
                try {
                    Thread.sleep((int)(Math.random() * 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } 
        } 
    }
```

- Thread를 상속받지 않았기 때문에 Thread가 아니다.
- Thread를 생성하고, 해당 생성자에 MyThread를 넣어서 Thread 생성

```java
  public class ThreadExam {  
        public static void main(String[] args) {
            MyThread r1 = new MyThread("MyThread r1");
            MyThread r2 = new MyThread("MyThread r2");

            Thread t1 = new Thread(r1);
            Thread t2 = new Thread(r2);

            t1.start();
            t2.start();
            System.out.print("main end");  
        }   
    }
```

- Thread.java

```java
public Thread(Runnable target) {
        this(null, target, "Thread-" + nextThreadNum(), 0);
    }
```

### 1.1.3. 코드
```java
class Mythread extends Thread {

    @Override
    public void run() {
        System.out.println("Thread를 상속받은 Class");
    }
}

class RunnableThread implements Runnable {
    @Override
    public void run() {
        System.out.println("Runnable를 상속받은 Class");
    }
}

public class ThreadExam {
    public static void main(String[] args) {
        Mythread myThread = new Mythread();
        myThread.start();

        RunnableThread rt = new RunnableThread();
        Thread myThread1 = new Thread(rt);
        myThread1.start();
    }
}
```

![](https://images.velog.io/images/withcolinsong/post/5f2b3ec5-c2ed-4c34-952f-004f85a7abc0/image.png)

## References
- [프로그래머스](https://programmers.co.kr/) : ** 강의를 듣고 정리한 자료입니다.**
- 🎈2020.11.22
- 🎈정리 : VScode

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)