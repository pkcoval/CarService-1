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
    <c:if test="${not empty customers}">
        <div style="margin-left: 25%; margin-right: 25%">
            <table border="1">
                <tr>
                    <th style="width: 30px; text-align: center">Id</th>
                    <th style="width: 300px; text-align: center">Imie</th>
                    <th style="width: 300px; text-align: center">Nazwisko</th>
                    <th style="width: 300px; text-align: center">Data urodzenia</th>
                    <th style="width: 300px; text-align: center">Przypisz</th>
                </tr>
                <c:forEach items="${customers}" var="customer">
                    <tr style="height: 10px">
                        <td style="text-align: center">${customer.id}</td>
                        <td style="text-align: center">${customer.name}</td>
                        <td style="text-align: center">${customer.surname}</td>
                        <td style="text-align: center">${customer.birthday}</td>
                        <td style="text-align: center">
                            <form method="post" action="">
                                <input type="hidden" name="vehicleId" value="${vehicleId}"/>
                                <button name="customerId" type="submit" value="${customer.id}">Przypisz</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </c:if>
</div>

<%@ include file="/fragments/footer.jsp" %>



