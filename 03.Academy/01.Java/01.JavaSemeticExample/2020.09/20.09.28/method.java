package com.exmethod;

// 자동차 클래스
class Car
{
    int num;
    double gas;
    
    void show()
    {
        System.out.println("차량 번호는 " + num );
        System.out.println("연료 양은 " + gas );
    }
}

class Sample1

{
    public static void main(String[] args)
    {
        Car car1 = new Car();
        
        car1.num = 1234;
        car1.gas = -10.0;
        
        car1.show();
    }
}


package com.exmethod;

class Car1 {
	private int num;
	private double gas;

	public void setNumGas(int n, double g) {
		if (g > 0 && g < 1000) {
			num = n;
			gas = g;
			System.out.println("차량 번호를 " + num + " , 연료 양을 " + gas);
		} else {
			System.out.println(g + " 는 올바른 연료 양이 아닙니다.");
			System.out.println("연료 양을 바꿀 수 없습니다.");
		}
	}

	public void show() {
		System.out.println("차량 번호는 " + num + " 입니다.");
		System.out.println("연료 양은 " + gas + " 입니다.");
	}
}

class Sample2 {
	public static void main(String[] args) {
		Car1 car1 = new Car1();

		// 이러한 접근은 불가능합니다.
		// car1.num = 1234;
		// car1.gas = -10.0;

		car1.setNumGas(1234, 20.5);
		car1.show();

		System.out.println("잘못된 연료 양 (-10.0)을 저장하겠습니다 ....");

		car1.setNumGas(1234, -10.0);
		car1.show();
	}
}


package com.exmethod;

class Car2 {
	private int num;
	private double gas;

	public void setCar(int n) { //메소드를 들어올 때 파라미터가 있어야 가능하다.
		num = n;
		System.out.println("차량 번호를 " + num + " 으로 바꾸었습니다.");
	}

	public void setCar(double g) {
		gas = g;
		System.out.println("연료 양을 " + gas + " 으로 바꾸었습니다.");
	}

	public void setCar(int n, double g) {
		num = n;
		gas = g;
		System.out.println("차량 번호를 " + num + ", 연료 양을 " + gas);
	}

	public void show() {
		System.out.println("차량 번호는 " + num + " 입니다.");
		System.out.println("연료 양은 " + gas + " 입니다.");
	}
}

class Sample3 {
	public static void main(String[] args) {
		Car2 car1 = new Car2();
		car1.setCar(1234, 20.5);
		car1.show();
		System.out.println("차량 번호만 변경 되었습니다.");
		car1.setCar(2345);
		car1.show();
		System.out.println("연료량만 변경 되었습니다.");
		car1.setCar(30.5);
		car1.show();
	}
}

package com.exmethod;
// 자동차 클래스
class Car3
{
    private int num;
    private double gas;
    
    public Car3 () 
    {
        num = 0;
        gas = 0.0;
        System.out.println("자동차가 만들어졌습니다.");
    }
    
    public void show()
    {
        System.out.println("차량 번호는 " + num + " 입니다.");
        System.out.println("연료 양은 " + gas + " 입니다.");
    }
}

class Sample4
{
    public static void main(String[] args)
    {
    	Car3 car1 = new Car3();
        
        car1.show();
    }
}


package com.exmethod;
//자동차 클래스
class Car4
{
    private int num;
    private double gas;
    
    
    //생성자
    public Car4 ()
    {
        num = 0;
        gas = 0.0;
        System.out.println("자동차가 만들어졌습니다.");
    }
    public Car4(int n, double g)
    {
        num = n;
        gas = g;
        System.out.println("차량 번호가 " + num + ", 연료 양이 " + gas);
    }
    public void show()
    {
        System.out.println("차량 번호는 " + num + " 입니다.");
        System.out.println("연료 양은 " + gas + " 입니다.");
    }
}

class Sample5
{
    public static void main(String[] args)
    {
    	Car4 car1 = new Car4();
        car1.show();
        
        Car4 car2 = new Car4(1234, 20.5);
        car2.show();
    }
}
