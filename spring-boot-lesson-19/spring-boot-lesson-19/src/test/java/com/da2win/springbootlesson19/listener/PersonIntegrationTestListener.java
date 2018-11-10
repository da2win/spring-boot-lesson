package com.da2win.springbootlesson19.listener;

import com.da2win.springbootlesson19.domain.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.support.AbstractTestExecutionListener;

/**
 * @Author Darwin
 * @Date 2018/11/10 9:49
 */
public class PersonIntegrationTestListener extends AbstractTestExecutionListener {
    @Override
    public void prepareTestInstance(TestContext testContext) throws Exception {
        ApplicationContext applicationContext = testContext.getApplicationContext();
        Person person = applicationContext.getBean("primaryPerson", Person.class);
        System.out.println(person);
    }

    @Override
    public void beforeTestMethod(TestContext testContext) throws Exception {
        System.err.println("before : " + testContext.getTestMethod());
    }

    @Override
    public void afterTestMethod(TestContext testContext) throws Exception {
        System.err.println("after : " + testContext.getTestMethod());
    }

    @Override
    public final int getOrder() {
        return HIGHEST_PRECEDENCE;
    }
}
