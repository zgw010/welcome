package org.group.welcome.servlet;

import org.group.welcome.dao.StudentDao;
import org.group.welcome.factory.Factory;
import org.group.welcome.vo.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdmitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sid = req.getParameter("sid");
        StudentDao studentDao = Factory.getStudentDao();
        Student student = studentDao.findBySid(sid);
        if(student != null){
            //System.out.println("你已被录取！");
            req.setAttribute("student",student);
            req.getRequestDispatcher("xxx.html").forward(req,resp);
        }
        else
        {
            //System.out.println("你未被录取！");
            resp.sendRedirect("xxx.html");
        }
    }
}
