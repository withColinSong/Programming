# JSON
- JavaScript Object Notation


## 1.1. JSON 에러
```text
Uncaught SyntaxError: Unexpected token N in JSON at position 36
    at JSON.parse (<anonymous>)
    at XMLHttpRequest.req.onreadystatechange
```

## 1.2. 해결방안
- JSON 문법을 다시 확인한다.
  - `'` `{` `}`누락 되었는지 확인해보기.
```java
	String fmt = "{"
	          + "  'id' :  '%d' ," 
	          + "  'name' : '%s' ,"
	          + "  'email' : '%s' ,"
	          + "  'phone' : '%s' ,"
	          + "  'salary' : '%10.1f' "
	          + "}";
```
