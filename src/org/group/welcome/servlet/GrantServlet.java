package org.group.welcome.servlet;

import org.group.welcome.dao.AdminDao;
import org.group.welcome.dao.AuthorityDao;
import org.group.welcome.factory.Factory;
import org.group.welcome.vo.Admin;
import org.group.welcome.vo.Authority;
import org.group.welcome.vo.Teacher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GrantServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AuthorityDao authorityDao= Factory.getAuthorityDao();
        AdminDao adminDao=Factory.getAdminDao();

        if(req.getParameter("choice")!=null){
            System.out.println("选择"+req.getParameter("choice"));
            System.out.println("ID"+req.getParameter("id"));
            int choice=Integer.parseInt(req.getParameter("choice"));

            if(choice==1){
                String id=req.getParameter("id");
                System.out.println(id);
                //添加管理员
                authorityDao.update(id,4);

                Admin admin=new Admin();
                admin.setId(id);
                admin.setName(adminDao.getAdminName(id));

                adminDao.add(admin);
            }else if(choice==0){
                String id=req.getParameter("id");
                //删除管理员
                System.out.println();
                authorityDao.update(id,3);
                adminDao.deleteById(id);
            }

       }
        List<Teacher> list=adminDao.findAll();
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).getTname());
        }
        req.setAttribute("list_admin",list);
        req.getRequestDispatcher("admin.jsp").forward(req,resp);
    }
}
