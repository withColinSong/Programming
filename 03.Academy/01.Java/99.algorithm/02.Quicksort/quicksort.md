[목차](#목차)
- [1. quicksort](#1-quicksort)
  - [1.1. 알고리즘](#11-알고리즘)



# 1. quicksort

- 추가적인 메모리 필요 없음
- 소팅 속도 빠름

## 1.1. 알고리즘


1. pivot 고르고
2. 왼쪽에는 pivot보다 작은 값의 배열(리스트)
3. 오른쪽에는 pivot보다 큰 값의 배열(리스트)


```java   
pivot = 5;
less = [3, 4, 1, 2]
greater = [8, 9, 6, 7]
less = soft(less)
greter = sort(greater)

return less + pivot + greater
```


pivot : 5
5 3 8 4 9 1 6 2 7 -> 정렬 시

l: 3 4 1 2 
l = sort(l)
g: 8 9 6 7
g = sort(g)

-----------------------
pivot : 3
3 4 1 2

l : 1 2
g : 4

less + pivot + greater

-------------------
pivot : 8
8 9 6 7

l: 6 7
g: 9

