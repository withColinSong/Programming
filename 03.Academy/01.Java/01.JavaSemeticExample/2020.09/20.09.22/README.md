# 조건문 (condition)

```
if (표현식) {

    표현식의 결과가 참일 때 실행하고자 하는 실행문;

} else {

    표현식의 결과가 거짓일 때 실행하고자 하는 실행문;

}

```

```
if (표현식1) {

    표현식1의 결과가 참일 때 실행하고자 하는 실행문;

} else if (표현식2) {

    표현식2의 결과가 참일 때 실행하고자 하는 실행문;

} else {

    표현식1의 결과도 거짓이고, 표현식2의 결과도 거짓일 때 실행하고자 하는 실행문;

}
```


# Switch 문

```
switch (조건 값) {

    case 값1:

        조건 값이 값1일 때 실행하고자 하는 실행문;

        break;

    case 값2:

        조건 값이 값2일 때 실행하고자 하는 실행문;

        break;

    ...

    default:

        조건 값이 어떠한 case 절에도 해당하지 않을 때 실행하고자 하는 실행문;

        break;

}

```

# 반복문 (loop)

```
for (초기식; 표현식; 증감식) {

    표현식의 결과가 참인 동안 반복적으로 실행하고자 하는 실행문;

}

for(;;){
 // 무한 반복
}
```
