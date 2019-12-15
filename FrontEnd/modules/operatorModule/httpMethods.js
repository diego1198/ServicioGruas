/*optiene todos los operadores asiganados a un administrador de grúa */
function listOperatorByCraneManager() {
    var idCraneManager = document.getElementById('idCraneManager').value;
    const URLAPI = "http://ec2-18-220-223-91.us-east-2.compute.amazonaws.com:8080/Gruas/service/CraneManager/" + idCraneManager;
    const container = document.getElementById('tableOperator');
    let contentHTML = '';
    var i = 0;
    fetch(URLAPI)
        .then(res => res.json())
        .then((json) => {
            container.innerHTML = '';
            for (const manager of json) {
                container.innerHTML += `
                <tr>  
                <td>${manager.craneManagerId}</td>
                <td>${manager.operatorId}</td>
                <td>${manager.operatorName}</td>
                <td>${manager.operatorLastName}</td>
                <td>${manager.operatorLicense}</td>
                </tr>
                `;

            }
        })
}

/*obtiene un operador por id */
function getOperadorByID() {

    var idOperator = document.getElementById('idOperator').value;
    const URLAPI = "http://ec2-18-220-223-91.us-east-2.compute.amazonaws.com:8080/Gruas/service/Operator/" + idOperator;
    const container = document.getElementById('tableOperator');
    let contentHTML = '';
    var i = 0;
    fetch(URLAPI)
        .then(res => res.json())
        .then((json) => {

            const operator = json;
            console.log(URLAPI);
            console.log(operator);
            container.innerHTML = '';
            container.innerHTML += `
                <tr>  
                   <td>${operator[0].operatorId}</td>
                   <td>${operator[0].craneManagerId}</td>
                   <td>${operator[0].operatorName}</td>
                   <td>${operator[0].operatorLastName}</td>
                   <td>${operator[0].operatorLicense}</td>
                </tr>
            `;


        })
}


/*lista todos los administradores de grúas registrados */
function getCraneManager() {
    const URLAPI = "http://ec2-18-220-223-91.us-east-2.compute.amazonaws.com:8080/Gruas/service/CraneManager";
    const container = document.getElementById('cmid');
    let contentHTML = '';
    var i = 0;
    fetch(URLAPI)
        .then(res => res.json())
        .then((json) => {
            container.innerHTML = '';
            container.innerHTML += `
                    <option value="0">SELECT CRANE MANAGER</option>
                `;
            for (const product of json) {
                container.innerHTML += `
                   
                    <option value="${product.cmid}">${product.cmid}</option>
                `;

            }
        })


}

/* agrega un operador */
function postOperator() {
    const form = document.getElementById('formOperator');
    var name = document.getElementById("name").value;
    var lastname = document.getElementById("lastname").value;
    var id = document.getElementById("id").value;
    var license = document.getElementById("license").value;
    var craneManager = parseInt(document.getElementById("cmid").value);

    var operator = new Object();
    operator.operatorId = id;
    operator.craneManagerId = craneManager;
    operator.operatorName = name;
    operator.operatorLastName = lastname;
    operator.operatorLicense = license;

    console.log(JSON.stringify(operator));
    return jQuery.ajax({
        'type': 'POST',
        'url': 'http://ec2-18-220-223-91.us-east-2.compute.amazonaws.com:8080/Gruas/service/Operator',
        'contentType': 'application/json',
        'data': JSON.stringify(operator),
        'dataType': 'json'
    });
    alert('Operador agregado correctamente');

}
/* actualizar los datos de un operador */
function putOperator() {
    const form = document.getElementById('formOperator');
    var name = document.getElementById("name").value;
    var lastname = document.getElementById("lastname").value;
    var id = document.getElementById("id").value;
    var license = document.getElementById("license").value;
    var craneManager = parseInt(document.getElementById("cmid").value);

    var operator = new Object();
    operator.operatorId = id;
    operator.craneManagerId = craneManager;
    operator.operatorName = name;
    operator.operatorLastName = lastname;
    operator.operatorLicense = license;

    console.log(JSON.stringify(operator));
    return jQuery.ajax({
        'type': 'PUT',
        'url': 'http://ec2-18-220-223-91.us-east-2.compute.amazonaws.com:8080/Gruas/service/Operator',
        'contentType': 'application/json',
        'data': JSON.stringify(operator),
        'dataType': 'json'
    });
    alert('Operador agregado correctamente');
}

/*elimina un operador */
function deleteOperator() {
    const form = document.getElementById('formOperator');
    var id = document.getElementById("idOperator").value;
    var operator = new Object();
    operator.operatorId = id;
    console.log(JSON.stringify(operator));
    return jQuery.ajax({
        'type': 'DELETE',
        'url': 'http://ec2-18-220-223-91.us-east-2.compute.amazonaws.com:8080/Gruas/service/Operator',
        'contentType': 'application/json',
        'data': JSON.stringify(operator),
        'dataType': 'json'
    });
    alert('Operador agregado correctamente');
}