package Day15;

interface iVehicle
{
	void show();
}
// 자동차 클래스
class Car1 implements iVehicle
{
	private int num;
	private double gas;

	public Car1(int n, double g)
	{
		num = n; gas = g;
		System.out.println("차량 번호가 " + num + " 이며, 연료 양이 " + gas + " 인 자동차가 만들어졌습니다.");
	}
	public void show()
	{
		System.out.println("차량 번호는 " + num + " 입니다.");
		System.out.println("연료 양은 " + gas + " 입니다.");
	}
}
// 비행기 클래스
class Plane1 implements iVehicle
{
	private int flight;

	public Plane1(int f)
	{
		flight = f;
		System.out.println("비행기 번호가 " + flight +   " 인 비행기가 만들어졌습니다.");
	}
	public void show()
	{
		System.out.println ("비행기 번호는 "+ flight + " 입니다.");
	}
}
class Sample3
{
	public static void main(String[] args)
	{

	}
}
