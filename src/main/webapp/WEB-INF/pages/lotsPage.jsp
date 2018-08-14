<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="<c:url value="/resources/css/lots.css" />" rel="stylesheet">
<html>
<head>
    <title>Lots</title>
</head>
<body>
<div>
    <a href="${pageContext.request.contextPath}/lots/add">Add Lot</a>
</div>
<table class="lots_table">
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
                <div>Lot Price</div>
            </td>
        </tr>
        <c:forEach items="${lots}" var="lot">
            <tr>
                <td>
                    <div>${lot.id}</div>
                </td>
                <td>
                    <div>${lot.name}</div>
                </td>
                <td>
                    <div>${lot.count}</div>
                </td>
                <td>
                    <div>${lot.price}</div>
                </td>
                <td>
                    <div>
                        <a href="${pageContext.request.contextPath}/lots/buyLot?id=${lot.id}">Buy</a>
                    </div>
                </td>
                <td>
                    <div>
                        <a href="${pageContext.request.contextPath}/lots/delete?id=${lot.id}">Delete</a>
                    </div>
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
    <a href="/stock">Stock</a>
</div>
</body>
</html>
