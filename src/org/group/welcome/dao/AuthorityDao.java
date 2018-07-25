package org.group.welcome.dao;

import org.group.welcome.vo.Authority;

public interface AuthorityDao {
    public Authority queryCheck(String id);
    public int queryById(String id);
    public boolean add(Authority authority);
    public boolean delete(String id);
    public boolean update(String id,int authority);
}
