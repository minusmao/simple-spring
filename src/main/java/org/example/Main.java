package org.example;

import org.example.dao.UserDao;
import org.example.service.UserService;
import org.spring.context.support.ClassPathXmlApplicationContext;

/**
 * @author minus
 * @since 2024/1/17 17:19
 */
public class Main {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) context.getBean("userService");
        UserDao userDao = userService.getUserDao();

        System.out.println(userDao);
    }
}