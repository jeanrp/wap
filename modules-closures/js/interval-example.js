

var rudyTimer = (function()
{
    var timer = null;  // stores ID of interval timer 
    function rudy() {   // called each time the timer goes off
        document.getElementById("output2").innerHTML += " Rudy!";
    }
    function delayMsg2() {
        if (timer == null) {
            timer = setInterval(rudy, 1000);
        } else {
            clearInterval(timer);
            timer = null;
        }
    }

    return delayMsg2;
})();