<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <form:form action="map_test" modelAttribute="testMap">
        <c:forEach items="${testMap.map}" var="map" varStatus="status">
            <tr>
                <td>${map.key}</td>
                <td><input name="testMap['${map.key}']" value="${map.value}"/></td>
            </tr>
        </c:forEach>
        <input type="submit"/>
    </form:form>
</html>
