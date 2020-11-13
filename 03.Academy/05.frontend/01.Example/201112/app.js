var name = 'abc';
console.log(name);

name = 11244;
console.log(name)

// 동적 타이핑
// 1. 값을 보고 타임 추론
// 2. 언제든 식별자의 값이 변경될 수 있음.



const obj = {
    abc: 'abc'
}

// 멤버 접근 연산자(.) member access operator
console.log(obj);

// 계산된 멤버 접근 연산자([]) computed member access operator
console.log(obj['abc'])

obj['alpha'] = 'a'
obj['beta'] = 'b'
console.log(obj)


//201113
console.log("-----------201113-----------")



// 배열 리터럴
const arr = [1, 2, '문자열', {}]

let [a, b] = arr
console.log(a)
console.log(b)

// 객체 리터럴
const user = {
    id: 'abcefg',
    name: 'song',
    data: [1, 2, 3, 4, ],
}

const {id, name, data} =  user
console.log(id)
console.log(name)
console.log(data)