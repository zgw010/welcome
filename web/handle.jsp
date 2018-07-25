<%@ page import="com.jspsmart.upload.SmartUpload" %>
<%@ page import="com.jspsmart.upload.Files" %>
<%@ page import="com.jspsmart.upload.File" %>
<%@ page import="org.group.welcome.Utils" %><%--
  Created by IntelliJ IDEA.
  User: daozhi
  Date: 2018/7/24
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    SmartUpload smartUpload = new SmartUpload();
    smartUpload.initialize(pageContext);
    smartUpload.upload();
    Files files = smartUpload.getFiles();
    File file = files.getFile(0);
    String ext = file.getFileExt();
    String ip = request.getLocalAddr();
    String filename = Utils.getFileName(ip)+"."+ext;
    System.out.println(filename);
    file.saveAs("files"+java.io.File.separator+filename);
%>
<body>
</body>
</html>
