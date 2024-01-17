package org.spring.beans.factory;

/**
 * 定义 IOC 容器的统一规范即获取 bean 对象
 *
 * @author minus
 * @since 2024/1/17 23:00
 */
public interface BeanFactory {

    //根据 bean 对象的名称获取 bean 对象
    Object getBean(String name) throws Exception;

    //根据 bean 对象的名称获取 bean 对象，并进行类型转换
    <T> T getBean(String name, Class<? extends T> clazz) throws Exception;

}
