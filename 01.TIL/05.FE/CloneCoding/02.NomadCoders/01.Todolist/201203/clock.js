
const clockContainer = document.querySelector(".js-clock");
const clockTitle = clockContainer.querySelector("h1");


function getTime() {
    const date = new Date(); // Date -> object
    const minutes = date.getMinutes();
    const hours = date.getDate();
    const seconds = date.getSeconds();
    clockTitle.innerText = `${hours}:${minutes}:${seconds}`
}
//make clock

function init() {
    getTime();
}

init();