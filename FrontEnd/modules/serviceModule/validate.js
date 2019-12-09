function validateService(){
    var brand, model, plate, color, origin, destiny, serviceDate, total, dni;

    brand = $('#brand').val();
    model = $('#model').val();
    plate = $('#plate').val();
    color = $('#color').val();
    origin = $('#origin').val();
    destiny = $('#destiny').val();
    serviceDate = $('#service_date').val();
    total = $('#total').val();
    dni = $('#dni').val();

    if(brand != ''){
        if(model != ''){
            if(plate != ''){
                if(color != ''){
                    if(origin != ''){
                        if(destiny != ''){
                            if(serviceDate != ''){
                                if(total != '$' && total != '$'){
                                    validateDNI(dni);
                                }else{
                                    alert('The field Total must be fill')
                                    document.getElementById('total').focus()        
                                }
                            }else{
                                alert('The field Service Date must be fill')
                                document.getElementById('service_date').focus()    
                            }
                        }else{
                            alert('The field destiny must be fill')
                            document.getElementById('destiny').focus()        
                        }
                    }else{
                        alert('The field origin must be fill')
                        document.getElementById('origin').focus()    
                    }
                }else{
                    alert('The field color must be fill')
                    document.getElementById('color').focus()        
                }
            }else{
                alert('The field plate must be fill')
                document.getElementById('plate').focus()    
            }
        }else{
            alert('The field model must be fill')
            document.getElementById('model').focus()    
        }
    }else{
        alert('The field brand must be fill')
        document.getElementById('brand').focus()
    }
}

function validateDNI(dni){
    if(dni.length == 10){
        var cad = dni.trim();
        var total = 0;
        var longitud = cad.length;
        var longcheck = longitud - 1;

        if (cad !== "" && longitud === 10) {
            for (i = 0; i < longcheck; i++) {
                if (i % 2 === 0) {
                    var aux = cad.charAt(i) * 2;
                    if (aux > 9) aux -= 9;
                    total += aux;
                } else {
                    total += parseInt(cad.charAt(i)); // parseInt o concatenará en lugar de sumar
                }
            }

            total = total % 10 ? 10 - total % 10 : 0;

            if (cad.charAt(longitud - 1) == total) {
                alert('All fields are correct!')
            } else {
                alert('Incorrect DNI')
                document.getElementById('dni').focus();
            }
        }
    }else{
        alert('Incorrect DNI')
        document.getElementById('dni').focus()
    }
}

function cargar(){
    const URLAPI = "http://localhost:8080/gruas/Service";
    const container = document.getElementById('tableService');
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
                    <td>${service.serviceDate}</td>
                    <td>${service.servBrand}</td>
                    <td>${service.servModel}</td>
                    <td>${service.servColor}</td>
                    <td>${service.servPlate}</td>
                    <td>${service.servOrig}</td>
                    <td>${service.servDest}</td>
                    <td>${service.servCost}</td>
                    <td><a data-toggle='tooltip' data-placement='top' title='Update' style='margin-right:5px' class='btn btn-success btn-sm'>
                    <i class="material-icons">build</i>
                    </a></td>
                </tr>
                `;
                
            }
        })
}

function getDistance(){
    var apiKey= "";
    var origin = document.getElementById('origin').value;
    var destiny = document.getElementById('destiny').value;
    var URL = "https://maps.googleapis.com/maps/api/distancematrix/json?units=metric&origins="+origin+"&destinations="+destiny+"&key="+apiKey;

    
    fetch(URL)
        .then(res => res.json())
        .then((json)=>{
            var rows = new Array();
            rows = json.rows;
            var row = rows[0];
            var elements = new Array();
            elements = row.elements;
            var elem = elements[0];
            var distance = elem.distance.text;
            $('#result').val(distance);
        })
    

    
}