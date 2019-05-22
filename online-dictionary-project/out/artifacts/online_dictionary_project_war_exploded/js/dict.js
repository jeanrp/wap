$(document).ready(function () {
    (function () {
        toastr.options = {
            "preventDuplicates": true,
            "preventOpenDuplicates": true
        };

        $("#term").focus();


    })();

    $("#term").bind('keypress', function (e) {
        if (e.keyCode == 13) {
            $('#lookup').trigger('click');
        }
    });


    $("#lookup").click(function () {

        var termText = $("#term").val();

        if (termText) {

            var term = {word: termText};

            getWordDefinitions(term);
        } else {
            toastr["info"]("You must fill the textbox before submitting");
        }
    })


    function getWordDefinitions(entry) {
        console.log(BASE_URL + 'DictServlet');

        $.ajax({
            url: BASE_URL + 'DictServlet',
            data: entry,
            method: 'GET',
            dataType: 'json',
            beforeSend: function () {
                $("#loading").fadeIn();
            },
            success: function (data) {

                if (data) {
                    toastr["success"]("Word and definitions found with success!");
                    fillWordDefinitionBlock(data);
                } else {
                    toastr["info"]("The word was not found");
                    $("#dictionary-block").css("display", "none");
                }

                $("#loading").fadeOut();
            },
            error: function (e) {
                $("#dictionary-block").css("display", "none");
                toastr["error"]("An unexpected error occurred.");
                $("#loading").fadeOut();
            }

        });
    }

    function fillWordDefinitionBlock(data) {
        $("#definitions-block").empty();

        $("#word").text(data.word.toLowerCase());

        data.wordTypeList.forEach((v, i) => {
            $("#definitions-block").append("<div class='line'><span><strong>"+i + "</strong>&nbsp;&nbsp;<strong>(" + v + ")</strong>&nbsp;&nbsp;::&nbsp;&nbsp;</span><span>" +data.definitionList[i]+ "</span></div>");
        });
        $("#dictionary-block").css("display", "block");

    }


});