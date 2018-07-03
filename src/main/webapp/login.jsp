<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tomasz
  Date: 02.07.18
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
<div>
    <div style="margin-left: 25%; margin-right: 25%">
        <div style="text-align: center; left: 20px">
            <form method='post' action='login'>
                <div><input type='email' placeholder='Podaj email' name='email'/></div>
                <div><input type='password' placeholder='Podaj hasło' name='pass'/></div>
                <div><input type='submit' value='Zaloguj'/></div>
            </form>

            <div>${messages.password}<br></div>
            <div>${messages.email}<br></div>
            <div>${messages.login}<br></div>
            <div>${message}<br></div>

        </div>
    </div>
</div>

<%@ include file="/fragments/footer.jsp" %>