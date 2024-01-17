package org.example.service;

import org.example.dao.UserDao;

/**
 * @author minus
 * @since 2024/1/17 23:41
 */
public class UserService {
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

}
