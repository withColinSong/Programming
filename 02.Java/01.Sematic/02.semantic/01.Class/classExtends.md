# 상속이란? 

부모가 가진것을 자식에게 물려주는것을 의미한다.
노트북은 컴퓨터의 한 종류다.
침대는 가구의 한 종류다. 혹은 침대는 가구다.
소방차는 자동차다.
이렇게 말할 수 있는 관계를 is a 관계 혹은 kind of 관계라고 한다.

### Car 를 상속받은 Bus 를 class로 표현하는 방법

```
  public class Car{

    }

    public class Bus extends Car{

    }
```

- 자바는 클래스 이름 뒤에 extends 키워드를 적고 부모클래스 이름을 적게 되면 부모 클래스가 가지고 있는 것을 상속받을 수 있게 된다.
- 상속이란 부모가 가지고 있는 것을 자식이 물려받는 것을 말한다. 즉, 부모가 가지고 있는 것을 자식이 사용할 수 있게 된다.


- 부모클래스에 메소드 추가하기
```
 public class Car{
        public void run(){
            System.out.println("달리다.");
        }
    }
```

- Car를 상속받은 Bus 사용
```
 public class BusExam{
        public static void main(String args[]){
            Bus bus = new Bus();
            bus.run();  
            //Bus class 는 아무런 코드를 가지지 않는다. 그럼에도 run 이라는 메소드를 사용하는데 문제가 발생되지 않는다. 
        }   
    }
```

- Bus에 메소드 추가
```
 public class Bus extends Car{
        public void ppangppang(){
            System.out.println("빵빵");
        }       
    }
```

- Bus는 Car에서 물려받은 run메소드와 ppangppang메소드를 사용할 수 있게 된다.
- 부모가 가지고 있는 메소드외에 추가로 메소드를 선언하는 것을 확장하였다고 표현한다.


[참조](https://programmers.co.kr/learn/courses/5/lessons/186)
