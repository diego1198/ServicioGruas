function cargar(){
    const URLAPI = "http://localhost:8080/Crane/Vehicles";
    const container = document.getElementById('tableVehicle');
    let contentHTML = '';
    var i=0;
    fetch(URLAPI)
        .then(res => res.json())
        .then((json)=>{
            container.innerHTML = '';
            for(const vehicle of json){
                i++;
                container.innerHTML += `
                <tr>
                    <td>${vehicle.vehicleId}</td>
                    <td>${vehicle.vehicleBrand}</td>
                    <td>${vehicle.vehicleModel}</td>
                    <td>${vehicle.vehicleColor}</td>
                    <td>${vehicle.vehicleLicesePlate}</td>
                    <td>${vehicle.vehicleType}</td>
                    <td><a data-toggle='tooltip' data-placement='top' title='Update' style='margin-right:5px' class='btn btn-success btn-sm'>
                    <i class="material-icons">build</i>
                    </a></td>
                </tr>
                `;
                
            }
        })
}

function registrar(){
        var locationForm = document.getElementById('vehicle-form');

        // Listen for submiot
        locationForm.addEventListener('submit', geocode);


        function geocode(e) {
            // Prevent actual submit
            e.preventDefault();

            var id = document.getElementById('id').value;
            var model = document.getElementById('model').value;
            var brand = document.getElementById('brand').value;
            var color = document.getElementById('color').value;
            var plate = document.getElementById('plate').value;
            var type = document.getElementById('type').value;
            console.log(id);
            console.log(model);
            console.log(brand);
            console.log(color);
            console.log(plate);
            console.log(type);
            axios.get('http://localhost:8080/Crane/Vehicles/'+id+'/'+model+'/'+brand+'/'+color+'/'+plate+'/'+type)
                    .then(function (response) {
                        // Log full response
                        console.log(response);
                        // Formatted Address                
                        alert("dato Registrado");
                    })
                    .catch(function (error) {
                        console.log(error);
                    });
        }
}

function validateRegisterVehicle() {
    var id, model, brand, color, plate, type;

    id = document.getElementById('id').value;
    model = document.getElementById('model').value;
    brand = document.getElementById('brand').value;
    color = document.getElementById('color').value;
    plate = document.getElementById('plate').value;
    type = document.getElementById('type').value;

    if (id === '' || model === '' || brand === '' || color === '' || plate === '' || type === '') {
        alert('fill in the fields ');
        return false;
    } else if (model.length > 20) {
        alert('Model is large');
        return false;
    } else if (brand.length > 20) {
        alert('brand is large');
        return false;
    } else if (plate.length > 8 && plate.length < 8) {
        alert('Insert plate correct');
        return false;
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
