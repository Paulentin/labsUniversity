
<%@ page  pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: dobro
  Date: 9/9/17
  Time: 4:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<%--<%@ include file="head.jspf" %>--%>

<body>
<table>

    <c:if test="${array!=null}">
        <tr>

        <c:forEach var="el" items="${array}">
            <c:forEach var="el2" items="${array}">

                <td>
                        ${el*el2}

                </td>

            </c:forEach>
            </tr>

        </c:forEach>
    </c:if>



</table>


</body>
</html>
