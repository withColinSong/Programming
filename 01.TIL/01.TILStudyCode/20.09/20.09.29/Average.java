package com.ex01;

import java.util.Scanner;

public class array {

	public static void main(String[] args) {
		// 다음과 같이 학생들의 성적을 받아서 평균을 구하는 프로그램을 작성하라.
		
		Scanner scan = new Scanner(System.in);
		
		int[] student = new int [2];
		
		//변수 정하기
		int i=0;
		int a=0;
		int count=0;
		int sum = 0;
		
		//프로그램 시작
		System.out.println("학생의 수를 입력하시오.");
		scan.nextInt();
		
		for(i=0; i<student.length; i++) {
			System.out.println("학생 " + (i+1) + "의 성적을 입력하시오. ");
			a = scan.nextInt();
			student[i] = a;
			if(a > 100) {
				System.out.println("잘못된 성적입니다. 다시 입력하시오.");
				System.out.println("학생 " + (i+1) + "의 성적을 입력하시오. ");
				a = scan.nextInt();
			}
			sum = sum + a;
			count++;
		}
		
		//출력
		System.out.println("성적 평균은 : " + (sum/(double)count));
	}

}
