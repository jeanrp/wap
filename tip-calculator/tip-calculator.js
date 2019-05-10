function calculateTip() {
    var subTotal = document.getElementById('subtotal');
    var tip = document.getElementById('tip'); 

    if (isNaN(subTotal.value) || isNaN(tip.value)) {
        alert('You shoud fill the fields with a number before calculate.');
        document.getElementById('total').innerHTML = '';
    } else {
        var tip = parseFloat(subTotal.value) * (parseFloat(tip.value) / 100);
        var result = parseFloat(subTotal.value) + parseFloat(tip); 
        document.getElementById('total').innerHTML = '$'+ result.toFixed(2);
    }
}

function isNumber(n) { return !isNaN(parseFloat(n)) && !isNaN(n - 0) }
