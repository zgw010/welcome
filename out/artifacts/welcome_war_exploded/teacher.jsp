<%@ page import="org.group.welcome.vo.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="org.group.welcome.vo.Page" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" style="background-color: #eee">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Welcome New Students
    </title>


    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.1/css/bulma.min.css">
    <script defer src="https://use.fontawesome.com/releases/v5.1.0/js/all.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js"></script>
    <script src="https://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.6.0/underscore.js"></script>
    <link rel="stylesheet" href="student.css">
    <link rel="stylesheet" href="teacher.css">

</head>

<body style="display: block;background-color: #eee">
<nav class="navbar is-transparent  is-fixed-top" style="z-index: 10000">
    <a href="index.html">
        <img class="logo" src="logo.png" alt="UESTC">
    </a>


    <div id="navbarExampleTransparentExample" class="navbar-menu student-menu">
        <div class="navbar-start">
            <a class="navbar-item informationInputMenu">
                信息录入
            </a>
            <a class="navbar-item informationExamineMenu">
                信息审核
            </a>
            <a class="navbar-item informationQueryMenu">
                查询界面
            </a>
        </div>
    </div>

    <div class="navbar-end">
        <div class="navbar-item">
            <div class="field is-grouped">
                <p class="control sign-in">
                    <a class="button has-text-grey-light" href="index.html">
              <span class="icon">
                <i class="fas fa-sign-in-alt"></i>
              </span>
                        <span>注销</span>
                    </a>
                </p>
            </div>
        </div>
    </div>

</nav>


<section class="informationInput" style="display: none;top: 202px;">
    <span class="close icon informationInputClose">
      <i class="fas fa-times"></i>
    </span>
    <div class="container">
        <div id="table" class="table-editable">
            <span class="table-add glyphicon glyphicon-plus"></span>

            <table class="table tableAdd">
                <tr>
                    <th>姓名</th>
                    <th>学号</th>
                    <th>身份证号</th>
                    <th>班级</th>
                    <th></th>
                </tr>

                <!-- This is our clonable table line -->
                <tr class="hide">
                    <td contenteditable="true"></td>
                    <td contenteditable="true"></td>
                    <td contenteditable="true"></td>
                    <td contenteditable="true"></td>
                    <td>
                        <span class="table-remove glyphicon glyphicon-remove"></span>
                    </td>
                </tr>
            </table>
            <form action="/enterServlet" method="post" style="display: none;" class="newStudentInfoForm">
                <input type="text" name="sname">
                <input type="text" name="sid">
                <input type="text" name="id">
                <input type="text" name="class_id">
                <input type="submit" class="newStudentInfoSubmitRButton">
            </form>
            <p class="control">
                <a class="button is-info newStudentInfoSubmitButton" style="float: right;margin-left: 20px">
                    点击提交
                </a>
            </p>
            <p class="control">
                <a class="button is-info newStudentButton" style="float: right;">
                    新建信息
                </a>
            </p>
        </div>
    </div>


</section>
<section class="informationExamine" style="display: block">
    <span class="close icon informationExamineClose">
      <i class="fas fa-times"></i>
    </span>
    <div class="container">
        <div id="table2" class="table-editable">
            <table class="table">
                <tr>
                    <th>姓名</th>
                    <th>学号</th>
                    <th>身份证号</th>
                    <th>班级</th>
                    <th></th>
                    <th></th>
                </tr>

                <%
                    Page page1=new Page();
                    if(request.getAttribute("page")!=null){
                        page1=(Page) request.getAttribute("page");
                    }
                    if ((List<Student>) request.getAttribute("list_student") != null) {
                        List<Student> studentList = (List<Student>) request.getAttribute("list_student");
                        for (int i = 0, len = studentList.size(); i < len; i++) {
                            if (studentList.get(i).getStat() % 10 == 1) {
                %>
                <tr>
                    <td><%=studentList.get(i).getSname()%>
                    </td>
                    <td><%=studentList.get(i).getId()%>
                    </td>
                    <td><%=studentList.get(i).getSid()%>
                    </td>
                    <td><%=studentList.get(i).getClass_id()%>
                    </td>
                    <td>
                        <form action="/checkServlet" method="post" style="display: none">
                            <input type="text" value="<%=studentList.get(i).getId()%>" name="pass">
                            <input type="submit" class="rExamineOk">
                        </form>
                        <span class="table-ok glyphicon glyphicon-ok examineOk"></span>
                    </td>
                    <td>
                        <span class="table-remove glyphicon glyphicon-remove"></span>
                    </td>
                </tr>
                <%
                            }
                        }
                    }
                %>

            </table>
            <form action="/checkServlet" method="post" style="display: none;">
                <input type="submit" class="informationExamineListSubmit">
            </form>
            <form action="/checkServlet" method="post">
                <input type="text" class="rLast" name="pagenow" value="<%=page1.getPageNow()-1%>">
                <input type="submit" class="rLast rLastSubmit">
            </form>

            <form action="/checkServlet" method="post">
                <input type="text" class="rNext" name="pagenow" value="<%=page1.getPageNow()+1%>">
                <input type="submit" class="rNext rNextSubmit">

            </form>
            <form action="/checkServlet" method="post">
                <div style="margin-top: 40px;margin-left: 500px">
    <% if(page1.getPageNow()!=1){
        %>
        <span class="icon last">
        <i class="fas fa-arrow-left"></i>
      </span>
    <%}%>
                    &emsp;
                    <span>
        <input type="text" class="input is-small" style="width: 40px;text-align: center;font-weight: 800;font-size: 14px;margin-top: -2px;" value="<%=page1.getPageNow()%>">&emsp;/<%=page1.getPageSum()%>&emsp;
        <a class="button is-small is-info go" style="font-weight: 800;">Go</a>
                        <input type="submit" class="rGosubmit rGo">
      </span>&emsp;

                    <% if(page1.getPageNow()!=page1.getPageSum()){
                    %>
                    <span class="icon next">
        <i class="fas fa-arrow-right"></i>
      </span>
                    <%}%>

                </div>
            </form>

            <p class="control">
                <a class="button is-info" style="float: right">
                    全部通过
                </a>
            </p>
        </div>
    </div>
</section>
<section class="informationQuery">
    <span class="close icon informationQueryClose">
      <i class="fas fa-times"></i>
    </span>
    注册成功
</section>

<script src="teacher.js"></script>


</body>

</html>