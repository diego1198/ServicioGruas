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
                                    alert('El campo total debe estar lleno!!')
                                    document.getElementById('total').focus()        
                                }
                            }else{
                                alert('El campo fecha de servicio debe estar lleno')
                                document.getElementById('service_date').focus()    
                            }
                        }else{
                            alert('El campo destino debe estar lleno')
                            document.getElementById('destiny').focus()        
                        }
                    }else{
                        alert('El campo origen debe estar lleno')
                        document.getElementById('origin').focus()    
                    }
                }else{
                    alert('El campo color debe estar lleno')
                    document.getElementById('color').focus()        
                }
            }else{
                alert('El campo placa debe estar lleno!!')
                document.getElementById('plate').focus()    
            }
        }else{
            alert('El campo modelo debe estar lleno!!')
            document.getElementById('model').focus()    
        }
    }else{
        alert('El campo marca debe estar lleno!!')
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
                postService();
            } else {
                alert('Cédula incorrecta')
                document.getElementById('dni').focus();
            }
        }
    }else{
        alert('Cédula incorrecta')
        document.getElementById('dni').focus()
    }
}

function postService(){
    var brand,model,plate,color,origin,destiny,distance,servDate,DNI,total;
    brand = $('#brand').val();
    model = $('#model').val();
    plate = $('#plate').val();
    color = $('#color').val();
    origin = $('#origin').val();
    destiny = $('#destiny').val();
    distance = $('#result').val();
    servDate = $('#service_date').val();
    DNI = $('#dni').val();
    total = $('#total').val();
    var service = new Object();
    service.servid = 0;
    service.servBrand = brand;
    service.servModel = model;
    service.servPlate = plate;
    service.servColor = color;
    service.servOrig = origin;
    service.servDest = destiny;
    service.servDistance = distance;
    service.serviceDate = servDate;
    service.servCost = total;
    service.servUnity = "0";

    console.log(JSON.stringify(service));

    jQuery.ajax({
        'type': 'POST',
        'url': 'http://ec2-18-220-223-91.us-east-2.compute.amazonaws.com:8080/Gruas/service/Service',
        'contentType': 'application/json',
        'data': JSON.stringify(service),
        'dataType': 'json'
        });

    alert('Servicio agregado correctamente');
    location.reload();
    

}


function cargar(){
    const URLAPI = "http://ec2-18-220-223-91.us-east-2.compute.amazonaws.com:8080/Gruas/service/Service";
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
                    <td>${service.servDistance}</td>
                </tr>
                `;
                
            }
        })
}

function getDistance(){
    var apiKey= "AIzaSyDgvZ2fd-Ic_8HvT2ZoAGGC-l76wc_D9mo";
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
            var km = elem.distance.value;
            setCost(km);
            $('#result').val(distance);
        })
    

    
}

function setCost(km){
    var cost;
    if(km < 10000){
        cost = 30;
    }else if(km>= 10000 && km< 20000){
        cost = 50;
    }else if(km>= 20000 && km< 40000){
        cost = 70;
    }else if(km>= 40000 && km<= 80000){
        cost = 90;
    }else{
        cost = 140;
    }
    $('#total').val(cost);
}