function validateOperatorRegister() {

    var name, lastName, id, license, craneManager;

    name = document.getElementById('name').value;
    lastName = document.getElementById('lastname').value;
    id = document.getElementById('id').value;
    license = document.getElementById('license').value;
    craneManager = document.getElementById('craneManager').value;

    if (name == '' || lastName == '' || id == '' || license == '0' || craneManager == '0') {
        alert('fill in the fields ');
        return false;
    } else if (name == "" || name == null) {
        alert('Name must be filled out');
        return false;
    } else if (name.length > 50) {
        alert('The name is very long');
        return false;
    } else if (name.length < 3) {
        alert('The name must have a minimum of 3 characters');
        return false;
    } else if (lastName == "" || lastName == null) {
        alert('LastName must be filled out');
        return false;
    } else if (lastName.length > 50) {
        alert('The Last Name is very long');
        return false;
    } else if (lastName.length < 3) {
        alert('The Last Name must have a minimum of 3 characters');
        return false;
    } else if (id == "" || id == null) {
        alert('enter your ID');
        return false;
    } else if (id.length !== 10) {
        alert('incorrect ID');
        return false;
    } else if (id.length == 10) {

        var cad = document.getElementById("id").value.trim();
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
                // alert("Cedula Válida");
            } else {
                alert("Cedula Inválida");
                return false;
            }
        }
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