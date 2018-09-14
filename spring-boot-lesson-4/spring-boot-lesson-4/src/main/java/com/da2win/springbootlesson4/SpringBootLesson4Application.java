package com.da2win.springbootlesson4;

import com.da2win.springbootlesson4.servlet.MyServletRequestListener;
import com.da2win.springbootlesson4.spring.boot.MyFilter2;
import com.da2win.springbootlesson4.spring.boot.MyServlet2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.*;
import org.springframework.context.annotation.Bean;

import javax.servlet.DispatcherType;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.da2win.springbootlesson4.servlet")
public class SpringBootLesson4Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootLesson4Application.class, args);
    }

    @Bean
    public static ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean();
        registrationBean.setServlet(new MyServlet2());
        registrationBean.setName("my-servlet");
        registrationBean.addUrlMappings("/spring-boot/myservlet2");
        registrationBean.addInitParameter("myname", "myvalue");
        return registrationBean;
    }

    @Bean
    public static FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter2());
        filterRegistrationBean.addServletNames("my-servlet");
        filterRegistrationBean.setDispatcherTypes(DispatcherType.REQUEST, DispatcherType.FORWARD);
        return filterRegistrationBean;
    }

    @Bean
    public static ServletListenerRegistrationBean servletListenerRegistrationBean() {
        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean();
        servletListenerRegistrationBean.setListener(new MyServletRequestListener());
        return servletListenerRegistrationBean;
    }

}
