package org.spring.beans.factory.support;

/**
 * 用来解析配置文件并在注册表中注册 bean 的信息
 *
 * @author minus
 * @since 2024/1/17 22:04
 */
public interface BeanDefinitionReader {

    //获取注册表对象
    BeanDefinitionRegistry getRegistry();

    //加载配置文件并在注册表中进行注册
    void loadBeanDefinitions(String configLocation) throws Exception;

}
