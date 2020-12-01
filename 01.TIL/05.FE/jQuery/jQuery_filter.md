# [목차](#목차)
- [목차](#목차)
- [filter](#filter)
  - [1. :fitst](#1-fitst)
  - [2. :last](#2-last)
    - [firstLast.jsp](#firstlastjsp)
  - [3. :even](#3-even)
  - [4. :odd](#4-odd)
    - [evenOdd.jsp](#evenoddjsp)
  - [5. :gt(index)](#5-gtindex)
    - [gt.jsp](#gtjsp)
  - [6. :lt(index)](#6-ltindex)
    - [lt.jsp](#ltjsp)
  - [7. :eq(index)](#7-eqindex)
    - [eq1.jsp](#eq1jsp)
    - [eq2.jsp](#eq2jsp)
  - [References](#references)



# filter
## 1. :fitst
- 인자의 첫번째로 일치하는 요소를 가져온다.

## 2. :last
- 인자의 마지막으로 일치하는 요소를 가져온다.

### firstLast.jsp
```java
  <h1>h1 -> index:0</h1>	
  <h1>h1 -> index:1</h1>
  <h1>h1 -> index:2</h1>	
  <ul class="ul">
      <li>1</li>
      <li>2</li>
      <li>3</li>
  </ul>
```

```java
$('h1:first').css('color','blue');
$('h1:last').css('color','blue');
```
![](https://images.velog.io/images/withcolinsong/post/4ccb0284-46f2-4d54-a209-12bcf7f05d51/image.png)

## 3. :even
- 인자의 짝수번째 요소를 모두 가져온다.

## 4. :odd
- 인자의 홀수번째 요소를 모두 가져온다.

### evenOdd.jsp
```java
  <h1>h1 -> index:0</h1>	
  <h1>h1 -> index:1</h1>
  <h1>h1 -> index:2</h1>
  <h1>h1 -> index:3</h1>
  <h1>h1 -> index:4</h1>	
  <ul class="ul">
      <li>1</li>
      <li>2</li>
      <li>3</li>
  </ul>
```

```java
$('h1:even').css('color','red');
$('h1:odd').css('color','blue');
```
![](https://images.velog.io/images/withcolinsong/post/f123ce0b-810d-4fa9-ac6a-df55e5a45b14/image.png)

## 5. :gt(index)

- 인자로 전달된 index 보다 큰 index를 가진 요소를 모두 가져온다.

### gt.jsp
```java
  <h1>h1 -> index:0</h1>	
  <h1>h1 -> index:1</h1>
  <h1>h1 -> index:2</h1>
  <h1>h1 -> index:3</h1>
  <h1>h1 -> index:4</h1>	
  <ul class="ul">
      <li>1</li>
      <li>2</li>
      <li>3</li>
  </ul>
```

```java
$('h1:gt(0)').css('color','red');
```
![](https://images.velog.io/images/withcolinsong/post/5bf9e386-6bbe-4b57-984f-12e96dbff19e/image.png)

## 6. :lt(index)
- 인자로 전달된 index 보다 작은 index를 가진 요소를 모두 가져온다.

### lt.jsp
```java
  <ul class="ul">
      <li>li -> index 0</li>
      <li>li -> index 1</li>
      <li>li -> index 2</li>
  </ul>
```

```java
$('li:lt(1)').css('color','red');
```
![](https://images.velog.io/images/withcolinsong/post/993a83a1-0c40-4913-a6cf-2564ffbf248e/image.png)

## 7. :eq(index)
- 인자로 전달된 index에 해당하는 요소를 가져온다. 
### eq1.jsp
```java
	<ul class="ul">
		<li>li -> index 0</li>
		<li>li -> index 1</li>
		<li>li -> index 2</li>
	</ul>
	<ul class="list">
		<li>li -> index 3</li>
		<li>li -> index 4</li>
		<li>li -> index 5</li>
	</ul>
```

```java
$('li:eq(1)').css('color', 'red');
```
![](https://images.velog.io/images/withcolinsong/post/f6061f38-02b2-4cbb-8474-0cacb60c1c42/image.png)

### eq2.jsp
```java
	<ul class="ul">
		<li>li -> index 0</li>
		<li>li -> index 1</li>
		<li>li -> index 2</li>
	</ul>
	<ul class="list">
		<li>li -> index 3</li>
		<li>li -> index 4</li>
		<li>li -> index 5</li>
	</ul>
```
```java
$('.ul:eq(0)').css('color','blue');
```
![](https://images.velog.io/images/withcolinsong/post/655ed9ff-9614-4541-a48a-77ca0c9c6cfb/image.png)

## References
- 🎈2020.11.30
- 🎈정리 : song

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)
