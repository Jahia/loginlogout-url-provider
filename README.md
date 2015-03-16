# loginlogout-url-provider

A module that provides an example implementation of a login/logout URL provider

## Installation

To test, simply build and deploy the example module. By default the module will redirect to the following URLs : 

http://localhost:8080/modules/login-logout-url-provider/jsps/login.jsp
http://localhost:8080/modules/login-logout-url-provider/jsps/logout.jsp

These are configured in the following file : 
https://github.com/Jahia/loginlogout-url-provider/blob/master/src/main/resources/META-INF/spring/login-logout-url-provider.xml
and should be changed if you use a different context path, hostname or port.

## Usage

When login using the http://localhost:8080/administration you should be redirected to the login JSP 
(which should also work), and when logging out you should be redirected to the logout.jsp that will log you out 
but it will not redirect you to another page (simply change the URL in the browser to check it has logged you out). 

