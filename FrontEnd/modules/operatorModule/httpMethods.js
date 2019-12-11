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