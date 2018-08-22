<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="<c:url value="/resources/css/stock.css" />" rel="stylesheet">
<html>
<head>
    <title>Stock</title>
</head>
<body>
<table class="stock_table">
    <form:form method="post">
        <tr>
            <td>
                <div>Id</div>
            </td>
            <td>
                <div>Price/Count</div>
            </td>
        </tr>
        <c:forEach items="${leftovers}" var="leftover">
            <tr>
                <td>
                    <div>${leftover.itemId}</div>
                </td>
                <td>
                <c:forEach items="${leftover.buckets}" var="bucketLeftover">
                            <table class="bucket">
                                <tr>
                                    <td>${bucketLeftover.bucket.price}</td>
                                    <td>${bucketLeftover.itemCount}</td>
                                </tr>
                            </table>
                </c:forEach>
                </td>
            </tr>
        </c:forEach></form:form>
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
