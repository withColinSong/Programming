package com.chap03;

public class Ex29 {

	static int recursiveSum(int n) {
		if (n == 1) { // n이 1이면, 그냥 1을 반환함.
			return 1;
		}

		return n + recursiveSum(n - 1);
		// n이 1이 아니면, n을 1부터 (n-1)까지의 합과 더한 값을 반환함.
	}

	public static void main(String[] args) {

		int res = recursiveSum(10); 
		System.out.println(res);
	}

}

풀이 :

1. recursiveSum(10)이 int n에 들어가서 if문의 조건을 확인한다.
2. 현재 10이 1과 같지 않으니 false 이므로, return n + recursiveSum(n - 1); 여기 구문을 실행한다.
3. 10(return n) + recursiveSum(n-1) + 9.... 8 + 7 ..6 ..1  : 55.
4 n이 1이 될 때까지 실행 후 n이 1과 같을 때 구문은 끝이난다.

