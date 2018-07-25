package org.group.welcome.dao.impl;

import org.group.welcome.dao.AuthorityDao;
import org.group.welcome.dao.ConnectionDatabase;
import org.group.welcome.vo.Authority;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorityDaoImpl implements AuthorityDao{

    @Override
    public Authority queryCheck(String id) {

        Connection conn=new ConnectionDatabase().getConnnection();
        PreparedStatement st=null;
        Authority authority=new Authority();
        ResultSet rs=null;
        String sql="SELECT id,password,authority FROM tb_authority WHERE id=?";
        try {
            st=conn.prepareStatement(sql);
            st.setString(1,id);
            rs=st.executeQuery();
            if(rs.next()){
                authority.setAuthority(rs.getInt("authority"));
                authority.setId(rs.getString("id"));
                authority.setPassword(rs.getString("password"));
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
        return authority;
    }


    @Override
    public boolean add(Authority authority) {
        boolean flag=false;
        Connection conn=new ConnectionDatabase().getConnnection();
        PreparedStatement st=null;
        String sql="INSERT INTO tb_authority (id,authority,password) VALUE (?,?,?)";
        try {
            st=conn.prepareStatement(sql);
            st.setString(1,authority.getId());
            st.setInt(2,authority.getAuthority());
            st.setString(3,authority.getPassword());
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
                if(conn!=null){
                    conn.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    @Override
    public boolean delete(String id) {
        boolean flag=false;
        Connection conn=new ConnectionDatabase().getConnnection();
        PreparedStatement st=null;
        String sql="DELETE FROM tb_authority WHERE id=?";
        try {
            st=conn.prepareStatement(sql);
            st.setString(1,id);
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
                if(conn!=null){
                    conn.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    @Override
    public boolean update(String id,int authority) {
        boolean flag=false;
        Connection conn=new ConnectionDatabase().getConnnection();
        PreparedStatement st=null;
        String sql="UPDATE tb_authority SET authority=? WHERE id=?";


        try {
            st=conn.prepareStatement(sql);
            st.setInt(1,authority);
            st.setString(2,id);
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
                if(conn!=null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    @Override
    public int queryById(String id) {
        Connection conn=new ConnectionDatabase().getConnnection();
        PreparedStatement st=null;
        Authority authority=new Authority();
        ResultSet rs=null;
        String sql="SELECT id,password,authority FROM tb_authority WHERE id=?";
        try {
            st=conn.prepareStatement(sql);
            st.setString(1,id);
            rs=st.executeQuery();
            if(rs.next()){
                authority.setAuthority(rs.getInt("authority"));
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
        return authority.getAuthority();
    }
}
