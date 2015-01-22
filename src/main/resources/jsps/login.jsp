<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="ui" uri="http://www.jahia.org/tags/uiComponentsLib" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="template" uri="http://www.jahia.org/tags/templateLib" %>
<%@ taglib prefix="jcr" uri="http://www.jahia.org/tags/jcr" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
    <head>
        <title>Custom Login Page</title>

    </head>
<body>

<form method="post" name="loginForm" action="/cms/login">
    <c:choose>
        <c:when test="${not empty param.redirectTo}">
            <c:set var="redirectTo" value="${param.redirectTo}"/>
        </c:when>
        <c:otherwise>
            <c:set var="redirectTo" value="${param.service}"/>
        </c:otherwise>
    </c:choose>
    <input type="hidden" name="redirect" value="${fn:escapeXml(redirectTo)}"/>
    <p>
        <label class="left" for="username">User</label>
        <input class="full" type="text" value="" tabindex="1" maxlength="250" name="username" id="username"/>
    </p>

    <p>
        <label class="left" for="password">Password</label>
        <input class="full" type="password" tabindex="2" maxlength="250" name="password" id="password" autocomplete="off"/>
    </p>

    <p>
        <input type="checkbox" id="rememberme" name="useCookie"/>
        <label for="rememberme" class="rememberLabel">Remember me</label>

    </p>

    <div class="divButton">
        <input type="submit" name="loginButton" class="button" value="Login"/>
    </div>
</form>

</body>
</html>