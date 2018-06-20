<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="<c:url value="/resources/css/recipes.css" />" rel="stylesheet">
<html>
<head>
    <title>Lots</title>
</head>
<body>
<table class="recipe_table">
    <form:form method="post">
        <tr>
            <td>
                <div>Id</div>
            </td>
            <td>
                <div>Name</div>
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
                    <div>${lot.price}</div>
                </td>
            </tr>
        </c:forEach>
    </form:form>

    <div>
        <a href="${pageContext.request.contextPath}/lots/add">Add Lot</a>
    </div>
</table>
</body>
</html>
