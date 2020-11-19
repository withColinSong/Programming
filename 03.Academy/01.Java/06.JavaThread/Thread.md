[목차](#목차)
- [1. 블로킹](#1-블로킹)
- [2. 스레드](#2-스레드)
  - [2.1. 자바에서 스레드 생성 및 실행](#21-자바에서-스레드-생성-및-실행)
    - [2.1.1. Runnable 사용](#211-runnable-사용)
    - [2.1.2. Thread 상속](#212-thread-상속)
  - [2.2. 스레드 우선순위](#22-스레드-우선순위)
  - [2.3. 동기화(synchronization)](#23-동기화synchronization)
    - [2.3.1. 공유 객체 사용시 문제점](#231-공유-객체-사용시-문제점)
    - [2.3.2. 문제 해결](#232-문제-해결)
    - [2.3.3. 동기화 사용 시 주의점](#233-동기화-사용-시-주의점)
  - [2.4. 스레드 상태(라이프사이클)](#24-스레드-상태라이프사이클)
  - [2.5. 스레드 상태 제어](#25-스레드-상태-제어)
  - [2.6. 결론](#26-결론)

# 1. 블로킹

```java
public static void main(Stirng[] args) {
  //블로킹
  final Scanner scan = new Scanner(System.in);
  scanner.next();
  System.out.println("next가 종료되기 전까지 이곳에 오지 못함");
}
```

코드 실행 흐름이 블로킹 연산이 종료되기 전까지 멈춰있다.

대표적인 예

- IO
  - 소켓
  - 파일
- 사용자 입력

# 2. 스레드

- 시분할: 주어진 시간 조각(퀀텀 타임)을 받아서 각 스레드가 실행됨
- 컨텍스트: 실행하고 있던 시점의 상태(문맥)
- 컨텍스트 스위칭: 기존의 실행 정보를 저장하고 다른 컨텍스트로 전환하는 것
- 동시성: 동시에 실행되는 것 처럼 보임
- 병렬성: 실제로 동시에 실행 됨

## 2.1. 자바에서 스레드 생성 및 실행

- Runnable 인터페이스
- Thread 상속

### 2.1.1. Runnable 사용

1. Runnable 인터페이스 구현체로 스레드가 수행할 작업 정의
2. 스레드의 생성자 파라미터로 전달

```java
package Thread;

/**
 * 스레드의 생성자로 넘어감(passing)
 */

public class Task implements Runnable {

	
	
	/**
     * 스레드가 수행 할 작업을 작성
     */
	@Override
	public void run() {
		while(true) {
			System.out.println("안녕");
			try {
				Thread.sleep(1000);
			}catch (InterruptedException ignore) {
				
			}
		}
	}
}

```
```java
//실행
package Thread;

public class Application {
	public static void main(String[] args) {
		final Task task = new Task();
		final Thread thread = new Thread(task);
		thread.start();
		
	}
}

```

### 2.1.2. Thread 상속

1. Thread 클래스를 상속 받음
2. run 메소드 오버라이드에서 수행할 작업 정의

## 2.2. 스레드 우선순위

- 어떤 스레드가 더 중요한가?
  - 중요할 수록 CPU에게 더 많은 관심을 받고 많이 실행됨.
- 우선순위가 높아지면 처리율이 증가함

```java
public class ThreadPriority extends Thread {

    public ThreadPriority(String name) {
        setName(name);
    }

    @Override
    public void run() {
        long sum = 0;
        final long t1 = System.currentTimeMillis();
        for (int i = 0; i < 20_0000_0000; i++) {
            sum += i;
        }
        final long t2 = System.currentTimeMillis();
        System.out.printf("스레드 %s 수행시간: %d\n", getName(), t2 - t1);
    }
}

```

```java
public class Application {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            Thread thread = new ThreadPriority("Thread-" + (i + 1));
            if (i == 9) {
                thread.setPriority(Thread.MAX_PRIORITY);
            } else {
                thread.setPriority(Thread.MIN_PRIORITY);
            }
            thread.start();
        }
    }
}

```

## 2.3. 동기화(synchronization)

### 2.3.1. 공유 객체 사용시 문제점
```java
public class CriticalSection {
	private int data = 1000;
	
	public boolean extractData(int value) {
		if (data >= value) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
			data -= value;
			return true;
			
		}
		
		return false;
	}
	
	public int getData() {
		return data;
	}
}

```

```java
//스레드
public class Worker extends Thread{
	private final CriticalSection cs;
	
	public Worker(CriticalSection cs) {
		this.cs = cs;
	}
	
	@Override
	public void run() {
		while (cs.getData() > 0) {
			final int value = (int)(Math.random() * 3 + 1) * 100;
			if(cs.extractData(value)) {
				System.out.printf("[%s] %d 감소함. (cs:%d)\n",
				getName(), value, cs.getData());
			}
		}
	}
}
```

```java
// Main

```
### 2.3.2. 문제 해결

어떤 스레드가 사용하고 있는 `공유 객체`가 다른 스레드에 의한 변경을 되는 것을 막기 위해 작업이 끝날 때 까지 접근하지 못하도록 해야
데이터의 오염을 막을 수 있다.
오염을 막는 행위 -> `lock`

`synchronized` 키워드 사용

### 2.3.3. 동기화 사용 시 주의점

- 공유 객체에 접근하는 스레드가 많아지면 프로그램 전체 성능 하락할 우려 존재
- 공유 객체에 접근해서 작업하는 시간이 길어지면 프로그램 전체 성능 하락할 우려가 존재.

## 2.4. 스레드 상태(라이프사이클)

- 생성(NEW)
  - 실행 대기(RUNNABLE)
  - 실행
  - 일시 정지
- 종료


```java
//감시할 스레드

public class Watchdog extends Thread {
	private final Thread target;
	
	
	public Watchdog(Thread target) {
		this.target = target;
	}
	
	@Override
	public void run() {
		while (true) {
			final State state = target.getState();
			System.out.println("target thread" + state);
			
			if (State.NEW.equals(state)) {
				target.start();
			}
			
			//스레드가 죽은 값 TERMINATED
			if (State.TERMINATED.equals(state)) {
				System.out.println("감시 종료");
				break;
			}
			
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				
			}
		}
	}
}
```

```java
package Thread;

public class WorkerThread extends Thread{
	
	@Override
	public void run() {
		long sum = 0;
		for (int i = 0; i < 20_0000_0000; i++) {
			sum += i;
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		
		}
		for (int i = 0; i < 20_0000_0000; i++) {
			sum += i;
		}
	}
}
```


```java
// 결과창
target threadNEW
target threadRUNNABLE
target threadRUNNABLE
target threadRUNNABLE
target threadRUNNABLE
target threadRUNNABLE
target threadRUNNABLE
target threadRUNNABLE
target threadRUNNABLE
target threadTIMED_WAITING
target threadTIMED_WAITING
target threadTIMED_WAITING
target threadTIMED_WAITING
target threadTIMED_WAITING
target threadTIMED_WAITING
target threadTIMED_WAITING
target threadRUNNABLE
target threadRUNNABLE
target threadRUNNABLE
target threadRUNNABLE
target threadRUNNABLE
target threadRUNNABLE
target threadTERMINATED
감시 종료
```

## 2.5. 스레드 상태 제어
- sleep
- join
  
```java
package Thread;

public class FactorialThread extends Thread {
	
	private long data = 1;
	
	@Override
	public void run() {
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
	
		}
		
		for (int i = 1; i <= 20; i++) {
			data *= i;
		}
	}
	
	public long getData() {
		return data;
	}
}
```

```java
package Thread;

public class Application2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		final FactorialThread thread = new FactorialThread();
		thread.start();
		System.out.println("start후");
		
		thread.join();
		System.out.println("join후");
		final long result = thread.getData();
		
		System.out.println(result);

	}

}

```

## 2.6. 결론

- 실행 흐름을 두 개 이상 만들 수 있음
  - 블로킹 되는 부분을 다른 실행 흐름에 넘기면 메인 스레드는 하던 일을 마저 할 수 있다.

