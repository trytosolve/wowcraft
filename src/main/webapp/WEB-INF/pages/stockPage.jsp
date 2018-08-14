<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="<c:url value="/resources/css/stock.css" />" rel="stylesheet">
<html>
<head>
    <title>Lots</title>
</head>
<body>
<div>
    <a href="${pageContext.request.contextPath}/lots/add">Add Lot</a>
</div>
<table class="stock_table">
    <form:form method="post">
        <tr>
            <td>
                <div>Id</div>
            </td>
            <td>
                <div>Name</div>
            </td>
            <td>
                <div>Count</div>
            </td>
            <td>
                <div>Stock Price</div>
            </td>
        </tr>
        <c:forEach items="${allStockBranches}" var="brunch">
            <tr>
                <td>
                    <div>${brunch.id}</div>
                </td>
                <td>
                    <div>${brunch.name}</div>
                </td>
                <td>
                    <div>${brunch.count}</div>
                </td>
                <td>
                    <div>${brunch.price}</div>
                </td>
            </tr>
        </c:forEach>
    </form:form>
</table>
<div>
    <a href="/recipes">Recipes</a>
</div>
<div>
    <a href="/reagents">Reagents</a>
</div>
<div>
    <a href="/items_prices">Items Prices</a>
</div>
<div>
    <a href="/lots">Lots</a>
</div>
</body>
</html>