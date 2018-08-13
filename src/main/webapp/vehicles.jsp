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

<%--showAll--%>
<div class="container">

    <c:if test="${not empty vehCusts}">
        <table border="1">
            <tr>
                <th style="text-align: center">Id</th>
                <th style="text-align: center">Model</th>
                <th style="text-align: center">Marka</th>
                <th style="text-align: center">Rok produkcji</th>
                <th style="text-align: center">Numer rejestracyjny</th>
                <th style="text-align: center">Następny serwis</th>
                <th style="text-align: center">Imię klienta</th>
                <th style="text-align: center">Nazwisko klienta</th>
                <th style="text-align: center"></th>
                <th style="text-align: center"></th>
            </tr>
            <c:forEach items="${vehCusts}" var="vehCust">
                <tr style="height: 10px">
                    <td style="text-align: center">${vehCust.vehicles.id}</td>
                    <td style="text-align: center">${vehCust.vehicles.model}</td>
                    <td style="text-align: center">${vehCust.vehicles.brand}</td>
                    <td style="text-align: center">${vehCust.vehicles.productionYear}</td>
                    <td style="text-align: center">${vehCust.vehicles.regNumber}</td>
                    <td style="text-align: center">${vehCust.vehicles.nextServiceDate}</td>
                    <td style="text-align: center">${vehCust.customers.name}</td>
                    <td style="text-align: center">${vehCust.customers.surname}</td>
                    <td style="text-align: center">
                        <form method="post" action="vehicles">
                            <button name="edit" type="submit" value="${vehCust.vehicles.id}">Edytuj</button>
                        </form>
                    </td>
                    <td style="text-align: center">
                        <form method="post" action="vehicles">
                            <button name="del" type="submit" value="${vehCust.vehicles.id}">Usuń</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <form style="width: 100%" method="post" action="">
            <button style="width: 600px" name="add" value="add" type="submit">Dodaj pojazd</button>
        </form>
    </c:if>
</div>
<div class="container">
    <%--editVehicle--%>
    <c:if test="${not empty vehicle}">
        <table border="1">
            <tr>
                <th style="text-align: center">Id</th>
                <th style="text-align: center">Model</th>
                <th style="text-align: center">Marka</th>
                <th style="text-align: center">Rok produkcji</th>
                <th style="text-align: center">Numer rejestracyjny</th>
                <th style="text-align: center">Następny serwis</th>
                <th style="text-align: center">Klient</th>
                <th style="text-align: center"></th>
                <th style="text-align: center"></th>
            </tr>
            <tr>
                <form method='post' action='vehicles'>
                    <td style="text-align: center">${vehicle.id}</td>
                    <td style="text-align: center"><input type='text' value='${vehicle.model}' name='model'/></td>
                    <td style="text-align: center"><input type='text' value='${vehicle.brand}' name='brand'/></td>
                    <td style="text-align: center"><input type='number' value='${vehicle.productionYear}'
                                                          name='productionYear'/></td>
                    <td style="text-align: center"><input type='text' value='${vehicle.regNumber}'
                                                          name='regNumber'/></td>
                    <td style="text-align: center"><input type='date' value='${vehicle.nextServiceDate}'
                                                          name='nextServiceDate'/></td>
                    <td style="text-align: center"><input type='number' value='${vehicle.customer_id}'
                                                          name='customer_id'/></td>
                    <td style="text-align: center">
                        <button name="save" type="submit" value="${vehicle.id}">Zapisz</button>
                    </td>
                </form>
                <td style="text-align: center">
                    <form method='post' action='/addCustomerToVehicle'>
                        <button name="vehicleId" type="submit" value="${vehicle.id}">Przypisz Klienta</button>
                    </form>
                </td>
            </tr>
        </table>
    </c:if>
</div>
<%--addVehicle--%>
<div class="container">
    <c:if test="${not empty addinfo}">
        <table border="1">
            <tr>
                <th style="text-align: center">Model</th>
                <th style="text-align: center">Marka</th>
                <th style="text-align: center">Rok produkcji</th>
                <th style="text-align: center">Numer rejestracyjny</th>
                <th style="text-align: center">Następny serwis</th>
                <th style="text-align: center">Klient</th>
                <th style="text-align: center"></th>
                <th style="text-align: center"></th>
            </tr>
            <tr>
                <form method='post' action='vehicles'>
                    <td style="text-align: center"><input type='text' name='model'/></td>
                    <td style="text-align: center"><input type='text' name='brand'/></td>
                    <td style="text-align: center"><input type='number' name='productionYear'/></td>
                    <td style="text-align: center"><input type='text' name='regNumber'/></td>
                    <td style="text-align: center"><input type='date' name='nextServiceDate'/></td>
                    <td style="text-align: center"><input type='number' name='customer_id'/></td>
                    <td style="text-align: center">
                        <button name="save" type="submit" value="0">Zapisz</button>
                    </td>
                </form>
            </tr>
        </table>
    </c:if>
</div>

<%@ include file="/fragments/footer.jsp" %>