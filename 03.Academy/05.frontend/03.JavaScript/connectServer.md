


1. 
```js
// npm init
// npm install express
// https://expressjs.com/ko/

// express 프레임워크 임포트
const express = require('express')
const app = express()
const PORT = 6600 //포트번호

// 경로 /와 매핑
app.get('/', (req, res) => {
    res.send('Hello Express!')
})

// 애플리케이션 시작!
app.listen(PORT, () => {
    console.log('애플리케이션이 시작')
})
```

2. 
```js
// express 프레임워크 임포트
const express = require('express')
const app = express()
const PORT = 6600 //포트번호

// 미들웨어 추가
app.use(express.static('./static')) //static 폴더에 index.html 실행되는 구문


// 애플리케이션 시작!
app.listen(PORT, () => {
    console.log('애플리케이션이 시작')
})
```

3. 
html ->JQuery 추가

```html
<html>
    <head>
        <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
    </head>
    <body>
    </body>
</html>
```

```js

// express 프레임워크 임포트
const express = require('express')
const app = express()
const PORT = 6600 //포트번호

// 미들웨어 추가
app.use(express.static('./static'))

//더미 데이터
const data = {
    id: '124125125',
    name : 'song',
    myData: [1, 2, 3,]
}

app.get('/data', (req, res) => {
    //data 객체를 json으로 서빙해줌
    // JSON : javascript object notation
    res.json(data)
})

// 애플리케이션 시작!
app.listen(PORT, () => {
    console.log('애플리케이션이 시작')
})

```


4. 
cmd창
- node index.js // node 실행

브라우저 
- `localhost:6000/data`


5. 
```js
// express 프레임워크 임포트
const express = require('express')
const app = express()
const PORT = 6600 //포트번호

// 미들웨어 추가
app.use(express.static('./static'))


app.get('/data', (req, res) => {
    //data 객체를 json으로 서빙해줌
    // JSON : javascript object notation
    const data = {
    id: '124125125',
    name : 'song',
    myData: [1, 2, 3,],
    timestamp: new Date(),
    
}
    res.json(data)
})

// 애플리케이션 시작!
app.listen(PORT, () => {
    console.log('애플리케이션이 시작')
})

```

```html
<!DOCTYPE html>
<html>
    <head>
        <title>Hello Node.js</title>
        <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
    </head>
    <body>
        <h1>이게되네..</h1>
        <button id="load-data">서버에서 정보 받기</button>
        <table border="1">
            <thead>
                <th>아이디</th>
                <th>이름</th>
                <th>데이터</th>
                <th>시각</th>
            </thead>
            <tbody>
                <tr>
                    <td id="user-id"></td>
                    <td id="user-name"></td>
                    <td id="user-data"></td>
                    <td id="user-time"></td>
                </tr>
            </tbody>
        </table>
        <script>
            $('#load-data').on('click', e=>{
                //alert('abc')
                $.get('/data', x => {
                    console.log(x)
                   const a = document.getElementById('user-id')
                    const b = document.getElementById('user-name')
                    const c = document.getElementById('user-data')
                    const d = document.getElementById('user-time')
                    
                    a.innerText=x.id
                    b.innerText=x.name
                    c.innerText=x.myData
                    d.innerText=x.timestamp
                })
            })
        </script>
    </body>
</html>

```



01.Example -> 201113 -> Web