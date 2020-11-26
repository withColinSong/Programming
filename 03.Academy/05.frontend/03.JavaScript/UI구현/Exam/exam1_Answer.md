```html

<!-- 1. 화면의 색상이 적혀있는 버튼을 클릭하면 
    그 색상에 해당하는 박스와 선택한 색상의 글자가 선택한 
    색상으로 나타나는 코드이다.  
    아래의 화면처럼 나타나지 않는 원인과 해결 방안을 작성하세요.
 -->
 <!DOCTYPE html>
 <html lang="kr">
 
 <head>
     <meta charset="UTF-8">
     <title>색상선택</title>
     <style>
         #box {
             background-color: black;
             width: 100px;
             height: 100px;
         }
 
         p>span {
             font-weight: bold;
         }
     </style>
 </head>
 
 <body>
     <h2>사각형의 색상을 선택하세요</h2>
     <hr>
     <button>red</button>
     <button>orange</button>
     <button>yellow</button>
     <button>green</button>
     <button>blue</button>
     <hr>
     <div id="box"></div>
     <p>선택한 색상은 <span id="color">검정색</span>입니다.</p>
     <script>
         var btn = document.getElementsByTagName('button');
         // 1.  반환 값이 배열임
         for (var i = 0; i < btn.length; i++) {
        // 1.1. btn 값을 배열로 변경해준다.
             btn[i].onclick = function () {
                 var selectedColor = this.innerHTML;
                 var box = document.getElementById('box');
                 box.style.backgroundColor = selectedColor;
                 var color = document.getElementById('color');
                 color.innerHTML = selectedColor;
                 // 1.2. 글씨의 색이 바뀌지 않으므로, 
                 // color.style.color 를 추가해준다.
                 color.style.color = selectedColor;
             }
         }
         // 1. 원인 : 이벤트 핸들러가 지정되어 있지 않았다. 
         // 1. 해결방안 : getElementsByTagName('button') - > HTMLCollectionOf 타입일 대 반환 값을 배열로 받아야 하는데 배열로 변경되는 로직이 없다.
         // btn.oneclick -> btn[i].onclick
         // 1.1. 글씨의 색이 바뀌지 않으므로, color.style.color = selectedColor를 추가해준다.
     </script>
 </body>
 
 </html>
 ```

 