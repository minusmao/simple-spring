package org.spring.utils;

/**
 * 字符串工具类
 * @author minus
 * @since 2024/1/17 23:34
 */
public class StringUtils {

    // userDao  ==>  setUserDao
    public static String getSetterMethodNameByFieldName(String propertyName) {
        return "set" + Character.toUpperCase(propertyName.charAt(0)) + propertyName.substring(1);
    }

}
