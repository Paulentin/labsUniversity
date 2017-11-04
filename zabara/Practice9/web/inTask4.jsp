<%@ page import="voter.MyListener" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: dobro
  Date: 9/2/17
  Time: 6:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>



<html>
<head>
    <title>Vote</title>
</head>
<body>
<form action="vote" method="get">
    <table>

        <tr>
          <td>
              <input name="name" type="text">
          </td>
        </tr>

        <tr>
            <td>
                <c:set var="foot" value="Football" />
                <input type="radio" name="activities" value="${foot}" id="${foot}"><label for="${foot}">Football</label><br>
            </td>
            <td>
               <c:if test="${sessionScope.vote ne null}">
                   <c:forEach items="${sessionScope.foot}" var="name" varStatus="status">
                       ${name}
                   </c:forEach>
               </c:if>

            </td>
        </tr>
        <tr>
            <td>
                <c:set var="biat" value="Biathlon" />

                <input type="radio" name="activities" value="Biathlon" id="biat"><label for="biat">Biathlon    </label><br>
            </td>
            <td>
                <c:if test="${sessionScope.vote ne null}">
                    <c:forEach items="${sessionScope.bia}" var="name" varStatus="status">
                        ${name}
                    </c:forEach>
                </c:if>
            </td>
        </tr>
        <tr>
            <td>
                <c:set var="bask" value="Basketball" />

                <input type="radio" name="activities" value="Basketball" id="basket"><label for="basket">Basketball    </label><br>
            </td>
            <td>
                <c:if test="${sessionScope.vote ne null}">
                    <c:forEach items="${sessionScope.basket}" var="name" varStatus="status">
                        ${name}
                    </c:forEach>
                </c:if>
            </td>
        </tr>
        <tr>
           <td>

               <input type="submit" value="vote">

           </td>
        </tr>
    </table>

</form>

</body>
</html>
