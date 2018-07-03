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
<style>
    .forDiv {
        width: 20%;
        float: left;
    }
</style>

<head>
    <title>Car Service CRM System</title>
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
            <input type="button" value="Główna" onclick="window.location.href='..'"/>
        </form>
    </div>

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
</body>

