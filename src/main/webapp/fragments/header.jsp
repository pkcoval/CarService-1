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

<div style="text-align: right; left: 20px">
    <form method='post' action='/login'>
        <input type='email' placeholder='Email' name='email'/>
        <input type='password' placeholder='Hasło' name='pass'/>
        <input type='submit' value='Zaloguj'/>
    </form>
    <% session.getAttribute("name"); %>
</div>

<div style="text-align: right; left: 20px">
    <form method='post' action='LoginServlet'>
        Witaj user.name + user.surname
        <input type='submit' value='Wyloguj'/>
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

