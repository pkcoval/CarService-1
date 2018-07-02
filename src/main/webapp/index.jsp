<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: tomasz
  Date: 29.06.18
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/fragments/header.jsp" %><br>

<div>
    <div style="margin-left: 25%; margin-right: 25%">
        <br><br><br><br>
        <h3>Pracownicy</h3>
        <br>
        <ul>
            <c:forEach items="${list}" var="lista">
                <li>${lista.name}, ${lista.email}
                    <a href="/?id=${lista.id}">Szczegóły</a>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>

<% session.getAttribute("name"); %>

<%@ include file="/fragments/footer.jsp" %>
