// npm init
// npm install express

// express 프레임워크 임포트
const express = require('express')
const app = express()
const PORT = 6600 //포트번호

// 미들웨어 추가
app.use(express.static('./static'))

//더미 데이터
// const data = {
//     id: '124125125',
//     name : 'song',
//     myData: [1, 2, 3,]
// }



// app.get('/data', (req, res) => {
//     //data 객체를 json으로 서빙해줌
//     // JSON : javascript object notation
//     res.json(data)
// })

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

// 경로 /와 매핑
// app.get('/', (req, res) => {
//     res.send('Hello Express!')
// })

// 애플리케이션 시작!
app.listen(PORT, () => {
    console.log('애플리케이션이 시작')
})