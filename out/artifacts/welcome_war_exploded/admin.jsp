<%@ page import="org.group.welcome.vo.Teacher" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Welcome New Students
  </title>

  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.1/css/bulma.min.css">
  <script defer src="https://use.fontawesome.com/releases/v5.1.0/js/all.js"></script>
  <link rel="stylesheet" href="student.css">
  <link rel="stylesheet" href="admin.css">
</head>

<body>

  <nav class="navbar is-transparent  is-fixed-top">
    <div class="navbar-brand">
      <a class="UESTC">
        <img class="logo" src="logo.png" alt="UESTC">
      </a>
    </div>
    <form action="/grantServlet" method="post"><input type="submit" class="UESTCquanxian" style="display: none"></form>


    <div class="navbar-end">
      <div class="navbar-item">
        <div class="field is-grouped">
          <p class="control sign-in">
            <a class="button has-text-grey-light"  href="index.html">
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

  <section class="allTeacherInfo">
    <table id="info">

      <tr>
        <th>编号</th>
        <th>身份证号</th>
        <th>用户ID</th>
        <th>用户姓名</th>
        <th>权限</th>
        <th>操作</th>
      </tr>

      <%

        if ( request.getAttribute("list_admin") != null) {
          List<Teacher> list = (List<Teacher>) request.getAttribute("list_admin");
          for (int i = 0, len = list.size(); i < len; i++) {
      %>
      <tr>
        <td><%=i+1%></td>
        <td><%=list.get(i).getTid()%>
        </td>
        <td><%=list.get(i).getId()%>
        </td>
        <td><%=list.get(i).getTname()%>
        </td>
        <td><%=list.get(i).getAuthority()%>
        </td>

        <td>
          <span class="icon authorityEdit">
            <i class="fas fa-edit"></i>
          </span>
        </td>
      </tr>
      <%
          }
        }
      %>



    </table>

  </section>
  <form action="/grantServlet" method="post" style="display: none">
    <input type="text" class="shouquanneirongA" name="id">
    <input type="text" class="shouquanneirongB" name="choice">
    <input type="submit" class="shouquantijiao">
  </form>
  <div style="position: absolute;top: 41%;left: 40%;display: none;border:1px solid gray;border-radius:5px;margin: 30px;padding: 0 0 20px 30px" class="shouquanchuangkou">
    <span class="icon shouquanClose" style="margin-left: 230px;">
      <i class="fas fa-times"></i>
    </span>
    <br>

    <div>请确认对 <span class="quanxianName"></span> <span style="display: none" class="quanxianQ"></span>进行的权限操作</div>
    <br>
    &emsp;
    <a class="button is-warning querenshouquan">授权</a>&emsp;&emsp;
    <a class="button is-info quxiaoshouquan">取消授权</a>

  </div>
  <form>
    <div class="field has-addons searchInputAdmin">
      <div class="control">
        <input class="input" type="text" placeholder="输入ID查询">
      </div>
      <div class="control">
        <a class="button is-info searchInputSubmit">
          Search
        </a>
        <input type="submit" class="searchSubmitAdmin">
      </div>
    </div>
  </form>
  <script src="admin.js"></script>
</body>

</html>