<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.3.1.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/reagentCreation.js"/>"></script>

<form:form id="edit_recipe_form" action="${pageContext.request.contextPath}/recipes/edit?id=${recipeForm.id}" modelAttribute="recipeForm"
           method="post">
    <table id="recipe_property">
        <tr>
            <td>Recipe Name:</td>
            <td><form:input id="name" path="name"/></td>
            <td><form:errors path="name"/></td>
        </tr>
        <c:forEach items="${recipeForm.reagentCountMap}" var="entry" varStatus="status">
            <tr id="clone_reagent${status.index}">
                <td>Reagent</td>
                <td>
                    <form:select id="cboReagents${status.index}" path="">
                        <option id="empty_option" value="">         </option>
                        <c:forEach items="${recipeForm.allReagentList}" var="reagent">
                            <option id="reagentName" value="${reagent.id}" ${reagent.id == entry.key ? 'selected' : ''}>
                                ${reagent.name}</option>
                        </c:forEach>
                    </form:select>
                </td>
                <td>count: <form:input id="count${status.index}"  path="" value="${entry.value}"/></td>
                <td><button id="delete${status.index}" type="button" value="none">Del reagent</button></td>
            </tr>
        </c:forEach>

    </table>
    <div><button id="add_for_edit_page" type="button" value="none">Add reagent</button></div>
    <div><input type="submit" value="Submit"/></div>

</form:form>