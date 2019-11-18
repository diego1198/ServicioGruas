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
                alert("Cedula Inválida");
                return false;
            }
        }
    }else{
        alert('Incorrect DNI')
        document.getElementById('dni').focus()
    }
}