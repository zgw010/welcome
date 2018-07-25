package org.group.welcome;

import com.mysql.jdbc.jdbc2.optional.SuspendableXAConnection;
import org.group.welcome.dao.AuthorityDao;
import org.group.welcome.dao.StudentDao;
import org.group.welcome.factory.Factory;
import org.group.welcome.vo.Authority;
import org.group.welcome.vo.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String args[]) throws SQLException {
        /*Student student = new Student();
        student.setId("1001");
        student.setSid("18941651321");
        student.setSname("张三");
        student.setStel("15548523256");
        student.setSaddress("电子科大");
        student.setSroom("1520");
        student.setClass_id("1007");
        student.setStat(0);
        StudentDao studentDao = Factory.getStudentDao();
        studentDao.add(student);*/
       /* Student student = new Student();
        StudentDao studentDao = Factory.getStudentDao();
        student = studentDao.queryById("1001");
        System.out.println(student.getSname());*/
        /*List<Student> student = new ArrayList<Student>();
        StudentDao studentDao = Factory.getStudentDao();
        student = studentDao.queryByName("张三");
        System.out.println(student.get(0).getSname());*/
        /*StudentDao studentDao = Factory.getStudentDao();
        ResultSet rs = studentDao.queryJoinByCollege("001");
        if(rs.next()){
            System.out.println(rs.getString("sname"));
        }*/
        /*StudentDao studentDao = Factory.getStudentDao();
        ResultSet rs = studentDao.queryJoinById("1001");
        if(rs.next()){
            System.out.println(rs.getString("sname"));
        }*/
        /*Student student = new Student();
        student.setId("1001");
        student.setSid("641261425");
        student.setSname("李四");
        student.setStel("1262506");
        student.setSaddress("电子科基大");
        student.setSroom("597");
        student.setClass_id("124267");
        student.setStat(0);
        StudentDao studentDao = Factory.getStudentDao();
        studentDao.update(student);*/
        /*StudentDao studentDao = Factory.getStudentDao();
        studentDao.deleteById("1001");*/
        /*StudentDao studentDao = Factory.getStudentDao();
        List<Student> student = studentDao.findAll();
        System.out.println(student.get(0).getSname());
        System.out.println(studentDao.findBySid("123456789"));*/
        /*StudentDao studentDao = Factory.getStudentDao();
        studentDao.findAll();*/
        /*for(int i=0;i<30;i++) {
            Student student = new Student();
            student.setId("010101"+i);
            student.setSid("189416513211551");
            student.setSname("王"+i);
            student.setClass_id("010101");
            student.setStat(0);
            StudentDao studentDao = Factory.getStudentDao();
            studentDao.add(student);
            Authority authority = new Authority();
            authority.setId(student.getId());
            authority.setAuthority(2);
            authority.setPassword(student.getId().substring(student.getId().length()-6));
            AuthorityDao authorityDao = Factory.getAuthorityDao();
            authorityDao.add(authority);
        }*/


    }
}
