function cargar(){
    const URLAPI = "http://localhost:8080/Crane/Clients";
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