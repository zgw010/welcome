<%@ page import="java.util.Map" %>
<%@ page import="static org.group.welcome.ReadCookie.ReadCookieMap" %><%--
  Created by IntelliJ IDEA.
  User: daozhi
  Date: 2018/7/24
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Map<String, Cookie> cookieMap = ReadCookieMap(request);
    String authority=null;
    if (cookieMap.containsKey("authority")) {
        Cookie cookie = (Cookie) cookieMap.get("authority");
        authority = cookie.getValue();
        //System.out.println(authority);
        int flag = Integer.parseInt(authority);
        if(!(flag>=3)){
            response.sendRedirect("login.html");
        }
    }
    else {
        response.sendRedirect("login.html");
    }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
