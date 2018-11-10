package com.da2win.springbootlesson19.spring.boot;

import com.da2win.springbootlesson19.configuration.PersonConfiguration;
import com.da2win.springbootlesson19.domain.Person;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author Darwin
 * @Date 2018/11/10 10:54
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PersonConfiguration.class)
public class PersonSpringBootTest {

    @Autowired
    private Person person;

    @Test
    public void testPrimaryPerson() {
        Assert.assertEquals(Long.valueOf(1L), person.getId());
        Assert.assertEquals("达尔文", person.getName());
        Assert.assertEquals(Integer.valueOf(25), person.getAge());
    }

}
