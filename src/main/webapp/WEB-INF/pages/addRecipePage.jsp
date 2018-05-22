<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.3.1.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/reagentCreation.js"/>"></script>

<form:form id="recipe_form" action="${pageContext.request.contextPath}/recipes/add" modelAttribute="recipeForm"
           method="post">
    <div class="error_red">${optionError}</div>
    <table id="recipe_property">
        <tr>
            <td>Recipe Name:</td>
            <td><form:input id="name" path="name"/></td>
            <td><form:errors path="name"/></td>
        </tr>
        <tr id="clone_reagent_0">
            <td>Reagent:</td>
            <td>
                <form:select id="cbox_reagents_0" path="">
                    <option id="empty_option" value=""></option>
                    <c:forEach items="${recipeForm.allReagentList}" var="reagent">
                        <form:option id="reagent_name" value="${reagent.id}">${reagent.name}</form:option>
                    </c:forEach>
                </form:select>
            </td>
            <td>count: <form:input id="count_0" path=""/></td>
            <td>
                <button id="delete_0" type="button" hidden value="none">Del reagent</button>
            </td>
        </tr>
    </table>
    <div>
        <button id="add_reagent_button" type="button" value="none">Add reagent</button>
    </div>
    <div><input type="submit" value="Submit"/></div>

</form:form>