package org.group.welcome.servlet;


import org.group.welcome.dao.AuthorityDao;
import org.group.welcome.dao.StudentDao;
import org.group.welcome.factory.Factory;
import org.group.welcome.vo.Authority;
import org.group.welcome.vo.Student;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        String password=req.getParameter("password");
        System.out.println(id+"+"+password);
        Authority authority=new Authority();
        AuthorityDao authorityDao= Factory.getAuthorityDao();
        authority=authorityDao.queryCheck(id);

        //密码正确，根据权限跳转不同页面，并向页面发送权限
        if(password.equals(authority.getPassword())){
            //学生
            if(authority.getAuthority()==2){
                System.out.println(authority.getAuthority());
                StudentDao studentDao = Factory.getStudentDao();
                Student student = studentDao.queryById(id);
                String str_id = URLEncoder.encode(student.getId(),"utf-8");
                String str_name= URLEncoder.encode(student.getSname(),"utf-8");
                String str_sid= URLEncoder.encode(student.getSid(),"utf-8");
                String str_stat= URLEncoder.encode(""+student.getStat(),"utf-8");
                String str_class_id = URLEncoder.encode(student.getClass_id(),"utf-8");
//                String str_id = student.getId();
//                String str_name= student.getSname();
//                String str_sid= student.getSid();
//                String str_stat= "0";
//                String str_class_id = student.getClass_id();
                Cookie cookie_id = new Cookie("id", str_id);
                Cookie cookie_name = new Cookie("name", str_name);
                Cookie cookie_sid = new Cookie("sid", str_sid);
                Cookie cookie_stat = new Cookie("stat", str_stat);
                Cookie cookie_class_id = new Cookie("class_id", str_class_id);
                Cookie cookie_authority = new Cookie("authority", "2");

                resp.addCookie(cookie_id);
                resp.addCookie(cookie_name);
                resp.addCookie(cookie_sid);
                resp.addCookie(cookie_stat);
                resp.addCookie(cookie_class_id);
                resp.addCookie(cookie_authority);
                resp.sendRedirect("student.html");
            }
            //老师
            else if(authority.getAuthority()==3){
                System.out.println(authority);
                Cookie cookie_authority = new Cookie("authority", "3");
                Cookie cookie_id = new Cookie("id", id);
                resp.addCookie(cookie_authority);
                resp.addCookie(cookie_id);
                //req.setAttribute("authority",authority.getAuthority());
                req.getRequestDispatcher("teacher.jsp").forward(req,resp);
            }
            //管理员
            else{
                System.out.println(authority);
                Cookie cookie_authority = new Cookie("authority", "4");
                Cookie cookie_id = new Cookie("id", id);
                resp.addCookie(cookie_authority);
                resp.addCookie(cookie_authority);
                req.getRequestDispatcher("admin.jsp").forward(req,resp);
            }

        }
        //用户名或密码错误，提示错误信息
        else{
            System.out.println("error");
        }
    }
}
