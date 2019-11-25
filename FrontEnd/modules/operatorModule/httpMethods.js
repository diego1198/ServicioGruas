function getAllCraneManager() {

    var contenido = document.querySelector('#contenido');
    fetch('http://localhost:8080/GruasService/RestFul/AllCraneManager')
        .then(response => response.json())
        .then(data => {
            debugger
        })

}

var invocation = new XMLHttpRequest();
var url = 'http://localhost:8080/GruasService/RestFul/AllCraneManager';

function callOtherDomain() {
    if (invocation) {
        invocation.open('GET', url, true);
        invocation.onreadystatechange = handler;
        invocation.send();
    }
}