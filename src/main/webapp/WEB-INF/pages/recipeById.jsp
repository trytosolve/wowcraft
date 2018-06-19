<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>Recipe Id: ${recipe.id}</div>
<div>Recipe Name: ${recipe.name}</div>

<table class="recipe_config">
    <tr><td>Components for create:</td></tr>
    <c:forEach items="${recipe.reagenCountMap}" var="reagents">
        <tr>
            <td>${reagents.key.name}</td>
            <td>${reagents.value}</td>
        </tr>
    </c:forEach>
</table>