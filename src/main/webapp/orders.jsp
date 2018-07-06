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
    <c:if test="${not empty orders}">
        <table border="1">
            <tr>
                <th style="text-align: center">Id</th>
                <th style="text-align: center">Data przyjęcia pojazdu</th>
                <th style="text-align: center">Planowana data ropoczęcia naprawy</th>
                <th style="text-align: center">Data rozpoczęcia naprawy</th>
                <th style="text-align: center">Opis uszkodzenia</th>
                <th style="text-align: center">Opis naprawy</th>
                <th style="text-align: center">Id Pracownika</th>
                <th style="text-align: center">Id Pojazdu</th>
                <th style="text-align: center">Status</th>
                <th style="text-align: center">Koszt dla klienta</th>
                <th style="text-align: center">Koszt części</th>
                <th style="text-align: center">Stawka godzinowa pracownika</th>
                <th style="text-align: center">Ilość roboczogodzin</th>
                <th style="text-align: center"></th>
                <th style="text-align: center"></th>
            </tr>
            <c:forEach items="${orders}" var="order">
                <tr style="height: 10px">
                    <td style="text-align: center">${order.id}</td>
                    <td style="text-align: center">${order.takeCar}</td>
                    <td style="text-align: center">${order.planStartRepair}</td>
                    <td style="text-align: center">${order.startRepair}</td>
                    <td style="text-align: center">${order.descriptionFault}</td>
                    <td style="text-align: center">${order.descriptionRepair}</td>
                    <td style="text-align: center">${order.employee_id}</td>
                    <td style="text-align: center">${order.vehicles_id}</td>
                    <td style="text-align: center">${order.status_id}</td>
                    <td style="text-align: center">${order.costForCustomer}</td>
                    <td style="text-align: center">${order.costParts}</td>
                    <td style="text-align: center">${order.salaryForHour}</td>
                    <td style="text-align: center">${order.amountOfHour}</td>
                    <td style="text-align: center">
                        <form method="post" action="orders">
                            <button name="edit" type="submit" value="${order.id}">Edytuj</button>
                        </form>
                    </td>
                    <td style="text-align: center">
                        <form method="post" action="orders">
                            <button name="del" type="submit" value="${order.id}">Usuń</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <form style="width: 100%" method="post" action="">
            <button style="width: 600px" name="add" value="add" type="submit">Dodaj zlecenie</button>
        </form>

    </c:if>
</div>
<%--editOrder--%>
<div class="container">
    <c:if test="${not empty order}">
        <table border="1">
            <tr>
                <th style="text-align: center">Id</th>
                <th style="text-align: center">Data przyjęcia pojazdu</th>
                <th style="text-align: center">Planowana data ropoczęcia naprawy</th>
                <th style="text-align: center">Data rozpoczęcia naprawy</th>
                <th style="text-align: center">Opis uszkodzenia</th>
                <th style="text-align: center">Opis naprawy</th>
                <th style="text-align: center">Id Pracownika</th>
                <th style="text-align: center">Id Pojazdu</th>
                <th style="text-align: center">Status</th>
                <th style="text-align: center">Koszt dla klienta</th>
                <th style="text-align: center">Koszt części</th>
                <th style="text-align: center">Stawka godzinowa pracownika</th>
                <th style="text-align: center">Ilość roboczogodzin</th>
                <th style="text-align: center"></th>
                <th style="text-align: center"></th>
            </tr>
            <tr>
                <form method='post' action='orders'>
                    <td style="text-align: center">${order.id}</td>
                    <td style="text-align: center"><input type='date' value='${order.takeCar}' name='takeCar'/></td>
                    <td style="text-align: center"><input type='date' value='${order.planStartRepair}'
                                                          name='planStartRepair'/></td>
                    <td style="text-align: center"><input type='date' value='${order.startRepair}'
                                                          name='startRepair'/></td>
                    <td style="text-align: center"><input type='text' value='${order.descriptionFault}'
                                                          name='descriptionFault'/></td>
                    <td style="text-align: center"><input type='text' value='${order.descriptionRepair}'
                                                          name='descriptionRepair'/></td>
                    <td style="text-align: center"><input type='number' value='${order.employee_id}'
                                                          name='employee_id'/></td>
                    <td style="text-align: center"><input type='number' value='${order.vehicles_id}'
                                                          name='vehicles_id'/></td>
                    <td style="text-align: center"><input type='number' value='${order.status_id}'
                                                          name='status_id'/></td>
                    <td style="text-align: center"><input type='number' value='${order.costForCustomer}'
                                                          name='costForCustomer'/></td>
                    <td style="text-align: center"><input type='number' value='${order.costParts}'
                                                          name='costParts'/></td>
                    <td style="text-align: center"><input type='number' value='${order.salaryForHour}'
                                                          name='salaryForHour'/></td>
                    <td style="text-align: center"><input type='number' value='${order.amountOfHour}'
                                                          name='amountOfHour'/></td>
                    <td style="text-align: center">
                        <button name="save" type="submit" value="${order.id}">Zapisz</button>
                    </td>
                </form>
            </tr>
        </table>
    </c:if>
</div>
<%--addOrder--%>
<div class="container">
    <c:if test="${not empty addinfo}">
        <table border="1">
            <tr>
                <th style="text-align: center">Data przyjęcia pojazdu</th>
                <th style="text-align: center">Planowana data ropoczęcia naprawy</th>
                <th style="text-align: center">Data rozpoczęcia naprawy</th>
                <th style="text-align: center">Opis uszkodzenia</th>
                <th style="text-align: center">Opis naprawy</th>
                <th style="text-align: center">Id Pracownika</th>
                <th style="text-align: center">Id Pojazdu</th>
                <th style="text-align: center">Status</th>
                <th style="text-align: center">Koszt dla klienta</th>
                <th style="text-align: center">Koszt części</th>
                <th style="text-align: center">Stawka godzinowa pracownika</th>
                <th style="text-align: center">Ilość roboczogodzin</th>
                <th style="text-align: center"></th>
                <th style="text-align: center"></th>
            </tr>
            <tr>
                <form method='post' action='orders'>
                    <td style="text-align: center"><input type='date' name='takeCar'/></td>
                    <td style="text-align: center"><input type='date' name='planStartRepair'/></td>
                    <td style="text-align: center"><input type='date' name='startRepair'/></td>
                    <td style="text-align: center"><input type='text' name='descriptionFault'/></td>
                    <td style="text-align: center"><input type='text' name='descriptionRepair'/></td>
                    <td style="text-align: center"><input type='number' name='employee_id'/></td>
                    <td style="text-align: center"><input type='number' name='vehicles_id'/></td>
                    <td style="text-align: center"><input type='number' name='status_id'/></td>
                    <td style="text-align: center"><input type='number' name='costForCustomer'/></td>
                    <td style="text-align: center"><input type='number' name='costParts'/></td>
                    <td style="text-align: center"><input type='number' name='salaryForHour'/></td>
                    <td style="text-align: center"><input type='number' name='amountOfHour'/></td>
                    <td>
                        <button name="save" type="submit" value="0">Zapisz</button>
                    </td>
                </form>
            </tr>
        </table>
    </c:if>
</div>

<%@ include file="/fragments/footer.jsp" %>



