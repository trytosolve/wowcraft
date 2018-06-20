<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form action="${pageContext.request.contextPath}/lots/add" modelAttribute="lotForm"
           method="post">
    <table>
        <tr>
            <td>Name:</td>
            <td><form:input id="name" path="name"/></td>
            <td><form:errors path="name"/></td>
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