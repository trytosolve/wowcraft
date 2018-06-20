<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form action="${pageContext.request.contextPath}" modelAttribute="reagentForm" method="post">
    <table>
        <tr>
            <td>Name:</td>
            <td><form:input id="name" path="name"/></td>
            <td><form:errors path="name"/></td>
        </tr>
        <tr>
            <td>Sell Price:</td>
            <td><form:input id="sell_price" path="sellPrice"/></td>
            <td><form:errors path="sellPrice"/></td>
        </tr>
        <tr>
            <td colspan="3"><input type="submit" value="Edit"/></td>
        </tr>
    </table>

</form:form>