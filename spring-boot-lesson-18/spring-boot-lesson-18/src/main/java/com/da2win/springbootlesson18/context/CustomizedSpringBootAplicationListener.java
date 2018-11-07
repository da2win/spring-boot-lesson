package com.da2win.springbootlesson18.context;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义 Spring Boot {@link ApplicationListener}
 * @Author Darwin
 * @Date 2018/11/7 11:07
 */
public class CustomizedSpringBootAplicationListener implements
        ApplicationListener<ApplicationEnvironmentPreparedEvent> {

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {

        ConfigurableEnvironment env = event.getEnvironment();

        MutablePropertySources propertySources = env.getPropertySources();

        Map<String, Object> source = new HashMap<>();

        source.put("server.port", 5678);
        source.put("spring.profiles.include", "abc");

        PropertySource propertySource = new MapPropertySource("from-application-listener", source);

        propertySources.addFirst(propertySource);

    }
}
