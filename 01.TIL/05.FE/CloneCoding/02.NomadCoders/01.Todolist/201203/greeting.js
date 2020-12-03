const form = document.querySelector(".js-form");
const input = document.querySelector("input");
const greeting = document.querySelector(".js-greetings") 

const USER_LS = "curretUser";
const SHOWING_CN = "showing";
    //querySelector -> element 요소를 가져온다.
    // querySeletorAll -> array

    // 로컬스토리지 -> chrome -> 개발자도구 -> Application -> local Storage
    // localStorage.

function paintGreeting(text) {
    form.classList.remove(SHOWING_CN);
    greeting.classList.add(SHOWING_CN);
    greeting.innerHTML = `Hello ${text}`
}

function loadName() {
    const currentUser = localStorage.getItem(USER_LS);
    if(currentUser === null) {
        
    } else {
        paintGreeting(currentUser);
    }
}

    function init() {
    loadName();
}

init();