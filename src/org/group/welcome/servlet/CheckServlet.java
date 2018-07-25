package org.group.welcome.servlet;

import org.group.welcome.dao.StudentDao;
import org.group.welcome.factory.Factory;
import org.group.welcome.vo.Page;
import org.group.welcome.vo.Student;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.group.welcome.ReadCookie.ReadCookieMap;

public class CheckServlet extends HttpServlet {
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
        System.out.println("tid"+ id);
        if(req.getParameter("pass")!=null){
            String sid=req.getParameter("pass");

            Student student=studentDao.queryById(sid);
            student.setStat(student.getStat()+1);
            studentDao.update(student);
        }
        List<Student> list=studentDao.queryJoinByCollege(id);//id由cookie读入

        List<Student> listtemp=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            if(list.get(i).getStat()%10==1){
                Student student=new Student();
                student=list.get(i);
                listtemp.add(student);
            }
        }

//更改审查通过的学生的状态

//将审查通过的学生从List中移除
       /* for(int i=0;i<list.size();i++){
            if(list.get(i).getStat()%10==2){
                list.remove(i);
                i--;
            }
        }
*/
        //分页
        Page page=new Page();
        String pageNow=req.getParameter("pagenow");
        if(null==pageNow){
            page.setPageNow(1);
        }
        else{
            page.setPageNow(Integer.parseInt(pageNow));
        }

        page.setInfoNumber(listtemp.size());
        System.out.println("zongyeshu"+page.getPageSum());
//设置起始
        int pageStart=(page.getPageNow()-1)*2;
        int pageEnd;
        if(page.getPageNow()==page.getPageSum()){
            pageEnd=page.getInfoNumber();
        }else{
            pageEnd = page.getPageNow()*2;
        }
        //取出需要的10条数据放入req_list中
        List<Student> req_list =new ArrayList<>();
        System.out.println("fenye"+pageStart+pageEnd);
        for(int i=pageStart;i<pageEnd;i++){
            Student student=new Student();
            student=listtemp.get(i);
            req_list.add(student);
        }

            for(int i=0;i<req_list.size();i++){
            System.out.println(req_list.get(i).getSname());
            }
            req.setAttribute("page",page);
            req.setAttribute("list_student",req_list);
            req.getRequestDispatcher("teacher.jsp").forward(req,resp);


    }
}
