<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="<c:url value="/resources/css/recipes.css" />" rel="stylesheet">
<html>
<head>
    <title>Reagents</title>
</head>
<body>
<div class="new_recipe">
    <a href="recipes/add">add_new</a>
</div>
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
                <div>Price</div>
            </td>
        </tr>
        <c:forEach items="${allRecipes}" var="recipe">
            <tr>
                <td>
                    <div>${recipe.id}</div>
                </td>
                <td>
                    <a href="/recipes/recipe?id=${recipe.id}"><div>${recipe.name}</div></a>
                </td>
                <td>
                    <div>${recipe.price}</div>
                </td>
                <td><a href="/recipes/edit?id=${recipe.id}">edit</a></td>
                <td><a href="/recipes/delete?id=${recipe.id}">delete</a></td>
            </tr>
        </c:forEach>
    </form:form>
</table>
</body>
</html>
