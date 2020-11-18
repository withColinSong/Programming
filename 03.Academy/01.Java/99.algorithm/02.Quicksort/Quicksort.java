public class Quicksort {

	public static List<Integer> sort(List<Integer> origin) {
		// 0. 탈출 조건 선정
		if(origin.isEmpty()) {
			return origin;
		}

		// 1. 피벗 선정
		final Integer pivot = origin.get(0);

		// 2. 피벗 중심으로 분류
		List<Integer> less = new ArrayList<>();
		List<Integer> greater = new ArrayList<>();
		List<Integer> pivots = new ArrayList<>();
		
		for(Integer n : origin) { // 피벗보다 작음
			if(n <= pivot) {
				less.add(n);
			} else if (n > pivot) { // 피벗보다 큼
				greater.add(n);
			} else { // 피벗과 값 같음
				pivots.add(n);
			}
		}
		// 3. 분류된 새로운 리스트들을 정렬
		less = sort(less);
		greater = sort(greater);
		
		
		// 4. 취합
		less.addAll(pivots);
		less.addAll(greater);
		
		return less;

	}
}

