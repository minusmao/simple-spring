package org.spring.beans.factory.support;

import org.spring.beans.factory.config.BeanDefinition;

/**
 * 定义了注册表的相关操作
 *
 * @author minus
 * @since 2024/1/17 21:34
 */
public interface BeanDefinitionRegistry {
    //注册 BeanDefinition 对象到注册表中
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    //从注册表中删除指定名称的 BeanDefinition 对象
    void removeBeanDefinition(String beanName) throws Exception;

    //根据名称从注册表中获取 BeanDefinition 对象
    BeanDefinition getBeanDefinition(String beanName) throws Exception;

    boolean containsBeanDefinition(String beanName);

    int getBeanDefinitionCount();

    String[] getBeanDefinitionNames();
}
