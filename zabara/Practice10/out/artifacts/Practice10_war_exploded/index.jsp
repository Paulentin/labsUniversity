<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="i18n.language" />





<html lang="${language}">
<%--<%@ include file="/WEB-INF/head.jspf" %>--%>

  <body>

<a href="/getConnection" >get connnection</a>


<form>
    <select id="language" name="language" onchange="submit()">
        <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
        <option value="ru" ${language == 'ru' ? 'selected' : ''}>Rus</option>
    </select>
</form>


  <h1>Logging in ( Part 4 )</h1>

  <form action="login" method="post">
      <fmt:message key="login.label.email" />
      <input type="text" name="name">
      <fmt:message key="login.label.password" />
      <input type="password" name="pass"><br>
      <fmt:message key="login.button.submit" var="buttonValue" />

      <input type="submit" value="${buttonValue}">
  </form>





  <h1>Part1</h1>
        <table>

          <%--part1--%>

            <%
                for (int i = 1; i <= 9; i++) {
            %><tr><%
            for (int j = 1; j <= 9; j++) {
                int  s = i*j;
            %><td><%= s%></td>
            <%
                }

            %></tr>
            <%
                }

            %>
              <%--part2--%>

        </table>

    <a href="/jstl">Link part2</a>


<h1> part 3</h1>
  <form action="part3" method="post">
      <input type="text" name="name">
      <input type="submit" value="Login">
  </form>

  <table>
      <c:forEach items="${sessionScope.sessions}" var="sess">
          <tr>
              ${sess}
          </tr>

      </c:forEach>

  </table>

  </body>
</html>
