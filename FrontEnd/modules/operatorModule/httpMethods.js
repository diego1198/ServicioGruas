function getAllCraneManager() {

    var contenido = document.querySelector('#contenido');
    fetch('http://localhost:8080/GruasService/RestFul/AllCraneManager')
        .then(response => response.json())
        .then(data => {
            debugger
        })

}