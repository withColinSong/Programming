const toDoForm = document.querySelector('.js-toDoForm');
const toDoinput = toDoform.querySelector('input');
const toDoList = form.querySelector('.js-toDoList');

const TODOS_LS = 'toDos';

function paintTodo(text) {
    console.log(text);
}


function handleSubmit() {
    event.preventDefault();
    const currentValue = toDoinput.value;
    paintTodo(currentValue);
    toDoinput.value = "";
}


function loadTodos() {
    const toDos = localStorage.getItem(TODOS_LS);
    if(toDos === null) {
        
    } 
}

function init() {
    loadToDos();
    toDoForm.addEventListener('submit', handleSubmit)
}

init();