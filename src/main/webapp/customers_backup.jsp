<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: tomasz
  Date: 29.06.18
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/fragments/header.jsp" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<table border="1">
    <tr>
        <th>id</th>
        <th>Imie</th>
        <th>Nazwisko</th>
        <th>Adress</th>
        <th>Telefon</th>
        <th>Notatki</th>
        <th>KosztRoboczogodzin </th>
    </tr>

    <c:forEach var="customer" items="${lista}" >
        <tr>
            <td>${customer.id} </td>
            <td>${customer.name} </td>
            <td>${customer.surname} </td>
            <td>${customer.address} </td>
            <td>${customer.phone} </td>
            <td>${customer.notice} </td>
            <td>${customer.salaryforhour} </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>



<%@ include file="/fragments/footer.jsp" %>
