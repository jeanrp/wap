window.onload = function (e) {
    var btnBigger = document.getElementById('btnBiggerDecoration');
    btnBigger.onclick = biggerDecorationClick;
    var checkBling = document.getElementById('bling');
    checkBling.onchange = checkBlingChange;
    textDecorator.style.fontSize = "12pt";


    var btnIgpayAtinlay = document.getElementById('btnIgpayAtinlay');
    btnIgpayAtinlay.onclick = btnIgpayAtinlayClick;

    var btnMalkovitch = document.getElementById('btnMalkovitch');
    btnMalkovitch.onclick = malkovitchClick;
};

 

var vowels = [
    "a", "á", "à", "ä", "â",
    "e", "é", "è", "ë", "ê",
    "i", "í", "ì", "ï", "î",
    "o", "ó", "ò", "ö", "ô",
    "u", "ú", "ù", "ü", "û"
];


function isVowel(letter) {
    return vowels.indexOf(letter.toLowerCase()) >= 0;
}

function malkovitchClick() {
    debugger;
    var textDecorator = document.getElementById('textDecorator');
    var words = textDecorator.innerHTML.trim().split(' ');

    var newWords = words.map(function (v, i, arr) {
        return v.trim().length >= 5 ? "Malkovich" : v;
    });


    textDecorator.innerText = newWords.join(' ');
}

function btnIgpayAtinlayClick() {
    debugger;
    var textDecorator = document.getElementById('textDecorator');
    var words = textDecorator.innerHTML.trim().split(' ');

    var newWords = words.map(function (v, i, arr) {
        if (!isVowel(v.trim().substr(0, 1)) && isNaN(v.trim().substr(0, 1))) {
            var firstLetter = v.substr(0, 1);
            v = v.substr(1) + firstLetter + 'ay';
        } else if (v.trim().length >= 1) {
            v += "ay";
        }

        return v;
    });

    textDecorator.innerText = newWords.join(' ');
}

function biggerDecorationClick() {
    setInterval(increaseFont, 500);
}

function increaseFont() {
    var textDecorator = document.getElementById('textDecorator');
    var currentFontSize = parseInt(textDecorator.style.fontSize);
    textDecorator.style.fontSize = currentFontSize + 2 + "pt";
}

function checkBlingChange() {
    var textDecorator = document.getElementById('textDecorator');
    var body = document.getElementsByTagName('body')[0];
    if (this.checked) {
        addClass(textDecorator, 'text-characteristics');
        addClass(body, 'body-background');
    } else {
        removeClass(textDecorator, 'text-characteristics');
        removeClass(body, 'body-background');
    }
}


function hasClass(ele, cls) {
    return !!ele.className.match(new RegExp('(\\s|^)' + cls + '(\\s|$)'));
}

function addClass(ele, cls) {
    if (!hasClass(ele, cls)) ele.className += " " + cls;
}

function removeClass(ele, cls) {
    if (hasClass(ele, cls)) {
        var reg = new RegExp('(\\s|^)' + cls + '(\\s|$)');
        ele.className = ele.className.replace(reg, ' ');
    }
}