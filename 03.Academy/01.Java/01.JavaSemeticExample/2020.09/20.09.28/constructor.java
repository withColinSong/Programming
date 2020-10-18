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
