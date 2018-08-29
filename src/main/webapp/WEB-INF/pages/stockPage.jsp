<%@ page import="com.iredko.wowcraft2.components.stock.ItemLeftover" %>
<%@ page import="com.iredko.wowcraft2.service.SortBucketLeftoverByPrice" %>
<%@ page import="com.iredko.wowcraft2.components.stock.BucketLeftover" %>
<%@ page import="java.util.*" %>
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
        <%
            List<ItemLeftover>  sortedItemList = new ArrayList((Set<ItemLeftover>) request.getAttribute("leftovers"));
            Collections.sort(sortedItemList, new Comparator<ItemLeftover>() {
                public int compare (ItemLeftover i1, ItemLeftover i2) {
                    return (i2.getItemId() > i1.getItemId() ? -1 : (i2.getItemId() == i1.getItemId() ? 0 : 1));
                }
            });
        %>
        <c:forEach items="<%=sortedItemList%>" var="leftover">
            <tr>
                <td>
                    <div>${leftover.itemId}</div>
                </td>
                <td>
                    <%
                        ItemLeftover itemLeftover = (ItemLeftover) pageContext.getAttribute("leftover");
                        List<BucketLeftover> sortedBuckets = new ArrayList(itemLeftover.getBuckets());
                        Collections.sort(sortedBuckets,new SortBucketLeftoverByPrice());
                    %>
                    <c:forEach items="<%=sortedBuckets%>" var="bucketLeftover">
                        <table class="bucket">
                            <c:if test="${bucketLeftover.itemCount != 0}">
                                <tr>
                                    <td>${bucketLeftover.bucket.price}</td>
                                    <td>${bucketLeftover.itemCount}</td>
                                </tr>
                            </c:if>
                        </table>
                    </c:forEach>
                </td>
            </tr>
        </c:forEach></form:form>

    <c:set var="test" value="test1"/>
</table>
<div>
    <a href="/recipes">Recipes</a>
</div>
<div>
    <a href="/reagents">Reagents</a>
</div>
<div>
    <a href="/lots">Lots</a>
</div>
</body>
</html>
