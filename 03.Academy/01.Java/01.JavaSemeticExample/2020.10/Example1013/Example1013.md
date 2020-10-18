# 버블정렬
### 코드를 오름차순으로 정렬하고, 오류나는 부분을 수정해라.

```java
public class Test2{
	public class BobbleSort {
		public static void main(String[] args) {

			int[] arr = {4,7,3,6,1};
			int sum = 0;

			for(int i=0; i<arr.length; i++) {
				for(int j=0; j<arr.length-1-i; j++) {
					if(arr[j] < arr[j+1]) {
						int temp = arr[j];
						arr[j] = arr[j+1];
						arr[j+1] = temp;
					}
				}
			}

			System.out.println("정렬 결과 : ");
			for(int i=0; i<arr.length; i++) {
				System.out.println(arr[i] + "\t");
			}

			System.out.println("\n입력한 수의 총 합은 : " + sum);
		}

	}
}
```


```java

public class BobbleSort02 {
	public static void main(String[] args) {

		int[] arr = {4,7,3,6,1};
		int sum = 0;

		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length-1-i; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}

		System.out.println("정렬 결과 : ");
		for(int i=0; i<arr.length; i++) {
			sum = sum + arr[i];
			System.out.println(arr[i] + "\t");
		}

		System.out.println("\n입력한 수의 총 합은 : " + sum);
	}

}

```
