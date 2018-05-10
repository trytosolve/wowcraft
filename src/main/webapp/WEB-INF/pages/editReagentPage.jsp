<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form action="${pageContext.request.contextPath}" modelAttribute="reagentForm" method="post">
    <table>
        <tr><form:errors path="name"/></tr>
        <tr><form:errors path="itemLvl"/></tr>
        <tr><form:errors path="maxStack"/></tr>
        <tr><form:errors path="cellPrice"/></tr>
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
            <td colspan="3"><input type="submit" value="Edit"/></td>
        </tr>
    </table>

</form:form>