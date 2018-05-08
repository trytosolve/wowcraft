<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form action="${pageContext.request.contextPath}/add_new_reagent" modelAttribute="reagentForm" method="post">
    <table class="clearfix" align="center">
        <tr>
            <span class="error"><form:errors path="name"/></span>
            <span class="error"><form:errors path="itemLvl"/></span>
            <span class="error"><form:errors path="maxStack"/></span>
            <span class="error"><form:errors path="cellPrice"/></span>
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