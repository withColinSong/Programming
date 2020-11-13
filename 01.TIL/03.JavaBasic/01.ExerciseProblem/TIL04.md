# 문제코드
```java
package TV;

public class MyTv {
	boolean isPowerOn;
	int channel;
	int volume;


	final int MAX_VOLUMN = 100;
	final int MIN_VOLUMN = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;

	void turnOnoff() {
(1) isPowerOn의 값이 ture이면 false면 ture로 바꾼다.
	

	void volumeUp() {
	
(2) volumn의 값이 MAX_VOLUME보다 작을 때만 값을 1증가시킨다.

	}


	void volumeDown() {
(3) volumn의 값이 MIN_VOLUMN보다 클 때만 값을 1감소시킨다.
    
	}

	void channelUp( ) {
(4) channel의 값을 1증가시킨다.
만일 channel의 MAX_CHANNEL이면, channel의 값을 MIN_CHANNEL로 바꾼다.

	}

	void channelDown() {
		
(5) channel의 값을 1감소시킨다.
만일 channel의 MIN_CHANNEL이면, channal의 값을 MAX_CHANNEL로 바꾼다.

	}

	public static void main(String[] args) {

		MyTv t = new MyTv();

		t.channel = 100;
		t.volume = 0;
		System.out.println("CH : " + t.channel + ", VOL : " + t.volume);

		t.channelDown(); 
		t.volumeDown(); 
		System.out.println("CH : " + t.channel + ", VOL : " + t.volume);

		t.volume = 100;
		t.channelUp(); 
		t.volumeUp(); 

		System.out.println("CH : " + t.channel + ", VOL : " + t.volume);
	}
}


```

# 내 코드
```java

package TV;

public class MyTv {
	boolean isPowerOn;
	int channel;
	int volume;


	final int MAX_VOLUMN = 100;
	final int MIN_VOLUMN = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;

	void turnOnoff() {
		isPowerOn = !isPowerOn;
	}

	void volumeUp() {
		if(volume < MAX_VOLUMN) {
			volume++;
		}
	}


	void volumeDown() {
		if(volume > MIN_VOLUMN) {
			volume--;
		}
	}

	void channelUp( ) {
		if(channel == MAX_CHANNEL) {
			channel = MIN_CHANNEL;
		}
		channel++;
	}

	void channelDown() {
		
		if(channel == MIN_CHANNEL) {
			channel = MAX_CHANNEL;
		}
		channel--;
	}

	public static void main(String[] args) {

		MyTv t = new MyTv();

		t.channel = 100;
		t.volume = 0;
		System.out.println("CH : " + t.channel + ", VOL : " + t.volume);

		t.channelDown(); 
		t.volumeDown(); 
		System.out.println("CH : " + t.channel + ", VOL : " + t.volume);

		t.volume = 100;
		t.channelUp(); 
		t.volumeUp(); 

		System.out.println("CH : " + t.channel + ", VOL : " + t.volume);
	}
}
```
