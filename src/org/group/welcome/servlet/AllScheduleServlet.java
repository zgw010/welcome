package org.group.welcome.servlet;

import com.mysql.fabric.FabricCommunicationException;
import org.group.welcome.dao.StudentDao;
import org.group.welcome.factory.Factory;
import org.group.welcome.vo.Student;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.group.welcome.ReadCookie.ReadCookieMap;

public class AllScheduleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Cookie> cookieMap = ReadCookieMap(req);
        String id=null;
        if (cookieMap.containsKey("id")) {
            Cookie cookie = (Cookie) cookieMap.get("id");
            id = cookie.getValue();
        }
        StudentDao studentDao= Factory.getStudentDao();
        List<Student> list=studentDao.queryJoinByCollege(id);
        int sum=list.size();
        int count=0;
        for(int i=0;i<sum;i++){
            if(list.get(i).getStat()%10==2){
                count++;
            }
        }
        req.setAttribute("sum",sum);
        req.setAttribute("count",count);
        req.getRequestDispatcher("test.jsp").forward(req,resp);
    }
}
