package com.da2win.springbootlesson19;

import com.da2win.springbootlesson19.configuration.PersonConfiguration;
import com.da2win.springbootlesson19.domain.Person;
import com.da2win.springbootlesson19.listener.PersonIntegrationTestListener;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

/**
 * @Author Darwin
 * @Date 2018/11/10 9:30
 */
@RunWith(SpringRunner.class)
@ContextHierarchy(
        {
                @ContextConfiguration(
                        classes = PersonConfiguration.class
                )
        }
)
@TestExecutionListeners({
        PersonIntegrationTestListener.class, DependencyInjectionTestExecutionListener.class
})
@TestPropertySource(properties = {"name=da2win"})
public class PersonIntergrationTest {

    @Value("${name}")
    private String name;

    @Autowired
    private Person person;

    @BeforeClass
    public static void beforeClass() {
        System.err.println("PersonIntergrationTest.beforeClass");
    }

    @Before
    public void before() {
        System.out.println("PersonIntergrationTest.before");
    }

    @Test
    public void testPrimaryPerson() {
        Assert.assertEquals(Long.valueOf(1L), person.getId());
        Assert.assertEquals("达尔文", person.getName());
        Assert.assertEquals(Integer.valueOf(25), person.getAge());
    }

    @Test
    public void testName() {
        Assert.assertEquals("da2win", name);
    }

    @After
    public void after() {
        System.out.println("PersonIntergrationTest.after");
    }

    @AfterClass
    public static void afterClass() {
        System.err.println("PersonIntergrationTest.afterClass");
    }

}
