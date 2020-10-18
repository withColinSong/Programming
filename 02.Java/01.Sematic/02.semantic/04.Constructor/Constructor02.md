
# 생성자

```
public class Car {
	String color;
	String gearType;
	int door;
	
	
	public Car() {} //기본 생성자
	
	public Car(String color, String gearType, int door) {
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
	
	public static void main(String[] args) {
		Car c = new Car("black", "auto", 4);


	}

}
```

![image](https://user-images.githubusercontent.com/71534090/95643864-0efe3600-0aed-11eb-92a5-5494d3b5de87.png)
