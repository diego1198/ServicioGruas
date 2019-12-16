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
        'url': 'http://ec2-18-220-223-91.us-east-2.compute.amazonaws.com:8080/Gruas/service/Operator/',
        'contentType': 'application/json',
        'data': JSON.stringify(operator),
        'dataType': 'json'
    });
    alert('Operador agregado correctamente');
}

var A, B, F, A1, C, C1, D, D1, E, E1, G;


/*obtiene el número de operadores que tienen el mismo tipo de licencia */
function getNumberLicense() {



    const URI_A = "http://ec2-18-220-223-91.us-east-2.compute.amazonaws.com:8080/Gruas/service/Operator/A";
    fetch(URI_A)
        .then(res => res.text())
        .then((license) => {
            A = license;
        })
    const URI_B = "http://ec2-18-220-223-91.us-east-2.compute.amazonaws.com:8080/Gruas/service/Operator/B";
    fetch(URI_B)
        .then(res => res.text())
        .then((license) => {
            B = license;
        })

    const URI_F = "http://ec2-18-220-223-91.us-east-2.compute.amazonaws.com:8080/Gruas/service/Operator/F";
    fetch(URI_F)
        .then(res => res.text())
        .then((license) => {
            F = license;
        })

    const URI_A1 = "http://ec2-18-220-223-91.us-east-2.compute.amazonaws.com:8080/Gruas/service/Operator/A1";
    fetch(URI_A1)
        .then(res => res.text())
        .then((license) => {
            A1 = license;
        })

    const URI_C = "http://ec2-18-220-223-91.us-east-2.compute.amazonaws.com:8080/Gruas/service/Operator/C";
    fetch(URI_C)
        .then(res => res.text())
        .then((license) => {
            C = license;
        })

    const URI_C1 = "http://ec2-18-220-223-91.us-east-2.compute.amazonaws.com:8080/Gruas/service/Operator/C1";
    fetch(URI_C1)
        .then(res => res.text())
        .then((license) => {
            C1 = license;
        })

    const URI_D = "http://ec2-18-220-223-91.us-east-2.compute.amazonaws.com:8080/Gruas/service/Operator/D";
    fetch(URI_D)
        .then(res => res.text())
        .then((license) => {
            D = license;
        })

    const URI_D1 = "http://ec2-18-220-223-91.us-east-2.compute.amazonaws.com:8080/Gruas/service/Operator/D1";
    fetch(URI_D1)
        .then(res => res.text())
        .then((license) => {
            D1 = license;
        })

    const URI_E = "http://ec2-18-220-223-91.us-east-2.compute.amazonaws.com:8080/Gruas/service/Operator/E";
    fetch(URI_E)
        .then(res => res.text())
        .then((license) => {
            E = license;
        })

    const URI_E1 = "http://ec2-18-220-223-91.us-east-2.compute.amazonaws.com:8080/Gruas/service/Operator/E1";
    fetch(URI_E1)
        .then(res => res.text())
        .then((license) => {
            E1 = license;
        })


    const URI_G = "http://ec2-18-220-223-91.us-east-2.compute.amazonaws.com:8080/Gruas/service/Operator/G";
    fetch(URI_G)
        .then(res => res.text())
        .then((license) => {
            G = license;
        })

    graphic();
}

function graphic() {
    let myGraphic = document.getElementById("myGraphic").getContext("2d");
    var chart = new Chart(myGraphic, {
        type: "bar",
        data: {
            labels: ["Licencia tipo A", "Licencia Tipo B", "Licencia tipo F",
                "Licencia tipo A1", "Licencia tipo C", "Licencia tipo C1", "Licencia tipo D",
                "Licencia tipo D1", "Licencia tipo E", "Licencia tipo E1", "Licencia tipo G"
            ],
            datasets: [{
                label: "Tipos de Liencias",
                backgroundColor: ["#64FF33", "#FF8033", "#3342FF",
                    "#D7DC47", "#17CC59", "#10BCDF", "#3C13F4",
                    "#F413BD", "#13F4F4", "#1391F4", "#7D13F4"
                ],
                borderColor: "rgb(0,255,0)",
                data: [parseInt(A), parseInt(B), parseInt(F),
                    parseInt(A1), parseInt(C), parseInt(C1), parseInt(D),
                    parseInt(D1), parseInt(E), parseInt(E1), parseInt(G)
                ]
            }]
        },
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: true
                    }
                }]
            }

        }
    })
}