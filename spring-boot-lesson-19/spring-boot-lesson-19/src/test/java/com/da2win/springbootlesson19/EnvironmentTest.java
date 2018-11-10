package com.da2win.springbootlesson19;

import org.junit.Test;
import org.springframework.core.env.Environment;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.mock.env.MockEnvironment;
import org.springframework.web.context.support.StandardServletEnvironment;

import static org.junit.Assert.*;

/**
 * @Author Darwin
 * @Date 2018/11/10 9:05
 */
public class EnvironmentTest {

    @Test
    public void testSystemProperty() {
        assertNotNull(System.getProperty("os.arch"));

        //Environment environment = new StandardEnvironment();
        //Environment webEnvironment = new StandardServletEnvironment();

        MockEnvironment environment = new MockEnvironment();

        environment.setProperty("user.country", "EN");

        assertEquals("EN", environment.getProperty("user.country"));

    }

    @Test
    public void testManagementSecurityEnabled() {

        MockEnvironment environment = new MockEnvironment();

        environment.setProperty("management.security.enabled", "true");

        assertTrue(environment.getProperty("management.security.enabled", boolean.class));

    }

    @Test
    public void testManagementSecurityDisabled() {

        MockEnvironment environment = new MockEnvironment();

        environment.setProperty("management.security.enabled", "false");

        assertFalse(environment.getProperty("management.security.enabled", boolean.class));

    }
}
