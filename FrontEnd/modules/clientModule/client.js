function cargar(){
    const URLAPI = "http://ec2-18-220-223-91.us-east-2.compute.amazonaws.com:8080/Gruas/beta/Clients";
    const container = document.getElementById('tableClient');
    let contentHTML = '';
    var i=0;
    fetch(URLAPI)
        .then(res => res.json())
        .then((json)=>{
            container.innerHTML = '';
            for(const service of json){
                i++;
                container.innerHTML += `
                <tr>
                    <th scope="row">${i}</th>
                    <td>${service.clientId}</td>
                    <td>${service.clientName}</td>
                    <td>${service.clientPhone}</td>
                    <td><a data-toggle='tooltip' data-placement='top' title='Update' style='margin-right:5px' class='btn btn-success btn-sm'>
                    <i class="material-icons">build</i>
                    </a></td>
                </tr>
                `;
                
            }
        })
}

function clientById(){
    var id = document.getElementById('id');
    const URLAPI = "http://ec2-18-220-223-91.us-east-2.compute.amazonaws.com:8080/Gruas/beta/Clients/"+id;
    const container = document.getElementById('tableClient');
    let contentHTML = '';
    var i=0;
    fetch(URLAPI)
        .then(res => res.json())
        .then((json)=>{
            container.innerHTML = '';
            for(const service of json){
                i++;
                container.innerHTML += `
                <tr>
                    <th scope="row">${i}</th>
                    <td>${service.clientId}</td>
                    <td>${service.clientName}</td>
                    <td>${service.clientPhone}</td>
                    <td><a data-toggle='tooltip' data-placement='top' title='Update' style='margin-right:5px' class='btn btn-success btn-sm'>
                    <i class="material-icons">build</i>
                    </a></td>
                </tr>
                `;
            }
        })
}