function getAllCraneManager() {

    var contenido = document.querySelector('#contenido');
    fetch('http://localhost:8080/Gruas/V1.0/AllCraneManager')
        .then(response => response.json())
        .then(data => {
            console.log(data);
        })

}

var invocation = new XMLHttpRequest();
var url = 'http://localhost:8080/Gruas/V1.0/AllCraneManager';

function callOtherDomain() {
    if (invocation) {
        invocation.open('GET', url, true);
        invocation.onreadystatechange = handler;
        invocation.send();
    }
}