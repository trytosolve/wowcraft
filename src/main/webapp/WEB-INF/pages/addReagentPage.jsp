<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form action="${pageContext.request.contextPath}/reagents/add" modelAttribute="reagentForm"
           method="post">
    <table>
        <tr>
            <td>Name:</td>
            <td><form:input id="name" path="name"/></td>
            <td><form:errors path="name"/></td>
        </tr>
        <tr>
            <td>Item Lvl:</td>
            <td><form:input id="item_lvl" path="itemLvl"/></td>
            <td><form:errors path="itemLvl"/></td>
        </tr>
        <tr>
            <td>Max Stack:</td>
            <td><form:input id="max_stack" path="maxStack"/></td>
            <td><form:errors path="maxStack"/>
        </tr>
        <tr>
            <td>Sell Price:</td>
            <td><form:input id="sell_price" path="sellPrice"/></td>
            <td><form:errors path="sellPrice"/></td>
        </tr>
        <tr>
            <td colspan="3"><input type="submit" value="Submit"/></td>
        </tr>
    </table>

</form:form>