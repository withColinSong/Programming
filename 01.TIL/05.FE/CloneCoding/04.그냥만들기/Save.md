# [목차](#목차)
- [목차](#목차)
- [New Memory](#new-memory)
  - [JSP](#jsp)
    - [서버가 응답한 페이지로 이동할 때 메서드](#서버가-응답한-페이지로-이동할-때-메서드)
  - [CSS](#css)
    - [css 외부링크](#css-외부링크)
    - [label의 for의 값과 양식의 id의 값이 같으면 연결](#label의-for의-값과-양식의-id의-값이-같으면-연결)
    - [placehold](#placehold)
    - [css pattern 속성](#css-pattern-속성)


# New Memory

## JSP
### 서버가 응답한 페이지로 이동할 때 메서드
```jsp
response.sendRedirect("path");
```

## CSS
- box-shadow:0 1px 6px 0 rgba(32, 33, 36, .28);
- .search:focus {
    outline: none;
    border: none;
}

### css 외부링크
```html
<link rel="stylesheet" type="text/css" href="경로">
```

### label의 for의 값과 양식의 id의 값이 같으면 연결

```html
<label for="id"><label>
    <input class="id">
```

### placehold 
```html
<img src='http://placehold.it/150X100'>
```

### css pattern 속성
```css
pattern='[A-za-z0-9]{8,20}$'
```