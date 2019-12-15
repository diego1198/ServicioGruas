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
                const form = document.getElementById('formOperator');
                var name = document.getElementById("name").value;
                var lastname = document.getElementById("lastname").value;
                var id = document.getElementById("id").value;
                var license = document.getElementById("license").value;
                var craneManager = parseInt(document.getElementById("craneManager").value);

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
            } else {
                alert("Cedula Inválida");
                return false;
            }
        }
    }

}