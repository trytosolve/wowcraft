<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.3.1.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/reagentCreation.js"/>"></script>

<form:form action="${pageContext.request.contextPath}/recipes/add" modelAttribute="recipeForm"
           method="post">
    <table class="recipe_property">
        <tr>
            <td>Name:</td>
            <td><form:input id="name" path="name"/></td>
            <td><form:errors path="name"/></td>
        </tr>
        <tr class="clone_reagent">
            <td>Recipe:</td>
            <td>
                <form:select id="cboReagent" path="">
                    <c:forEach items="${recipeForm.reagentList}" var="reagent">
                        <form:option class="reagentName" value="none">${reagent.name}</form:option>
                    </c:forEach>
                </form:select>
            </td>
            <td>count: <form:input class="count"  path="reagentCountMap"/></td>
        </tr>
    </table>
    <div><button class="add" type="button" value="none">Add reagent</button></div>
    <div><button class="del" type="button" value="none">Del reagent</button></div>
    <div><button class="test" type="button" value="none">test</button></div>
    <div><input type="submit" value="Submit"/></div>

</form:form>