package org.group.welcome.servlet;

import org.group.welcome.dao.StudentDao;
import org.group.welcome.factory.Factory;
import org.group.welcome.vo.Student;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;

import static org.group.welcome.ReadCookie.ReadCookieMap;

public class DormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String sroom = req.getParameter("room");
        System.out.println(sroom);
        String id = null;
        Student student = new Student();
        Map<String, Cookie> cookieMap = ReadCookieMap(req);
        if (cookieMap.containsKey("id")) {
            Cookie cookie = (Cookie) cookieMap.get("id");
            id = cookie.getValue();
            //System.out.println(id);
            StudentDao studentDao = Factory.getStudentDao();
            student =  studentDao.queryById(id);
            if((student.getStat()/100) == 0) {
                student.setSroom(sroom);
                student.setStat(student.getStat()+100);
                studentDao.update(student);
                String str_stat= URLEncoder.encode(""+student.getStat(),"utf-8");
                Cookie cookie_stat = new Cookie("stat", str_stat);
                resp.addCookie(cookie_stat);
 //           System.out.println(student.getSname());
//            System.out.println("信息更改完成！");
                resp.sendRedirect("student.html");
//            req.setAttribute("student",student);
//            req.getRequestDispatcher("xxx.html").forward(req,resp);
            }
            else{
                resp.sendRedirect("student.html");
            }
        }

    }
}
