package org.group.welcome.dao.impl;

import org.group.welcome.dao.ConnectionDatabase;
import org.group.welcome.dao.StudentDao;
import org.group.welcome.vo.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    @Override
    public List<Student> findAll() {
        List<Student> list =new ArrayList<Student>();
        String sql = "SELECT * FROM tb_student";
        ConnectionDatabase cdb = new ConnectionDatabase();
        Connection conn = cdb.getConnnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            //查询成功后展开数据集
            while(rs.next()){
                Student student = new Student();
                student.setId(rs.getString("id"));
                student.setSid(rs.getString("sid"));
                student.setSname(rs.getString("sname"));
                student.setStel(rs.getString("stel"));
                student.setSaddress(rs.getString("saddress"));
                student.setSaddress(rs.getString("sroom"));
                student.setClass_id(rs.getString("class_id"));
                student.setStat(rs.getInt("stat"));
                list.add(student);
                /*//输出数据集，测试用
                System.out.println(student.getId());
                System.out.println();
                System.out.println(student.getSid());
                System.out.println(student.getSname());
                System.out.println(student.getStel());
                System.out.println(student.getSaddress());
                System.out.println(student.getSaddress());
                System.out.println(student.getClass_id());
                System.out.println(student.getStat());*/
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public Student findBySid(String sid) {
        Student student = new Student();
        String sql = "SELECT * FROM tb_student  WHERE sid = ?";
        ConnectionDatabase cdb = new ConnectionDatabase();
        Connection conn = cdb.getConnnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,sid);
            ResultSet rs = ps.executeQuery();
            //查询成功后展开数据集
            if(rs.next()){
                student.setId(rs.getString("id"));
                student.setSid(rs.getString("sid"));
                student.setSname(rs.getString("sname"));
                /*//输出数据集，测试用
                System.out.println(authority);*/
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    public Student queryById(String id){
        Student student = null;
        String sql = "SELECT * FROM tb_student WHERE id = ?";
        ConnectionDatabase cdb = new ConnectionDatabase();
        Connection conn = cdb.getConnnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,id);
            ResultSet rs = ps.executeQuery();
            //查询成功后展开数据集
            if(rs.next()){
                student = new Student();
                student.setId(rs.getString("id"));
                student.setSid(rs.getString("sid"));
                student.setSname(rs.getString("sname"));
                student.setStel(rs.getString("stel"));
                student.setSaddress(rs.getString("saddress"));
                student.setSaddress(rs.getString("sroom"));
                student.setClass_id(rs.getString("class_id"));
                student.setStat(rs.getInt("stat"));
                /*//输出数据集，测试用
                System.out.println(student.getId());
                System.out.println();
                System.out.println(student.getSid());
                System.out.println(student.getSname());
                System.out.println(student.getStel());
                System.out.println(student.getSaddress());
                System.out.println(student.getSaddress());
                System.out.println(student.getClass_id());
                System.out.println(student.getStat());*/
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }



    public List<Student> queryByName(String name){
        List<Student> list = null;
        String sql = "SELECT * FROM tb_student WHERE sname = ?";
        ConnectionDatabase cdb = new ConnectionDatabase();
        Connection conn = cdb.getConnnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            ResultSet rs = ps.executeQuery();
            //查询成功后展开数据集
            if(rs.next()){
                list = new ArrayList<Student>();
                Student student = new Student();
                student.setId(rs.getString("id"));
                student.setSid(rs.getString("sid"));
                student.setSname(rs.getString("sname"));
                student.setStel(rs.getString("stel"));
                student.setSaddress(rs.getString("saddress"));
                student.setSaddress(rs.getString("sroom"));
                student.setClass_id(rs.getString("class_id"));
                student.setStat(rs.getInt("stat"));
                list.add(student);
                /*//输出数据集，测试用
                System.out.println(student.getId());
                System.out.println();
                System.out.println(student.getSid());
                System.out.println(student.getSname());
                System.out.println(student.getStel());
                System.out.println(student.getSaddress());
                System.out.println(student.getSaddress());
                System.out.println(student.getClass_id());
                System.out.println(student.getStat());*/
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Student> queryJoinByCollege(String id){
        String sql1="SELECT cid FROM tb_teacher WHERE id=?";
        Connection connection=new ConnectionDatabase().getConnnection();
        PreparedStatement st=null;
        String cid=null;
        ResultSet rs1=null;
        try {
            st = connection.prepareStatement(sql1);
            st.setString(1,id);
            rs1=st.executeQuery();
            if(rs1.next()){
                cid=rs1.getString("cid");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sql = "SELECT * " +
                "FROM tb_student s,tb_class z,tb_college c,tb_major m " +
                "WHERE s.class_id = z.class_id AND z.mid = m.mid AND m.cid = c.cid AND c.cid = ?";
        ConnectionDatabase cdb = new ConnectionDatabase();
        Connection conn = cdb.getConnnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Student> list=new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,cid);
            rs = ps.executeQuery();
            while(rs.next()){
                Student student=new Student();
                student.setId(rs.getString("id"));
                student.setSid(rs.getString("sid"));
                student.setSname(rs.getString("sname"));
                student.setStel(rs.getString("stel"));
                student.setSaddress(rs.getString("saddress"));
                student.setSaddress(rs.getString("sroom"));
                student.setClass_id(rs.getString("class_id"));
                student.setStat(rs.getInt("stat"));
                list.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ResultSet queryJoinById(String id){
        String sql = "SELECT * " +
                "FROM tb_student s,tb_class z,tb_major m,tb_college c " +
                "WHERE s.class_id = z.class_id AND z.mid = m.mid AND m.cid = c.cid AND id = ?";
        ConnectionDatabase cdb = new ConnectionDatabase();
        Connection conn = cdb.getConnnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,id);
            rs = ps.executeQuery();
            /*while(rs.next()){
                //输出数据集，测试用
                System.out.println(rs.getString("id"));
                System.out.println(rs.getString("sid"));
                System.out.println(rs.getString("sname"));
                System.out.println(rs.getString("stel"));
                System.out.println(rs.getString("saddress"));
                System.out.println(rs.getString("sroom"));
                System.out.println(rs.getString("class_id"));
                System.out.println(rs.getString("stat"));
            }*/
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public boolean add(Student student){
        boolean flag = false;
        Connection conn =new ConnectionDatabase().getConnnection();
        String sql = "INSERT INTO tb_student (id,sid,sname,stel,saddress,sroom,class_id,stat) "+
                "VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(sql);
            st.setString(1,student.getId());
            st.setString(2,student.getSid());
            st.setString(3,student.getSname());
            st.setString(4,student.getStel());
            st.setString(5,student.getSaddress());
            st.setString(6,student.getSroom());
            st.setString(7,student.getClass_id());
            st.setInt(8,student.getStat());
            if(st.executeUpdate()==1){
                //System.out.println("插入成功！");
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (st!=null)
                    st.close();
                if(conn!=null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    public boolean deleteById(String id){
        boolean flag = false;
        Connection conn =new ConnectionDatabase().getConnnection();
        String sql = "Delete From tb_student Where id = ?";
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(sql);
            st.setString(1,id);
            if(st.executeUpdate()==1){
                System.out.println("删除成功！");
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (st!=null)
                    st.close();
                if(conn!=null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    public boolean update(Student student){
        boolean flag = false;
        Connection conn =new ConnectionDatabase().getConnnection();
        String sql = "Update tb_student " +
                "Set id = ?,sid = ?,sname = ?,stel = ?,saddress = ?,sroom = ?,class_id = ?,stat =? " +
                "Where id = ?";
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(sql);
            st.setString(1,student.getId());
            st.setString(2,student.getSid());
            st.setString(3,student.getSname());
            st.setString(4,student.getStel());
            st.setString(5,student.getSaddress());
            st.setString(6,student.getSroom());
            st.setString(7,student.getClass_id());
            st.setInt(8,student.getStat());
            st.setString(9,student.getId());
            if(st.executeUpdate()!=0){
                //System.out.println("修改成功！");
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (st!=null)
                    st.close();
                if(conn!=null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }
}
