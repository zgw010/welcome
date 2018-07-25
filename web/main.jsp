<%@ page import="java.net.URLEncoder" %><%--
main.jsp
  Created by IntelliJ IDEA.
  User: daozhi
  Date: 2018/7/23
  Time: 9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String str = URLEncoder.encode("4","utf-8");
    Cookie authority = new Cookie("authority", str);
    // 设置cookie过期时间为24小时。
    authority.setMaxAge(60*60*24);
    // 在响应头部添加cookie
    //id.setMaxAge(0);
    response.addCookie(authority);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>设置 Cookie</h1>

<ul>
    <li><p><b>ID:</b>
        <%=str%>
    </p></li>
</ul>
</body>
</html>
