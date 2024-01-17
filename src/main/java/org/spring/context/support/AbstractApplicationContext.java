package org.spring.context.support;

import org.spring.beans.factory.config.BeanDefinition;
import org.spring.beans.factory.support.BeanDefinitionReader;
import org.spring.beans.factory.support.BeanDefinitionRegistry;
import org.spring.context.ApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * 作为 ApplicationContext 接口的子类，所以该类也是非延时加载，所以需要在该类中定义一个 Map 集合，作为 bean 对象存储的容器。
 * 声明 BeanDefinitionReader 类型的变量，用来进行 xml 配置文件的解析，符合单一职责原则。
 * BeanDefinitionReader 类型的对象创建交由子类实现，因为只有子类明确到底创建 BeanDefinitionReader 哪个子实现类对象。
 *
 * @author minus
 * @since 2024/1/17 23:05
 */
public abstract class AbstractApplicationContext implements ApplicationContext {

    protected BeanDefinitionReader beanDefinitionReader;
    //用来存储 bean 对象的容器   key 存储的是 bean 的 id 值，value 存储的是 bean 对象
    protected Map<String, Object> singletonObjects = new HashMap<>();

    //存储配置文件的路径
    protected String configLocation;

    @Override
    public void refresh() throws IllegalStateException, Exception {

        //加载 BeanDefinition
        beanDefinitionReader.loadBeanDefinitions(configLocation);

        //初始化 bean
        finishBeanInitialization();
    }

    //bean 的初始化
    private void finishBeanInitialization() throws Exception {
        BeanDefinitionRegistry registry = beanDefinitionReader.getRegistry();
        String[] beanNames = registry.getBeanDefinitionNames();

        for (String beanName : beanNames) {
            BeanDefinition beanDefinition = registry.getBeanDefinition(beanName);
            getBean(beanName);
        }
    }

}
