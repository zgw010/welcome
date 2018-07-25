package org.group.welcome.dao;

import org.group.welcome.vo.Admin;
import org.group.welcome.vo.Teacher;

import java.util.List;

public interface AdminDao {
    public List<Teacher> findAll();
    public String getAdminName(String id);
    public List<Admin> findall();
    public boolean add(Admin admin);
    public boolean deleteById(String id);
}
