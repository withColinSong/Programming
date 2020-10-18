
![](https://images.velog.io/images/withcolinsong/post/dcff24aa-9761-4791-8160-a2af2f3d1f83/image.png)

```java
public class test01 {
	public static void main(String[] args) {
		int[][] intArray = new int[5][5]; 

		int i = 0;
		int j = 0;
		int val = 1;
		int sum = 0;

		//배열의 값 넣기
		for(i=0; i<intArray.length; i++) {
			for(j=0; j<intArray.length; j++) {
				intArray[i][j] = val;
				val++;
				if(i + j == 4) {
					sum = sum +intArray[i][j];
				}
			}
		}  
		
		System.out.println(sum);
	}

}
```
