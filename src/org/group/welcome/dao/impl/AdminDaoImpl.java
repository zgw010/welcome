package org.group.welcome.dao.impl;

import org.group.welcome.dao.AdminDao;
import org.group.welcome.vo.Admin;
import org.group.welcome.dao.ConnectionDatabase;
import org.group.welcome.vo.Teacher;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDaoImpl implements AdminDao {
    @Override
    public List<Teacher> findAll() {
        Connection conn=new ConnectionDatabase().getConnnection();
        Statement st=null;
        String sql ="SELECT *FROM tb_teacher t,tb_authority a WHERE t.id=a.id";
        List<Teacher> list=new ArrayList<>();
        try {
            st=conn.createStatement();
            ResultSet rs= st.executeQuery(sql);
            while (rs.next()){
                Teacher teacher =new Teacher();
                teacher.setId(rs.getString("id"));
                teacher.setTid(rs.getString("tid"));
                teacher.setTname(rs.getString("tname"));
                teacher.setAuthority(rs.getInt("authority"));
                list.add(teacher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public String getAdminName(String id) {
        Connection conn=new ConnectionDatabase().getConnnection();
        PreparedStatement st=null;
        ResultSet rs=null;
        String sql="SELECT tname FROM tb_teacher WHERE id=?";
        String name=null;
        try {
            st=conn.prepareStatement(sql);
            st.setString(1,id);
            rs=st.executeQuery();
            if(rs.next()){
                name=rs.getString("tname");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(rs!=null){
                    rs.close();
                }
                if(st!=null){
                    st.close();
                }
                if(conn!=null){
                    conn.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return name;
    }

    @Override
    public List<Admin> findall() {
        Connection conn=new ConnectionDatabase().getConnnection();
        Statement st=null;
        List<Admin> list=new ArrayList<Admin>();

        ResultSet rs=null;
        String sql="SELECT * FROM tb_admin";
        try {
            st=conn.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                Admin admin=new Admin();
                admin.setId(rs.getString("id"));
                admin.setName(rs.getString("aname"));
                list.add(admin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(rs!=null){
                    rs.close();
                }
                if(st!=null);{
                    st.close();
                }
                if(conn!=null){
                    conn.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public boolean add(Admin admin) {
        boolean flag=false;
        Connection conn=new ConnectionDatabase().getConnnection();
        PreparedStatement st=null;
        String sql="INSERT INTO tb_admin (id,aname) VALUES(?,?)";
        try {
            st=conn.prepareStatement(sql);
            st.setString(1,admin.getId());
            st.setString(2,admin.getName());
            int i=st.executeUpdate();
            if(i==1){
                flag=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(st!=null){
                    st.close();
                }
                if(conn!=null);{
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    @Override
    public boolean deleteById(String id) {
        boolean flag=false;
        Connection conn=new ConnectionDatabase().getConnnection();
        PreparedStatement st=null;
        String sql="DELETE FROM tb_admin WHERE id=?";
        try {
            st=conn.prepareStatement(sql);
            st.setString(1,id);
            int i=st.executeUpdate();
            if(i==1){
                flag=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                if(st!=null){
                    st.close();
                }
                if(conn!=null){
                    conn.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }
}
