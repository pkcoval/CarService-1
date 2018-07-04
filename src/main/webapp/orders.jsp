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

<br>
<%--showAll--%>
<div>
    <c:if test="${not empty orders}">
        <div style="margin-left: 25%; margin-right: 25%">
            <table border="1">
                <tr>
                    <th style="width: 30px; text-align: center">Id</th>
                    <th style="width: 300px; text-align: center">Data przyjęcia pojazdu</th>
                    <th style="width: 300px; text-align: center">Planowana data ropoczęcia naprawy</th>
                    <th style="width: 300px; text-align: center">Data rozpoczęcia naprawy</th>
                    <th style="width: 300px; text-align: center">Opis uszkodzenia</th>
                    <th style="width: 300px; text-align: center">Opis naprawy</th>
                    <th style="width: 300px; text-align: center">Id Pracownika</th>
                    <th style="width: 300px; text-align: center">Id Pojazdu</th>
                    <th style="width: 300px; text-align: center">Status</th>
                    <th style="width: 300px; text-align: center">Koszt dla klienta</th>
                    <th style="width: 300px; text-align: center">Koszt części</th>
                    <th style="width: 300px; text-align: center">Stawka godzinowa pracownika</th>
                    <th style="width: 300px; text-align: center">Ilość roboczogodzin</th>
                    <th style="width: 300px; text-align: center"></th>
                    <th style="width: 300px; text-align: center"></th>
                </tr>
                <c:forEach items="${orders}" var="order">
                    <tr style="height: 10px">
                        <td style="text-align: center">${orders.id}</td>
                        <td style="text-align: center">${orders.takeCar}</td>
                        <td style="text-align: center">${orders.planStartRepair}</td>
                        <td style="text-align: center">${orders.startRepair}</td>
                        <td style="text-align: center">${orders.descriptionFault}</td>
                        <td style="text-align: center">${orders.descriptionRepair}</td>
                        <td style="text-align: center">${orders.employee_id}</td>
                        <td style="text-align: center">${orders.vehicle_id}</td>
                        <td style="text-align: center">${orders.status_id}</td>
                        <td style="text-align: center">${orders.costForCustomer}</td>
                        <td style="text-align: center">${orders.costParts}</td>
                        <td style="text-align: center">${orders.salaryForHour}</td>
                        <td style="text-align: center">${orders.amountOfHour}</td>
                        <td style="text-align: center">
                            <form method="post" action="orders">
                                <button name="edit" type="submit" value="${orders.id}">Edytuj</button>
                            </form>
                        </td>
                        <td style="text-align: center">
                            <form method="post" action="orders">
                                <button name="del" type="submit" value="${orders.id}">Usuń</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <div>
                <form style="width: 100%" method="post" action="">
                    <button style="width: 600px" name="add" value="add" type="submit">Dodaj zlecenie</button>
                </form>
            </div>
        </div>
    </c:if>
    <%--editOrder--%>
    <c:if test="${not empty order}">
        <div style="margin-left: 25%; margin-right: 25%">
            <table border="1">
                <tr>
                    <th style="width: 30px; text-align: center">Id</th>
                    <th style="width: 300px; text-align: center">Data przyjęcia pojazdu</th>
                    <th style="width: 300px; text-align: center">Planowana data ropoczęcia naprawy</th>
                    <th style="width: 300px; text-align: center">Data rozpoczęcia naprawy</th>
                    <th style="width: 300px; text-align: center">Opis uszkodzenia</th>
                    <th style="width: 300px; text-align: center">Opis naprawy</th>
                    <th style="width: 300px; text-align: center">Id Pracownika</th>
                    <th style="width: 300px; text-align: center">Id Pojazdu</th>
                    <th style="width: 300px; text-align: center">Status</th>
                    <th style="width: 300px; text-align: center">Koszt dla klienta</th>
                    <th style="width: 300px; text-align: center">Koszt części</th>
                    <th style="width: 300px; text-align: center">Stawka godzinowa pracownika</th>
                    <th style="width: 300px; text-align: center">Ilość roboczogodzin</th>
                    <th style="width: 300px; text-align: center"></th>
                    <th style="width: 300px; text-align: center"></th>
                </tr>
                <tr>
                    <form method='post' action='orders'>
                        <td style="text-align: center">${order.id}</td>
                        <td style="text-align: center"><input type='date' value='${order.takeCar}' name='takeCar'/></td>
                        <td style="text-align: center"><input type='date' value='${order.planStartRepair}'
                                                              name='brand'/></td>
                        <td style="text-align: center"><input type='date' value='${order.startRepair}'
                                                              name='startRepair'/></td>
                        <td style="text-align: center"><input type='text' value='${order.descriptionFault}'
                                                              name='descriptionFault'/></td>
                        <td style="text-align: center"><input type='text' value='${order.descritpionRepair}'
                                                              name='descriptionRepair'/></td>
                        <td style="text-align: center"><input type='number' value='${order.employee_id}'
                                                              name='employee_id'/></td>
                        <td style="text-align: center"><input type='number' value='${order.vehicle_id}'
                                                              name='vehicle_id'/></td>
                        <td style="text-align: center"><input type='number' value='${order.status_id}'
                                                              name='status_id'/></td>
                        <td style="text-align: center"><input type='number' value='${order.costForCustomer}'
                                                              name='employee_id'/></td>
                        <td style="text-align: center"><input type='number' value='${order.costPart}'
                                                              name='costPart'/></td>
                        <td style="text-align: center"><input type='number' value='${order.salaryForHour}'
                                                              name='employee_id'/></td>
                        <td style="text-align: center"><input type='number' value='${order.amountOfHour}'
                                                              name='employee_id'/></td>
                        <td style="text-align: center">
                            <button name="save" type="submit" value="${order.id}">Zapisz</button>
                        </td>
                    </form>
                </tr>
            </table>
        </div>
    </c:if>
    <%--addOrder--%>
    <c:if test="${not empty addinfo}">
        <div style="margin-left: 25%; margin-right: 25%">
            <table border="1">
                <tr>
                    <th style="width: 300px; text-align: center">Data przyjęcia pojazdu</th>
                    <th style="width: 300px; text-align: center">Opis uszkodzenia</th>
                    <th style="width: 300px; text-align: center">Id Pojazdu</th>
                    <th style="width: 300px; text-align: center"></th>
                    <th style="width: 300px; text-align: center"></th>
                </tr>
                <tr>
                    <form method='post' action='vehicles'>
                        <td style="text-align: center"><input type='date' name='takeCar'/></td>
                        <td style="text-align: center"><input type='text' name='descriptionFault'/></td>
                        <td style="text-align: center"><input type='number' name='vehicles_id'/></td>
                        <td style="text-align: center">
                            <button name="save" type="submit" value="0">Zapisz</button>
                        </td>
                    </form>
                </tr>
            </table>
        </div>
    </c:if>

</div>

<%@ include file="/fragments/footer.jsp" %>



