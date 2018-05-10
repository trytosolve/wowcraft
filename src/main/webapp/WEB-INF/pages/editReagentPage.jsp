<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form action="${pageContext.request.contextPath}" modelAttribute="reagentForm" method="post">
    <table>
        <tr>
            <td>Name:</td>
            <td><form:input id="name" path="name"/></td>
            <td><form:errors path="name"/></td>
        </tr>
        <tr>
            <td>Item Lvl:</td>
            <td><form:input id="itemLvl" path="itemLvl"/></td>
            <td><form:errors path="itemLvl"/></td>
        </tr>
        <tr>
            <td>Max Stack:</td>
            <td><form:input id="maxStack" path="maxStack"/></td>
            <td><form:errors path="maxStack"/>
        </tr>
        <tr>
            <td>Cell Price:</td>
            <td><form:input id="cellPrice" path="cellPrice"/></td>
            <td><form:errors path="cellPrice"/></td>
        </tr>
        <tr>
            <td colspan="3"><input type="submit" value="Edit"/></td>
        </tr>
    </table>

</form:form>