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
import java.util.HashMap;
import java.util.Map;

import static org.group.welcome.ReadCookie.ReadCookieMap;

public class ScheduleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = null;
        Map<String, Cookie> cookieMap = ReadCookieMap(req);
        if (cookieMap.containsKey("id")) {
            Cookie cookie = (Cookie) cookieMap.get("id");
            id = cookie.getValue();
            //System.out.println(id);
            Student student = new Student();
            StudentDao studentDao = Factory.getStudentDao();
            student =  studentDao.queryById(id);
            //System.out.println(student.getSname());
            //System.out.println(student.getStat());
            req.setAttribute("stat",student.getStat());
            req.getRequestDispatcher("xxx.html").forward(req,resp);
        }
        else{
            //System.out.println("查询失败！");
            Student student = null;
            req.setAttribute("stat",student.getStat());
            req.getRequestDispatcher("xxx.html").forward(req,resp);
        }
    }

}
