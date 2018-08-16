<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form action="${pageContext.request.contextPath}/lots/add" modelAttribute="lotForm"
           method="post">
    <table>
        <tr>
            <td>Item Id:</td>
            <td><form:input id="itemId" path="itemId"/></td>
            <td><form:errors path="itemId"/></td>
        </tr>
        <tr>
            <td>Count:</td>
            <td><form:input id="count" path="count"/></td>
            <td><form:errors path="count"/></td>
        </tr>
        <tr>
            <td>Lot Price:</td>
            <td><form:input id="sell_price" path="price"/></td>
            <td><form:errors path="price"/></td>
        </tr>
        <tr>
            <td colspan="3"><input type="submit" value="Submit"/></td>
        </tr>
    </table>

</form:form>