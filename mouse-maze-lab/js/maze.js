$(document).ready(function () {
    var isRunningState = false;
    var winMessage = "You win!";
    var loseMessage = "You lose!";
    var initialMessage = "Click the 'S' to begin.";
    var startedMessage = "You started the game!";

    var changeCursor = function (value) {
        $('#maze').css('cursor', value);
    }

    var showLoseBehavior = function () {
        if (isRunningState) {
            changeCursor('auto');

            $(".boundary").css({
                "background-color": "rgb(255, 136, 136)"
            });

            $("#status")
                .addClass("you-lose-message")
                .removeClass("you-win-message")
                .text(loseMessage);

            setTimeout(function () {
                $("#status")
                    .text(initialMessage)
                    .removeClass("you-lose-message");
            }, 5000);
            isRunningState = false;
        }
    }

    $("#maze .boundary").mouseover(function () {
        showLoseBehavior();
    });

    $("#maze-left").hover(function () {
        showLoseBehavior();
    });

    $("#start").click(function () {
        $(".boundary").css({
            "background-color": "#FFFFFF"
        })

        $("#status")
            .removeClass("you-lose-message")
            .removeClass("you-win-message")
            .text(startedMessage);

        var cursorimg = 'imgs/sedan.png';
        changeCursor('url(' + cursorimg + '), auto');

        isRunningState = true;
    });



    $("#end").mouseover(function () {
        if (isRunningState) {
            changeCursor('auto');
            isRunningState = false;

            $("#status")
                .addClass("you-win-message")
                .removeClass("you-lose-message")
                .text(winMessage);


            setTimeout(function () {
                $("#status")
                    .text(initialMessage)
                    .removeClass("you-win-message");
            }, 5000);
        }
    });
});