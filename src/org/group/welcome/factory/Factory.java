package org.group.welcome.factory;

import org.group.welcome.dao.AdminDao;
import org.group.welcome.dao.AuthorityDao;
import org.group.welcome.dao.StudentDao;
import org.group.welcome.dao.impl.AdminDaoImpl;
import org.group.welcome.dao.impl.AuthorityDaoImpl;
import org.group.welcome.dao.impl.StudentDaoImpl;

public class Factory {
    public static AdminDao getAdminDao() {
        return new AdminDaoImpl();
    }
    public static AuthorityDao getAuthorityDao() {
        return new AuthorityDaoImpl();
    }
    public static StudentDao getStudentDao() {
        return new StudentDaoImpl();
    }
}
