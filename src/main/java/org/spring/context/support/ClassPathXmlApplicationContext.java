package org.spring.context.support;

import org.spring.utils.StringUtils;
import org.spring.beans.MutablePropertyValues;
import org.spring.beans.PropertyValue;
import org.spring.beans.factory.config.BeanDefinition;
import org.spring.beans.factory.support.BeanDefinitionRegistry;
import org.spring.beans.factory.xml.XmlBeanDefinitionReader;

import java.lang.reflect.Method;

/**
 * 该类主要是加载类路径下的配置文件，并进行 bean 对象的创建，主要完成以下功能：
 * 1. 在构造方法中，创建 BeanDefinitionReader 对象。
 * 2. 在构造方法中，调用 refresh()方法，用于进行配置文件加载、创建 bean 对象并存储到容器中。
 * 3. 重写父接口中的 getBean()方法，并实现依赖注入操作。
 *
 * @author minus
 * @since 2024/1/17 23:09
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext{

    public ClassPathXmlApplicationContext(String configLocation) {
        this.configLocation = configLocation;
        //构建 XmlBeanDefinitionReader 对象
        beanDefinitionReader = new XmlBeanDefinitionReader();
        try {
            this.refresh();
        } catch (Exception e) {
        }
    }

    //根据 bean 的 id 属性值获取 bean 对象
    @Override
    public Object getBean(String name) throws Exception {

        //return singletonObjects.get(name);
        Object obj = singletonObjects.get(name);
        if(obj != null) {
            return obj;
        }

        BeanDefinitionRegistry registry = beanDefinitionReader.getRegistry();
        BeanDefinition beanDefinition = registry.getBeanDefinition(name);
        if(beanDefinition == null) {
            return null;
        }
        String className = beanDefinition.getClassName();
        Class<?> clazz = Class.forName(className);
        Object beanObj = clazz.newInstance();
        MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
        for (PropertyValue propertyValue : propertyValues) {
            String propertyName = propertyValue.getName();
            String value = propertyValue.getValue();
            String ref = propertyValue.getRef();
            if(ref != null && !"".equals(ref)) {

                Object bean = getBean(ref);
                String methodName = StringUtils.getSetterMethodNameByFieldName(propertyName);
                Method[] methods = clazz.getMethods();
                for (Method method : methods) {
                    if(method.getName().equals(methodName)) {
                        method.invoke(beanObj,bean);
                    }
                }
            }

            if(value != null && !"".equals(value)) {
                String methodName = StringUtils.getSetterMethodNameByFieldName(propertyName);
                Method method = clazz.getMethod(methodName, String.class);
                method.invoke(beanObj,value);
            }
        }
        singletonObjects.put(name,beanObj);
        return beanObj;
    }

    @Override
    public <T> T getBean(String name, Class<? extends T> clazz) throws Exception {

        Object bean = getBean(name);
        if(bean != null) {
            return clazz.cast(bean);
        }
        return null;
    }
}

