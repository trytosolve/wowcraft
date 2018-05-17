<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.3.1.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/reagentCreation.js"/>"></script>

<form:form id="edit_recipe_page" action="${pageContext.request.contextPath}/recipes/edit" modelAttribute="recipeForm"
           method="post">
    <table class="recipe_property">
        <tr>
            <td>Recipe Name:</td>
            <td><form:input id="name" path="name"/></td>
            <td><form:errors path="name"/></td>
        </tr>
        <c:forEach items="${recipeForm.reagentCountMap}" var="entry">
            <tr>
                <td>Reagent</td>
                <td>
                    <form:select id="cboReagents" path="">
                        <c:forEach items="${recipeForm.allReagentList}" var="reagent">
                            <option class="reagentName" value="${reagent.id}" ${reagent.id == entry.key ? 'selected' : ''}>
                                ${reagent.name}</option>
                        </c:forEach>
                    </form:select>
                </td>
                <td>count: <form:input class="count"  path="" value="${entry.value}"/></td>
            </tr>
        </c:forEach>

        <div>--------------------------------------------------</div>
        <tr class="clone_reagent">
            <td>Recipe:</td>
            <td>
                <form:select id="cboReagents" path="">
                    <c:forEach items="${recipeForm.allReagentList}" var="reagent">
                        <form:option class="reagentName" value="${reagent.id}">${reagent.name}</form:option>
                    </c:forEach>
                </form:select>
            </td>
            <td>count: <form:input class="count"  path=""/></td>
        </tr>
    </table>
    <div><button class="add" type="button" value="none">Add reagent</button></div>
    <div><button class="del" type="button" value="none">Del reagent</button></div>
    <div><button class="test" type="button" value="none">test</button></div>
    <div><input type="submit" value="Submit"/></div>

</form:form>