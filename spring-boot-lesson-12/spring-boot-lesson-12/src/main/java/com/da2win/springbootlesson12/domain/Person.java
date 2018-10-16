package com.da2win.springbootlesson12.domain;

import com.da2win.springbootlesson12.bean.validation.constraints.PersonNamePrefix;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 领域对象 Person
 */
public class Person {
    @NotNull
    @PersonNamePrefix(prefix = "segmentfault-")
    private String name;
    @Min(value = 0)
    @Max(value = 200/*, message = "人的年龄最大不能超过200"*/)
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
