package com.ex01;

public class Class01 {
	int ivalue;
	float fvalue;
	
	void print() {
		System.out.println("ivalue  : " + ivalue);
		System.out.println("fvalue : " +  fvalue);
	}
	
	public Class01() {
		ivalue = 10;
		fvalue = 1.2345f;
		print();
	}
	
	public static void main(String[] args) {
		
		Class01 numberBox = new Class01();
		

	}

}
