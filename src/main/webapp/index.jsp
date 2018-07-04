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
    <c:if test="${not empty employees}">
        <div style="margin-left: 25%; margin-right: 25%">
            <table border="1">
                <tr>
                    <th style="width: 30px; text-align: center">Id</th>
                    <th style="width: 300px; text-align: center">Imię</th>
                    <th style="width: 300px; text-align: center">Nazwisko</th>
                    <th style="width: 300px; text-align: center">Email</th>
                    <th style="width: 300px; text-align: center">Adres</th>
                    <th style="width: 300px; text-align: center">Numer telefonu</th>
                    <th style="width: 300px; text-align: center">Notatki</th>
                    <th style="width: 300px; text-align: center">Stawka godzinowa</th>
                    <th style="width: 300px; text-align: center"></th>
                    <th style="width: 300px; text-align: center"></th>
                </tr>
                <c:forEach items="${employees}" var="employee">
                    <tr style="height: 10px">
                        <td style="text-align: center">${employee.id}</td>
                        <td style="text-align: center">${employee.name}</td>
                        <td style="text-align: center">${employee.surname}</td>
                        <td style="text-align: center">${employee.email}</td>
                        <td style="text-align: center">${employee.address}</td>
                        <td style="text-align: center">${employee.phone}</td>
                        <td style="text-align: center">${employee.notice}</td>
                        <td style="text-align: center">${employee.salaryForHour}</td>
                        <td style="text-align: center">
                            <form method="post" action="employees">
                                <button name="edit" type="submit" value="${employees.id}">Edytuj</button>
                            </form>
                        </td>
                        <td style="text-align: center">
                            <form method="post" action="vehicles">
                                <button name="del" type="submit" value="${employees.id}">Usuń</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <div>
                <form style="width: 100%" method="post" action="">
                    <button style="width: 600px" name="add" value="add" type="submit">Dodaj pracownika</button>
                </form>
            </div>
        </div>
    </c:if>
    <%--editEmployee--%>
    <c:if test="${not empty employee}">
        <div style="margin-left: 25%; margin-right: 25%">
            <table border="1">
                <tr>
                    <th style="width: 30px; text-align: center">Id</th>
                    <th style="width: 300px; text-align: center">Imię</th>
                    <th style="width: 300px; text-align: center">Nazwisko</th>
                    <th style="width: 300px; text-align: center">Email</th>
                    <th style="width: 300px; text-align: center">Adres</th>
                    <th style="width: 300px; text-align: center">Numer telefonu</th>
                    <th style="width: 300px; text-align: center">Notatki</th>
                    <th style="width: 300px; text-align: center">Stawka godzinowa</th>
                    <th style="width: 300px; text-align: center"></th>
                    <th style="width: 300px; text-align: center"></th>
                </tr>
                <tr>
                    <form method='post' action='employees'>
                        <td style="text-align: center">${employee.id}</td>
                        <td style="text-align: center"><input type='text' value='${employee.name}' name='name'/></td>
                        <td style="text-align: center"><input type='text' value='${employee.surname}' name='surname'/></td>
                        <td style="text-align: center"><input type='email' value='${employee.email}'
                                                              name='email'/></td>
                        <td style="text-align: center"><input type='text' value='${employee.address}'
                                                              name='address'/></td>
                        <td style="text-align: center"><input type='number' value='${employee.phone}'
                                                              name='phone'/></td>
                        <td style="text-align: center"><input type='text' value='${employee.notice}'
                                                              name='notice'/></td>
                        <td style="text-align: center"><input type='number' value='${employee.salaryForHour}'
                                                              name='salary'/></td>
                        <td style="text-align: center">
                            <button name="save" type="submit" value="${employee.id}">Zapisz</button>
                        </td>
                    </form>
                </tr>
            </table>
        </div>
    </c:if>
    <%--addEmployee--%>
    <c:if test="${not empty addinfo}">
        <div style="margin-left: 25%; margin-right: 25%">
            <table border="1">
                <tr>
                    <th style="width: 300px; text-align: center">Imię</th>
                    <th style="width: 300px; text-align: center">Nazwisko</th>
                    <th style="width: 300px; text-align: center">Email</th>
                    <th style="width: 300px; text-align: center">Adres</th>
                    <th style="width: 300px; text-align: center">Numer telefonu</th>
                    <th style="width: 300px; text-align: center">Notatki</th>
                    <th style="width: 300px; text-align: center">Stawka godzinowa</th>
                    <th style="width: 300px; text-align: center"></th>
                    <th style="width: 300px; text-align: center"></th>
                </tr>
                <tr>
                    <form method='post' action='employees'>
                        <td style="text-align: center"><input type='text' name='name'/></td>
                        <td style="text-align: center"><input type='text' name='surname'/></td>
                        <td style="text-align: center"><input type='email' name='email'/></td>
                        <td style="text-align: center"><input type='text' name='address'/></td>
                        <td style="text-align: center"><input type='number' name='phone'/></td>
                        <td style="text-align: center"><input type='text' name='notice'/></td>
                        <td style="text-align: center"><input type='number' name='salary'/></td>
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



