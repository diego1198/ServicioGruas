
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