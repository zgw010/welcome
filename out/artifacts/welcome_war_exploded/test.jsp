<%@ page import="org.group.welcome.vo.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.group.welcome.vo.Admin" %><%--
  Created by IntelliJ IDEA.
  User: daozhi
  Date: 2018/7/22
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="adminAuthority.jsp"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Title</title>
</head>
<body>
<form action="handle.jsp" method="post" enctype="multipart/form-data">
    选择附件:<input type="file" name="file"><br>
    <input type="submit" value="上传">
</form>
</body>
</html>
