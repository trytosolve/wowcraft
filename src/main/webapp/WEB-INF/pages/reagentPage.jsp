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
<link href="<c:url value="/resources/css/reagents.css" />" rel="stylesheet">
<html>
<head>
    <title>Reagents</title>
</head>
<body>
<div class="new_reagent">
    <a href="/reagents/add">add_new</a>
</div>
<table class="reagent_table">
    <form:form method="post">
        <tr>
            <td>
                <div>Id</div>
            </td>
            <td>
                <div>Name</div>
            </td>
            <td>
                <div>Item Lvl</div>
            </td>
            <td>
                <div>Max Stack</div>
            </td>
            <td>
                <div>Cell Price</div>
            </td>
            <td>
                <div></div>
            </td>
            <td>
                <div></div>
            </td>
        </tr>

        <c:forEach items="${allReagents}" var="reagent">
            <tr>
                <td>
                    <div>${reagent.id}</div>
                </td>
                <td>
                    <div>${reagent.name}</div>
                </td>
                <td>
                    <div>${reagent.itemLvl}</div>
                </td>
                <td>
                    <div>${reagent.maxStack}</div>
                </td>
                <td>
                    <div>${reagent.cellPrice}</div>
                </td>
                <td><a href="reagents/edit?id=${reagent.id}">edit</a></td>
                <td><a href="reagents/delete?id=${reagent.id}">delete</a></td>
            </tr>
        </c:forEach>

    </form:form>
</table>
</body>
</html>
