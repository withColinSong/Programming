const form = document.querySelector('.js-form'), // querySelector -> 선택자를 만족하는 첫 번째 element를 가져온다.
    input = form.querySelector('input');

const greeting = document.querySelector('.js-greetings');



const USER_LS = "currentUser",
    SHOWING_CN = "Showing";


    function paintGreeting(text) {
        form.classList.remove(SHOWING_CN);
        greeting.classList.add(SHOWING_CN);
        greeting.innerHTML = `Hello ${text}`
        
    }

function loadName() {
    const currentUser = localStorage.getItem(USER_LS);
    if(currentUser === null ) {
        
    } else {
        paintGreeting(currentUser);
    }
    
}
function init() {
    loadName();
}

init();