package org.group.welcome.servlet;

import org.group.welcome.dao.AuthorityDao;
import org.group.welcome.dao.StudentDao;
import org.group.welcome.factory.Factory;
import org.group.welcome.vo.Authority;
import org.group.welcome.vo.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EnterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        String sid = req.getParameter("sid");
        String sname = req.getParameter("sname");
        String class_id = req.getParameter("class_id");
        String password = sid.substring(sid.length() - 6);

        Student student = new Student();
        student.setId(id);
        student.setSid(sid);
        student.setSname(sname);
        student.setClass_id(class_id);
        Authority authority = new Authority();
        authority.setId(id);
        authority.setPassword(password);
        authority.setAuthority(2);

        StudentDao studentDao = Factory.getStudentDao();
        AuthorityDao authorityDao = Factory.getAuthorityDao();

        studentDao.add(student);
        authorityDao.add(authority);
        req.getRequestDispatcher("teacher.jsp").forward(req, resp);

    }
}
