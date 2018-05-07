<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: IRedko
  Date: 04.05.2018
  Time: 8:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Reagents</title>
  </head>
  <body>
  <form:form method="post">
    <c:forEach items="${allReagents}" var="reagent">
        <div>${reagent.name}</div>
    </c:forEach>
  </form:form>
  </body>
</html>
