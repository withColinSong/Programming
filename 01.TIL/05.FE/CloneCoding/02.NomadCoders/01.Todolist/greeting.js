const form = document.querySelector(".js-form");
const input = document.querySelector("input");
const greeting = document.querySelector(".js-greetings") 

const USER_LS = "curretUser";
const SHOWING_CN = "showing";
    //querySelector -> element 요소를 가져온다.
    // querySeletorAll -> array

    // 로컬스토리지 -> chrome -> 개발자도구 -> Application -> local Storage
    // localStorage.


function saveName(text) {
    localStorage.setItem(USER_LS, text);
}

    function handleSubmit(event) { //form을 제출하는 이벤트가 생기면 여기가 실행한다.
    event.preventDefault(); // 이벤트 금지
    const currentValue = input.value;
    paintGreeting(currentValue);
    saveName(currentValue); // 사용자 저장
}


function askForName() {
    form.classList.add(SHOWING_CN);
    form.addEventListener("submit", handleSubmit);

}


function paintGreeting(text) {
    form.classList.remove(SHOWING_CN); // form .showing 속성을 삭제해줘!
    greeting.classList.add(SHOWING_CN); // <h4>를 .showing 속성을 살행해줘!
    greeting.innerHTML = `Hello ${text}` // 그리고 user의 이름으로 인사해줘!
}



    function loadName() {
    const currentUser = localStorage.getItem(USER_LS); //localStroage의 user를 확인하여 가져올거야!
    if(currentUser === null) {
        askForName(); 
    } else { // localStroage의 user가 null이 아니라면 아래 코드를 실행할거야.
        paintGreeting(currentUser); 
    }
}

    function init() {
    loadName();
}

init();