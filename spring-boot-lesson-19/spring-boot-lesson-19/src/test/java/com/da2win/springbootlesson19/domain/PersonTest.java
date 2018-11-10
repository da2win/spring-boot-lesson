package com.da2win.springbootlesson19.domain;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * {@link Person} Test
 * @Author Darwin
 * @Date 2018/11/10 8:59
 */
public class PersonTest {

    @Test
    public void testPerson() {
        Person person = new Person();
        person.setAge(10);
        Assert.assertEquals(Integer.valueOf(10), person.getAge());
        Assert.assertNotNull(person);
    }
}
