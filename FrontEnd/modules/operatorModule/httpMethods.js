function cargar() {
    const URLAPI = "http://localhost:8080/Gruas/serrvice/AllCraneManager";
    const container = document.getElementById('tableService');
    let contentHTML = '';
    var i = 0;
    fetch(URLAPI)
        .then(res => res.json())
        .then((json) => {
            container.innerHTML = '';
            for (const product of json) {
                container.innerHTML += `
                <tr>  
                    <td>${product.cmUser}</td>
                    <td>${product.cmid}</td>
                </tr>
                `;

            }
        })
}



function postOperator() {
    const form = document.getElementById('formOperator');
    var name = document.getElementById("name").value;
    var lastname = document.getElementById("lastname").value;
    var id = document.getElementById("id").value;
    var license = document.getElementById("license").value;
    var craneManager = document.getElementById("craneManager").value;

    var operator = new Object();
    operator.opid = id;
    operator.cmid = craneManager;
    operator.opname = name;
    operator.oplastname = lastname;
    operator.oplicense = license;

    console.log(JSON.stringify(operator));
    return jQuery.ajax({
        'type': 'POST',
        'url': 'http://localhost:8080/Gruas/serrvice/CreateOperator',
        'contentType': 'application/json',
        'data': JSON.stringify(operator),
        'dataType': 'json'
    });
    alert('Operator agregado correctamente');
    location.reload();

}