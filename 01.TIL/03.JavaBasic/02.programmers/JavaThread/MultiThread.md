# [목차](#목차)
- [목차](#목차)
- [1. MusicPlayer](#1-musicplayer)
- [2. MusicBox](#2-musicbox)
- [3. Music (Main class)](#3-music-main-class)
- [4. Result](#4-result)
  - [References](#references)

# 1. MusicPlayer
```java
public class MusicPlayer {
    public void tryThread() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void wisue() {
        for(int i = 0; i < 3; i++) {
            System.out.println("위수 : 흐르는 시간 속에 우리는 아름다워\n");
            tryThread();
        }
    }

    public void anoc() {
        for(int i = 0; i < 3; i++) {
            System.out.println("아녹 : 닮은날\n");
            tryThread();
        }
    }
    public void oohyo() {
        for(int i = 0; i < 3; i++) {
            System.out.println("우효 : 민들레\n");
            tryThread();
        }
    }
    public void hello_ga_yeong() {
        for(int i = 0; i < 3; i++) {
            System.out.println("안녕하신가영 : 지금이 우리의 전부\n");
            tryThread();
        }
    }
}
```

# 2. MusicBox
```java
package Javabasic;

public class MusicBox extends Thread{
    int type;
    MusicPlayer musicPlayer;

    public MusicBox(int type, MusicPlayer musicPlayer) {
        this.type = type;
        this.musicPlayer = musicPlayer;
    }

    @Override
    public void run() {
        switch(type) {
            case 1 :
                musicPlayer.wisue();
                break;
            case 2 :
                musicPlayer.anoc();
                break;
            case 3 :
                musicPlayer.hello_ga_yeong();
                break;
            case 4 :
                musicPlayer.oohyo();
                break;
        }
    }
}

```

# 3. Music (Main class)
```java


public class Music {
    public static void main(String[] args) {
        MusicPlayer musicPlayer = new MusicPlayer();

        MusicBox player1 = new MusicBox(1, musicPlayer);
        MusicBox player2 = new MusicBox(2, musicPlayer);
        MusicBox player3 = new MusicBox(3, musicPlayer);
        MusicBox player4 = new MusicBox(4, musicPlayer);

        player1.start();
        player2.start();
        player3.start();
        player4.start();
    }
}
```
# 4. Result
![](https://images.velog.io/images/withcolinsong/post/1dcc89ff-cf46-4a77-91b0-b51c958257f0/image.png)

## References
- [프로그래머스](https://programmers.co.kr/) : 직접 코드 짜보기
- 🎈2020.11.22
- 🎈정리 : VScode

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)