<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form action="${pageContext.request.contextPath}/add_new_reagent" modelAttribute="reagentForm" method="post">
    <table>
        <tr>
            <td><form:errors path="name"/></td>
            <td><form:errors path="itemLvl"/></td>
            <td><form:errors path="maxStack"/></td>
            <td><form:errors path="cellPrice"/></td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><form:input id="name" path="name"/></td>
        </tr>
        <tr>
            <td>Item Lvl:</td>
            <td><form:input id="itemLvl" path="itemLvl"/></td>
        </tr>
        <tr>
            <td>Max Stack:</td>
            <td><form:input id="maxStack" path="maxStack"/></td>
        </tr>
        <tr>
            <td>Cell Price:</td>
            <td><form:input id="cellPrice" path="cellPrice"/></td>
        </tr>
        <tr>
            <td colspan="3"><input type="submit" value="Submit"/></td>
        </tr>
    </table>

</form:form>