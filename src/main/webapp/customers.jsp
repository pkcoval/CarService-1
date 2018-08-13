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
    <c:if test="${not empty customers}">
        <table border="1">
            <tr>
                <th style="width: 5%; text-align: center">Id</th>
                <th style="width: 20%; text-align: center">Imie</th>
                <th style="width: 30%; text-align: center">Nazwisko</th>
                <th style="width: 25%; text-align: center">Data urodzenia</th>
                <th style="width: 10%; text-align: center">Edytuj</th>
                <th style="width: 10%; text-align: center">Usuń</th>
            </tr>
            <c:forEach items="${customers}" var="customer">
                <tr>
                    <td style="text-align: center">${customer.id}</td>
                    <td style="text-align: center">${customer.name}</td>
                    <td style="text-align: center">${customer.surname}</td>
                    <td style="text-align: center">${customer.birthday}</td>
                    <td style="text-align: center">
                        <form method="post" action="customers">
                            <button name="edit" type="submit" value="${customer.id}">Edytuj</button>
                        </form>
                    </td>
                    <td style="text-align: center">
                        <form method="post" action="customers">
                            <button name="del" type="submit" value="${customer.id}">Usuń</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <form method="post" action="">
            <button name="add" value="add" type="submit">Dodaj użytkownika</button>
        </form>

    </c:if>
</div>
<%--editCustomer--%>
<div class="container">
    <c:if test="${not empty customer}">
        <table border="1">
            <tr>
                <th style="width: 5%; text-align: center">Id</th>
                <th style="width: 25%; text-align: center">Imie</th>
                <th style="width: 30%; text-align: center">Nazwisko</th>
                <th style="width: 20%; text-align: center">Data urodzenia</th>
                <th style="width: 20%; text-align: center"></th>
            </tr>
            <tr>
                <form method='post' action='customers'>
                    <td style="text-align: center">${customer.id}</td>
                    <td style="text-align: center"><input type='text' value='${customer.name}' name='name'/></td>
                    <td style="text-align: center"><input type='text' value='${customer.surname}' name='surname'/>
                    </td>
                    <td style="text-align: center"><input type='date' value='${customer.birthday}' name='birthday'/>
                    </td>
                    <td style="text-align: center">
                        <button name="save" type="submit" value="${customer.id}">Zapisz</button>
                    </td>
                </form>
            </tr>
        </table>
    </c:if>
</div>
<%--addCustomer--%>
<div class="container">
    <c:if test="${not empty addinfo}">

        <table border="1">
            <tr>
                <th style="width: 25%; text-align: center">Imie</th>
                <th style="width: 30%; text-align: center">Nazwisko</th>
                <th style="width: 25%; text-align: center">Data urodzenia</th>
                <th style="width: 20%; text-align: center"></th>
            </tr>
            <tr>
                <form method='post' action='customers'>
                    <td style="width: 25%; text-align: center"><input type='text' name='name'/></td>
                    <td style="width: 30%; text-align: center"><input type='text' name='surname'/></td>
                    <td style="width: 25%; text-align: center"><input type='date' name='birthday'/></td>
                    <td style="width: 20%; text-align: center">
                        <button name="save" type="submit" value="0">Zapisz</button>
                    </td>
                </form>
            </tr>
        </table>
    </c:if>
</div>

<%@ include file="/fragments/footer.jsp" %>