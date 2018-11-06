package com.da2win.springbootlesson17.jmx;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

/**
 * @Author Darwin
 * @Date 2018/11/6 16:24
 */
@ManagedResource(
        objectName = "com.da2win.springbootlesson17.jmx:type=SimpleBean",
        description = "这是一个简单的Bean, 被 Spring 托管"
)
@Component
public class SimpleBean {

    private Long id;

    private String name;

    private Integer age;

    @ManagedAttribute(description = "ID 属性")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManagedAttribute(description = "name 属性")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManagedAttribute(description = "age 属性")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @ManagedOperation(description = "display 操作")
    public String display() {
        return toString();
    }

    @Override
    public String toString() {
        return "SimpleBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
