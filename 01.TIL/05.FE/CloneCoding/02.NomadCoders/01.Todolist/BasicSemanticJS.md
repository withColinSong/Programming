# [목차](#목차)
- [목차](#목차)
- [1. 데이터 정렬](#1-데이터-정렬)
  - [1.1 Array](#11-array)
  - [2.1 object](#21-object)
    - [2.1.1 Console](#211-console)
- [2. function](#2-function)
  - [2.1 function 정의](#21-function-정의)
- [3. 문자열](#3-문자열)
  - [3.1. 템플릿 리터럴](#31-템플릿-리터럴)
  - [3.2  Conditional](#32--conditional)
- [4. DOM](#4-dom)
  - [4.1. DOM 요소들](#41-dom-요소들)
  - [4.2. Event](#42-event)
    - [4.2.1 Example code](#421-example-code)


# 1. 데이터 정렬

- 여러가지 타입을 담을 수 있다.
- 인덱스는 0부터 시작한다.
- 여러가지 타입을 담을 수 있다.

```js
const monday = "Mon";
const tue = "Tue";
const wed = "Wed";
const thu = "Thu";
const fri = "Fri";

console.log(monday, tue, wed, thu, fri) // 효율적이지 못하다.

```

## 1.1 Array
- []
- Array 안에 Object을 넣을 수 있다.

```js
const dayOfWeek = ["Mon", "Tue", "Thu", "Fri", true];
console.log(dayOfWeek)
```

> ["Mon", "Tue", "Thu", "Fri", true]

## 2.1 object
- { }
- object 안에 Array을 넣을 수 있다.
- 콤마로 구분
```js
const songInfo = {
    name: "Song",
    age: 10,
    gender: "Female",
    favMovies: ["소공녀", "윤희에게", "인생은 아름다워"],
    favFood : [
        {
            name: "Kimchi",
            fatty: false
        },
        {
            name: "Pizza",
            fatty: true
        }
    ]
}
```

```js
console.log(songInfo.age);
29

console.log(songInfo.favMovies[0]);
소공녀

console.log(songInfo.favFood[0].name)
Kimchi
```
- object에 접근하고 싶을 때 .을 이용
- Array에 접근하고 싶을 때는 [index]

### 2.1.1 Console
```js
// console -> object. 
// log -> 함수
console.log(console)
```

# 2. function

## 2.1 function 정의

```js
function 함수명() {
    // 코드
}
```
```js
function sayHello(potato) { // 파라미터
    console.log('hello', potato); 
}

console.log("song") // 인자
```
> hello song

# 3. 문자열
```
backlash: `
single-quote: '
double-quote: "
```
## 3.1. 템플릿 리터럴
```js
`${variable}`
```

## 3.2  Conditional

`===` -> value === data type 
`==` -> value == value
`&&` -> AND
`||` -> OR

# 4. DOM
- Document Object Model
  - HTML 태그 -> 객체로 생성

HTML 접근하기
```js
document.
```

## 4.1. DOM 요소들

```js
document.querySelector(#id);
document.getElementById();
```

## 4.2. Event
> event -> object // 이벤트 객체


### 4.2.1 Example code

```js
function handleResize(event){
    console.log(event);
}
window.addEventListener("resize" , handleResize);
```

```js
const Element = document.getElementById("title");
function handleClick(){
     Element.style.color = "red";
}
window.addEventListener("click" , handleClick);
```

```js
 const HandleEvent = document.querySelector('.title-contents');

function EventHandle () {
    HandleEvent.innerText = '클릭시 바뀝니다.';
    HandleEvent.style.backgroundColor = "red";
}

HandleEvent.addEventListener("click", EventHandle);
```
- [basicLogic CODE](basicLogic.html)

