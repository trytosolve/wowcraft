<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.3.1.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/reagentCreation.js"/>"></script>

<form:form id="recipe_form" action="${pageContext.request.contextPath}/recipes/edit?id=${recipeForm.id}" modelAttribute="recipeForm"
           method="post">
    <table id="recipe_property">
        <tr>
            <td>Recipe Name:</td>
            <td><form:input id="name" path="name"/></td>
            <td><form:errors path="name"/></td>
        </tr>
        <tr>
            <td>Recipe Price:</td>
            <td><form:input id="price" path="price"/></td>
            <td><form:errors path="price"/></td>
        </tr>
        <c:forEach items="${recipeForm.reagentCountMap}" var="entry" varStatus="status">
            <tr id="clone_reagent_${status.index}">
                <td>Reagent</td>
                <td>
                    <form:select id="cbox_reagents_${status.index}" path="">
                        <option id="empty_option" value="">         </option>
                        <c:forEach items="${allReagents}" var="reagent">
                            <option id="reagent_name" value="${reagent.id}" ${reagent.id == entry.key ? 'selected' : ''}>
                                    ${reagent.name}</option>
                        </c:forEach>
                    </form:select>
                </td>
                <td>count: <form:input id="count_${status.index}"  path="" value="${entry.value}"/></td>
                <td><button id="delete_${status.index}" type="button" value="none">Del reagent</button></td>
            </tr>
        </c:forEach>

    </table>
    <div><button id="add_reagent_button" type="button" value="none">Add reagent</button></div>
    <div><input type="submit" value="Submit"/></div>

</form:form>