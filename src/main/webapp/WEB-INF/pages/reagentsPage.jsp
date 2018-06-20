<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: IRedko
  Date: 04.05.2018
  Time: 8:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="<c:url value="/resources/css/reagents.css" />" rel="stylesheet">
<html>
<head>
    <title>Reagents</title>
</head>
<body>
<div>${usageError}</div>
<c:forEach items="${usagesList}" var="recipe">
    <span>${recipe.name}</span>
    <span>|</span>
</c:forEach>
<div class="new_reagent">
    <a href="/reagents/add">add_new</a>
</div>
<table class="reagent_table">
    <form:form method="post">
        <tr>
            <td>
                <div>Id</div>
            </td>
            <td>
                <div>Name</div>
            </td>
            <td>
                <div>Sell Price</div>
            </td>
            <td>
                <div></div>
            </td>
            <td>
                <div></div>
            </td>
        </tr>

        <c:forEach items="${allReagents}" var="reagent">
            <tr>
                <td>
                    <div>${reagent.id}</div>
                </td>
                <td>
                    <div>${reagent.name}</div>
                </td>
                <td>
                    <div>${reagent.sellPrice}</div>
                </td>
                <td><a href="${pageContext.request.contextPath}/reagents/edit?id=${reagent.id}">edit</a></td>
                <td><a href="${pageContext.request.contextPath}/reagents/delete?id=${reagent.id}">delete</a></td>
            </tr>
        </c:forEach>
    </form:form>
</table>
<div>
    <a href="/recipes">Recipes</a>
</div>
<div>
    <a href="/items_prices">Items Prices</a>
</div>
<div>
    <a href="/lots">Lots</a>
</div>
</body>
</html>
