<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="st" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
    <script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
    <style>
        .demo-card-wide.mdl-card {
            width: 350px;
        }
        .demo-card-wide > .mdl-card__title {
            color: #fff;
            height: 175px;
            background: center / cover #46B6AC;
        }
        .demo-card-wide > .mdl-card__menu {
            color: #fff;
        }
        #main_div{
            width: 1000px;
            height: auto;
            margin-left: 250px;
        }
    </style>
    <title>home</title>
</head>
<body>
    <h1 align="center">Prouducts</h1>

    <%--${prouductList[0].name}--%>
    <%--${prouductList[0].description}--%>

    <form action="/new_prouduct" style="margin-left: 200px;">
        <button class="btn btn-info" type="submit" > Add new prouduct</button>
    </form></br>

    <div id = "main_div" align="center">
        <c:forEach items="${prouductList}" var="prouduct" varStatus="loop">

            <div class="demo-card-wide mdl-card mdl-shadow--2dp" style="float: left; margin-left: 100px; margin-top: 50px;">
                <div class="mdl-card__title">
                    <img src="<c:url value='/resources/images/${prouduct.id}.png'/>" style="width: 350px; height: 175px; float: left">
                </div>
                <div class="mdl-card__supporting-text" align="left">
                    <h2 class="mdl-card__title-text" style="float: inside;"> name : ${prouduct.name}</h2><br>
                    <p> description : ${prouduct.description}</p>
                </div>
                <div class="mdl-card__actions mdl-card--border">
                    <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
                        Buy now
                    </a>
                </div>
                <div class="mdl-card__menu">
                    <button class="mdl-button mdl-button--icon mdl-js-button mdl-js-ripple-effect">
                        <i class="material-icons">share</i>
                    </button>
                </div>
            </div>
        </c:forEach>
    </div>
    </br>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>
