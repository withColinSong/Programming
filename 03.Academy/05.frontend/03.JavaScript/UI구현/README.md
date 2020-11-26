# [목차](#목차)
- [목차](#목차)
- [1. DOM 조작](#1-dom-조작)
  - [1.1. DOM_INPUT](#11-dom_input)
  - [1.3. DOM_SELECT](#13-dom_select)

# 1. DOM 조작
```html
<!DOCTYPE html>
<html>
    <head>
        <title>제목</title>
        <style>
            html, body {
                margin: 0;
            }

            .box {
            width: 100px;
            height: 100px;
            background-color: red;
            }
        </style>
    </head>
    <body>
        <div id = "box" class="box">
            Contents
        </div>
        <button id="btn">button</button>
        <script>
            // 1. id로 선택
            // 1.1. document.getElementById('box')
            // 1.2. document.querySelector('#box') -> 단 하나의 요소만 선택
            const box = document.getElementById('box');
            box.style.backgroundColor = 'blue';
            box.innerText = 'change contents';
            
            // DOM 선택
            const box = document.querySelector('#box');
             // DOM 조작
            box.style.backgroundColor = 'blue';

            // 2. class로 선택
            // 2.1. document.getElementsByclassName('box')
            // 2.2. docment.querySelectorAll('.box'); //css와 같은 접근 방법
            
            const boxes = document.getElementsByClassName('box');
            //getElementsByClassName -> 리스트로 출력됨 -> 리스트 안에 접근해서 요소를 수정해야함.
            boxes[0].style.backgroundColor = 'blue'; 
            const boxes = document.querySelectorAll('.box');
            

            // 3. 태그 이름으로 선택
            // 3.1. document.getElementsByTagName('div');
            // 3.2. document.getSelectorAll('div');

            const b = document.getElementsByTagName('div');
            b[0].style.backgroundColor = "crimson";

        </script>
    </body>
</html>
```

## 1.1. DOM_INPUT
```html

<!DOCTYPE html>
<html>
    <head>
        <title>제목</title>
        <style>
        </style>
    </head>

    <body>
        <input type="checkbox" name="fruit" value="사과"/>사과<br/>
        <input type="checkbox" name="fruit" value="오렌지"/>오렌지<br/>
        <input type="checkbox" name="fruit" value="포도"/>포도<br/>
        <input type="checkbox" name="fruit" value="아보카도"/>🥑<br/>                
        <button id="print">출력!</button>
        <h2 id="list"></h2>
        <script>
            const p = document.getElementById('print');
            p.addEventListener('click', () => {
                const chks = document.getElementsByName('fruit');
                const len = chks.length;
                const list = document.getElementById('list');
                let s = '';
                for (let i = 0; i < len; i++) {
                    if (chks[i].checked) {
                        s += chks[i].value
                        s += ', '
                    }
                }
                list.innerText = s
            })
        </script>
    </body>
</html>

```

## 1.3. DOM_SELECT
```html
<!DOCTYPE html>
<html>
    <head>
        <title>제목</title>
        <style>
            html, body {
                margin: 0;
            }

            .box {
            width: 100px;
            height: 100px;
            background-color: red;
            }
        </style>
    </head>
    <body>
        <select id='select'>
            <option value="직접 입력">직접 입력</option>
            <option value="naver.com">naver.com</option>
            <option value="google.com">google.com</option>
        </select>
        <h1 id="selectedValue">안보임</h1>

        
        <script>
            /*-- 
            1. 속성(태그)
            2. 프로퍼티 (on이벤트이름)
            3. addEventListener 
            */
            function handleSelectOnChange(obj) {
                console.log(obj.value)
                const title = document.getElementById('selectedValue')
                title.innerText = obj.value;
            }
        </script>
        
    </body>
</html>
```