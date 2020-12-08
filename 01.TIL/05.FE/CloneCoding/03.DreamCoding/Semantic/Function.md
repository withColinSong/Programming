# [목차](#목차)
- [목차](#목차)
- [1. function declaration](#1-function-declaration)
  - [1.2. Parameters](#12-parameters)
  - [1.3. Default parameters](#13-default-parameters)
  - [1.4. Rest parameters](#14-rest-parameters)
  - [1.5. Local scope](#15-local-scope)
  - [1.6. return](#16-return)
- [2. Function Expression](#2-function-expression)
  - [2.1. anonymous function](#21-anonymous-function)
  - [2.2. call back](#22-call-back)
  - [2.3. named function](#23-named-function)
- [3. Arrow function](#3-arrow-function)
  - [References](#references)

# 1. function declaration
- function -> object의 일종이다.
- JavaScript -> Type 없다.

```js
function printHello() {
    console.log('hello');
}

printHello();
```
> hello

```js
function log(message) {
    console.log(message);
}

log('log() : hello');
log(1234);
```
> log() : hello
> 
> index.js:16 1234

.

## 1.2. Parameters
- primitive type -> 스택에 저장

```js
function changeName(obj) { 
    obj.name = 'song';
}

const obj = {
    name : 'yeon',
    age : 40,
}

const obj2 = {name : 'ya'};

changeName(obj2);
console.log(obj2);

> {name: "song"}name: "song"

changeName(obj);
console.log(obj);

> {name: "song", age: 40}

const obj3 = {
    value : 20,
    name : 'obj3',
}

changeName(obj3);
console.log(obj3);
```
> {value: 20, name: "song"}



## 1.3. Default parameters 
- (added in ES6)


1.
```js
function showMessage(message, from) {
    if(from == undefined) {
        from = 'unknown';
    }
    console.log(`${message} by ${from}`);    
}

showMessage('안녕하세요');
```
> 안녕하세요 by unknown

2.
```js
function showMessage(message, from = 'unknown') {
    console.log(`${message} by ${from}`)
}

showMessage('안녕하세요');
```
> 안녕하세요 by unknown


## 1.4. Rest parameters 
- (added in ES6)

```js
function printAll (...args) {
    for(i = 0; i < args.length; i++) {
        console.log(args[i]);
    }

    for (const arg of args) {
        console.log(arg);
    }

    args.forEach((arg) => console.log(arg));
}

printAll('String', 201202, 3.14);
```
> String
> 
> 201202
> 
> 3.14

## 1.5. Local scope

```js
let globalMessage = 'global' //global variable
function printMessage() {
    let message = 'hello'; // local variable
    console.log(message);
    console.log(globalMessage);
}

//console.log(message); // 에러
printMessage();
```
> hello
> 
> golbal

## 1.6. return
```js
function sum(a, b) {
    return a+b;
}

const result = sum(1, 2);
console.log(result);
console.log(`sum: ${sum(1,2)}`);
```
> 3
> 
> sum: 3

# 2. Function Expression
- 함수 표현식
- 할당한 다음에 사용할 수 있다.
- function declaration -> 호이스팅 가능

## 2.1. anonymous function
- 이름 없는 함수

```js
const print = function() {
    console.log(print);
}

print();
const printAgain = print;
printAgain();
```

```js
ƒ () {
    console.log(print);
}

ƒ () {
    console.log(print);
}
```

## 2.2. call back
```js
function randomQuiz(answer, printYes, printNo) {
    if(answer === 'love you') {
        printYes();
    }else {
        printNo();
    }
};

const printYes = function() {
    console.log('yes!');
}

const printNo = function() {
    console.log('no!');
}

randomQuiz('wrong', printYes, printNo);
randomQuiz('love you', printYes, printNo);
```
> no!
> 
> yes!


## 2.3. named function

- 이름 있는 함수

```js
function randomQuiz(answer, printYes, printNo) {
    if(answer === 'love you') {
        printYes();
    }else {
        printNo();
    }
};

const printYes = function() printYes() {
    console.log('yes!');
}

const printNo = function printNo() { // 이름 있는 함수
    console.log('no!');
}
randomQuiz('wrong', printYes, printNo);
randomQuiz('love you', printYes, printNo);
```
> no!
> 
> yes!

# 3. Arrow function 
```js
const simplePrint1 = function() {
    console.log('simplePrint!')
}

const simplePrint = () => console.log('simplePrint!');
const add = (a, b) => a + b
const simpleMultply = (a, b) => {
    return a * b;
};
```

## References
- [Youtube : 드림코딩 by 엘리](//) : ** 강의를 보고 정리한 자료입니다.**
- 🎈2020.12.02

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)