package com.da2win.springbootlesson19;

import org.junit.Test;
import org.springframework.mock.web.MockServletContext;

import javax.servlet.ServletContext;

/**
 * @Author Darwin
 * @Date 2018/11/10 9:16
 */
public class MockServletAPITest {

    /**
     * {@link ServletContext}
     */
    @Test
    public void testMockServletContext() {
        // 不支持 servlet 3.0 的注册 api
        MockServletContext servletContext = new MockServletContext();

        servletContext.setInitParameter("abc", "def");


    }
}
