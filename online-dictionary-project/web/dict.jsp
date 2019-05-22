<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!doctype html>
<html lang="en">
<head>
    <c:set var="url">${pageContext.request.requestURL}</c:set>
    <base href="${fn:substring(url, 0, fn:length(url) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}/"/>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Online Dictionary</title>

    <link rel="stylesheet" href="css/dict.css">
    <link rel="stylesheet" href="css/toastr.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
          integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">

    <link href="https://fonts.googleapis.com/css?family=Open+Sans&display=swap" rel="stylesheet">
</head>
<body>
<div id="loading">
    <div class="lds-hourglass"></div>
</div>

<div class="header">
    <header>
        <nav aria-label="Site Navigation">
            <div class="header-block">
                <ul class="list-header-block">
                    <li class="text-header">W A P</li>
                </ul>
            </div>
        </nav>
        <div class="header-body">
            <div class="text-header-body"><a href="dict.jsp"><span>Online</span><span>Dictionary</span></a>
                <div class="input-header-block">
                    <label for="term" style="float:left;">Term</label>
                    <input type="search" title="Search" autocomplete="off" autocapitalize="off" autocorrect="off"
                           name="term" class="input-header" id="term">
                    <button aria-label="Search" type="button" id="lookup"
                            class="button-block "><i class="fas fa-search"></i></button>
                </div>
            </div>
        </div>
    </header>
</div>

<div id="dictionary-block" class="dictionary">
        <h1 id="word"></h1>
        <hr/>
        <div id="definitions-block" class="definitions">
        </div>
    </div>
</div>


<script>var BASE_URL = document.getElementsByTagName("base")[0].href;</script>
<script src="js/jquery-3.4.1.min.js"></script>
<script src="js/toastr.min.js"></script>
<script src="js/dict.js"></script>
</body>
</html>

