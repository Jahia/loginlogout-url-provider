<%@ page import="org.apache.commons.lang.StringUtils" %>
<%@ page import="org.jahia.params.valves.LogoutConfig" %>
<%@ page import="org.jahia.bin.Logout" %>
<html>
<head>
    <title>Custom Logout Page</title>
</head>
<body>
Service parameter : <%=request.getParameter("service")%> <br/>
Default logout URL : <%=StringUtils.defaultIfEmpty(LogoutConfig.getInstance().getCustomLogoutUrl(request), Logout.getLogoutServletPath()) %> <br/>
<a href='<%=request.getParameter("service")%>'>Click here to logout</a>
</body>
</html>