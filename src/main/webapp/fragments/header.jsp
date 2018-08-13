<%--
  Created by IntelliJ IDEA.
  User: tomasz
  Date: 30.06.18
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<html>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
    .forDiv {

        width: 25%;
        float: left;
    }
</style>

<head>
    <title>Car Service CRM System</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
</head>
<body>

<div style="height: 30px; text-align: right">
    <label></label> Jesteś zalogowany jako: <c:out value="${sessionScope.name}"/> <c:out
        value="${sessionScope.surname}"/>!</label>

    <form method='post' action='logout'>
        <div><input type='submit' value='Wyloguj'/></div>
    </form>

</div>

<div>

    <div class="forDiv">
    <form>
    <input type="button" value="Pracownicy" onclick="window.location.href='/employees'"/>
    </form>
    </div>

    <div class="forDiv">
    <form>
    <input type="button" value="Zlecenia" onclick="window.location.href='/orders'"/>
    </form>
    </div>

    <div class="forDiv">
    <form>
    <input type="button" value="Pojazdy" onclick="window.location.href='/vehicles'"/>
    </form>
    </div>

    <div class="forDiv">
    <form>
    <input type="button" value="Klienci" onclick="window.location.href='/customers'"/>
    </form>
    </div>

</div>

<%--<div class="collapse navbar-collapse" id="mainNavigation">--%>
    <%--<ul class="navbar-nav mr-auto">--%>
        <%--<li class="nav-item active">--%>
            <%--<a class="nav-link" href="/employees">Pracownicy </a>--%>
        <%--</li>--%>
        <%--<li class="nav-item">--%>
            <%--<a class="nav-link" href="/orders">Zlecenia</a>--%>
        <%--</li>--%>
        <%--<li class="nav-item">--%>
            <%--<a class="nav-link" href="/vehicles">Pojazdy</a>--%>
        <%--</li>--%>
        <%--<li class="nav-item">--%>
            <%--<a class="nav-link" href="/customers">Klienci</a>--%>
        <%--</li>--%>
    <%--</ul>--%>
<%--</div>--%>


</body>

