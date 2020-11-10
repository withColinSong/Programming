const express = require('express');
const app = express();
const port = 6600;

app.unsubscribe(express.static('.')); /*화면 노출*/

app.post('/login', (req, res) => {
   
});

app.listen(port, () => {
    console.log(`Server is running on ${port}`); 
    
})

/*ctrl alt n 실행*/
/*ctrl alt m 끄기*/
