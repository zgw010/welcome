package org.group.welcome.dao;

import org.group.welcome.vo.Student;

import java.sql.ResultSet;
import java.util.List;

public interface StudentDao {

    public Student findBySid(String sid);
    public List<Student> findAll();
    public Student queryById(String id);
    public List<Student> queryByName(String name);
    public List<Student> queryJoinByCollege(String id);
    public ResultSet queryJoinById(String id);
    public boolean add(Student student);
    public boolean deleteById(String id);
    public boolean update(Student student);
}
