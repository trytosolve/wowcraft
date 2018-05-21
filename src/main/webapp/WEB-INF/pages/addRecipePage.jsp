<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.3.1.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/reagentCreation.js"/>"></script>

<form:form id="add_recipe_form" action="${pageContext.request.contextPath}/recipes/add" modelAttribute="recipeForm"
           method="post">
    <table id="recipe_property">
        <tr>
            <td>Recipe Name:</td>
            <td><form:input id="name" path="name"/></td>
            <td><form:errors path="name"/></td>
        </tr>
        <tr id="clone_reagent">
            <td>Reagent:</td>
            <td>
                <form:select id="cboReagents" path="">
                    <option id="empty_option" value=""></option>
                    <c:forEach items="${recipeForm.allReagentList}" var="reagent">
                        <form:option id="reagentName" value="${reagent.id}">${reagent.name}</form:option>
                    </c:forEach>
                </form:select>
            </td>
            <td>count: <form:input id="count"  path=""/></td>
            <td><button id="delete" type="button" hidden value="none">Del reagent</button></td>
        </tr>
    </table>
    <div><button id="add_for_add_page" type="button" value="none">Add reagent</button></div>
    <div><input type="submit" value="Submit"/></div>

</form:form>