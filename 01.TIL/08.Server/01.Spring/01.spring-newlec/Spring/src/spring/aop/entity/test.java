package spring.aop.entity;

import org.springframework.stereotype.Component;


public class test implements Exam{

	@Override
	public int total() {
		System.out.println("test");
		return 0;
	}

	@Override
	public float avg() {
		System.out.println("test");
		return 0;
	}

}
