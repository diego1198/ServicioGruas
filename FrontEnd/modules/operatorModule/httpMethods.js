function listarALLCraneManagerTable() {
    const URLAPI = "http://ec2-18-220-223-91.us-east-2.compute.amazonaws.com:8080/Gruas/service/CraneManager";
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
                   
                    <option value="${i=i+1}">${product.cmid}</option>
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
        'url': 'http://ec2-18-220-223-91.us-east-2.compute.amazonaws.com:8080/Gruas/service/Operator',
        'contentType': 'application/json',
        'data': JSON.stringify(operator),
        'dataType': 'json'
    });
    alert('Operator agregado correctamente');
    location.reload();

}