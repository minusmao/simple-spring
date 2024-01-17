package org.spring.context;

import org.spring.beans.factory.BeanFactory;

/**
 * 该接口的所以的子实现类对 bean 对象的创建都是非延时的，
 * 所以在该接口中定义 refresh() 方法，该方法主要完成以下两个功能：
 * 1. 加载配置文件。
 * 2. 根据注册表中的 BeanDefinition 对象封装的数据进行 bean 对象的创建
 *
 * @author minus
 * @since 2024/1/17 23:02
 */
public interface ApplicationContext extends BeanFactory {

    //进行配置文件加载并进行对象创建
    void refresh() throws IllegalStateException, Exception;

}
