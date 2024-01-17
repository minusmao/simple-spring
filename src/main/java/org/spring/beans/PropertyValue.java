package org.spring.beans;

/**
 * 用于封装 bean 的属性，体现到上面的配置文件就是封装 bean 标签的子标签 property 标签数据
 *
 * @author minus
 * @since 2024/1/17 21:18
 */
public class PropertyValue {

    private String name;
    private String ref;
    private String value;

    public PropertyValue() {
    }

    public PropertyValue(String name, String ref, String value) {
        this.name = name;
        this.ref = ref;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
